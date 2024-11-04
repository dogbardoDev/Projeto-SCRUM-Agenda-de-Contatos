package org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.validationcontato;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.ContatoHandler;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.exceptions.ValidacaoException;

public class NumeroContatoHandler extends ContatoHandler {

    @Override
    public ContatoDTO handle(ContatoDTO contatoDTO) {
        if (contatoDTO.getNumero() == null || contatoDTO.getNumero().isEmpty() || contatoDTO.getNumero().length() < 9) {
            throw new ValidacaoException("Erro ao inserir número");
        } else
            return super.handle(contatoDTO);
    }
}
