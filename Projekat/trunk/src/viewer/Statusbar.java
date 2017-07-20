package viewer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Klasa Statusbar prikazuje status bar u glavnom prozoru sa svim podacima u njemu.
 * Nalaze se podaci o prikazanoj tabeli, o stanju i o trenutno selektovanom redu.
 * 
 * @author G6
 */
public class Statusbar extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private View view = null;
	private JLabel selectedTable = new JLabel();
	private JLabel viewerState = new JLabel();
	private JLabel selectedRow = new JLabel();
	private String statusTabela = new String("Selected table: Table not selected");
	private String statusState = new String("State: Ready");
	private String statusRow = new String("Current row: ");
	
	/**
	 * Konstruktor klase Statusbar,prikazuje status bar u osnovnom prozoru i prosljedjuje 
	 * joj potrebne paramerte.
	 * @param view prikaz osnovnog prozora
	 */
	public Statusbar(View view)
	{
		this.view = view;
		setLayout(new BorderLayout());
		
		JPanel statusBar = new JPanel(new GridLayout());
		
		JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel element = new JPanel(new GridLayout());
		element.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		selectedTable.setText(statusTabela);
		element.add(selectedTable);
		left.add(element);
		
		JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel state = new JPanel(new GridLayout());
		state.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		viewerState.setText(statusState);
		state.add(viewerState);
		center.add(state);
		
		JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel row = new JPanel(new GridLayout());
		row.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		selectedRow.setText(statusRow);
		row.add(selectedRow);
		right.add(row);
		
		statusBar.add(left, BorderLayout.WEST);
		statusBar.add(center, BorderLayout.CENTER);
		statusBar.add(right, BorderLayout.EAST);
		
		add(statusBar);
	}
	
	public JLabel getSelectedTable() 
	{
		return selectedTable;
	}

	public void setSelectedTable(String selectedTable) 
	{
		this.selectedTable.setText(selectedTable);
	}

	public JLabel getViewerState() 
	{
		return viewerState;
	}

	public void setViewerState(String viewerState) 
	{
		this.viewerState.setText(viewerState);
	}

	public JLabel getSelectedRow() 
	{
		return selectedRow;
	}

	public void setSelectedRow(String selectedRow) 
	{
		this.selectedRow.setText(selectedRow);
	}
}