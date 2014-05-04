package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Persistence.PersistenceManager;
import Valueobjects.Mitarbeiter;

public class FilePersistenceManger implements PersistenceManager{


	private BufferedReader reader = null;
	private PrintWriter writer = null;
	
	public void openForReading(String datei) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(datei));
	}

	public void openForWriting(String datei) throws IOException {
		writer = new PrintWriter(new BufferedWriter(new FileWriter(datei)));
	}

	public boolean close() {
		if (writer != null)
			writer.close();
		
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return false;
			}
		}

		return true;
	}

	/**
	 * Methode zum Einlesen der Buchdaten aus einer externen Datenquelle.
	 * Das Verfügbarkeitsattribut ist in der Datenquelle (Datei) als "t" oder "f"
	 * codiert abgelegt.
	 * 
	 * @return Buch-Objekt, wenn Einlesen erfolgreich, false null
	 */
	public Mitarbeiter ladeMitarbeiter() throws IOException {
		// Name einlesen
		String name = liesZeile();
		if (name == null) {
			// keine Daten mehr vorhanden
			return null;
		}
		// Passwort einlesen ...
		String MpasswortString = liesZeile();
		// ... und von String in int konvertieren
		int passwort = Integer.parseInt(MpasswortString);
		
		// Buch ausgeliehen?
		String verfuegbarCode = liesZeile();
		// Codierung des Ausleihstatus in boolean umwandeln
		boolean verfuegbar = false;
		if (verfuegbarCode.equals("t"))
			verfuegbar = true;
		
		// neues Buch-Objekt anlegen und zurückgeben
		return new Mitarbeiter(name, passwort, verfuegbar);
	}

	/**
	 * Methode zum Schreiben der Buchdaten in eine externe Datenquelle.
	 * Das Verfügbarkeitsattribut wird in der Datenquelle (Datei) als "t" oder "f"
	 * codiert abgelegt.
	 * 
	 * @param b Buch-Objekt, das gespeichert werden soll
	 * @return true, wenn Schreibvorgang erfolgreich, false sonst
	 */
	public boolean speichereMitarbeiter(Mitarbeiter m) throws IOException {
		// Titel, Passwort und Verfügbarkeit schreiben
		schreibeZeile(m.getName());
		schreibeZeile(Integer.valueOf(m.getPasswort()).toString());
		if (m.isVerfuegbar())
			schreibeZeile("t");
		else
			schreibeZeile("f");

		return true;
	}


	
	private String liesZeile() throws IOException {
		if (reader != null)
			return reader.readLine();
		else
			return "";
	}

	private void schreibeZeile(String daten) {
		if (writer != null)
			writer.println(daten);
	}

}
