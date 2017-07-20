package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Zatvara vec otvoreni selekcioni prozor.
 */
public class LWCancel implements ActionListener
{
	JFrame link;
	
	/**
	 * Konstruktor klase LWCancel za otkazivanje izbora podatka iz selekcionog dijaloga.
	 * 
	 * @param link JFrame koji se zatvara.
	 */
	public LWCancel(JFrame link)
	{
		this.link = link;
	}
	
	/**
	 * Akcija za zatvaranje selekcionog dijagrama.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		link.dispose();
		link = null;
	}

}
