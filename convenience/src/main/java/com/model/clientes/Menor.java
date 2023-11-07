package com.model.clientes;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "menor")
public class Menor extends Cliente{
    
    private String responsavel;

    public Menor(){}

    public Menor(String email, String nome, int idade, String cpf, String responsavel) {
        super(email, nome, idade, cpf);
        this.responsavel = responsavel;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString(){
        return "Menor [id=" + id + ", email=" + email + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", responsavel=" + responsavel + "]";
    }
    
}

