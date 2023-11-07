package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.ReservaDAO;
import com.model.reservas.Reserva;


public class ReservaController {
       
    public static void salvarReserva(Reserva reserva) {
        try {
            ReservaDAO.salvarReserva(reserva);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Reserva> buscarTodasReservas(){
        try {
            List<Reserva> reservas = new ArrayList<Reserva>();
            reservas = ReservaDAO.buscarTodasReservas();
            return reservas;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Reserva buscarReserva(int id) {
        try {
            Reserva r1 = ReservaDAO.buscarReserva(id);
            return ReservaDAO.buscarReserva(id);
        } catch (Exception e) {
            return null; //o correto é mandar exceção em vez de mandar null
        }
    }

    public static void excluirReserva(int id){
        try {
            Reserva c1 = ReservaDAO.buscarReserva(id);
            ReservaDAO.excluirReserva(c1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
