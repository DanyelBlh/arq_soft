package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.ClienteDAO;
import com.model.clientes.*;

public abstract class ClienteController {

    public static void salvarCliente(Cliente cliente) {
        try {
            ClienteDAO.salvarCliente(cliente);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Cliente> buscarTodosClientes(){
        try {
            List<Cliente> clientes = new ArrayList<Cliente>();
            clientes = ClienteDAO.buscarTodosClientes();
            return clientes;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Cliente buscarCliente(int id) {
        try {
            Cliente c1 = ClienteDAO.buscarCliente(id);
            return ClienteDAO.buscarCliente(id);
        } catch (Exception e) {
            return null; //o correto é mandar exceção em vez de mandar null
        }
    }

    public static void atualizarCliente(int id, String novoEmail, String novoNome, int novaIdade, String novoCPF, String novoResponsavel, String novoEstadoCivil) {
        try {
            Cliente cliente = ClienteDAO.buscarCliente(id);
            
            if (cliente != null) {
                if (novoEmail != "") {
                    cliente.setEmail(novoEmail);
                }

                if (novoNome != "") {
                    cliente.setNome(novoNome);
                }

                if (novaIdade > 0) {
                    cliente.setIdade(novaIdade);
                }

                if (novoCPF != "") {
                    cliente.setCpf(novoCPF);
                }

                if (cliente instanceof Menor && novoResponsavel != "") {
                    Menor menor = (Menor) cliente;
                    menor.setResponsavel(novoResponsavel);
                }

                if (cliente instanceof Maior && novoEstadoCivil != "") {
                    Maior maior = (Maior) cliente;
                    maior.setEstadoCivil(novoEstadoCivil);
                }

                ClienteDAO.atualizarCliente(cliente);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void excluirCliente(int id){
        try {
            Cliente c1 = ClienteDAO.buscarCliente(id);
            ClienteDAO.excluirCliente(c1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
