package modelo;

public class Cliente {
    private String nome;
    private String telefone;
    private String infoAdicional;

    // Construtor
    public Cliente(String nome, String telefone, String infoAdicional) {
        this.nome = nome;
        this.telefone = telefone;
        this.infoAdicional = infoAdicional;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    // Método para representar o cliente como String
    @Override
    public String toString() {
        return "Cliente: " + nome + ", Telefone: " + telefone + ", Informações: " + infoAdicional;
    }
}
