package br.com.clean_architecture.domain.usecases;

import br.com.clean_architecture.domain.entities.Estudante;
import br.com.clean_architecture.exceptions.EstudanteNaoEncontradoException;
import br.com.clean_architecture.interfaces.IEstudanteGateway;

public class BuscarEstudantePorNomeUseCase {

    private final IEstudanteGateway gateway;

    private BuscarEstudantePorNomeUseCase(IEstudanteGateway gateway) {
        this.gateway = gateway;
    }

    public static BuscarEstudantePorNomeUseCase create(IEstudanteGateway gateway) {
        return new BuscarEstudantePorNomeUseCase(gateway);
    }

    public Estudante run(String nome) throws EstudanteNaoEncontradoException {
        Estudante estudante = gateway.buscarPorNome(nome);
        if (estudante == null) {
            throw new EstudanteNaoEncontradoException(nome);
        }
        return estudante;
    }
}
