package br.com.juniormiqueletti.xmlvalidatorjavafx.controller;

import br.com.juniormiqueletti.xmlvalidatorjavafx.app.Init;
import br.com.juniormiqueletti.xmlvalidatorjavafx.service.XMLValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Scanner;


public class XMLValidatorController {

    private FileChooser chooser = new FileChooser();
    private File xmlFile;
    private File xsdFile;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private XMLValidatorService XMLValidatorService;

    @FXML
    private Button btnXmlFile;

    @FXML
    private Button btnXsdFile;

    @FXML
    private TextField tfXmlFile;

    @FXML
    private TextField tfXsdFile;

    @FXML
    private Button btnValidate;

    @FXML
    private TextArea taXmlFile;

    @FXML
    private TextArea taXsdFile;

    public XMLValidatorController() {
    }

    @FXML
    public void chooseXmlFile(ActionEvent event) {
        try {

            chooser.setTitle("Choose your XML File");
            chooser.getExtensionFilters().clear();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files(*.xml)", "*.xml"));
            xmlFile = chooser.showOpenDialog(Init.mainStage);
            this.tfXmlFile.setText(xmlFile.getAbsolutePath());

             /*TODO Refactor*/
            String textArea = null;
            Scanner scan = new Scanner(xmlFile);
            while (scan.hasNext()){
                textArea+=scan.next()+"\n";
            }
            this.taXmlFile.setText(textArea);

        } catch (NullPointerException e) {

            this.tfXmlFile.setText("");

        } catch (Exception e) {

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.show();

        }
    }

    @FXML
    public void chooseXsdFile(ActionEvent event) {
        try {

            chooser.setTitle("Choose your XSD File");
            chooser.getExtensionFilters().clear();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XSD Files(*.xsd)", "*.xsd"));
            xsdFile = chooser.showOpenDialog(Init.mainStage);
            this.tfXsdFile.setText(xsdFile.getAbsolutePath());

            /*TODO Refactor*/
            String textArea = null;
            Scanner scan = new Scanner(xsdFile);
            while (scan.hasNext()){
                textArea+=scan.next()+"\n";
            }
            this.taXsdFile.setText(textArea);

        } catch (NullPointerException e) {

            this.tfXsdFile.setText("");

        } catch (Exception e) {

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.show();

        }

    }

    @FXML
    public void validate(ActionEvent event) {

        XMLValidatorService = new XMLValidatorService(xmlFile,xsdFile);
        String finalMessage = null;

        try {

            finalMessage= XMLValidatorService.validate();

        }catch (Exception e){
             alert.setHeaderText(e.getMessage());
        }

        alert.setTitle("Information");
        alert.setHeaderText(finalMessage);
        alert.show();
    }

}
