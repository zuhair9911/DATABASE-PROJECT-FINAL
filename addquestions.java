package quiz_system;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class addquestions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	String quizid;
	String title;
	int questionums;
	int quizscore;
	int clicks;
	String hostid;
	String hostname;
	private JTextField question;
	private JTextField option_1;
	private JTextField option_2;
	private JTextField option_3;
	private JTextField option_4;
	private JTextField score;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addquestions frame = new addquestions("","",0,0,"","");
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
	
	public addquestions(String quizid, String title, int questionums, int quizscore,String hostid, String hostname) {
		this.questionums=questionums;
		this.quizid=quizid;
		this.title=title;
		this.quizscore = quizscore;
		this.hostid=hostid;
		this.hostname=hostname;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea titlequiz = new JTextArea();
		titlequiz.setBackground(new Color(0, 0, 128));
		titlequiz.setFont(new Font("Monospaced", Font.BOLD, 14));
		titlequiz.setForeground(SystemColor.text);
		titlequiz.setEditable(false);
		titlequiz.setBounds(0, 0, 732, 23);
		contentPane.add(titlequiz);
		
		titlequiz.setText("  QUIZ ID: " + quizid + "    TITLE: " + title + "    MAX NO OF QUESTIONS: " + questionums + "     TOTAL SCORE: " + quizscore);
		
		JTextArea quesinfo = new JTextArea();
		quesinfo.setFont(new Font("Monospaced", Font.BOLD, 14));
		quesinfo.setBounds(10, 45, 676, 22);
		contentPane.add(quesinfo);
		
		question = new JTextField();
		question.setBounds(10, 106, 620, 34);
		contentPane.add(question);
		question.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("QUESTION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 81, 93, 14);
		contentPane.add(lblNewLabel);
		
		option_1 = new JTextField();
		option_1.setBounds(96, 164, 626, 20);
		contentPane.add(option_1);
		option_1.setColumns(10);
		
		option_2 = new JTextField();
		option_2.setBounds(96, 214, 626, 20);
		contentPane.add(option_2);
		option_2.setColumns(10);
		
		option_3 = new JTextField();
		option_3.setBounds(96, 265, 626, 20);
		contentPane.add(option_3);
		option_3.setColumns(10);
		
		option_4 = new JTextField();
		option_4.setBounds(96, 316, 626, 20);
		contentPane.add(option_4);
		option_4.setColumns(10);
		
		JRadioButton option1 = new JRadioButton("OPTION 1");
		option1.setBackground(SystemColor.text);
		option1.setBounds(10, 163, 80, 23);
		contentPane.add(option1);
		
		JRadioButton option2 = new JRadioButton("OPTION 2");
		option2.setBackground(SystemColor.text);
		option2.setBounds(10, 213, 80, 23);
		contentPane.add(option2);
		
		JRadioButton option3 = new JRadioButton("OPTION 3");
		option3.setBackground(SystemColor.text);
		option3.setBounds(10, 264, 80, 23);
		contentPane.add(option3);
		
		JRadioButton option4 = new JRadioButton("OPTION 4");
		option4.setBackground(SystemColor.text);
		option4.setBounds(10, 315, 80, 23);
		contentPane.add(option4);
		
		ButtonGroup ba = new ButtonGroup();
		ba.add(option1);
		ba.add(option2);
		ba.add(option3);
		ba.add(option4);
		 //int x = 0;
	
		//int newscore = 0;
		JButton btnNewButton = new JButton("ADD QUESTION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								
				 clicks++;
			//	 quesinfo.setText("");
				 
				 
				
				int i = (int) (Math.random() * 9);
				int j = (int) (Math.random() * 9);
				int k = (int) (Math.random() * 9);
				int l = (int) (Math.random() * 9);
				int m = (int) (Math.random() * 9);
				String questionid = Integer.toString(i) + Integer.toString(j) + Integer.toString(k) + Integer.toString(l) + Integer.toString(m);
				
				int a = (int) (Math.random() * 9);
				int b = (int) (Math.random() * 9);
				int c = (int) (Math.random() * 9);
				int d = (int) (Math.random() * 9);
				int ee = (int) (Math.random() * 9);
				String option1_ = Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d) + Integer.toString(ee);
				
				int f = (int) (Math.random() * 9);
				int g = (int) (Math.random() * 9);
				int h = (int) (Math.random() * 9);
				int ii = (int) (Math.random() * 9);
				int jj = (int) (Math.random() * 9);
				String option2_ = Integer.toString(f) + Integer.toString(g) + Integer.toString(h) + Integer.toString(ii) + Integer.toString(jj);
				
				int kk = (int) (Math.random() * 9);
				int ll = (int) (Math.random() * 9);
				int mm = (int) (Math.random() * 9);
				int n = (int) (Math.random() * 9);
				int o = (int) (Math.random() * 9);
				String option3_ = Integer.toString(kk) + Integer.toString(ll) + Integer.toString(mm) + Integer.toString(n) + Integer.toString(o);
				
				int p = (int) (Math.random() * 9);
				int q = (int) (Math.random() * 9);
				int r = (int) (Math.random() * 9);
				int s = (int) (Math.random() * 9);
				int t = (int) (Math.random() * 9);
				String option4_ = Integer.toString(p) + Integer.toString(q) + Integer.toString(r) + Integer.toString(s) + Integer.toString(t);
				
				Connection con = null;
			   // Statement start = null;
			    
			    JFrame je = new JFrame();
			    
			  /*  try {
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					start = con.createStatement();
					PreparedStatement st = con.prepareStatement("INSERT INTO questions(QUESTION_ID,QUIZ_ID,QUESTION_SCORE,CONTENT) VALUES (?,?,?,?)");
					st.setString(1, questionid);
					st.setString(2, quizid);
					st.setInt(3, Integer.parseInt(score.getText()));
					st.setString(4, question.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(je, "QUESTION ADDED");
					
				}
				catch (Exception err) {
					err.printStackTrace();
				} */
			    
				if (option1.isSelected()) {
					
					try {
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						//start = con.createStatement();
						PreparedStatement st = con.prepareStatement("INSERT INTO questions(QUESTION_ID,QUIZ_ID,QUESTION_SCORE,CONTENT) VALUES (?,?,?,?)");
						st.setString(1, questionid);
						st.setString(2, quizid);
						st.setInt(3, Integer.parseInt(score.getText()));
						st.setString(4, question.getText());
						st.executeUpdate();
						//JOptionPane.showMessageDialog(je, "QUESTION ADDED");
						
						PreparedStatement o1 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o1.setString(1, option1_);
						o1.setString(2, questionid);
						o1.setString(3, quizid);
						o1.setString(4, option_1.getText());
						o1.setInt(5, 1);
						
						PreparedStatement o2 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o2.setString(1, option2_);
						o2.setString(2, questionid);
						o2.setString(3, quizid);
						o2.setString(4, option_2.getText());
						o2.setInt(5, 0);
						
						PreparedStatement o3 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o3.setString(1, option3_);
						o3.setString(2, questionid);
						o3.setString(3, quizid);
						o3.setString(4, option_3.getText());
						o3.setInt(5, 0);
						
						PreparedStatement o4 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o4.setString(1, option4_);
						o4.setString(2, questionid);
						o4.setString(3, quizid);
						o4.setString(4, option_4.getText());
						o4.setInt(5, 0);
						
						
						o1.executeUpdate();
						o2.executeUpdate();
						o3.executeUpdate();
						o4.executeUpdate();
						
						JOptionPane.showMessageDialog(je, "QUESTION ADDED");
						
						
						
					}
					catch (Exception err) {
						err.printStackTrace();
						JOptionPane.showMessageDialog(je, "ERROR, TRY AGAIN!");
					}
					
				}
				
				if (option2.isSelected()) {
					
					try {
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						//start = con.createStatement();
						PreparedStatement st = con.prepareStatement("INSERT INTO questions(QUESTION_ID,QUIZ_ID,QUESTION_SCORE,CONTENT) VALUES (?,?,?,?)");
						st.setString(1, questionid);
						st.setString(2, quizid);
						st.setInt(3, Integer.parseInt(score.getText()));
						st.setString(4, question.getText());
						st.executeUpdate();
						//JOptionPane.showMessageDialog(je, "QUESTION ADDED");
						
						PreparedStatement o1 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o1.setString(1, option1_);
						o1.setString(2, questionid);
						o1.setString(3, quizid);
						o1.setString(4, option_1.getText());
						o1.setInt(5, 0);
						
						PreparedStatement o2 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o2.setString(1, option2_);
						o2.setString(2, questionid);
						o2.setString(3, quizid);
						o2.setString(4, option_2.getText());
						o2.setInt(5, 1);
						
						PreparedStatement o3 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o3.setString(1, option3_);
						o3.setString(2, questionid);
						o3.setString(3, quizid);
						o3.setString(4, option_3.getText());
						o3.setInt(5, 0);
						
						PreparedStatement o4 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o4.setString(1, option4_);
						o4.setString(2, questionid);
						o4.setString(3, quizid);
						o4.setString(4, option_4.getText());
						o4.setInt(5, 0);
						
						
						o1.executeUpdate();
						o2.executeUpdate();
						o3.executeUpdate();
						o4.executeUpdate();
						
						JOptionPane.showMessageDialog(je, "QUESTION ADDED");
						
						
						
					}
					catch (Exception err) {
						err.printStackTrace();
						JOptionPane.showMessageDialog(je, "ERROR, TRY AGAIN!");
					}
					
					
				}
				
				if (option3.isSelected()) {
					
					try {
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						//start = con.createStatement();
						PreparedStatement st = con.prepareStatement("INSERT INTO questions(QUESTION_ID,QUIZ_ID,QUESTION_SCORE,CONTENT) VALUES (?,?,?,?)");
						st.setString(1, questionid);
						st.setString(2, quizid);
						st.setInt(3, Integer.parseInt(score.getText()));
						st.setString(4, question.getText());
						st.executeUpdate();
						//JOptionPane.showMessageDialog(je, "QUESTION ADDED");
						
						PreparedStatement o1 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o1.setString(1, option1_);
						o1.setString(2, questionid);
						o1.setString(3, quizid);
						o1.setString(4, option_1.getText());
						o1.setInt(5, 0);
						
						PreparedStatement o2 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o2.setString(1, option2_);
						o2.setString(2, questionid);
						o2.setString(3, quizid);
						o2.setString(4, option_2.getText());
						o2.setInt(5, 0);
						
						PreparedStatement o3 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o3.setString(1, option3_);
						o3.setString(2, questionid);
						o3.setString(3, quizid);
						o3.setString(4, option_3.getText());
						o3.setInt(5, 1);
						
						PreparedStatement o4 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o4.setString(1, option4_);
						o4.setString(2, questionid);
						o4.setString(3, quizid);
						o4.setString(4, option_4.getText());
						o4.setInt(5, 0);
						
						
						o1.executeUpdate();
						o2.executeUpdate();
						o3.executeUpdate();
						o4.executeUpdate();
						
						JOptionPane.showMessageDialog(je, "QUESTION ADDED");
						
						
						
					}
					catch (Exception err) {
						err.printStackTrace();
						JOptionPane.showMessageDialog(je, "ERROR, TRY AGAIN!");
					}
					
					
				}
				
				if (option4.isSelected()) {
					
					try {
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						//start = con.createStatement();
						PreparedStatement st = con.prepareStatement("INSERT INTO questions(QUESTION_ID,QUIZ_ID,QUESTION_SCORE,CONTENT) VALUES (?,?,?,?)");
						st.setString(1, questionid);
						st.setString(2, quizid);
						st.setInt(3, Integer.parseInt(score.getText()));
						st.setString(4, question.getText());
						st.executeUpdate();
						//JOptionPane.showMessageDialog(je, "QUESTION ADDED");
						
						PreparedStatement o1 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o1.setString(1, option1_);
						o1.setString(2, questionid);
						o1.setString(3, quizid);
						o1.setString(4, option_1.getText());
						o1.setInt(5, 0);
						
						PreparedStatement o2 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o2.setString(1, option2_);
						o2.setString(2, questionid);
						o2.setString(3, quizid);
						o2.setString(4, option_2.getText());
						o2.setInt(5, 0);
						
						PreparedStatement o3 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o3.setString(1, option3_);
						o3.setString(2, questionid);
						o3.setString(3, quizid);
						o3.setString(4, option_3.getText());
						o3.setInt(5, 0);
						
						PreparedStatement o4 = con.prepareStatement("INSERT INTO answers(ANSWER_ID,QUESTION_ID,QUIZ_ID,CONTENT,isCORRECT) VALUES (?,?,?,?,?)");
						o4.setString(1, option4_);
						o4.setString(2, questionid);
						o4.setString(3, quizid);
						o4.setString(4, option_4.getText());
						o4.setInt(5, 1);
						
						
						o1.executeUpdate();
						o2.executeUpdate();
						o3.executeUpdate();
						o4.executeUpdate();
						
						JOptionPane.showMessageDialog(je, "QUESTION ADDED");
						
						
						
					}
					catch (Exception err) {
						err.printStackTrace();
						JOptionPane.showMessageDialog(je, "ERROR, TRY AGAIN!");
					}
						
					
				}
				
				question.setText("");
				option_1.setText("");
				option_2.setText("");
				option_3.setText("");
				option_4.setText("");
				
				int newscore = quizscore - Integer.parseInt(score.getText());
				
				
				quesinfo.setText("QUESTIONS ADDED: " + clicks + "       MARKS REMAINING: " +  newscore);
				if (clicks == questionums) {
					btnNewButton.setEnabled(false);
				}

				
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(283, 347, 178, 23);
		contentPane.add(btnNewButton);
		
		score = new JTextField();
		score.setBounds(640, 120, 86, 20);
		contentPane.add(score);
		score.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SCORE");
		lblNewLabel_1.setBounds(640, 95, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("FINISH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherHome th = new TeacherHome(hostname,hostid);
				th.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBounds(283, 381, 178, 23);
		contentPane.add(btnNewButton_1);
		
		
		
	}
}
