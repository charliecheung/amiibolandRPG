package items;
import javax.swing.ImageIcon;

import amiibo.GUI.AmiiboLandGameMapGUI;
import data.*;

public class MegaMushroom extends Item
{
	public MegaMushroom(SavedData data)
	{
		image = new ImageIcon("src/resources/ui/items/mega mushroom.png");
		quantity = Integer.parseInt(data.savedGameFile[4].split(",")[1]);
	}
	
	public void use(AmiiboLandGameMapGUI gameMap, Amiibo user)
	{
		if ((user.currentHealth < user.maxHealth) && (quantity > 0))
		{
			user.currentHealth = user.maxHealth;
			quantity--;
		}
		else if (quantity == 0)
		{
			dialogue.insufficientQuantity(gameMap);
		}
		else if (user.currentHealth == user.maxHealth)
		{
			dialogue.incorrectUsage(gameMap);
		}
	}
	public String getName()
	{
		return "Mega Mushroom";
	}
}
