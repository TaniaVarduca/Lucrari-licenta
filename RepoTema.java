package Repository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Domain.Student;
import Domain.Tema;

import java.util.Scanner;

public class RepoTema {
    private List<Tema> temaList;
    private String fileName;

    public RepoTema(String fileName) {
        this.fileName = fileName;
        temaList = new ArrayList<>();
    }

    public RepoTema(List<Tema> profesorList, String fileName) {	//constructor cu parameterii
        this.temaList = profesorList;
        this.fileName = fileName;
    }

    public int getSize() {		//lungime lista teme
        return temaList.size();
    }

    public void readFromFile_Tema() {		//citire din fisier
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            temaList.clear();
            while ((line = br.readLine()) != null) {
                String components[] = line.split(",");
                String stringIDtema = components[0].trim();
                String titlu = components[1].trim();
                String tip = components[2].trim();
                String numeProf = components[3].trim();
                int IDtema = Integer.parseInt(stringIDtema);
                Tema tema = new Tema(IDtema, titlu, tip, numeProf);
                temaList.add(tema);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fisier!");
        }
    }

    public void writeToFile() throws IOException {		//scriere in fisier
        File fileOutput = new File(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutput);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        for (int i = 0; i < temaList.size(); i++) {
            bw.write(temaList.get(i).toString());
            bw.newLine();
        }
        bw.close();
    }

    public int searchByCodTema(int IDtema) {		//cautare tema dupa cod
        for (int i = 0; i < temaList.size(); i++) {
            if (temaList.get(i).getIDtema() == IDtema) {
                return i;
            }
        }
        return -1;
    }
  
    public void addTema(Tema a) throws Exception {		//adaugare tema
        int position = searchByCodTema(a.getIDtema());
        if (position == -1) 
        {
        	temaList.add(a);
            writeToFile();
        } else
            throw new Exception("Tema exista deja !");
    }
  
    public void updateTema(Tema a) throws Exception {		//update tema
        int position = searchByCodTema(a.getIDtema());
        if (position == -1) {
            throw new Exception("Tema nu exista!");
        } else {
        	temaList.set(position, a);
            writeToFile();
        }
    }

    public void deleteTema(Tema a) throws Exception {		//stergere tema
        int position = searchByCodTema(a.getIDtema());
        if (position == -1) {
            throw new Exception("Tema nu exista!");
        } else {
        	temaList.remove(position);
            writeToFile();
        }
    }

    public List<Tema> getAll() {		//lista toate temele
        return temaList;
    }

    public Tema getTema(int position) {		//gasire tema dupa poztie
        return temaList.get(position);
    }
    
    public List<Tema> getTema_cod(int IDtema) {		//gasire tema dupa cod
        List<Tema> listTemaCod = new ArrayList<Tema>();
        for (int i = 0; i < temaList.size(); i++) {
            if (temaList.get(i).getIDtema() == IDtema) {
            	listTemaCod.add(temaList.get(i));
            }
        }
        return listTemaCod;
    }
}
