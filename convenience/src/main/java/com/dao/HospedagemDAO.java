package com.dao;

import java.util.List;

import javax.persistence.*;

import com.model.clientes.Cliente;
import com.model.hospedagens.Hospedagem;

public class HospedagemDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
    private static EntityManager em = emf.createEntityManager();

    public static void salvarHospedagem(Hospedagem hospedagem) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(hospedagem);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static Hospedagem buscarHospedagem(int id) throws Exception {
        try {
            em.getTransaction().begin();
            Hospedagem hospedagem = em.find(Hospedagem.class, id);
            em.getTransaction().commit();
            return hospedagem;
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception(e);
        }
    }

    public static List<Hospedagem> buscarTodasHospedagens() throws Exception {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT h FROM Hospedagem h");
            List<Hospedagem> hospedagens = sql.getResultList();
            em.getTransaction().commit();
            return hospedagens;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void atualizarHospedagem(Hospedagem hospedagem) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(hospedagem);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static void excluirHospedagem (Hospedagem hospedagem) throws Exception {
        try {
            em.getTransaction().begin();
            hospedagem = em.merge(hospedagem);
            em.remove(hospedagem);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

}


