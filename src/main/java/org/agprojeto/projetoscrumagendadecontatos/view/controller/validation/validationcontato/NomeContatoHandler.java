package org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.validationcontato;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.ContatoHandler;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.exceptions.ValidacaoException;

public class NomeContatoHandler extends ContatoHandler {

    @Override
    public ContatoDTO handle(ContatoDTO contatoDTO) {
        if (contatoDTO == null || contatoDTO.getNome() == null || contatoDTO.getNome().isEmpty()) {
            throw new ValidacaoException("Erro ao inserir nome");
        } else
            return super.handle(contatoDTO);
    }
}
