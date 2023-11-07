package com.model.pacotes;

import java.time.LocalDate;

import javax.persistence.*;

import com.model.hospedagens.Hospedagem;
import com.model.transportes.Transporte;

@Entity
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected LocalDate dataPartida;
    protected LocalDate dataRetorno;
    protected String origem;
    protected String destino;
    protected int numPessoas;

    @OneToOne
    @JoinColumn(name = "transporte_id")
    protected Transporte transporte;

    @OneToOne
    @JoinColumn(name = "hospedagem_id")
    protected Hospedagem hospedagem;

    public Pacote(LocalDate dataPartida, LocalDate dataRetorno, String origem, String destino, int numPessoas, Transporte transporte, Hospedagem hospedagem) {
        this.dataPartida = dataPartida;
        this.dataRetorno = dataRetorno;
        this.origem = origem;
        this.destino = destino;
        this.numPessoas = numPessoas;
        this.transporte = transporte;
        this.hospedagem = hospedagem;
    }

    public Pacote(LocalDate dataPartida, LocalDate dataRetorno, String origem, String destino, int numPessoas) {
        this.dataPartida = dataPartida;
        this.dataRetorno = dataRetorno;
        this.origem = origem;
        this.destino = destino;
        this.numPessoas = numPessoas;
    }

    public Pacote() {}

    public int getId() {
        return id;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }

    public LocalDate getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDate dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    @Override
    public String toString() {
        return "Pacote [id=" + id + ", dataPartida=" + dataPartida + ", dataRetorno=" + dataRetorno + ", origem="
                + origem + ", destino=" + destino + ", numPessoas=" + numPessoas + ", transporte=" + transporte
                + ", hospedagem=" + hospedagem + "]";
    }

    
}
