package data;

import java.io.*;
import java.awt.*;
import java.util.Scanner;

import javax.swing.*;

import amiibo.GUI.*;


/**
 * Last Updated: April 10th ,2014
 * This is the MazeBoard class. This class has the map in a 2D array. The paint method will then check each element of the array and then 
 * it will either draw the wall or floor of the maze. Both the wall and floor icon are made in photo shop and are open and loaded into the variable
 * Wall and floor. 
*/

public class AmiiboLandGameMap extends AmiiboLandGameFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//instance variables
	private int scoreTimeOff = 0; 
    private Scanner inputStream = null;
    private int WIDTH = 40;
    private int HEIGHT = 24;
    private String[][] mapArray = new String[WIDTH][HEIGHT];
    private Timer currentTime;
	SavedData savedData;
	String gamelevel;
	AmiiboLandGameFrame level;
       
	/**
	  * getWidth return this WIDTH variable, accessed method
	  */
    public int getWidth()
    {
        return WIDTH;
    
    }
    /**
	  * getHeight return this HEIGHT variable, accessed method
	  */
    public int getHeight()
    {
        return HEIGHT;
    }

	/**
	  * Default Constructor
	  */
    public AmiiboLandGameMap()
    {

    }

    /**
      * Default constructor of the class
      * reads and load the default map file into the map array
	  * Maze ideas were taken and based off mazes from http://www.delorie.com/game-room/
      */
    public AmiiboLandGameMap(String levelSelect,Timer time )
    {
        savedData = new SavedData();
        currentTime = time;
        this.gamelevel = levelSelect;
        
        // switch statement uses the correct map text file, according to the 
        // user choice from the drop down menu in startscreen GUI. File is scanned and read line by line,
        // and converted to an array to be interpreted by the GUI
        switch(gamelevel)
        {
        
        case "Street1":
            try
            {
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));              
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
                    
            case "Street2":
            try
            {
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));             
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
            
            case "Street3":
            try
            {
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));          
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
            
            case "Street4":
            try
            {
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));             
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
            
            case "BrianHouse":
            try
            {
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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

            case "TOWN":
            try
            {
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));
                int numOfRows =0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
            
            case "Pallet Town":
            try
            {
                inputStream = new Scanner(new File("src/resources/maps/Pallet Town.txt"));
                int numOfRows = 0;
                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    mapArray[numOfRows] = line.split(" ");
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
      * this method checks takes tow arguments a x coordinate and a y coordinate. It will then use these coordinates to check if the space in the mapArray contains a treasure piece.
      * This is why there is a if branch in the method. The branch will check to see if the coordinates passed in contain treasure or not. If the is a treasure then the treasure counter will 
      * increase by one, indicating that one treasure is found and added to out treasure count.
	  * @param rows the row of the map array
	  * @param columns column of the map array
    */
    public void levelChecker(SavedData savedData, int rows, int columns, AmiiboLandGameMapGUI gui)
	{
			int top = 20;
			int bottom = 20;
			int left = 20;
			int right = 20;
			int middle = 20;
			
	    	//Handles the appropriate action if player lands on Street 1 element
    		if(mapArray[columns][rows].equals("a"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		level = new AmiiboLandGameFrame(savedData, "Street1", middle, top);
    		}
    		
    		else if(mapArray[columns][rows].equals("A"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		 level = new AmiiboLandGameFrame(savedData, "Street1", middle, bottom);
    		}
    		
    		else if(mapArray[columns][rows].equals("e"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		 level = new AmiiboLandGameFrame(savedData, "Street1", right, middle);
    		}
    		
        	//Handles the appropriate action if player lands on Street 2 element
    		else if(mapArray[columns][rows].equals("B"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		 level = new AmiiboLandGameFrame(savedData, "Street2", left, middle);
    		}
    		
    		else if(mapArray[columns][rows].equals("b"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		 level = new AmiiboLandGameFrame(savedData, "Street2", right, middle);
    		}
    		
    		else if(mapArray[columns][rows].equals("E"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		 level = new AmiiboLandGameFrame(savedData, "Street2", middle, top);
    		}
    		
        	//Handles the appropriate action if player lands on Street 3 element
    		else if(mapArray[columns][rows].equals("C"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		 level = new AmiiboLandGameFrame(savedData, "Street3", left, middle);
    		}
    		
      		else if(mapArray[columns][rows].equals("c"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		 level = new AmiiboLandGameFrame(savedData, "Street3", right, middle);
    		}
    		
    		//Handles the appropriate action if player lands on Street 4 element
    		else if(mapArray[columns][rows].equals("D"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		 level = new AmiiboLandGameFrame(savedData, "Street4", middle, left);
    		}
    		
    		else if(mapArray[columns][rows].equals("d"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
        		 level = new AmiiboLandGameFrame(savedData, "Street4", middle, top);
    		}
    		
    		//Handles the appropriate action if player lands on the RainForest element 
    		else if(mapArray[columns][rows].equals("1"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
    			 level = new AmiiboLandGameFrame(savedData, "RainForest", middle, middle);
    		}
    		
    		//Handles the appropriate action if player lands on the Bull's Eye element
    		else if(mapArray[columns][rows].equals("2"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
    			 level = new AmiiboLandGameFrame(savedData, "BullsEye", middle, bottom);
    		}
    		
    		//Handles the appropriate action if player lands on the WeRToys element
    		else if(mapArray[columns][rows].equals("3"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
    			 level = new AmiiboLandGameFrame(savedData, "WeRToys", middle, bottom);
    		}
    		
    		//Handles the appropriate action if player lands on the Pallet Town Element 
    		else if(mapArray[columns][rows].equals("P"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
    			 level = new AmiiboLandGameFrame(savedData, "TOWN", middle, top);
    		}
    		
    		//Handles the appropriate action if player lands  on the Floor Store Element 
    		else if(mapArray[columns][rows].equals("4"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
    			 level = new AmiiboLandGameFrame(savedData, "FloorStore", middle, bottom);
    		}
    		
    		//Handles the appropriate action if player lands on the RainForest element
    		else if(mapArray[columns][rows].equals("H"))
    		{
    			Window w = SwingUtilities.getWindowAncestor(gui);
    	        w.setVisible(false);
    			 level = new AmiiboLandGameFrame(savedData, "BrianHouse", middle, bottom);
    		}
    		
    		else
    		{
    		}

	}
    

	
	/**
	  * this method will return the the time to be taken of the time it takes
	  * to complete the maze game.
	  * @return scoreTimeOff score that is to be taken of from total time.
	  */
	public int getScoreTimeOFf()
	{
		return scoreTimeOff;
	}
	
	/** 
	  * this method checks if the player has reach the finish line tile of the game
	  * @param rows the current row of the player
	  * @param columns the current column of the player
	  * @return true if the player has reached the finish line.
	  */
	public boolean endGameCheck(int rows,int columns)
	{
		// if branch to check if the player has finish the game.
		// returns true of player reach finish line. Returns false if the player has not finish the game.
		if(mapArray[columns][rows].equals("E"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	  * This method checks the mapArray to see the pass in movement is a valid movement space. The method will return a false if there is a wall
	  * for the next movement. If the pass in space is not a wall ie a empty space or a Treasure space then the method will return true.
	  * True means that the movement is indeed a valid movement. False means that the movement is not a valid movement.
	  * @param rows the current row of the player
      * @param columns the current column of the player
	  * @return true if valid movement
	  * @return false if not valid movement
	  */
    public boolean validMovement(int rows, int columns)
    {
        // If branch to check if player has made a valid movement.
		// returns a boolean value depending if valid or not valid.
		if(mapArray[columns][rows].equals("pA") || mapArray[columns][rows].equals("pB") || mapArray[columns][rows].equals("pC") || mapArray[columns][rows].equals("pD") || mapArray[columns][rows].equals("p") || mapArray[columns][rows].equals("n")|| mapArray[columns][rows].equals("gA") || mapArray[columns][rows].equals("wL") || mapArray[columns][rows].equals("sand"))
        {

            return true;
        }
        else
        {

            return false;
        }
        
    }
    
    /**
     * This method will check the interaction of the player sprite. It will call the appropriate method for the interaction, for example if the player encounters a boss
     * then it will check if the encounter is a boss and then calls the boss battle method(Or what ever we are doing for the battle)
     * @param rows this is the row position passed into the method
     * @param columns this is the column position passed into the method
     * @throws FileNotFoundException 
     * 
     */
	 //BABESKII WHOLE METHOD
    public LinkedList interactionElement(int rows, int columns, SavedData savedData, AmiiboLandGameNPC npc, AmiiboLandGameItems items) throws FileNotFoundException
    {
    	String whatNPC = npc.whatNPCType(columns, rows);
    	System.out.println(whatNPC);
    	
    	if(mapArray[columns][rows].equals("W") )
    	{
    		Dialogue text = new Dialogue("This is a wall, This is a wall, This is a wall, This is a wall", "Wall", null);
    		LinkedList linkedList = new LinkedList(text);
    		text = new Dialogue("Also, Brian came out", "Wall", null);
    		linkedList.insert(text);
    		text = new Dialogue("done", null, null);
    		linkedList.insert(text);
    		return linkedList;
    	}
    	
    	else if(mapArray[columns][rows].equals("Z"))
    	{	
    		Dialogue text = new Dialogue("Brian came out", "Boss", null);
    		LinkedList linkedList = new LinkedList(text);
    		text = new Dialogue("done", null, null);
    		linkedList.insert(text);
    		return linkedList;
    	}
    	
    	else if(whatNPC.equals("Brian"))
    	{	
    		if (savedData.savedGameFile[5].split(",")[1].equals("0"))
    		{
    			this.savedData = savedData;
    			this.savedData.savedGameFile[5] = "TALKED_TO_BRIAN," + 1;
	    		Dialogue text = new Dialogue("Hello " + savedData.playerData[0] + "! I am Brian!", "Brian", null);
	    		LinkedList linkedList = new LinkedList(text);
	    		text = new Dialogue("You got any leads bruh?", "#USER", null);
	    		linkedList.insert(text);
	    		text = new Dialogue("Fine! Here's a shitty link Amiibo", "Brian", null);
	    		linkedList.insert(text);
	    		text = new Dialogue("done", null, null);
	    		linkedList.insert(text);
	            savedData.getAmiibo(2);
	    		return linkedList;
    		}
    		
    		else if ((Integer.parseInt(savedData.savedGameFile[6].split(",")[1]) < 32))
    		{
    			int temp = (Integer.parseInt(savedData.savedGameFile[6].split(",")[1]));
    			temp++;
    			this.savedData.savedGameFile[6] = "BRIAN_CAME_OUT_COUNTER," + temp;
	    		Dialogue text = new Dialogue("No, I will not come out", "Brian", null);
	    		LinkedList linkedList = new LinkedList(text);
	    		text = new Dialogue("done", null, null);
	    		linkedList.insert(text);
	    		return linkedList;
    		}
    		
    		else
    		{
	    		Dialogue text = new Dialogue("Fine, because of your persistance, I came out", "Brian", null);
	    		LinkedList linkedList = new LinkedList(text);
	    		text = new Dialogue("done", null, null);
	    		linkedList.insert(text);
	    		return linkedList;
    		}
    	}
    	
    	else if(whatNPC.equals("Nurse"))
    	{
    		LinkedList linkedList;
    		if (savedData.party.ifHurt() == true)
    		{
				Dialogue text = new Dialogue("Your Amiibo appear to be hurt", "Nurse", null);
				linkedList = new LinkedList(text);
				PlaySound healSound = new PlaySound();
				healSound.heal();
				savedData.party.heal();
				text = new Dialogue("Here, let me heal them", "Nurse", healSound);
				linkedList.insert(text);
				text = new Dialogue("There! Done. See you soon!", "Nurse", null);
				linkedList.insert(text);
				text = new Dialogue("done", null, null);
				linkedList.insert(text);
    		}
    		
    		else
    		{
				Dialogue text = new Dialogue("Your Amiibo appear to be in tip-top shape!", "Nurse", null);
				linkedList = new LinkedList(text);
	    		text = new Dialogue("done", null, null);
	    		linkedList.insert(text);
    		}
    		return linkedList;
    	}
    	
    	else if(whatNPC.equals("Chest"))
    	{
    		LinkedList linkedList;
			Dialogue text = new Dialogue("Let's change things up", null, null);
			linkedList = new LinkedList(text);
			text = new Dialogue("CHANGE_PARTY", null, null);
			linkedList.insert(text);
			text = new Dialogue("There! New Party has been selected", null, null);
			linkedList.insert(text);
    		text = new Dialogue("done", null, null);
    		linkedList.insert(text);
    		return linkedList;
    	}
    	
    	else if(whatNPC.equals("Red"))
    	{
    		LinkedList linkedList;
			Dialogue text = new Dialogue("...", "Red", null);
			linkedList = new LinkedList(text);
			text = new Dialogue("BATTLE_RED", null, null);
			linkedList.insert(text);
    		text = new Dialogue("done", null, null);
    		linkedList.insert(text);
    		return linkedList;
    	}
    	
    	else
    	{
			Dialogue text = new Dialogue("done", null, null);
    		LinkedList linkedList = new LinkedList(text);
			return linkedList;
    	}
    }

	/**
	  * This method return the current element of the map array.
	  * @return mapElement contains the string element of mapArray
	  */
    public String getMapElement(int rows, int columns)
    {
        String mapElement = mapArray[rows][columns];
        return mapElement;
    }
    
    public String getlevel()
    {
    	return gamelevel;
    }

	
	
}