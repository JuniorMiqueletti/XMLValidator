package br.com.juniormiqueletti.xmlvalidatorjavafx.Controller;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by Junior-Pc on 24/03/2016.
 */
public class XmlValidator {

    private File xmlFile;
    private File xsdFile;
    private String parsedXmlFile;
    private String parsedXsdFile;
    JAXBContext jaxbContext;
    Unmarshaller unmarshaller;

    public XmlValidator(File xmlFile, File xsdFile) {
        this.xmlFile = xmlFile;
        this.xsdFile = xsdFile;
    }

    public String getParsedXmlFile() {
        return parsedXmlFile;
    }

    public String getParsedXsdFile() {
        return parsedXsdFile;
    }

    public String validate() throws SAXException, JAXBException {

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            return "Ok.";
        } catch (IOException e){
            return e.getMessage();
        }catch(SAXException e1){
            return e1.getMessage();
        }
    }
}
