package viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * klasa WelcomeScreen prikazuje pocetni ekran aplikacije i trazi od korisnika da unese korisnicko ime i lozinku.
 * 
 * @author G6
 */
public class WelcomeScreen extends JWindow
{
	private static final long serialVersionUID = 1L;
	
	JFrame login;
	JLabel usernameLbl = new JLabel("Korisnicko ime:");
	JLabel passwordLbl = new JLabel("Lozinka:");
	JTextField usernameTxt = new JTextField("", 14);
	JPasswordField passwordTxt = new JPasswordField("", 10);
	JButton OK;
	JPanel prviPanel;
	JPanel drugiPanel;
	JPanel box;
	public boolean nastavak = false;
	
	/**
	 * Funkcija showSplashAndExit prikazuje pocetni ekran
	 */
	public void showSplashAndExit()
	{
		showSplash();
		System.exit(0);
	}
	
	/**
	 * Funkcija showSplash prikazuje pocetni ekran sa podacima
	 * @return vraca bool vrijednost o tome da li je pokrenuta aplikacija
	 */
	public boolean showSplash()
	{
		int width = 500;
		int height = 249;
		int x;
		int y;
		JPanel splashScreen = (JPanel) getContentPane();
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		 x = (screen.width - width) / 2;
		 y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		JLabel slika = new JLabel(new ImageIcon("icons/WelcomeScreen.png"));
		splashScreen.add(slika, BorderLayout.CENTER);
		setVisible(true);
					
		login = new JFrame();		
		login.setSize(300, 150);
		login.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons/dbicon.png"));
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		prviPanel = new JPanel(new FlowLayout());
		prviPanel.add(usernameLbl);
		prviPanel.add(usernameTxt);
			
		drugiPanel = new JPanel(new FlowLayout());
		drugiPanel.add(passwordLbl);
		drugiPanel.add(passwordTxt);
		OK = new JButton("-      OK      -");
			
		box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		box.add(prviPanel);
		box.add(drugiPanel);
		box.add(OK);
			
		login.add(box);
		
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{						
			System.out.println("Nece da ga slipuje");
		}
		
		login.show();
		
		OK.addActionListener(new ActionListener()
		{			
			@Override
			/**
			 * funkcija actionPerformed koristi se za potvrdu korisnickog imena i lozinke i vraca u programu da li je korisnik prepoznat ili ne
			 */
			public void actionPerformed(ActionEvent arg0)
			{
				if (usernameTxt.getText().equals("Menager"))
				{
					char[] input = passwordTxt.getPassword();
					char[] pass = {'1','2','3'};
					if(Arrays.equals(input, pass))
					{						
						passwordTxt.setText("");
						usernameTxt.setText("");
						login.hide();
						setVisible(true);
						try
						{
							Thread.sleep(2000);
						} 
						catch (InterruptedException e)
						{						
							System.out.println("Nece da ga slipuje");
						}
						setVisible(false);
						nastavak = true;						
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Nije dobra lozinka");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Korisnicko ime je neispravno");					
				}
			}
		});
		return nastavak;
	}
}