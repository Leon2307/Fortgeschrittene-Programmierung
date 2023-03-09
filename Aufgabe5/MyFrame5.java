package Aufgabe5;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.events.Event;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.*;

public class MyFrame5 extends JFrame {

    Container contentPane;
    JLabel euro;
    JTextField euroText, resultText;
    JComboBox<String> currency;

    public MyFrame5(String title) {
        super(title);
        contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 1));

        euro = new JLabel("Euro");
        euroText = new JTextField();
        currency = new JComboBox<String>(EuroConverter.bezeichnung);
        resultText = new JTextField();

        EventListener al = new EventListener();
        euroText.addActionListener(al);
        resultText.addActionListener(al);
        currency.addActionListener(al);

        contentPane.add(euro);
        contentPane.add(euroText);
        contentPane.add(currency);
        contentPane.add(resultText);

    }

    private class EventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionEvent: " + e);
            if (e.getSource() == euroText) {
                double euro = Double.parseDouble(euroText.getText());
                int currencyIndex = currency.getSelectedIndex();
                double resultValue = EuroConverter.convertFromEuro(euro, currencyIndex);
                resultText.setText(String.valueOf(resultValue));
            } else if (e.getSource() == resultText) {
                double resultValue = Double.parseDouble(resultText.getText());
                int currencyIndex = currency.getSelectedIndex();
                double euro = EuroConverter.convertToEuro(resultValue, currencyIndex);
                euroText.setText(String.valueOf(euro));
            } else if (e.getSource() == currency) {
                int currencyIndex = currency.getSelectedIndex();
                double euro = Double.parseDouble(euroText.getText());
                double resultValue = EuroConverter.convertFromEuro(euro, currencyIndex);
                resultText.setText(String.valueOf(resultValue));
            }
        }
    }
}
