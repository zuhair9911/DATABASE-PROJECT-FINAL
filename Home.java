package quiz_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Connection c = null;
				Statement start = null;
				try {
				    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					Home frame = new Home();
					frame.setVisible(true);
					frame.setTitle("QUIZ SYSTEM");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setBackground(new Color(95, 158, 160));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("TEACHER");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLogin ta = new TeacherLogin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(272, 145, 168, 54);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("STUDENT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogin sd = new StudentLogin();
				sd.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setBounds(272, 210, 168, 54);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("SIGN UP");
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup sg = new Signup();
				sg.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setForeground(SystemColor.text);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBackground(new Color(0, 0, 128));
		btnNewButton_5.setBounds(272, 336, 168, 54);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("NEW MEMBER?");
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(303, 311, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LOGIN");
		lblNewLabel_1_1.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(334, 120, 43, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtQuiz = new JTextField();
		txtQuiz.setEditable(false);
		txtQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuiz.setText("QUIZ");
		txtQuiz.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		txtQuiz.setBackground(new Color(0, 0, 128));
		txtQuiz.setForeground(Color.WHITE);
		txtQuiz.setBounds(0, 33, 712, 61);
		contentPane.add(txtQuiz);
		txtQuiz.setColumns(10);
	}
}
