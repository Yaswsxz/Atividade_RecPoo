import java.time.LocalDate;

/**
 * Representa a saída de alimentos para uma família ou instituição.
 */
public class Distribuicao {

    private int id;
    private Alimento alimento;
    private double quantidade;
    private LocalDate data;
    private String beneficiario;

    public Distribuicao(int id, Alimento alimento, double quantidade, LocalDate data, String beneficiario) {
        this.id = id;
        this.alimento = alimento;
        this.quantidade = quantidade;
        this.data = data;
        this.beneficiario = beneficiario;
    }

    public boolean processar(Estoque estoque) {
        // Validações exigidas ANTES de reduzir o estoque
        if (quantidade <= 0) {
            System.out.println("ERRO: a quantidade distribuída deve ser maior que zero.");
            return false;
        }
        if (alimento.estaVencido()) {
            System.out.println("ERRO: não é permitido distribuir alimento vencido.");
            return false;
        }
        if (estoque.getAlimento() != alimento) {
            System.out.println("ERRO: o estoque informado não corresponde a este alimento.");
            return false;
        }
        if (quantidade > estoque.getQuantidade()) {
            System.out.println("ERRO: quantidade insuficiente em estoque.");
            return false;
        }

        // Colaboração: a distribuição pede ao estoque a baixa
        if (estoque.registrarDistribuicao(quantidade)) {
            System.out.println("Distribuição realizada com sucesso.");
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public String getBeneficiario() {
        return beneficiario;
    }
}