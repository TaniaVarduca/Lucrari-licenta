package View;

import Domain.Student;
import Domain.Profesor;

import java.util.List;

public class CapTabel {
    
    public static void afisStudenti1() {
        System.out.println();
        System.out.println("=========================================================================");
        System.out.format("|%10s|%7s   |%8s  |%20s      |%9s |\n", "Cod student", "Nume", "Prenume", "Titlu lucrare", "Sustinut");

        System.out.println("=========================================================================");
    }

    public static void afisStudenti2() {
        System.out.println("=========================================================================");
        System.out.println();
    }
   
    public static void afisProfesori1() {
        System.out.println();
        System.out.println("==================================");
        System.out.format("|%10s|  %10s  |\n", "Cod profesor", "Nume si prenume");

        System.out.println("==================================");
    }

    public static void afisProfesori2() {
        System.out.println("==================================");
        System.out.println();
    }
    
    public static void afisTeme1() {
        System.out.println();
        System.out.println("=============================================================");
        System.out.format("|%8s|%14s        |%7s   |%15s  |\n", "Cod tema", "Titlu", "Tip", "Nume Profesor");

        System.out.println("=============================================================");
    }

    public static void afisTeme2() {
        System.out.println("=============================================================");
        System.out.println();
    }
}
