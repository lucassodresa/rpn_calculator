import calculator.Adder;
import calculator.Calculator;
import calculator.Divider;
import calculator.Multiplier;
import calculator.Subtracter;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            Calculator calculadora = new Calculator();
            Adder adicao = new Adder();
            Subtracter subtracao = new Subtracter();
            Multiplier multiplicacao = new Multiplier();
            Divider divisao = new Divider();

            calculadora.addNumberToHistory(5);
            calculadora.addNumberToHistory(6);

            calculadora.setOperator(adicao);
            calculadora.calculate();

            System.out.println(calculadora.getNumbersHistory());
        } catch (Exception error) {
            System.out.println(error);

        }

    }
}
