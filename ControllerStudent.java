package Controller;

import Domain.Student;
import Repository.RepoStudent;

import java.util.*;

public class ControllerStudent {
    private RepoStudent repo;

    
    public ControllerStudent(RepoStudent repo) {
        this.repo = repo;
    }

    public void readFromFile_Student() {		//citire din fisier
        repo.readFromFile_Student();
    }

    public void addStudent(int IDstudent, String nume, String prenume, String titluLucrare, int sustinut) {//adaugare student
    	Student student = new Student(IDstudent, nume, prenume, titluLucrare, sustinut);
        try {
            repo.addStudent(student);
            System.out.println("Studentul a fost adaugat!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean searchByCodStudent(int IDstudent) {
        if (repo.searchByCodStudent(IDstudent) != -1) {
            return true;
        }
        return false;
    }

    public Student searchByCodStudent_Obiect(int IDstudent) {	//cautare student dupa cod
        int position = repo.searchByCodStudent(IDstudent);
        if (repo.searchByCodStudent(IDstudent) != -1) {
            return repo.getStudent(position);
        }
        return repo.getStudent(-1);
    }

    public void updateStudent(int IDstudent, String nume, String prenume, String titluLucrare, int sustinut) {//update student
    	Student student = new Student(IDstudent, nume, prenume, titluLucrare, sustinut);
        try {
            repo.updateStudent(student);
            System.out.println("Studentul a fost actualizat!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent(int IDstudent) throws Exception {	//stergere student
        int position = repo.searchByCodStudent(IDstudent);
        if (position != -1) {
        	Student student = new Student(IDstudent, repo.getStudent(position).getNume(), repo.getStudent(position).getPrenume(), repo.getStudent(position).getTitluLucrare(), repo.getStudent(position).getSustinut());
            try {
                repo.deleteStudent(student);
                System.out.println("Studentul a fost sters!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new Exception("Studentul cu acest cod nu mai exista!");
        }
    }

    public List<Student> getAll() {		//lista toti studentii
        return repo.getAll();
    }
    
    public List<Student> getAllSustinut() {		//lista cu toti studentii care si-au sustinut lucrarea
    	List<Student> listStudentSustinut = new ArrayList<Student>();
    	for(int i=0;i<repo.getSize();i++) {
    		if(repo.getStudent(i).getSustinut()==1) {
    			listStudentSustinut.add(repo.getStudent(i));
    		}
    	}
        return listStudentSustinut;
    }
    
    public List<Student> getAllNuSustinut() {		//lista cu toti studentii care nu si-au sustinut lucrarea
    	List<Student> listStudentNuSustinut = new ArrayList<Student>();
    	for(int i=0;i<repo.getSize();i++) {
    		if(repo.getStudent(i).getSustinut()==0) {
    			listStudentNuSustinut.add(repo.getStudent(i));
    		}
    	}
        return listStudentNuSustinut;
    }
    
    public List<Student> getAllNeinscris(){  //lista cu toti studentii care nu s-au inscris pe liste
    	List<Student> listStudentNeinscris = new ArrayList<Student>();
    	for(int i=0;i<repo.getSize();i++) {
    		if(repo.getStudent(i).getTitluLucrare().equals("")) {
    			listStudentNeinscris.add(repo.getStudent(i));
    		}
    	}
        return listStudentNeinscris;
    }
    
    public List<Student> getAllCod(int IDstudent) {		
        return repo.getStudent_cod(IDstudent);
    }
}
