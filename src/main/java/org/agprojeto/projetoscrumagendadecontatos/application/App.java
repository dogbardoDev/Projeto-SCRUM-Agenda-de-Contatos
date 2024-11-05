package org.agprojeto.projetoscrumagendadecontatos.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/org/agprojeto/projetoscrumagendadecontatos/view/TelaContatos.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 640);
        stage.setResizable(false);
        stage.setTitle("Agenda de Contatos");
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/org/agprojeto/projetoscrumagendadecontatos/view/error/styles/error.css").toExternalForm());
        stage.show();
    }
    public static Stage getMainStage() {
        return stage;
    }
    public static void main(String[] args) {
        launch();
    }

}