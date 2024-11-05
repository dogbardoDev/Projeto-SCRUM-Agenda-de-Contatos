module org.agprojeto.projetoscrumagendadecontatos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires modelmapper;

    exports org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.exceptions;
    exports org.agprojeto.projetoscrumagendadecontatos.dto;
    exports org.agprojeto.projetoscrumagendadecontatos.model.entities;
    exports org.agprojeto.projetoscrumagendadecontatos.view.controller;
    opens org.agprojeto.projetoscrumagendadecontatos.view.controller to javafx.fxml;
    opens org.agprojeto.projetoscrumagendadecontatos.view to javafx.fxml;

}