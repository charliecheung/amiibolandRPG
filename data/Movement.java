package data;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import amiibo.GUI.*;



/**
  * Last updated April 10th, 2014
  * this class creates the GUI players next move. Taking a parameter of the current
  * X and Y position from the selected map array, the player will then move in the correct directons
  * through the array. Each movement, or key pressed event, checks for valid movement, treasure,
  * and an end game status.
  */

public class Movement
{
	private int playPostionArrayX;
	private int playPostionArrayY;
	
	private AmiiboLandMapEncounters encounter = new AmiiboLandMapEncounters();
	
	//Facing down = 0, Facing right = 1, facing left = 2, facing up = 3
	private String playerOrientation = "down";
	
	private boolean isMoving = false;

	/**
	  * This method will move the player in the map, UP a block.
	  * Checks for treasure, valid movement, and end of game status.
	  * @ params Mazeboard: the instance we are using of Mazeboard
	  * @ params Player: our instance of player
	  */  
    public void moveUp(SavedData savedData, AmiiboLandGameMap mapInfo,AmiiboLandGameNPC npc,AmiiboLandGameItems items,Player playerInfo, AmiiboLandGameMapGUI gui)
    {
    	playPostionArrayX = playerInfo.getXPosition();
		playPostionArrayY = playerInfo.getYPosition();
		
		//Changes the player sprite to facing up position.
		playerOrientation = "up";
		
        // Handles the collision detection. If the next position of of the maze is
        // a wall then the moveCalc will be passed 0,0 so that the character position does not change
        if(mapInfo.validMovement(playPostionArrayX,playPostionArrayY-1) == false || npc.isValidMovement(playPostionArrayX, playPostionArrayY-1)==false|| (items.isValidMovement(playPostionArrayX, playPostionArrayY-1,savedData,mapInfo)==false))
        {
            playerInfo.moveCalc(0,0);
        }
        else
        {
    	   	// Checks if the tile moved on has the element for the next value
    	   	mapInfo.levelChecker(savedData, playPostionArrayX,playPostionArrayY-1, gui);
        	//Calculates the sprite next position.
            playerInfo.moveCalc(0,-1);
            encounter.generateRandomEncounter(mapInfo.getlevel());
        }

    }
    
	/**
	  * This method will move the player in the maze, DOWN a block.
	  * Checks for treasure, valid movement, and end of game status.
	  * @ params Mazeboard: the instance we are using of Mazeboard
	  * @ params Player: our instance of player
	  */
    public void moveDown(SavedData savedData, AmiiboLandGameMap mapInfo,AmiiboLandGameNPC npc,AmiiboLandGameItems items,Player playerInfo, AmiiboLandGameMapGUI gui)
    {
        playPostionArrayX = playerInfo.getXPosition();
        playPostionArrayY = playerInfo.getYPosition();
		
        //Changes the player sprite to facing down position.
		playerOrientation = "down";
        
        
        // Handles the collision detection. If the next position of of the maze is
        // a wall then the moveCalc will be passed 0,0 so that the character position does not change
        if(mapInfo.validMovement(playPostionArrayX,playPostionArrayY+1) == false || (npc.isValidMovement(playPostionArrayX, playPostionArrayY+1)==false)|| (items.isValidMovement(playPostionArrayX, playPostionArrayY+1,savedData,mapInfo)==false))
        {
            playerInfo.moveCalc(0,0);
        }
        
       else
        {
    	   	// Checks if the tile moved on has the element for the next value
    	   	mapInfo.levelChecker(savedData, playPostionArrayX,playPostionArrayY+1, gui);
            playerInfo.moveCalc(0,1);
            encounter.generateRandomEncounter(mapInfo.getlevel());

        }
    }
    
