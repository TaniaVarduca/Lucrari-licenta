package View;

import Controller.*;
import Domain.*;
import Repository.*;

import java.text.DecimalFormat;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContinutTabel {
    
    public static void afisStudenti(List<Student> studentList){
        for (int i = 0; i < studentList.size(); i++)
            System.out.format("|%11d|%-10s|%-10s|%-26s|%10d|\n",studentList.get(i).getIDstudent(), studentList.get(i).getNume(), studentList.get(i).getPrenume(), studentList.get(i).getTitluLucrare(), studentList.get(i).getSustinut());

    }

    public static void afisProfesori(List<Profesor> profList){
        for (int i = 0; i < profList.size(); i++)
            System.out.format("|%12d|%10s \n",profList.get(i).getIDprofesor(), profList.get(i).getNume());
    }
    
    public static void afisTeme(List<Tema> temaList){
        for (int i = 0; i < temaList.size(); i++)
            System.out.format("|%8s|%-22s|%-10s|%-15s\n",temaList.get(i).getIDtema(), temaList.get(i).getTitlu(), temaList.get(i).getTip(), temaList.get(i).getNumeProf());
    }
    
    public static void afisTemeProf(List<Tema> temaList, String numeProf){
        for (int i = 0; i < temaList.size(); i++)
        	if(numeProf.equals(temaList.get(i).getNumeProf()))
        		System.out.format("|%8s|%-22s|%-10s|%-15s\n",temaList.get(i).getIDtema(), temaList.get(i).getTitlu(), temaList.get(i).getTip(), temaList.get(i).getNumeProf());
    }
    
    public static void afisStudentiProf(List<Student> studentList, List<Tema> temaList, String numeProf){
    	for (int i = 0; i < temaList.size(); i++)
        	if(numeProf.equals(temaList.get(i).getNumeProf()))
        		for(int j = 0;j < studentList.size(); j++)
        			if(studentList.get(j).getTitluLucrare().equals(temaList.get(i).getTitlu()))
        				System.out.format("|%11d|%-10s|%-10s|%-26s|%10d|\n",studentList.get(j).getIDstudent(), studentList.get(j).getNume(), studentList.get(j).getPrenume(), studentList.get(j).getTitluLucrare(), studentList.get(j).getSustinut());
    }
}