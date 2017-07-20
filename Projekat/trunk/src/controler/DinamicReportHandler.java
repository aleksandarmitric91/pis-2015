package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import model.ConnectionClass;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import viewer.DinamicReportWindows;
import viewer.Tree;
import viewer.View;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import dataType.Column;

/**
 * Ova klasa prihvata klik na dinamicke izvjestaje i prikazuje ih.
 * 
 * @author G6
 */
public class DinamicReportHandler implements ActionListener 
{
	DinamicReportWindows dinamicRW;
	View view;
	
	/**
	 * Konstruktor klase DinamicReportHandler za prikazivanje izvjestaja.
	 * 
	 * @param view Objekat klase View kojim pristuamo elementima osnovnog prozora.
	 */
	public DinamicReportHandler(View view) 
	{
		this.view = view;
	}
	
	/**
	 * Akcija kojom se prikazuju izvjestaji.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Tree tree = this.view.getDrvce();
		Vector<Vector<Object>> resultSet = ConnectionClass.readTableData(tree.getTabela());
		
		try
		{
			Style titleStyle = new Style("Title");
			titleStyle.setBorderBottom(Border.PEN_1_POINT());
			titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
			titleStyle.setPadding(15);
			titleStyle.setFont(Font.ARIAL_BIG);

			Date date = new Date();
			FastReportBuilder drb = new FastReportBuilder();
			drb.addAutoText("Elektrotehnicki fakultet u Istocnom Sarajevu", AutoText.POSITION_HEADER, AutoText.ALIGNMENT_LEFT, 200);
			drb.addAutoText("Projektovanje Informacionih Sistema", AutoText.POSITION_HEADER, AutoText.ALIGNMENT_LEFT, 200);
			drb.addAutoText("Grupa6 - Multiteka", AutoText.POSITION_HEADER,AutoText.ALIGNMENT_LEFT, 200 );
			drb.addAutoText(date.toString(), AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_LEFT, 200);
			drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y, AutoText.POSITION_FOOTER, AutoText.ALIGMENT_RIGHT);
			DynamicReport dr = null;
			JRDataSource ds = null;
			
			int brojKolona = tree.getKolone().size();
			for (int i = 0; i < brojKolona; i++)
			{
				Column c = tree.getKolone().get(i);
				System.out.println(c.getKod());
				dr = drb.addColumn(c.getIme(), c.getKod(), String.class.getName(), 50).build();
			}
			
			dr = drb.setTitleStyle(titleStyle).setTitle("Izvjestajni podsistem aplikacije")
					.setSubtitle("Tabela: " + tree.getTabela().getIme()).setPrintBackgroundOnOddRows(true)
					.setFooterVariablesHeight(15).setUseFullPageWidth(true).build();
			ds = new JRResultSetDataSource(ConnectionClass.read(tree.getTabela()));
			JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
			System.out.println("Generisao sam report.");
			JasperViewer.viewReport(jp, false);
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
