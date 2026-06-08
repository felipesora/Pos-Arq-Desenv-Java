package br.com.clean_architecture.adapters.controllers;

import br.com.clean_architecture.adapters.gateways.EstudanteGateway;
import br.com.clean_architecture.adapters.presenters.EstudantePresenter;
import br.com.clean_architecture.domain.usecases.CadastrarEstudanteUseCase;
import br.com.clean_architecture.dto.EstudanteDTO;
import br.com.clean_architecture.dto.NovoEstudanteDTO;
import br.com.clean_architecture.exceptions.EstudanteJaExistenteException;
import br.com.clean_architecture.interfaces.IDataStorageSource;

public class EstudanteController {

    private final IDataStorageSource dataStorageSource;

    private EstudanteController (IDataStorageSource dataStorageSource) {
        this.dataStorageSource = dataStorageSource;
    }

    public static EstudanteController create (IDataStorageSource dataStorageSource) {
        return new EstudanteController(dataStorageSource);
    }

    public EstudanteDTO Cadastrar(NovoEstudanteDTO novoEstudanteDTO) {
        var estudanteGateway = EstudanteGateway.create(this.dataStorageSource);
        var useCase = CadastrarEstudanteUseCase.create(estudanteGateway);
        try {
            var estudante = useCase.run(novoEstudanteDTO);
            var estudanteDto = EstudantePresenter.ToDTO(estudante);
            return estudanteDto;
        } catch (EstudanteJaExistenteException e) {
            return null;  // deve retornar algo melhor
        }
    }

}
