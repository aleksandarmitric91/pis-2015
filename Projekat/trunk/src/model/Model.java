package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dataType.Database;
import dataType.Table;

/**
 * Koristi se za pribavljanje konekcionih podataka.
 * @author G6
 *
 */
public class Model
{	
	Connection konekcija = null;
	String adresa, imeBaze, korisnickoIme, sifra;
	int port;
	
	ArrayList<Table> tabele = new ArrayList<>();
	Database database;

	public Connection getKonekcija() {
		return konekcija;
	}

	public void setKonekcija(Connection konekcija) {
		this.konekcija = konekcija;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getImeBaze() {
		return imeBaze;
	}

	public void setImeBaze(String imeBaze) {
		this.imeBaze = imeBaze;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	/**
	 * Metoda koja poziva metodu klase ConnectionClass radi ostvarivanja konekcije u modelu.
	 */
	public void connect()
	{
		konekcija = ConnectionClass.getConnection(adresa, port, imeBaze, korisnickoIme, sifra);
		System.out.println("Konekcija otvorena: "+ konekcija.toString());
	}
	
	/**
	 * Metoda za zatvaranje konecije u modelu.
	 */
	public void disconnect()
	{
		this.database = null;
		try 
		{
			if (konekcija != null && !konekcija.isClosed())
			{
				ConnectionClass.closeConnection();
				System.out.println("Konekcija zatvorena: "+ konekcija.toString());
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<Table> getTabele() {
		return tabele;
	}

	public void setTabele(ArrayList<Table> tabele) {
		this.tabele = tabele;
	}
}