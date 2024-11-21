package modelo;

import java.time.LocalDateTime;

public class Agendamento {
    private final Cliente cliente;
    private final Barbeiro barbeiro;
    private final Servico servico;
    private final LocalDateTime dataHora;

    // Construtor
    public Agendamento(Cliente cliente, Barbeiro barbeiro, Servico servico, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public Servico getServico() {
        return servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    // Método toString para exibir o agendamento como String
    @Override
    public String toString() {
        return "Agendamento{" +
                "Cliente=" + cliente.getNome() +
                ", Barbeiro=" + barbeiro.getNome() +
                ", Serviço=" + servico.getNome() +
                ", Data e Hora=" + dataHora +
                '}';
    }
}
