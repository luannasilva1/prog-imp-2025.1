import java.util.Scanner;
public class Exemplo04For {
    public static Scanner sc = new Scanner(System.in);
    public static void main (String[] args){
        int num1, num2, qtdInterv;

        System.out.print("Digite número inteiro");
        num1 = sc.nextInt();

        do {
            System.out.print("Digite um número inteiro maior que " + num1);
            num2 = sc.nextInt();
            if(num2 <= num1){
            System.out.println("Número inválido");
            }
        } while(num2 <= num1);

        qtdInterv = num2 - num1 + 1;
        System.out.println("Existem " + qtdInterv + " números no intervalo de " +
        num1 + " a " + num2);

        System.out.print("E esses números são: { " + num1);
        for(int i = num1 + 1; i <= num2; i++) {
         System.out.print(", " + i);
         }
        System.out.println(" }");

    }

}