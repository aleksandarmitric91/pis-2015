package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.Menubar;
import viewer.Toolbar;
import viewer.View;

/**
 * Klasa Update omogucava pozivanje procedure update klikom na dugme Update
 * 
 * @author G6
 */
public class Update implements ActionListener 
{
	View view;
	Menubar menu;
	Toolbar toolbar;

	/**
	 * Kosntruktor klase Update za kreiranje objekta date klase.
	 * 
	 * @param view Objekat klase view za pristup osnovnom prozoru.
	 */
	public Update(View view) 
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
						
		Accept.setFunkcija("Update");
	}
}
