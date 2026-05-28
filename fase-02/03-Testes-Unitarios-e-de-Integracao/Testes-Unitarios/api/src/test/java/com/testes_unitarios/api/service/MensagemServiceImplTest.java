package com.testes_unitarios.api.service;

import com.testes_unitarios.api.model.Mensagem;
import com.testes_unitarios.api.repository.MensagemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MensagemServiceImplTest {

    @Mock
    private MensagemRepository mensagemRepository;

    @InjectMocks
    private MensagemServiceImpl mensagemService;

    @Test
    void devePermitirRegistrarMensagem() {
        // Arrange
        var mensagem = gerarMensagem();
        when(mensagemRepository.save(any(Mensagem.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        var mensagemRegistrada = mensagemService.registrarMensagem(mensagem);

        // Assert
        assertEquals(mensagem, mensagemRegistrada);
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