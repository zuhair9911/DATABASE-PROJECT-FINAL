package quiz_system;

import java.awt.BorderLayout;   
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import jdk.javadoc.internal.tool.Start;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.Color;

public class TeacherLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JPasswordField passwordtea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogin frame = new TeacherLogin();
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
	public TeacherLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TEACHER LOGIN");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBackground(SystemColor.text);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 28));
		lblNewLabel.setBounds(255, 120, 221, 48);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(353, 198, 106, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(675, 237, 0, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(269, 199, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(269, 238, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Connection c = null;
				//PreparedStatement start = null;
				JFrame jf = new JFrame();
				JFrame j = new JFrame();
				try {
					String db = "";
					String name = "";
					String id = "";
					int host = 0;
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					//start = c.createStatement();
					PreparedStatement	start = c.prepareStatement("SELECT * FROM person WHERE username = '" + username.getText() + "';");
				    //String sql = "SELECT pass FROM person WHERE username = '" + username.getText() + "'";
					ResultSet rs = start.executeQuery();
					//rs.absolute(1);
					String pw = password.getText();
					String pm = passwordtea.getText();
					while(rs.next()) {
						db = rs.getString("pass");
						name = rs.getString("FIRST_NAME");
						id = rs.getString("USER_ID");
						host = rs.getInt("HOST");
					break;
					}
					
					if (pm.equals(db) && host == 1) {
						TeacherHome tc = new TeacherHome(name,id);
						//tc.ID = id;
						//tc.Name = name;
						tc.setVisible(true);
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
		btnNewButton.setBounds(272, 286, 187, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm = new Home();
				hm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		passwordtea = new JPasswordField();
		passwordtea.setBounds(353, 237, 106, 20);
		contentPane.add(passwordtea);
	}
}
