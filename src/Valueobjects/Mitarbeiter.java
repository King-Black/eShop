package Valueobjects;

public class Mitarbeiter extends User {
	
	private int mitarbeiterId;
	
	public Mitarbeiter(int mitarbeitderId, String vorName, String nachName, String passwort){
		super(vorName, nachName, passwort);
		this.mitarbeiterId = mitarbeiterId;
		
	}

}
