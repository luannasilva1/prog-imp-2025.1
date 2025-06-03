import java.util.Scanner;

public class VetorAlunos {
  public static Scanner sc = new Scanner(System.in);
  public static final int QTD_ALUNOS = 4;

  public static void main(String[] args) {
    Aluno[] todos = new Aluno[QTD_ALUNOS];
    Aluno[] aprovados = new Aluno[QTD_ALUNOS];
    Aluno[] reprovados = new Aluno[QTD_ALUNOS];
    int qtdAprovados = 0, qtdReprovados = 0;

    for (int i = 0; i < QTD_ALUNOS; i++) {
      todos[i] = new Aluno();

      System.out.println("Digite o nome do aluno:");
      todos[i].nome = sc.nextLine();

      System.out.println("Digite a matrícula do aluno:");
      todos[i].matricula = sc.nextLine();

      System.out.println("Digite a média final do aluno:");
      todos[i].mediaFinal = sc.nextDouble();
      sc.nextLine();

      if (todos[i].mediaFinal >= 5.0) {
        aprovados[qtdAprovados] = todos[i];
        qtdAprovados++;
      } else {
        reprovados[qtdReprovados] = todos[i];
        qtdReprovados++;
      }
    }

    System.out.println("----- ALUNOS APROVADOS -----");
    for (int i = 0; i < qtdAprovados; i++) {
      System.out.println("Nome: " + aprovados[i].nome);
      System.out.println("Matrícula: " + aprovados[i].matricula);
      System.out.println("Média Final: " + aprovados[i].mediaFinal);
      System.out.println("----------------------------");
    }

    System.out.println("----- ALUNOS REPROVADOS -----");
    for (int i = 0; i < qtdReprovados; i++) {
      System.out.println("Nome: " + reprovados[i].nome);
      System.out.println("Matrícula: " + reprovados[i].matricula);
      System.out.println("Média Final: " + reprovados[i].mediaFinal);
      System.out.println("------------------------------");
    }
  }
}

    

