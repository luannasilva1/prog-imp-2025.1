import java.util.Scanner;

public class ResolucaoProva {

    public static Scanner sc = new Scanner(System.in);

    public static class Pessoa {
        String nome;
        int idade;
        double altura;
        int peso;
        double imc;
    }

    public static int CadastrarPessoas(Pessoa[] v, int qtd) {
        int TAM = 100;
        if (qtd >= TAM) {
            System.out.println("Limite atingido!");
            return qtd;
        }

        String nome;
        do {
            System.out.println("Digite o nome da pessoa: ");
            nome = sc.nextLine();
        } while (BuscarPorNome(v, qtd, nome) != -1);

        System.out.println("Digite a idade da pessoa:");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite a altura da pessoa (ex: 1.70):");
        double altura = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite o peso da pessoa:");
        int peso = sc.nextInt();
        sc.nextLine();

        v[qtd] = new Pessoa();
        v[qtd].nome = nome;
        v[qtd].idade = idade;
        v[qtd].altura = altura;
        v[qtd].peso = peso;

        return qtd + 1;
    }

    public static int BuscarPorNome(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    public static void CalcularIMC(Pessoa[] v, int qtd) {
        for (int i = 0; i < qtd; i++) {
            double imc = v[i].peso / (v[i].altura * v[i].altura);
            v[i].imc = imc;
        }
    }

    public static void ImprimirPessoas(Pessoa[] v, int qtd) {
        for (int i = 0; i < qtd; i++) {
            System.out.printf("Nome: %s | IMC: %.2f\n", v[i].nome, v[i].imc);
        }
    }

    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[100];
        int qtd = 0;

        System.out.println("Quantas pessoas deseja cadastrar?");
        int total = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < total; i++) {
            qtd = CadastrarPessoas(pessoas, qtd);
        }

        CalcularIMC(pessoas, qtd);
        ImprimirPessoas(pessoas, qtd);
    }
}
