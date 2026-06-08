package br.com.clean_architecture.exceptions;

public class EstudanteNaoEncontradoException extends RuntimeException {
    public EstudanteNaoEncontradoException(String message) {
        super(message);
    }
}
