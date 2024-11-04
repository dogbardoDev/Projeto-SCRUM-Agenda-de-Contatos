package org.agprojeto.projetoscrumagendadecontatos.dao;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;

import java.util.List;

public interface ContatoDAO {

    void inserirContato(ContatoDTO contatoDTO);
    void atualizarContato(ContatoDTO contatoDTO);
    void excluirContato(Integer id);
    ContatoDTO buscarContatoPorId(Integer id);
    List<ContatoDTO> listarTodosOsContatos();
    ContatoDTO buscarContatoPorNumero(String numero);

}
