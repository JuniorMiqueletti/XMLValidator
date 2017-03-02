package br.com.juniormiqueletti.xmlvalidatorjavafx.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Init extends Application {

    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/App.fxml"));
        primaryStage.setTitle("XMLValidatorService | JuniorMiqueletti");
        primaryStage.setScene(new Scene(root, 1000, 600));
        mainStage = primaryStage;
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
