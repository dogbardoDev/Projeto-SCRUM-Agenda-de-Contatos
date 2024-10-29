package org.agprojeto.projetoscrumagendadecontatos.dao;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;

public interface ContatoDAO {

    void inserirContato(ContatoDTO cliente);
    void atualizarContato(ContatoDTO cliente);
    void excluirContato(Integer id);

}
