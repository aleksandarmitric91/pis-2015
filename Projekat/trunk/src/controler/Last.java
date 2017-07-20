package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.DBTable;
import viewer.LinkedWindow;
import viewer.View;

/**
 * Ova klasa vrsi selekciju zadnjeg reda klikom na dugme Last.
 * @author Test
 *
 */
public class Last implements ActionListener
{
	
	View view;
	DBTable tabela;
	LinkedWindow linkedWindow;
	
	/**
	 * Konstruktor klase Last preko koga pozivamo akciju na klik.
	 * 
	 * @param view Objekat glavnog prozora preko koga pristupamo tabeli glavnog prozora.
	 * @param linkedWindow Objekat selekcionog prozora preko koga pristupamo tabeli selekcionog prozora.
	 */
	public Last(View view, LinkedWindow linkedWindow)
	{
		this.linkedWindow = linkedWindow;
		this.view = view;
	}

	/**
	 * Akcija koja izvrsava promjenu selektovanog reda na zadnji red.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(this.linkedWindow == null)
		{
			tabela = view.getTabela();
		}
		else
		{
			tabela = linkedWindow.getdBtabela();
		}
		int last = tabela.getRowCount();
		last--;
		tabela.SelectRow(last, last);
	}

}
