package quiz_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ViewScores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	String name;
	String id;
	private JTextField scoreid;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewScores frame = new ViewScores("","");
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
	public ViewScores(String name, String id) {
		this.name=name;
		this.id=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SCORES");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBackground(SystemColor.text);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		lblNewLabel.setBounds(325, 11, 81, 27);
		contentPane.add(lblNewLabel);
		
		scoreid = new JTextField();
		scoreid.setHorizontalAlignment(SwingConstants.CENTER);
		scoreid.setBounds(254, 49, 218, 20);
		contentPane.add(scoreid);
		scoreid.setColumns(10);
		
		ButtonGroup bg = new ButtonGroup();
		
		
		
		
		JButton btnNewButton = new JButton("VIEW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c = null;
				try {
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
					//start = c.createStatement();
					PreparedStatement	start = c.prepareStatement("SELECT * FROM take where QUIZ_ID = '" + scoreid.getText() + "';");

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
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(254, 78, 218, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 712, 358);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ATTEMP ID", "STUDENT ID", "QUIZ ID", "SCORE", "SUBMITTED AT"
			}
		));
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.control);
	}
}
