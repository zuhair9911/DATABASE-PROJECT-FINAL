package quiz_system;

import java.awt.BorderLayout; 

import java.awt.EventQueue;
//import java.sql.Date;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class CreateQuiz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	String id;
	String host_id;
	private JTextField quiztitle;
	private JTextField quizscore;
	String hosename;
	private JTextField noquestions;
	private JTextField deadline;
	private JTextField startsAt;
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateQuiz frame = new CreateQuiz("", "","");
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
	public CreateQuiz(String ID, String host_id, String hose_name) {
		this.id = ID;
		this.host_id = host_id;
		this.hosename = hose_name;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 540);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE QUIZ");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(276, 11, 160, 52);
		contentPane.add(lblNewLabel);
		
		JTextArea quizid = new JTextArea();
		quizid.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		quizid.setForeground(SystemColor.text);
		quizid.setEditable(false);
		quizid.setBackground(new Color(0, 0, 128));
		quizid.setBounds(0, 85, 712, 61);
		contentPane.add(quizid);
		
		quizid.setText(" QUIZ ID: " + id + "\n" + " HOST ID: " + host_id + "\n" + " HOST NAME: " + hosename);
		
		quiztitle = new JTextField();
		quiztitle.setBounds(266, 160, 306, 20);
		contentPane.add(quiztitle);
		quiztitle.setColumns(10);
		
		quizscore = new JTextField();
		quizscore.setBounds(266, 222, 306, 20);
		contentPane.add(quizscore);
		quizscore.setColumns(10);
		
		JButton btnNewButton = new JButton("CREATE QUIZ and ADD QUESTIONS");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jx = new JFrame();
				Connection c = null;
				Statement start = null;
				
				try {
					
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					start = c.createStatement();
					
					Date date = new Date();
					
					java.sql.Date dt = new java.sql.Date(date.getTime());
					
					//String sql = "INSERT INTO quiz(QUIZ_ID,HOST_ID,TITLE,SCORE,created) VALUES ('" + id + "','" + host_id + "','" + quiztitle.getText() + "'," + Integer.parseInt(quizscore.getText()) + "," +  + ");";
					//start.executeUpdate(sql);
					
					PreparedStatement st	 = c.prepareStatement("INSERT INTO quiz(QUIZ_ID,HOST_ID,TITLE,SCORE,created,no_of_questions,startsat,submission) VALUES (?,?,?,?,?,?,?,?)");
					st.setString(1,id);
					st.setString(2,host_id);
					st.setString(3, quiztitle.getText());
					st.setInt(4,Integer.parseInt(quizscore.getText()));
					st.setDate(5,dt);
					st.setInt(6,Integer.parseInt(noquestions.getText()));
				    st.setString(7, startsAt.getText());
					st.setString(8, deadline.getText());
					st.executeUpdate();
					
					JOptionPane.showMessageDialog(jx, "QUIZ CREATED");
					//TeacherHome tb = new TeacherHome(hosename,host_id);
					//tb.setVisible(true);
					String y = quiztitle.getText();
					addquestions ad = new addquestions(id,y,Integer.parseInt(noquestions.getText()),Integer.parseInt(quizscore.getText()),host_id,hose_name);
					ad.setVisible(true);
					dispose();
				}
				catch (Exception em) {
					em.printStackTrace();
					JOptionPane.showMessageDialog(jx, "ERROR");
				}
			}
		});
		btnNewButton.setBounds(265, 320, 307, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("TITLE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(229, 163, 27, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL SCORE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(187, 225, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		noquestions = new JTextField();
		noquestions.setBounds(266, 191, 306, 20);
		contentPane.add(noquestions);
		noquestions.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NO OF QUESTIONS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(163, 194, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DEADLINE (YYYY-MM-DD HH:MM:SS) ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(78, 287, 178, 14);
		contentPane.add(lblNewLabel_4);
		
		deadline = new JTextField();
		deadline.setBounds(266, 284, 306, 20);
		contentPane.add(deadline);
		deadline.setColumns(10);
		
		startsAt = new JTextField();
		startsAt.setBounds(266, 253, 306, 20);
		contentPane.add(startsAt);
		startsAt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("STARTS AT (YYYY-MM-DD HH:MM:SS)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(75, 256, 181, 14);
		contentPane.add(lblNewLabel_5);
	}

}
