package org.agprojeto.projetoscrumagendadecontatos.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.util.Alertas;
import org.agprojeto.projetoscrumagendadecontatos.view.App;

import java.io.IOException;

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

    public void onBtnVoltar(){
        loadView("/org/agprojeto/projetoscrumagendadecontatos/view/TelaContatos.fxml");
    }

    private void loadView(String caminho) {
        try {
            Stage mainStage = App.getMainStage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
            Parent novaTela = loader.load();
            mainStage.getScene().setRoot(novaTela);

        } catch (IOException e) {
            Alertas.mostrarAlerta("Erro", "Não foi possivel carregar a tela.", Alert.AlertType.ERROR);
        }
    }
}

