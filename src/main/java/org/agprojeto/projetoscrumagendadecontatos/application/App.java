package org.agprojeto.projetoscrumagendadecontatos.application;

import org.agprojeto.projetoscrumagendadecontatos.dao.ContatoDAO;
import org.agprojeto.projetoscrumagendadecontatos.dao.DAOFactory;
import org.agprojeto.projetoscrumagendadecontatos.db.exceptions.DBException;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;

import java.util.List;


public class App {
    public static void main(String[] args) {
        ContatoDAO contatoDAO = DAOFactory.criarContatoDAO();
        ContatoDTO contatoDTO1 = new ContatoDTO(null, "dsadsa1", "dsadsa11", "321321a", "323c", "dsa1@gmail.com", "fdkjjlfdsjlçkzfs1");
        ContatoDTO contatoDTO2 = new ContatoDTO(null, "dsadsa2", "dsadsa22", "321321b", "323b", "dsa2@gmail.com", "fdkjjlfdsjlçkzfs2");
        ContatoDTO contatoDTO3 = new ContatoDTO(null, "dsadsa3", "dsadsa33", "321321c", "323a", "dsa3@gmail.com", "fdkjjlfdsjlçkzfs3");

        try {
            List<ContatoDTO> lista = contatoDAO.listarTodosOsContatos();
            for (ContatoDTO contato : lista) {
                System.out.println(contato);
            }

            ContatoDTO contatoDTO = contatoDAO.buscarContatoPorId(1);
            System.out.println(contatoDTO);
        } catch (DBException e) {
            System.err.println("Erro ao inserir contato: " + e.getMessage());
        }
    }
}
