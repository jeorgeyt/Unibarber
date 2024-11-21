package modelo;


public class Servico {
    private String nome;
    private double preco;
    private int duracao; // duração em minutos

    // Construtor
    public Servico(String nome, double preco, int duracao) {
        this.nome = nome;
        this.preco = preco;
        this.duracao = duracao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    // Método toString para exibir o serviço como String
    @Override
    public String toString() {
        return "Serviço: " + nome + ", Preço: R$ " + preco + ", Duração: " + duracao + " minutos";
    }
}
