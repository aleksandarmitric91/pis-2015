package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controler.*;

import javax.swing.KeyStroke;

/**
 * Klasa  Manubar se koristi za prikaz i podesavanje menu bar-a, za kreiranje svih polja u njemu.
 * U zavisnosti od XML fajla menu je dostupan ili ne
 * @author AleksandraV
 *
 */
public class Menubar extends JMenuBar
{
	private static final long serialVersionUID = 1L;
	
	View view;
	JMenuItem openXML;
	JMenuItem switchXML;
	JMenuItem exit;
	JMenuItem first;
	JMenuItem next;
	JMenuItem previous;
	JMenuItem last;
	JMenuItem insert;
	JMenuItem update;
	JMenuItem delete;
	JMenuItem accept;
	JMenuItem cancel;
	//JMenuItem tableReport;
	JMenuItem advancedReport;
	JMenuItem cjenovnik;
	JMenuItem clanovi;
	JMenuItem artikli;
	JMenuItem zaposleni;
	JMenuItem about;
	
	OpenXML openXMLHandler;
	SwitchXML switchXMLHandler;
	ExitHandler exitHandler;
	First firstHandler;
	Next nextHandler;
	Previous previousHandler;
	Last lastHandler;
	Create createHandler;
	Update updateHandler;
	Delete deleteHandler;
	Accept acceptHandler;
	Cancel cancelHandler; 
	DinamicReportHandler dinamicRH;
	AboutHandler aboutHandler;
	
	/**
	 * Konstruktor Menubar se koristi za kreiranje menubara-a
	 * @param view Objekat klase View na kojem ce se prikazati menubar
	 */
	public Menubar(View view)
	{
		this.view = view;

		openXMLHandler = new OpenXML(this.view);
		switchXMLHandler = new SwitchXML(this.view);
		exitHandler = new ExitHandler(this.view);
		firstHandler = new First(this.view, null);
		nextHandler = new Next(this.view, null);
		previousHandler = new Previous(this.view, null);
		lastHandler = new Last(this.view, null);
		createHandler = new Create(this.view);
		updateHandler = new Update(this.view);
		deleteHandler = new Delete(this.view);
		acceptHandler = new Accept(this.view);
		cancelHandler = new Cancel(this.view); 
		aboutHandler = new AboutHandler(this.view);
		dinamicRH =new DinamicReportHandler(this.view);
		
		
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu report = new JMenu("Report");
		JMenu stat = new JMenu("StaticReport");
		JMenu help = new JMenu("Help");
		
		file.setMnemonic('f');
		edit.setMnemonic('e');
		report.setMnemonic('r');
		help.setMnemonic('h');
		
		openXML = new JMenuItem("Open XML");
		openXML.setMnemonic(KeyEvent.VK_O);
		openXML.setIcon(new ImageIcon("icons/openXML.png"));
		openXML.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		openXML.setToolTipText("Izbor XML fajla");
		openXML.addActionListener(openXMLHandler);

		switchXML = new JMenuItem("Switch XML");
		switchXML.setMnemonic(KeyEvent.VK_S);
		switchXML.setIcon(new ImageIcon("icons/switchXML.png"));
		switchXML.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		switchXML.setToolTipText("Promjena trenutnog XML fajla");
		switchXML.addActionListener(switchXMLHandler);

		exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E);
		exit.setIcon(new ImageIcon("icons/exit.png"));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		exit.setToolTipText("Zatvaranje aplikacije");
		exit.addActionListener(exitHandler);
		
		first = new JMenuItem("First");
		first.setMnemonic(KeyEvent.VK_F);
		first.setIcon(new ImageIcon("icons/first.png"));
		first.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
		first.setToolTipText("Prvi element");
		first.addActionListener(firstHandler);
		
		next = new JMenuItem("Next");
		next.setMnemonic(KeyEvent.VK_N);
		next.setIcon(new ImageIcon("icons/next.png"));
		next.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		next.setToolTipText("Sledeci element");
		next.addActionListener(nextHandler);
		
		previous = new JMenuItem("Previous");
		previous.setMnemonic(KeyEvent.VK_P);
		previous.setIcon(new ImageIcon("icons/previous.png"));
		previous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
		previous.setToolTipText("Prethodni element");
		previous.addActionListener(previousHandler);
		
		last = new JMenuItem("Last");
		last.setMnemonic(KeyEvent.VK_L);
		last.setIcon(new ImageIcon("icons/last.png"));
		last.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
		last.setToolTipText("Zadnji element");
		last.addActionListener(lastHandler);
		
		insert = new JMenuItem("Insert");
		insert.setMnemonic(KeyEvent.VK_I);
		insert.setIcon(new ImageIcon("icons/insert.png"));
		insert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
		insert.setToolTipText("Ubaci podatke");
		insert.addActionListener(createHandler);
		
