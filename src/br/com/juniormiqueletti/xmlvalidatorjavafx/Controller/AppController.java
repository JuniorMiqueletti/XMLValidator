package br.com.juniormiqueletti.xmlvalidatorjavafx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppController {

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
    public void validate(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("in progress..");
        alert.show();
    }
    
}
