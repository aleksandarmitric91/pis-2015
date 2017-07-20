package model;

import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import viewer.DBTable;
import viewer.InputFields;
import viewer.Tree;
import viewer.View;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import dataType.Table;

/**
 * Ova klasa se koristi prilikom konekcije na bazu i provjerava validnost konekcije.
 *  Unutar klase se nalaze konekcioni parametri.
 * 
 * @author G6
 */
public class ConnectionClass
{
	static Connection konekcija = null;
	private static String drajver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String url = null;
	static String korisnickoIme = null;
	static String sifra = null;
	View view;
	InputFields input;

	/**
	 * Ova funkcija koristi se za pribavljane parametara za konekciju
	 * 
	 * @param adresa
	 * @param port
	 * @param database-ime baze 
	 * @param username-korisnicko ime 
	 * @param password-lozinka
	 * @return konekcija
	 */
	public static Connection getConnection(String adresa, int port, String database, String username, String password)
	{
		korisnickoIme = username.trim();
		sifra = password.trim();
		url = "jdbc:sqlserver://" + adresa + ":" + port + ";";
		try
		{
			Class.forName(drajver);

			Properties properties = new Properties();
			properties.put("databaseName", database);
			properties.put("user", korisnickoIme);
			properties.put("password", sifra);
			
			konekcija = DriverManager.getConnection(url, properties);
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Konekcija nije usppjela.\nOdbijen pristup bazi.");
		} 
		catch (ClassNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "Konekcija nije usppjela.\nDrajver jebe ne prestaje.");
		}
		return konekcija;
	}

	/**
	 * Funkcija za zatvaranje konekcije
	 */
	public static void closeConnection()
	{
		try
		{
			konekcija.close();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,	"Doslo je do greske prilikom prekida konekcije.");
		}
	}
	
	/**
	 * Funkcija za citanje podataka sa baze.
	 * 
	 * @param table Tabela iz koje citamo podatke
	 * @return Procitani podatci iz tabele.
	 */
	public static ResultSet read(Table table)
	{
		ResultSet rs = null;
		try
		{
			CallableStatement procStmt = konekcija.prepareCall("{ call " + table.getsProcedure().get(1) + "() }", 
					SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, SQLServerResultSet.CONCUR_READ_ONLY);
			rs = procStmt.executeQuery();
		}
		catch (SQLException e1)
		{
			JOptionPane.showMessageDialog(null, "Upit nije izvrsen.\nOpis greške:\n" + e1.getMessage()); 
		}
		return rs;
	}

	/**
	 * Funkcija za vracanje podataka pomocu kojih popunjavamo tabelu.
	 * 
	 * @param table Tabela iz koje citamo podatke
	 * @return Procitani podaci.
	 */
	public static Vector<Vector<Object>> readTableData(Table table)
	{
		Vector<Vector<Object>> rowsData = new Vector<>();
		ResultSet rs = ConnectionClass.read(table);
		int br = 1;
		try
		{
			while(rs.next())
			{
				Vector<Object> rowData = new Vector<>();
				rowData.add(br);
				br++;
				for (int i = 0; i < table.getKolone().size(); i++)
				{
					String type = table.getKolone().get(i).getTipPodatka().toString();
					
					if (type.contains("char"))
					{
						if (rs.getString(i + 1) == null)
						{
							rowData.add(new String(""));
						}
						else
						{
							rowData.add(new String(rs.getString(i + 1)));
						}
					}
					else if (type.contains("numeric"))
					{
						rowData.add(new Long(rs.getLong(i + 1)));
					}
					else if (type.contains("int"))
					{
						rowData.add(new Integer(rs.getInt(i + 1)));
					}
					else if (type.contains("bit"))
					{
						rowData.add(new Boolean(rs.getBoolean(i + 1)));
					}
					else if (type.contains("float"))
					{
						rowData.add(new Double(rs.getDouble(i + 1)));
					}
					else if (type.contains("image"))
					{
						byte[] bitovi = rs.getBytes(i + 1);
						rowData.add(bitovi);
					}
					else if (type.contains("date"))
					{
						rowData.add(rs.getDate(i + 1));
					}
					else
					{
						JOptionPane.showMessageDialog(null, 
								"Tip podatka " + type + " nije prepoznat.");
					}
				}
				rowsData.add(rowData);
			}
			return rowsData;
		}
		catch (HeadlessException e)
		{
			JOptionPane.showMessageDialog(null,"Rezultat upita nije u redu.");
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Rezultat upita nije u redu.\nProvjerite vezu sa bazom.");
		}
		return null;
	}
	
	/**
	 * Funkija koja izvrsava brisanje podatka iz baze.
	 * 
	 * @param table Tabele u kojoj se brisu podatci.
	 * @param view Objekat klase View za pristup osnovnom prozoru.
	 */
	public static void delete(Table table, View view)
	{
		DBTable tabela = view.getTabela();
		Vector<Vector<Object>> values = ConnectionClass.readTableData(table);
		Vector<Object> colums = tabela.getCollumNames();
		
		Vector<Object> pkIndex = new Vector<>();
		for (int i = 0; i < table.getKolone().size(); i++)
		{
			if (table.getKolone().get(i).isPrimarniKljuc())
			{
				pkIndex.add(i);
			}
		}
		CallableStatement deleteProcedure = null;
		
		String procedura = table.getsProcedure().get(3)+ "(?";
		
		for (int i = 1; i < pkIndex.size(); i++)
		{
			procedura += ",?";
		}
		procedura += ")";
		
		try
		{
			deleteProcedure = konekcija.prepareCall("{ call " + procedura + " }", 
					SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, 
					SQLServerResultSet.CONCUR_READ_ONLY);
			
			for (int i = 0; i < pkIndex.size(); i++)
			{
				Object val = values.get(tabela.getSelectedRow()).get((int) pkIndex.get(i)+1);
				
				System.out.println("VAL = " + val);
				if (val instanceof String)
				{
					deleteProcedure.setString(i + 1, (String) val);
				}
				else if (val instanceof Integer)
				{
					deleteProcedure.setInt(i + 1, (Integer) val);
				}
				else if (val instanceof Long)
				{
					deleteProcedure.setLong(i + 1, (Long) val);
				}
				else if (val instanceof Boolean)
				{
					deleteProcedure.setBoolean(i + 1, (Boolean) val);
				}
				else if (val instanceof Double)
				{
					deleteProcedure.setFloat(i + 1, (Float) val);
				}
				else if (val instanceof Byte[])
				{
					deleteProcedure.setBytes(i + 1, (byte[]) val);
				}
				else if (val instanceof Date)
				{
					deleteProcedure.setString(i + 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) val));
				}
			}
			deleteProcedure.executeUpdate();
			values = ConnectionClass.readTableData(table);
			DefaultTableModel tableModel = new DefaultTableModel(values, colums);
			tabela.setTableModel(tableModel);
			tabela.setHeader(table);
			tabela.SelectRow(0, 0);
			JOptionPane.showMessageDialog(null, "Obrisano");
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Upit (DELETE) nije izvrsen.\nOpis greške:\n" + e.getMessage());
			e.printStackTrace();
		}
	}
		
	/**
	 * Funkija koja izvrsava kreiranje podatka u bazi.
	 * 
	 * @param table Tabele u kojoj se ubacuju podatci.
	 * @param view Objekat klase View za pristup osnovnom prozoru.
	 */
	public static void insert(Table table, View view)
	{
		DBTable tabela = view.getTabela();
		
		InputFields input = view.getInputFields();
		Tree tree = view.getDrvce();
		Vector<Object> podaci = input.getInputFieldData(view, input.getColumn());
		
		CallableStatement insertProcedure = null;
		String procedura = table.getsProcedure().get(0)+ "(?";
		
		for (int i = 1; i < table.getKolone().size(); i++)
		{
			procedura += ",?";
		}
		procedura += ")";
		
		try
		{
			insertProcedure = konekcija.prepareCall("{ call " + procedura + " }", 
					SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, 
					SQLServerResultSet.CONCUR_READ_ONLY);
			
			for (int i = 0; i < table.getKolone().size(); i++)
			{
				Object val = podaci.get(i);
				
				String type = table.getKolone().get(i).getTipPodatka();
				
				if (val == null || val.toString().equals(""))
				{
					if (type.contains("varchar"))
					{
						insertProcedure.setNull(i + 1, Types.VARCHAR);
					}
					else if (type.contains("char"))
					{
						insertProcedure.setNull(i + 1, Types.CHAR);
					}
					else if (type.contains("numeric"))
					{
						insertProcedure.setNull(i + 1, Types.NUMERIC);
					}
					else if (type.contains("small"))
					{
						insertProcedure.setNull(i + 1, Types.SMALLINT);
					}
					else if (type.contains("int"))
					{
						insertProcedure.setNull(i + 1, Types.INTEGER);
					}
					else if (type.contains("bit"))
					{
						insertProcedure.setNull(i + 1, Types.BIT);
					}
					else if (type.contains("float"))
					{
						insertProcedure.setNull(i + 1, Types.FLOAT);
					}
					else if (type.contains("image"))
					{
						insertProcedure.setNull(i + 1, Types.BINARY);
					}
					else if (type.contains("date"))
					{
						insertProcedure.setNull(i + 1, Types.DATE);
					}
				}
				if (val instanceof Date)
				{
					Date datum = (Date)val;
					int godina = (new Date().getYear() > 2000) ? (2000 + datum.getYear()) : (1900 + datum.getYear());
					String tekst = godina + "-" + (datum.getMonth() + 1) + "-" + datum.getDate();
					insertProcedure.setString(i + 1, tekst);
				}	
				else if (val instanceof Byte[])
				{
					insertProcedure.setBytes(i + 1, (byte[]) val);
				}
				else if (type.contains("varchar"))
				{
					val = podaci.get(i).toString();
					insertProcedure.setString(i + 1, (String) val);
				}
				else if (type.contains("char"))
				{
					val = podaci.get(i).toString();
					insertProcedure.setString(i + 1, (String) val);
				}
				else if (type.contains("numeric"))
				{
					val = Integer.parseInt(podaci.get(i).toString());
					insertProcedure.setInt(i + 1, (Integer) val);
				}
				else if (type.contains("small"))
				{
					val = Integer.parseInt(podaci.get(i).toString());
					insertProcedure.setInt(i + 1, (Integer) val);
				}
				else if (type.contains("int"))
				{
					val = Integer.parseInt(podaci.get(i).toString());
					insertProcedure.setInt(i + 1, (Integer) val);
				}
				
				else if (type.contains("float"))
				{
					val = Float.parseFloat(podaci.get(i).toString());
					insertProcedure.setFloat(i + 1, (Float) val);
				}
				else if(val == "True")
				{
					insertProcedure.setBoolean(i + 1, true);
				}
				else if(val == "False")
				{
					insertProcedure.setBoolean(i + 1, (boolean) false);
				}
			}
			insertProcedure.executeUpdate();
			Vector<Vector<Object>> values = ConnectionClass.readTableData(table);
			Vector<Object> colums = tabela.getCollumNames();
			DefaultTableModel tableModel = new DefaultTableModel(values, colums);
			tabela.setTableModel(tableModel);
			tabela.setHeader(table);
			tabela.SelectRow(0, 0);
			JOptionPane.showMessageDialog(null, "Update complete");
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, 
					"Upit (INSERT) nije izvrsen.\nOpis greške:\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Funkija koja izvrsava ubacivanje podatka u bazu.
	 * 
	 * @param table Tabele u kojoj se mjenjaju podatci.
	 * @param view Objekat klase View za pristup osnovnom prozoru.
	 */
	public static void update(Table table, View view)
	{
		
		DBTable tabela = view.getTabela();
		
		InputFields input = view.getInputFields();
		Tree tree = view.getDrvce();
		Vector<Object> podaci = input.getInputFieldData(view, input.getColumn());
		
		CallableStatement updateProcedure = null;
		
		String procedura = table.getsProcedure().get(2)+ "(?";
		
		for (int i = 1; i < table.getKolone().size(); i++)
		{
			procedura += ",?";
		}
		procedura += ")";
		
		try
		{
			updateProcedure = konekcija.prepareCall("{ call " + procedura + " }", 
					SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, 
					SQLServerResultSet.CONCUR_READ_ONLY);
			
			for (int i = 0; i < table.getKolone().size(); i++)
			{
				Object val = podaci.get(i);
				
				String type = table.getKolone().get(i).getTipPodatka();
				
				if (val == null || val.toString().equals(""))
				{
					if (type.contains("varchar"))
					{
						updateProcedure.setNull(i + 1, Types.VARCHAR);
					}
					else if (type.contains("char"))
					{
						updateProcedure.setNull(i + 1, Types.CHAR);
					}
					else if (type.contains("numeric"))
					{
						updateProcedure.setNull(i + 1, Types.NUMERIC);
					}
					else if (type.contains("small"))
					{
						updateProcedure.setNull(i + 1, Types.SMALLINT);
					}
					else if (type.contains("int"))
					{
						updateProcedure.setNull(i + 1, Types.INTEGER);
					}
					else if (type.contains("bit"))
					{
						updateProcedure.setNull(i + 1, Types.BIT);
					}
					else if (type.contains("float"))
					{
						updateProcedure.setNull(i + 1, Types.FLOAT);
					}
					else if (type.contains("image"))
					{
						updateProcedure.setNull(i + 1, Types.BINARY);
					}
					else if (type.contains("date"))
					{
						updateProcedure.setNull(i + 1, Types.DATE);
					}
				}
				if (val instanceof Date)
				{
					Date datum = (Date)val;
					int godina = (new Date().getYear() > 2000) ? (2000 + datum.getYear()) : (1900 + datum.getYear());
					String tekst = godina + "-" + (datum.getMonth() + 1) + "-" + datum.getDate();
					updateProcedure.setString(i + 1, tekst);
				}	
				else if (val instanceof Byte[])
				{
					updateProcedure.setBytes(i + 1, (byte[]) val);
				}
				else if (type.contains("varchar"))
				{
					val = podaci.get(i).toString();
					updateProcedure.setString(i + 1, (String) val);
				}
				else if (type.contains("char"))
				{
					val = podaci.get(i).toString();
					updateProcedure.setString(i + 1, (String) val);
				}
				else if (type.contains("numeric"))
				{
					val = Integer.parseInt(podaci.get(i).toString());
					updateProcedure.setInt(i + 1, (Integer) val);
				}
				else if (type.contains("small"))
				{
					val = Integer.parseInt(podaci.get(i).toString());
					updateProcedure.setInt(i + 1, (Integer) val);
				}
				else if (type.contains("int"))
				{
					val = Integer.parseInt(podaci.get(i).toString());
					updateProcedure.setInt(i + 1, (Integer) val);
				}
				
				else if (type.contains("float"))
				{
					val = Float.parseFloat(podaci.get(i).toString());
					updateProcedure.setFloat(i + 1, (Float) val);
				}
				else if(val == "True")
				{
					updateProcedure.setBoolean(i + 1, true);
				}
				else if(val == "False")
				{
					updateProcedure.setBoolean(i + 1, (boolean) false);
				}
			}
			updateProcedure.executeUpdate();
			Vector<Vector<Object>> values = ConnectionClass.readTableData(table);
			Vector<Object> colums = tabela.getCollumNames();
			DefaultTableModel tableModel = new DefaultTableModel(values, colums);
			tabela.setTableModel(tableModel);
			tabela.setHeader(table);
			tabela.SelectRow(0, 0);
			JOptionPane.showMessageDialog(null, "Update complete");
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, 
					"Upit (INSERT) nije izvrsen.\nOpis greške:\n" + e.getMessage());
			e.printStackTrace();
		}
	}

}