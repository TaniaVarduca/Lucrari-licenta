package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerStudent;
import Repository.RepoStudent;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.TextField;

public class DeleteStudent extends JFrame {
	
	RepoStudent repo_stud = new RepoStudent("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Studenti.txt");
    private  ControllerStudent ctrl_stud = new ControllerStudent(repo_stud);

	private JPanel contentPane;
	Image image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudent frame = new DeleteStudent();
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
	public DeleteStudent() {
		
		
		ctrl_stud.readFromFile_Student();
		
		setTitle("Stergere student");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIntroducetiDatelePentru = new JTextPane();
		txtpnIntroducetiDatelePentru.setBackground(new Color(224, 255, 255));
		txtpnIntroducetiDatelePentru.setFont(new Font("Sitka Small", Font.PLAIN, 19));
		txtpnIntroducetiDatelePentru.setBounds(29, 55, 360, 51);
		txtpnIntroducetiDatelePentru.setText("Alegeti id-ul studentului pentru stergere:");
		txtpnIntroducetiDatelePentru.setEditable(false);
		contentPane.add(txtpnIntroducetiDatelePentru);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtpnId.setText("ID:");
		txtpnId.setBounds(103, 168, 51, 28);
		contentPane.add(txtpnId);
		
		TextField textField = new TextField();
		textField.setBounds(232, 168, 51, 28);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Sterge student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int id = Integer.parseInt(textField.getText());				
                try {
                    ctrl_stud.deleteStudent(id);
                } catch (Exception e) {
                	e.getMessage();
                }                
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 19));
		btnNewButton.setBounds(140, 283, 122, 44);
		contentPane.add(btnNewButton);
	}
}