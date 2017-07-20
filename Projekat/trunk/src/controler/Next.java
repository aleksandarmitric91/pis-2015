package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.DBTable;
import viewer.LinkedWindow;
import viewer.View;

/**
 * Ova klasa vrsi selekciju sledeceg reda klikom na dugme Next.
 * 
 * @author G6
 */
public class Next implements ActionListener 
{
	View view;
	DBTable tabela;
	LinkedWindow linkedWindow;
	
	/**
	 * Konstruktor klase Next preko koga pozivamo akciju na klik.
	 * 
	 * @param view Objekat glavnog prozora preko koga pristupamo tabeli glavnog prozora.
	 * @param linkedWindow Objekat selekcionog prozora preko koga pristupamo tabeli selekcionog prozora.
	 */
	public Next(View view, LinkedWindow linkedWindow)
	{
		this.linkedWindow = linkedWindow;
		this.view = view;
	}
	
	/**
	 * Ova akcija pomjera pokazivac reda za jedno mjesto unapred.
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
		int next = tabela.getSelectedRow();
		next++;
		if(next < tabela.getRowCount())
		{
			tabela.SelectRow(next, next);
		}
	}
}
