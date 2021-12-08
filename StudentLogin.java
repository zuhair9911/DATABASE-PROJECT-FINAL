package quiz_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class StudentLogin extends JFrame {

	private JPanel contentPane;
	private JTextField loginid;
	private JTextField loginpw;
	private JPasswordField passwordstu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
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
	public StudentLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("STUDENT LOGIN");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 28));
		lblNewLabel.setBounds(251, 137, 229, 33);
		contentPane.add(lblNewLabel);
		
		loginid = new JTextField();
		loginid.setBounds(373, 208, 86, 20);
		contentPane.add(loginid);
		loginid.setColumns(10);
		
		loginpw = new JTextField();
		loginpw.setBounds(646, 237, -2, 20);
		contentPane.add(loginpw);
		loginpw.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(272, 209, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(272, 243, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame j = new JFrame();
				try {
					String db = "";
					String name = "";
					String id = "";
					int host = 0;
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					//start = c.createStatement();
					PreparedStatement	start = c.prepareStatement("SELECT * FROM person WHERE username = '" + loginid.getText() + "';");
				    //String sql = "SELECT pass FROM person WHERE username = '" + username.getText() + "'";
					ResultSet rs = start.executeQuery();
					//rs.absolute(1);
					String pw = loginpw.getText();
					String pm = passwordstu.getText();
					while(rs.next()) {
						db = rs.getString("pass");
						name = rs.getString("FIRST_NAME");
						id = rs.getString("USER_ID");
						host = rs.getInt("HOST");
					break;
					}
					
					if (pm.equals(db) && host == 0) {
						StudentHome sc = new StudentHome(name,id);
						//tc.ID = id;
						//tc.Name = name;
						sc.setVisible(true);
						dispose();
					}
					
					else {
						JOptionPane.showMessageDialog(j, "LOGIN FAILED");
					}
				}
			    catch (Exception ez) {
			    	JOptionPane.showMessageDialog(j, "LOGIN FAILED");
					ez.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBounds(272, 288, 187, 48);
		contentPane.add(btnNewButton_1);
		
		passwordstu = new JPasswordField();
		passwordstu.setBounds(373, 242, 86, 20);
		contentPane.add(passwordstu);
	}

}
