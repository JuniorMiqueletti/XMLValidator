package br.com.juniormiqueletti.xmlvalidatorjavafx.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class XMLValidatorServiceTest {

    private XMLValidatorService service = new XMLValidatorService();
    
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void shouldReturnFalseOnValidateWrongXsdFileTest() throws IOException {
        File xsdFile = folder.newFile("fileValidation.txt");
        Assert.assertFalse(service.isValidXSDFile(xsdFile));
    }

    @Test
    public void shouldReturnFalseOnValidateFileXSDWithoutExtensionTest() throws IOException {
        File xsdFile = folder.newFile("fileValidation");
        Assert.assertFalse(service.isValidXSDFile(xsdFile));
    }

    @Test
    public void shouldReturnTrueOnValidateXsdFileTest() throws IOException {
        File xsdFile = folder.newFile("fileValidation.xsd");
        Assert.assertTrue(service.isValidXSDFile(xsdFile));
    }

    @Test
    public void shouldReturnFalseOnValidateWrongXmlFileTest() throws IOException {
        File xsdFile = folder.newFile("fileValidation.aaa");
        Assert.assertFalse(service.isValidXMLFile(xsdFile));
    }

    @Test
    public void shouldReturnTrueOnValidateXmlFileTest() throws IOException {
        File xsdFile = folder.newFile("fileValidation.xml");
        Assert.assertTrue(service.isValidXMLFile(xsdFile));
    }

    @Test
    public void shouldReturnFalseOnValidateFileXmlWithoutExtensionTest() throws IOException {
        File xsdFile = folder.newFile("fileValidation");
        Assert.assertFalse(service.isValidXMLFile(xsdFile));
    }

}
