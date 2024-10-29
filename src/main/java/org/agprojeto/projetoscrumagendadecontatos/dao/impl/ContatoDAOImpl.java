package org.agprojeto.projetoscrumagendadecontatos.dao.impl;

import org.agprojeto.projetoscrumagendadecontatos.dao.ContatoDAO;
import org.agprojeto.projetoscrumagendadecontatos.db.exceptions.DBException;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.mapper.ContatoMapper;
import org.agprojeto.projetoscrumagendadecontatos.model.entities.Contato;

import java.sql.*;

public class ContatoDAOImpl implements ContatoDAO {


    private final Connection conexao;

    public ContatoDAOImpl(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserirContato(ContatoDTO contatoDTO) {
        Contato contato = ContatoMapper.toEntity(contatoDTO);

        try (PreparedStatement stmt = conexao.prepareStatement(
                "INSERT INTO contatos (nome, sobrenome, numero, numero2, email, descricao) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getSobrenome());
            stmt.setString(3, contato.getNumero());
            stmt.setString(4, contato.getNumero2());
            stmt.setString(5, contato.getEmail());
            stmt.setString(6, contato.getDescricao());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        contato.setId(id);
                    }
                }
            } else {
                throw new DBException("Erro ao inserir linha");
            }
        } catch (SQLException e) {
            throw new DBException("Erro ao inserir contato: " + e.getMessage() + " " + e);
        }
    }

    @Override
    public void atualizarContato(ContatoDTO cliente) {

    }

    @Override
    public void excluirContato(Integer id) {

    }
}
