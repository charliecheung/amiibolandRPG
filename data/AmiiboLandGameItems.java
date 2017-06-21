package data;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * This class will handle all the Item elements of the game. Will handle the collisions with the Item's 
 * The class will also read in the correct Item text file depending on which map the player is on.
 * List to do:
 * 1. Implement moving Item - This is  a might have feature
 * 
 * Last Modified: February 20, 2015
 * @author ANDREW DONG
 *
 */
public class AmiiboLandGameItems {
	
	//Instance Variables for the class
    
    // Modified these variables depending on how many Item's we want
    private int maxX = 5;
    private int maxY = 1;
    public ImageIcon unObtained = new ImageIcon("src/resources/textures/items/pokeball closed.png");
    public ImageIcon obtained = new ImageIcon("src/resources/textures/items/pokeball opened.png");

    /**
     * Will get the array column size
     * @return - number of columns in the array
     */
    public int getMaxX()
    {
    	return maxX;
    }
    
    /**
     * Will return the number of rows in the array
     * @return - number of columns
     */
    public int getMaxY()
    {
    	return maxY;
    }
    
    public Image getImage(int obtained)
    {
    	if (obtained == 0)
    	{
    		return unObtained.getImage();
    	}
    	else
    	{
    		return this.obtained.getImage();
    	}
    }

    /**
     * Default constructor does nothing
     */
	public AmiiboLandGameItems()
	{
	
	}
	
	/** 
	 * THis method will handle all the collisions related to the Item's of the map
	 * @param xCoord
	 * @param yCoord
	 * @return - return False if not valid movement option and True otherwise
	 */
	public boolean isValidMovement(int xCoord,int yCoord,SavedData savedData,AmiiboLandGameMap map)
	{
		boolean validMovement = true;
		for (int i = 0; i < savedData.linesOfItems; i++)
		{
			//y=2 x=3
			String[] temp = savedData.savedItems[i].split(",");
			if (((yCoord == Integer.parseInt(temp[3])) && (xCoord == Integer.parseInt(temp[2]))) && (temp[0]).equals(map.gamelevel))
			{
				System.out.println("Comparing Coord: " + xCoord + "," + yCoord + " with " + temp[3] + "," + temp[2]);
				validMovement = false;
			}
		}
		return validMovement;	
	}
/*
	public boolean checkGrabbed(SavedData savedData, int xCoord, int yCoord)
	{
		for (int i = 0; i < savedData.linesOfItems; i++)
		{
			//y=2 x=3
			String[] temp = savedData.savedItems[i].split(",");
			if ((xCoord == Integer.parseInt(temp[3])) && (yCoord == Integer.parseInt(temp[2])))
			{
				if (Integer.parseInt(temp[4]) == 0)
				{
					savedData.savedItems[i] = temp[0]+","+temp[1]+","+temp[2]+","+temp[3]+","+"1";
					return false;
				}
				else
				{
					return true;
				}
			}
		}
	}
	*/
}
