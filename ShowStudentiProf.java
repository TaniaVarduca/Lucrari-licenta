package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.*;
import Domain.*;
import Repository.*;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class ShowStudentiProf extends JFrame {

	RepoTema repo_tema = new RepoTema("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Teme.txt");
    private  ControllerTema ctrl_tema = new ControllerTema(repo_tema);
    
    RepoProfesor repo_prof = new RepoProfesor("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Profesori.txt");
    private  ControllerProfesor ctrl_prof = new ControllerProfesor(repo_prof);
    
    RepoStudent repo_stud = new RepoStudent("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Studenti.txt");
    private  ControllerStudent ctrl_stud = new ControllerStudent(repo_stud);
    
	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ShowStudentiProf frame = new ShowStudentiProf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ShowStudentiProf() {
		initialize("");
	}

	/**
	 * Create the frame.
	 */
	public ShowStudentiProf(String numeProf) {
		initialize(numeProf);
	}
	
	public void initialize(String numeProf) {
		setTitle("Studentii asignati la un profesor");
		ctrl_tema.readFromFile_Tema();
		ctrl_prof.readFromFile_Profesor();
		ctrl_stud.readFromFile_Student();
		

		setBounds(100, 100, 500, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//table = new JTable();

		String nume = numeProf;
        List<Student> listStudProf = new ArrayList<>();
        listStudProf = afisStudProf(ctrl_stud.getAll(), ctrl_tema.getAll(), numeProf);
		
        String[] columnNames = 
			{"ID",
            "NUME",
            "PRENUME",
            "TITLU LUCRARE",
            "SUSTINUT"};
	
        Object[][] data = new Object[listStudProf.size()+1][5];
	
        data[0][0] = "ID";
        data[0][1] = "NUME";
        data[0][2] = "PRENUME";
        data[0][3] = "TITLU LUCRARE";
        data[0][4] = "SUSTINUT";
		
		for (int i = 1; i < listStudProf.size()+1; i++) {
			data[i][0] = listStudProf.get(i-1).getIDstudent();
			data[i][1] = listStudProf.get(i-1).getNume();
			data[i][2] = listStudProf.get(i-1).getPrenume();
			data[i][3] = listStudProf.get(i-1).getTitluLucrare();
			data[i][4] = listStudProf.get(i-1).getSustinut();
		}
		
		table_1 = new JTable(data,columnNames);
		table_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table_1.setBackground(new Color(224, 255, 255));
		contentPane.add(table_1, BorderLayout.CENTER);
	}
	
	//studentii unui anumit profesor
    public static List<Student> afisStudProf(List<Student> studentList, List<Tema> temaList, String numeProf) {
    	List<Student> listStud = new ArrayList<>();
    	for (int i = 0; i < temaList.size(); i++)
        	if(numeProf.equals(temaList.get(i).getNumeProf()))
        		for(int j = 0;j < studentList.size(); j++)
        			if(studentList.get(j).getTitluLucrare().equals(temaList.get(i).getTitlu())) {
        				listStud.add(studentList.get(j));
                }       
       return listStud;   
    }    
}
