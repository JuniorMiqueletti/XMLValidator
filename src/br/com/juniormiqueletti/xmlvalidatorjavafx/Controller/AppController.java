package br.com.juniormiqueletti.xmlvalidatorjavafx.Controller;

import br.com.juniormiqueletti.xmlvalidatorjavafx.App.Init;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import javax.swing.text.NumberFormatter;
import java.io.File;


public class AppController{

    FileChooser chooser = new FileChooser();
    File xmlFile;
    File xsdFile;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

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

    public AppController() {
    }

    @FXML
    public void chooseXmlFile(ActionEvent event){
        try {

            chooser.setTitle("Choose your XML File");
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files(*.xml)", "*.xml"));
            xmlFile = chooser.showOpenDialog(Init.mainStage);
            this.tfXmlFile.setText(xmlFile.getAbsolutePath());

        }catch (NullPointerException e){

            this.tfXmlFile.setText("");

        }catch (Exception e){

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.show();

        }
    }

    @FXML
    public void chooseXsdFile(ActionEvent event){
        try {

            chooser.setTitle("Choose your XSD File");
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XSD Files(*.xsd)", "*.xsd"));
            xsdFile = chooser.showOpenDialog(Init.mainStage);
            this.tfXmlFile.setText(xsdFile.getAbsolutePath());

        }catch (NullPointerException e){

            this.tfXmlFile.setText("");

        }catch (Exception e){

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.show();

        }

    }

    @FXML
    public void validate(ActionEvent event){


        alert.setTitle("Information");
        alert.setHeaderText("in progress..");
        alert.show();
    }

}
