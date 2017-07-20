package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.InputFields;
import viewer.Menubar;
import viewer.Statusbar;
import viewer.Toolbar;
import viewer.Tree;
import viewer.View;

/**
 * Klasa Create omogucava pozivanje procedure Create klikom na dugme Insert
 * 
 * @author G6
 */
public class Create implements ActionListener 
{
	View view;
	Menubar menu;
	Toolbar toolbar;
	Tree tree;
	Statusbar statusbar;
	
	/**
	 * Kosntruktor klase Create za kreiranje objekta date klase.
	 * 
	 * @param view Objekat klase view za pristup osnovnom prozoru.
	 */
	public Create(View view) 
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
						
		Accept.setFunkcija("Create");
		
		tree = this.view.getDrvce();
		
		InputFields input = this.view.getInputFields();
		input.clearInputFields(tree.getKolone());
	}
}
