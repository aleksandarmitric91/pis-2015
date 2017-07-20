package dataType;


import java.util.ArrayList;

/**
 * Ova klasa vraca podatke u tabelu na mjestu koje se dobija parsiranjem XML-a.
 * @author G6
 *
 */
public class Database
{
	String ime;
	ArrayList<Object> stavkeBaze=new ArrayList<>();
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public ArrayList<?> getStavkeBaze() {
		return stavkeBaze;
	}

	public void setStavkeBaze(ArrayList<Object> stavkeBaze) {
		this.stavkeBaze = stavkeBaze;
	}
}
