/**
 * Representa quem faz a doação (empresa ou pessoa).
 * Responsabilidade: guardar e exibir os dados do doador.
 */
public class Doador {

    // Estado (atributos privados = encapsulamento)
    private int id;
    private String nome;
    private String documento;
    private String telefone;

    // Construtor: define o estado inicial do objeto
    public Doador(int id, String nome, String documento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }

    // Comportamento: exibe os dados do doador
    public void exibirDados() {
        System.out.println("Doador: " + nome);
        System.out.println("Documento: " + documento + " | Telefone: " + telefone);
    }

    // Comportamento: alteração controlada do telefone (com validação)
    public boolean atualizarTelefone(String novoTelefone) {
        if (novoTelefone == null || novoTelefone.isBlank()) {
            System.out.println("ERRO: telefone inválido.");
            return false;
        }
        this.telefone = novoTelefone;
        return true;
    }

    // Getters: apenas consulta, sem setters desnecessários
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }
}