package br.com.clean_architecture.interfaces;

import br.com.clean_architecture.dto.EstudanteDTO;
import br.com.clean_architecture.dto.NovoEstudanteDTO;

public interface IDataStorageSource {
    EstudanteDTO obterEstudantePorIdentificacao(String identificacao);

    EstudanteDTO incluirEstudante(NovoEstudanteDTO novoEstudante);

    EstudanteDTO obterEstudantePorNome(String nome);
}
