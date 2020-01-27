package com.algaworks.algamoneyapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB02_PESSOA")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;


    @Column(name = "NOME")
    private String nome;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Pessoa() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
