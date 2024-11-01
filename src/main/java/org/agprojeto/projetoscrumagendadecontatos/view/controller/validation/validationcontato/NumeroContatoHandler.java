package org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.validationcontato;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.ContatoHandler;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.exceptions.ValidacaoException;

public class NumeroContatoHandler extends ContatoHandler {

    @Override
    public ContatoDTO handle(ContatoDTO contatoDTO) {
        if (contatoDTO.getNumero() == null || contatoDTO.getNumero().isEmpty()) {
            throw new ValidacaoException("Erro ao inserir número");
        }
        if (contatoDTO.getNumero().length() < 8) {
            throw new ValidacaoException("Erro ao inserir número");
        }
        if (contatoDTO.getNumero().length() == 9) {
            return contatoDTO;
        } else
            return super.handle(contatoDTO);
    }
}
