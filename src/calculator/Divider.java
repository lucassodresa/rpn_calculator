package calculator;

public class Divider extends Operator {
  @Override
  public double calculate(double number1, double number2) {
    // fazer validacoes de criterios de divisibilidades
    // eg. um number não pode ser dividido por 0
    return number1 / number2;
  }
}
