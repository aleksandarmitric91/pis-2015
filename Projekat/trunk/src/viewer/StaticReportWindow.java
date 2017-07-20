package viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controler.ReportOKHandler;
/**
 * Klasa StaticReportWindow koristi se za kreiranje pomocnog prozora StaticReportWindow, koji se pojavljuje nakon klika izabrano dugme
 * @author AleksandraV
 *
 */
public class StaticReportWindow 
{
	ReportOKHandler OKHandler;
	View view;
	static JRadioButton artikli;
	static JRadioButton clanovi;
	static JRadioButton cjenovnik;
	static JRadioButton zaposleni;
	
/**
 * Konstruktor klase StaticReportWindow se koristi za podesavanje komponenti
 *  koje se nalaze na StaticReportWindow-u i kreiranje objekta ove klase.
 * @param view polozaj glavnog prozora
 */
	public StaticReportWindow(View view) 
	{
		this.view = view;
		OKHandler = new ReportOKHandler(this.view);
		
		JFrame staticRW = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		staticRW.setLayout(new BorderLayout());
		staticRW.setSize(200,125);
		staticRW.setResizable(false);
		staticRW.setLocation(screenSize.width/2-(screenSize.width*1/5)/2,screenSize.height/2-(screenSize.height*2/5)/2);
		staticRW.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons/dbicon.png"));
		staticRW.setTitle("Staticki Izvjestij");
	
		
		JLabel labela = new JLabel("Izaberite izvjestaj:");
		
		ButtonGroup BG = new ButtonGroup();
		artikli = new JRadioButton("Artikli");
		clanovi = new JRadioButton("Clanovi");
		cjenovnik = new JRadioButton("Cjenovnik");
		zaposleni = new JRadioButton("Zaposleni");
		BG.add(artikli);
		BG.add(clanovi);
		BG.add(cjenovnik);
		BG.add(zaposleni);
		
		clanovi.setSelected(true);
		
		JButton OK = new JButton("OK");
		OK.setSize(50,10);
		OK.addActionListener(OKHandler);
		JPanel panel = new JPanel(new BorderLayout());
		JPanel pomPanel = new JPanel(new BorderLayout());
		JPanel pomPanel1 = new JPanel (new BorderLayout());
		JPanel pomPanel2= new JPanel(new BorderLayout());
		
		pomPanel.add(artikli, BorderLayout.WEST);
		pomPanel.add(cjenovnik, BorderLayout.CENTER);
		pomPanel1.add(clanovi, BorderLayout.WEST);
		pomPanel1.add(zaposleni, BorderLayout.CENTER);
		pomPanel2.add(pomPanel, BorderLayout.SOUTH);
		pomPanel2.add(pomPanel1, BorderLayout.NORTH);
		
		panel.add(labela,BorderLayout.NORTH);
		panel.add(pomPanel2, BorderLayout.CENTER);
		panel.add(OK, BorderLayout.SOUTH);
		
		staticRW.add(panel);
		staticRW.setVisible(true);
	}
	
	public static String getSelectedButton()
	{
		if(artikli.isSelected())
		{
			return "artikli";
		}
		else if(cjenovnik.isSelected())
		{
			return "cjenovnik";
		}
		else if(clanovi.isSelected())
		{
			return "clanovi";
		}
		else if(zaposleni.isSelected())
		{
			return "zaposleni";
		}
		else
		{
			return null;
		}
	}
	
}
