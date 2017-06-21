package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class will handle all the NPC elements of the game. Will handle the collisions with the NPC's 
 * The class will also read in the correct NPC text file depending on which map the player is on.
 * List to do:
 * 1. Implement moving NPC - This is  a might have feature
 * 
 * Last Modified: February 20, 2015
 * @author ANDREW DONG
 *
 */
public class AmiiboLandGameNPC {
	
	//Instance Variables for the class
    private Scanner inputStream = null;
    
    // Modified these variables depending on how many NPC's we want
    private int maxX = 4;
    private int maxY = 5;
    private String[][] npcCoord = new String[maxY][maxX];

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

    /**
     * Default constructor does nothing
     */
	public AmiiboLandGameNPC()
	{
	
	}

	/**
	 * This method will take in a map name and then reads in a text file that
	 * contains all the coordinates of the NPC's of that map
	 * @param npcFileName
	 */
	public AmiiboLandGameNPC(String npcFileName)
	{


		switch(npcFileName)
		{

		case "Pallet Town":
        try
        {
        	
            inputStream = new Scanner(new File("src/resources/maps/PalletTownNPC.txt"));              
            int numOfRows =0;
            while(inputStream.hasNextLine())
            {
                String line = inputStream.nextLine();
                npcCoord[numOfRows] = line.split(" ");
                numOfRows++;
            }    
            inputStream.close();

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error in opening the file: ");
            System.exit(0);
        }

        break;
        
		case "BullsEye":
	        try
	        {
	            inputStream = new Scanner(new File("src/resources/maps/BullsEyeNPC.txt"));              
	            int numOfRows =0;
	            while(inputStream.hasNextLine())
	            {
	                String line = inputStream.nextLine();
	                npcCoord[numOfRows] = line.split(" ");
	                numOfRows++;
	            }    
	            inputStream.close();
	        }
	        catch(FileNotFoundException e)
	        {
	            System.out.println("Error in opening the file: ");
	            System.exit(0);
	        }
	        break;
	        
		case "FloorStore":
	        try
	        {
	            inputStream = new Scanner(new File("src/resources/maps/FloorStoreNPC.txt"));              
	            int numOfRows =0;
	            while(inputStream.hasNextLine())
	            {
	                String line = inputStream.nextLine();
	                npcCoord[numOfRows] = line.split(" ");
	                numOfRows++;
	            }    
	            inputStream.close();
	        }
	        catch(FileNotFoundException e)
	        {
	            System.out.println("Error in opening the file: ");
	            System.exit(0);
	        }
	        break;
	        
		case "WeRToys":
	        try
	        {
	            inputStream = new Scanner(new File("src/resources/maps/WeRToysNPC.txt"));              
	            int numOfRows =0;
	            while(inputStream.hasNextLine())
	            {
	                String line = inputStream.nextLine();
	                npcCoord[numOfRows] = line.split(" ");
	                numOfRows++;
	            }    
	            inputStream.close();
	        }
	        catch(FileNotFoundException e)
	        {
	            System.out.println("Error in opening the file: ");
	            System.exit(0);
	        }
	        break;
		
		case "RainForest":
	        try
	        {
	            inputStream = new Scanner(new File("src/resources/maps/RainForestNPC.txt"));              
	            int numOfRows =0;
	            while(inputStream.hasNextLine())
	            {
	                String line = inputStream.nextLine();
	                npcCoord[numOfRows] = line.split(" ");
	                numOfRows++;
	            }    
	            inputStream.close();
	        }
	        catch(FileNotFoundException e)
	        {
	            System.out.println("Error in opening the file: ");
	            System.exit(0);
	        }
	        break;
		}

	}
	
	/**
	 * This method will take in the row and column number and return the x coordinate
	 * of the NPC.
	 * @param arrayRows
	 * @param arrayColumns
	 * @return X coordinate of the NPC
	 */
	public String getXPosition(int arrayRows,int arrayColumns)
	{
		return npcCoord[arrayRows][arrayColumns];
	}
	
	/**
	 * This method will take in the row and column number and return the y coordinate
	 * of the NPC.
	 * @param arrayRows
	 * @param arrayColumns
	 * @return - the Y coordinate of the NPC
	 */
	public String getYPosition(int arrayRows,int arrayColumns)
	{
		return npcCoord[arrayRows][arrayColumns];
	}
	
	/**
	 * This method will return the string element containing the NPC info so 
	 * that we can print the correct type of NPC to the map
	 * @param arrayRows
	 * @return - String NPCElement
	 */
	public String getElementType(int arrayRows)
	{
		return npcCoord[arrayRows][0];
	}
	
	/** 
	 * THis method will handle all the collisions related to the NPC's of the map
	 * @param xCoord
	 * @param yCoord
	 * @return - return False if not valid movement option and True otherwise
	 */
	public boolean isValidMovement(int xCoord,int yCoord )
	{
		boolean validMovement = false;
		for(int yLoop = 0; yLoop < maxY; yLoop++)
		{
				int xLoop =1;
				if(Integer.parseInt(npcCoord[yLoop][xLoop]) == xCoord &&
						Integer.parseInt(npcCoord[yLoop][xLoop+1]) == yCoord)
				{

					validMovement = false;
					yLoop = maxY;
				}
				else
				{
					validMovement = true;
				}

		}
		return validMovement;	
	}
	
	/**
	 * THis method will check the NPC type, ie Chest, Nurse, Boss, etc. This method is use to handle
	 * the interaction with the NPCs
	 * @param xCoord
	 * @param yCoord
	 * @return - return a string that contains the type of the NPC
	 */
	public String whatNPCType(int xCoord, int yCoord)
	{
		String npcType = null;

		// This for loop will loop through each row of the npcCoord array and check if the player has interact 
		// with a NPC. 
		for(int yLoop = 0; yLoop < maxY; yLoop++)
		{
			int xLoop = 1;
			
			if(Integer.parseInt(npcCoord[yLoop][xLoop]) == yCoord &&
					Integer.parseInt(npcCoord[yLoop][xLoop+1]) == xCoord)
			{
				npcType = npcCoord[yLoop][0];
				yLoop = maxY;
				
			}
			else
			{
				npcType = "FUCK";
			}
			

		}
		return npcType;
		
		
	}
	
	
}
