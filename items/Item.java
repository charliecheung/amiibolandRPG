package items;
import java.awt.Image;

import javax.swing.ImageIcon;

import amiibo.GUI.AmiiboLandGameMapGUI;
import amiibo.GUI.Dialogue;
import data.*;

public class Item 
{
	ImageIcon image =  new ImageIcon("");
	public int quantity = 0;
	public Item next = null;
	public Item prev = null;
	Dialogue dialogue = new Dialogue("", "", null);
	
	public void use(AmiiboLandGameMapGUI gameMap, Amiibo used)
	{
		if (quantity > 0)
		{
			quantity--;
			System.out.println("Used Blank Item! And Brian came out");
		}
		else
		{
			//Play error sound
			System.out.println("No more nigguh");
		}
	}
	
	public void add()
	{
		quantity++;
	}
	
	public Image getImage()
	{
		return image.getImage();
	}
	
	public String getName()
	{
		return "Item";
	}
}
