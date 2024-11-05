package org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.validationcontato;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.ContatoHandler;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.exceptions.ValidacaoException;

public class EmailContatoHandler extends ContatoHandler {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    @Override
    public ContatoDTO handle(ContatoDTO contatoDTO) {
        if (contatoDTO.getEmail() == null || contatoDTO.getEmail().isEmpty()) {
            return super.handle(contatoDTO);
        }
        if (!contatoDTO.getEmail().matches(EMAIL_REGEX)) {
            throw new ValidacaoException("Erro ao inserir email");
        }
        return super.handle(contatoDTO);
    }

}
