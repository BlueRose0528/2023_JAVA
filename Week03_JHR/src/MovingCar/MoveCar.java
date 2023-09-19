package MovingCar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveCar extends JFrame {
    int img_x = 150, img_y = 150;
    JButton leftButton, rightButton;
    JLabel carLabel;

    public MoveCar() {
        setSize(700, 700); 
        
        
        leftButton = new JButton("Left");
        rightButton = new JButton("Right");
        
       
        carLabel = new JLabel("");
        ImageIcon icon = new ImageIcon("c:\\car.png");
        carLabel.setIcon(icon);

        JPanel panel = new JPanel(new BorderLayout()); 
        panel.add(leftButton, BorderLayout.WEST); 
        panel.add(rightButton, BorderLayout.EAST); 
        panel.add(carLabel, BorderLayout.CENTER); 

        
        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_x -= 10;
                carLabel.setLocation(img_x, img_y);
            }
        });

        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_x += 10;
                carLabel.setLocation(img_x, img_y);
            }
        });

        add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MoveCar f = new MoveCar();
    }
}
