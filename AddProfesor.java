package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerProfesor;
import Repository.RepoProfesor;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddProfesor extends JFrame {
	
	RepoProfesor repo_prof = new RepoProfesor("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Profesori.txt");
    private  ControllerProfesor ctrl_prof = new ControllerProfesor(repo_prof);

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Image image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProfesor frame = new AddProfesor();
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
	public AddProfesor() {
		ctrl_prof.readFromFile_Profesor();
		
		setTitle("Adaugare Profesor");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIntroducetiDatelePentru = new JTextPane();
		txtpnIntroducetiDatelePentru.setBackground(new Color(224, 255, 255));
		txtpnIntroducetiDatelePentru.setFont(new Font("Sitka Small", Font.PLAIN, 19));
		txtpnIntroducetiDatelePentru.setBounds(41, 41, 377, 44);
		txtpnIntroducetiDatelePentru.setText("Introduceti datele pentru adaugare:");
		txtpnIntroducetiDatelePentru.setEditable(false);
		contentPane.add(txtpnIntroducetiDatelePentru);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setFont(new Font("Sitka Small", Font.BOLD, 17));
		txtpnId.setText("ID:");
		txtpnId.setBounds(41, 155, 39, 28);
		contentPane.add(txtpnId);
		
		JTextPane txtpnTitlu = new JTextPane();
		txtpnTitlu.setFont(new Font("Sitka Text", Font.BOLD, 17));
		txtpnTitlu.setText("Nume si prenume:");
		txtpnTitlu.setBounds(41, 204, 168, 28);
		contentPane.add(txtpnTitlu);
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(250, 155, 116, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(250, 204, 116, 28);
		contentPane.add(textField_1);
		
		
		JButton btnNewButton = new JButton("Adauga profesor");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Profesorul a fost adaugat!");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(textField.getText());
		        String nume = textField_1.getText();
		        
                try {
                    ctrl_prof.addProfesor(id, nume);
                } catch (Exception e) {
                	e.getMessage();
                }               
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnNewButton.setBounds(139, 320, 160, 44);
		contentPane.add(btnNewButton);
			
	}
	
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