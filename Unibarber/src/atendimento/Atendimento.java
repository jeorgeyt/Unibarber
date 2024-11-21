package atendimento;

import java.time.LocalDateTime;
import modelo.Agendamento;
import modelo.Barbeiro;
import modelo.Cliente;
import modelo.Servico;
import repository.AgendamentoRepository;

public class Atendimento {
    private final AgendamentoRepository agendamentoRepository;

    // Construtor
    public Atendimento(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    // Método para criar um agendamento
    public boolean criarAgendamento(Cliente cliente, Barbeiro barbeiro, Servico servico, LocalDateTime dataHora) {
        Agendamento agendamento = new Agendamento(cliente, barbeiro, servico, dataHora);

        // Tenta adicionar o agendamento no repositório
        if (agendamentoRepository.adicionarAgendamento(agendamento)) {
            System.out.println("Agendamento criado com sucesso para " + cliente.getNome() +
                    " com o barbeiro " + barbeiro.getNome() + " em " + dataHora);
            return true;
        } else {
            System.out.println("Não foi possível criar o agendamento para " + cliente.getNome() +
                    ". Limite diário de atendimentos atingido para o barbeiro " + barbeiro.getNome() + ".");
            return false;
        }
    }

    // Método para listar todos os agendamentos
    public void listarAgendamentos() {
        agendamentoRepository.listarAgendamentos().forEach(System.out::println);
    }

    // Método para listar agendamentos por data
    public void listarAgendamentosPorData(LocalDateTime data) {
        agendamentoRepository.listarAgendamentosPorData(data.toLocalDate()).forEach(System.out::println);
    }
}
