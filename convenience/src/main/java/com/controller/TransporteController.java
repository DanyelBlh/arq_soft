package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.TransporteDAO;
import com.model.transportes.Aviao;
import com.model.transportes.Transporte;

public abstract class TransporteController {

    public static void salvarTransporte(Transporte transporte) {
        try {
            TransporteDAO.salvarTransporte(transporte);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Transporte> buscarTodosTransportes(){
        try {
            List<Transporte> transportes = new ArrayList<Transporte>();
            transportes = TransporteDAO.buscarTodosTransportes();
            return transportes;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Transporte buscarTransporte(int id) {
        try {
            Transporte c1 = TransporteDAO.buscarTransporte(id);
            return TransporteDAO.buscarTransporte(id);
        } catch (Exception e) {
            return null; //o correto é mandar exceção em vez de mandar null
        }
    }

    public static void atualizarTransporte(int id, float novoValor, String nomeCompanhia, String numeroPassagem) {
        try {
            Transporte transporte = TransporteDAO.buscarTransporte(id);
            
            if (transporte != null) {
                if (novoValor > 0) {
                    transporte.setValorTransporte(novoValor);
                }

                if (transporte instanceof Aviao && nomeCompanhia != "") {
                    Aviao aviao = (Aviao) transporte;
                    aviao.setNomeCompanhiaAerea(nomeCompanhia);
                }

                if (transporte instanceof Aviao && numeroPassagem != "") {
                    Aviao aviao = (Aviao) transporte;
                    aviao.setNumeroPassagem(numeroPassagem);
                }
                
                TransporteDAO.atualizarTransporte(transporte);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void excluirTransporte(int id){
        try {
            Transporte c1 = TransporteDAO.buscarTransporte(id);
            TransporteDAO.excluirTransporte(c1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

