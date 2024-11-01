package org.agprojeto.projetoscrumagendadecontatos.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.agprojeto.projetoscrumagendadecontatos.controller.ContatoController;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.util.Restricoes;
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
    private void salvarContato() {
        lblErroNome.setText("");
        lblErroNumero.setText("");
        lblErroEmail.setText("");

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

        } catch (ValidacaoException e) {
            if (e.getMessage().contains("nome")) {
                lblErroNome.setText(e.getMessage());
            } else if (e.getMessage().contains("número")) {
                lblErroNumero.setText(e.getMessage());
            } else if (e.getMessage().contains("email")) {
                lblErroEmail.setText(e.getMessage());
            }
        }
    }

    public void validacaoContato(ContatoDTO contatoDTO) throws ValidacaoException {
        txtNomeContato.setText("");
        txtNumero1Contato.setText("");
        txtEmailContato.setText("");
        contatoValidator.validarContato(contatoDTO);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Restricoes.setTextFieldMaxLength(txtNumero1Contato, 9);
    }

}
