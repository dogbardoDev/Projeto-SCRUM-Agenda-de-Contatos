package org.agprojeto.projetoscrumagendadecontatos.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("TelaContatos.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 640);
        stage.setResizable(false);
        stage.setTitle("Agenda de Contatos");
        stage.setScene(scene);
        stage.show();
    }
    public static Stage getMainStage() {
        return stage;
    }
    public static void main(String[] args) {
        launch();
    }

}