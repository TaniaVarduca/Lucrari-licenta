package Repository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Domain.Profesor;

import java.util.Scanner;

public class RepoProfesor {
    private List<Profesor> profesorList;
    private String fileName;

    public RepoProfesor(String fileName) {
        this.fileName = fileName;
        profesorList = new ArrayList<>();
    }

    public RepoProfesor(List<Profesor> profesorList, String fileName) { // constructor cu parameterii
        this.profesorList = profesorList;
        this.fileName = fileName;
    }

    public int getSize() { 			//lungime lista
        return profesorList.size();
    }

    public void readFromFile_Profesor() {		//citire din fisier
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            profesorList.clear();
            while ((line = br.readLine()) != null) {
                String components[] = line.split(",");
                String stringIDprofesor = components[0].trim();
                String nume = components[1].trim();
                int IDprofesor = Integer.parseInt(stringIDprofesor);
                Profesor profesor = new Profesor(IDprofesor, nume);
                profesorList.add(profesor);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Eroare in citirea din fisier!");
        }
    }

    public void writeToFile() throws IOException {		//scriere in fisier
        File fileOutput = new File(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutput);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        for (int i = 0; i < profesorList.size(); i++) {
            bw.write(profesorList.get(i).toString());
            bw.newLine();
        }
        bw.close();
    }

    public int searchByCodProfesor(int IDprofesor) {		//cautare prof dupa cod
        for (int i = 0; i < profesorList.size(); i++) {
            if (profesorList.get(i).getIDprofesor() == IDprofesor) {
                return i;
            }
        }
        return -1;
    }
    
    public void addProfesor(Profesor a) throws Exception {		//adauga profesor
        int position = searchByCodProfesor(a.getIDprofesor());
        if (position == -1) //if the object do not already exists in the list
        {
        	profesorList.add(a);
            writeToFile();
        } else
            throw new Exception("Profesorul exista deja !");
    }
   
    public void updateProfesor(Profesor a) throws Exception {		//update profesor
        int position = searchByCodProfesor(a.getIDprofesor());
        if (position == -1) {
            throw new Exception("Profesorul nu exista!");
        } else {
        	profesorList.set(position, a);
            writeToFile();
        }
    }

    public void deleteProfesor(Profesor a) throws Exception {		//stergere profesor
        int position = searchByCodProfesor(a.getIDprofesor());
        if (position == -1) {
            throw new Exception("Profesorul nu exista!");
        } else {
        	profesorList.remove(position);
            writeToFile();
        }
    }

    public List<Profesor> getAll() { 		//lista toti profesorii
        return profesorList;
    }

    public Profesor getProfesor(int position) {		//gasire profesor dupa pozitie
        return profesorList.get(position);
    }
}