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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;

public class ViewQuiz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	String name;
	String id;
	private JTable quiztable;
	private JTextField searchquiz;
	private JTextField delquiz;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewQuiz frame = new ViewQuiz("","");
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
	public ViewQuiz(String name, String id) {
		this.name=name;
		this.id=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW QUIZZES");
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(279, 11, 174, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("GO BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherHome tm = new TeacherHome(name,id);
				tm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JRadioButton idsearch = new JRadioButton("SEARCH BY ID");
		idsearch.setBackground(SystemColor.text);
		idsearch.setBounds(10, 64, 109, 23);
		contentPane.add(idsearch);
		
		JRadioButton showall = new JRadioButton("SHOW ALL ");
		showall.setBackground(SystemColor.text);
		showall.setBounds(10, 84, 95, 23);
		contentPane.add(showall);
		
		searchquiz = new JTextField();
		searchquiz.setBounds(125, 66, 86, 20);
		contentPane.add(searchquiz);
		searchquiz.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) quiztable.getModel();
				model.setRowCount(0);
				
				Connection c = null;
				//Statement start = null;
				
				
					
				if (idsearch.isSelected()) {
					
					try {
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						//start = c.createStatement();
						PreparedStatement	start = c.prepareStatement("SELECT * FROM QUIZ where QUIZ_ID = '" + searchquiz.getText() + "';");

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
						  
						 DefaultTableModel tblModel = (DefaultTableModel)quiztable.getModel();
						 //tblModel.setColumnIdentifiers(columnName);
						  tblModel.addRow(data);
						}
					}
					
					catch (Exception a) {
						a.printStackTrace();
					}
					
				}
				
				if (showall.isSelected()) {
					
					try {
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						//start = c.createStatement();
						PreparedStatement	start = c.prepareStatement("SELECT * FROM QUIZ where HOST_ID = '" + id + "';");

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
						  
						 DefaultTableModel tblModel = (DefaultTableModel)quiztable.getModel();
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
		btnNewButton_1.setBounds(221, 68, 215, 39);
		contentPane.add(btnNewButton_1);
		
		ButtonGroup ba = new ButtonGroup();
		ba.add(idsearch);
		ba.add(showall);
		
		JButton btnNewButton_2 = new JButton("DELETE QUIZ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jj = new JFrame();
				try {
					Connection c = null;
					Statement start = null;
					
					 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
						start = c.createStatement();
						 
						String sql = "DELETE FROM quiz WHERE QUIZ_ID= '" + delquiz.getText() + "'AND HOST_ID = '" + id + "';";
									
						 start.executeUpdate(sql);
						 JOptionPane.showMessageDialog(jj,"QUIZ DELETED");
				}
				
				catch (Exception oo) {
					oo.printStackTrace();
					 JOptionPane.showMessageDialog(jj,"ERROR");
				}
				
			}
		});
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setBounds(599, 64, 123, 20);
		contentPane.add(btnNewButton_2);
		
		delquiz = new JTextField();
		delquiz.setBounds(446, 85, 143, 20);
		contentPane.add(delquiz);
		delquiz.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("QUIZ ID");
		lblNewLabel_1.setBounds(446, 68, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("EDIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editquiz ed = new editquiz(name,id,delquiz.getText());
				ed.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(599, 87, 123, 20);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 712, 356);
		contentPane.add(scrollPane);
		
		quiztable = new JTable();
		scrollPane.setViewportView(quiztable);
		quiztable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"QUIZ ID", "HOST ID", "TITLE", "TOTAL SCORE", "CREATED", "NO OF QUESTIONS", "STARTS AT", "ENDS AT"
			}
		));
		
		
		
		
		quiztable.setBackground(SystemColor.menu);
		
	}
}
