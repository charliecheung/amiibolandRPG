package items;
import javax.swing.ImageIcon;

import amiibo.GUI.AmiiboLandGameMapGUI;
import data.*;

public class OneUpMushroom extends Item
{
	public OneUpMushroom(SavedData data)
	{
		image = new ImageIcon("src/resources/ui/items/1up mushroom.png");
		quantity = Integer.parseInt(data.savedGameFile[4].split(",")[4]);
	}
	
	public void use(AmiiboLandGameMapGUI gameMap, Amiibo user)
	{
		if ((user.currentHealth == 0) && (quantity > 0))
		{
			user.currentHealth = user.maxHealth;
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
		return "1-Up Mushroom";
	}
}
