package quiz_system;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class theQuiz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	String quiz_id;
	String userid;
	String username;
	String[] questionids = new String[5];
	String[] answers = new String[4];
	String[] answerids = new String[4];
	int questionum = 0;
	int totalscore = 0;
	int count = 1;
	
	int initial = 0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					theQuiz frame = new theQuiz("","","");
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
	
	public void storeids(String _quizid) {
		
		Connection c = null;
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
			PreparedStatement	start = c.prepareStatement("SELECT * FROM questions where QUIZ_ID = '" + _quizid + "';");

			ResultSet rs = start.executeQuery();
			
			int i = 0;
			
		while (rs.next()) {
			    String quesid = rs.getString("QUESTION_ID");
			  /*  String quizid = rs.getString("QUIZ_ID");
			    int quescore = rs.getInt("QUESTION_SCORE");
			    String x = String.valueOf(quescore);
			    String content = rs.getString("CONTENT"); */
			    questionids[i] = quesid;
			    i++;
			}	
		}
		catch (Exception fin) {
			fin.printStackTrace();
		}
		
	}
	
	public String firstquestion() {
		Connection c = null;
		int i = 0;
		String quesid = "";
		int quescore = 0;
		String x = "";
		String content = "";
		questionum = 1;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
			PreparedStatement	start = c.prepareStatement("SELECT * FROM questions where QUIZ_ID = '" + questionids[0] + "';");

			ResultSet rs = start.executeQuery();
			
			
		while (rs.next()) {
			   quesid = rs.getString("QUESTION_ID");
			    quescore = rs.getInt("QUESTION_SCORE");
			    x = String.valueOf(quescore);
			    content = rs.getString("CONTENT"); 
			    
			}
	  }
		catch (Exception fin) {
			fin.printStackTrace();
		}
		
		return content;
	}
	
	
	
	public theQuiz(String quizid, String userid, String username) {
		
		int p = (int) (Math.random() * 9);
		int o = (int) (Math.random() * 9);
		int z = (int) (Math.random() * 9);
		int u = (int) (Math.random() * 9);
		int y = (int) (Math.random() * 9);
		String xax = Integer.toString(p) + Integer.toString(o) + Integer.toString(z) + Integer.toString(u) + Integer.toString(y);
		
		this.quiz_id=quizid;
		this.userid=userid;
		this.username=username;
		questionum = 1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea question = new JTextArea();
		question.setEditable(false);
		question.setBackground(SystemColor.control);
		question.setBounds(10, 95, 626, 49);
		contentPane.add(question);
		
		JTextArea question_num = new JTextArea();
		question_num.setEditable(false);
		question_num.setFont(new Font("Monospaced", Font.PLAIN, 16));
		question_num.setBounds(10, 62, 198, 22);
		contentPane.add(question_num);
		
		question_num.setText("QUESTION NUMBER: " + questionum);
		
		JTextArea opt1 = new JTextArea();
		opt1.setBackground(SystemColor.control);
		opt1.setBounds(37, 155, 685, 39);
		contentPane.add(opt1);
		
		JTextArea opt2 = new JTextArea();
		opt2.setBackground(SystemColor.menu);
		opt2.setBounds(37, 205, 685, 39);
		contentPane.add(opt2);
		
		JTextArea opt3 = new JTextArea();
		opt3.setBackground(SystemColor.menu);
		opt3.setBounds(37, 255, 685, 39);
		contentPane.add(opt3);
		
		JTextArea opt4 = new JTextArea();
		opt4.setBackground(SystemColor.menu);
		opt4.setBounds(37, 305, 685, 39);
		contentPane.add(opt4);
		
		JRadioButton option1 = new JRadioButton("");
		option1.setBackground(SystemColor.text);
		option1.setBounds(10, 156, 21, 23);
		contentPane.add(option1);
		
		JRadioButton option2 = new JRadioButton("");
		option2.setBackground(SystemColor.text);
		option2.setBounds(10, 206, 21, 23);
		contentPane.add(option2);
		
		JRadioButton option3 = new JRadioButton("");
		option3.setBackground(SystemColor.text);
		option3.setBounds(10, 256, 21, 23);
		contentPane.add(option3);
		
		JRadioButton option4 = new JRadioButton("");
		option4.setBackground(SystemColor.text);
		option4.setBounds(10, 305, 21, 23);
		contentPane.add(option4);
		
		ButtonGroup button = new ButtonGroup();
		button.add(option4);
		button.add(option3);
		button.add(option2);
		button.add(option1);
		
		
		
		
		JTextArea score = new JTextArea();
		score.setBackground(SystemColor.inactiveCaption);
		score.setBounds(646, 122, 76, 22);
		contentPane.add(score);
		
		JLabel lblNewLabel = new JLabel("POINTS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(646, 97, 76, 14);
		contentPane.add(lblNewLabel);
		
		Connection c = null;
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
			PreparedStatement	start = c.prepareStatement("SELECT * FROM questions where QUIZ_ID = '" + quiz_id + "';");

			ResultSet rs = start.executeQuery();
			
			int i = 0;
			
		while (rs.next()) {
			    String quesid = rs.getString("QUESTION_ID");
			    questionids[i] = quesid;
			    i++;
			}	
		}
		catch (Exception fin) {
			fin.printStackTrace();
		}
		
		System.out.println(questionids[0]);
		System.out.println(questionids[1]);
		System.out.println(questionids[2]);
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
			PreparedStatement	start = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[0] + "';");

			ResultSet rs = start.executeQuery();
			
			
		while (rs.next()) {
			   String quesid = rs.getString("QUESTION_ID");
			  int quescore = rs.getInt("QUESTION_SCORE");
			   String x = String.valueOf(quescore);
			    String content = rs.getString("CONTENT"); 
			    question.setText(content);
			    score.setText(x);
			}
		}
		catch (Exception fin) {
			fin.printStackTrace();
		}
		
		try {
			int a = 0;
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
			PreparedStatement	start = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + questionids[0] + "';");

			ResultSet rs = start.executeQuery();
			
			
		while (rs.next()) {
			   String ansids = rs.getString("ANSWER_ID");
			   String answer = rs.getString("content");
			   answers[a] = answer;
			   answerids[a] = ansids;
			   a++;
			   
			}
		
		opt1.setText(answers[0] + " " + answerids[0]);
		opt2.setText(answers[1] + " " + answerids[1]);
		opt3.setText(answers[2] + " " + answerids[2]);
		opt4.setText(answers[3] + " " + answerids[3]);
		}
		catch (Exception fin) {
			fin.printStackTrace();
		}
		
		
		
		JButton btnNewButton = new JButton("SAVE & NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionum++;
				question_num.setText("QUESTION NUMBER: " + questionum);
				question.setText("");
				opt1.setText("");
				opt2.setText("");
				opt3.setText("");
				opt4.setText("");
				score.setText("");
				
				/*if (initial == questionids.length-1) {
					//btnNewButton.setEnabled(false);
					JFrame jc = new JFrame();
					JOptionPane.showMessageDialog(jc, "SUBMITTED");
					Connection c = null;
					Statement start = null;
					
					try {
						
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
						LocalDateTime now = LocalDateTime.now();
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						start = c.createStatement();
						PreparedStatement st = c.prepareStatement("INSERT INTO take(TAKE_ID,USER_ID,QUIZ_ID,SCORE,FINISHED,postGrade) VALUES (?,?,?,?,?,?)");
						
						st.setString(1, xax);
						st.setString(2, userid);
						st.setString(3, quizid);
						st.setInt(4, totalscore);
						st.setString(5, dtf.format(now));
						st.setInt(6, 0);
						

						st.executeUpdate();
						

						
					}
					
					catch (Exception take) {
						take.printStackTrace();
					}
					
					StudentHome sc = new StudentHome(userid,username);
					sc.setVisible(true);
					dispose();
					
				}  */
				
				
				 if (option1.isSelected()) {
					String ans = opt1.getText();
					
					Connection c = null;
					try {
						int iscorr = 0;
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						PreparedStatement	start = c.prepareStatement("SELECT * FROM answers where ANSWER_ID = '" + answerids[0] + "';");
						ResultSet rs = start.executeQuery();
						
						while(rs.next()) {
							 iscorr = rs.getInt("isCorrect");
						}
						
						if(iscorr == 1) {
							int sc = 0;
							PreparedStatement	q1 = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[initial] + "';");
							ResultSet rs2 = q1.executeQuery();
							while(rs2.next()) {
								 sc = rs2.getInt("QUESTION_SCORE");
							}
							totalscore = totalscore + sc;
							
							if (initial == questionids.length-1) {
								//btnNewButton.setEnabled(false);
								JFrame jc = new JFrame();
								JOptionPane.showMessageDialog(jc, "SUBMITTED");
								 c = null;
								//Statement start = null;
								
								try {
									
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
									LocalDateTime now = LocalDateTime.now();
									c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
									//start = c.createStatement();
									PreparedStatement st = c.prepareStatement("INSERT INTO take(TAKE_ID,USER_ID,QUIZ_ID,SCORE,FINISHED,postGrade) VALUES (?,?,?,?,?,?)");
									
									st.setString(1, xax);
									st.setString(2, userid);
									st.setString(3, quizid);
									st.setInt(4, totalscore);
									st.setString(5, dtf.format(now));
									st.setInt(6, 0);
									

									st.executeUpdate();
									

									
								}
								
								catch (Exception take) {
									take.printStackTrace();
								}
								
								StudentHome sca = new StudentHome(userid,username);
								sca.setVisible(true);
								dispose();
								
							}
							
							PreparedStatement	newques = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[count] + "';");

							ResultSet rs3 = newques.executeQuery();
							
							
						while (rs3.next()) {
							   String quesid = rs3.getString("QUESTION_ID");
							  int quescore = rs3.getInt("QUESTION_SCORE");
							   String x = String.valueOf(quescore);
							    String content = rs3.getString("CONTENT"); 
							    question.setText(content);
							    score.setText(x);
							    
							}
						
						int a = 0;
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						PreparedStatement	printans = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + questionids[count] + "';");

						ResultSet rs4 = printans.executeQuery();
						
						
					while (rs4.next()) {
						   String ansids = rs4.getString("ANSWER_ID");
						   String answer = rs4.getString("content");
						   answers[a] = answer;
						   answerids[a] = ansids;
						   a++;
						   
						}
					
					opt1.setText(answers[0] + " " + answerids[0]);
					opt2.setText(answers[1] + " " + answerids[1]);
					opt3.setText(answers[2] + " " + answerids[2]);
					opt4.setText(answers[3] + " " + answerids[3]);
							count++;
							initial++;
							
						}
						
						if(iscorr == 0) {
							
							if (initial == questionids.length-1) {
								//btnNewButton.setEnabled(false);
								JFrame jc = new JFrame();
								JOptionPane.showMessageDialog(jc, "SUBMITTED");
								 c = null;
								//Statement start = null;
								
								try {
									
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
									LocalDateTime now = LocalDateTime.now();
									c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
									//start = c.createStatement();
									PreparedStatement st = c.prepareStatement("INSERT INTO take(TAKE_ID,USER_ID,QUIZ_ID,SCORE,FINISHED,postGrade) VALUES (?,?,?,?,?,?)");
									
									st.setString(1, xax);
									st.setString(2, userid);
									st.setString(3, quizid);
									st.setInt(4, totalscore);
									st.setString(5, dtf.format(now));
									st.setInt(6, 0);
									

									st.executeUpdate();
									

									
								}
								
								catch (Exception take) {
									take.printStackTrace();
								}
								
								StudentHome sca = new StudentHome(userid,username);
								sca.setVisible(true);
								dispose();
								
							}
								
								PreparedStatement	newques = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[count] + "';");

								ResultSet rs3 = newques.executeQuery();
								
								
							while (rs3.next()) {
								   String quesid = rs3.getString("QUESTION_ID");
								  int quescore = rs3.getInt("QUESTION_SCORE");
								   String x = String.valueOf(quescore);
								    String content = rs3.getString("CONTENT"); 
								    question.setText(content);
								    score.setText(x);
								    
								}
							
							int a = 0;
							c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
							PreparedStatement	printans = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + questionids[count] + "';");

							ResultSet rs4 = printans.executeQuery();
							
							
						while (rs4.next()) {
							   String ansids = rs4.getString("ANSWER_ID");
							   String answer = rs4.getString("content");
							   answers[a] = answer;
							   answerids[a] = ansids;
							   a++;
							   
							}
						
						opt1.setText(answers[0] + " " + answerids[0]);
						opt2.setText(answers[1] + " " + answerids[1]);
						opt3.setText(answers[2] + " " + answerids[2]);
						opt4.setText(answers[3] + " " + answerids[3]);
								count++;
								initial++;
								
							}
						}
					
					
					catch (Exception atm) {
						
					}
					
					
					
				}
				
				if (option2.isSelected()) {
					String ans = opt2.getText();
					
					Connection c = null;
					try {
						int iscorr = 0;
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						PreparedStatement	start = c.prepareStatement("SELECT * FROM answers where ANSWER_ID = '" + answerids[1] + "';");
						ResultSet rs = start.executeQuery();
						
						while(rs.next()) {
							 iscorr = rs.getInt("isCorrect");
						}
						
						if(iscorr == 1) {
							int sc = 0;
							PreparedStatement	q1 = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[initial] + "';");
							ResultSet rs2 = q1.executeQuery();
							while(rs2.next()) {
								 sc = rs2.getInt("QUESTION_SCORE");
							}
							totalscore = totalscore + sc;
							
							if (initial == questionids.length-1) {
								//btnNewButton.setEnabled(false);
								JFrame jc = new JFrame();
								JOptionPane.showMessageDialog(jc, "SUBMITTED");
								 c = null;
								//Statement start = null;
								
								try {
									
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
									LocalDateTime now = LocalDateTime.now();
									c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
									//start = c.createStatement();
									PreparedStatement st = c.prepareStatement("INSERT INTO take(TAKE_ID,USER_ID,QUIZ_ID,SCORE,FINISHED,postGrade) VALUES (?,?,?,?,?,?)");
									
									st.setString(1, xax);
									st.setString(2, userid);
									st.setString(3, quizid);
									st.setInt(4, totalscore);
									st.setString(5, dtf.format(now));
									st.setInt(6, 0);
									

									st.executeUpdate();
									

									
								}
								
								catch (Exception take) {
									take.printStackTrace();
								}
								
								StudentHome sca = new StudentHome(userid,username);
								sca.setVisible(true);
								dispose();
								
							}
							
							PreparedStatement	newques = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[count] + "';");

							ResultSet rs3 = newques.executeQuery();
							
							
						while (rs3.next()) {
							   String quesid = rs3.getString("QUESTION_ID");
							  int quescore = rs3.getInt("QUESTION_SCORE");
							   String x = String.valueOf(quescore);
							    String content = rs3.getString("CONTENT"); 
							    question.setText(content);
							    score.setText(x);
							    
							}
						
						int a = 0;
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						PreparedStatement	printans = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + questionids[count] + "';");

						ResultSet rs4 = printans.executeQuery();
						
						
					while (rs4.next()) {
						   String ansids = rs4.getString("ANSWER_ID");
						   String answer = rs4.getString("content");
						   answers[a] = answer;
						   answerids[a] = ansids;
						   a++;
						   
						}
					
					opt1.setText(answers[0] + " " + answerids[0]);
					opt2.setText(answers[1] + " " + answerids[1]);
					opt3.setText(answers[2] + " " + answerids[2]);
					opt4.setText(answers[3] + " " + answerids[3]);
							count++;
							initial++;
							
						}
						
						if(iscorr == 0) {
							
							if (initial == questionids.length-1) {
								//btnNewButton.setEnabled(false);
								JFrame jc = new JFrame();
								JOptionPane.showMessageDialog(jc, "SUBMITTED");
								 c = null;
								//Statement start = null;
								
								try {
									
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
									LocalDateTime now = LocalDateTime.now();
									c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
									//start = c.createStatement();
									PreparedStatement st = c.prepareStatement("INSERT INTO take(TAKE_ID,USER_ID,QUIZ_ID,SCORE,FINISHED,postGrade) VALUES (?,?,?,?,?,?)");
									
									st.setString(1, xax);
									st.setString(2, userid);
									st.setString(3, quizid);
									st.setInt(4, totalscore);
									st.setString(5, dtf.format(now));
									st.setInt(6, 0);
									

									st.executeUpdate();
									

									
								}
								
								catch (Exception take) {
									take.printStackTrace();
								}
								
								StudentHome sca = new StudentHome(userid,username);
								sca.setVisible(true);
								dispose();
								
							}
								
								PreparedStatement	newques = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[count] + "';");

								ResultSet rs3 = newques.executeQuery();
								
								
							while (rs3.next()) {
								   String quesid = rs3.getString("QUESTION_ID");
								  int quescore = rs3.getInt("QUESTION_SCORE");
								   String x = String.valueOf(quescore);
								    String content = rs3.getString("CONTENT"); 
								    question.setText(content);
								    score.setText(x);
								    
								}
							
							int a = 0;
							c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
							PreparedStatement	printans = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + questionids[count] + "';");

							ResultSet rs4 = printans.executeQuery();
							
							
						while (rs4.next()) {
							   String ansids = rs4.getString("ANSWER_ID");
							   String answer = rs4.getString("content");
							   answers[a] = answer;
							   answerids[a] = ansids;
							   a++;
							   
							}
						
						opt1.setText(answers[0] + " " + answerids[0]);
						opt2.setText(answers[1] + " " + answerids[1]);
						opt3.setText(answers[2] + " " + answerids[2]);
						opt4.setText(answers[3] + " " + answerids[3]);
								count++;
								initial++;
								
							}
						}
					
					
					catch (Exception atm) {
						
					}
					
					
			  }

				if (option3.isSelected()) {
					String ans = opt3.getText();
					
					Connection c = null;
					try {
						int iscorr = 0;
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						PreparedStatement	start = c.prepareStatement("SELECT * FROM answers where ANSWER_ID = '" + answerids[2] + "';");
						ResultSet rs = start.executeQuery();
						
						while(rs.next()) {
							 iscorr = rs.getInt("isCorrect");
						}
						
						if(iscorr == 1) {
							int sc = 0;
							PreparedStatement	q1 = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[initial] + "';");
							ResultSet rs2 = q1.executeQuery();
							while(rs2.next()) {
								 sc = rs2.getInt("QUESTION_SCORE");
							}
							totalscore = totalscore + sc;
							
							if (initial == questionids.length-1) {
								//btnNewButton.setEnabled(false);
								JFrame jc = new JFrame();
								JOptionPane.showMessageDialog(jc, "SUBMITTED");
								 c = null;
								//Statement start = null;
								
								try {
									
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
									LocalDateTime now = LocalDateTime.now();
									c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
									//start = c.createStatement();
									PreparedStatement st = c.prepareStatement("INSERT INTO take(TAKE_ID,USER_ID,QUIZ_ID,SCORE,FINISHED,postGrade) VALUES (?,?,?,?,?,?)");
									
									st.setString(1, xax);
									st.setString(2, userid);
									st.setString(3, quizid);
									st.setInt(4, totalscore);
									st.setString(5, dtf.format(now));
									st.setInt(6, 0);
									

									st.executeUpdate();
									

									
								}
								
								catch (Exception take) {
									take.printStackTrace();
								}
								
								StudentHome sca = new StudentHome(userid,username);
								sca.setVisible(true);
								dispose();
								
							}
							PreparedStatement	newques = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[count] + "';");

							ResultSet rs3 = newques.executeQuery();
							
							
						while (rs3.next()) {
							   String quesid = rs3.getString("QUESTION_ID");
							  int quescore = rs3.getInt("QUESTION_SCORE");
							   String x = String.valueOf(quescore);
							    String content = rs3.getString("CONTENT"); 
							    question.setText(content);
							    score.setText(x);
							    
							}
						
						int a = 0;
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						PreparedStatement	printans = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + questionids[count] + "';");

						ResultSet rs4 = printans.executeQuery();
						
						
					while (rs4.next()) {
						   String ansids = rs4.getString("ANSWER_ID");
						   String answer = rs4.getString("content");
						   answers[a] = answer;
						   answerids[a] = ansids;
						   a++;
						   
						}
					
					opt1.setText(answers[0] + " " + answerids[0]);
					opt2.setText(answers[1] + " " + answerids[1]);
					opt3.setText(answers[2] + " " + answerids[2]);
					opt4.setText(answers[3] + " " + answerids[3]);
							count++;
							initial++;
							
						}
						
						if(iscorr == 0) {
							
							if (initial == questionids.length-1) {
								//btnNewButton.setEnabled(false);
								JFrame jc = new JFrame();
								JOptionPane.showMessageDialog(jc, "SUBMITTED");
								 c = null;
								//Statement start = null;
								
								try {
									
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
									LocalDateTime now = LocalDateTime.now();
									c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
									//start = c.createStatement();
									PreparedStatement st = c.prepareStatement("INSERT INTO take(TAKE_ID,USER_ID,QUIZ_ID,SCORE,FINISHED,postGrade) VALUES (?,?,?,?,?,?)");
									
									st.setString(1, xax);
									st.setString(2, userid);
									st.setString(3, quizid);
									st.setInt(4, totalscore);
									st.setString(5, dtf.format(now));
									st.setInt(6, 0);
									

									st.executeUpdate();
									

									
								}
								
								catch (Exception take) {
									take.printStackTrace();
								}
								
								StudentHome sca = new StudentHome(userid,username);
								sca.setVisible(true);
								dispose();
								
							}
								
								PreparedStatement	newques = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[count] + "';");

								ResultSet rs3 = newques.executeQuery();
								
								
							while (rs3.next()) {
								   String quesid = rs3.getString("QUESTION_ID");
								  int quescore = rs3.getInt("QUESTION_SCORE");
								   String x = String.valueOf(quescore);
								    String content = rs3.getString("CONTENT"); 
								    question.setText(content);
								    score.setText(x);
								    
								}
							
							int a = 0;
							c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
							PreparedStatement	printans = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + questionids[count] + "';");

							ResultSet rs4 = printans.executeQuery();
							
							
						while (rs4.next()) {
							   String ansids = rs4.getString("ANSWER_ID");
							   String answer = rs4.getString("content");
							   answers[a] = answer;
							   answerids[a] = ansids;
							   a++;
							   
							}
						
						opt1.setText(answers[0] + " " + answerids[0]);
						opt2.setText(answers[1] + " " + answerids[1]);
						opt3.setText(answers[2] + " " + answerids[2]);
						opt4.setText(answers[3] + " " + answerids[3]);
								count++;
								initial++;
								
							}
						}
					
					
					catch (Exception atm) {
						
					}
					
					
				}

				if (option4.isSelected()) {
					String ans = opt4.getText();
					
					Connection c = null;
					try {
						int iscorr = 0;
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						PreparedStatement	start = c.prepareStatement("SELECT * FROM answers where ANSWER_ID = '" + answerids[3] + "';");
						ResultSet rs = start.executeQuery();
						
						while(rs.next()) {
							 iscorr = rs.getInt("isCorrect");
						}
						
						if(iscorr == 1) {
							int sc = 0;
							PreparedStatement	q1 = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[initial] + "';");
							ResultSet rs2 = q1.executeQuery();
							while(rs2.next()) {
								 sc = rs2.getInt("QUESTION_SCORE");
							}
							totalscore = totalscore + sc;
							
							if (initial == questionids.length-1) {
								//btnNewButton.setEnabled(false);
								JFrame jc = new JFrame();
								JOptionPane.showMessageDialog(jc, "SUBMITTED");
								 c = null;
								//Statement start = null;
								
								try {
									
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
									LocalDateTime now = LocalDateTime.now();
									c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
									//start = c.createStatement();
									PreparedStatement st = c.prepareStatement("INSERT INTO take(TAKE_ID,USER_ID,QUIZ_ID,SCORE,FINISHED,postGrade) VALUES (?,?,?,?,?,?)");
									
									st.setString(1, xax);
									st.setString(2, userid);
									st.setString(3, quizid);
									st.setInt(4, totalscore);
									st.setString(5, dtf.format(now));
									st.setInt(6, 0);
									

									st.executeUpdate();
									

									
								}
								
								catch (Exception take) {
									take.printStackTrace();
								}
								
								StudentHome sca = new StudentHome(userid,username);
								sca.setVisible(true);
								dispose();
								
							}
							
							PreparedStatement	newques = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[count] + "';");

							ResultSet rs3 = newques.executeQuery();
							
							
						while (rs3.next()) {
							   String quesid = rs3.getString("QUESTION_ID");
							  int quescore = rs3.getInt("QUESTION_SCORE");
							   String x = String.valueOf(quescore);
							    String content = rs3.getString("CONTENT"); 
							    question.setText(content);
							    score.setText(x);
							    
							}
						
						int a = 0;
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						PreparedStatement	printans = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + questionids[count] + "';");

						ResultSet rs4 = printans.executeQuery();
						
						
					while (rs4.next()) {
						   String ansids = rs4.getString("ANSWER_ID");
						   String answer = rs4.getString("content");
						   answers[a] = answer;
						   answerids[a] = ansids;
						   a++;
						   
						}
					
					opt1.setText(answers[0] + " " + answerids[0]);
					opt2.setText(answers[1] + " " + answerids[1]);
					opt3.setText(answers[2] + " " + answerids[2]);
					opt4.setText(answers[3] + " " + answerids[3]);
							count++;
							initial++;
							
						}
						
						if(iscorr == 0) {
							
							if (initial == questionids.length-1) {
								//btnNewButton.setEnabled(false);
								JFrame jc = new JFrame();
								JOptionPane.showMessageDialog(jc, "SUBMITTED");
								 c = null;
								//Statement start = null;
								
								try {
									
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
									LocalDateTime now = LocalDateTime.now();
									c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
									//start = c.createStatement();
									PreparedStatement st = c.prepareStatement("INSERT INTO take(TAKE_ID,USER_ID,QUIZ_ID,SCORE,FINISHED,postGrade) VALUES (?,?,?,?,?,?)");
									
									st.setString(1, xax);
									st.setString(2, userid);
									st.setString(3, quizid);
									st.setInt(4, totalscore);
									st.setString(5, dtf.format(now));
									st.setInt(6, 0);
									

									st.executeUpdate();
									

									
								}
								
								catch (Exception take) {
									take.printStackTrace();
								}
								
								StudentHome sca = new StudentHome(userid,username);
								sca.setVisible(true);
								dispose();
								
							}
								
								PreparedStatement	newques = c.prepareStatement("SELECT * FROM questions where QUESTION_ID = '" + questionids[count] + "';");

								ResultSet rs3 = newques.executeQuery();
								
								
							while (rs3.next()) {
								   String quesid = rs3.getString("QUESTION_ID");
								  int quescore = rs3.getInt("QUESTION_SCORE");
								   String x = String.valueOf(quescore);
								    String content = rs3.getString("CONTENT"); 
								    question.setText(content);
								    score.setText(x);
								    
								}
							
							int a = 0;
							c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
							PreparedStatement	printans = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + questionids[count] + "';");

							ResultSet rs4 = printans.executeQuery();
							
							
						while (rs4.next()) {
							   String ansids = rs4.getString("ANSWER_ID");
							   String answer = rs4.getString("content");
							   answers[a] = answer;
							   answerids[a] = ansids;
							   a++;
							   
							}
						
						opt1.setText(answers[0] + " " + answerids[0]);
						opt2.setText(answers[1] + " " + answerids[1]);
						opt3.setText(answers[2] + " " + answerids[2]);
						opt4.setText(answers[3] + " " + answerids[3]);
								count++;
								initial++;
								
							}
						}
					
					
					catch (Exception atm) {
						
					}
					
					
				}
				
		//		JFrame quizscore = new JFrame();
			//	JOptionPane.showMessageDialog(quizscore, "YOU SCORED: " + totalscore);
				
				if (initial == questionids.length-1) {
					//btnNewButton.setEnabled(false);
					btnNewButton.setText("SAVE & SUBMIT");
					
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(300, 355, 131, 23);
		contentPane.add(btnNewButton);
		
		JTextArea takeid = new JTextArea();
		takeid.setEditable(false);
		takeid.setFont(new Font("Monospaced", Font.PLAIN, 15));
		takeid.setBounds(10, 11, 228, 22);
		contentPane.add(takeid);
		
		takeid.setText("ATTEMPT ID: " + xax);
		
		
		
		
		
		
	}
}
