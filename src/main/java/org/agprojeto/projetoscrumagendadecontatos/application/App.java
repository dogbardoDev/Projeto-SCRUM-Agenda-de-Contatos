package org.agprojeto.projetoscrumagendadecontatos.application;

import org.agprojeto.projetoscrumagendadecontatos.dao.ContatoDAO;
import org.agprojeto.projetoscrumagendadecontatos.dao.impl.ContatoDAOImpl;
import org.agprojeto.projetoscrumagendadecontatos.db.DB;
import org.agprojeto.projetoscrumagendadecontatos.db.exceptions.DBException;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;


public class App {
    public static void main(String[] args) {
        ContatoDAO contatoDAO = new ContatoDAOImpl(DB.getConexao());
        ContatoDTO contatoDTO = new ContatoDTO(null, "Nome", "Sobrenome", "123456789", "987654321", "email@example.com", "Descrição");

        try {
            contatoDAO.inserirContato(contatoDTO);
            System.out.println("Contato inserido com sucesso!");
        } catch (DBException e) {
            System.err.println("Erro ao inserir contato: " + e.getMessage());
        }
    }
}
