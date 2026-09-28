import java.time.LocalDate;

/**
 * Classe principal: executa o cenário obrigatório de teste
 * e a demonstração de identidade e referências.
 */
public class Main {

    public static void main(String[] args) {

        String linha = "========================================";
        System.out.println(linha);
        System.out.println(" SISTEMA BANCO DE ALIMENTOS");
        System.out.println(linha);

        // 1. Criar o alimento Arroz com estoque inicial de 0 kg
        //    (instanciação com o operador new)
        Alimento arroz = new Alimento(1, "Arroz", "Grãos", LocalDate.now().plusMonths(6));
        Estoque estoqueArroz = new Estoque(arroz); // começa com 0 kg

        // 2. Criar o doador Supermercado Esperança
        Doador supermercado = new Doador(1, "Supermercado Esperança",
                "12.345.678/0001-90", "(43) 3333-4444");

        System.out.println("Doador: " + supermercado.getNome());
        System.out.println("Produto: " + arroz.getNome());

        // 3. Registrar e processar uma doação de 100 kg -> estoque 100 kg
        Doacao doacao = new Doacao(1, supermercado, arroz, 100, LocalDate.now());
        System.out.println("Doação recebida: " + doacao.getQuantidade() + " kg");
        doacao.processar(estoqueArroz);
        System.out.println("Estoque atual: " + estoqueArroz.getQuantidade() + " kg");
        System.out.println();

        // 4. Distribuição de 30 kg -> estoque 70 kg
        Distribuicao dist1 = new Distribuicao(1, arroz, 30, LocalDate.now(), "Família Silva");
        System.out.println("Distribuição solicitada: " + dist1.getQuantidade() + " kg");
        dist1.processar(estoqueArroz);
        System.out.println("Estoque atual: " + estoqueArroz.getQuantidade() + " kg");
        System.out.println();

        // 5. Perda de 5 kg por embalagem danificada -> estoque 65 kg
        Perda perda = new Perda(1, arroz, 5, "Embalagem danificada", LocalDate.now());
        perda.processar(estoqueArroz);
        System.out.println("Estoque atual: " + estoqueArroz.getQuantidade() + " kg");
        System.out.println();

        // 6. Tentar distribuir 80 kg -> deve ser rejeitado (só há 65 kg)
        Distribuicao dist2 = new Distribuicao(2, arroz, 80, LocalDate.now(), "Instituição Lar Feliz");
        System.out.println("Distribuição solicitada: " + dist2.getQuantidade() + " kg");
        boolean ok = dist2.processar(estoqueArroz);

        // 7. Confirmar que o estoque final permanece em 65 kg
        if (!ok) {
            System.out.println("Estoque permanece: " + estoqueArroz.getQuantidade() + " kg");
        }
        System.out.println(linha);

        // Teste extra: a mesma doação não pode ser processada duas vezes
        System.out.println("Tentando processar a mesma doação novamente...");
        doacao.processar(estoqueArroz);
        System.out.println("Estoque atual: " + estoqueArroz.getQuantidade() + " kg");
        System.out.println(linha);

        // ===== Demonstração de identidade e referências =====
        System.out.println(" IDENTIDADE E REFERÊNCIAS");
        System.out.println(linha);

        LocalDate validade = LocalDate.now().plusMonths(6);
        Alimento arroz1 = new Alimento(10, "Arroz", "Grãos", validade);
        Alimento arroz2 = new Alimento(10, "Arroz", "Grãos", validade);
        Alimento arroz3 = arroz1;

        // FALSE: arroz1 e arroz2 foram criados com dois "new" diferentes.
        // Mesmo tendo o mesmo estado (mesmos valores nos atributos), são
        // dois objetos distintos na memória, cada um com sua identidade.
        // O operador == compara as referências (endereços), não o conteúdo.
        System.out.println("arroz1 == arroz2: " + (arroz1 == arroz2));

        // TRUE: arroz3 não criou um objeto novo (não houve "new").
        // Ele apenas recebeu a mesma referência de arroz1, então as duas
        // variáveis apontam para o MESMO objeto na memória.
        System.out.println("arroz1 == arroz3: " + (arroz1 == arroz3));

        System.out.println(linha);
    }
}