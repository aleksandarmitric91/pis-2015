package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.Model;
import viewer.Statusbar;
import viewer.Toolbar;

import com.javadocking.DockingManager;
import com.javadocking.dock.Position;
import com.javadocking.dock.SplitDock;
import com.javadocking.dock.TabDock;
import com.javadocking.dockable.DefaultDockable;
import com.javadocking.dockable.Dockable;
import com.javadocking.dockable.DockingMode;
import com.javadocking.model.FloatDockModel;

/**
 * Klasa View se koristi za prikaz elemenata u glavnom prozoru
 * @author AleksandraV
 *
 */
public class View
{
	Model model;
	JFrame frame;
	Menubar menu;
	JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	Toolbar toolbar;
	Statusbar statusbar;
	int inputFieldsHeight = 175;
	DBTable tabela;
	Tree drvce;
	InputFields inputFields;

	public DBTable getTabela() {
		return tabela;
	}

	public void setTabela(DBTable tabela) {
		this.tabela = tabela;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public Tree getDrvce() {
		return drvce;
	}

	public void setDrvce(Tree drvce) {
		this.drvce = drvce;
	}

	public Statusbar getStatusbar() {
		return statusbar;
	}

	public void setStatusbar(Statusbar statusbar) {
		this.statusbar = statusbar;
	}

	public InputFields getInputFields() {
		return inputFields;
	}

	public void setInputFields(InputFields inputFields) {
		this.inputFields = inputFields;
	}

	/**
	 * Konstruktor klase View. Dodaje elemenate na glavni prozor i kreirana objekta ove klase.
	 */
	public View()
	{
		frame = new JFrame("DB Viewer - G6");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenSize.width*3/4, screenSize.height*3/4);
		frame.setMinimumSize(new Dimension(700, 400));
		frame.setLocation(screenSize.width/2-(screenSize.width*3/4)/2,screenSize.height/2-(screenSize.height*3/4)/2);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons/dbicon.png"));
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() 
		{
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
		    	model.disconnect();
	            System.exit(0);
		    }
		});
		
		menu = new Menubar(this);
		toolbar = new Toolbar(this);
		statusbar = new Statusbar(this);
		
		tabela = new DBTable(this);
		inputFields = new InputFields(this);
		drvce = new Tree(this);
		
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());

		FloatDockModel dokModel = new FloatDockModel();
		dokModel.addOwner("frame0", frame);
		DockingManager.setDockModel(dokModel);
		 
		Dockable predmetDokovanja1 = new DefaultDockable("Prozor1", drvce, "Database Browser", null, DockingMode.ALL);
		Dockable predmetDokovanja2 = new DefaultDockable("Prozor2", tabela, "Database Table", null, DockingMode.ALL);
		Dockable predmetDokovanja3 = new DefaultDockable("Prozor3", inputFields, "Input Fields", null, DockingMode.ALL);
		
		TabDock lijeviTabDok = new TabDock();
		TabDock centralniTabDok = new TabDock();
		TabDock tabDokDno = new TabDock();

		lijeviTabDok.addDockable(predmetDokovanja1, new Position(0));
		centralniTabDok.addDockable(predmetDokovanja2, new Position(0));
		tabDokDno.addDockable(predmetDokovanja3, new Position(0));
		
		SplitDock leftSplitDock = new SplitDock();
		leftSplitDock.addChildDock(lijeviTabDok, new Position(Position.CENTER));
		SplitDock centerSplitDock = new SplitDock();
		centerSplitDock.addChildDock(centralniTabDok, new Position(Position.CENTER));
		SplitDock bottomSplitDock = new SplitDock();
		bottomSplitDock.addChildDock(tabDokDno, new Position(Position.CENTER));
		
		dokModel.addRootDock("ljievidok", leftSplitDock, frame);
		dokModel.addRootDock("centralnidok", centerSplitDock, frame);
		dokModel.addRootDock("dokdno", bottomSplitDock, frame);
		
		horizontalSplitPane.setDividerLocation(200);
		verticalSplitPane.setDividerLocation(frame.getHeight() - inputFieldsHeight - 125);
		
		horizontalSplitPane.setLeftComponent(leftSplitDock);
		horizontalSplitPane.setRightComponent(verticalSplitPane);
		verticalSplitPane.setTopComponent(centerSplitDock);
		verticalSplitPane.setBottomComponent(bottomSplitDock);
		
		frame.setJMenuBar(menu);
		menu.disableMenubarButtons();
		menu.disableSwitchXML();
		menu.disableAceptAndCancel();
		menu.disableStaticReport();
		center.add(toolbar, BorderLayout.NORTH);
		toolbar.disableToolbarButtons();
		toolbar.disableAceptAndCancel();
		toolbar.disableStaticReport();
		frame.getContentPane().add(center, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.getContentPane().add(statusbar, BorderLayout.SOUTH);
		center.add(horizontalSplitPane);
		
		frame.addComponentListener(new ComponentListener()
		{
			/**
			 * Funkcija componentResized se koristi za realizaciju akcije na promjenu velicine glavnog prozora.
			 */
			@Override
			public void componentResized(ComponentEvent e)
			{
				verticalSplitPane.setDividerLocation(frame.getHeight() - inputFieldsHeight - 125);
				inputFields.setSirina(inputFields.getWidth());
			}

			@Override
			public void componentHidden(ComponentEvent e)
			{
			}

			@Override
			public void componentMoved(ComponentEvent e)
			{
			}

			@Override
			public void componentShown(ComponentEvent e)
			{
			}
		});
		
		inputFields.addComponentListener(new ComponentListener()
		{
			/**
			 * Funkcija componentResized se koristi za realizaciju akcije na promjenu velicine input prozora.
			 */
			@Override
			public void componentResized(ComponentEvent e)
			{
				inputFields.setBackground(new Color(0, 10, 150, 0));
				inputFields.setSirina(inputFields.getWidth());
			}

			@Override
			public void componentHidden(ComponentEvent e)
			{
			}

			@Override
			public void componentMoved(ComponentEvent e)
			{
			}

			@Override
			public void componentShown(ComponentEvent e)
			{
			}
		});
	}

	public Toolbar getToolbar()
	{
		return toolbar;
	}

	public void setToolbar(Toolbar toolbar)
	{
		this.toolbar = toolbar;
	}

	public Menubar getMenu()
	{
		return menu;
	}
}

