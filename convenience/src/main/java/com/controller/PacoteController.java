package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.PacoteDAO;
import com.model.pacotes.Pacote;

public abstract class PacoteController {
    
    public static void salvarPacote(Pacote pacote) {
        try {
            PacoteDAO.salvarPacote(pacote);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Pacote> buscarTodosPacotes(){
        try {
            List<Pacote> pacotes = new ArrayList<Pacote>();
            pacotes = PacoteDAO.buscarTodosPacotes();
            return pacotes;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Pacote buscarPacote(int id) {
        try {
            Pacote p1 = PacoteDAO.buscarPacote(id);
            return PacoteDAO.buscarPacote(id);
        } catch (Exception e) {
            return null; //o correto é mandar exceção em vez de mandar null
        }
    }

    public static void excluirPacote(int id){
        try {
            Pacote c1 = PacoteDAO.buscarPacote(id);
            PacoteDAO.excluirPacote(c1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
