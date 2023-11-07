package com.dao;

import java.util.List;

import javax.persistence.*;

import com.model.clientes.Cliente;
import com.model.pacotes.Pacote;

public class PacoteDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
    private static EntityManager em = emf.createEntityManager();

    public static void salvarPacote(Pacote pacote) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(pacote);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static Pacote buscarPacote(int id) throws Exception {
        try {
            em.getTransaction().begin();
            Pacote pacote = em.find(Pacote.class, id);
            em.getTransaction().commit();
            return pacote;
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception(e);
        }

    }

    public static List<Pacote> buscarTodosPacotes() throws Exception {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT p FROM Pacote p");
            List<Pacote> pacotes = sql.getResultList();
            em.getTransaction().commit();
            return pacotes;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void atualizarPacote(Pacote pacote) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(pacote);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static void excluirPacote(Pacote pacote) throws Exception {
        try {
            em.getTransaction().begin();
            pacote = em.merge(pacote);
            em.remove(pacote);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }
}

