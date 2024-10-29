package org.agprojeto.projetoscrumagendadecontatos.db.exceptions;

public class DBException extends RuntimeException {

    public DBException() {
        super();
    }

    public DBException(String message) {
        super(message);
    }
}
