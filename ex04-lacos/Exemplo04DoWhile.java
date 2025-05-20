import java.util.Scanner;

public class Exemplo04DoWhile{
    public static Scanner sc = new Scanner(System.in);

    public static void main (String args []){
        int num1, num2, qtdInterv;

        System.out.print("Digite um número inteiro: ");
        num1 = sc.nextInt();
        
        do {
            System.out.print("Digite um número inteiro maior que " + num1);
            num2 = sc.nextInt();
            if(num2 <= num1){
                System.out.println("número inmválido!");
            }
        } while(num2 <= num1);

        qtdInterv = num2 - num1  + 1;
        System.out.println("Existem " + qtdInterv + " números no intervalo de " +
        num1 + " a " + num2);

    }
}