module org.agprojeto.projetoscrumagendadecontatos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.agprojeto.projetoscrumagendadecontatos to javafx.fxml;
    exports org.agprojeto.projetoscrumagendadecontatos.view.controller;
    exports org.agprojeto.projetoscrumagendadecontatos;
    opens org.agprojeto.projetoscrumagendadecontatos.view.controller to javafx.fxml;
    exports org.agprojeto.projetoscrumagendadecontatos.view;
    opens org.agprojeto.projetoscrumagendadecontatos.view to javafx.fxml;
}