
import atendimento.Atendimento;
import java.time.LocalDateTime;
import java.util.Scanner;
import modelo.*;
import repository.*; // "*:"" importa automaticamento todos do pct de repository e modelo

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializando repositórios e serviços
        ClienteRepository clienteRepo = new ClienteRepository();
        BarbeiroRepository barbeiroRepo = new BarbeiroRepository();
        ServicoRepository servicoRepo = new ServicoRepository();
        AgendamentoRepository agendamentoRepo = new AgendamentoRepository();
        Atendimento agendamentoAtendimento = new Atendimento(agendamentoRepo);

        // Menu para interagir 
        while (true) {
            System.out.println("\n--- Unibarber ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Barbeiro");
            System.out.println("3. Adicionar Serviço");
            System.out.println("4. Criar Agendamento");
            System.out.println("5. Listar Agendamentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> {
                    // Adicionando um cliente
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Email do cliente: ");
                    String emailCliente = scanner.nextLine();
                    clienteRepo.adicionarCliente(new Cliente(nomeCliente, emailCliente, nomeCliente));
                    System.out.println("Cliente adicionado com sucesso!");
                }

                case 2 -> {
                    // Adicionando um barbeiro
                    System.out.print("Nome do barbeiro: ");
                    String nomeBarbeiro = scanner.nextLine();
                    System.out.print("Especialização do barbeiro: ");
                    String especializacao = scanner.nextLine();
                    System.out.print("Limite diário de atendimentos: ");
                    int limiteAtendimentos = scanner.nextInt();
                    scanner.nextLine();
                    barbeiroRepo.adicionarBarbeiro(new Barbeiro(nomeBarbeiro, especializacao, limiteAtendimentos));
                    System.out.println("Barbeiro adicionado com sucesso!");
                }

                case 3 -> {
                    // Adicionando um serviço
                    System.out.print("Nome do serviço: ");
                    String nomeServico = scanner.nextLine();
                    System.out.print("Preço do serviço: ");
                    double precoServico = scanner.nextDouble();
                    System.out.print("Duração do serviço (minutos): ");
                    int duracaoServico = scanner.nextInt();
                    scanner.nextLine();
                    servicoRepo.adicionarServico(new Servico(nomeServico, precoServico, duracaoServico));
                    System.out.println("Serviço adicionado com sucesso!");
                }

                case 4 -> {
                    //Esse trecho de código utiliza o Stream API do Java para buscar um cliente, agendamento, servico e um babeiro em uma lista de clientes com base no nome informado
                    // Criando um agendamento
                    System.out.print("Nome do cliente: ");
                    String nomeClienteAgendamento = scanner.nextLine();
                    Cliente cliente = clienteRepo.listarClientes().stream() 
                            .filter(c -> c.getNome().equals(nomeClienteAgendamento))
                            .findFirst().orElse(null); 

                    System.out.print("Nome do barbeiro: ");
                    String nomeBarbeiroAgendamento = scanner.nextLine();
                    Barbeiro barbeiro = barbeiroRepo.listarBarbeiros().stream()
                            .filter(b -> b.getNome().equals(nomeBarbeiroAgendamento))
                            .findFirst().orElse(null);

                    System.out.print("Nome do serviço: ");
                    String nomeServicoAgendamento = scanner.nextLine();
                    Servico servico = servicoRepo.listarServicos().stream()
                            .filter(s -> s.getNome().equals(nomeServicoAgendamento))
                            .findFirst().orElse(null);

                    System.out.print("Data e Hora do Agendamento (yyyy-MM-ddTHH:mm): ");
                    String dataHoraInput = scanner.nextLine();
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraInput);

                    if (cliente != null && barbeiro != null && servico != null) {
                        agendamentoAtendimento.criarAgendamento(cliente, barbeiro, servico, dataHora);
                    } else {
                        System.out.println("Cliente, barbeiro ou serviço não encontrado.");
                    }
                }

                case 5 -> {
                    // Listar todos os agendamentos
                    System.out.println("Lista de Agendamentos:");
                    agendamentoAtendimento.listarAgendamentos();
                }

                case 0 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
