package org.agprojeto.projetoscrumagendadecontatos.view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.util.Viewer;

public class TelaDetalharController {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSobrenome;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtTelefone2;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextArea txtDescricao;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnVoltar;

    public void setContato(ContatoDTO contato) {
        txtNome.setText(contato.getNome());
        txtSobrenome.setText(contato.getSobrenome());
        txtTelefone.setText(contato.getNumero());
        txtTelefone2.setText(contato.getNumero2());
        txtEmail.setText(contato.getEmail());
        txtDescricao.setText(contato.getDescricao());
    }

    @FXML
    private void onBtnVoltarDetalhar() {
        Viewer.loadView("/org/agprojeto/projetoscrumagendadecontatos/view/TelaContatos.fxml");
    }
}

