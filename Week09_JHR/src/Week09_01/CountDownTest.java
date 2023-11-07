package Week09_01;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest extends JFrame {
    private JLabel label;
    private JButton startButton;
    private JButton stopButton;
    private int currentCount;
    private Counter t;
    private volatile boolean running;

    class Counter extends Thread {
        public void run() {
            for (int i = currentCount; i <= 100 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                label.setText(String.valueOf(i));
            }
        }
    }

    public CountDownTest() {
        setTitle("카운트다운");
        setSize(400, 200);
        getContentPane().setLayout(null);

        label = new JLabel("0");
        label.setBounds(0, 0, 384, 111);
        label.setFont(new Font("Serif", Font.BOLD, 100));
        getContentPane().add(label);

        startButton = new JButton("카운트 시작");
        startButton.setBounds(50, 120, 150, 30);
        getContentPane().add(startButton);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t == null) {
                    running = true;
                    t = new Counter();
                    t.start();
                }
            }
        });

        stopButton = new JButton("카운트 중지");
        stopButton.setBounds(220, 120, 150, 30);
        getContentPane().add(stopButton);
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = false;
                if (t != null && t.isAlive()) {
                    t.interrupt();
                    t = null;
                }
                currentCount = Integer.parseInt(label.getText()); 
            }
        });
    }

    public static void main(String[] args) {
        CountDownTest frame = new CountDownTest();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

