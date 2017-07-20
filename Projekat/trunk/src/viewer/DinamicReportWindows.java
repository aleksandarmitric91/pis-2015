package viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import dataType.Column;

/**
 * Klasa za kreiranje prozora za dinamicke izvjestaje.
 * 
 * @author G6
 */
public class DinamicReportWindows 
{
	View view;
	Tree tree;

	/**
	 * Objekat klase DinamicReportWindows za kreiranje prozora dinamickog izvjestaja.
	 * 
	 * @param view Objekat klase View za pristup elementima glavnog prozora.
	 */
	public DinamicReportWindows(View view) 
	{
		this.view = view;
		
		JFrame dinamicRW = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		dinamicRW.setLayout(new BorderLayout());
		dinamicRW.setSize(600,300);
		dinamicRW.setMinimumSize(new Dimension(400,400));
		dinamicRW.setLocation(screenSize.width/2-(screenSize.width*2/5)/2,screenSize.height/2-(screenSize.height*3/5)/2);
		dinamicRW.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons/dbicon.png"));
		dinamicRW.setTitle("Dinamicki Izvjestij");
		
		tree = this.view.getDrvce();
		Vector<Column> kolone = new Vector<>();
		kolone = tree.getKolone();
		Vector<String> imenaKolona = new Vector<>();
		
		JPanel listPane = new JPanel();
		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
		
		for (int i = 0; i < kolone.size(); i++)
		{
			imenaKolona.add(tree.getKolone().get(i).getIme());
			System.out.println(imenaKolona.get(i));
			JCheckBox check = new JCheckBox(imenaKolona.get(i), true);
			listPane.add(check);
		}
		
		JLabel labela = new JLabel("Izaberite u kom formatu zelite prikazati izvjestaj:");
		
		ButtonGroup BG = new ButtonGroup();
		JRadioButton xml = new JRadioButton("XML");
		JRadioButton pdf = new JRadioButton("PDF");
		BG.add(pdf);
		BG.add(xml);
		
		pdf.setSelected(true);
		
		JButton OK = new JButton("OK");
		OK.setSize(50,10);
		
		JPanel pomPanel = new JPanel(new BorderLayout());
		pomPanel.add(labela, BorderLayout.NORTH);
		pomPanel.add(pdf, BorderLayout.WEST);
		pomPanel.add(xml, BorderLayout.CENTER);
		pomPanel.add(OK, BorderLayout.SOUTH);
		
		dinamicRW.add(listPane);
		
		dinamicRW.add(pomPanel, BorderLayout.SOUTH);
		dinamicRW.setVisible(true);
	}
}
