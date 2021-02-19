package Controller;

import Domain.Profesor;
import Repository.RepoProfesor;

import java.util.*;

public class ControllerProfesor {
    private RepoProfesor repo;

    public ControllerProfesor(RepoProfesor repo) {
        this.repo = repo;
    }

    public void readFromFile_Profesor() {		//citire din fisier
        repo.readFromFile_Profesor();
    }

    public void addProfesor(int IDprofesor, String nume) {		//adaugare profesor
    	Profesor profesor = new Profesor(IDprofesor, nume);
        try {
            repo.addProfesor(profesor);
            System.out.println("Profesorul a fost adaugat!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean searchByCodProfesor(int IDprofesor) {		
        if (repo.searchByCodProfesor(IDprofesor) != -1) {
            return true;
        }
        return false;
    }

    public Profesor searchByCodProfesor_Obiect(int IDprofesor) {		//cautare profesor dupa cod
        int position = repo.searchByCodProfesor(IDprofesor);
        if (repo.searchByCodProfesor(IDprofesor) != -1) {
            return repo.getProfesor(position);
        }
        return repo.getProfesor(-1);
    }

    public void updateProfesor(int IDprofesor, String nume) {		//update profesor
    	Profesor profesor = new Profesor(IDprofesor, nume);
        try {
            repo.updateProfesor(profesor);
            System.out.println("Profesorul a fost actualizat!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteProfesor(int IDprofesor) throws Exception {		//stergere profesor
        int position = repo.searchByCodProfesor(IDprofesor);
        if (position != -1) {
        	Profesor profesor = new Profesor(IDprofesor, repo.getProfesor(position).getNume());
            try {
                repo.deleteProfesor(profesor);
                System.out.println("Profesorul a fost sters!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new Exception("Profesorul cu acest cod nu exista!");
        }
    }

    public List<Profesor> getAll() {		//lista toti profesorii
        return repo.getAll();
    }
}
