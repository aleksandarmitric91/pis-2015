package dataType;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Klasa vraca podatke u tabelu parsiranjem XML-a.
 * @author G6
 *
 */
public class Table
{
	private String kod;
	private String ime;
	
	private ArrayList<String> grupe = new ArrayList<String>();
	private Vector<Column> kolone = new Vector<Column>();
	private ArrayList<String> sProcedure = new ArrayList<String>();

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public ArrayList<String> getGrupe() {
		return grupe;
	}

	public void setGrupe(ArrayList<String> grupe) {
		this.grupe = grupe;
	}

	public Vector<Column> getKolone() {
		return kolone;
	}

	public void setKolone(Vector<Column> kolone2) {
		this.kolone = kolone2;
	}

	public ArrayList<String> getsProcedure() {
		return sProcedure;
	}

	public void setsProcedure(ArrayList<String> sProcedure) {
		this.sProcedure = sProcedure;
	}

	/**
	 * Konstruktor klase Table.
	 * @param ime Naziv tabele unutar baze.
	 * @param kod Kodno ime tabele.
	 */
	public Table(String ime, String kod)
	{
		this.ime = ime;
		this.kod = kod;
	}
}
