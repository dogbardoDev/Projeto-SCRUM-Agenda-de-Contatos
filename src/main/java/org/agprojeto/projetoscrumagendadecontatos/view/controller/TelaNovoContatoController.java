package org.agprojeto.projetoscrumagendadecontatos.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.agprojeto.projetoscrumagendadecontatos.controller.ContatoController;
import org.agprojeto.projetoscrumagendadecontatos.dao.ContatoDAO;
import org.agprojeto.projetoscrumagendadecontatos.dao.DAOFactory;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.mapper.ContatoMapper;
import org.agprojeto.projetoscrumagendadecontatos.model.entities.Contato;

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

    private final ContatoController contatoController = new ContatoController();

    @FXML
    private void salvarContato() {
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

        contatoController.inserirContato(contato);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
