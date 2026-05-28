package com.testes_unitarios.api.repository;

import com.testes_unitarios.api.model.Mensagem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MensagemRepositoryTest {

    @Mock
    private MensagemRepository mensagemRepository;

    @Test
    void DevePermitirRegistrarMensagem() {

        // Arrange
        var mensagem = gerarMensagem();

        when(mensagemRepository.save(any(Mensagem.class))).thenReturn(mensagem);

        // Act
        var mensagemSalva = mensagemRepository.save(mensagem);

        // Assert
        assertNotNull(mensagemSalva);
        assertEquals("Felipe", mensagemSalva.getNomeUsuario());
        assertEquals("conteudo", mensagemSalva.getConteudo());
        assertEquals(0, mensagemSalva.getGostei());
    }

    @Test
    void devePermitirConsultarMensagem() {

        // Arrange
        var id = UUID.randomUUID();
        var mensagem = gerarMensagem();
        mensagem.setId(id);

        when(mensagemRepository.findById(any(UUID.class))).thenReturn(Optional.of(mensagem));

        // Act
        var mensagemEncontrada = mensagemRepository.findById(id);

        // Assert
        assertThat(mensagemEncontrada)
                .isPresent()
                .contains(mensagem);
    }

    private Mensagem gerarMensagem() {
        return Mensagem.builder()
                .nomeUsuario("Felipe")
                .conteudo("conteudo")
                .gostei(0)
                .dataCriacao(LocalDateTime.now())
                .dataAlteracao(LocalDateTime.now())
                .build();
    }
}