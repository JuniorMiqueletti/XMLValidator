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
        primaryStage.setTitle("XMLValidator | JuniorMiqueletti");
        primaryStage.setScene(new Scene(root));
        mainStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
