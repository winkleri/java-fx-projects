package org.example.pm2vier;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Client extends Application {

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("Main.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
            stage.setTitle("GradeManagerFX");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }
