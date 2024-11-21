package repository;

import java.util.ArrayList;
import java.util.List;
import modelo.Barbeiro;




public class BarbeiroRepository {
    private final List<Barbeiro> barbeiros = new ArrayList<>();

    // Adiciona um barbeiro ao repositório
    public void adicionarBarbeiro(Barbeiro barbeiro) {
        barbeiros.add(barbeiro);
    }

    // Remove um barbeiro do repositório
    public void removerBarbeiro(Barbeiro barbeiro) {
        barbeiros.remove(barbeiro);
    }

    // Retorna a lista de todos os barbeiros
    public List<Barbeiro> listarBarbeiros() {
        return barbeiros;
    }
}
