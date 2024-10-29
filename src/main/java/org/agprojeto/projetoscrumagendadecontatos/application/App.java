package org.agprojeto.projetoscrumagendadecontatos.application;

import org.agprojeto.projetoscrumagendadecontatos.dao.ContatoDAO;
import org.agprojeto.projetoscrumagendadecontatos.dao.DAOFactory;
import org.agprojeto.projetoscrumagendadecontatos.db.exceptions.DBException;


public class App {
    public static void main(String[] args) {
        ContatoDAO contatoDAO = DAOFactory.criarContatoDAO();

        try {
            contatoDAO.excluirContato(6);
            System.out.println("Contato excluido");
        } catch (DBException e) {
            System.err.println("Erro ao inserir contato: " + e.getMessage());
        }
    }
}
