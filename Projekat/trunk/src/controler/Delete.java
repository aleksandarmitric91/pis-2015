package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dataType.Table;
import model.ConnectionClass;
import viewer.Menubar;
import viewer.Toolbar;
import viewer.Tree;
import viewer.View;

/**
 * Ova klasa omogucava pozivanje kontrole Delete i reaguje na klik dugmeta .
 * @author G6
 *
 */
public class Delete implements ActionListener 
{
	View view;
	ConnectionClass konekcija;
	Table table;
	Tree tree;
	Menubar menu;
	Toolbar toolbar;
	Accept accept;
	
	/**
	 * Konstruktor klase Delete za kreiranje objekta date klase. S
	 * @param view Objekat klase view za iscrtavanje osnovnog prozora.
	 */
	public Delete(View view) 
	{
		this.view = view;
	}

	/**
	 * Akcija koja prilagodjava stanje editora.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		menu = this.view.getMenu();
		toolbar = this.view.getToolbar();
		menu.disableMenubarButtons();
		toolbar.disableToolbarButtons();
		
		menu.enableAceptAndCancel();
		menu.disableSwitchXML();
		toolbar.enableAceptAndCancel();
						
		Accept.setFunkcija("Delete");
	}
}
