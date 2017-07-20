package viewer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import controler.First;
import controler.Last;
import controler.Next;
import controler.Previous;

/**
 * Klasa ToolbarLW nasljedjuje JToolBar i na osnovu nje se kreira izgled toolbara u selekcionom dialogu
 * U ovoj klasi se ubacuju dugmad na toolbar na Linked Window
 * @author AleksandraV
 *
 */
public class ToolbarLW extends JToolBar
{
	private static final long serialVersionUID = 1L;
	
	View view;
	JButton first;
	JButton next;
	JButton previous;
	JButton last;
	
	First firstHandler;
	Next nextHandler;
	Previous previousHandler;
	Last lastHandler;
	LinkedWindow linkedWindow;
	
	/**
	 * Konstruktor klase ToolbarLW, se koristi da se pozovu parametri dugmica koji ce se koristiti u Linked Window-u 
	 * i da se kreira objekat ove klase
	 * @param linkedWindow prosljedjuje parametre prozora na koji treba postaviti toolbar
	 */
	public ToolbarLW(LinkedWindow linkedWindow)
	{
		this.linkedWindow = linkedWindow;
		
		firstHandler = new First(this.view, this.linkedWindow);
		nextHandler = new Next(this.view, this.linkedWindow);
		previousHandler = new Previous(this.view, this.linkedWindow);
		lastHandler  = new Last(this.view, this.linkedWindow);
		
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
		
		add(first);		
		add(previous);
		add(next);
		add(last);
	}
}
