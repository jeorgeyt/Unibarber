package repository;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();

    // Adiciona um cliente ao repositório
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Remove um cliente do repositório
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    // Retorna a lista de todos os clientes
    public List<Cliente> listarClientes() {
        return clientes;
    }
}

