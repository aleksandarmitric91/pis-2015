package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.Menubar;
import viewer.Toolbar;
import viewer.View;

/**
 * Klasa Cancel klikom na dugme ponistava nastavak zeljene akcije
 * 
 * @author G6
 */
public class Cancel implements ActionListener 
{
	View view;
	Menubar menu;
	Toolbar toolbar;
	/**
	 * Kosntruktor klase Cancel za otkazivanje zeljene akcije.
	 * 
	 * @param view Objekat klase view za iscrtavanje osnovnog prozora.
	 */
	public Cancel(View view) 
	{
		this.view = view;
	}
	
	/**
	 * Akcija koja prekida nastavak zeljene akcije.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Accept.setFunkcija(null);
		
		menu = this.view.getMenu();
		menu.enableMenubarButtons();
		menu.disableAceptAndCancel();
		menu.enableSwitchXML();
		
		toolbar = this.view.getToolbar();
		toolbar.enableToolbarButtons();
		toolbar.disableAceptAndCancel();
		
	}
	
}
