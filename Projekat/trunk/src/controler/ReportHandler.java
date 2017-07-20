package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import viewer.StaticReportWindow;
import viewer.View;

/**
 * Klasa za ispisivanje panela sa prikazom izbora koji izvjestaj zelimo da generisemo.
 */
public class ReportHandler implements ActionListener 
{
	StaticReportWindow staticRW;
	View view;	
	
	/**
	 * Konstruktor klase ReportHandler za kreiranje statickih izvjestaja
	 * 
	 * @param view
	 */
	public ReportHandler(View view) 
	{
		this.view = view;
	}
	
	/**
	 * Akcija prikazuje prozor prilikom klika na dugme staticki izvjestaji
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		staticRW = new StaticReportWindow(this.view);
	}
}