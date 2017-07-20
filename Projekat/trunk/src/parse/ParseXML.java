package parse;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import dataType.*;
import dataType.Package;
import model.Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * Koristi se za parsiranje XML fajla.
 * @author G6
 *
 */
public class ParseXML 
{
	Model model;
	Database database;
	ArrayList<Object> stavkeBaze=new ArrayList<>();
	ArrayList<Table> sveTabele = new ArrayList<>();
	
	/**
	 * Konstruktor klase ParseXML. Kreira objekat klase ParseXML.
	 * @param fileName Lokacija na kojoj se nalazi XML fajl.
	 * @param model Objekat klase Model u koji se podesavaju parametri konekcije.
	 */
	public ParseXML(String fileName, Model model)
	{
		database=new Database();
		try 
		{
			File xmlFile = new File(fileName);
			DocumentBuilderFactory databaseFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder=databaseFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			database.setIme(doc.getDocumentElement().getAttribute("name"));
			NodeList dbChildNodes = doc.getDocumentElement().getChildNodes();
			for (int i = 0; i < dbChildNodes.getLength(); i++)
			{
				Node dbChildNode = dbChildNodes.item(i);
				if (dbChildNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element packageElement = (Element) dbChildNode;
					if (packageElement.getTagName().equalsIgnoreCase("connection"))
					{
						model.setKorisnickoIme(packageElement.getAttribute("username"));
						model.setSifra(packageElement.getAttribute("password"));
						model.setAdresa(packageElement.getAttribute("address"));
						model.setPort(Integer.valueOf(packageElement.getAttribute("port")));
						model.setImeBaze(packageElement.getAttribute("database"));
					}
					else
					{
						stavkeBaze.add(this.parsePackages(dbChildNode));			
					}
				}
			}	
			database.setStavkeBaze(stavkeBaze);	
			model.setDatabase(database);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,	"Greska prilikom otvaranja XML fajla.");
		}
	}
	
	/**
	 * Metoda koja parsira pakete.
	 * @param node Cvor koji parsiramo.
	 * @return Vraca parsiran objekat.
	 */
	public Object parsePackages(Node node)
	{
		if (node.getNodeType() == Node.ELEMENT_NODE)
		{
			Element elementPaketa = (Element) node;
			if (elementPaketa.getTagName().equalsIgnoreCase("table"))
			{
				Object pomTabela = parseTable(node);
				this.sveTabele.add((Table)pomTabela);
				return pomTabela;
			} 
			else 
			{
				Package pack = new Package(elementPaketa.getAttribute("name"));
				ArrayList<Object> elementi = new ArrayList<>();
				NodeList pktChildNodes = node.getChildNodes();
				for (int j = 0; j < pktChildNodes.getLength(); j++)
				{
					Node pktNode = pktChildNodes.item(j);
					if (pktNode.getNodeType() == Node.ELEMENT_NODE)
					{
						elementi.add(this.parsePackages(pktNode));
					}
				}
				pack.setStavkePaketa(elementi);
				return pack;
			}
		}
		return null;
	}
	
	/**
	 * Metoda koja parsira cvor i generise objekat klase Table.
	 * @param node Cvor iz koga se generise objekat Table.
	 * @return Popunjen objekat klase Table.Vraca null u slucaju da nije uspjelo.
	 */
	public Table parseTable(Node node)
	{
		if (node.getNodeType() == Node.ELEMENT_NODE)
		{
			Element tabeleElement = (Element) node;
			Table tabela = new Table(tabeleElement.getAttribute("name"), tabeleElement.getAttribute("code"));
			Vector<Column> kolone = new Vector<>();
			ArrayList<String> grupe = new ArrayList<>();
			ArrayList<String> crud = new ArrayList<>();
			NodeList tbChildNodes = node.getChildNodes();
			for (int i = 0; i < tbChildNodes.getLength(); i++) 
			{
				Node tbChildNode = tbChildNodes.item(i);
				if (tbChildNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element tableElement = (Element) tbChildNode;
					if (tableElement.getTagName().equalsIgnoreCase("column"))
					{			
						Column col = new Column();
						col.setKod(tableElement.getAttribute("code"));
						col.setGrupa(Integer.valueOf(tableElement.getAttribute("group")));
						col.setIme(tableElement.getAttribute("name"));
						
						if (tableElement.getAttribute("nullable").equals("true"))
						{
							col.setNullable(true);
						}
						else
						{
							col.setNullable(false);
						}

						if (tableElement.getAttribute("primary").equals("true"))
						{
							col.setPrimarniKljuc(true);
						}
						else
						{
							col.setPrimarniKljuc(false);
						}

						if (tableElement.getAttribute("size") == "")
						{
							col.setVelicina(0);
						}
						else
						{
							col.setVelicina(Integer.valueOf(tableElement.getAttribute("size")));
						}

						col.setTipPodatka(tableElement.getAttribute("type"));
						kolone.add(col);
						
						NodeList colChNodes = tableElement.getChildNodes();
						for (int m = 0; m < colChNodes.getLength(); m++)
						{
							Node colNode = colChNodes.item(m);
							if (colNode.getNodeType() == Node.ELEMENT_NODE)
							{
								Element colEl = (Element) colNode;

								if (colEl.getTagName().equalsIgnoreCase("references"))
								{
									col.setRefKolona(colEl.getAttribute("refColumn"));
									col.setRefTabela(colEl.getAttribute("refTable"));
								}
							}
						}
					}
					else if (tableElement.getTagName().equalsIgnoreCase("groups")) 
					{
						NodeList groupChildNodes = tableElement.getChildNodes();
						for (int t = 0; t < groupChildNodes.getLength(); t++)
						{
							Node groupNode = groupChildNodes.item(t);
							if (groupNode.getNodeType() == Node.ELEMENT_NODE)
							{
								Element groupElement = (Element) groupNode;

								if (groupElement.getTagName().equalsIgnoreCase("group"))
								{
									String groupName = null;
									groupName = groupElement.getAttribute("name");
									grupe.add(groupName);
								}
							}
						}
					}
					else if (tableElement.getTagName().equalsIgnoreCase("crud")) 
					{
						NodeList crudChNodes = tableElement.getChildNodes();
						for (int l = 0; l < crudChNodes.getLength(); l++)
						{
							Node crudNode = crudChNodes.item(l);
							if (crudNode.getNodeType() == Node.ELEMENT_NODE)
							{
								Element crudEl = (Element) crudNode;
								if (crudEl.getTagName().equalsIgnoreCase("create"))
								{
									crud.add(crudEl.getAttribute("procedure"));
								}
								else if (crudEl.getTagName().equalsIgnoreCase("retrieve"))
								{
									crud.add(crudEl.getAttribute("procedure"));
								}
								else if (crudEl.getTagName().equalsIgnoreCase("update"))
								{
									crud.add(crudEl.getAttribute("procedure"));
								}
								else if (crudEl.getTagName().equalsIgnoreCase("delete"))
								{
									crud.add(crudEl.getAttribute("procedure"));
								}
							}
						}
					}
				}
			}
			tabela.setGrupe(grupe);
			tabela.setsProcedure(crud);
			tabela.setKolone(kolone);
			return tabela;
		}
		return null;
	}

	public ArrayList<Table> getSveTabele() {
		return sveTabele;
	}

	public void setSveTabele(ArrayList<Table> sveTabele) {
		this.sveTabele = sveTabele;
	}
}
