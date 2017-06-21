package amiibo.GUI;

import java.awt.Image;

import javax.swing.ImageIcon;



/**
 * This class will get the appropriate image for all the NPC positions, Will expand this class more once we have
 * implemented more maps and different NPC's. This class is similar to our AmiiboLandGameImagaeDecipher.
 * Last Modified: February 20, 2015
 * @author ANDREW DONG
 *
 */
public class AmiiboLandGameNPCImage 
{
	
	//Instance variables for the class
	private Image npcReturnedImage;
	
	//Default constructor does nothing
	public AmiiboLandGameNPCImage()
	{
		
	}
	
	/** 
	 * This method will return the correct NPC image depending on the npcElement from the NPCMap file
	 * @param npcImageInfo - this contains the string information of the NPC that we want to print to the map
	 * @return - Will return npcReturnedImage which contains the correct NPC image file
	 */
	public Image GetImage(String npcImageInfo)
	{
	
		if(npcImageInfo.equals("NPC"))
		{
			ImageIcon img = new ImageIcon("src/resources/characters/player/male/frontWalking.gif");
			npcReturnedImage = img.getImage();
		}
		
		else if(npcImageInfo.equals("NPC1"))
		{
			ImageIcon img = new ImageIcon("src/resources/characters/player/male/frontWalking.gif");
			npcReturnedImage = img.getImage();
		}
		
		else if(npcImageInfo.equals("NPC2"))
		{
			ImageIcon img = new ImageIcon("src/resources/characters/player/male/frontWalking.gif");
			npcReturnedImage = img.getImage();
		}
		
		else if(npcImageInfo.equals("NPC3"))
		{
			ImageIcon img = new ImageIcon("src/resources/characters/player/male/frontWalking.gif");
			npcReturnedImage = img.getImage();
		}
		else if(npcImageInfo.equals("Nurse"))
		{
			ImageIcon img = new ImageIcon("src/resources/Characters/Nurse/stand.png");
			npcReturnedImage = img.getImage();
		}
		else if(npcImageInfo.equals("Brian"))
		{
			ImageIcon img = new ImageIcon("src/resources/Characters/Brian/stand.png");
			npcReturnedImage = img.getImage();
		}
		else if(npcImageInfo.equals("Red"))
		{
			ImageIcon img = new ImageIcon("src/resources/Characters/Ash/forward-stand.png");
			npcReturnedImage = img.getImage();
		}
		else if(npcImageInfo.equals("Chest"))
		{
			ImageIcon img = new ImageIcon("src/resources/textures/Overworld/Chest.png");
			npcReturnedImage = img.getImage();
		}
		else
		{
			ImageIcon img = new ImageIcon("src/resources/characters/player/male/frontWalking.gif");
			npcReturnedImage = img.getImage();
		}
		
		
		
		return npcReturnedImage;
	
	}
}
