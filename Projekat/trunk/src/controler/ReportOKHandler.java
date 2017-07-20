package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import viewer.StaticReportWindow;
import viewer.View;

/**
 * Klasa omogucava potvrdu akcije ispisa izvjestaja.
 * 
 * @author G6S
 */
public class ReportOKHandler implements ActionListener 
{
	String ime;
	View view;
	
	/**
	 * Konstruktor klase ReportOKHandler za potvrdu akcije prikazivanja 
	 * @param view
	 */
	public ReportOKHandler(View view) 
	{
		this.view = view;
	}
	
	/**
	 * Akcija koja bira staticki izvjestaj i stampa.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		ime = StaticReportWindow.getSelectedButton();
		switch(ime)
		{
			case "cjenovnik":
			{
				JasperReport jr;
				JasperPrint jp;
				try 
				{
					jr = JasperCompileManager.compileReport("reports/reportCjenovnik.jrxml");
					jp = JasperFillManager.fillReport(jr, null, view.getModel().getKonekcija());
					JasperViewer.viewReport(jp,false);
				} 
				catch (JRException e) { e.printStackTrace();}
				break;
			}
			case "artikli":
			{
				JasperReport jr;
				JasperPrint jp;
				try 
				{
					jr = JasperCompileManager.compileReport("reports/reportArtikli.jrxml");
					jp = JasperFillManager.fillReport(jr, null, view.getModel().getKonekcija());
					JasperViewer.viewReport(jp,false);
				}
				catch (JRException e) {e.printStackTrace();}
				break;
			}
			case "zaposleni":
			{
				JasperReport jr;
				JasperPrint jp;
				try 
				{
					jr = JasperCompileManager.compileReport("reports/reportZaposleni.jrxml");
					jp = JasperFillManager.fillReport(jr, null, view.getModel().getKonekcija());
					JasperViewer.viewReport(jp,false);
				} catch (JRException e) {e.printStackTrace();}
				break;
			}
			case "clanovi":
			{
				JasperReport jr;
				JasperPrint jp;
				try 
				{
					jr = JasperCompileManager.compileReport("reports/reportClanovi.jrxml");
					jp = JasperFillManager.fillReport(jr, null, view.getModel().getKonekcija());
					JasperViewer.viewReport(jp,false);
				} 
				catch (JRException e) {e.printStackTrace();}
				break;
			}
		}
	}
}
