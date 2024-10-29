package org.agprojeto.projetoscrumagendadecontatos.dao;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;

public interface ContatoDAO {

    void inserirContato(ContatoDTO contatoDTO);
    void atualizarContato(ContatoDTO contatoDTO);
    void excluirContato(Integer id);

}
