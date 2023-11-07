package com.model.reservas;

import java.time.LocalDate;

import javax.persistence.*;

import com.model.clientes.Cliente;
import com.model.pacotes.Pacote;

@Entity
public class Reserva implements TaxaServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    protected Cliente cliente;

    @OneToOne
    @JoinColumn(name = "pacote_id")
    protected Pacote pacote;

    protected float valorTotal;
    protected LocalDate data;

    public Reserva(Cliente cliente, Pacote pacote) {
        this.cliente = cliente;
        this.pacote = pacote;
        this.data = LocalDate.now();
        setValorTotal(pacote);
    }

    public Reserva() {}

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", cliente=" + cliente + ", pacote=" + pacote + ", valorTotal=" + valorTotal
                + ", data=" + data + "]";
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Pacote pacote) {
        this.valorTotal = pacote.getTransporte().getValorTransporte() + pacote.getHospedagem().getValorHospedagem();
    }

    @Override
    public void calcularTaxaServico() {
        valorTotal += (valorTotal * 0.01); 
    }
    
}
