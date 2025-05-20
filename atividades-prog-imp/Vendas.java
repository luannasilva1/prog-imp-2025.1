import java.util.Scanner;
public class Vendas {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
    Produto p1 = new Produto(), p2 = new Produto();
    System.out.println("-------DIGITAÇÃO DADOS PRODUTO 1-------");
    lerProduto(p1);
    System.out.println("-------DIGITAÇÃO DADOS PRODUTO 2-------");
    lerProduto(p2);
    
    System.out.println("-------IMPRESSÃO-------");
    exibirProduto(p1);
    exibirProduto(p2);

    }
    

    public static void lerProduto(Produto p){
        System.out.print("Digite o título: ");
        p.titulo = sc.nextLine();
        System.out.print("Digite o descrição: ");
        p.descricao = sc.nextLine();
        System.out.print("Digite o preço unitário: ");
        p.precoUnitario = sc.nextDouble();
        System.out.print("Digite o estoque: ");
        p.estoque = sc.nextInt();
        sc.nextLine();
    }
    
    public static void exibirProduto(Produto p) {
    System.out.println(p.titulo + " | " + p.descricao + " | " +
                       p.precoUnitario + " | " + p.estoque);
}

}
