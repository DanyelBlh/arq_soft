package com;
//teste
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.controller.ClienteController;
import com.controller.HospedagemController;
import com.controller.PacoteController;
import com.controller.ReservaController;
import com.controller.TransporteController;
import com.dao.ClienteDAO;
import com.model.clientes.*;
import com.model.hospedagens.Hospedagem;
import com.model.pacotes.*;
import com.model.reservas.Reserva;
import com.model.transportes.Aviao;
import com.model.transportes.Transporte;

public class App 
{
    public static List<Cliente> clientes = new ArrayList<>();
    static private List<Cliente> listaEmail = new ArrayList<>();
    public static List<Pacote> pacotes = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main( String[] args ) throws Exception
    {
        int opcao = 0;

        do {
            System.out.println("========== MENU PRINCIPAL ==========");
            System.out.println("1. Menu Cliente");
            System.out.println("2. Menu Pacote");
            System.out.println("3. Menu Hospedagem");
            System.out.println("4. Menu Transporte");
            System.out.println("5. Menu Reserva");
            System.out.println("6. Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuCliente();
                    break;
                case 2:
                    menuPacote();
                    break;
                case 3:
                    menuHospedagem();
                    break;
                case 4:
                    menuTransporte();
                    break;
                case 5:
                    menuReserva();
                    break;
                
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                    default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 6);

        scanner.close();
    }



    private static void menuCliente() throws Exception {
    int opcao = 0;

        do {
            System.out.println("============ Menu Cliente ===========");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Visualizar Lista de Todos os Clientes");
            System.out.println("4. Atualizar Cliente");
            System.out.println("5. Deletar Cliente");
            System.out.println("6. Login");
            System.out.println("7. Voltar ao menu principal");
            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    buscarCliente();
                    break;
                case 3:
                    buscarTodosClientes();
                    break; 
                case 4:
                    atualizarCliente();
                    break;               
                case 5:
                    deletarCliente();
                    break;
                case 6:
                    logarUsuario(listaEmail);
                    break;
                case 7:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 7);
    }

    public static void logarUsuario(List<Cliente> listaEmail) throws Exception { 
      
        System.out.println("Digite seu e-mail: ");
        String email = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) ClienteDAO.buscarTodosClientes();

        Cliente clienteSelecionado = null;
        boolean usuarioEncontrado = false; // Variável para verificar se o usuário foi encontrado

        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                clienteSelecionado = cliente;

                // String cpfArmazenado = cliente.getCpf();
                if (cliente.getCpf().equals(cpf)) {
                    System.out.println("\nVocê está logado!\n");
                    System.out.println("____________________");

                    cliente.setLogado(true);
                    listaEmail.add(cliente);
                } else {
                    System.out.println("cpf inválido!");
                    
                }

                usuarioEncontrado = true; // O usuário foi encontrado, não há necessidade de continuar o loop
                break;
            }
        }
        if (!usuarioEncontrado) {
            System.out.println("Usuário ou senha incorreta!\n");
    }
    
}
    

    private static void cadastrarCliente() {

        System.out.print("Digite o e-mail do cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idadeCliente = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();
        if (idadeCliente >=18){
            System.out.println("Digite o estado civil do cliente: ");
            String estadoCivilCliente = scanner.nextLine();
            Maior novoClienteMaior = new Maior(emailCliente, nomeCliente, idadeCliente, cpfCliente, estadoCivilCliente);
            ClienteController.salvarCliente(novoClienteMaior);
        } else {
            System.out.println("Digite o nome do responsável: ");
            String responsavelCliente = scanner.nextLine();
            Menor novoClienteMenor = new Menor(emailCliente, nomeCliente,idadeCliente, cpfCliente, responsavelCliente);
            ClienteController.salvarCliente(novoClienteMenor);
        }
        
        System.out.println("\nCliente cadastrado com sucesso.\n");
    }

    private static void buscarCliente() {
        System.out.println("Digite o número do ID do cliente para buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(ClienteController.buscarCliente(id));
    }
    
    private static void buscarTodosClientes() {
        System.out.println(ClienteController.buscarTodosClientes());
    }

    private static void atualizarCliente() {
        System.out.println("Digite o número do ID do cliente para fazer atualização no sistema: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        ClienteController.buscarCliente(id);

        System.out.print("Digite a atualização do e-mail do cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Digite a atualização do nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite a atualização da idade do cliente: ");
        int idadeCliente = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a atualização do CPF do cliente: ");
        String cpfCliente = scanner.nextLine();
        System.out.print("Digite a atualização do Estado Civil do cliente (caso menor de idade, deixar em branco): ");
        String estadoCivil = scanner.nextLine();
        System.out.print("Digite a atualização do Responsável do cliente (caso maior de idade, deixar em branco): ");
        String responsavel = scanner.nextLine();

        ClienteController.atualizarCliente(id, emailCliente, nomeCliente, idadeCliente, cpfCliente, responsavel, estadoCivil);
                
        System.out.println("\nCliente alterado com sucesso.\n");
    }

    private static void deletarCliente() {
        System.out.println("Digite o número do ID do cliente para deletar do sistema: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        ClienteController.excluirCliente(id);
        System.out.println("\nCliente excluído com sucesso.\n");
    }

    private static void menuPacote() {
        int opcao = 0;

        do {
            System.out.println("============ Menu Pacote ===========");
            System.out.println("1. Cadastrar Pacote");
            System.out.println("2. Buscar Pacote");
            System.out.println("3. Visualizar lista de Pacotes Cadastrados");
            System.out.println("4. Deletar Pacote");
            System.out.println("5. Voltar ao menu principal");
            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarPacote();
                    break;
                case 2:
                    buscarPacote();
                    break;
                case 3:
                    buscarTodosPacotes();
                    break;
                case 4:
                    deletarPacote();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 5);
    }

    private static void cadastrarPacote() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Digite a data de partida (dd/MM/yyyy): ");
        String dataPartidaString = scanner.nextLine();
        LocalDate dataPartidaPacote = LocalDate.parse(dataPartidaString, formatter);
        System.out.print("Digite a data de chegada (dd/MM/yyyy): ");
        String dataChegadaString = scanner.nextLine();
        LocalDate dataChegadaPacote = LocalDate.parse(dataChegadaString, formatter);
        System.out.print("Digite a origem da viagem: ");
        String origemPacote = scanner.nextLine();
        System.out.print("Digite o destino da viagem: ");
        String destinoPacote = scanner.nextLine();
        System.out.print("Digite o número de pessoas: ");
        int numPessoas = scanner.nextInt();
       
        System.out.print("Digite o ID do transporte: ");
        int idTransporte = scanner.nextInt();
        scanner.nextLine();
        Transporte transporte = TransporteController.buscarTransporte(idTransporte);

        System.out.print("Digite o ID da hospedagem: ");
        int idHospedagem = scanner.nextInt();
        scanner.nextLine();
        Hospedagem hospedagem = HospedagemController.buscarHospedagem(idHospedagem);

        Pacote novoPacote = new Pacote(dataPartidaPacote, dataChegadaPacote, origemPacote, destinoPacote, numPessoas, transporte, hospedagem);
        PacoteController.salvarPacote(novoPacote);
        System.out.println("\nPacote cadastrado com sucesso.\n");
    }

    private static void buscarPacote() {
        System.out.println("Digite o ID do pacote para buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(PacoteController.buscarPacote(id));
    }

    private static void buscarTodosPacotes() {
        System.out.println(PacoteController.buscarTodosPacotes());
    }

    private static void deletarPacote() {
        System.out.println("Digite o ID do pacote para deletar do sistema: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        PacoteController.excluirPacote(id);
        System.out.println("\nPacote excluído com sucesso.\n");
    }

    private static void menuHospedagem() {
        int opcao = 0;

        do {
            System.out.println("============ Menu Hospedagem ===========");
            System.out.println("1. Cadastrar Hospedagem");
            System.out.println("2. Buscar Hospedagem");
            System.out.println("3. Mostrar todos as Hospedagens Cadastradas");
            System.out.println("4. Atualizar Hospedagem");
            System.out.println("5. Deletar Hospedagem");
            System.out.println("6. Voltar ao menu principal");
            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarHospedagem();
                    break;
                case 2:
                    buscarHospedagem();
                    break;
                case 3:
                    buscarTodasHospedagens();
                    break;
                case 4:
                    atualizarHospedagem();
                    break;
                case 5:
                    deletarHospedagem();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 6);
    }

    private static void cadastrarHospedagem() {
        System.out.print("Digite o nome do Hotel: ");
        String nomeHotel = scanner.nextLine();
        System.out.print("Digite o valor por pessoa: ");
        int valorHospedagem = scanner.nextInt();
        scanner.nextFloat();
        Hospedagem novaHospedagem = new Hospedagem(nomeHotel, valorHospedagem);
        HospedagemController.salvarHospedagem(novaHospedagem);
        System.out.println("\nHospedagem cadastrada com sucesso.\n");
    }

    private static void buscarHospedagem() {
        System.out.println("Digite o ID da hospedagem para buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(HospedagemController.buscarHospedagem(id));
    }

    private static void buscarTodasHospedagens() {
        System.out.println(HospedagemController.buscarTodasHospedagens());
    }

    private static void atualizarHospedagem(){
        System.out.println("Digite o número do ID da Hospedagem para fazer atualização no sistema: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        HospedagemController.buscarHospedagem(id);
        
        System.out.print("Digite a atualização do nome da Hospedagem: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite a atualização do valor da Hospedagem: ");
        float novoValor = scanner.nextFloat();
        scanner.nextLine();

        HospedagemController.atualizarCliente(id, novoNome, novoValor);
                
        System.out.println("\nHospedagem alterada com sucesso.\n");
    }

    private static void deletarHospedagem() {
        System.out.println("Digite o ID da hospedagem para deletar do sistema: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        HospedagemController.excluirHospedagem(id);
        System.out.println("\nHospedagem excluída com sucesso.\n");
    }

    private static void menuTransporte() {
        int opcao = 0;

        do {
            System.out.println("============ Menu Transporte ===========");
            System.out.println("1. Cadastrar Transporte");
            System.out.println("2. Buscar Transporte");
            System.out.println("3. Mostrar todos os Transportes Cadastrados");
            System.out.println("4. Atualizar Transporte");
            System.out.println("5. Deletar Transporte");
            System.out.println("6. Voltar ao menu principal");
            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarTransporte();
                    break;
                case 2:
                    buscarTransporte();
                    break;
                case 3:
                    buscarTodosTransportes();
                    break;
                case 4:
                    atualizarTransporte();
                    break;
                case 5:
                    deletarTransporte();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 5);
    }

    private static void cadastrarTransporte() {
        System.out.print("Digite o nome da Companhia Aérea: ");
        String nomeCompanhia = scanner.nextLine();
        System.out.print("Digite o número da Passagem: ");
        String numeroPassagem = scanner.nextLine();
        System.out.print("Digite o valor da Passagem: ");
        float valorTransporte = scanner.nextFloat();
        scanner.nextLine();
        Aviao novoAviao = new Aviao(valorTransporte, nomeCompanhia, numeroPassagem);
        TransporteController.salvarTransporte(novoAviao);
        System.out.println("\nTransporte cadastrado com sucesso.\n");
    }

    private static void buscarTransporte() {
        System.out.println("Digite o ID do Transporte para buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(TransporteController.buscarTransporte(id));
    }

    private static void buscarTodosTransportes() {
        System.out.println(TransporteController.buscarTodosTransportes());
    }

    private static void atualizarTransporte(){
        System.out.println("Digite o número do ID do Transporte para fazer atualização no sistema: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        TransporteController.buscarTransporte(id);
        
        System.out.print("Digite a atualização do valor do Transporte: ");
        float novoValor = scanner.nextFloat();
        scanner.nextLine();
    
        System.out.print("Digite a atualização do nome da Companhia Aérea: ");
        String novoNome = scanner.nextLine();

        System.out.print("Digite a atualização do número da Passagem: ");
        String novoNumero = scanner.nextLine();

        TransporteController.atualizarTransporte(id, novoValor, novoNome, novoNumero);
                
        System.out.println("\nTransporte alterado com sucesso.\n");
    }

    private static void deletarTransporte() {
        System.out.println("Digite o ID do transporte para deletar do sistema: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        TransporteController.excluirTransporte(id);
        System.out.println("\nTransporte excluído com sucesso.\n");
    }

    private static void menuReserva() {
        int opcao = 0;

        do {
            System.out.println("============ Menu Reserva ===========");
            System.out.println("1. Cadastrar Reserva");
            System.out.println("2. Buscar Reserva");
            System.out.println("3. Mostrar todas as Reservas Cadastradas");
            System.out.println("4. Deletar Reserva");
            System.out.println("5. Voltar ao menu principal");
            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarReserva();
                    break;
                case 2:
                    buscarReserva();
                    break;
                case 3:
                    buscarTodasReservas();
                    break;
                case 4:
                    deletarReserva();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 5);
    }

    private static void cadastrarReserva() {
        System.out.print("Digite o ID do Pacote: ");
        int idPacote = scanner.nextInt();
        scanner.nextLine();
        Pacote pacote = PacoteController.buscarPacote(idPacote);

        System.out.print("Digite o ID do Cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = ClienteController.buscarCliente(idCliente);

        Reserva novaReserva = new Reserva(cliente, pacote);
        ReservaController.salvarReserva(novaReserva);

        System.out.println("\nReserva cadastrada com sucesso.\n");
    }

    private static void buscarReserva() {
        System.out.println("Digite o ID da Reserva para buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(ReservaController.buscarReserva(id));
    }

    private static void buscarTodasReservas() {
        System.out.println(ReservaController.buscarTodasReservas());
    }

    private static void deletarReserva() {
        System.out.println("Digite o ID da reserva para deletar do sistema: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        ReservaController.excluirReserva(id);
        System.out.println("\nReserva excluída com sucesso.\n");
    }

}
