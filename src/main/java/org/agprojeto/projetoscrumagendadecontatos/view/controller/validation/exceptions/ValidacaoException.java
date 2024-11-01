package org.agprojeto.projetoscrumagendadecontatos.view.controller.validation.exceptions;

public class ValidacaoException extends RuntimeException{

    public ValidacaoException(){
        super();
    }

    public ValidacaoException(String mensagem){
        super(mensagem);
    }

}
