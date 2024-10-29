package org.agprojeto.projetoscrumagendadecontatos.controller;

import org.agprojeto.projetoscrumagendadecontatos.dao.ContatoDAO;
import org.agprojeto.projetoscrumagendadecontatos.dao.DAOFactory;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;

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
}
