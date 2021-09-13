package calculator;

public class Divider extends Operator {
  @Override
  public double calculate(double number1, double number2) throws Exception {
    if (number1 == 0) {
      throw new Exception("Impossível dividir por zero");
    }

    return number2 / number1;
  }
}
