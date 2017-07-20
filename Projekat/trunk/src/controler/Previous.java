package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.DBTable;
import viewer.LinkedWindow;
import viewer.View;

/**
 * Ova klasa vrsi selekciju prethodnog reda klikom na dugme Previous.
 *
 * @author G6
 */
public class Previous implements ActionListener 
{
	View view;
	DBTable tabela;
	LinkedWindow linkedWindow;
	
	/**
	 * Konstruktor klase Previous preko koga pozivamo akciju na klik.
	 * 
	 * @param view Objekat glavnog prozora preko koga pristupamo tabeli glavnog prozora.
	 * @param linkedWindow Objekat selekcionog prozora preko koga pristupamo tabeli selekcionog prozora.
	 */
	public Previous(View view, LinkedWindow linkedWindow)
	{
		this.linkedWindow = linkedWindow;
		this.view = view;		
	}
	
	/**
	 * Ova akcija pomjera pokazivac reda za jedno mjesto unazad.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(linkedWindow == null)
		{
			tabela = view.getTabela();
		}
		else
		{
			tabela = linkedWindow.getdBtabela();
		}
		int previous = tabela.getSelectedRow();
		previous--;
		if(previous >= 0)
		{
			tabela.SelectRow(previous, previous);			
		}
	}
}
