package model;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.javadocking.util.LookAndFeelUtil;

import viewer.WelcomeScreen;
import viewer.View;

/**
 * Glavna klasa koja se koristi prilikom pokretanja aplikacije.
 * 
 * @author G6
 */
public class MainClass
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}
		catch (Exception e) {}
		JFrame.setDefaultLookAndFeelDecorated(true);
		LookAndFeelUtil.removeAllSplitPaneBorders();
		
		WelcomeScreen ws=new WelcomeScreen();
		
		ws.showSplash();
		
		while(ws.nastavak == false)
		{}
		
		View view = new View();
		view.setModel(new Model());
	}
}
