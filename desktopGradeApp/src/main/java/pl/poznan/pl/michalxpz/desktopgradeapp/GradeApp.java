package pl.poznan.pl.michalxpz.desktopgradeapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GradeApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GradeApp.class.getResource("viewGrades.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 860, 600);
        stage.setTitle("Grade App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
