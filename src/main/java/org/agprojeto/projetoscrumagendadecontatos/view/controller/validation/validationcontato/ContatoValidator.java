package org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.validationcontato;

import org.agprojeto.projetoscrumagendadecontatos.dto.ContatoDTO;
import org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.ContatoHandler;

public class ContatoValidator {

    private final ContatoHandler firstHandler;

    public ContatoValidator() {
        ContatoHandler nomeContatoHandler = new NomeContatoHandler();
        ContatoHandler numeroContatoHandler = new NumeroContatoHandler();
        ContatoHandler numero2ContatoHandler = new NumeroContatoHandler();
        ContatoHandler emailContatoHandler = new EmailContatoHandler();

        nomeContatoHandler
                .setNextHandler(numeroContatoHandler)
                .setNextHandler(numero2ContatoHandler)
                .setNextHandler(emailContatoHandler);

        this.firstHandler = nomeContatoHandler;
    }

    public void validarContato(ContatoDTO contatoDTO) {
        if (firstHandler != null) {
            firstHandler.handle(contatoDTO);
        }
    }

}
