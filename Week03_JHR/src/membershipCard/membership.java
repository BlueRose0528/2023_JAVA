package membershipCard;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class membership extends JFrame {

	public membership()
	{
		setTitle("MembershipData");
		setSize(650, 200);
		
		JPanel panel=new JPanel();
		add(panel);
		
		panel.add(new JLabel("아이디  "));
		panel.add(new JTextField(20));
		panel.add(new JLabel("패스워드  "));
		panel.add(new JPasswordField(20));
		panel.add(new JLabel("이메일주소  "));
		panel.add(new JTextField(20));
		panel.add(new JLabel("전화번호  "));
		panel.add(new JTextField(20));
		
		JButton login=new JButton("둥록하기");
		panel.add(login);
		
		JButton cancel=new JButton("취소");
		panel.add(cancel);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new membership();
	}

}
