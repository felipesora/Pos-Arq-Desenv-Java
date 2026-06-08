package br.com.clean_architecture.domain.usecases;

import br.com.clean_architecture.domain.entities.Estudante;
import br.com.clean_architecture.dto.NovoEstudanteDTO;
import br.com.clean_architecture.exceptions.EstudanteJaExistenteException;
import br.com.clean_architecture.interfaces.IEstudanteGateway;

public class CadastrarEstudanteUseCase {

    private final IEstudanteGateway gateway;

    private CadastrarEstudanteUseCase(IEstudanteGateway gateway) {
        this.gateway = gateway;
    }

    public static CadastrarEstudanteUseCase create(IEstudanteGateway gateway) {
        return new CadastrarEstudanteUseCase(gateway);
    }

    public Estudante run(NovoEstudanteDTO novoEstudanteDTO) throws EstudanteJaExistenteException {
        final Estudante estudanteExistente = gateway.buscarPorNome(novoEstudanteDTO.nome());

        if (estudanteExistente != null) {
            throw new EstudanteJaExistenteException(novoEstudanteDTO.nome());
        }

        final Estudante novoEstudante = Estudante.create(
                novoEstudanteDTO.nome(),
                novoEstudanteDTO.idade(),
                novoEstudanteDTO.enderecoEmail()
        );

        Estudante estudante = gateway.incluir(novoEstudante);
        return estudante;
    }
}
