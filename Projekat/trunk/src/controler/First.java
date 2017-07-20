package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import viewer.DBTable;
import viewer.LinkedWindow;
import viewer.View;

/**
 * Ova klasa vrsi selekciju prvog reda klikom na dugme First.
 * 
 * @author G6
 */
public class First implements ActionListener
{
	View view;
	DBTable tabela;
	LinkedWindow linkedWindow;
	
	/**
	 * konstruktor klase First preko koga pozivamo akciju na klik.
	 * 
	 * @param view Objekat glavnog prozora preko koga pristupamo tabeli glavnog prozora.
	 * @param linkedWindow Objekat selekcionog prozora preko koga pristupamo tabeli selekcionog prozora.
	 */
	public First(View view, LinkedWindow linkedWindow)
	{
		this.linkedWindow = linkedWindow;
		this.view = view;
	}
	
	/**
	 * Akcija koja izvrsava promjenu selektovanog reda na prvi red.
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
		tabela.SelectRow(0, 0);
	}
}
