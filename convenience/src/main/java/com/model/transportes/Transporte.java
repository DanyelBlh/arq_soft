package com.model.transportes;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_transporte")
public abstract class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    protected float valorTransporte;
    
    public Transporte(float valorTransporte) {
        this.valorTransporte = valorTransporte;
    }
    
    public Transporte() {}

    @Override
    public String toString() {
        return "Transporte [valorTransporte=" + valorTransporte + "]";
    }

    public float getValorTransporte() {
        return valorTransporte;
    }

    public void setValorTransporte(float valorTransporte) {
        this.valorTransporte = valorTransporte;
    }

}
