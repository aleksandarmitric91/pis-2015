package viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import controler.LWCancel;
import controler.LWSelect;
import dataType.Column;
import dataType.Table;
/**
 * Klasa zaduzena za kreiranje izgleda selekcionog prozora.
 * @author G6
 *
 */
public class LinkedWindow 
{
	ToolbarLW toolbar;
	View view;
	JButton Select;
	JButton Cancel;
	DBTable dBtabela;
	LWCancel cancel;
	LWSelect select;
	JFrame linkedFrame;
	Column trazenaKolona;
	Table otvorenaTabela;
	Vector<Column> kolone;
	Vector<Object> prethodnoStanjeInputa;
	/**
	 * Konstruktor za kreiranje objekta
	 * @param view Objekat klase View za iscrtavanje osnovnog prozora
	 * @param naziv Naziv prozora selekcionog prozora
	 * @param tableModel Model tabele za prikaz
	 * @param tabela Parametar koji se ispisuje u selekcionom prozoru
	 * @param trazenaKolona Trazena kolona 
	 */
	public LinkedWindow(View view, String naziv, DefaultTableModel tableModel, Table tabela, Column trazenaKolona)
	{
		this.view = view;
		this.trazenaKolona = trazenaKolona;
		otvorenaTabela = tabela;
		this.kolone=tabela.getKolone();
		prethodnoStanjeInputa = new Vector<>();
		prethodnoStanjeInputa.clear();
		
		
		linkedFrame = new JFrame();
		linkedFrame.setTitle(naziv);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		linkedFrame.setLayout(new BorderLayout());
		linkedFrame.setSize(screenSize.width*2/5, screenSize.height*3/5);
		linkedFrame.setMinimumSize(new Dimension(300, 100));
		linkedFrame.setLocation(screenSize.width/2-(screenSize.width*2/5)/2,screenSize.height/2-(screenSize.height*3/5)/2);
		linkedFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons/dbicon.png"));
		
		cancel = new LWCancel(this.linkedFrame);
		select = new LWSelect(this, this.linkedFrame);
		Select = new JButton("Select");
		Cancel = new JButton("Cancel");
		Select.addActionListener(select);
		Cancel.addActionListener(cancel);
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel flowPanel = new JPanel(new FlowLayout(2));
		
		flowPanel.add(Cancel);
		flowPanel.add(Select);
		
		toolbar = new ToolbarLW(this);
		
		panel.add(toolbar, BorderLayout.NORTH);
		dBtabela=new DBTable(this.view);
		dBtabela.setTableModel(tableModel);
		dBtabela.setHeader(tabela);
		dBtabela.SelectRow(0, 0);
		panel.add(dBtabela, BorderLayout.CENTER);
		panel.add(flowPanel, BorderLayout.SOUTH);
		
		linkedFrame.add(panel);
		linkedFrame.setVisible(true);
		
		prethodnoStanjeInputa = this.view.inputFields.getInputFieldData(this.view, tabela.getKolone());
	}
	
	public JFrame getLinkedFrame(){
		return linkedFrame;
	}

	public void setLinkedFrame(JFrame linkedFrame){
		this.linkedFrame = linkedFrame;
	}

	public DBTable getdBtabela() {
		return dBtabela;
	}

	public void setdBtabela(DBTable dBtabela) {
		this.dBtabela = dBtabela;
	}

	public Column getTrazenaKolona() {
		return trazenaKolona;
	}

	public void setTrazenaKolona(Column trazenaKolona) {
		this.trazenaKolona = trazenaKolona;
	}

	public Table getOtvorenaTabela() {
		return otvorenaTabela;
	}

	public void setOtvorenaTabela(Table otvorenaTabela) {
		this.otvorenaTabela = otvorenaTabela;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Vector<Object> getPrethodnoStanjeInputa() {
		return prethodnoStanjeInputa;
	}

	public void setPrethodnoStanjeInputa(Vector<Object> prethodnoStanjeInputa) {
		this.prethodnoStanjeInputa = prethodnoStanjeInputa;
	}
}
