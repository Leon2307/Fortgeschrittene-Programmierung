package Aufgabe4;

import java.awt.event.*;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;

public class MyFrame4 extends JFrame {

    Container contentPane;
    JTextField num1, num2;
    JLabel operation, equal, result;
    JButton plus, minus, mult, div, delete;

    public MyFrame4(String title) {
        super(title);
        contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 5));

        num1 = new JTextField();
        num2 = new JTextField();
        operation = new JLabel();
        equal = new JLabel("=");
        result = new JLabel();
        plus = new JButton("+");
        minus = new JButton("-");
        mult = new JButton("*");
        div = new JButton("/");
        delete = new JButton("Delete");

        contentPane.add(num1);
        contentPane.add(operation);
        contentPane.add(num2);
        contentPane.add(equal);
        contentPane.add(result);
        contentPane.add(plus);
        contentPane.add(minus);
        contentPane.add(mult);
        contentPane.add(div);
        contentPane.add(delete);

        ActionListener oLPlus = new OperatorListener("+");
        plus.addActionListener(oLPlus);
        ActionListener oLMinus = new OperatorListener("-");
        minus.addActionListener(oLMinus);
        ActionListener oLMult = new OperatorListener("*");
        mult.addActionListener(oLMult);
        ActionListener oLDiv = new OperatorListener("/");
        div.addActionListener(oLDiv);
        ActionListener oLDelete = new OperatorListener("1");
        delete.addActionListener(oLDelete);
    }

    private class OperatorListener implements ActionListener {
        private String operator;

        public OperatorListener(String operator) {
            this.operator = operator;
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == delete) {
                num1.setText("");
                num2.setText("");
                operation.setText("");
                result.setText("");
            } else {
                operation.setText(operator);
                double n1 = Double.parseDouble(num1.getText());
                double n2 = Double.parseDouble(num2.getText());
                double res = 0;
                switch (operator) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "*":
                        res = n1 * n2;
                        break;
                    case "/":
                        res = n1 / n2;
                        break;
                }
                result.setText(Double.toString(res));
            }
        }
    }
}
