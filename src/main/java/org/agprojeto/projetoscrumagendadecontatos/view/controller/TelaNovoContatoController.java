package org.agprojeto.projetoscrumagendadecontatos.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.agprojeto.projetoscrumagendadecontatos.controller.ContatoController;
import org.agprojeto.projetoscrumagendadecontatos.db.exceptions.DBException;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.util.Alertas;
import org.agprojeto.projetoscrumagendadecontatos.util.Restricoes;
import org.agprojeto.projetoscrumagendadecontatos.util.Viewer;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.exceptions.ValidacaoException;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.validationcontato.ContatoValidator;

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
    @FXML
    private Label lblErroNome;
    @FXML
    private Label lblErroNumero;
    @FXML
    private Label lblErroEmail;

    private final ContatoController contatoController = new ContatoController();
    private final ContatoValidator contatoValidator = new ContatoValidator();

    @FXML
    private void onBtnSalvarContato() {
        lblErroNome.setText("");
        lblErroNumero.setText("");
        lblErroEmail.setText("");

        txtNomeContato.getStyleClass().remove("error");
        txtNumero1Contato.getStyleClass().remove("error");
        txtEmailContato.getStyleClass().remove("error");

        String nomeContato = txtNomeContato.getText();
        String sobrenomeContato = txtSobrenomeContato.getText();
        String numero1Contato = txtNumero1Contato.getText();
        String numero2Contato = txtNumero2Contato.getText();
        String emailContato = txtEmailContato.getText();
        String descricaoContato = txtDescricaoContato.getText();

        ContatoDTO contato = new ContatoDTO(
                null,
                nomeContato,
                sobrenomeContato,
                numero1Contato,
                numero2Contato,
                emailContato,
                descricaoContato
        );

        try {
            contatoValidator.validarContato(contato);
            contatoController.inserirContato(contato);
            Alertas.mostrarAlerta("Sucesso", "Contato salvo com sucesso!", Alert.AlertType.INFORMATION);

        } catch (ValidacaoException e) {
            if (e.getMessage().toLowerCase().contains("nome")) {
                lblErroNome.setText(e.getMessage());
                txtNomeContato.getStyleClass().add("error");
            } else if (e.getMessage().toLowerCase().contains("número")) {
                lblErroNumero.setText(e.getMessage());
                txtNumero1Contato.getStyleClass().add("error");
            } else if (e.getMessage().toLowerCase().contains("email")) {
                lblErroEmail.setText(e.getMessage());
                txtEmailContato.getStyleClass().add("error");
            }
        } catch (DBException e) {
            Alertas.mostrarAlerta("Erro", "Já há um contato com esse número. Edite-o ou cadastre outro.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void onBtnVoltarContato() {
        Viewer.loadView("/org/agprojeto/projetoscrumagendadecontatos/view/TelaContatos.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Restricoes.setTextFieldMaxLength(txtNumero1Contato, 15);
        Restricoes.setTextFieldMaxLength(txtNumero2Contato, 15);
        Restricoes.setTextFieldInteger(txtNumero1Contato);
        Restricoes.setTextFieldInteger(txtNumero2Contato);
    }
}
