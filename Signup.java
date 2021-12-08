package quiz_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField mobile;
	private JTextField email;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 540);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaptionText);
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(314, 47, 120, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("I am a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(247, 140, 72, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LAST NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(247, 210, 72, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("FIRST NAME");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(247, 175, 84, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("MOBILE#");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(247, 241, 72, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("USERNAME");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(247, 303, 72, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("EMAIL");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(247, 272, 43, 14);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("PASSWORD");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(247, 334, 84, 14);
		contentPane.add(lblNewLabel_1_6);
		
		JRadioButton teacher = new JRadioButton("TEACHER");
		teacher.setBackground(new Color(230, 230, 250));
		teacher.setBounds(325, 141, 109, 23);
		contentPane.add(teacher);
		
		JRadioButton student = new JRadioButton("STUDENT");
		student.setBackground(new Color(230, 230, 250));
		student.setBounds(436, 141, 109, 23);
		contentPane.add(student);
		
		firstname = new JTextField();
		firstname.setBackground(SystemColor.inactiveCaption);
		firstname.setBounds(335, 174, 163, 20);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBackground(SystemColor.inactiveCaption);
		lastname.setBounds(334, 209, 164, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBackground(SystemColor.inactiveCaption);
		mobile.setBounds(335, 240, 163, 20);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		email = new JTextField();
		email.setBackground(SystemColor.inactiveCaption);
		email.setBounds(335, 271, 163, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		username = new JTextField();
		username.setBackground(SystemColor.inactiveCaption);
		username.setBounds(335, 302, 163, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBackground(SystemColor.inactiveCaption);
		password.setBounds(335, 333, 163, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(teacher.isSelected()) {
					Connection c = null;
					Statement start = null;
					JFrame f = new JFrame();
					int host = 1;
					int i = (int) (Math.random() * 9);
					int j = (int) (Math.random() * 9);
					int k = (int) (Math.random() * 9);
					int l = (int) (Math.random() * 9);
					int m = (int) (Math.random() * 9);
					String x = Integer.toString(i) + Integer.toString(j) + Integer.toString(k) + Integer.toString(l) + Integer.toString(m);
					try {
						
						 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					start = c.createStatement();
					 
					String sql = "INSERT INTO person(USER_ID,FIRST_NAME,LAST_NAME,HOST,MOBILE_NUM,EMAIL,username,pass) VALUES ('" + x + "','" + firstname.getText() + "','" + lastname.getText() + "','" + host + "','" + mobile.getText() + "','" + email.getText() + "','" + username.getText() + "','" + password.getText() + "')";
					 
					 start.executeUpdate(sql);
					 JOptionPane.showMessageDialog(f,"TEACHER SIGNUP SUCCESSFUL");
					 Home ad = new Home();
					 ad.setVisible(true);
					 dispose();
					}
					catch (Exception ez) {
						ez.printStackTrace();
						JOptionPane.showMessageDialog(f,"ERROR");
					}
				}
				
				if(student.isSelected()) {
					Connection c = null;
					Statement start = null;
					JFrame f = new JFrame();
					int host = 0;
					int i = (int) (Math.random() * 9);
					int j = (int) (Math.random() * 9);
					int k = (int) (Math.random() * 9);
					int l = (int) (Math.random() * 9);
					int m = (int) (Math.random() * 9);
					String x = Integer.toString(i) + Integer.toString(j) + Integer.toString(k) + Integer.toString(l) + Integer.toString(m);
					try {
						
						 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					start = c.createStatement();
					 
					String sql = "INSERT INTO person(USER_ID,FIRST_NAME,LAST_NAME,HOST,MOBILE_NUM,EMAIL,username,pass) VALUES ('" + x + "','" + firstname.getText() + "','" + lastname.getText() + "','" + host + "','" + mobile.getText() + "','" + email.getText() + "','" + username.getText() + "','" + password.getText() + "')";
					 
					 start.executeUpdate(sql);
					 JOptionPane.showMessageDialog(f,"STUDENT SIGNUP SUCCESFULL");
					 Home ad = new Home();
					 ad.setVisible(true);
					 dispose();
					}
					catch (Exception ez) {
						ez.printStackTrace();
						JOptionPane.showMessageDialog(f,"ERROR");
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(247, 367, 251, 23);
		contentPane.add(btnNewButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(student);
		bg.add(teacher);
		
		JButton btnNewButton_1 = new JButton("GO BACK");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
