package Domain;

import java.io.IOException;
import java.util.Vector;

import exceptions.MitarbeiterExistiertBereitsException;
import Valueobjects.Mitarbeiter;


public class UserVerwaltung {
	private String datei = "";
	
	private MitarbeiterVerwaltung meinMitarbeiter;
	// private KundenVerwaltung meineKunden;
	// hier weitere Verwaltungsklassen, z.B. für Autoren oder Angestellte
	

	public UserVerwaltung(String datei) throws IOException {
		this.datei = datei;
		
		// Mitarbeiter aus Datei einlesen
		meinMitarbeiter = new MitarbeiterVerwaltung();
		meinMitarbeiter.liesDaten(datei+"_M.txt");
		meinMitarbeiter.schreibeDaten(datei+"_M.txt");

//		// Kundenkartei aus Datei einlesen
//		meineKunden = new KundenVerwaltung();
//		meineKunden.liesDaten(datei+"_K.txt");
//		meineKunden.schreibeDaten(datei+"_K.txt");
	}



	public Vector<Mitarbeiter> gibAlleMitarbeiter() {
		// einfach delegieren an meineBuecher
		return meinMitarbeiter.getMitarbeiterListe();
	}


	public Vector<Mitarbeiter> sucheNachName(String name) {
		// einfach delegieren an meineBuecher
		return meinMitarbeiter.sucheMitarbeiter(name); 
	}


	public void fuegeMitarbeiterEin(String name, int passwort) throws MitarbeiterExistiertBereitsException {
		Mitarbeiter m = new Mitarbeiter(name, passwort);
		meinMitarbeiter.einfuegen(m);
	}
	
	public boolean loescheErstesBuchMitTitel(final String name) {
	    final Vector<Mitarbeiter> liste = meinMitarbeiter.sucheMitarbeiter(name);
	    if (liste.size() == 0) {
	        return false;
	    }
        final Mitarbeiter mitarbeiter = (Mitarbeiter) liste.elementAt(0);
	    return meinMitarbeiter.loeschen(mitarbeiter);
	}

	/**
	 * Methode zum Speichern des Buchbestands in einer Datei.
	 * 
	 * @throws IOException
	 */
	public void schreibeBuecher() throws IOException {
		meinMitarbeiter.schreibeDaten(datei+"_M.txt");
	}

		}
