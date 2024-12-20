package org.agprojeto.projetoscrumagendadecontatos.controller;

import org.agprojeto.projetoscrumagendadecontatos.dao.ContatoDAO;
import org.agprojeto.projetoscrumagendadecontatos.dao.DAOFactory;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;

import java.util.List;

public class ContatoController {

    private final ContatoDAO contatoDAO = DAOFactory.criarContatoDAO();

    public void inserirContato(ContatoDTO contatoDTO) {
        contatoDAO.inserirContato(contatoDTO);
    }

    public void atualizarContato(ContatoDTO contatoDTO) {
        contatoDAO.atualizarContato(contatoDTO);
    }

    public void excluirContato(Integer id) {
        contatoDAO.excluirContato(id);
    }

    public List<ContatoDTO> buscarContatosParaTabelaContatos() {
        return contatoDAO.listarTodosOsContatos();
    }

    public ContatoDTO buscarContatoPorNumero(String numero) {
        return contatoDAO.buscarContatoPorNumero(numero);
    }
}
