package modelo;

public class Barbeiro {
    private String nome;
    private String especializacao;
    private int limiteDiarioAtendimentos;

    // Construtor
    public Barbeiro(String nome, String especializacao, int limiteDiarioAtendimentos) {
        this.nome = nome;
        this.especializacao = especializacao;
        this.limiteDiarioAtendimentos = limiteDiarioAtendimentos;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public int getLimiteDiarioAtendimentos() {
        return limiteDiarioAtendimentos;
    }

    public void setLimiteDiarioAtendimentos(int limiteDiarioAtendimentos) {
        this.limiteDiarioAtendimentos = limiteDiarioAtendimentos;
    }

    // Método toString para exibir o barbeiro como String
    @Override
    public String toString() {
        return "Barbeiro: " + nome + ", Especialização: " + especializacao +
               ", Limite Diário de Atendimentos: " + limiteDiarioAtendimentos;
    }
}
