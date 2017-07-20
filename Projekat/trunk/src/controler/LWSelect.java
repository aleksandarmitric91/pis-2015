package controler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;

import viewer.LinkedWindow;
import dataType.Column;

/**
 * Ova klasa sluzi za dohvatanje podatka iz selekcionog prozora i popunjava InputFields novim podatcima.
 * @author G6
 *
 */
public class LWSelect implements ActionListener
{
	JFrame link;
	LinkedWindow linkWindow;
	String povratniPodatak = null;

	/**
	 * Konstruktor klase LWSelect 
	 * 
	 * @param linkWin Objekat klase LinkedWindow preko koga citamo potrebne podatke.
	 * @param link Objekat klase JPanel preko koga zatvaramo selekcioni dijagram.
	 */
	public LWSelect(LinkedWindow linkWin, JFrame link)
	{
		this.linkWindow = linkWin;
		this.link = link;
	}
	
	/**
	 * Akcija za zatvaranje selekcionog dijagrama.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		int brojKolone = 0;
		int indeksMjestaUpisa = 0;
		linkWindow.getLinkedFrame();
		Vector<Column> kolone = linkWindow.getOtvorenaTabela().getKolone();
		Vector<Object> rezultatCitanja = new Vector<>();
		rezultatCitanja.clear();
		rezultatCitanja = linkWindow.getPrethodnoStanjeInputa();
		for (int i = 0; i < kolone.size(); i++) 
		{
			if(kolone.get(i).getIme().equals(linkWindow.getTrazenaKolona().getIme()))
			{
				brojKolone = i;
			}
		}
		
		povratniPodatak = linkWindow.getdBtabela().getValueAt(linkWindow.getdBtabela().getSelectedRow(), brojKolone);
		for (int i = 0; i < linkWindow.getView().getInputFields().getHelpPanels().size(); i++) 
		{
			Component[] komponenteHelpPanela = linkWindow.getView().getInputFields().getHelpPanels().get(i).getComponents();//uzima elemente jednog panela,odnosno labelu, tekst field i check box ako ima
			Component komponentaHelpPanela = null;
			for (int j = 0; j < komponenteHelpPanela.length; j++) 
			{
				komponentaHelpPanela = komponenteHelpPanela[j];
				if(komponentaHelpPanela instanceof JLabel)
				{
					JLabel labela = (JLabel) komponentaHelpPanela;
					if (labela.getText().contains(linkWindow.getTrazenaKolona().getIme())) 
					{
						indeksMjestaUpisa = i;
					}
				}
			}
		}
		
		rezultatCitanja.set(indeksMjestaUpisa, povratniPodatak);
		linkWindow.getView().getInputFields().createInputFields(linkWindow.getView().getDrvce().getKolone(), rezultatCitanja);
		link.dispose();
		link = null;
	}
}
