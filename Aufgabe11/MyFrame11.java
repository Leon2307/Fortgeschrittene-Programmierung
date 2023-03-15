package Aufgabe11;

import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.*;

public class MyFrame11 extends JFrame{

    JLabel argument;
    JButton calculate;
    JTextField argumentText, resultText;
    ButtonGroup bg;
    JCheckBox log, sqrt;
    

    public MyFrame11(String name) {
        super(name);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 3));

        // Create Components
        argument = new JLabel("Argument");
        argumentText = new JTextField();
        resultText = new JTextField();
        calculate = new JButton("Berechnen");
        log = new JCheckBox("LOGARITHMUS");
        sqrt = new JCheckBox("QUADRATWURZEL");

        // ButtonGroup
        bg = new ButtonGroup();
        bg.add(log);
        bg.add(sqrt);

        // add to ContentPane 
        cp.add(argument);
        cp.add(log);
        cp.add(calculate);
        cp.add(argumentText);
        cp.add(sqrt);
        cp.add(resultText);

        // add ActionListener
        calculate.addActionListener(new ExecuteListener());


    }

    public class ExecuteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == calculate) {
                double argument = Double.parseDouble(argumentText.getText());
                if (log.isSelected()) {
                    double resultValue = Math.log(argument);
                    resultText.setText(String.valueOf(resultValue));
                } else if (sqrt.isSelected()) {
                    double resultValue = Math.sqrt(argument);
                    resultText.setText(String.valueOf(resultValue));
                }
            }
        }
    }
    
}
