package org.agprojeto.projetoscrumagendadecontatos.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaNovoContatoController implements Initializable {

    @FXML
    private TextField txtNomeContato;
    @FXML
    private TextField txtSobrenomeContato;
    @FXML
    private TextField txtNumero1Contato;
    @FXML
    private TextField txtNumero2Contato;
    @FXML
    private TextField txtEmailContato;
    @FXML
    private TextArea txtDescricaoContato;
    @FXML
    private Button btnSalvarContato;
    @FXML
    private Button btnVoltarContato;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
