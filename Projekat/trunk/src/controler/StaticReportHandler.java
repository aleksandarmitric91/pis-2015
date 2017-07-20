package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import viewer.View;

/**
 * Klasa za prikaz statickih izvjestaja.
 * 
 * @author G6
 */
public class StaticReportHandler implements ActionListener {

	String report;
	View view;

	/**
	 * Konstruktor klase StaticReportHandler za kreiranje datog objekta.
	 * 
	 * @param view Objekat klaze View za pristup elementima glavnog prozora.
	 * @param report String kojim se definise koji izvjestaj se stampa
	 */
	public StaticReportHandler(View view, String report) 
	{
		this.report = report;
		this.view = view;
	}
	
	/**
	 * Akcija za prikaz statickog prozora.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch (report) 
		{
			case "cjenovnik": 
			{
				JasperReport jr;
				JasperPrint jp;
				try 
				{
					jr = JasperCompileManager.compileReport("reports/reportCjenovnik.jrxml");
					jp = JasperFillManager.fillReport(jr, null, view.getModel().getKonekcija());
					JasperViewer.viewReport(jp, false);
	
				} catch (JRException e) {e.printStackTrace();}
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
					JasperViewer.viewReport(jp, false);
				} catch (JRException e) {e.printStackTrace();}
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
					JasperViewer.viewReport(jp, false);
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
					JasperViewer.viewReport(jp, false);
				} catch (JRException e) { e.printStackTrace();}
				break;
			}
		}
	}
}