	/**
	  * This method will move the player in the maze, RIGHT a block.
	  * Checks for treasure, valid movement, and end of game status.
	  * @ params Mazeboard: the instance we are using of Mazeboard
	  * @ params Player: our instance of player
	  */
    public void moveRight(SavedData savedData, AmiiboLandGameMap mapInfo,AmiiboLandGameNPC npc,AmiiboLandGameItems items,Player playerInfo, AmiiboLandGameMapGUI gui)
    {
        playPostionArrayX = playerInfo.getXPosition();
		playPostionArrayY = playerInfo.getYPosition();
		
		//Changes the player sprite to facing right position.
		playerOrientation = "right";
        
		// Handles the collision detection. If the next position of of the maze is
        // a wall then the moveCalc will be passed 0,0 so that the character position does not change            
        if(mapInfo.validMovement(playPostionArrayX+1,playPostionArrayY) == false || npc.isValidMovement(playPostionArrayX+1, playPostionArrayY)==false || (items.isValidMovement(playPostionArrayX+1, playPostionArrayY,savedData,mapInfo)==false))
        {
            playerInfo.moveCalc(0,0);
        }
        else
        {
    	   	// Checks if the tile moved on has the element for the next value
    	   	mapInfo.levelChecker(savedData, playPostionArrayX+1,playPostionArrayY, gui);
            playerInfo.moveCalc(1,0);
            encounter.generateRandomEncounter(mapInfo.getlevel());
        }	
    }
    
	/**
	  * This method will move the player in the maze, LEFT a block.
	  * Checks for treasure, valid movement, and end of game status.
	  * @ params Mazeboard: the instance we are using of Mazeboard
	  * @ params Player: our instance of player
	  */
	 //BABESKI
    public void moveLeft(SavedData savedData, AmiiboLandGameMap mapInfo,AmiiboLandGameNPC npc,AmiiboLandGameItems items, Player playerInfo, AmiiboLandGameMapGUI gui)
    {
        playPostionArrayX = playerInfo.getXPosition();
		playPostionArrayY = playerInfo.getYPosition();
		
		//Changes the player sprite to facing left position.
		playerOrientation = "left";
		
        // Handles the collision detection. If the next position of of the maze is
        // a wall then the moveCalc will be passed 0,0 so that the character position does not change
        if(mapInfo.validMovement(playPostionArrayX-1,playPostionArrayY) == false || npc.isValidMovement(playPostionArrayX-1, playPostionArrayY)==false|| (items.isValidMovement(playPostionArrayX-1, playPostionArrayY,savedData,mapInfo)==false))
        {
            playerInfo.moveCalc(0,0);
        }
        else
        {
    	   	// Checks if the tile moved on has the element for the next value
    	   	mapInfo.levelChecker(savedData, playPostionArrayX-1,playPostionArrayY, gui);
            playerInfo.moveCalc(-1,0);
            encounter.generateRandomEncounter(mapInfo.getlevel());

        }
    }
    
    //BABESKI
	public LinkedList interaction(AmiiboLandGameMap mapInfo, Player playerInfo,AmiiboLandGameNPC npc,AmiiboLandGameItems items,String orientationInfo,SavedData savedData) throws FileNotFoundException, UnsupportedEncodingException 
	{
        playPostionArrayX = playerInfo.getXPosition();
		playPostionArrayY = playerInfo.getYPosition();
		
		//If the player sprite is facing up, then we want to interact with the position of (x,y+1)
		if(orientationInfo.equals("up"))
		{
			return mapInfo.interactionElement(playPostionArrayX, playPostionArrayY-1, savedData,npc,items);
		}
		

		else if(orientationInfo.equals("right"))
		{
			return mapInfo.interactionElement(playPostionArrayX+1, playPostionArrayY, savedData,npc,items);
		}
		

		else if(orientationInfo.equals("left"))
		{
			return mapInfo.interactionElement(playPostionArrayX-1, playPostionArrayY, savedData,npc,items);
		}
		else
		{
			return mapInfo.interactionElement(playPostionArrayX, playPostionArrayY+1, savedData,npc,items);
		}
		
	}
    
    
    //This method will get the current sprite orientation 
    //Facing down = 0, Facing right = 1, facing left = 2, facing up = 3
    public String getOrientation()
    {
    	
    	return playerOrientation;
    }
    
    //This method will determine if the player sprite is moving or not, moving = TRUE, not moving = FALSE
    public boolean getIsMoving()
    {
		return isMoving;
    	
    }
    
    //This method will set the isMoving to TRUE if moving and False otherwise 
    public void setIsMoving(String isMove)
    {
    	if(isMove.equals("move"))
    	{
    		isMoving = true;
    	}
    	else
    	{
    		isMoving = false;
    	}
    	
    }


}