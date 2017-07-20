package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.View;
/**
 * Ova klasa hvata klik na dugme i realizuje izlaz "Exit".
 * 
 * @author G6
 */
public class ExitHandler implements ActionListener
{
	private View view;
	
	/**
	 * Konstruktor klase ExitHandler za realizaciju izlaza iz programa.
	 * 
	 * @param view Objekat klase View koji se zatvara.
	 */
	public ExitHandler(View view)
	{
		this.view = view;
	}
	
	/**
	 * Akcija za zatvaranje prozora.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		this.view.getModel().disconnect();
		System.exit(0);
	}

}
