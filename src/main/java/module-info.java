module org.agprojeto.projetoscrumagendadecontatos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.agprojeto.projetoscrumagendadecontatos to javafx.fxml;
    exports org.agprojeto.projetoscrumagendadecontatos.view.controller;
    opens org.agprojeto.projetoscrumagendadecontatos.view.controller to javafx.fxml;
    exports org.agprojeto.projetoscrumagendadecontatos.view;
    opens org.agprojeto.projetoscrumagendadecontatos.view to javafx.fxml;
}