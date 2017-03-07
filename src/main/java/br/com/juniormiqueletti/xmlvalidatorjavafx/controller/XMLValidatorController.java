package br.com.juniormiqueletti.xmlvalidatorjavafx.controller;

import br.com.juniormiqueletti.xmlvalidatorjavafx.service.XMLValidatorService;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class XMLValidatorController {

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private XMLValidatorService service = new XMLValidatorService();
    private String finalMessage = new String();;

    @FXML
    private JFXTextField jtfXsdFilePath = new JFXTextField();

    @FXML
    private JFXTextField jtfXmlFilePath = new JFXTextField();

    public XMLValidatorController() {}

    @FXML
    private void handlerDragOver(DragEvent event){
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleDropXsd(DragEvent event){
        List<File> files = event.getDragboard().getFiles();
        if (isOnlyOneFile(files))
            jtfXsdFilePath.setText(files.get(0).getAbsolutePath());
    }

    @FXML
    private void handleDropXml(DragEvent event){
        List<File> files = event.getDragboard().getFiles();
        if (isOnlyOneFile(files))
            jtfXmlFilePath.setText(files.get(0).getAbsolutePath());
    }

    private boolean isOnlyOneFile(List<File> files) {
        if (files.size() > 1){
            alert.setContentText("Please select only one file!");
            alert.show();
            return false;
        };

        return true;
    }

    @FXML
    public void validate(ActionEvent event) {

        List<String> returnValidationMessages = new ArrayList<>();
        finalMessage = null;

        try {

            service.setXmlFile(jtfXmlFilePath.getText());
            service.setXsdFile(jtfXsdFilePath.getText());

            returnValidationMessages = service.validate();

        }catch (Exception e){
            returnValidationMessages.add(e.getMessage());
        }

        alert.setTitle("Information");

        returnValidationMessages.forEach((v) -> {
            finalMessage =  finalMessage == null ? String.format("\n%s",v) : finalMessage + String.format("\n%s",v);
        });

        alert.setContentText(finalMessage);
        alert.show();
    }
}
