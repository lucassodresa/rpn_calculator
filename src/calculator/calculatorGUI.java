package calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class calculatorGUI extends JFrame {
    // criação de frame
    static JFrame f;

    // criação de textfield e panel
    static JTextField pilha, campo;
    static JPanel p;

    public static void main(String args[]) throws Exception {

        Calculator calculadora = new Calculator();

        f = new JFrame("Calculadora RPN");

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.gray);

        pilha = new JTextField();
        pilha.setBorder(BorderFactory.createTitledBorder("Números na memória"));
        pilha.setEditable(false);
        pilha.setLayout(null);
        pilha.setBounds(16, 10, 350, 40);
        pilha.setFont(new Font("Arial", Font.BOLD, 18));
        pilha.setText(calculadora.getNumbersHistory().toString());
        p.add(pilha);

        campo = new JTextField(calculadora.getTextField());
        campo.setEditable(false);
        campo.setLayout(null);
        campo.setBounds(16, 60, 145, 40);
        campo.setFont(new Font("Arial", Font.BOLD, 18));
        campo.setBorder(BorderFactory.createLineBorder(Color.black));
        p.add(campo);

        // criando botoes
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bsoma, bsubt, bdivi, bmult, bC, bDel, bEnter, bIgual, bPonto;

        // propriedades dos botões
        b0 = new JButton("0");
        b0.setLayout(null);
        b0.setBounds(96, 360, 60, 60);
        b0.setFont(new Font("Arial", Font.BOLD, 20));
        b0.setBorder(BorderFactory.createLineBorder(Color.black));
        b0.addActionListener(e -> {
            calculadora.addNumberToTextField("0");
            campo.setText(calculadora.getTextField());
        });
        p.add(b0);

        b1 = new JButton("1");
        b1.setLayout(null);
        b1.setBounds(16, 280, 60, 60);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setBorder(BorderFactory.createLineBorder(Color.black));
        b1.addActionListener(e -> {
            calculadora.addNumberToTextField("1");
            campo.setText(calculadora.getTextField());
        });
        p.add(b1);

        b2 = new JButton("2");
        b2.setLayout(null);
        b2.setBounds(96, 280, 60, 60);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setBorder(BorderFactory.createLineBorder(Color.black));
        b2.addActionListener(e -> {
            calculadora.addNumberToTextField("2");
            campo.setText(calculadora.getTextField());
        });
        p.add(b2);

        b3 = new JButton("3");
        b3.setLayout(null);
        b3.setBounds(176, 280, 60, 60);
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b3.setBorder(BorderFactory.createLineBorder(Color.black));
        b3.addActionListener(e -> {
            calculadora.addNumberToTextField("3");
            campo.setText(calculadora.getTextField());
        });
        p.add(b3);

        b4 = new JButton("4");
        b4.setLayout(null);
        b4.setBounds(16, 200, 60, 60);
        b4.setFont(new Font("Arial", Font.BOLD, 20));
        b4.setBorder(BorderFactory.createLineBorder(Color.black));
        b4.addActionListener(e -> {
            calculadora.addNumberToTextField("4");
            campo.setText(calculadora.getTextField());
        });
        p.add(b4);

        b5 = new JButton("5");
        b5.setLayout(null);
        b5.setBounds(96, 200, 60, 60);
        b5.setFont(new Font("Arial", Font.BOLD, 20));
        b5.setBorder(BorderFactory.createLineBorder(Color.black));
        b5.addActionListener(e -> {
            calculadora.addNumberToTextField("5");
            campo.setText(calculadora.getTextField());
        });
        p.add(b5);

        b6 = new JButton("6");
        b6.setLayout(null);
        b6.setBounds(176, 200, 60, 60);
        b6.setFont(new Font("Arial", Font.BOLD, 20));
        b6.setBorder(BorderFactory.createLineBorder(Color.black));
        b6.addActionListener(e -> {
            calculadora.addNumberToTextField("6");
            campo.setText(calculadora.getTextField());
        });
        p.add(b6);

        b7 = new JButton("7");
        b7.setLayout(null);
        b7.setBounds(16, 120, 60, 60);
        b7.setFont(new Font("Arial", Font.BOLD, 20));
        b7.setBorder(BorderFactory.createLineBorder(Color.black));
        b7.addActionListener(e -> {
            calculadora.addNumberToTextField("7");
            campo.setText(calculadora.getTextField());
        });
        p.add(b7);

        b8 = new JButton("8");
        b8.setLayout(null);
        b8.setBounds(96, 120, 60, 60);
        b8.setFont(new Font("Arial", Font.BOLD, 20));
        b8.setBorder(BorderFactory.createLineBorder(Color.black));
        b8.addActionListener(e -> {
            calculadora.addNumberToTextField("8");
            campo.setText(calculadora.getTextField());
        });
        p.add(b8);

        b9 = new JButton("9");
        b9.setLayout(null);
        b9.setBounds(176, 120, 60, 60);
        b9.setFont(new Font("Arial", Font.BOLD, 20));
        b9.setBorder(BorderFactory.createLineBorder(Color.black));
        b9.addActionListener(e -> {
            calculadora.addNumberToTextField("9");
            campo.setText(calculadora.getTextField());
        });
        p.add(b9);

        // criando operadores
        bsoma = new JButton("+");
        bsoma.setLayout(null);
        bsoma.setBounds(280, 120, 60, 60);
        bsoma.setFont(new Font("Arial", Font.BOLD, 20));
        bsoma.setBorder(BorderFactory.createLineBorder(Color.black));
        bsoma.addActionListener(e -> {
            try {
                calculadora.addInput("+");
                Stack<Double> numbersHistory = calculadora.getNumbersHistory();
                pilha.setText(numbersHistory.toString());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });
        p.add(bsoma);

        bsubt = new JButton("-");
        bsubt.setLayout(null);
        bsubt.setBounds(280, 200, 60, 60);
        bsubt.setFont(new Font("Arial", Font.BOLD, 20));
        bsubt.setBorder(BorderFactory.createLineBorder(Color.black));
        bsubt.addActionListener(e -> {
            try {
                calculadora.addInput("-");
                Stack<Double> numbersHistory = calculadora.getNumbersHistory();
                pilha.setText(numbersHistory.toString());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });
        p.add(bsubt);

        bdivi = new JButton("/");
        bdivi.setLayout(null);
        bdivi.setBounds(280, 280, 60, 60);
        bdivi.setFont(new Font("Arial", Font.BOLD, 20));
        bdivi.setBorder(BorderFactory.createLineBorder(Color.black));
        bdivi.addActionListener(e -> {
            try {
                calculadora.addInput("/");
                Stack<Double> numbersHistory = calculadora.getNumbersHistory();
                pilha.setText(numbersHistory.toString());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });
        p.add(bdivi);

        bmult = new JButton("*");
        bmult.setLayout(null);
        bmult.setBounds(280, 360, 60, 60);
        bmult.setFont(new Font("Arial", Font.BOLD, 20));
        bmult.setBorder(BorderFactory.createLineBorder(Color.black));
        bmult.addActionListener(e -> {
            try {
                calculadora.addInput("*");
                Stack<Double> numbersHistory = calculadora.getNumbersHistory();
                pilha.setText(numbersHistory.toString());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });
        p.add(bmult);

        bEnter = new JButton("ENTER");
        bEnter.setLayout(null);
        bEnter.setBounds(165, 60, 75, 39);
        bEnter.setBackground(Color.red);
        bEnter.setForeground(Color.black);
        bEnter.setFont(new Font("Arial", Font.BOLD, 12));
        bEnter.setBorder(BorderFactory.createLineBorder(Color.black));
        bEnter.addActionListener(e -> {
            String textFieldValue = calculadora.getTextField();
            try {
                calculadora.addInput(textFieldValue);
                calculadora.setTextField("");
                campo.setText("");
                Stack<Double> numbersHistory = calculadora.getNumbersHistory();
                pilha.setText(numbersHistory.toString());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            campo.setText(calculadora.getTextField());
        });
        p.add(bEnter);

        bC = new JButton("C");
        bC.setLayout(null);
        bC.setBounds(320, 60, 45, 39);
        bC.setFont(new Font("Arial", Font.BOLD, 15));
        bC.setBorder(BorderFactory.createLineBorder(Color.black));
        bC.addActionListener(e -> {
            try {
                calculadora.setTextField("");
                campo.setText(calculadora.getTextField());
                calculadora.addInput("clear");
                Stack<Double> numbersHistory = calculadora.getNumbersHistory();
                pilha.setText(numbersHistory.toString());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });
        p.add(bC);

        bDel = new JButton("Delete");
        bDel.setLayout(null);
        bDel.setBounds(245, 60, 70, 39);
        bDel.setFont(new Font("Arial", Font.BOLD, 12));
        bDel.setBorder(BorderFactory.createLineBorder(Color.black));
        bDel.addActionListener(e -> {
            calculadora.removeLastNumberToTextField();
            campo.setText(calculadora.getTextField());
        });

        p.add(bDel);

        bIgual = new JButton("=");
        bIgual.setLayout(null);
        bIgual.setBounds(176, 360, 60, 60);
        bIgual.setFont(new Font("Arial", Font.BOLD, 20));
        bIgual.setBorder(BorderFactory.createLineBorder(Color.black));
        p.add(bIgual);

        bPonto = new JButton(".");
        bPonto.setLayout(null);
        bPonto.setBounds(16, 360, 60, 60);
        bPonto.setFont(new Font("Arial", Font.BOLD, 20));
        bPonto.setBorder(BorderFactory.createLineBorder(Color.black));
        bPonto.addActionListener(e -> {
            calculadora.addNumberToTextField(".");
            campo.setText(calculadora.getTextField());
        });
        p.add(bPonto);

        // configurando jframe

        f.add(p);
        f.setResizable(false);
        f.setSize(400, 470);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
