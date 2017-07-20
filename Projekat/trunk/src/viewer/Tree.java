package viewer;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.ConnectionClass;
import dataType.Column;
import dataType.Package;
import dataType.Database;
import dataType.Table;

/**
 * Klasa Tree nasljedjuje JPanel i implementira  MouseListener.
 * Na osnovu ove klase kreira se stablo u prozoru preko ucitanog XMLa
 * @author AleksandraV
 *
 */
public class Tree extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	
	private View view;
	private JTree serverTree;
	private JScrollPane scrollPane = null;
	Statusbar statusbar;
	Toolbar toolbar;
	Menubar menu;
	DBTable dbTabela;
	DefaultMutableTreeNode stavkeTabele;
	Vector<Object> collums;
	Vector<Vector<Object>> values;
	public Vector<Column> kolone = new Vector<>();
	InputFields inputFields;
	static Table tabela;
	static DefaultMutableTreeNode selectedElement = null;
	
	/**
	 * Konstruktor klase Tree podesava osnovni izgled stabla u progrmau i kreira objekat ove klase.
	 * @param Objekat klase View odgovoran za prikaz glavnog prozora.
	 */
	public Tree(View view)
	{
		this.view = view;
		setLayout(new BorderLayout());
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
	}
	
	/**
	 * Funkcija createTree kreira drvce na osnovu baze koja je procitana 
	 * @param database baza podataka cije se drvce ispisuje
	 */
	public void createTree(Database database)
	{
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(database);
		
		for(int i = 0; i < database.getStavkeBaze().size(); i++)
		{
			if(database.getStavkeBaze().get(i) instanceof Package)
			{
				Package paket = (Package) database.getStavkeBaze().get(i);
				DefaultMutableTreeNode pomPaket = new DefaultMutableTreeNode(paket);
				root.add(pomPaket);
				
				for(int j = 0; j < paket.getStavkePaketa().size(); j++)
				{
					if(paket.getStavkePaketa().get(j) instanceof Package)
					{
						Package paket1 = (Package) paket.getStavkePaketa().get(j);
						DefaultMutableTreeNode pomPaket2 = new DefaultMutableTreeNode(paket1);
						pomPaket.add(pomPaket2);
							
						for(int k = 0; k < paket1.getStavkePaketa().size(); k++) 
						{
							Table tabela = (Table) paket1.getStavkePaketa().get(k);
							DefaultMutableTreeNode table = new DefaultMutableTreeNode(tabela);
							pomPaket2.add(table);
							for(int l = 0; l < tabela.getKolone().size(); l++)
							{
								DefaultMutableTreeNode pomKolona = new DefaultMutableTreeNode(tabela.getKolone().get(l));
								table.add(pomKolona);
							}
						}
					}
					else
					{
						Table tabela = (Table) paket.getStavkePaketa().get(j);
						DefaultMutableTreeNode table = new DefaultMutableTreeNode(tabela);
						pomPaket.add(table);
						
						for(int k = 0; k < tabela.getKolone().size(); k++)
						{
							DefaultMutableTreeNode kolona = new DefaultMutableTreeNode(tabela.getKolone().get(k));
							table.add(kolona);
						}
					}
				}
			}
			else
			{
				Table tabela = (Table) database.getStavkeBaze().get(i);
				DefaultMutableTreeNode table = new DefaultMutableTreeNode(tabela);
				root.add(table);
				for(int j = 0; j < tabela.getKolone().size(); j++)
				{
					DefaultMutableTreeNode kolona = new DefaultMutableTreeNode(tabela.getKolone().get(j));
					table.add(kolona);
				}
			}
		}
		serverTree = new JTree(root);
		serverTree.setRowHeight(22);
		serverTree.setFocusable(false);
		serverTree.setCellRenderer(new TreeRenderer());
		serverTree.addMouseListener(this);
		
		scrollPane.setViewportView(serverTree);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
	}
	
	/**
	 * Funkcija mouseClicked provjerava dvo-klik misa u stablu koje je kreirano i na osnovu toga generise tabelu.
	 */
	@Override
	public void mouseClicked(MouseEvent click) throws NullPointerException
	{	
		if (click.getClickCount() == 2)
		{
			TreePath tp = serverTree.getSelectionPath();
			try 
			{
				selectedElement =(DefaultMutableTreeNode)serverTree.getSelectionPath().getLastPathComponent();
			} 
			catch (Exception e) {}
			
			if (tp != null)
			{
				if(selectedElement.getUserObject().getClass().getName()=="dataType.Table")
				{
					toolbar = this.view.getToolbar();
					if (!toolbar.accept.isEnabled())
					{
					tabela = (Table)selectedElement.getUserObject();
					String selectedTableName = ("Selected table: " + tabela.getIme());
					statusbar = this.view.getStatusbar();
					statusbar.setSelectedTable(selectedTableName);
					kolone.clear();
					collums = new Vector<>();
					values = new Vector<>();
					
					collums.add("#");					
					for (int i = 0; i < selectedElement.getChildCount(); i++) 
					{
						stavkeTabele=(DefaultMutableTreeNode) selectedElement.getChildAt(i);
						kolone.add((Column) stavkeTabele.getUserObject());
						collums.add(kolone.get(i).getIme());
					}
					dbTabela = this.view.getTabela();
					
					menu = this.view.getMenu();
					toolbar.enableToolbarButtons();
					menu.enableMenubarButtons();
					
					values = ConnectionClass.readTableData(tabela);
					
					DefaultTableModel tableModel = new DefaultTableModel(values, collums);
					
					dbTabela.setTableModel(tableModel);
					dbTabela.setHeader(tabela);
					dbTabela.setCollumNames(collums);
					dbTabela.SelectRow(0, 0);
					
					inputFields=this.view.getInputFields();
					inputFields.createInputFields(kolone, null);
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
	}

	public JTree getServerTree()
	{
		return serverTree;
	}

	public void setServerTree(JTree serverTree)
	{
		this.serverTree = serverTree;
	}

	public static Table getTabela()
	{
		return tabela;
	}

	public static DefaultMutableTreeNode getSelectedElement()
	{
		return selectedElement;
	}

	public Vector<Column> getKolone()
	{
		return kolone;
	}
}

