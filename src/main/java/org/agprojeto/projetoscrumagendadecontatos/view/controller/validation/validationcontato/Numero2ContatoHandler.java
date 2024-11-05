package org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.validationcontato;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.ContatoHandler;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.exceptions.ValidacaoException;

public class Numero2ContatoHandler extends ContatoHandler {

    @Override
    public ContatoDTO handle(ContatoDTO contatoDTO) {
        if (contatoDTO.getNumero2().equals(contatoDTO.getNumero())) {
            throw new ValidacaoException("Número 2 igual ao número 1");
        } else
            return super.handle(contatoDTO);
    }

}
