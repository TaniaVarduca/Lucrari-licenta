package UI;

import Controller.*;
import Domain.Student;
import Domain.Profesor;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import View.*;

public class UI {
	
    private ControllerStudent ctrl_stud;
    private ControllerProfesor ctrl_prof;
    private ControllerTema ctrl_tema;

    public UI(ControllerStudent ctrl_stud, ControllerProfesor ctrl_prof, ControllerTema ctrl_tema) {
        this.ctrl_stud = ctrl_stud;
        this.ctrl_prof = ctrl_prof;
        this.ctrl_tema = ctrl_tema;
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

    public void MeniuPrincipal() {
        System.out.println("---------- MENIU PRINCIPAL ----------");
        System.out.println("            a. Studenti");
        System.out.println("            b. Profesori");
        System.out.println("            c. Teme");
        System.out.println("            x. Iesire");
        System.out.println("-------------------------------------");
    }

    public void MeniuStudent() {
        System.out.println("--------------- MENIU ----------------");
        System.out.println("            1. Adaugare Student");
        System.out.println("            2. Update Student");
        System.out.println("            3. Stergere Student");
        System.out.println("            4. Afisare lista Studenti");
        System.out.println("            5. Afisare lista Studenti care si-au sustinut lucrarea");
        System.out.println("            6. Afisare lista Studenti care nu si-au sustinut lucrarea");
        System.out.println("            7. Afisare lista Studenti care nu s-au inscris pe liste");
        System.out.println("            0. Inapoi");
        System.out.println("-------------------------------------");
    }

    public void MeniuProfesor() {
        System.out.println("--------------- MENIU ----------------");
        System.out.println("            1. Adaugare Profesor");
        System.out.println("            2. Afisare lista Profesori");
        System.out.println("            3. Afisare lista teme pentru un Profesor");
        System.out.println("            4. Afisare lista studenti asignati la un Profesor");
        System.out.println("            0. Inapoi");
        System.out.println("-------------------------------------");
    }
    
    public void MeniuTema() {
        System.out.println("--------------- MENIU ----------------");
        System.out.println("            1. Adaugare Tema");
        System.out.println("            2. Afisare lista Teme");
        System.out.println("            0. Inapoi");
        System.out.println("-------------------------------------");
    }
    
    public void runStudent() {
        MeniuStudent();
        int option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        ctrl_stud.readFromFile_Student();
        ctrl_prof.readFromFile_Profesor();
        ctrl_tema.readFromFile_Tema();
        while (option != 0) {
            switch (option) {
                case 1:
                	int IDstudent = ReadNaturalNumber("Introduceti codul studentului: ");
                    String nume = ReadString("Introduceti numele studentului: ");
                    String prenume = ReadString("Introduceti prenumele studentului: ");
                    String titluLucrare = ReadString("Introduceti titlul lucrarii: ");  
                    int sustinut = ReadNaturalNumber("Lucrare sustinuta=1/nesustinuta=0: ");
                    try {
                        ctrl_stud.addStudent(IDstudent, nume, prenume, titluLucrare, sustinut);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    int codStudent = ReadNaturalNumber("Introduceti codul studentului: ");
                    if (ctrl_stud.searchByCodStudent(codStudent)) {
                        String nume1 = ReadString("Introduceti numele studentului: ");
                        String prenume1 = ReadString("Introduceti prenumele studentului: ");
                        String titluLucrare1 = ReadString("Introduceti titlul lucrarii: ");
                        int sustinut1 = ReadNaturalNumber("Lucrare sustinuta=1/nesustinuta=0: ");
                        if (nume1.equals("")) {
                        	nume1 = ctrl_stud.searchByCodStudent_Obiect(codStudent).getNume();
                        }
                        if (prenume1.equals("")) {
                        	prenume1 = ctrl_stud.searchByCodStudent_Obiect(codStudent).getPrenume();
                        }
                        if (titluLucrare1.equals("")) {
                        	titluLucrare1 = ctrl_stud.searchByCodStudent_Obiect(codStudent).getTitluLucrare();
                        }
                        if (String.valueOf(sustinut1).equals("")) {
                        	sustinut1 = ctrl_stud.searchByCodStudent_Obiect(codStudent).getSustinut();
                        }
                        ctrl_stud.updateStudent(codStudent, nume1, prenume1, titluLucrare1, sustinut1);
                    } else {
                        System.out.println("Nu exista codul introdus! ");
                    }
                    break;
                case 3:
                    int codStudent1 = ReadNaturalNumber("Introduceti codul studentului: ");
                    try {

                        if (ctrl_stud.searchByCodStudent(codStudent1)) {
                            List<Student> lista_stud = ctrl_stud.getAllCod(codStudent1);
                            for (int i = 0; i < lista_stud.size(); i++) {
                                ctrl_stud.deleteStudent(codStudent1);
                            }
                            ctrl_stud.deleteStudent(codStudent1);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    CapTabel.afisStudenti1();
                    ContinutTabel.afisStudenti(ctrl_stud.getAll());
                    CapTabel.afisStudenti2();
                    break;
                case 5:
                    CapTabel.afisStudenti1();
                    ContinutTabel.afisStudenti(ctrl_stud.getAllSustinut());
                    CapTabel.afisStudenti2();
                    break;
                case 6:
                    CapTabel.afisStudenti1();
                    ContinutTabel.afisStudenti(ctrl_stud.getAllNuSustinut());
                    CapTabel.afisStudenti2();
                    break;
                case 7:
                    CapTabel.afisStudenti1();
                    ContinutTabel.afisStudenti(ctrl_stud.getAllNeinscris());
                    CapTabel.afisStudenti2();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            MeniuStudent();
            option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        }
    }

    public void runProfesor() {
        MeniuProfesor();
        int option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        ctrl_stud.readFromFile_Student();
        ctrl_prof.readFromFile_Profesor();
        ctrl_tema.readFromFile_Tema();
        while (option != 0) {
            switch (option) {
                case 1:
                	int IDprofesor = ReadNaturalNumber("Introduceti codul profesorului: ");
                    String nume = ReadString("Introduceti numele profesorului: ");
                    try {
                        ctrl_prof.addProfesor(IDprofesor, nume);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    CapTabel.afisProfesori1();
                    ContinutTabel.afisProfesori(ctrl_prof.getAll());
                    CapTabel.afisProfesori2();
                    break;
                case 3:
                	String nume1 = ReadString("Introduceti numele profesorului: ");
                    CapTabel.afisTeme1();
                    ContinutTabel.afisTemeProf(ctrl_tema.getAll(), nume1);
                    CapTabel.afisTeme2();
                    break;
                case 4:
                	String nume2 = ReadString("Introduceti numele profesorului: ");
                    CapTabel.afisStudenti1();
                    ContinutTabel.afisStudentiProf(ctrl_stud.getAll(), ctrl_tema.getAll(), nume2);
                    CapTabel.afisStudenti2();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            MeniuProfesor();
            option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        }
    }
     
    public void runTema() {
        MeniuTema();
        int option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        ctrl_stud.readFromFile_Student();
        ctrl_prof.readFromFile_Profesor();
        ctrl_tema.readFromFile_Tema();
        while (option != 0) {
            switch (option) {
                case 1:
                	int IDtema = ReadNaturalNumber("Introduceti codul temei: ");
                    String titlu = ReadString("Introduceti titlul temei: ");
                    String tip = ReadString("Introduceti tipul temei (licenta/dizertatie): ");
                    String numeProf = ReadString("Introduceti numele profesorului: ");
                    try {
                        ctrl_tema.addTema(IDtema, titlu, tip, numeProf);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    CapTabel.afisTeme1();
                    ContinutTabel.afisTeme(ctrl_tema.getAll());
                    CapTabel.afisTeme2();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            MeniuTema();
            option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        }
    }
    
    public void runApp() {
        MeniuPrincipal();
        String option_principal = ReadString("Introduceti optiunea dorita: ");
        String out_option = new String("x");
        while (!(option_principal.equals(out_option))) {
            switch (option_principal) {
                case "a":
                    runStudent();
                    break;
                case "b":
                	runProfesor();
                	break;
                case "c":
                	runTema();
                	break;
                case "x":
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            MeniuPrincipal();
            option_principal = ReadString("Introduceti optiunea dorita: ");
        }
        System.out.println("Program terminat!");
    }
}