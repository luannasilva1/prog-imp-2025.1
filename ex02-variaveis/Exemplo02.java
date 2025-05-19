import java.util.Scanner;
public class Exemplo02 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        int num1 = 10, num2;
        double num3 = 3.15, num4;

        System.out.println("Digite um número inteiro");
        num2 = sc.nextInt();

        System.out.println("Digite um número decimal");
        num4 = sc.nextDouble();


        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);

    }
    
}
