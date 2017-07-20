package viewer;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dataType.Table;
import viewer.CustomTableCellRenderer;

/**
 * Glavni panel za ispis tabele.
 * @author G6
 *
 */
public class DBTable extends JScrollPane
{
	static final long serialVersionUID = 1L;
	View view;
	
	private JTable tabela = null;
	private Vector<Object> collumNames;
	private Vector<Vector<Object>> values;
	Statusbar statusbar;
	
	/**
	 * Konstruktor klase DBTable.
	 * @param view Objekat klase View na kome se prikazuje DBTable.
	 */
	public DBTable(final View view)
	{ 
		this.view = view;
		collumNames = new Vector<>();
		values = new Vector<>();
		
		tabela = new JTable(new DefaultTableModel(values, collumNames));
		tabela.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		tabela.setColumnSelectionAllowed(false);
		tabela.setRowSelectionAllowed(true);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		if (!(values.size() == 0))
		{
			tabela.setRowSelectionInterval(0, 0);
		}
		
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
		
		setViewportView(tabela);
		
	    tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
	    {  
	        public void valueChanged(ListSelectionEvent e) 
	        {  
	           if(tabela.getSelectedRow() >= 0)
	           {
	        	   Toolbar toolbar = view.getToolbar();
	        	   if(toolbar.accept.isEnabled() == false)
	        	   {
	        	   view.inputFields.createInputFields(view.getDrvce().kolone, null);
	        	   Statusbar statusbar = view.getStatusbar();
	        	   DBTable tabela = view.getTabela();
	        	   String selectedRow = "Selected row: " + (tabela.getSelectedRow() + 1) + "/" + tabela.getRowCount();
	        	   statusbar.setSelectedRow(selectedRow);
	        	   }
	           }
	        }  
	    }); 
	}
	
	public JTable getTabela()
	{
		return tabela;
	}

	public void setTable(JTable tabela)
	{
		this.tabela.equals(tabela);
	}
	
	/**
	 * Metoda za selektovanje redova u intervalu.
	 * @param row1 Pocetni red.
	 * @param row2 Krajni red.
	 */
	public void SelectRow(int row1, int row2)
	{
		tabela.setRowSelectionInterval(row1, row1);
		row2=1;
		tabela.scrollRectToVisible(tabela.getCellRect(row1, row2, true));
	}
	
	public int getCollumnCount()
	{
		return tabela.getColumnCount();
	}
	
	public int getRowCount()
	{
		return tabela.getRowCount();
	}
	
	public int getSelectedRow()
	{
		return tabela.getSelectedRow();
	}
	
	public void setTableModel(DefaultTableModel tableModel)
	{
		this.tabela.setModel(tableModel);
	}
	
	/**
	 * Uzima vrijednost iz zadate kolone.
	 * @param row Red.
	 * @param col Kolona.
	 * @return Vraca vrijednost u celiji.
	 */
	public String getValueAt(int row, int col)
	{
		col++;
		try 
		{
			return tabela.getValueAt(row, col).toString();
		} catch (Exception e) 
		{
			return null;
		}
	}
	
	/**
	 * Postavlja i formatira heder tabele.
	 * @param table Tabela ciji se heder edituje.
	 */
	public void setHeader(Table table)
	{
		this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
		
		tabela.getColumnModel().getColumn(0).setPreferredWidth(5 * 8);
		
		for (int i = 0; i < table.getKolone().size(); i++)
		{
			if (table.getKolone().get(i).getTipPodatka().toString().contains("date"))
			{
				tabela.getColumnModel().getColumn(i + 1).setPreferredWidth(150);
			}
			else
			if (table.getKolone().get(i).getVelicina() < table.getKolone().get(i).getIme().length())
			{
				tabela.getColumnModel().getColumn(i + 1).setPreferredWidth(table.getKolone().get(i).getIme().length() * 5);
			}
			else
			{
				tabela.getColumnModel().getColumn(i + 1).setPreferredWidth(table.getKolone().get(i).getVelicina() * 5);
			}
		}
		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setColumnSelectionAllowed(false);
		tabela.setRowSelectionAllowed(true);
		tabela.setShowGrid(false);
		tabela.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
	}

	public Vector<Object> getCollumNames()
	{
		return collumNames;
	}

	public void setCollumNames(Vector<Object> collumNames)
	{
		this.collumNames = collumNames;
	}
}
