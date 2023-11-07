package Practice;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDown extends JFrame {
    private JLabel label;

    class MyThread extends Thread {
        public void run() {
            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                label.setText(i + " ");
            }
        }
    }

    public CountDown() {
        setTitle("카운트 다운");
        setSize(400, 150);
        label = new JLabel("0");
        label.setFont(new Font("Serif", Font.BOLD, 100));
        add(label);
        setVisible(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        (new MyThread()).start();
    }

    public static void main(String[] args) {
        CountDown frame = new CountDown();
    }
}

