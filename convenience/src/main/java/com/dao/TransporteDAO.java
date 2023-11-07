package com.dao;

import java.util.List;

import javax.persistence.*;

import com.model.clientes.Cliente;
import com.model.transportes.Transporte;

public class TransporteDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
    private static EntityManager em = emf.createEntityManager();

    public static void salvarTransporte(Transporte transporte) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(transporte);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static Transporte buscarTransporte(int id) throws Exception {
        try {
            em.getTransaction().begin();
            Transporte transporte = em.find(Transporte.class, id);
            em.getTransaction().commit();
            return transporte;
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception(e);
        }
    }

    public static List<Transporte> buscarTodosTransportes() throws Exception {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT c FROM Transporte c");
            List<Transporte> transportes = sql.getResultList();
            em.getTransaction().commit();
            return transportes;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void atualizarTransporte(Transporte transporte) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(transporte);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static void excluirTransporte (Transporte transporte) throws Exception {
        try {
            em.getTransaction().begin();
            transporte = em.merge(transporte);
            em.remove(transporte);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

}


