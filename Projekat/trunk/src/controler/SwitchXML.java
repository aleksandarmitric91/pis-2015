package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import parse.ParseXML;
import viewer.DBTable;
import viewer.InputFields;
import viewer.Menubar;
import viewer.Statusbar;
import viewer.Toolbar;
import viewer.View;

/**
 * Ova klasa sluzi zamjenu XML fajla i parsiranje tog novog fajla.
 * 
 * @author G6
 */
public class SwitchXML implements ActionListener
{
	View view;
	DBTable table;
	InputFields inputFields;
	Menubar menu;
	Toolbar toolbar;
	
	/**
	 * Konstruktor klase switchXML kojim se kreira objekat za promjenu XML fajla.
	 * 
	 * @param view Objekat klase View za pristupanje glavnom prozoru.
	 */
	public SwitchXML(View view) 
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
			this.view.getModel().disconnect();
			File file = fChooser.getSelectedFile();
			String filename = file.getAbsolutePath();
			ParseXML parser = new ParseXML(filename, this.view.getModel());
			view.getDrvce().createTree(view.getModel().getDatabase());
			this.view.getModel().connect();
			Statusbar statusbar = this.view.getStatusbar();
			statusbar.setSelectedTable("Selected table: Table not selected");
			statusbar.setViewerState("State: Connected");
			
			table = this.view.getTabela();
			table.setTableModel(new DefaultTableModel());
			
			inputFields = this.view.getInputFields();
			inputFields.createInputFields(null , null);
			
			menu = this.view.getMenu();
			toolbar = this.view.getToolbar();
			
			menu.disableMenubarButtons();
			toolbar.disableToolbarButtons();
			
			menu.disableStaticReport();
			toolbar.disableStaticReport();
			
			if(fChooser.getSelectedFile().getName().equals("XMLMultiteka.xml"))			
			{
				toolbar.enableStaticReport();
				menu.enableStaticReport();
			}
		}
	}
}
