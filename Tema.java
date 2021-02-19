package Domain;

public class Tema {
	private int idTema = 0;
	private String titlu = null;
	private String tip = null;
	private String numeProf = null;
  
	public Tema(){	//constructor implicit
	}

	public Tema(int idTema, String titlu, String tip, String numeProf){ //constr. cu parametri
		this.idTema = idTema;
		this.titlu = titlu;
		this.tip = tip;
		this.numeProf = numeProf;
	}
 
	public int getIDtema() {		//get IDtema
		return idTema;
	}
	
	public void setIDtema(int idTema) {	//set IDtema
		this.idTema = idTema;
	}
	
	public String getTitlu() {	//get titlu
		return titlu;
	}
	
	public void setTitlu(String titlu) {	//set titlu
		this.titlu = titlu;
	}
	
	public String getNumeProf() {	//get nume prof.
		return numeProf;
	}
	
	public void setNumeProf(String numeProf) {	//set nume prof.
		this.numeProf = numeProf;
	}
	
	public String getTip() {	//get tip
		return tip;
	}
	
	public void setTip(String tip) {	//set tip
		this.tip = tip;
	}
	
	public String toString() {		//afisare string
		return idTema + "," + titlu + "," + tip + "," + numeProf;
	}
}
