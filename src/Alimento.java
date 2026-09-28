import java.time.LocalDate;

/**
 * Representa um alimento que o banco recebe e distribui.
 * Abstração: do mundo real, só interessam nome, categoria e validade.
 */
public class Alimento {

    private int id;
    private String nome;
    private String categoria;
    private LocalDate dataValidade;

    public Alimento(int id, String nome, String categoria, LocalDate dataValidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.dataValidade = dataValidade;
    }

    // Regra de negócio: compara a validade com a data atual do sistema
    public boolean estaVencido() {
        return LocalDate.now().isAfter(dataValidade);
    }

    public void exibirDados() {
        System.out.println("Produto: " + nome);
        System.out.println("Categoria: " + categoria + " | Validade: " + dataValidade
                + (estaVencido() ? " (VENCIDO)" : ""));
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
}