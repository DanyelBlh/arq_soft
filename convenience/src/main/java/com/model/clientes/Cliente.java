package com.model.clientes;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cliente")
public abstract class Cliente {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String email;
    protected String nome;
    protected int idade;
    protected String cpf;
    protected boolean logado;
    
    public Cliente(){} //para o hibernate

    public Cliente(String email, String nome, int idade, String cpf) {
        this.email = email;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.logado = false;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", email=" + email + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + "]";
    }

}

