package org.agprojeto.projetoscrumagendadecontatos.dao.impl;

import org.agprojeto.projetoscrumagendadecontatos.dao.ContatoDAO;
import org.agprojeto.projetoscrumagendadecontatos.db.exceptions.DBException;
import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.mapper.ContatoMapper;
import org.agprojeto.projetoscrumagendadecontatos.model.entities.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAOImpl implements ContatoDAO {

    private static final String SQL_VERIFICAR_NUMERO = "SELECT 1 FROM contatos WHERE numero = ?";
    private final Connection conexao;

    public ContatoDAOImpl(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserirContato(ContatoDTO contatoDTO) {
        Contato contato = ContatoMapper.toEntity(contatoDTO);

        if (verificarNumeroExistente(contato.getNumero())) {
            throw new DBException("Número de contato já existe.");
        }

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
    public void atualizarContato(ContatoDTO contatoDTO) {
        String sql = "update contatos set nome = ?, sobrenome = ?, numero = ?, numero2 = ?, email = ?, descricao = ? where id = ?";
        try(PreparedStatement st = conexao.prepareStatement(sql)){

            st.setString(1, contatoDTO.getNome());
            st.setString(2, contatoDTO.getSobrenome());
            st.setString(3, contatoDTO.getNumero());
            st.setString(4, contatoDTO.getNumero2());
            st.setString(5, contatoDTO.getEmail());
            st.setString(6, contatoDTO.getDescricao());
            st.setInt(7, contatoDTO.getId());
            st.executeUpdate();

        }catch (SQLException e){
            throw new DBException("Erro ao atualizar Contato" + e.getMessage() + " | " + e );
        }
    }

    @Override
    public void excluirContato(Integer id) {
        String sql = "delete from contatos where id = ?";

        try(PreparedStatement st = conexao.prepareStatement(sql)){

            st.setInt(1, id);
            st.executeUpdate();

        }catch(SQLException e){
            throw new DBException("Erro ao excluir Contato");
        }
    }

    @Override
    public ContatoDTO buscarContatoPorId(Integer id) {
        String sql = "select * from contatos where id = ?";
        ContatoDTO contatoDTO;

        try(PreparedStatement st = conexao.prepareStatement(sql)){
            st.setInt(1, id);

            try(ResultSet resultSet = st.executeQuery()){
                if (resultSet.next()) {
                    contatoDTO = instaciarContato(resultSet);
                }else
                    contatoDTO = null;
            }
        }catch (SQLException e){
            throw new DBException("Erro ao buscar Contato com ID = " + id + " " + e.getMessage());
        }
        return contatoDTO;
    }

    @Override
    public ContatoDTO buscarContatoPorNumero(String numero) {
        String sql = "select * from contatos where numero = ?";
        ContatoDTO contatoDTO;

        try(PreparedStatement st = conexao.prepareStatement(sql)){
            st.setString(1, numero);

            try(ResultSet resultSet = st.executeQuery()){
                if (resultSet.next()) {
                    contatoDTO = instaciarContato(resultSet);
                }else
                    contatoDTO = null;
            }
        }catch (SQLException e){
            throw new DBException("Erro ao buscar Contato com número = " + numero  + " " + e.getMessage());
        }
        return contatoDTO;
    }

    @Override
    public List<ContatoDTO> listarTodosOsContatos() {
        List<ContatoDTO> contatos = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM contatos");
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                contatos.add(instaciarContato(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException("Erro ao listar Contatos: " + e.getMessage());
        }
        return contatos;
    }

    private boolean verificarNumeroExistente(String numero) throws DBException {
        try (PreparedStatement stmt = conexao.prepareStatement(SQL_VERIFICAR_NUMERO)) {
            stmt.setString(1, numero);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new DBException("Erro ao verificar número existente: " + e.getMessage() + " " + e);
        }
    }

    private ContatoDTO instaciarContato(ResultSet resultSet) throws SQLException {
        return new ContatoDTO(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("sobrenome"),
                resultSet.getString("numero"),
                resultSet.getString("numero2"),
                resultSet.getString("email"),
                resultSet.getString("descricao")
        );
    }
}
