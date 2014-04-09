package Persistence;

import java.io.IOException;
import Valueobjects.Mitarbeiter;

public interface PersistenceManager {

	public void openForReading(String datenquelle) throws IOException;
	
	public void openForWriting(String datenquelle) throws IOException;
	
	public boolean close();

	/**
	 * Methode zum Einlesen der Buchdaten aus einer externen Datenquelle.
	 * 
	 * @return Buch-Objekt, wenn Einlesen erfolgreich, false null
	 */
	public Mitarbeiter ladeMitarbeiter() throws IOException;

	/**
	 * Methode zum Schreiben der Buchdaten in eine externe Datenquelle.
	 * 
	 * @param b Buch-Objekt, das gespeichert werden soll
	 * @return true, wenn Schreibvorgang erfolgreich, false sonst
	 */
	public boolean speichereMitarbeiter(Mitarbeiter m) throws IOException;

	/*
	 *  Wenn später mal eine Kundenverwaltung ergänzt wird:

	public Kunde ladeKunde() throws IOException;

	public boolean speichereKunde(Kunde k) throws IOException;
	
	*/
}
