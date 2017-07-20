package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import parse.ParseXML;
import viewer.Menubar;
import viewer.Statusbar;
import viewer.Toolbar;
import viewer.View;

/**
 *  Ova klasa vrsi otvaranje izabranog XML dokumenta i generisanje stabla.
 * @author G6
 *
 */
public class OpenXML implements ActionListener
{
	JFileChooser fileChooser;
	private View view;
	Menubar menu;
	ParseXML parser;
	Toolbar toolbar;
	
	/**
	 * Konstruktor klase OpenXML za otvaranje XML fajla.
	 * 
	 * @param view
	 */
	public OpenXML(View view)
	{
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{		
		String wd = System.getProperty("user.dir");
		JFileChooser fChooser = new JFileChooser(wd);
		FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
		fChooser.setFileFilter(xmlfilter);
		int opcija = fChooser.showDialog(new JFrame(), "Open XML file");
		if (opcija == JFileChooser.APPROVE_OPTION)
		{
			File file = fChooser.getSelectedFile();
			String filename = file.getAbsolutePath();
			parser=new ParseXML(filename, this.view.getModel());	
			this.view.getModel().setTabele(parser.getSveTabele());
			this.view.getModel().connect();
			view.getDrvce().createTree(view.getModel().getDatabase());
			Statusbar statusbar = this.view.getStatusbar();
			statusbar.setSelectedTable("Selected table: Table not selected");
			statusbar.setViewerState("State: Connected");
			
			menu = this.view.getMenu();
			menu.enableSwitchXML();
			menu.disableOpenXML();
			
			toolbar = this.view.getToolbar();

			if(fChooser.getSelectedFile().getName().equals("XMLMultiteka.xml"))			
			{
				toolbar.enableStaticReport();
				menu.enableStaticReport();
			}
		}
	}
/*
 * Ova funkcija vrsi parsiranje XML fajla
 * 
 */
	public ParseXML getParser() {
		return parser;
	}

	public void setParser(ParseXML parser) {
		this.parser = parser;
	}
}


