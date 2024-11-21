package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Agendamento;
import modelo.Barbeiro;




public class AgendamentoRepository {
    private final List<Agendamento> agendamentos = new ArrayList<>();

    // Adiciona um agendamento se o limite diário do barbeiro não foi atingido
    public boolean adicionarAgendamento(Agendamento agendamento) {
        Barbeiro barbeiro = agendamento.getBarbeiro();
        LocalDate data = agendamento.getDataHora().toLocalDate();

        long atendimentosDoDia = agendamentos.stream()
                .filter(a -> a.getBarbeiro().equals(barbeiro) && a.getDataHora().toLocalDate().equals(data))
                .count();

        if (atendimentosDoDia < barbeiro.getLimiteDiarioAtendimentos()) {
            agendamentos.add(agendamento);
            return true;
        } else {
            System.out.println("Limite diário de atendimentos para o barbeiro " + barbeiro.getNome() + " foi atingido.");
            return false;
        }
    }

    // Lista todos os agendamentos
    public List<Agendamento> listarAgendamentos() {
        return agendamentos;
    }

    // Lista agendamentos para uma data específica
    public List<Agendamento> listarAgendamentosPorData(LocalDate data) {
        return agendamentos.stream()
                .filter(a -> a.getDataHora().toLocalDate().equals(data))
                .collect(Collectors.toList());
    }

}
