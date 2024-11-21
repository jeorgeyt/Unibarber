package repository;

import java.util.ArrayList;
import java.util.List;
import modelo.Servico;

public class ServicoRepository {
    private final List<Servico> servicos = new ArrayList<>();

    // Adiciona um serviço ao repositório
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    // Remove um serviço do repositório
    public void removerServico(Servico servico) {
        servicos.remove(servico);
    }

    // Retorna a lista de todos os serviços
    public List<Servico> listarServicos() {
        return servicos;
    }
}
