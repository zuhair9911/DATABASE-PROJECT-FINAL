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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class editquiz extends JFrame {

	private JPanel contentPane;
	private JTable edittable;

	/**
	 * Launch the application.
	 */
	
	String name;
	String id;
	String quizid;
	//String deadline;
	private JTextField getqid;
	private JTextField id_answer;
	private JTextField id_questions;
	private JTextArea answer_edit1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editquiz frame = new editquiz("","","");
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
	public editquiz(String name, String id, String quizid) {
		this.name=name;
		this.id=id;
		this.quizid=quizid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.controlText);
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		textArea.setBackground(new Color(0, 0, 128));
		textArea.setForeground(SystemColor.text);
		textArea.setBounds(10, 50, 171, 58);
		contentPane.add(textArea);
		
		textArea.setText("HOST NAME: " + name + "     \nHOST ID: " + id + "     \nQUIZ ID: " + quizid);
		
		
		JLabel lblNewLabel = new JLabel("EDIT QUIZ");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(316, 14, 95, 25);
		contentPane.add(lblNewLabel);
		
		edittable = new JTable();
		edittable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		edittable.setBackground(SystemColor.inactiveCaption);
		edittable.setBounds(217, 115, 505, 355);
		contentPane.add(edittable);
		
		JButton btnNewButton = new JButton("GO BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewQuiz vq = new ViewQuiz(name,id);
				vq.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(10, 16, 89, 23);
		contentPane.add(btnNewButton);
		
		JRadioButton selquiz = new JRadioButton("VIEW QUIZ INFO");
		selquiz.setFont(new Font("Tahoma", Font.PLAIN, 11));
		selquiz.setBackground(SystemColor.text);
		selquiz.setBounds(224, 52, 109, 23);
		contentPane.add(selquiz);
		
		JRadioButton quesview = new JRadioButton("VIEW QUESTIONS");
		quesview.setFont(new Font("Tahoma", Font.PLAIN, 11));
		quesview.setBackground(SystemColor.text);
		quesview.setBounds(352, 52, 113, 23);
		contentPane.add(quesview);
		
		JRadioButton ansview = new JRadioButton("VIEW ANSWERS");
		ansview.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ansview.setBackground(SystemColor.text);
		ansview.setBounds(482, 52, 109, 23);
		contentPane.add(ansview);
		
		getqid = new JTextField();
		getqid.setBounds(597, 52, 121, 20);
		contentPane.add(getqid);
		getqid.setColumns(10);
		
		ButtonGroup bq = new ButtonGroup();
		bq.add(selquiz);
		bq.add(ansview);
		bq.add(quesview);
		
		JTextArea editdeadline = new JTextArea();
		editdeadline.setBackground(SystemColor.controlHighlight);
		editdeadline.setBounds(10, 158, 197, 23);
		contentPane.add(editdeadline);
		
		JRadioButton deadlinechange = new JRadioButton("EDIT DEADLINE");
		deadlinechange.setBackground(Color.WHITE);
		deadlinechange.setBounds(10, 128, 109, 23);
		contentPane.add(deadlinechange);
		
		JTextArea questionedit = new JTextArea();
		questionedit.setBackground(SystemColor.controlHighlight);
		questionedit.setBounds(10, 280, 197, 22);
		contentPane.add(questionedit);
		
		JTextArea answer_edit;
		answer_edit1 = new JTextArea();
		answer_edit1.setBackground(SystemColor.controlHighlight);
		answer_edit1.setBounds(10, 414, 197, 22);
		contentPane.add(answer_edit1);
		
		JRadioButton qedit = new JRadioButton("EDIT QUESTION CONTENT");
		qedit.setBackground(SystemColor.text);
		qedit.setBounds(10, 227, 197, 20);
		contentPane.add(qedit);
		
		JButton btnNewButton_1 = new JButton("VIEW");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) edittable.getModel();
				model.setRowCount(0);
				
				Connection c = null;
				//Statement start = null;
				
				
					
				if (selquiz.isSelected() || deadlinechange.isSelected()) {
					
					try {
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						//start = c.createStatement();
						PreparedStatement	start = c.prepareStatement("SELECT * FROM QUIZ where QUIZ_ID = '" + quizid + "';");

						ResultSet rs = start.executeQuery();
						
						while (rs.next()) {
						    String quizid = rs.getString("QUIZ_ID");
						    String hostid = rs.getString("HOST_ID");
						    String title = rs.getString("TITLE");
						    String score = rs.getString("SCORE");
						    String created = rs.getString("CREATED");
						    String noques = String.valueOf(rs.getInt("no_of_questions"));
						    String startsat = rs.getString("startsat");
						    String endsat = rs.getString("submission");
						    // create a single array of one row's worth of data
						    String[] data = { quizid,hostid,title,score,created,noques,startsat,endsat } ;

						    // and add this row of data into the table model
						  
						 DefaultTableModel tblModel = (DefaultTableModel)edittable.getModel();
						 //tblModel.setColumnIdentifiers(columnName);
						  tblModel.addRow(data);
						  editdeadline.setText(endsat);
						}
					}
					
					catch (Exception a) {
						a.printStackTrace();
					}
					
				}
				
				if (quesview.isSelected()) {
					
					try {
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						//start = c.createStatement();
						PreparedStatement	start = c.prepareStatement("SELECT * FROM questions where QUIZ_ID = '" + quizid + "';");

						ResultSet rs = start.executeQuery();
						
						while (rs.next()) {
						    String quesid = rs.getString("QUESTION_ID");
						    String quizid = rs.getString("QUIZ_ID");
						    int quescore = rs.getInt("QUESTION_SCORE");
						    String x = String.valueOf(quescore);
						    String content = rs.getString("CONTENT");
						    //String created = rs.getString("CREATED");
						    // create a single array of one row's worth of data
						    String[] data = { quesid,quizid,x,content };

						    // and add this row of data into the table model
						  
						 DefaultTableModel tblModel = (DefaultTableModel)edittable.getModel();
						 //tblModel.setColumnIdentifiers(columnName);
						  tblModel.addRow(data);
						}
					}
					
					catch (Exception a) {
						a.printStackTrace();
					}
					
				}
				
				if (ansview.isSelected()) {
					
					try {
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						//start = c.createStatement();
						PreparedStatement	start = c.prepareStatement("SELECT * FROM answers where QUESTION_ID = '" + getqid.getText() + "';");

						ResultSet rs = start.executeQuery();
						
						while (rs.next()) {
						    String ansid = rs.getString("ANSWER_ID");
						    String quesid = rs.getString("QUESTION_ID");
						    String quizid = rs.getString("QUIZ_ID");
						    String content = rs.getString("CONTENT");
						    int iscorr = rs.getInt("isCORRECT");
						    String x = String.valueOf(iscorr);
						    
						    //String created = rs.getString("CREATED");
						    // create a single array of one row's worth of data
						    String[] data = { ansid,quesid,quizid,content,x };

						    // and add this row of data into the table model
						  
						 DefaultTableModel tblModel = (DefaultTableModel)edittable.getModel();
						 //tblModel.setColumnIdentifiers(columnName);
						  tblModel.addRow(data);
						}
					}
					
					catch (Exception a) {
						a.printStackTrace();
					}
				}
			
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBounds(217, 81, 501, 23);
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(228, 241, 5, 22);
		contentPane.add(textArea_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jx = new JFrame();
				try {
				Connection c = null;
				Statement start = null;
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
				start = c.createStatement();
				String sql = "UPDATE quiz SET submission ='" + editdeadline.getText() + "' WHERE QUIZ_ID ='" + quizid + "'";
				//start = c.createStatement();
				//PreparedStatement start = c.prepareStatement("UPDATE quiz SET submission ='" + editdeadline.getText() + "' WHERE QUIZ_ID = '" + quizid + "';");
				start.execute(sql);
				JOptionPane.showMessageDialog(jx, "DEADLINE EDITED!");
				}
				catch (Exception eee) {
					eee.printStackTrace();
					JOptionPane.showMessageDialog(jx, "ERROR");
				}
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(10, 192, 197, 24);
		contentPane.add(btnNewButton_2);
		
		
		
		
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jk = new JFrame();
				try {
					
					Connection c = null;
					Statement start = null;
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					start = c.createStatement();
					String sql = "UPDATE questions SET content ='" + questionedit.getText() + "' WHERE QUESTION_ID ='" + id_questions.getText() + "'";
					//start = c.createStatement();
					//PreparedStatement start = c.prepareStatement("UPDATE quiz SET submission ='" + editdeadline.getText() + "' WHERE QUIZ_ID = '" + quizid + "';");
					start.execute(sql);
					JOptionPane.showMessageDialog(jk, "QUESTION EDITED!");
					
					
				}
				
				catch (Exception ow) {
					ow.printStackTrace();
					JOptionPane.showMessageDialog(jk, "ERROR");
				}
			}
		});
		btnNewButton_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3.setForeground(SystemColor.text);
		btnNewButton_3.setBounds(10, 313, 197, 23);
		contentPane.add(btnNewButton_3);
		
		JRadioButton answeredit = new JRadioButton("EDIT ANSWER CONTENT");
		answeredit.setBackground(SystemColor.text);
		answeredit.setBounds(10, 358, 197, 23);
		contentPane.add(answeredit);
		
		
		
		JButton btnNewButton_4 = new JButton("UPDATE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jk = new JFrame();
				try {
					
					Connection c = null;
					Statement start = null;
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					start = c.createStatement();
					String sql = "UPDATE answers SET content ='" + answer_edit1.getText() + "' WHERE ANSWER_ID ='" + id_answer.getText() + "'";
					//start = c.createStatement();
					//PreparedStatement start = c.prepareStatement("UPDATE quiz SET submission ='" + editdeadline.getText() + "' WHERE QUIZ_ID = '" + quizid + "';");
					start.execute(sql);
					JOptionPane.showMessageDialog(jk, "ANSWER EDITED!");
					
					
				}
				
				catch (Exception ow) {
					ow.printStackTrace();
					JOptionPane.showMessageDialog(jk, "ERROR");
				}
			}
			
		});
		btnNewButton_4.setForeground(SystemColor.text);
		btnNewButton_4.setBackground(new Color(0, 0, 128));
		btnNewButton_4.setBounds(10, 447, 197, 23);
		contentPane.add(btnNewButton_4);
		
		id_answer = new JTextField();
		id_answer.setBounds(10, 383, 197, 20);
		contentPane.add(id_answer);
		id_answer.setColumns(10);
		
		id_questions = new JTextField();
		id_questions.setBounds(10, 249, 197, 20);
		contentPane.add(id_questions);
		id_questions.setColumns(10);
		
		bq.add(answeredit);
		bq.add(qedit);
		bq.add(deadlinechange);
		
		JButton btnNewButton_5 = new JButton("POST GRADES");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame jk = new JFrame();
				try {
					
					Connection c = null;
					Statement start = null;
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					start = c.createStatement();
					String sql = "UPDATE take SET postGrade = 1 WHERE QUIZ_ID = '" + quizid + "';";
					//start = c.createStatement();
					//PreparedStatement start = c.prepareStatement("UPDATE quiz SET submission ='" + editdeadline.getText() + "' WHERE QUIZ_ID = '" + quizid + "';");
					start.execute(sql);
					JOptionPane.showMessageDialog(jk, "GRADES POSTED.");
					
					
				}
				
				catch (Exception ow) {
					ow.printStackTrace();
					JOptionPane.showMessageDialog(jk, "ERROR");
				}
			}
		});
		btnNewButton_5.setForeground(SystemColor.text);
		btnNewButton_5.setBackground(new Color(0, 0, 128));
		btnNewButton_5.setBounds(597, 19, 125, 23);
		contentPane.add(btnNewButton_5);
		
		
		
		
		
		
	}
}
