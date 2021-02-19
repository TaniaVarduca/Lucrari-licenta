package Repository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Domain.Student;

import java.util.Scanner;

public class RepoStudent {
    private List<Student> studentList;
    private String fileName;

    
    public RepoStudent(String fileName) {		//constructor implicit
        this.fileName = fileName;
        studentList = new ArrayList<>();
    }

    public RepoStudent(List<Student> studentList, String fileName) { //constructor cu parameterii
        this.studentList = studentList;
        this.fileName = fileName;
    }

    public int getSize() {			//lingime lista studenti
        return studentList.size();
    }

    public void readFromFile_Student() { //citire din fisier
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            studentList.clear();
            while ((line = br.readLine()) != null) {
                String components[] = line.split(",");
                String stringIDstudent = components[0].trim();
                String nume = components[1].trim();
                String prenume = components[2].trim();
                String titluLucrare = components[3].trim();
                String stringSustinut = components[4].trim();
                int sustinut = Integer.parseInt(stringSustinut);
                int IDstudent = Integer.parseInt(stringIDstudent);
                Student student = new Student(IDstudent, nume, prenume, titluLucrare, sustinut);
                studentList.add(student);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fisier!");
        }
    }

    public void writeToFile() throws IOException { //scriere in fisier
        File fileOutput = new File(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutput);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        for (int i = 0; i < studentList.size(); i++) {
            bw.write(studentList.get(i).toString());
            bw.newLine();
        }
        bw.close();
    }

    public int searchByCodStudent(int IDstudent) {		//cautare student dupa cod
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getIDstudent() == IDstudent) {
                return i;
            }
        }
        return -1;
    }

    public void addStudent(Student a) throws Exception { 	//adaugare student
        int position = searchByCodStudent(a.getIDstudent());
        if (position == -1) 
        {
        	studentList.add(a);
            writeToFile();
        } else
            throw new Exception("Studentul exista deja !");
    }
 
    public void updateStudent(Student a) throws Exception {		//update student
        int position = searchByCodStudent(a.getIDstudent());
        if (position == -1) {
            throw new Exception("Studentul nu exista!");
        } else {
        	studentList.set(position, a);
            writeToFile();
        }
    }

    public void deleteStudent(Student a) throws Exception {		//stergere student
        int position = searchByCodStudent(a.getIDstudent());
        if (position == -1) {
            throw new Exception("Studentul nu exista!");
        } else {
        	studentList.remove(position);
            writeToFile();
        }
    }

    public List<Student> getAll() {			//lista toti studentii
        return studentList;
    }

    public Student getStudent(int position) {		//gasire student dupa pozitie
        return studentList.get(position);
    }
    
    public List<Student> getStudent_cod(int IDstudent) {	//gasire student dupa cod
        List<Student> listStudentCod = new ArrayList<Student>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getIDstudent() == IDstudent) {
            	listStudentCod.add(studentList.get(i));
            }
        }
        return listStudentCod;
    }
}