		update = new JMenuItem("Update");
		update.setMnemonic(KeyEvent.VK_U);
		update.setIcon(new ImageIcon("icons/update.png"));
		update.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.ALT_MASK));
		update.setToolTipText("Izmjeni podatke");
		update.addActionListener(updateHandler);
		
		delete = new JMenuItem("Delete");
		delete.setMnemonic(KeyEvent.VK_D);
		delete.setIcon(new ImageIcon("icons/delete.png"));
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		delete.setToolTipText("Obrisi podatke");
		delete.addActionListener(deleteHandler);
		
		accept = new JMenuItem("Accept");
		accept.setMnemonic(KeyEvent.VK_A);
		accept.setIcon(new ImageIcon("icons/accept.png"));
		accept.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		accept.setToolTipText("Potvrdi izmjenu");
		accept.addActionListener(acceptHandler);
		
		cancel = new JMenuItem("Cancel");
		cancel.setMnemonic(KeyEvent.VK_C);
		cancel.setIcon(new ImageIcon("icons/cancel.png"));
		cancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		cancel.setToolTipText("Otkazi izmjenu");
		cancel.addActionListener(cancelHandler);
		
		stat.setMnemonic(KeyEvent.VK_S);
		stat.setIcon(new ImageIcon("icons/report.png"));
		stat.setToolTipText("Staticki Izvjestaji");
		
		cjenovnik= new JMenuItem("Cjenovnik");
		cjenovnik.setMnemonic(KeyEvent.VK_C);
		cjenovnik.setToolTipText("Cjenovnik");
		cjenovnik.addActionListener(new StaticReportHandler(view, "cjenovnik"));
		
		clanovi= new JMenuItem("Clanovi");
		clanovi.setMnemonic(KeyEvent.VK_L);
		clanovi.setToolTipText("Clanovi");
		clanovi.addActionListener(new StaticReportHandler(view,"clanovi"));
		
		artikli= new JMenuItem("Artikli");
		artikli.setMnemonic(KeyEvent.VK_A);
		artikli.setToolTipText("Artikli");
		artikli.addActionListener(new StaticReportHandler(view,"artikli"));
		
		zaposleni= new JMenuItem("Zaposleni");
		zaposleni.setMnemonic(KeyEvent.VK_Z);
		zaposleni.setToolTipText("Zaposleni");
		zaposleni.addActionListener(new StaticReportHandler(view,"zaposleni"));
		
		advancedReport = new JMenuItem("DinamicReport");
		advancedReport.setMnemonic(KeyEvent.VK_R);
		advancedReport.setIcon(new ImageIcon("icons/advanced_report.png"));
		advancedReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		advancedReport.setToolTipText("Dinamicki Izvjestaj");
		advancedReport.addActionListener(dinamicRH);
		
		about = new JMenuItem("About");
		about.setMnemonic(KeyEvent.VK_H);
		about.setIcon(new ImageIcon("icons/about.png"));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
		about.setToolTipText("Informacije");
		about.addActionListener(aboutHandler);
		
		file.add(openXML);
		file.add(switchXML);
		file.addSeparator();
		file.add(exit);
		edit.add(first);
		edit.add(next);
		edit.add(previous);
		edit.add(last);
		edit.addSeparator();
		edit.add(insert);
		edit.add(update);
		edit.add(delete);
		edit.addSeparator();
		edit.add(accept);
		edit.add(cancel);
		report.add(stat);
		stat.add(cjenovnik);
		stat.add(clanovi);
		stat.add(artikli);
		stat.add(zaposleni);
		//report.add(tableReport);
		report.add(advancedReport);
		help.add(about);
		
		add(file);
		add(edit);
		add(report);
		add(help);
	}
	
	public void disableMenubarButtons()
	{
		first.setEnabled(false);
		next.setEnabled(false);
		previous.setEnabled(false);
		last.setEnabled(false);
		insert.setEnabled(false);
		update.setEnabled(false);
		delete.setEnabled(false);
		//tableReport.setEnabled(false);
		advancedReport.setEnabled(false);
	}
	
	public void enableMenubarButtons()
	{
		first.setEnabled(true);
		next.setEnabled(true);
		previous.setEnabled(true);
		last.setEnabled(true);
		insert.setEnabled(true);
		update.setEnabled(true);
		delete.setEnabled(true);
		//tableReport.setEnabled(true);
		advancedReport.setEnabled(true);
		
		
	}
	public void disableSwitchXML()
	{
		switchXML.setEnabled(false);
	}
	public void enableSwitchXML()
	{
		switchXML.setEnabled(true);
	}
	public void disableOpenXML()
	{
		openXML.setEnabled(false);
	}
	public void disableAceptAndCancel()
	{
		accept.setEnabled(false);
		cancel.setEnabled(false);
	}
	public void enableAceptAndCancel()
	{
		accept.setEnabled(true);
		cancel.setEnabled(true);
	}
	public void disableStaticReport()
	{
		cjenovnik.setEnabled(false);
		artikli.setEnabled(false);
		zaposleni.setEnabled(false);
		clanovi.setEnabled(false);
	}
	public void enableStaticReport()
	{
		cjenovnik.setEnabled(true);
		artikli.setEnabled(true);
		zaposleni.setEnabled(true);
		clanovi.setEnabled(true);
	}
	
}