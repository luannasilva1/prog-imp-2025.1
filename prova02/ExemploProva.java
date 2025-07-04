
import java.util.Scanner;

public class ExemploProva {
    
    public static Scanner input = new Scanner(System.in);
    public static final int TAM = 100;
    public static void main(String[] args) {
        Categoria[] categorias = new Categoria[TAM];
        Product[] produtos = new Product[TAM];
        int qtdCategorias = 0;
        int qtdProdutos = 0;
        System.out.println("\n--- Cadastro de Categorias ---\n");
        qtdCategorias = cadastrarCategoria(categorias, qtdCategorias);
        System.out.println("\n--- Listagem de Categorias ---\n");
        imprimirCategorias(categorias, qtdCategorias);
        System.out.println("\n--- Cadastro de Produtos ---\n");
        qtdProdutos = cadastrarProduto(produtos,qtdProdutos, categorias, qtdCategorias);
        System.out.println("\n--- Listagem de produtos ---\n");
        input.nextLine();
        imprimirProdutos(produtos, qtdProdutos, categorias, qtdCategorias);
        bubbleSortPorDescricao(produtos, qtdProdutos);
        System.out.println("");
        System.out.print("Digite uma descrição para busca: ");
        String busca = input.nextLine();
        buscaBinariaPorDescricao(produtos, qtdProdutos, busca);
    }

    public static int cadastrarCategoria(Categoria[] v, int qtd) {
        if (qtd >= TAM) {
            System.out.println("Limite de categorias Atingido!");
            return qtd;
        }

        System.out.print("Codigo da Categoria: ");
        int codigo = input.nextInt();
        input.nextLine();

        for (int i = 0; i < qtd; i++) {
            if (v[i].codigo == codigo) {
                System.out.println("Código já existente!");
                return qtd;
            }
        }

        System.out.print("Nome da catégoria: ");
        String nome = input.nextLine();

        v[qtd] = new Categoria();
        v[qtd].codigo = codigo;
        v[qtd].nome = nome;

        return qtd + 1;
    }

    public static void imprimirCategorias(Categoria[] v, int qtd) {
        for (int i = 0; i < qtd; i++) {
            System.out.printf("(Código: %d, Nome: %s)\n",
                v[i].codigo,v[i].nome);
        }
    }

    public static int cadastrarProduto(Product[] vp, int qtdProdutos, Categoria[] vc, int qtdCategorias) {
        if (qtdProdutos >= TAM) {
            System.out.println("Limite de produtos atingido!");
            return qtdProdutos;
        }

        System.out.print("Código do produto: ");
        int codigo = input.nextInt();
        input.nextLine(); // Limpa buffer

        System.out.print("Título: ");
        String titulo = input.nextLine();

        System.out.print("Descrição: ");
        String descricao = input.nextLine();

        // Lista categorias disponíveis
        System.out.println("Categorias disponíveis:");
        for (int i = 0; i < qtdCategorias; i++) {
            System.out.println(vc[i].codigo + " - " + vc[i].nome);
        }

        System.out.print("Código da categoria: ");
        int codCategoria = input.nextInt();

        System.out.print("Preço (em centavos, ex: 1000 = R$10.00): ");
        int preco = input.nextInt();

        vp[qtdProdutos] = new Product();
        vp[qtdProdutos].codigo = codigo;
        vp[qtdProdutos].titulo = titulo;
        vp[qtdProdutos].descricao = descricao;
        vp[qtdProdutos].categoria = codCategoria;
        vp[qtdProdutos].preco = preco;

        return qtdProdutos + 1;
    }

    public static void imprimirProdutos(Product[] vp, int qtdProdutos, Categoria[] vc, int qtdCategorias) {
        for (int i = 0; i < qtdProdutos; i++) {
            Product p = vp[i];

            String nomeCategoria = "Não Encontrada";
            for (int j = 0; j < qtdCategorias; j++) {
                if (vc[j].codigo == p.categoria) {
                    nomeCategoria = vc[j].nome;
                    break;
                }
            }

            double precoReais = p.preco / 100.0;

            System.out.printf("Código: %d | Título: %s | Descrição: %s | Categoria: %s | Preço: R$ %.2f%n",
                            p.codigo, p.titulo, p.descricao, nomeCategoria, precoReais);
        }
    }

    public static void bubbleSortPorDescricao (Product[] vp, int qtd) {
        Product aux;
        boolean trocou;
        for (int i = 0; i < qtd - 1; i ++) {
            trocou = false;
            for (int j = 0; j < qtd - 1 - i; j++) {
                if (vp[j].descricao.compareToIgnoreCase(vp[j+1].descricao) > 0) {
                    aux = vp[j];
                    vp[j] = vp[j+1];
                    vp[j+1] = aux;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }

    public static void buscaBinariaPorDescricao(Product[] v, int qtd, String x) {
        int inicio = 0;
        int fim = qtd - 1;
        int meio;
        boolean encontrou = false;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            int comparacao = x.compareToIgnoreCase(v[meio].descricao);
            if (comparacao == 0) {
                encontrou = true;
                System.out.println("Produto Encontrado na Posição: " + meio);
                System.out.printf("(Código: %d | Título: %s | Descrição: %s | Categoria: %d | Preço: R$ %.2f)%n",
                                 v[meio].codigo, v[meio].titulo,v[meio].descricao, v[meio].categoria, v[meio].preco / 100.0);
                break;
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }

        }
        if (!encontrou) {
            System.out.println("Produto com Descrição '" + x + "' Não Encontrado.");
        }
    }
}
