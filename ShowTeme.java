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

import Domain.Tema;
import Controller.ControllerTema;
import Repository.RepoTema;
import javax.swing.UIManager;

public class ShowTeme extends JFrame {

	RepoTema repo_tema = new RepoTema("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Teme.txt");
    private  ControllerTema ctrl_tema = new ControllerTema(repo_tema);
    
    
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
	public ShowTeme() {
		setTitle("Afisare Teme");
		setBounds(100, 100, 820, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ctrl_tema.readFromFile_Tema();
        List<Tema> listTema = new ArrayList<>();
        listTema = ctrl_tema.getAll();
		
		String[] columnNames = 
				{"ID",
                "TITLU",
                "TIP",
                "NUME PROFESOR"};
		
		Object[][] data = new Object[listTema.size()+1][4];
		
		data[0][0] = "ID";
		data[0][1] = "TITLU";
		data[0][2] = "TIP";
		data[0][3] = "NUME PROFESOR";
		
		for (int i = 1; i < listTema.size()+1; i++) {
				data[i][0] = listTema.get(i-1).getIDtema();
				data[i][1] = listTema.get(i-1).getTitlu();
				data[i][2] = listTema.get(i-1).getTip();
				data[i][3] = listTema.get(i-1).getNumeProf();
		}
		
		table = new JTable(data,columnNames);
		table.setFont(new Font("Arial",3, 15));
		table.setBackground(UIManager.getColor("info"));
		contentPane.add(table, BorderLayout.CENTER);
		}
}
