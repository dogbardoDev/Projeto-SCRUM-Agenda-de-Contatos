package org.agprojeto.projetoscrumagendadecontatos.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.agprojeto.projetoscrumagendadecontatos.controller.ContatoController;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.view.App;
import org.agprojeto.projetoscrumagendadecontatos.view.observer.ContatoObserver;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaContatosController implements Initializable, ContatoObserver {
    private ContatoController controller;
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
        BtnExcluir.setOnAction(event -> excluirContato());
        BtnDetalhar.setOnAction(event -> detalharContato());
        BtnNovo.setOnAction(event -> novoContato());

        colunaIcon.setCellValueFactory(new PropertyValueFactory<>("icon"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        atualizarTabelaContatos();
    }

    private void loadView(String caminho) {
        try {
            Stage mainStage = App.getMainStage();

            // Carrega o novo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
            Parent novaTela = loader.load();

            // Define o novo conteúdo da tela principal
            mainStage.getScene().setRoot(novaTela);

        } catch (IOException e) {
            mostrarAlerta("Erro");
        }
    }

    public void atualizarTabelaContatos() {
        List<ContatoDTO> listaContatos = controller.buscarContatosParaTabelaContatos();
        contatos = FXCollections.observableList(listaContatos);
        tableViewContato.setItems(contatos);
    }
    private void excluirContato() {
        // Lógica para excluir o contato selecionado
        // Exemplo:
        // Contato contatoSelecionado = TabelaContatos.getSelectionModel().getSelectedItem();
        // if (contatoSelecionado != null) {
        //     // Remover contato da lista e atualizar a tabela
        // } else {
        //     mostrarAlerta("Selecione um contato para excluir.");
        // }
        mostrarAlerta("Funcionalidade de excluir contato ainda não implementada.");
    }

    private void detalharContato() {
        ContatoDTO contatoSelecionado = tableViewContato.getSelectionModel().getSelectedItem();
        // if (contatoSelecionado != null) {
        //     // Abrir uma nova tela com os detalhes do contato
        // } else {
        //     mostrarAlerta("Selecione um contato para ver os detalhes.");
        // }
        mostrarAlerta("Funcionalidade de detalhar contato ainda não implementada.");
    }

    private void novoContato() {
       loadView("/org/agprojeto/projetoscrumagendadecontatos/view/TelaNovoContato.fxml");
    }

    private void mostrarAlerta(String mensagem) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Informação");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    @Override
    public void atualizarContato() {
        atualizarTabelaContatos();
    }
}