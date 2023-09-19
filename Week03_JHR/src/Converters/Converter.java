package Converters;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Converter extends JFrame {
    private JTextField mileField;
    private JTextField kmField;

    public Converter() {
        JPanel panel = new JPanel();
        add(panel);

        JLabel label1 = new JLabel("Mile");
        JLabel label2 = new JLabel("Kilometer");
        mileField = new JTextField(10);
        kmField = new JTextField(10);
        JButton convertButton = new JButton("변환");

        panel.add(label1);
        panel.add(mileField);
        panel.add(label2);
        panel.add(kmField);
        panel.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                try {
                    double miles = Double.parseDouble(mileField.getText());
                    double kilometers = miles * 1.609344;
                    kmField.setText(String.format("%.2f", kilometers));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "올바른 숫자를 입력하세요.", "에러", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSize(300, 150);
        setTitle("거리 변환기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Converter f = new Converter();
        });
    }
}
