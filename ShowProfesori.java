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

import Domain.Profesor;
import Controller.ControllerProfesor;
import Repository.RepoProfesor;
import javax.swing.UIManager;

public class ShowProfesori extends JFrame {

	RepoProfesor repo_prof = new RepoProfesor("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Profesori.txt");
    private  ControllerProfesor ctrl_prof = new ControllerProfesor(repo_prof);
    
    
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
	public ShowProfesori() {
		setTitle("Afisare Profesori");
		setBounds(100, 100, 820, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ctrl_prof.readFromFile_Profesor();
        List<Profesor> listProfesor = new ArrayList<>();
        listProfesor = ctrl_prof.getAll();
		
		String[] columnNames = 
				{"ID",
                "NUME SI PRENUME"};
		
		Object[][] data = new Object[listProfesor.size()+1][2];
		
		data[0][0] = "ID";
		data[0][1] = "NUME SI PRENUME";
		
		for (int i = 1; i < listProfesor.size()+1; i++) {
				data[i][0] = listProfesor.get(i-1).getIDprofesor();
				data[i][1] = listProfesor.get(i-1).getNume();
		}
		
		table = new JTable(data,columnNames);
		table.setFont(new Font("Arial",3, 15));
		table.setBackground(UIManager.getColor("info"));
		contentPane.add(table, BorderLayout.CENTER);
		}
}
