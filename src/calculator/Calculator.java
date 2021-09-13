package calculator;

import java.util.Stack;
import java.util.Arrays;

public class Calculator {
  private Stack<Double> numbersHistory;
  private Operator operator;

  public Stack<Double> getNumbersHistory() {
    return this.numbersHistory;
  }

  public Operator getOperator() {
    return this.operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator; // fazer clone da classe
  }

  public Calculator() {
    this.numbersHistory = new Stack<Double>();
    this.operator = null;
  }

  private void addNumberToHistory(double value) {
    this.numbersHistory.push(value);
  }

  private void calculate() throws Exception {
    int sizeNumbersHistory = this.numbersHistory.size();

    if (sizeNumbersHistory < 2) {
      throw new Exception("Emitir erro pq tem numeros insuficientes na pilha");
    }
    if (!(this.operator instanceof Operator)) {
      throw new Exception("é preciso ser definido um operador válido");
    }

    double number1 = this.numbersHistory.pop();
    double number2 = this.numbersHistory.pop();

    try {
      double result = this.operator.calculate(number1, number2);
      this.operator = null;
      this.numbersHistory.push(result);
    } catch (Exception error) {
      this.numbersHistory.push(number2);
      this.numbersHistory.push(number1);

      throw new Exception(error);
    }
  }

  private boolean isOperation(String valueToVerify) {
    String[] values = { "+", "-", "*", "/" };
    boolean contains = Arrays.stream(values).anyMatch(valueToVerify::equals);

    return contains;
  }

  private boolean isNumeric(String valueToVerify) {
    return valueToVerify.matches("-?\\d+(\\.\\d+)?");
  }

  public void addInput(String input) throws Exception {

    if (isOperation(input)) { // is operation

      switch (input) {
        case "+":
          this.setOperator(new Adder());
          break;
        case "-":
          this.setOperator(new Subtracter());
          break;
        case "*":
          this.setOperator(new Multiplier());
          break;
        case "/":
          this.setOperator(new Divider());
          break;
        default:
          this.setOperator(null);
          break;
      }

      this.calculate();

      // System.out.println("é uma operação");
    }

    else if (isNumeric(input)) { // is number [done]
      Double number = Double.parseDouble(input);
      this.addNumberToHistory(number);
    }

    else {
      throw new Exception("Caracter inválido");
    }

    // if (input) { // is special button
    // System.out.println("é um botao especial");
    // }

  }

}
