package calculator;

import java.util.Stack;

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

  public void addNumberToHistory(double value) {
    this.numbersHistory.push(value);
  }

  public void calculate() throws Exception {

    // 1- verificar se existe um operador selecionado
    // 2- limpar o operador depois do calculo

    int sizeNumbersHistory = this.numbersHistory.size();

    if (sizeNumbersHistory < 2) {
      throw new Exception("Emitir erro pq tem numeros insuficientes na pilha");
    }
    if (!(this.operator instanceof Operator)) {
      throw new Exception("é preciso ser definido um operador válido");
    }

    double number1 = this.numbersHistory.pop();
    double number2 = this.numbersHistory.pop();
    double result = this.operator.calculate(number1, number2);

    this.operator = null;
    this.numbersHistory.push(result);

  }

}
