import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class MyNumberFrame extends JFrame {
    JCheckBox checkBox;
    JButton btn;
    JLabel jl;

    public MyNumberFrame() {
        JComboBox<Integer> jb = new JComboBox<Integer>();

        for (int i = 0; i < 10; i++) {
            jb.addItem(i);
        }
        checkBox = new JCheckBox("numerisch");
        btn = new JButton("Alles Löschen");
        jl = new JLabel();

        add(jb, BorderLayout.NORTH);
        add(checkBox, BorderLayout.SOUTH);
        add(btn, BorderLayout.EAST);
        add(jl, BorderLayout.WEST);

        btn.addActionListener(new myLis());

        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    Integer value = Integer.parseInt(jl.getText()) + (int) jb.getSelectedItem();
                    jl.setText(value.toString());
                } else {
                    jl.setText(jl.getText() + jb.getSelectedItem());
                }
            }
        });
    }

    public class myLis implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn) {
                jl.setText("");
            }
        }

    }

}
