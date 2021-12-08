package quiz_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class StudentHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	String name;
	String id;
	private JTextField txtHb;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome frame = new StudentHome("","");
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
	public StudentHome(String name,String id) {
		this.name=name;
		this.id=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hh = new Home();
				hh.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(633, 0, 99, 58);
		contentPane.add(btnNewButton);
		
		JTextArea stu_wel = new JTextArea();
		stu_wel.setText(" Welcome <dynamic>\n ID: <dynamic>");
		stu_wel.setForeground(SystemColor.text);
		stu_wel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		stu_wel.setEditable(false);
		stu_wel.setBackground(new Color(0, 0, 128));
		stu_wel.setBounds(0, 0, 535, 58);
		contentPane.add(stu_wel);
		
		stu_wel.setText(" Welcome " + name + "\n" + " ID: " + id);
		
		txtHb = new JTextField();
		txtHb.setToolTipText("");
		txtHb.setForeground(SystemColor.controlText);
		txtHb.setHorizontalAlignment(SwingConstants.CENTER);
		txtHb.setBackground(SystemColor.text);
		txtHb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHb.setBounds(233, 164, 265, 44);
		contentPane.add(txtHb);
		txtHb.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("QUIZ ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(335, 139, 61, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("ATTEMPT QUIZ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startquiz sq = new startquiz(txtHb.getText(),id,name);
				sq.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBounds(304, 219, 123, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VIEW SCORES");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentScore vs = new StudentScore(name,id);
				vs.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(304, 265, 123, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PROFILE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				studentprofile tp = new studentprofile(name,id);
				tp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3.setBounds(534, 0, 99, 58);
		contentPane.add(btnNewButton_3);
	}
}
