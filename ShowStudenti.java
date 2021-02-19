package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Domain.Student;
import Controller.ControllerStudent;
import Repository.RepoStudent;
import javax.swing.UIManager;

public class ShowStudenti extends JFrame {

	RepoStudent repo_stud = new RepoStudent("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Studenti.txt");
    private  ControllerStudent ctrl_stud = new ControllerStudent(repo_stud);
    
    
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowStudenti frame = new ShowStudenti();
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
	public ShowStudenti() {
		setTitle("Afisare Studenti");
		setBounds(100, 100, 820, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ctrl_stud.readFromFile_Student();
        List<Student> listStudent = new ArrayList<>();
        listStudent = ctrl_stud.getAll();
		
		String[] columnNames = 
				{"ID",
                "NUME",
                "PRENUME",
                "TITLU LUCRARE",
                "SUSTINUT"};
		
		Object[][] data = new Object[listStudent.size()+1][5];
		
		data[0][0] = "ID";
		data[0][1] = "NUME";
		data[0][2] = "PRENUME";
		data[0][3] = "TITLU LUCRARE";
		data[0][4] = "SUSTINUT";
		
		for (int i = 1; i < listStudent.size()+1; i++) {
				data[i][0] = listStudent.get(i-1).getIDstudent();
				data[i][1] = listStudent.get(i-1).getNume();
				data[i][2] = listStudent.get(i-1).getPrenume();
				data[i][3] = listStudent.get(i-1).getTitluLucrare();
				data[i][4] = listStudent.get(i-1).getSustinut();
		}
		
		table = new JTable(data,columnNames);
		table.setFont(new Font("Arial",3, 15));
		table.setBackground(UIManager.getColor("info"));
		contentPane.add(table, BorderLayout.CENTER);
		}
}