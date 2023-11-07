package com.model.hospedagens;

import javax.persistence.*;

@Entity
public class Hospedagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String nomeHotel;
    protected float valorHospedagem;

    public Hospedagem(String nomeHotel, float valorHospedagem) {
        this.nomeHotel = nomeHotel;
        this.valorHospedagem = valorHospedagem;
    }

    public Hospedagem() {}

    @Override
    public String toString() {
        return "Hospedagem [id=" + id + ", nomeHotel=" + nomeHotel + ", valorHospedagem=" + valorHospedagem + "]";
    }

    public int getId() {
        return id;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public float getValorHospedagem() {
        return valorHospedagem;
    }

    public void setValorHospedagem(float valorHospedagem) {
        this.valorHospedagem = valorHospedagem;
    }

    
}
