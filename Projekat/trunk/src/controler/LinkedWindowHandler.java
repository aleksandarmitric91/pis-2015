package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.ConnectionClass;
import dataType.Column;
import dataType.Table;
import viewer.LinkedWindow;
import viewer.View;

/**
 * Ova klasa sluzi za ucitavanje podataka novog selekcionog prozora i kreiranje selekcionog dijagrama.
 * 
 * @author G6
 */
public class LinkedWindowHandler implements ActionListener
{
	View view;
	Column kolona;
	LinkedWindow window;
	ArrayList<Table> sveTabele = new ArrayList<>();
	Vector<Vector<Object>> values;
	Vector<Object> collums;
	
	/**
	 * Konstruktor klase LinkedWindowHandler za kreiranje hendlera koji popunjava tabelu selekcionog dijagrama.
	 * 
	 * @param view Objekat klase za pristup elementima osnovnog prozora.
	 * @param kolona Lista kolona za header novog editora.
	 */
	public LinkedWindowHandler(View view, Column kolona)
	{
		this.view = view;
		this.kolona = kolona;
	}

	/**
	 * Akcija koja kreira promjenu selekcioni dijagram.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		collums = new Vector<>();
		values = new Vector<>();
		sveTabele = this.view.getModel().getTabele();
		
		for (int i = 0; i < sveTabele.size(); i++) 
		{
			if(kolona.getRefTabela().equals(sveTabele.get(i).getKod().toString()))
			{
				values = ConnectionClass.readTableData(sveTabele.get(i));
				
				collums.add("#");
				for (int j = 0; j < sveTabele.get(i).getKolone().size(); j++) 
				{
					collums.add(sveTabele.get(i).getKolone().get(j).getIme());
				}
				DefaultTableModel tableModel = new DefaultTableModel(values, collums);
				window = new LinkedWindow(this.view, sveTabele.get(i).getIme().toString(), tableModel, sveTabele.get(i), kolona);
			}
		}
	}

	public Column getKolona() {
		return kolona;
	}

	public void setKolona(Column kolona) {
		this.kolona = kolona;
	}

	public LinkedWindow getWindow() {
		return window;
	}

	public void setWindow(LinkedWindow window) {
		this.window = window;
	}
}
