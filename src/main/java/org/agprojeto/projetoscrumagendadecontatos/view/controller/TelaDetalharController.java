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

public class TelaDetalharController implements Initializable {

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
    private Label lblErroNome;
    @FXML
    private Label lblErroNumero;
    @FXML
    private Label lblErroEmail;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnVoltar;

    private ContatoDTO contatoDTO;
    private final ContatoValidator contatoValidator = new ContatoValidator();
    private final ContatoController contatoController = new ContatoController();

    public void setContato(ContatoDTO contato) {
        this.contatoDTO = contato;
        txtNome.setText(contato.getNome());
        txtSobrenome.setText(contato.getSobrenome());
        txtTelefone.setText(contato.getNumero());
        txtTelefone2.setText(contato.getNumero2());
        txtEmail.setText(contato.getEmail());
        txtDescricao.setText(contato.getDescricao());
    }

    @FXML
    private void onBtnEditar() {
        lblErroNome.setText("");
        lblErroNumero.setText("");
        lblErroEmail.setText("");

        txtNome.getStyleClass().remove("error");
        txtTelefone.getStyleClass().remove("error");
        txtEmail.getStyleClass().remove("error");

        contatoDTO.setNome(txtNome.getText());
        contatoDTO.setSobrenome(txtSobrenome.getText());
        contatoDTO.setNumero(txtTelefone.getText());
        contatoDTO.setNumero2(txtTelefone2.getText());
        contatoDTO.setEmail(txtEmail.getText());
        contatoDTO.setDescricao(txtDescricao.getText());

        try {
            contatoValidator.validarContato(contatoDTO);
            contatoController.atualizarContato(contatoDTO);
            Alertas.mostrarAlerta("Sucesso", "Contato editado com sucesso!", Alert.AlertType.INFORMATION);

        } catch (ValidacaoException e) {
            if (e.getMessage().toLowerCase().contains("nome")) {
                txtNome.getStyleClass().add("error");
                lblErroNome.setText(e.getMessage());
            } else if (e.getMessage().toLowerCase().contains("número")) {
                txtTelefone.getStyleClass().add("error");
                lblErroNumero.setText(e.getMessage());
            } else if (e.getMessage().toLowerCase().contains("email")) {
                txtEmail.getStyleClass().add("error");
                lblErroEmail.setText(e.getMessage());
            }
        } catch (DBException e) {
            Alertas.mostrarAlerta("Erro", "Erro ao editar contato. Verifique os campos corretamente.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void onBtnVoltarDetalhar() {
        Viewer.loadView("/org/agprojeto/projetoscrumagendadecontatos/view/TelaContatos.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Restricoes.setTextFieldMaxLength(txtTelefone, 15);
        Restricoes.setTextFieldMaxLength(txtTelefone2, 15);
        Restricoes.setTextFieldInteger(txtTelefone);
        Restricoes.setTextFieldInteger(txtTelefone2);

        if (contatoDTO != null) {
            setContato(contatoDTO);
        }
    }
}
