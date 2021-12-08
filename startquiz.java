package quiz_system;

import java.awt.BorderLayout;  
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;    

public class startquiz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	String quizid;
	String userid;
	String username;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startquiz frame = new startquiz("","","");
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
		String quiz_id = "";
		String hostid = "";
		String title = "";
		String score = "";
		String created = "";
		String noques = "";
		String startsat = "";
		String endsat = "";
		
	public String quizinfo() {
		
		try {
			Connection c = null;
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
			//start = c.createStatement();
			PreparedStatement	start = c.prepareStatement("SELECT * FROM QUIZ where QUIZ_ID = '" + quizid + "';");

			ResultSet rs = start.executeQuery();
			
			while (rs.next()) {
			     quiz_id = rs.getString("QUIZ_ID");
			     hostid = rs.getString("HOST_ID");
			     title = rs.getString("TITLE");
			     score = rs.getString("SCORE");
			     created = rs.getString("CREATED");
			     noques = String.valueOf(rs.getInt("no_of_questions"));
			     startsat = rs.getString("startsat");
			     endsat = rs.getString("submission");
			    // create a single array of one row's worth of data
			    //String[] data = { quizid,hostid,title,score,created,noques,startsat,endsat } ;

			    	
			  
			}
			
			
		}
		
		catch (Exception a) {
			a.printStackTrace();
		}
		
		return "\n QUIZ ID: " + quiz_id + "\n\n TITLE: " + title + "\n\n MARKS: " + score + "\n\n NUMBER OF QUESTIONS: " + noques + "\n\n STARTS AT: " + startsat + "\n\n ENDS AT: " + endsat;
	}
		
	
	
	public startquiz(String quizid,String userid, String username) {
		this.quizid=quizid;
		this.userid=userid;
		this.username=username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea quizinfo = new JTextArea();
		quizinfo.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		quizinfo.setEditable(false);
		quizinfo.setBackground(SystemColor.text);
		quizinfo.setBounds(203, 55, 332, 323);
		contentPane.add(quizinfo);
		
		quizinfo.setText(quizinfo());
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentHome hh = new StudentHome(username,userid);
				hh.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BEGIN QUIZ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ji = new JFrame();
				Connection c = null;
				//c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
				
				//System.out.println(dtf.format(now));  
				try {
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz system db project", "root", "");
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
				}
				
				String date_time = startsat;
				String submission = endsat;
		        SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		        
		        		LocalDate date = LocalDate.parse(date_time, dtf);
		        		LocalDate date1 = LocalDate.parse(dtf.format(now), dtf);
		        		LocalDate end = LocalDate.parse(submission, dtf);
		        		
		        		LocalTime mytime = LocalTime.parse(dtf.format(now),dtf);
		        		LocalTime starttime = LocalTime.parse(date_time,dtf);
		        		LocalTime endtime = LocalTime.parse(submission,dtf);
		        		
		        		System.out.println(date1);
		        		
		        		//Date date = (Date) dateParser.parse(date_time); //startsat
		                //Date date1 = (Date) dateParser.parse(dtf.format(now)); //systemdate
		                ///ystem.out.println(date);
		                //date.compareTo(date1);

		               // SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy");
		                //System.out.println(dateFormatter.format(date));

		      /*  if (date1.compareTo(date) == 0 && date1.compareTo(end) == 0 ) {    
				theQuiz quiz = new theQuiz();
				quiz.setVisible(true);
				dispose();
		        }*/
		        
		        if(date1.compareTo(date) < 0 && mytime.compareTo(starttime) < 0) {
		        	JOptionPane.showMessageDialog(ji, "QUIZ HAS NOT STARTED YET");		       
		        		/*StudentHome sh = new StudentHome(username,userid);
		        		sh.setVisible(true);
		        		dispose();*/
		        	}
		        else if((date1.compareTo(end) > 0 && mytime.compareTo(endtime) > 0) || date1.compareTo(end) > 0 ) {
		        	JOptionPane.showMessageDialog(ji, "QUIZ HAS FINISHED");		       
		        		/*StudentHome sh = new StudentHome(username,userid);
		        		sh.setVisible(true);
		        		dispose(); */
		        	}
		        else {
					theQuiz quiz = new theQuiz(quizid,userid,username);
					quiz.setVisible(true);
					dispose();
				}

				}
				
								catch (Exception q) {
					q.printStackTrace();
				}
			
				
			}});
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBounds(203, 389, 332, 36);
		contentPane.add(btnNewButton_1);
		
	}

}
