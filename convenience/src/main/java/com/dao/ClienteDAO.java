package com.dao;

import java.util.List;

import javax.persistence.*;

import com.model.clientes.Cliente;

public class ClienteDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
    private static EntityManager em = emf.createEntityManager();

    public static void salvarCliente(Cliente cliente) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static Cliente buscarCliente(int id) throws Exception {
        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().commit();
            return cliente;
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception(e);
        }
    }

    public static List<Cliente> buscarTodosClientes() throws Exception {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT c FROM Cliente c");
            List<Cliente> clientes = sql.getResultList();
            em.getTransaction().commit();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void atualizarCliente(Cliente cliente) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static void excluirCliente (Cliente cliente) throws Exception {
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

