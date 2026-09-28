import java.time.LocalDate;

/**
 * Representa a baixa de alimentos que não podem ser distribuídos
 * (produto vencido, embalagem danificada, contaminação, armazenamento...).
 */
public class Perda {

    private int id;
    private Alimento alimento;
    private double quantidade;
    private String motivo;
    private LocalDate data;

    public Perda(int id, Alimento alimento, double quantidade, String motivo, LocalDate data) {
        this.id = id;
        this.alimento = alimento;
        this.quantidade = quantidade;
        this.motivo = motivo;
        this.data = data;
    }

    public boolean processar(Estoque estoque) {
        if (motivo == null || motivo.isBlank()) {
            System.out.println("ERRO: informe o motivo da perda.");
            return false;
        }
        if (estoque.getAlimento() != alimento) {
            System.out.println("ERRO: o estoque informado não corresponde a este alimento.");
            return false;
        }
        // Quantidade > 0 e saldo suficiente são validados pelo próprio Estoque
        // Obs.: alimento vencido PODE ser registrado como perda (é um dos motivos).
        if (estoque.registrarPerda(quantidade)) {
            System.out.println("Perda registrada: " + quantidade + " kg");
            System.out.println("Motivo: " + motivo);
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

    public String getMotivo() {
        return motivo;
    }

    public LocalDate getData() {
        return data;
    }
}