package br.com.clean_architecture.interfaces;

import br.com.clean_architecture.domain.entities.Estudante;

public interface IEstudanteGateway {
    Estudante buscarPorIdentificacao(String identificacao);
    Estudante incluir(Estudante estudante);
    Estudante buscarPorNome(String nome);
}
