package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerTema;
import Repository.RepoTema;

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

public class AddTema extends JFrame {
	
	RepoTema repo_tema = new RepoTema("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Teme.txt");
    private  ControllerTema ctrl_tema = new ControllerTema(repo_tema);

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Image image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTema frame = new AddTema();
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
	public AddTema() {
		ctrl_tema.readFromFile_Tema();
		
		setTitle("Adaugare tema");
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
		txtpnId.setBounds(84, 147, 40, 28);
		contentPane.add(txtpnId);
		
		JTextPane txtpnTitlu = new JTextPane();
		txtpnTitlu.setFont(new Font("Sitka Text", Font.BOLD, 17));
		txtpnTitlu.setText("Titlu:");
		txtpnTitlu.setBounds(84, 204, 59, 28);
		contentPane.add(txtpnTitlu);
		
		JTextPane txtpnTip = new JTextPane();
		txtpnTip.setFont(new Font("Sitka Text", Font.BOLD, 17));
		txtpnTip.setText("Tip:");
		txtpnTip.setBounds(84, 258, 40, 28);
		contentPane.add(txtpnTip);
		
		JTextPane txtpnNumeProf = new JTextPane();
		txtpnNumeProf.setFont(new Font("Sitka Text", Font.BOLD, 17));
		txtpnNumeProf.setText("Profesor:");
		txtpnNumeProf.setBounds(84, 312, 89, 28);
		contentPane.add(txtpnNumeProf);
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(223, 147, 108, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(223, 204, 108, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(223, 258, 108, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(223, 312, 108, 28);
		contentPane.add(textField_3);
		
		
		JButton btnNewButton = new JButton("Adauga tema");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Tema a fost adaugata!");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(textField.getText());
		        String titlu = textField_1.getText();
		        String tip = textField_2.getText();
		        String prof = textField_3.getText();
		        
                try {
                    ctrl_tema.addTema(id, titlu, tip, prof);
                } catch (Exception e) {
                	e.getMessage();
                }
                
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnNewButton.setBounds(146, 389, 151, 44);
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