package UI;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import Repository.*;
import View.CapTabel;
import View.ContinutTabel;
import Controller.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	//RepoStudent repo_stud = new RepoStudent("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Studenti.txt");
   // RepoProfesor repo_prof = new RepoProfesor("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Profesori.txt");
    //RepoTema repo_tema = new RepoTema("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Teme.txt");
    //private ControllerStudent ctrl_stud;
    //private ControllerProfesor ctrl_prof;
    //private ControllerTema ctrl_tema;
    
    private ShowStudenti showStudenti = new ShowStudenti();
    private ShowProfesori showProfesori = new ShowProfesori();
    private ShowTeme showTeme = new ShowTeme();
    private ShowStudentiSustinut showStudentiSustinut = new ShowStudentiSustinut();
    private ShowStudentiNuSustinut showStudentiNuSustinut = new ShowStudentiNuSustinut();
    private ShowStudentiNeinscrisi showStudentiNeinscrisi = new ShowStudentiNeinscrisi();
    
    private AddStudent addStudent = new AddStudent();
    private AddProfesor addProfesor = new AddProfesor();
    private AddTema addTema = new AddTema();
    
    private DeleteStudent delStudent = new DeleteStudent();
    private UpdateStudent updateStudent = new UpdateStudent();
    
    private ChooseProf1 chooseProf1 = new ChooseProf1();
    private ChooseProf2 chooseProf2 = new ChooseProf2();
    
	private JFrame frame;
	Image image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(222, 184, 135));
	
		frame.setBounds(100, 100, 821, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Gestionare lucrari licenta si dizertatie");
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setFont(new Font("Broadway", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Studenti");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 19));
		
		JLabel lblNewLabel_2 = new JLabel("Profesori");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 19));
		
		JLabel lblNewLabel_3 = new JLabel("Teme");
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 19));
		
		JButton btnNewButton = new JButton("Afisare studenti");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showStudenti.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(245, 222, 179));
		
		JButton btnNewButton_1 = new JButton("Adaugare student");
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addStudent.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Stergere student");
		btnNewButton_2.setBackground(new Color(245, 222, 179));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delStudent.setVisible(true);
				showStudenti.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Update student");
		btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateStudent.setVisible(true);
				showStudenti.setVisible(true);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Lista studentilor care au sustinut lucrarea");
		btnNewButton_4.setBackground(new Color(245, 222, 179));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showStudentiSustinut.setVisible(true);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Lista studentilor care nu au sustinut lucrarea");
		btnNewButton_5.setBackground(SystemColor.info);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showStudentiNuSustinut.setVisible(true);
			}
		});
		
		JButton btnNewButton_6 = new JButton("Lista studentilor care nu sunt inscrisi pe liste");
		btnNewButton_6.setBackground(new Color(245, 222, 179));
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showStudentiNeinscrisi.setVisible(true);
			}
		});
		
		JButton btnNewButton_7 = new JButton("Afisare profesori");
		btnNewButton_7.setBackground(SystemColor.info);
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showProfesori.setVisible(true);
			}
		});
		
		JButton btnNewButton_8 = new JButton("Adaugare profesor");
		btnNewButton_8.setBackground(new Color(245, 222, 179));
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addProfesor.setVisible(true);
			}
		});
		
		JButton btnNewButton_9 = new JButton("Lista temelor unui profesor");
		btnNewButton_9.setBackground(SystemColor.info);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showProfesori.setVisible(true);
				chooseProf1.setVisible(true);
			}
		});
		
		JButton btnNewButton_10 = new JButton("Lista studentilor asignati la un profesor");
		btnNewButton_10.setBackground(new Color(245, 222, 179));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showProfesori.setVisible(true);
				chooseProf2.setVisible(true);
			}
		});
		
		JButton btnNewButton_11 = new JButton("Afisare teme");
		btnNewButton_11.setBackground(new Color(245, 222, 179));
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showTeme.setVisible(true);
			}
		});
		
		JButton btnNewButton_12 = new JButton("Adaugare tema");
		btnNewButton_12.setBackground(SystemColor.info);
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addTema.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton)
										.addComponent(btnNewButton_1)
										.addComponent(btnNewButton_2)
										.addComponent(btnNewButton_3))
									.addGap(145)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_10)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnNewButton_7)
												.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnNewButton_8))
											.addGap(150)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_3)
												.addComponent(btnNewButton_12)
												.addComponent(btnNewButton_11)))
										.addComponent(btnNewButton_9)))
								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton_6)
									.addComponent(btnNewButton_5))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_11)
						.addComponent(btnNewButton_7))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_12)
						.addComponent(btnNewButton_8))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_9))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_10))
					.addGap(26)
					.addComponent(btnNewButton_4)
					.addGap(29)
					.addComponent(btnNewButton_5)
					.addGap(28)
					.addComponent(btnNewButton_6)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
