package org.agprojeto.projetoscrumagendadecontatos.view.controller.validation;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;

public abstract class ContatoHandler {

    protected ContatoHandler nextHandler;

    public ContatoDTO handle(ContatoDTO contatoDTO) {
        if (nextHandler != null) {
            return nextHandler.handle(contatoDTO);
        }
        return contatoDTO;
    }

    public ContatoHandler setNextHandler(ContatoHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }
}
