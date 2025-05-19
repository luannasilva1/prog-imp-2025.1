import java.util.Scanner;

public class Exemplo03 {
    public static Scanner sc = new Scanner(System.in);

    public static void main (String args[]){
        int num;
        System.out.print("Digite um número: ");
         num = sc.nextInt();
        System.out.println("Você digitou o número " + num);
         if( num < 0){
        System.out.println(num + " é negativo"); 
         }
         else if(num == 0){
        System.out.println(num + " é nulo");
         }
        else{
        System.out.println(num + " é positivo");
        }

    }

}