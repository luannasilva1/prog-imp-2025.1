import java.util.Scanner;
public class Exemplo05Ordenacao {
    public static Scanner sc = new Scanner(System.in);

    public static void preencherVetor(int[] v, int n) {
        for(int i=0; i<n; i++){
            v[i] = sc.nextInt();
        }
    }
    public static void imprimirVetor (int[] v, int n) {
        for(int i=0; i<n; i++){
            System.out.println(v[i]);
        }
    }
    public static void metodoBolha(int []v, int n) {
        
    }



     public static boolean estaOrdenado(double[] v) {
        boolean result = true;
        // testando se o vetor está ordenado de forma crescente
        for (int i = 1; i < v.length; i += 1) {
            if (v[i] < v[i - 1]) {
                result = false;
                break;
            }
        }
        if (result) {
            return true;
        }
        // testando se o vetor está ordenado de forma decrescente
        for (int i = 1; i < v.length; i += 1) {
            if (v[i] > v[i - 1]) {
                return false;
            }
        }






    public static void main(String[] args){
        int[] vetor = new int[5];
        preencherVetor(vetor,5);
        imprimirVetor (vetor, 2);

    }






}