import Repository.*;
import Controller.*;
import UI.*;


public class StartApp {

    public static void main(String[] args) {
        RepoStudent repo_stud = new RepoStudent("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Studenti.txt");
        RepoProfesor repo_prof = new RepoProfesor("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Profesori.txt");
        RepoTema repo_tema = new RepoTema("C:\\Users\\TANIA\\eclipse-workspace\\lab5\\src\\Teme.txt");
        ControllerStudent ctrl_stud = new ControllerStudent(repo_stud);
        ControllerProfesor ctrl_prof = new ControllerProfesor(repo_prof);
        ControllerTema ctrl_tema = new ControllerTema(repo_tema);
        UI ui = new UI(ctrl_stud, ctrl_prof, ctrl_tema);
        ui.runApp();
    }
}