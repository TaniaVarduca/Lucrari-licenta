package Domain;

public class Profesor {
	private int IDprofesor = 0;
	private String nume = null;	
  
	public Profesor(){	//constructor implicit
	}

	public Profesor(int IDprofesor, String nume){ //constr. cu parametri
		this.IDprofesor = IDprofesor;
		this.nume = nume;
	}
 
	public int getIDprofesor() {	//get IDprofesor
		return IDprofesor;
	}
	
	public void setIDprofesor(int IDprofesor) {	//set IDprofesor
		this.IDprofesor = IDprofesor;
	}
	
	public String getNume() {	//get nume
		return nume;
	}
	
	public void setNume(String nume) {	//set nume
		this.nume = nume;
	}
	
	
	public String toString() {		//afisare string
		return IDprofesor + "," + nume;
	}
}
