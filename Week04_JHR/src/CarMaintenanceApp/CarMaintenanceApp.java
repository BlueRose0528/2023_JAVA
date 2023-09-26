package CarMaintenanceApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarMaintenanceApp {
    public static void main(String[] args) {
     
        JFrame frame = new JFrame("자동차 정비");

        frame.setSize(300, 250);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1)); 
   
        JCheckBox engineOilCheckbox = new JCheckBox("엔진 오일 변환 (45,000원)");
        JCheckBox transmissionOilCheckbox = new JCheckBox("자동 변속기 오일 교환 (80,000원)");
        JCheckBox airFilterCheckbox = new JCheckBox("에어컨 필터 교환 (30,000원)");
        JCheckBox tireReplacementCheckbox = new JCheckBox("타이어 교환 (100,000원)");

   
        JButton calculateButton = new JButton("가격 계산");
        JLabel totalLabel = new JLabel("현재까지의 가격: ");

     
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalCost = 0;

                if (engineOilCheckbox.isSelected()) {
                    totalCost += 45000;
                }
                if (transmissionOilCheckbox.isSelected()) {
                    totalCost += 80000;
                }
                if (airFilterCheckbox.isSelected()) {
                    totalCost += 30000;
                }
                if (tireReplacementCheckbox.isSelected()) {
                    totalCost += 100000;
                }

                totalLabel.setText("전체 가격: " + totalCost + "원");
            }
        });

   
        panel.add(engineOilCheckbox);
        panel.add(transmissionOilCheckbox);
        panel.add(airFilterCheckbox);
        panel.add(tireReplacementCheckbox);
        panel.add(calculateButton);
        panel.add(totalLabel);

        frame.add(panel);

        frame.setVisible(true);
    }
}
