/**
 * Controla o saldo de um alimento.
 * Responsabilidade: garantir que a quantidade nunca fique negativa.
 *
 * Não existe setQuantidade(): a quantidade só muda pelas operações
 * de negócio abaixo, que validam os valores antes de alterar o estado.
 */
public class Estoque {

    private Alimento alimento;
    private double quantidade;

    // O estoque sempre começa zerado; só cresce por entradas válidas
    public Estoque(Alimento alimento) {
        this.alimento = alimento;
        this.quantidade = 0;
    }

    public boolean registrarEntrada(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("ERRO: a quantidade de entrada deve ser maior que zero.");
            return false;
        }
        this.quantidade += quantidade;
        return true;
    }

    public boolean registrarDistribuicao(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("ERRO: a quantidade distribuída deve ser maior que zero.");
            return false;
        }
        if (quantidade > this.quantidade) {
            System.out.println("ERRO: quantidade insuficiente em estoque.");
            return false;
        }
        this.quantidade -= quantidade;
        return true;
    }

    public boolean registrarPerda(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("ERRO: a quantidade perdida deve ser maior que zero.");
            return false;
        }
        if (quantidade > this.quantidade) {
            System.out.println("ERRO: a perda não pode ser maior que o estoque disponível.");
            return false;
        }
        this.quantidade -= quantidade;
        return true;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public Alimento getAlimento() {
        return alimento;
    }
}