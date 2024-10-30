package org.agprojeto.projetoscrumagendadecontatos.dto;

public class ContatoDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String numero;
    private String numero2;
    private String email;
    private String descricao;

    // Construtores

    public ContatoDTO() {}

    public ContatoDTO(Integer id, String nome, String sobrenome, String numero, String numero2, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
        this.numero2 = numero2;
        this.email = email;
        this.descricao = descricao;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNumero() {
        return numero;
    }

    public String getNumero2() {
        return numero2;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}