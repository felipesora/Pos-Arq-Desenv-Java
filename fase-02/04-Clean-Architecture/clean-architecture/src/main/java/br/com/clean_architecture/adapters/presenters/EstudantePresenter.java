package br.com.clean_architecture.adapters.presenters;

import br.com.clean_architecture.domain.entities.Estudante;
import br.com.clean_architecture.dto.EstudanteDTO;

public class EstudantePresenter {

    public static EstudanteDTO ToDTO(Estudante estudante) {
        final String identificacao = estudante.getIdentificacaoInterna();
        final String identificacaoOfuscada = identificacao.charAt(1) + "..." + identificacao.charAt(identificacao.length() - 1);

        EstudanteDTO estudanteDTO = new EstudanteDTO(
                identificacaoOfuscada,
                estudante.getNome(),
                estudante.getIdade(),
                estudante.getEnderecoEmail()
        );
        return estudanteDTO;
    }

}
