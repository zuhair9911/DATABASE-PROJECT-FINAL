package quiz_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentScore extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	String userid;
	String username;
	private JButton btnNewButton;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentScore frame = new StudentScore("","");
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
	public StudentScore(String username,String userid) {
		
		this.username=username;
		this.userid = userid;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 540);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 692, 447);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ATTEMPT ID", "USER ID", "QUIZ ID", "SCORE", "SUBMITTED AT"
			}
		));
		table.setBackground(SystemColor.inactiveCaptionBorder);
		
		btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentHome ss = new StudentHome(username,userid);
				ss.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
			//start = c.createStatement();
			PreparedStatement	start = c.prepareStatement("SELECT * FROM take where USER_ID = '" + userid + "' AND postGrade = " + 1);

			ResultSet rs = start.executeQuery();
			
			while (rs.next()) {
			    String quizid = rs.getString("TAKE_ID");
			    String hostid = rs.getString("USER_ID");
			    String title = rs.getString("QUIZ_ID");
			    String score = rs.getString("SCORE");
			    String created = rs.getString("FINISHED");
			    
			    // create a single array of one row's worth of data
			    String[] data = { quizid,hostid,title,score,created } ;

			    // and add this row of data into the table model
			  
			 DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			 //tblModel.setColumnIdentifiers(columnName);
			  tblModel.addRow(data);
			}
		}
		
		catch (Exception a) {
			a.printStackTrace();
		}
	}
}
