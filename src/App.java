import java.util.Scanner;
import calculator.Calculator;

public class App {

  public final static void clearConsole() {
    try {
      final String os = System.getProperty("os.name");

      if (os.contains("Windows")) {
        Runtime.getRuntime().exec("cls");
      } else {
        Runtime.getRuntime().exec("clear");
      }
    } catch (final Exception e) {
      // Handle any exceptions.
    }
  }

  public static void main(String[] args) throws Exception {

    Scanner keyboard = new Scanner(System.in);
    Calculator calculadora = new Calculator();

    while (true) {
      System.out.println(calculadora.getNumbersHistory());
      System.out.print("Insira um valor -> ");
      String input = keyboard.next();
      clearConsole();

      try {

        calculadora.addInput(input);

      } catch (Exception error) {
        System.out.println(error);
      }
    }

  }
}
