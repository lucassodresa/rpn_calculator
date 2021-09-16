package calculator;

import java.util.Stack;
import java.util.Arrays;

public class Calculator {
  private Stack<Double> numbersHistory;
  private Operator operator;
  private String textField;

  public Stack<Double> getNumbersHistory() {
    return this.numbersHistory;
  }

  public Operator getOperator() {
    return this.operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public String getTextField() {
    return this.textField;
  }

  public void setTextField(String textField) {
    this.textField = textField;
  }

  public void addNumberToTextField(String value) {
    String textFieldValue = this.getTextField();
    String newTextFieldValue = textFieldValue.concat(value);
    this.setTextField(newTextFieldValue);
  }

  public void removeLastNumberToTextField() {
    String textFieldValue = this.getTextField();
    int textFieldTam = textFieldValue.length();

    if (textFieldTam > 0) {
      String newTextFieldValue = textFieldValue.substring(0, textFieldTam - 1);
      this.setTextField(newTextFieldValue);
    }

  }

  public Calculator() {
    this.numbersHistory = new Stack<Double>();
    this.operator = null;
    this.textField = "";
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

    if (isOperation(input)) {

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
    } else if (isNumeric(input)) {
      Double number = Double.parseDouble(input);
      this.addNumberToHistory(number);
    } else if ("exit".equals(input)) {
      System.out.println("Bye...");
      System.exit(0);
    } else if ("clear".equals(input)) {
      this.numbersHistory = new Stack<Double>();
    } else {
      throw new Exception("Caracter inválido");
    }
  }
}
