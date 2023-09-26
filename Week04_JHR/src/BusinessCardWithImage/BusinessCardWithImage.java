package BusinessCardWithImage;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class BusinessCardWithImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame=new JFrame("명함");
		
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		
		ImageIcon icon=new ImageIcon("c:\\dog.png");
		JLabel imageLabel=new JLabel(icon);
		
		panel.add(imageLabel, BorderLayout.CENTER);
		
		JPanel infoPanel=new JPanel();
		infoPanel.setLayout(new GridLayout(3, 1));
		
		JLabel nameLabel=new JLabel("name: 정후리");
		JLabel titleLabel=new JLabel("job: 개발자");
		JLabel contactLabel=new JLabel("tel:123-456-7890");
		
		infoPanel.add(nameLabel);
		infoPanel.add(titleLabel);
		infoPanel.add(contactLabel);
		
		panel.add(infoPanel, BorderLayout.NORTH);
		frame.add(panel);
		frame.setVisible(true);
	}

}
