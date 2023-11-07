package com.model.transportes;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "aviao")
public class Aviao extends Transporte {
    
    private String nomeCompanhiaAerea;
    private String numeroPassagem;

    public Aviao(float valorTransporte, String nomeCompanhiaAerea, String numeroPassagem) {
            super(valorTransporte);
            this.nomeCompanhiaAerea = nomeCompanhiaAerea;
            this.numeroPassagem = numeroPassagem;
    }

    public Aviao(){}
    
    public String getNomeCompanhiaAerea() {
        return nomeCompanhiaAerea;
    }

    public void setNomeCompanhiaAerea(String nomeCompanhiaAerea) {
        this.nomeCompanhiaAerea = nomeCompanhiaAerea;
    }

    public String getNumeroPassagem() {
        return numeroPassagem;
    }

    public void setNumeroPassagem(String numeroPassagem) {
        this.numeroPassagem = numeroPassagem;
    }    

}
