package org.agprojeto.projetoscrumagendadecontatos.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class app extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(app.class.getResource("TelaNovoContato.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 640);
        stage.setResizable(false);
        stage.setTitle("Agenda de Contatos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}