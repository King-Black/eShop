package Valueobjects;

public class Artikel {
	
	private static final String ArtikelBeschreibung = null;
	private int ArtikelNummer;
	private String ArtikelName;
	private int ArtikelBestand;
	private String Beschreibung;
	private float Preis;
	
	public Artikel(int ArtikelNummer, String ArtikelName, int ArtikelBestand, string Beschreibung, float Preis){
		this.ArtikelNummer = ArtikelNummer;
		this.ArtikelName = ArtikelName;
		this.ArtikelBestand = ArtikelBestand;
		this.Beschreibung = Beschreibung;
		this.Preis = Preis;
		
	}
	
	public int getArtikelNummer(){
		return this.ArtikelNummer;
	}
	
	public void setArtikelNummer(int ArtikelNummer){
		this.ArtikelNummer = ArtikelNummer;
	}
	
	public String getArtikelName(){
		return this.ArtikelName;
	}
	
	public void setArtikelName(String ArtikelName){
		this.ArtikelName = ArtikelName;
	}
	
}
