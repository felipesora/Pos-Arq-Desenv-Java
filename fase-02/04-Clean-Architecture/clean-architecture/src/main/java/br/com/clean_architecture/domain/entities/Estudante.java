package br.com.clean_architecture.domain.entities;

import org.apache.commons.validator.routines.EmailValidator;

public class Estudante {

    private String identificacaoInterna;
    private String nome;
    private int idade;
    private String enderecoEmail;

    public static Estudante create(String nome, int idade, String enderecoEmail)
            throws IllegalArgumentException
    {
        if (nome == null || enderecoEmail == null) {
            throw new IllegalArgumentException("Null data");
        }

        validateNome(nome);
        validateIdade(idade);
        validateEnderecoEmail(enderecoEmail);

        Estudante estudante = new Estudante();
        estudante.setNome(nome);
        estudante.setIdade(idade);
        estudante.setEnderecoEmail(enderecoEmail);

        return estudante;
    }

    public static Estudante create(String identificaoInterna, String nome, int idade, String enderecoEmail)
            throws IllegalArgumentException
    {
        if (nome == null || enderecoEmail == null) {
            throw new IllegalArgumentException("Null data");
        }

        Estudante estudante = new Estudante();
        estudante.setIdentificacaoInterna(identificaoInterna);
        estudante.setNome(nome);
        estudante.setIdade(idade);
        estudante.setEnderecoEmail(enderecoEmail);

        return estudante;
    }


    private static void validateEnderecoEmail(String enderecoEmail) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(enderecoEmail)) {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    private static void validateIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Idade deve ser maior que 18");
        }
    }

    private static void validateNome(String nome) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome Inválido");
        }
    }

    private static void validateIdentificacaoInterna(String identificacaoInterna) {
        if (identificacaoInterna == null || identificacaoInterna.trim().isEmpty()) {
            throw new IllegalArgumentException("Identificacao Interna Invalida");
        }
    }

    public String getIdentificacaoInterna() {
        return identificacaoInterna;
    }

    public void setIdentificacaoInterna(String identificacaoInterna) {
        this.identificacaoInterna = identificacaoInterna;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }
}
