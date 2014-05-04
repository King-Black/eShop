package Valueobjects;

public class Mitarbeiter extends User {
	
	private int mitarbeiterId;
	private boolean verfuegbar;
	
	
	public Mitarbeiter(int mitarbeitderId, String vorName, String nachName, String passwort, boolean verfuegbar){
		super(vorName, nachName, passwort);
		this.mitarbeiterId = mitarbeiterId;
		this.verfuegbar = verfuegbar;
	}
	
	public int getMitarbeiterId(){
		return this.mitarbeiterId;
	}
	
	public void setMitarbeiterId(int mitarbeiterId){
		this.mitarbeiterId = mitarbeiterId;
	}

}
