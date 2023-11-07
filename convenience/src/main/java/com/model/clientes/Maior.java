package com.model.clientes;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "maior")
public class Maior extends Cliente{
    
    private String estadoCivil;

    public Maior(){}

    public Maior(String email, String nome, int idade, String cpf, String estadoCivil) {
        super(email, nome, idade, cpf);
        this.estadoCivil = estadoCivil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Maior [id=" + id + ", email=" + email + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", estadoCivil=" + estadoCivil + "]";
    }

    

}

