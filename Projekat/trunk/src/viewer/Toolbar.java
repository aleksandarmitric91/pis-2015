package viewer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import controler.*;

/**
 * Klasa Toolbar nasljedjuje JToolBar. Ona se koristi za postavljanje button-a na postavljeni panel toolbar-a
 * 
 * @author G6
 */
public class Toolbar extends JToolBar
{
	View view;
	JButton first;
	JButton next;
	JButton previous;
	JButton last;
	JButton insert;
	JButton update;
	JButton delete;
	JButton accept;
	JButton cancel;
	JButton tableReport;
	JButton advancedReport;
	JButton about;
	
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
	ReportHandler staticReportHsndler;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Konstruktor klase Toolbar,prikazuje sve ikonice na toolbar-i
	 *  prati akcije koje se desavaju na button-ima i poziva dogadjaje za njih
	 * @param view Objekat klase View na koji se postavlja Toolbar objekat
	 */
	public Toolbar(View view)
	{
		this.view = view;
		
		firstHandler = new First(this.view, null);
		nextHandler = new Next(this.view, null);
		previousHandler = new Previous(this.view, null);
		lastHandler  = new Last(this.view, null);
		createHandler = new Create(this.view);
		updateHandler = new Update(this.view);
		deleteHandler = new Delete(this.view);
		acceptHandler = new Accept(this.view);
		cancelHandler = new Cancel(this.view);
		dinamicRH = new DinamicReportHandler(this.view);
		aboutHandler = new AboutHandler(this.view);
		staticReportHsndler = new ReportHandler(this.view);
		
		setFloatable(true);
		setRollover(true);
		setName("Toolbar");
		
		first = new JButton(new ImageIcon("icons/first.png"));
		first.setToolTipText("Prvi element");
		first.setFocusable(false);
		first.addActionListener(firstHandler);
		
		next = new JButton(new ImageIcon("icons/next.png"));
		next.setToolTipText("Sledeci element");
		next.setFocusable(false);
		next.addActionListener(nextHandler);
		
		previous = new JButton(new ImageIcon("icons/previous.png"));
		previous.setToolTipText("Prethodni element");
		previous.setFocusable(false);
		previous.addActionListener(previousHandler);
		
		last = new JButton(new ImageIcon("icons/last.png"));
		last.setToolTipText("Zadnji element");
		last.setFocusable(false);
		last.addActionListener(lastHandler);
		
		insert = new JButton(new ImageIcon("icons/insert.png"));
		insert.setToolTipText("Ubaci podatke");
		insert.setFocusable(false);
		insert.addActionListener(createHandler);
		
		update = new JButton(new ImageIcon("icons/update.png"));
		update.setToolTipText("Izmjeni podatke");
		update.setFocusable(false);
		update.addActionListener(updateHandler);
		
		delete = new JButton(new ImageIcon("icons/delete.png"));
		delete.setToolTipText("Obrisi podatke");
		delete.setFocusable(false);
		delete.addActionListener(deleteHandler);
		
		accept = new JButton(new ImageIcon("icons/accept.png"));
		accept.setToolTipText("Potvrdi izmjenu");
		accept.setFocusable(false);
		accept.addActionListener(acceptHandler);
		
		cancel = new JButton(new ImageIcon("icons/cancel.png"));
		cancel.setToolTipText("Otkazi izmjenu");
		cancel.setFocusable(false);
		cancel.addActionListener(cancelHandler);
		
		tableReport = new JButton(new ImageIcon("icons/report.png"));
		tableReport.setToolTipText("Generisi izvjestaj");
		tableReport.setFocusable(false);
		tableReport.addActionListener(staticReportHsndler);
		
		advancedReport = new JButton(new ImageIcon("icons/advanced_report.png"));
		advancedReport.setToolTipText("Generisi napredni izvjestaj");
		advancedReport.setFocusable(false);
		advancedReport.addActionListener(dinamicRH);
		
		about = new JButton(new ImageIcon("icons/about.png"));
		about.setToolTipText("Informacije");
		about.setFocusable(false);
		about.addActionListener(aboutHandler);
		
		add(first);		
		add(previous);
		add(next);
		add(last);
		addSeparator();
		add(insert);
		add(update);
		add(delete);
		addSeparator();
		add(accept);
		add(cancel);
		addSeparator();
		add(tableReport);
		add(advancedReport);
		addSeparator();
		add(about);
	}
	
	/**
	 *Funkcija disableToolbarButtons onemogucava button-e na toolbaru sve dok se ne ucita odgovarajuci xml fajl
	 */
	public void disableToolbarButtons()
	{
		first.setEnabled(false);
		next.setEnabled(false);
		previous.setEnabled(false);
		last.setEnabled(false);
		insert.setEnabled(false);
		update.setEnabled(false);
		delete.setEnabled(false);
		advancedReport.setEnabled(false);
	}
	
	/**
	 * Funkcija enableToolbarButtons omogucava rad sa button-ima kad je to dozvoljeno, tj kad je ucitan XML fajl
	 */
	public void enableToolbarButtons()
	{
		first.setEnabled(true);
		next.setEnabled(true);
		previous.setEnabled(true);
		last.setEnabled(true);
		insert.setEnabled(true);
		update.setEnabled(true);
		delete.setEnabled(true);
		advancedReport.setEnabled(true);
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
		tableReport.setEnabled(false);
	}
	
	public void enableStaticReport()
	{
		tableReport.setEnabled(true);
	}
}