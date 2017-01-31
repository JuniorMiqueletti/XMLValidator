package br.com.juniormiqueletti.xmlvalidatorjavafx.Controller;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Junior-Pc on 24/03/2016.
 * Class with validation method
 */
public class XmlValidator {

    private File xmlFile;
    private File xsdFile;

    public XmlValidator(File xmlFile, File xsdFile) {
        this.xmlFile = xmlFile;
        this.xsdFile = xsdFile;
    }

    public String validate() throws SAXException, JAXBException {

        try {
            /*TODO refactor*/
            final List<SAXException> exceptions = new LinkedList<SAXException>();

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
            String erros;
            erros = "Validation..\n\n";

            for (int i = 0; i < exceptions.size();i++){
                erros = String.format("%s--\n%s\n", erros, exceptions.get(1+i).getMessage());
                erros = String.format("%s  %s\n", erros, exceptions.get(i).getMessage());
                i++;
            }

            if (exceptions.isEmpty()){
                erros = String.format("%s%s",erros,"Ok !");
            }

            return erros;

        } catch (Exception e){
            return e.getMessage();
        }
    }
}
