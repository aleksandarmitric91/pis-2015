package controler;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import viewer.View;
/**
 * Klasa AboutHendler koristi se za realizaciju akcije klik na dugme About
 * @author G6
 */
public class AboutHandler implements ActionListener
{
	View view;
	
	/**
	 * Konstruktor klase AboutHandler
	 * @param view Objekat klase view 
	 */
	public AboutHandler(View view)
	{
		this.view = view;
	}
	
	/**
	 * Funkcija actionPerformed omogucava izvrsenje akcije.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Font font1 = new Font("Georgia Bold", Font.BOLD, 20);
		
		JPanel praznina = new JPanel();
		praznina.setPreferredSize(new Dimension(10, 10));
		
		JLabel naslov = new JLabel("DB Viewer Multiteka G6");
		naslov.setFont(font1);
		naslov.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel tekst = new JLabel("Projektovanje Informacionih Sistema - G6\n");
		tekst.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel aleksandra = new JLabel("Aleksandra Vujadinović - projekt menadžer");
		aleksandra.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel slobodan = new JLabel("Slobodan Kuzmanović - developer");		
		slobodan.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel aleksandar = new JLabel("Aleksandar Mitrić - developer");		
		aleksandar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel marko = new JLabel("Marko Lackanović - developer");		
		marko.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(naslov);
		
		panel.add(tekst);
		panel.add(praznina);
		panel.add(aleksandra);	
		panel.add(slobodan);
		panel.add(aleksandar);
		panel.add(marko);
		
		JOptionPane.showMessageDialog(null, panel, "Informacije", JOptionPane.PLAIN_MESSAGE);
	}
}
