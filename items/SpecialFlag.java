package items;
import javax.swing.ImageIcon;

import amiibo.GUI.AmiiboLandGameMapGUI;
import data.*;

public class SpecialFlag extends Item
{
	public SpecialFlag(SavedData data)
	{
		image = new ImageIcon("src/resources/ui/items/special flag.png");
		quantity = Integer.parseInt(data.savedGameFile[4].split(",")[3]);
	}
	
	public void use(AmiiboLandGameMapGUI gameMap, Amiibo user)
	{
		if ((user.currentHealth == 0) && (quantity > 0))
		{
			user.currentHealth = user.maxHealth / 2;
			quantity--;
		}
		else if (quantity == 0)
		{
			dialogue.insufficientQuantity(gameMap);
		}
		else if (user.currentHealth > 0)
		{
			dialogue.incorrectUsage(gameMap);
		}
	}
	public String getName()
	{
		return "Special Flag";
	}
}
