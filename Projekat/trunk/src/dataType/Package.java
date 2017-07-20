package dataType;

import java.util.ArrayList;

/**
 * Ova klasa vraca podatke paketu koji se dobijaju parsiranjem XML-a
 * @author G6
 *
 */
public class Package
{
	String ime;
	ArrayList<Object> stavkePaketa = new ArrayList<>();

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public ArrayList<Object> getStavkePaketa() {
		return stavkePaketa;
	}

	public void setStavkePaketa(ArrayList<Object> stavkePaketa) {
		this.stavkePaketa = stavkePaketa;
	}
	
	/**
	 * Konstruktor klase Package za smjestanje paketa.
	 * @param ime Ime paketa.
	 */
	public Package(String ime)
	{
		this.ime = ime;
	}
}
