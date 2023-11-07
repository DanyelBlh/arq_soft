package com.dao;

import java.util.List;

import javax.persistence.*;

import com.model.clientes.Cliente;
import com.model.reservas.Reserva;

public class ReservaDAO {

   private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
    private static EntityManager em = emf.createEntityManager();

    public static void salvarReserva(Reserva reserva) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(reserva);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static Reserva buscarReserva(int id) throws Exception {
        try {
            em.getTransaction().begin();
            Reserva cliente = em.find(Reserva.class, id);
            em.getTransaction().commit();
            return cliente;
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception(e);
        }
    }

    public static List<Reserva> buscarTodasReservas() throws Exception {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT r FROM Reserva r");
            List<Reserva> clientes = sql.getResultList();
            em.getTransaction().commit();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void atualizarReserva(Reserva reserva) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(reserva);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static void excluirReserva (Reserva cliente) throws Exception {
        try {
            em.getTransaction().begin();
            cliente = em.merge(cliente);
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

}
