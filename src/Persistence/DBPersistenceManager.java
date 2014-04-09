package Persistence;

import java.io.IOException;

import Persistence.PersistenceManager;
import Valueobjects.Mitarbeiter;

public class DBPersistenceManager implements PersistenceManager {

	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Mitarbeiter ladeMitarbeiter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void openForReading(String datenquelle) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openForWriting(String datenquelle) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean speichereMitarbeiter(Mitarbeiter m) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

}
