package TelNumber;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddressBook extends JFrame {
    ArrayList<Person> list = new ArrayList<>();
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField telField;
    private JTextArea addressArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddressBook frame = new AddressBook();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddressBook() {
        setTitle("Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 360, 252);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(12, 10, 57, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_l = new JLabel("전화번호");
        lblNewLabel_l.setBounds(12, 42, 57, 15);
        contentPane.add(lblNewLabel_l);

        nameField = new JTextField();
        nameField.setBounds(81, 7, 243, 21);
        contentPane.add(nameField);
        nameField.setColumns(10);

        telField = new JTextField();
        telField.setBounds(81, 39, 243, 21);
        contentPane.add(telField);
        telField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("주소");
        lblNewLabel_2.setBounds(12, 79, 57, 15);
        contentPane.add(lblNewLabel_2);

        addressArea = new JTextArea();
        addressArea.setBounds(12, 104, 312, 67);
        contentPane.add(addressArea);

        JButton saveButton = new JButton("저장");
        saveButton.setBounds(12, 181, 97, 23);
        contentPane.add(saveButton);
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String tel = telField.getText();
            String address = addressArea.getText();
            list.add(new Person(name, tel, address));
            clearFields();
        });

        JButton searchButton = new JButton("검색");
        searchButton.setBounds(117, 181, 97, 23);
        contentPane.add(searchButton);
        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            for (Person p : list) {
                if (p.getName().equals(name)) {
                    telField.setText(p.getTel());
                    addressArea.setText(p.getAddress());
                    break; 
                }
            }
        });

        JButton exitButton = new JButton("종료");
        exitButton.setBounds(227, 181, 97, 23);
        contentPane.add(exitButton);
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    class Person {
        String name;
        String tel;
        String address;

        public String getName() {
            return name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Person(String name, String tel, String address) {
            this.name = name;
            this.tel = tel;
            this.address = address;
        }
    }

    private void clearFields() {
        nameField.setText("");
        telField.setText("");
        addressArea.setText("");
    }
}
