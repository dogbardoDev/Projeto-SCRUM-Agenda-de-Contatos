package org.agprojeto.projetoscrumagendadecontatos.dao;

import org.agprojeto.projetoscrumagendadecontatos.dao.impl.ContatoDAOImpl;
import org.agprojeto.projetoscrumagendadecontatos.db.DB;

public class DAOFactory {

    public static ContatoDAO criarClienteDAO() {
        return new ContatoDAOImpl(DB.getConexao());
    }
}
