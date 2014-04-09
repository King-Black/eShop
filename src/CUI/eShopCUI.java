import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import domain.ShopVerwaltung;
import domain.UserVerwaltung;
import exceptions.MitarbeiterExistiertBereitsException;

public class eShopCUI {
	//private ShopVerwaltung shop;
	private UserVerwaltung user;
	private BufferedReader in;
	
	public eShopCUI(String datei) throws IOException {
		//shop = new ShopVerwaltung(datei);
		user = new UserVerwaltung(datei);
		
		// Stream-Objekt fuer Texteingabe ueber Konsolenfenster erzeugen
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	//Startmenue wird ausgefuehrt
	private void gibMenueAus() {
		System.out.print("Willkommen beim eShop \n");
		System.out.print("Befehle: \n  login: 'l'");
        System.out.print("         \n  Registrieren als Mitarbeiter:  'm'");
        System.out.print("         \n  Registrieren als Kunde:  'k'");
		System.out.print("         \n > "); // Prompt
		System.out.flush(); // ohne NL ausgeben
	}
	
	// Liest die Eingabe von der Konsole
	private String liesEingabe() throws IOException {
		// einlesen von Konsole
		return in.readLine();
	}
	//Verarbeitet die Eingabe aus der Konsole
	private void verarbeiteEingabe(String line) throws IOException{
		//Registrierung des Mitarbeiters
		if (line.equals("m")) { 
			System.out.print("Name:  > ");
			String name = liesEingabe();
			System.out.print("Passwort:  > ");
			String passwort = liesEingabe();
			int mPasswort = Integer.parseInt(passwort);
			boolean ok = false;
			try {
				
				
				user.fuegeMitarbeiterEin(name, mPasswort);
				ok = true;
			} catch (MitarbeiterExistiertBereitsException e) {
				// Hier Fehlerbehandlung...
				e.printStackTrace();
			}

			if (ok)
				System.out.println("Die Registrierung hat geklappt!");
			else
				System.out.println("User existiert bereits!");
		}
		
		
	}
	
	public void run() {
		// Variable für Eingaben von der Konsole
		String input = ""; 
	
		// Hauptschleife der Benutzungsschnittstelle
		do {
			gibMenueAus();
			try {
				input = liesEingabe();
				verarbeiteEingabe(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (!input.equals("q"));
	}
	
	//Ausführen der Main-Methode, bzw Hauptprogramm
	public static void main(String[] args) {
		eShopCUI cui;
		try {
			cui = new eShopCUI("SHOP");
			cui.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
