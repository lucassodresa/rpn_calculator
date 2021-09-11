package calculator;

public class Subtracter extends Operator {
  @Override
  public double calculate(double number1, double number2) {
    return number1 - number2;
  }
}
