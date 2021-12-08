package quiz_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class TeacherHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	String Name;
	String ID;
	
	String[] id;
	int count = 0;
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherHome frame = new TeacherHome("","");
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
	
	public TeacherHome(String Name, String ID) {
		this.ID = ID;
		this.Name = Name;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm = new Home();
				hm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(622, 0, 110, 65);
		contentPane.add(btnNewButton);
		
		JTextArea welcome = new JTextArea();
		welcome.setForeground(SystemColor.text);
		welcome.setBackground(new Color(0, 0, 128));
		welcome.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		welcome.setEditable(false);
		welcome.setBounds(0, 0, 623, 65);
		contentPane.add(welcome);
		
		
		
		welcome.setText(" Welcome " + Name + "\n" + " ID: " + ID);
		
		JButton btnNewButton_1 = new JButton("CREATE QUIZ");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = (int) (Math.random() * 9);
				int j = (int) (Math.random() * 9);
				int k = (int) (Math.random() * 9);
				int l = (int) (Math.random() * 9);
				int m = (int) (Math.random() * 9);
				String x = Integer.toString(i) + Integer.toString(j) + Integer.toString(k) + Integer.toString(l) + Integer.toString(m);
				//id[count] = x;
				//count++;
				CreateQuiz qz = new CreateQuiz(x,ID,Name);
				qz.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(143, 132, 217, 105);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VIEW / EDIT QUIZZES");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewQuiz vq = new ViewQuiz(Name,ID);
				vq.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(370, 133, 217, 105);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VIEW SCORES");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewScores vs = new ViewScores(Name,ID);
				vs.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(SystemColor.text);
		btnNewButton_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(143, 248, 217, 105);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("PROFILE");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherprofile tp = new teacherprofile(Name,ID);
				tp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3_1.setBackground(new Color(0, 0, 128));
		btnNewButton_3_1.setBounds(370, 248, 217, 105);
		contentPane.add(btnNewButton_3_1);
	}
}
