package org.agprojeto.projetoscrumagendadecontatos.view.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.agprojeto.projetoscrumagendadecontatos.controller.ContatoController;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.util.Alertas;
import org.agprojeto.projetoscrumagendadecontatos.view.App;
import org.agprojeto.projetoscrumagendadecontatos.view.observer.ContatoObserver;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TelaContatosController implements Initializable, ContatoObserver {
    private ContatoController controller;
    public static ContatoDTO contatoSelecionado;
    @FXML
    private TableView<ContatoDTO> tableViewContato;
    @FXML
    private TableColumn<ContatoDTO, ImageView> colunaIcon;
    @FXML
    private TableColumn<ContatoDTO, String> colunaNome;
    @FXML
    private Button BtnExcluir;
    @FXML
    private Button BtnDetalhar;
    @FXML
    private Button BtnNovo;
    @FXML
    private ObservableList<ContatoDTO> contatos;


    public void initialize(URL url, ResourceBundle rb) {
        controller = new ContatoController();
        colunaIcon.setCellValueFactory(new PropertyValueFactory<>("icone"));
        colunaNome.setCellValueFactory(cellData -> {
            ContatoDTO contato = cellData.getValue();
            String nomeCompleto = contato.getNome() + " " + contato.getSobrenome();
            return new SimpleStringProperty(nomeCompleto);
        });
        atualizarTabelaContatos();

    }

    private void loadView(String caminho) {
        try {
            Stage mainStage = App.getMainStage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
            Parent novaTela = loader.load();

            mainStage.getScene().setRoot(novaTela);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadViewDetalhamento(String caminho) {
        try {
            Stage mainStage = App.getMainStage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
            Parent novaTela = loader.load();
            TelaDetalharController detalhamentoController = loader.getController();
            detalhamentoController.setContato(contatoSelecionado);
            mainStage.getScene().setRoot(novaTela);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizarTabelaContatos() {
        List<ContatoDTO> listaContatos = controller.buscarContatosParaTabelaContatos();
        contatos = FXCollections.observableList(listaContatos);
        for (ContatoDTO contato : contatos) {
            ImageView iconeContato = new ImageView(new Image(this.getClass().getResourceAsStream("/org/agprojeto/projetoscrumagendadecontatos/icones/icons8-male-user-32.png")));
            contato.setIcone(iconeContato);
        }
        tableViewContato.setItems(contatos);

    }

    public void onBtnExcluir() {
        contatoSelecionado = tableViewContato.getSelectionModel().getSelectedItem();
        if (contatoSelecionado != null) {
            Optional<ButtonType> escolha = Alertas.showConfirmation("Confirmação", "Tem certeza de que deseja excluir o contato " + contatoSelecionado.getNome() + " " + contatoSelecionado.getSobrenome() + "?");
            if (escolha.get() == ButtonType.OK) {
                controller.excluirContato(contatoSelecionado.getId());
                atualizarTabelaContatos();
            }
        } else {
            Alertas.mostrarAlerta("Erro", "Selecione um contato para excluir!", AlertType.ERROR);
        }
    }

    public void onBtnDetalhar() {
        contatoSelecionado = tableViewContato.getSelectionModel().getSelectedItem();
        if (contatoSelecionado != null) {
            loadViewDetalhamento("/org/agprojeto/projetoscrumagendadecontatos/view/TelaDetalhar.fxml");
        } else {
            Alertas.mostrarAlerta("Erro", "Selecione um contato para Detalhar!", AlertType.ERROR);
        }
    }

    public void onBtnNovo() {
        loadView("/org/agprojeto/projetoscrumagendadecontatos/view/TelaNovoContato.fxml");
    }

    @Override
    public void atualizarContato() {
        atualizarTabelaContatos();
    }

    public ContatoDTO getContatoSelecionado() {
        return contatoSelecionado;
    }
}