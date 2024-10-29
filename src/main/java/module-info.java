module org.agprojeto.projetoscrumagendadecontatos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.agprojeto.projetoscrumagendadecontatos to javafx.fxml;
    exports org.agprojeto.projetoscrumagendadecontatos;
}