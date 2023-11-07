package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.HospedagemDAO;
import com.model.hospedagens.Hospedagem;

public abstract class HospedagemController {

    public static void salvarHospedagem(Hospedagem hospedagem) {
        try {
            HospedagemDAO.salvarHospedagem(hospedagem);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Hospedagem> buscarTodasHospedagens(){
        try {
            List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
            hospedagens = HospedagemDAO.buscarTodasHospedagens();
            return hospedagens;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Hospedagem buscarHospedagem(int id) {
        try {
            Hospedagem c1 = HospedagemDAO.buscarHospedagem(id);
            return HospedagemDAO.buscarHospedagem(id);
        } catch (Exception e) {
            return null; //o correto é mandar exceção em vez de mandar null
        }
    }

    public static void atualizarCliente(int id, String novoNomeHotel, float novoValorHospedagem) {
        try {
            Hospedagem hospedagem = HospedagemDAO.buscarHospedagem(id);
            
            if (hospedagem != null) {
                if (novoNomeHotel != null) {
                    hospedagem.setNomeHotel(novoNomeHotel);
                }

                if (novoValorHospedagem != 0) {
                    hospedagem.setValorHospedagem(novoValorHospedagem);
                }

                HospedagemDAO.atualizarHospedagem(hospedagem);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void excluirHospedagem(int id){
        try {
            Hospedagem c1 = HospedagemDAO.buscarHospedagem(id);
            HospedagemDAO.excluirHospedagem(c1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

