package quiz_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class teacherprofile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	String name;
	String id;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacherprofile frame = new teacherprofile("","");
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
	public teacherprofile(String name, String id) {
		this.name=name;
		this.id=id;
				
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
				TeacherHome th = new TeacherHome(name,id);
				th.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextArea iduser = new JTextArea();
		iduser.setEditable(false);
		iduser.setBounds(321, 88, 204, 23);
		contentPane.add(iduser);
		
		JTextArea namefirst = new JTextArea();
		namefirst.setBounds(321, 122, 204, 23);
		contentPane.add(namefirst);
		
		JTextArea namelast = new JTextArea();
		namelast.setBounds(321, 156, 204, 23);
		contentPane.add(namelast);
		
		JTextArea mob = new JTextArea();
		mob.setBounds(321, 190, 204, 23);
		contentPane.add(mob);
		
		JTextArea mail = new JTextArea();
		mail.setBounds(321, 224, 204, 23);
		contentPane.add(mail);
		
		JTextArea nameuser = new JTextArea();
		nameuser.setBounds(321, 258, 204, 23);
		contentPane.add(nameuser);
		
		JTextArea word = new JTextArea();
		word.setBounds(321, 292, 204, 23);
		contentPane.add(word);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(251, 93, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("FIRST NAME");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFirstName.setBounds(251, 127, 60, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLastName.setBounds(251, 161, 60, 14);
		contentPane.add(lblLastName);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMobile.setBounds(251, 195, 60, 14);
		contentPane.add(lblMobile);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(251, 229, 60, 14);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(251, 263, 60, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(251, 297, 60, 14);
		contentPane.add(lblPassword);
		
		JButton btnNewButton_1 = new JButton("SAVE EDIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame jx = new JFrame();
				try {
				Connection c = null;
				Statement start = null;
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
				start = c.createStatement();
				String sql = "UPDATE person SET FIRST_NAME ='" + namefirst.getText() + "',"
							+  "LAST_NAME ='" + namelast.getText() + "',"
									+  "MOBILE_NUM ='" + mob.getText() + "',"
											+  "EMAIL ='" + mail.getText() + "',"
													+  "username ='" + nameuser.getText() + "',"
															+  "pass ='" + word.getText() + "' WHERE USER_ID = '" + id + "';";
				
				start.execute(sql);
				JOptionPane.showMessageDialog(jx, "PROFILE EDITED");
				}
				catch (Exception eee) {
					eee.printStackTrace();
					JOptionPane.showMessageDialog(jx, "ERROR");
				}
			
			
			
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBounds(321, 326, 204, 23);
		contentPane.add(btnNewButton_1);
		
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
			//start = c.createStatement();
			PreparedStatement	start = c.prepareStatement("SELECT * FROM person where USER_ID = '" + id + "'");

			ResultSet rs = start.executeQuery();
			
			while (rs.next()) {
			    String personid = rs.getString("USER_ID");
			    String firstname = rs.getString("FIRST_NAME");
			    String lastname = rs.getString("LAST_NAME");
			    String mobilenum = rs.getString("MOBILE_NUM");
			    String email = rs.getString("EMAIL");
			    String username = rs.getString("username");
			    String password = rs.getString("pass");
			    // create a single array of one row's worth of data
			  // String[] data = { personid,firstname,lastname,mobilenum,email,username,password } ;

			    // and add this row of data into the table model
			    
			    iduser.setText(id);
			    namefirst.setText(firstname);
			    namelast.setText(lastname);
			    mob.setText(mobilenum);
			    mail.setText(email);
			    nameuser.setText(username);
			    word.setText(password);
			    
			    
			  
			
			}
		}
		
		catch (Exception a) {
			a.printStackTrace();
		}
	}
}
