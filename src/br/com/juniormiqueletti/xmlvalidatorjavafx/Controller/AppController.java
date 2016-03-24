package br.com.juniormiqueletti.xmlvalidatorjavafx.Controller;

import br.com.juniormiqueletti.xmlvalidatorjavafx.App.Init;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


public class AppController{

    FileChooser chooser = new FileChooser();

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

    @FXML
    public void chooseXmlFile(ActionEvent event){
        chooser.setTitle("Choose your XML File");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files(*.xml)", "*.xml"));
        chooser.showOpenDialog(Init.mainStage);
    }

    @FXML
    public void chooseXsdFile(ActionEvent event){
        chooser.setTitle("Choose your XSD File");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XSD Files(*.xsd)", "*.xsd"));
        chooser.showOpenDialog(Init.mainStage);
    }

    @FXML
    public void validate(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("in progress..");
        alert.show();
    }

}
