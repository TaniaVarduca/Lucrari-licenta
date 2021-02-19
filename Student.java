package Domain;

public class Student {
	private int IDstudent = 0;				//initializare cod student
	private String nume = null;				//initializare nume
	private String prenume = null;			//initializare prenume
	private String titluLucrare = null;		//initializare titluLucrare
	private int sustinut = 0;				//initializare sustinut
  
	public Student(){	//constructor implicit
	}

	public Student(int IDstudent, String nume, String prenume, String titluLucrare, int sustinut){ //constr. cu parametri
		this.IDstudent = IDstudent;
		this.nume = nume;
		this.prenume = prenume;
		this.titluLucrare = titluLucrare;
		this.sustinut = sustinut;
	}
 
	public int getIDstudent() {		//get IDstudent
		return IDstudent;
	}
	
	public void setIDstudent(int IDstudent) {	//set IDstudent
		this.IDstudent = IDstudent;
	}
	
	public String getNume() {	//get nume
		return nume;
	}
	
	public void setNume(String nume) {	//set nume
		this.nume = nume;
	}
	
	public String getPrenume() {	//get prenume
		return prenume;
	}
	
	public void setPrenume(String prenume) {	//set prenume
		this.prenume = prenume;
	}
	
	public String getTitluLucrare() {	//get titluLucrare
		return titluLucrare;
	}
	
	public void setTitluLucrare(String titluLucrare) {	//set titluLucrare
		this.titluLucrare = titluLucrare;
	}
	
	public int getSustinut() {		//get sustinut
		return sustinut;
	}
	
	public void setSustinut(int sustinut) {	//set IDstudent
		this.sustinut = sustinut;
	}
	
	public String toString() {		//afisare string
		return IDstudent + "," + nume + "," + prenume + "," + titluLucrare + ","+ sustinut;
	}
}
