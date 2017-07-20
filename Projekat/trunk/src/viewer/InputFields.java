package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

import org.freixas.jcalendar.JCalendarCombo;

import controler.LinkedWindowHandler;
import dataType.Column;
import dataType.Table;
import net.miginfocom.swing.MigLayout;
/**
 * Klasa zaduzena za kreiranje Input Filds-a
 * @author G6
 *
 */
public class InputFields extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane = null;
	private JPanel basicPanel;
	ArrayList<JPanel> helpPanels =new ArrayList<>();
	private View view;
	int sirina, brojHorizonPolja;
	String infoField = null;
	LinkedWindowHandler btnHandler;
	Table refTable;
	Column refColumn;
	JPanel helpPanel;
	Vector<Column> column;

	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		this.sirina = sirina;
	}

	/**
	 * Konstruktor klase InputFields
	 * @param view Objekat klase View za isrtavanje glavnog prozora
	 */
	public InputFields(View view)
	{	
		this.view = view;
		basicPanel = new JPanel(new MigLayout());
		basicPanel.setBackground(new Color(0, 10, 150, 0));
		setLayout(new BorderLayout());	
		scrollPane = new JScrollPane(basicPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	/**
	 * Metoda za kreiranje InputFields/a
	 * @param kolone Vektor kolona potrebnih za kreiranje InputField/a
	 * @param noveVrednosti Vektor objekata novih vrednosti za Input Field/s
	 */
	public void createInputFields(Vector<Column> kolone, Vector<Object> noveVrednosti)
	{
		basicPanel.removeAll();
		helpPanels.clear();
		
		int selektovaniRed = this.view.getTabela().getSelectedRow();
		this.brojHorizonPolja = this.getWidth() / 250;
		
		if(kolone != null )
		{
			for (int i = 0; i < kolone.size(); i++) 
			{
				if(noveVrednosti == null)
				{
					infoField = this.view.getTabela().getValueAt(selektovaniRed, i);
				}
				else
				{
					infoField = noveVrednosti.get(i).toString();
				}
				helpPanel = new JPanel(new BorderLayout());
				helpPanel.setBackground(new Color(0, 10, 150, 0));
				helpPanel.setMinimumSize(new Dimension(250, 40));
				helpPanel.setPreferredSize(new Dimension(250, 40));
				
				if (kolone.get(i).isNullable() == false || kolone.get(i).isPrimarniKljuc() == true)
				{
					helpPanel.add(new JLabel(kolone.get(i).getIme()+"*: "), BorderLayout.NORTH);
				}
				else
				{
					helpPanel.add(new JLabel(kolone.get(i).getIme()+": "), BorderLayout.NORTH);
				}
				
				if(kolone.get(i).getTipPodatka().toString().contains("int"))//ok
				{
					NumberFormat.getIntegerInstance().setGroupingUsed(false);
					JFormattedTextField intField = new JFormattedTextField();
					intField.setMinimumSize(new Dimension(130,20));
					intField.setPreferredSize(new Dimension(130,20));
					intField.setFont(new Font("Arial",Font.PLAIN,10));
					intField.setText(infoField);
					helpPanel.add(intField, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("varchar"))//ok
				{
					JFormattedTextField varcharField;
					String format = "";
					for (int j = 0; j < kolone.get(i).getVelicina(); j++) 
					{
						format+="*";
					}
					try 
					{
						MaskFormatter mask = new MaskFormatter(format);
						varcharField = new JFormattedTextField(mask);
					} 
					catch (ParseException e) 
					{
						varcharField = new JFormattedTextField();
						e.printStackTrace();
					}
					
					varcharField.setMinimumSize(new Dimension(130,20));
					varcharField.setPreferredSize(new Dimension(130,20));
					varcharField.setFont(new Font("Arial",Font.PLAIN,10));
					varcharField.setText(infoField);
					helpPanel.add(varcharField, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("date"))//ok
				{
					JCalendarCombo calendar = new JCalendarCombo();
					calendar.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
					Date date = null;
					
					if (infoField != null) 
					{
						try 
						{
							date = new SimpleDateFormat("yyyy-MM-dd").parse(infoField);
							calendar.setDate(date);
						} 
						catch (ParseException e) {}
					}
					else
					{
						calendar.setDate(date);
					}
					
					calendar.setMinimumSize(new Dimension(130,20));
					calendar.setPreferredSize(new Dimension(130, 20));
					calendar.setFont(new Font("Arial",Font.PLAIN,10));
					helpPanel.add(calendar, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("char"))//ok
				{
					JFormattedTextField charField;
					String format = "";
					for (int j = 0; j < kolone.get(i).getVelicina(); j++) 
					{
						format+="*";
					}
					try 
					{
						MaskFormatter mask = new MaskFormatter(format);
						charField = new JFormattedTextField(mask);
					} 
					catch (ParseException e) 
					{
						charField = new JFormattedTextField();
					}
					
					charField.setMinimumSize(new Dimension(130,20));
					charField.setPreferredSize(new Dimension(130,20));
					charField.setFont(new Font("Arial",Font.PLAIN,10));
					charField.setText(infoField);
					helpPanel.add(charField, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("numeric"))//ok
				{
					JFormattedTextField numberField = new JFormattedTextField(NumberFormat.getNumberInstance());
					numberField.setMinimumSize(new Dimension(130,20));
					numberField.setPreferredSize(new Dimension(130,20));
					numberField.setFont(new Font("Arial",Font.PLAIN,10));
					numberField.setText(infoField);
					helpPanel.add(numberField, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("bit"))//ok
				{
					JCheckBox chBox = new JCheckBox();
					if(infoField=="1" || infoField=="true")
					{
						chBox.setSelected(true);
					}
					else
					{
						chBox.setSelected(false);
					}
					chBox.setBackground(new Color(0, 10, 150, 0));
					helpPanel.add(chBox, BorderLayout.WEST);
					JLabel lab=new JLabel();
					lab.setText("Da");
					lab.setBackground(new Color(0, 10, 150, 0));
					helpPanel.add(lab, BorderLayout.CENTER);
				}
				helpPanels.add(helpPanel);
				
				if(i % brojHorizonPolja == (brojHorizonPolja-1))
				{
					basicPanel.add(helpPanel,"wrap");
				}
				else
				{
					basicPanel.add(helpPanel);
				}
			}
		}
		this.view.verticalSplitPane.setDividerLocation(this.view.frame.getHeight() - this.view.inputFieldsHeight - 125);	
	}

	/**
	 * Metoda za ciscenje Input Fields/a
	 * @param kolone Kolone koje trebaju biti ociscene
	 */
	public void clearInputFields(Vector<Column> kolone)
	{
		this.column = kolone;
		
		basicPanel.removeAll();
		helpPanels.clear();
		int selektovaniRed = this.view.getTabela().getSelectedRow();
		this.brojHorizonPolja = this.getWidth() / 250;
		
		if(kolone != null )
		{
			for (int i = 0; i < kolone.size(); i++) 
			{
				infoField = this.view.getTabela().getValueAt(selektovaniRed, i);
				helpPanel = new JPanel(new BorderLayout());
				helpPanel.setBackground(new Color(0, 10, 150, 0));
				helpPanel.setMinimumSize(new Dimension(250, 40));
				helpPanel.setPreferredSize(new Dimension(250, 40));

				if (kolone.get(i).isNullable() == false || kolone.get(i).isPrimarniKljuc() == true)
				{
					helpPanel.add(new JLabel(kolone.get(i).getIme()+"*: "), BorderLayout.NORTH);
				}
				else
				{
					helpPanel.add(new JLabel(kolone.get(i).getIme()+": "), BorderLayout.NORTH);
				}
				
				if(kolone.get(i).getTipPodatka().toString().contains("int"))//ok
				{
					JFormattedTextField intField = new JFormattedTextField(NumberFormat.getIntegerInstance());
					intField.setMinimumSize(new Dimension(130,20));
					intField.setPreferredSize(new Dimension(130,20));
					intField.setFont(new Font("Arial",Font.PLAIN,10));
					helpPanel.add(intField, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("varchar"))//ok
				{
					JFormattedTextField varcharField;
					String format = "";
					for (int j = 0; j < kolone.get(i).getVelicina(); j++) 
					{
						format+="*";
					}
					try 
					{
						MaskFormatter mask = new MaskFormatter(format);
						varcharField = new JFormattedTextField(mask);
					} 
					catch (ParseException e) 
					{
						varcharField = new JFormattedTextField();
						e.printStackTrace();
					}
					
					varcharField.setMinimumSize(new Dimension(130,20));
					varcharField.setPreferredSize(new Dimension(130,20));
					varcharField.setFont(new Font("Arial",Font.PLAIN,10));
					helpPanel.add(varcharField, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("date"))//ok
				{
					JCalendarCombo calendar = new JCalendarCombo();
					calendar.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
					calendar.setMinimumSize(new Dimension(130,20));
					calendar.setPreferredSize(new Dimension(130, 20));
					calendar.setFont(new Font("Arial",Font.PLAIN,10));
					helpPanel.add(calendar, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("char"))//ok
				{
					JFormattedTextField charField;
					String format = "";
					for (int j = 0; j < kolone.get(i).getVelicina(); j++) 
					{
						format+="*";
					}
					try 
					{
						MaskFormatter mask = new MaskFormatter(format);
						charField = new JFormattedTextField(mask);
					} 
					catch (ParseException e) 
					{
						charField = new JFormattedTextField();
					}
					
					charField.setMinimumSize(new Dimension(130,20));
					charField.setPreferredSize(new Dimension(130,20));
					charField.setFont(new Font("Arial",Font.PLAIN,10));
					helpPanel.add(charField, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("numeric"))//ok
				{
					JFormattedTextField numberField = new JFormattedTextField(NumberFormat.getNumberInstance());
					numberField.setMinimumSize(new Dimension(130,20));
					numberField.setPreferredSize(new Dimension(130,20));
					numberField.setFont(new Font("Arial",Font.PLAIN,10));
					helpPanel.add(numberField, BorderLayout.CENTER);
					if (kolone.get(i).getRefKolona() != null) 
					{
						JButton btn = new JButton("...");
						btn.setBounds(10,0,10,0);
						btnHandler = new LinkedWindowHandler(this.view, kolone.get(i));
						btn.addActionListener(btnHandler);
						helpPanel.add(btn, BorderLayout.EAST);
					}
				}
				else if(kolone.get(i).getTipPodatka().toString().contains("bit"))//ok
				{
					JCheckBox chBox = new JCheckBox();
					chBox.setSelected(false);
					chBox.setBackground(new Color(0, 10, 150, 0));
					helpPanel.add(chBox, BorderLayout.WEST);
					JLabel lab=new JLabel();
					lab.setText("Da");
					lab.setBackground(new Color(0, 10, 150, 0));
					helpPanel.add(lab, BorderLayout.CENTER);
				}
				helpPanels.add(helpPanel);
				
				if(i % brojHorizonPolja == (brojHorizonPolja-1))
				{
					basicPanel.add(helpPanel,"wrap");
				}
				else
				{
					basicPanel.add(helpPanel);
				}
			}
		}
		this.view.verticalSplitPane.setDividerLocation(this.view.frame.getHeight() - this.view.inputFieldsHeight - 125);
	}
	
	/**
	 * Metoda koja dobavlja podatke iz input field/s
	 * @param view Objekat klase View za iscrtavanje glavnog prozora
	 * @param kolone Kolone
	 * @return Vraca popunjen vektor objekata sa podacima iz intpufilda
	 */
	public Vector<Object> getInputFieldData(View view, Vector<Column> kolone)
	{
		Vector<Object> rezultatCitanja = new Vector<>();
		rezultatCitanja.clear();
		
		for (int i = 0; i < helpPanels.size(); i++) 
		{
			Component[] komponenteHelpPanela = helpPanels.get(i).getComponents();//uzima elemente jednog panela,odnosno labelu, tekst field i check box ako ima
			Component komponentaHelpPanela = null;
			for (int j = 0; j < komponenteHelpPanela.length; j++) 
			{
				komponentaHelpPanela = komponenteHelpPanela[j];
				if(komponentaHelpPanela instanceof JCheckBox)
				{
					JCheckBox cb = (JCheckBox) komponentaHelpPanela;
					String cekirano = null;
					if(cb.isSelected()==true)
					{
						cekirano = "True";
					}
					else
					{
						cekirano = "False";
					}
					rezultatCitanja.add(cekirano);
				}
				else if (komponentaHelpPanela instanceof JFormattedTextField)
				{
					JFormattedTextField textBox = (JFormattedTextField) komponentaHelpPanela;
					rezultatCitanja.add(textBox.getText());
				}
				else if (komponentaHelpPanela instanceof JCalendarCombo)
				{
					JCalendarCombo dateBox = (JCalendarCombo) komponentaHelpPanela;
					Date datumD = dateBox.getDate();
					rezultatCitanja.add(datumD);
				}
			}
		}
		return rezultatCitanja;
	}

	
	public JPanel getBasicPanel() {
		return basicPanel;
	}

	public void setBasicPanel(JPanel basicPanel) {
		this.basicPanel = basicPanel;
	}

	public ArrayList<JPanel> getHelpPanels() {
		return helpPanels;
	}

	public void setHelpPanels(ArrayList<JPanel> helpPanels) {
		this.helpPanels = helpPanels;
	}

	public Vector<Column> getColumn(){
		return column;
	}
}
