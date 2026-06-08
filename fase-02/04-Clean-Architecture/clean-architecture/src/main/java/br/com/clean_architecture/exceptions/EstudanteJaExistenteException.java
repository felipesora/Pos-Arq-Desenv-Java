package br.com.clean_architecture.exceptions;

public class EstudanteJaExistenteException extends RuntimeException {
    public EstudanteJaExistenteException(String message) {
        super(message);
    }
}
