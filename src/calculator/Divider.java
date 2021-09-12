package calculator;

public class Divider extends Operator {
  @Override
  public double calculate(double number1, double number2) throws Exception {
    if (number2 == 0) {
      throw new Exception("Impossível dividir por zero");
    }

    return number1 / number2;
  }
}
