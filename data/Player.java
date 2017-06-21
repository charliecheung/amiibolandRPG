package data;

/** 
  * Last updated: April 10th, 2014 
  * This class contains the logic part of the movement of the game
  * This class calculates the players current position and next position.
  */
public class Player
{
	// setting the initial starting spot of the player, declares the variable
	private int xPosition = 0;
	private int yPosition = 0;

	/**
	  * Default constructor sets the player position to the starting position of the game [1][1]
	  * on the mapArray in the MazeBoard class
	  */
	public Player(String location)
	{
        // initializing the starting position of the character.
		String[] coordinates = new String[2];
		coordinates = location.split(",");
        xPosition = Integer.parseInt(coordinates[0]);
        yPosition = Integer.parseInt(coordinates[1]);
	}
	
	public void forceMove(int x, int y)
	{
		xPosition = x;
		yPosition = y;
	}

	/** 
	  * This method handles all the calculation of the movement. 
	  * @param xcoord how much to move in the x direction
	  * @param ycoord how much to move in the y direction
	  */
	public void moveCalc(int xcoord, int ycoord)
	{
        xPosition = xPosition + xcoord;
        yPosition = yPosition + ycoord;
	}
	
	/**
	  * This method returns the current xPostion
	  * @return xPosition current x position of the character.
	  */
	public int getXPosition()
	{
		
		return xPosition;
	}
	
	/**
	  * This method returns the current xPostion
	  * @return xPosition current x position of the character.
	  */
	public int getYPosition()
	{
		
		return yPosition;
	}

}
