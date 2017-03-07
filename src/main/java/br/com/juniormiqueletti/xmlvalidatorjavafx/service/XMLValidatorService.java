package br.com.juniormiqueletti.xmlvalidatorjavafx.service;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Junior-Pc on 24/03/2016.
 * Class with validation method
 */
public class XMLValidatorService {

    private File xmlFile;
    private File xsdFile;

    public XMLValidatorService(File xmlFile, File xsdFile) {
        this.xmlFile = xmlFile;
        this.xsdFile = xsdFile;
    }

    public XMLValidatorService() {

    }

    public List<String> validate() throws Exception {

        List<String> returnMessage = new ArrayList<>();

        if (!isValidXMLFile(this.xmlFile))
            throw new Exception("This isn't a valid XML File!");

        if (!isValidXSDFile(this.xsdFile))
            throw new Exception("This isn't a valid XSD File!");

        try {
            /*TODO refactor*/
            final List<SAXException> exceptions = new LinkedList<>();

            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = factory.newSchema(xsdFile);
            final Validator validator = schema.newValidator();

            validator.setErrorHandler(new ErrorHandler() {

                @Override
                public void warning(SAXParseException exception) throws SAXException {}

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    exceptions.add(exception);
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {}
            });

            validator.validate(new StreamSource(xmlFile));

            returnMessage.add("Validation.");
            returnMessage.add("");

            if (exceptions.isEmpty()){

                returnMessage.add("File Okk!!");

            }else{

                exceptions.forEach((e)->{
                           returnMessage.add(e.getMessage().toString());
                        }
                );

            }

            return returnMessage;

        } catch (Exception e){
            return Arrays.asList(e.getMessage());
        }
    }

    public boolean isValidXSDFile(File xsdFile) {
        return isValidFile(xsdFile, ".XSD");
    }

    public boolean isValidXMLFile(File xsdFile) {

        return isValidFile(xsdFile, ".XML");
    }

    private boolean isValidFile(File xsdFile, String suffix) {
        if (xsdFile == null || !xsdFile.exists())
            return false;

        if (!xsdFile.getAbsolutePath().toUpperCase().endsWith(suffix))
            return false;

        return true;
    }

    public void setXmlFile(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    public void setXsdFile(File xsdFile) {
        this.xsdFile = xsdFile;
    }

    public void setXmlFile(String text) { this.xmlFile = new File(text); }

    public void setXsdFile(String text) { this.xsdFile = new File(text); }
}
