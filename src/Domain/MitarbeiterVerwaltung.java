package Domain;

import java.util.Vector;
import java.io.IOException;



import exceptions.MitarbeiterExistiertBereitsException;
import persistence.FilePersistenceManager;
import persistence.PersistenceManager;
import Valueobjects.Mitarbeiter;

public class MitarbeiterVerwaltung {
	

	private  Vector<Mitarbeiter> MitarbeiterListe = new Vector<Mitarbeiter>();
	
	private FilePersistenceManager pm = new FilePersistenceManager();
	
	public void liesDaten(String datei) throws IOException{
		pm.openForReading(datei);
		Mitarbeiter einMitarbeiter;
		do {
			// Buch-Objekt einlesen
			einMitarbeiter = pm.ladeMitarbeiter();
			if (einMitarbeiter != null) {
				// Buch in Liste einfügen
				try {
					einfuegen(einMitarbeiter);
				} catch (MitarbeiterExistiertBereitsException e1) {
					// Kann hier eigentlich nicht auftreten,
					// daher auch keine Fehlerbehandlung...
				}
			}
		} while (einMitarbeiter != null);

		// Persistenz-Schnittstelle wieder schließen
		pm.close();
	}
	public void schreibeDaten(String datei) throws IOException  {
		// PersistenzManager für Schreibvorgänge öffnen
		pm.openForWriting(datei);

		for (final Object mitarbeiter : MitarbeiterListe) {
			if (mitarbeiter != null) {
				// speichern
				pm.speichereMitarbeiter((Mitarbeiter) mitarbeiter);
			}
		}
		
		// Persistenz-Schnittstelle wieder schließen
		pm.close();
	}
	
/**
 * Methode, die ein Buch an das Ende der Bücherliste einfügt.
 * 
 * @param einBuch das einzufügende Buch
 * @throws BuchExistiertBereitsException wenn das Buch bereits existiert
 */
public void einfuegen(final Mitarbeiter einMitarbeiter) throws MitarbeiterExistiertBereitsException {
    if (MitarbeiterListe.contains(einMitarbeiter)) {
        throw new MitarbeiterExistiertBereitsException(einMitarbeiter, " - in 'einfuegen()'");
    }
    MitarbeiterListe.add(einMitarbeiter);
}

public boolean loeschen(Mitarbeiter einMitarbeiter) {
    // das übernimmt die BuchListe:
    return MitarbeiterListe.remove(einMitarbeiter);
}

/**
 * Methode, die anhand eines Titels nach Büchern sucht. Es wird eine Liste von Büchern
 * zurückgegeben, die alle Bücher mit exakt übereinstimmendem Titel enthält.
 * 
 * @param titel Titel des gesuchten Buchs
 * @return Liste der Bücher mit gesuchtem Titel (evtl. leer)
 */
public Vector<Mitarbeiter> sucheBuecher(final String Name) {
	final Vector<Mitarbeiter> ergebnis = new Vector<Mitarbeiter>();
	for (final Mitarbeiter mitarbeiter : MitarbeiterListe) {
		if (mitarbeiter.getName().equals(Name)) {
			// gefundenes Buch in Suchergebnis eintragen
		    ergebnis.add(mitarbeiter);
		}
	}
	return ergebnis;
}

/**
 * Methode, die den Bücherbestand zurückgibt.
 */
public Vector<Mitarbeiter> getMitarbeiterListe() {
	return MitarbeiterListe;
}
public Vector<Mitarbeiter> sucheMitarbeiter(String name) {
	// TODO Auto-generated method stub
	return null;
}
}
