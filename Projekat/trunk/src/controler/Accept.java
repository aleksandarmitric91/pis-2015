package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ConnectionClass;
import viewer.Menubar;
import viewer.Toolbar;
import viewer.Tree;
import viewer.View;

/**
 * Klasa Accept omogucuje potvrdu zeljene akcije.
 * @author G6
 */
public class Accept implements ActionListener 
{
	View view;
	Menubar menu;
	Toolbar toolbar;
	Tree tree;
	
	static String funkcija;
	
	/**
	 * Kosntruktor klase Accept za prihvatanje zeljene akcije.
	 * 
	 * @param view Objekat klase view za iscrtavanje osnovnog prozora.
	 */
	public Accept(View view) 
	{
		this.view = view;
	}

	/**
	 * Akcija koja prekida nastavak izabrane akcije.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if (funkcija == "Delete")
		{
			tree = this.view.getDrvce();
			ConnectionClass.delete(tree.getTabela(), view);
		}
		if (funkcija == "Update")
		{
			tree = this.view.getDrvce();
			ConnectionClass.update(tree.getTabela(), view);
		}
		if (funkcija == "Create")
		{
			tree = this.view.getDrvce();			
			ConnectionClass.insert(tree.getTabela(), view);
		}
		menu = this.view.getMenu();
		menu.enableMenubarButtons();
		menu.disableAceptAndCancel();
		menu.enableSwitchXML();
		
		toolbar = this.view.getToolbar();
		toolbar.enableToolbarButtons();
		toolbar.disableAceptAndCancel();
	}

	public String getFunkcija()
	{
		return funkcija;
	}

	public static void setFunkcija(String funk)
	{
		funkcija = funk;
	}
}
