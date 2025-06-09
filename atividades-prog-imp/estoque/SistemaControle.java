package estoque;

import java.util.Scanner;

public class SistemaControle { 
    public static Scanner sc = new Scanner(System.in);
    public static Produto[] produtos = new Produto[3];
    public static int totalProdutos = 0;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE GERENCIAMENTO ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar");
            System.out.println("3 - Filtrar p/ categoria");
            System.out.println("4 - Ordenar");
            System.out.println("5 - Remover elemento");
            System.out.println("6 - Atualizar preço");
            System.out.println("7 - Informar subtotal do valor em estoque por categoria");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: cadastrarProduto(); break;
                case 2: listarProdutos(); break;
                case 3: filtrarPorCategoria(); break;
                case 4: ordenarProdutos(); break;
                case 5: removerProduto(); break;
                case 6: atualizarPreco(); break;
                case 7: subtotalPorCategoria(); break;
                case 0: System.out.println("Saindo do sistema..."); break;
                default: System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void cadastrarProduto() {
        if (totalProdutos >= produtos.length) {
            System.out.println("Erro: Limite de produtos atingido!");
            return;
        }

        Produto p = new Produto();

        System.out.print("Nome: ");
        p.nome = sc.nextLine();

        System.out.print("Quantidade em estoque: ");
        p.qtdEstoque = sc.nextInt();

        System.out.print("Preço unitário: ");
        p.precoUnitario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Categoria: ");
        p.categoria = sc.nextLine();

        System.out.print("Quantidade mínima: ");
        p.qtdMinima = sc.nextInt();
        sc.nextLine();

        produtos[totalProdutos] = p;
        totalProdutos++;
    }

    public static void listarProdutos() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        System.out.println("\n=== LISTA DE PRODUTOS ===");
        for (int i = 0; i < totalProdutos; i++) {
            Produto p = produtos[i];
            System.out.printf("(%s, %d unid., R$ %.2f, %s, mín: %d)\n",
                p.nome, p.qtdEstoque, p.precoUnitario, p.categoria, p.qtdMinima);
        }
    }

    public static void filtrarPorCategoria() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        System.out.print("Digite a categoria para filtrar: ");
        String categoriaFiltro = sc.nextLine();

        boolean encontrou = false;
        System.out.println("\n=== PRODUTOS DA CATEGORIA: " + categoriaFiltro + " ===");
        for (int i = 0; i < totalProdutos; i++) {
            Produto p = produtos[i];
            if (p.categoria.equalsIgnoreCase(categoriaFiltro)) {
                System.out.printf("(%s, %d unid., R$ %.2f, %s, mín: %d)\n",
                    p.nome, p.qtdEstoque, p.precoUnitario, p.categoria, p.qtdMinima);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto encontrado na categoria: " + categoriaFiltro);
        }
    }

    public static void ordenarProdutos() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        for (int i = 0; i < totalProdutos - 1; i++) {
            for (int j = 0; j < totalProdutos - 1 - i; j++) {
                if (produtos[j].nome.compareToIgnoreCase(produtos[j + 1].nome) > 0) {
                    Produto temp = produtos[j];
                    produtos[j] = produtos[j + 1];
                    produtos[j + 1] = temp;
                }
            }
        }

        System.out.println("Produtos ordenados por nome!");
        listarProdutos();
    }

    public static void removerProduto() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        System.out.println("\n=== PRODUTOS CADASTRADOS ===");
        for (int i = 0; i < totalProdutos; i++) {
            System.out.printf("%d. %s\n", i + 1, produtos[i].nome);
        }

        System.out.print("Digite o número do produto a ser removido: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine();

        if (indice < 0 || indice >= totalProdutos) {
            System.out.println("Produto inválido!");
            return;
        }

        String nomeRemovido = produtos[indice].nome;

        for (int i = indice; i < totalProdutos - 1; i++) {
            produtos[i] = produtos[i + 1];
        }

        totalProdutos--;
        System.out.println("Produto '" + nomeRemovido + "' removido com sucesso!");
    }

    public static void atualizarPreco() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        System.out.println("\n=== PRODUTOS CADASTRADOS ===");
        for (int i = 0; i < totalProdutos; i++) {
            System.out.printf("%d. %s - R$ %.2f\n", i + 1, produtos[i].nome, produtos[i].precoUnitario);
        }

        System.out.print("Digite o número do produto para atualizar o preço: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine();

        if (indice < 0 || indice >= totalProdutos) {
            System.out.println("Produto inválido!");
            return;
        }

        System.out.printf("Preço atual de '%s': R$ %.2f\n", produtos[indice].nome, produtos[indice].precoUnitario);
        System.out.print("Digite o novo preço: ");
        double novoPreco = sc.nextDouble();
        sc.nextLine();

        produtos[indice].precoUnitario = novoPreco;
        System.out.printf("Preço do produto '%s' atualizado para R$ %.2f\n", produtos[indice].nome, novoPreco);
    }

    public static void subtotalPorCategoria() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        String[] categorias = new String[totalProdutos];
        int totalCategorias = 0;

        for (int i = 0; i < totalProdutos; i++) {
            String cat = produtos[i].categoria;
            boolean existe = false;

            for (int j = 0; j < totalCategorias; j++) {
                if (categorias[j].equalsIgnoreCase(cat)) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                categorias[totalCategorias] = cat;
                totalCategorias++;
            }
        }

        System.out.println("\n=== SUBTOTAL POR CATEGORIA ===");
        double totalGeral = 0;

        for (int i = 0; i < totalCategorias; i++) {
            String categoriaAtual = categorias[i];
            double subtotalCategoria = 0;

            System.out.println("\nCategoria: " + categoriaAtual);
            for (int j = 0; j < totalProdutos; j++) {
                if (produtos[j].categoria.equalsIgnoreCase(categoriaAtual)) {
                    double valorEstoque = produtos[j].qtdEstoque * produtos[j].precoUnitario;
                    System.out.printf("  %s - %d unid. - R$ %.2f\n",
                        produtos[j].nome, produtos[j].qtdEstoque, valorEstoque);
                    subtotalCategoria += valorEstoque;
                }
            }

            System.out.printf("Subtotal: R$ %.2f\n", subtotalCategoria);
            totalGeral += subtotalCategoria;
        }

        System.out.printf("\nTOTAL GERAL: R$ %.2f\n", totalGeral);
    }
}
