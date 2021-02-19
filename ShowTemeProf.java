package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerProfesor;
import Controller.ControllerTema;
import Domain.Tema;
import Repository.RepoProfesor;
import Repository.RepoTema;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class ShowTemeProf extends JFrame {

	RepoTema repo_tema = new RepoTema("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Teme.txt");
    private  ControllerTema ctrl_tema = new ControllerTema(repo_tema);
    
    RepoProfesor repo_prof = new RepoProfesor("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Profesori.txt");
    private  ControllerProfesor ctrl_prof = new ControllerProfesor(repo_prof);
    
	private JPanel contentPane;
	//private static String numeAutor = "Opre Ana";
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ShowTemeProf frame = new ShowTemeProf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ShowTemeProf() {
		initialize("");
	}

	/**
	 * Create the frame.
	 */
	public ShowTemeProf(String numeProf) {
		initialize(numeProf);
	}
	
	public void initialize(String numeProf) {
		setTitle("Temele unui profesor");
		ctrl_tema.readFromFile_Tema();
		ctrl_prof.readFromFile_Profesor();
		

		setBounds(100, 100, 500, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();

		String nume = numeProf;
        List<Tema> listTemeProf = new ArrayList<>();
        listTemeProf = afisTemeProf(ctrl_tema.getAll(),numeProf);
		
        String[] columnNames = 
			{"ID",
            "TITLU",
            "TIP",
            "NUME PROFESOR"};
		
        Object[][] data = new Object[listTemeProf.size()+1][4];
		
		data[0][0] = "ID";
		data[0][1] = "TITLU";
		data[0][2] = "TIP";
		data[0][3] = "NUME PROFESOR";
		
		for (int i = 1; i < listTemeProf.size()+1; i++) {
				data[i][0] = listTemeProf.get(i-1).getIDtema();
				data[i][1] = listTemeProf.get(i-1).getTitlu();
				data[i][2] = listTemeProf.get(i-1).getTip();
				data[i][3] = listTemeProf.get(i-1).getNumeProf();
		}
		
		table_1 = new JTable(data,columnNames);
		table_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table_1.setBackground(new Color(224, 255, 255));
		contentPane.add(table_1, BorderLayout.CENTER);
	}
	
	//temele unui anumit profesor
    public static List<Tema> afisTemeProf(List<Tema> temaList, String numeProf) {
    	List<Tema> listTeme = new ArrayList<>();
        for (int i = 0; i < temaList.size(); i++) {
        	if(numeProf.equals(temaList.get(i).getNumeProf())) {
                    listTeme.add(temaList.get(i));
                }
        }       
       return listTeme;   
    }    
}
