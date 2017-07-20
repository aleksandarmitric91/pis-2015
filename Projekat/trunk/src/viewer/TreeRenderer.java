package viewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import dataType.Database;
import dataType.Package;
import dataType.Table;
import dataType.Column;

/**
 * Klasa TreeRenderer implementira TreeCellRenderer i na osnovu nje se vrsi pomjeranje tabele, panela u glavnom programu
 * @author AleksandraV
 *
 */
public class TreeRenderer implements TreeCellRenderer
{
	/**
	 * Metoda getTreeCellRendererComponent se koristi za rendiranje stabla u glavnom prozoru.
	 * Na osnovu prosljedjenih parametara 
	 */
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,boolean isSelected, boolean isExpanded, boolean isLeaf, int row, boolean hasFocus)
	{
		JLabel labela = new JLabel();
		labela.setOpaque(true);
		Border paddingBorder = BorderFactory.createEmptyBorder(0,10,0,10);
		labela.setBorder(paddingBorder);
		labela.setFont(new Font( "TimesNewRoman" , Font.BOLD, 13));

		DefaultMutableTreeNode cvor = (DefaultMutableTreeNode) value;
		
		if(cvor.getUserObject() instanceof Database)
		{
			Database database = (Database) cvor.getUserObject();
			labela.setIcon(new ImageIcon("icons/treeDatabase.png"));
			labela.setText(database.getIme());
		}
		else if(cvor.getUserObject() instanceof Package)
		{
			Package pack = (Package) cvor.getUserObject();
			labela.setIcon(new ImageIcon("icons/treePackage.png"));
			labela.setText(pack.getIme());
		}
		else if(cvor.getUserObject() instanceof Table)
		{
			Table table = (Table) cvor.getUserObject();
			labela.setIcon(new ImageIcon("icons/treeTable.png"));
			labela.setText(table.getIme());
		}
		else if(cvor.getUserObject() instanceof Column)
		{
			Column kolona = (Column) cvor.getUserObject();
			labela.setIcon(new ImageIcon("icons/treeColumn.png"));
			labela.setText(kolona.getIme()+" - "+kolona.getTipPodatka());
		}
		
		if(isSelected)
		{
			labela.setBackground(new Color(51, 153, 255));
		}
		
		return labela;
	}
}

