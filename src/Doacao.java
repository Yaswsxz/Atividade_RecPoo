import java.time.LocalDate;

/**
 * Representa uma doação recebida de um doador.
 * Colaboração: usa Doador, Alimento e Estoque para cumprir seu papel.
 */
public class Doacao {

    private int id;
    private Doador doador;
    private Alimento alimento;
    private double quantidade;
    private LocalDate data;
    private boolean processada;

    public Doacao(int id, Doador doador, Alimento alimento, double quantidade, LocalDate data) {
        this.id = id;
        this.doador = doador;
        this.alimento = alimento;
        this.quantidade = quantidade;
        this.data = data;
        this.processada = false; // toda doação nasce não processada
    }

    public boolean processar(Estoque estoque) {
        // Regra: a mesma doação não pode ser processada duas vezes
        if (processada) {
            System.out.println("ERRO: esta doação já foi processada.");
            return false;
        }
        if (quantidade <= 0) {
            System.out.println("ERRO: a quantidade doada deve ser maior que zero.");
            return false;
        }
        if (alimento.estaVencido()) {
            System.out.println("ERRO: não é possível receber alimento vencido.");
            return false;
        }
        // Identidade: o estoque precisa ser do MESMO objeto alimento da doação
        if (estoque.getAlimento() != alimento) {
            System.out.println("ERRO: o estoque informado não corresponde a este alimento.");
            return false;
        }

        // Colaboração: a doação pede ao estoque que registre a entrada
        if (estoque.registrarEntrada(quantidade)) {
            processada = true;
            System.out.println("Doação processada com sucesso.");
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public Doador getDoador() {
        return doador;
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

    public boolean isProcessada() {
        return processada;
    }
}