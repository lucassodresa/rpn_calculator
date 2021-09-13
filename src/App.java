import java.util.Scanner;
import calculator.Calculator;

public class App {

  public final static void clearConsole() {
    System.out.print("\033[H\033[2J");
  }

  public static void wait(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  public static void main(String[] args) throws Exception {

    Scanner keyboard = new Scanner(System.in);
    Calculator calculadora = new Calculator();

    while (true) {
      clearConsole();
      System.out.print("Valores Inseridos:\t");
      System.out.print(calculadora.getNumbersHistory());
      System.out.print("\n\n[exit] - p/ sair    [clear] - p/ limpar o histórico\n\n");

      System.out.print("Insira um valor -> ");
      String input = keyboard.next();

      try {
        calculadora.addInput(input);
      } catch (Exception error) {
        System.out.print("\nError: ");
        System.out.println(error);
        wait(3000);
      }
    }

  }
}
