package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerStudent;
import Repository.RepoStudent;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateStudent extends JFrame {
	
	RepoStudent repo_stud = new RepoStudent("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Studenti.txt");
    private  ControllerStudent ctrl_stud = new ControllerStudent(repo_stud);

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	Image image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
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
	public UpdateStudent() {
		ctrl_stud.readFromFile_Student();
		
		setTitle("Adaugare student");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 605);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIntroducetiDatelePentru = new JTextPane();
		txtpnIntroducetiDatelePentru.setBackground(new Color(224, 255, 255));
		txtpnIntroducetiDatelePentru.setFont(new Font("Sitka Small", Font.PLAIN, 19));
		txtpnIntroducetiDatelePentru.setBounds(41, 41, 377, 44);
		txtpnIntroducetiDatelePentru.setText("Introduceti datele pentru modificare:");
		txtpnIntroducetiDatelePentru.setEditable(false);
		contentPane.add(txtpnIntroducetiDatelePentru);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setFont(new Font("Sitka Small", Font.BOLD, 17));
		txtpnId.setText("ID:");
		txtpnId.setBounds(55, 134, 40, 28);
		contentPane.add(txtpnId);
		
		JTextPane txtpnNume = new JTextPane();
		txtpnNume.setFont(new Font("Sitka Text", Font.BOLD, 17));
		txtpnNume.setText("Nume:");
		txtpnNume.setBounds(55, 192, 61, 28);
		contentPane.add(txtpnNume);
		
		JTextPane txtpnPrenume = new JTextPane();
		txtpnPrenume.setFont(new Font("Sitka Text", Font.BOLD, 17));
		txtpnPrenume.setText("Prenume:");
		txtpnPrenume.setBounds(55, 247, 87, 28);
		contentPane.add(txtpnPrenume);
		
		JTextPane txtpnTitluLucrare = new JTextPane();
		txtpnTitluLucrare.setFont(new Font("Sitka Text", Font.BOLD, 17));
		txtpnTitluLucrare.setText("Titlu lucrare:");
		txtpnTitluLucrare.setBounds(55, 309, 124, 28);
		contentPane.add(txtpnTitluLucrare);
		
		JTextPane txtpnSustinut = new JTextPane();
		txtpnSustinut.setFont(new Font("Sitka Text", Font.BOLD, 17));
		txtpnSustinut.setText("   Sustinut \r\n(1=da/0=nu):");
		txtpnSustinut.setBounds(55, 366, 122, 54);
		contentPane.add(txtpnSustinut);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(243, 134, 108, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(243, 192, 108, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(243, 247, 108, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(243, 309, 108, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(243, 372, 108, 28);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Update student");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Studentul a fost updatat!");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(textField.getText());
		        String nume = textField_1.getText();
		        String prenume = textField_2.getText();
		        String titlu = textField_3.getText();
		        int sustinut = Integer.parseInt(textField_4.getText());
		        if (nume.equals("")) {
                	nume = ctrl_stud.searchByCodStudent_Obiect(id).getNume();
                }
		        if (prenume.equals("")) {
                	prenume = ctrl_stud.searchByCodStudent_Obiect(id).getPrenume();
                }
		        if (titlu.equals("")) {
		        	titlu = ctrl_stud.searchByCodStudent_Obiect(id).getTitluLucrare();
                }
                try {                	
                    ctrl_stud.updateStudent(id, nume, prenume, titlu, sustinut);
                } catch (Exception e) {
                	e.getMessage();
                }
                
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnNewButton.setBounds(142, 475, 152, 44);
		contentPane.add(btnNewButton);
		
		
	}
	
	/*
    Descriere: citeste un numar natural
    Input: String sir
    Output: int
     */



	public int ReadNaturalNumber(String sir) {
        System.out.println(sir);
        int n = -1;
        while (n < 0) {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader buff = new BufferedReader(reader);
            try {
                String text = buff.readLine();
                n = Integer.parseInt(text);
                if (n < 0)
                    System.out.println("Introduceti un numar mai mare ca 0!");
            } catch (IOException e) {

                System.out.println("Introduceti un numar pozitiv" + e.getMessage());
            } catch (NumberFormatException ex) {

                System.out.println("Introduceti un numar pozitiv" + ex.getMessage());
            }
        }
        return n;
    }

    /*
    Descriere: citeste un string
    Input: String sir
    Output: String
     */

    public String ReadString(String sir) {
        System.out.println(sir);
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(reader);
        String text = "";
        try {
            text = buff.readLine();
        } catch (IOException e) {

            System.out.println("Eroare la citire!" + e.getMessage());
        }
        return text;
    }
}
