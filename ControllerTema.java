package Controller;

import Domain.Tema;
import Repository.RepoTema;

import java.util.*;

public class ControllerTema {
    private RepoTema repo;

    
    public ControllerTema(RepoTema repo) {
        this.repo = repo;
    }

    public void readFromFile_Tema() {	//citire din fiser
        repo.readFromFile_Tema();
    }

    public void addTema(int IDtema, String titlu, String tip, String numeProf) {		//adaugare tema
    	Tema tema = new Tema(IDtema, titlu, tip, numeProf);
        try {
            repo.addTema(tema);
            System.out.println("Tema a fost adaugata!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean searchByCodTema(int IDtema) {		
        if (repo.searchByCodTema(IDtema) != -1) {
            return true;
        }
        return false;
    }

    public Tema searchByCodTema_Obiect(int IDtema) {		//cautare tema dupa cod
        int position = repo.searchByCodTema(IDtema);
        if (repo.searchByCodTema(IDtema) != -1) {
            return repo.getTema(position);
        }
        return repo.getTema(-1);
    }

    public void updateTema(int IDtema, String titlu, String tip, String numeProf) {		//update tema
    	Tema tema = new Tema(IDtema, titlu, tip, numeProf);
        try {
            repo.updateTema(tema);
            System.out.println("Studentul a fost actualizat!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTema(int IDtema) throws Exception {		//stergere tema
        int position = repo.searchByCodTema(IDtema);
        if (position != -1) {
        	Tema tema = new Tema(IDtema, repo.getTema(position).getTitlu(), repo.getTema(position).getTip(), repo.getTema(position).getNumeProf());
            try {
                repo.deleteTema(tema);
                System.out.println("Tema a fost stearsa!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new Exception("Tema cu acest cod nu mai exista!");
        }
    }

    public List<Tema> getAll() {		//lista toate temele
        return repo.getAll();
    }
      
    public List<Tema> getAllCod(int IDtema) {
        return repo.getTema_cod(IDtema);
    }
}

