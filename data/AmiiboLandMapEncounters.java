package data;


import java.util.Random;

/**
 * This Class will handle the random encounters in the game. The class will determine if a random monster will pop up for battle if you step on a tile. 
 * The Class will also randomly generate random rare monster which will give bonus experience. 
 * Last Modified: January 28, 2015
 * @author ANDREW DONG
 *
 */
public class AmiiboLandMapEncounters 
{
	//Maximum value of the random generated number
	private int randomEnemyMax = 15;
	private int randomEnemyRarity = 100;
	private Random randomEnemy = new Random();   
	private int enemyValue;
	private int enemyRareValue;

	/**
	 * This method will generate random monsters. Monsters can be rare or normal
	 * @param mapLevelName: Game level name passed in each map will yield different rarity of monsters 
	 */
	public void generateRandomEncounter(String mapLevelName)
	{
		switch(mapLevelName)
		{  
	        // switch statements so we can change the rarity of the monsters according to which map the player is in. Numbers can be change so that for X map
			// x monster will appear more or whatever we want for the game.
	       case "Street1":
	        	// We first generate a number between 0 and 15
	        	enemyValue = randomEnemy.nextInt(randomEnemyMax)+1;
	        	System.out.println(enemyValue);
	        	
	        	if(enemyValue == 15)
	        	{
	        		System.out.println("OMG BRIAN CAME OUT! GET READY TO BATTLE?!");
	        		// THis is the rarity of the enemy. If the enemy is rare he gives more exp at end of battle? 
	        		enemyRareValue = randomEnemy.nextInt(randomEnemyRarity)+1;
	        		if(enemyRareValue >= 90)
	        		{
	        			System.out.println("OMG RARE MONSTERRR BBG!");
	        		}
	        		else
	        		{
	        			System.out.println("LAME NORMAL MONSTER *SADFACE");
	        		}
	        		
	        	}
	        	
	          break;
	          
	       case "Street2":
	        	// We first generate a number between 0 and 15
	        	enemyValue = randomEnemy.nextInt(randomEnemyMax)+1;
	        	System.out.println(enemyValue);
	        	
	        	if(enemyValue == 15)
	        	{
	        		System.out.println("OMG BRIAN CAME OUT! GET READY TO BATTLE?!");
	        		// THis is the rarity of the enemy. If the enemy is rare he gives more exp at end of battle? 
	        		enemyRareValue = randomEnemy.nextInt(randomEnemyRarity)+1;
	        		if(enemyRareValue >= 90)
	        		{
	        			System.out.println("OMG RARE MONSTERRR BBG!");
	        		}
	        		else
	        		{
	        			System.out.println("LAME NORMAL MONSTER *SADFACE");
	        		}
	        		
	        	}
	        	
	          break;
	          
	       case "Street3":
	        	// We first generate a number between 0 and 15
	        	enemyValue = randomEnemy.nextInt(randomEnemyMax)+1;
	        	System.out.println(enemyValue);
	        	
	        	if(enemyValue == 15)
	        	{
	        		System.out.println("OMG BRIAN CAME OUT! GET READY TO BATTLE?!");
	        		// THis is the rarity of the enemy. If the enemy is rare he gives more exp at end of battle? 
	        		enemyRareValue = randomEnemy.nextInt(randomEnemyRarity)+1;
	        		if(enemyRareValue >= 90)
	        		{
	        			System.out.println("OMG RARE MONSTERRR BBG!");
	        		}
	        		else
	        		{
	        			System.out.println("LAME NORMAL MONSTER *SADFACE");
	        		}
	        		
	        	}
	        	
	          break;
	          
	       case "Street4":
	        	// We first generate a number between 0 and 15
	        	enemyValue = randomEnemy.nextInt(randomEnemyMax)+1;
	        	System.out.println(enemyValue);
	        	
	        	if(enemyValue == 15)
	        	{
	        		System.out.println("OMG BRIAN CAME OUT! GET READY TO BATTLE?!");
	        		// THis is the rarity of the enemy. If the enemy is rare he gives more exp at end of battle? 
	        		enemyRareValue = randomEnemy.nextInt(randomEnemyRarity);
	        		if(enemyRareValue >= 90)
	        		{
	        			System.out.println("OMG RARE MONSTERRR BBG!");
	        		}
	        		else
	        		{
	        			System.out.println("LAME NORMAL MONSTER *SADFACE");
	        		}
	        		
	        	}
	        	
	          break;
	       
	       case "BullsEye":
	        	// We first generate a number between 0 and 15
	        	enemyValue = randomEnemy.nextInt(randomEnemyMax)+1;
	        	System.out.println(enemyValue);
	        	
	        	if(enemyValue == 15)
	        	{
	        		System.out.println("OMG BRIAN CAME OUT! GET READY TO BATTLE?!");
	        		// THis is the rarity of the enemy. If the enemy is rare he gives more exp at end of battle? 
	        		enemyRareValue = randomEnemy.nextInt(randomEnemyRarity);
	        		if(enemyRareValue >= 90)
	        		{
	        			System.out.println("OMG RARE MONSTERRR BBG!");
	        		}
	        		else
	        		{
	        			System.out.println("LAME NORMAL MONSTER *SADFACE");
	        		}
	        		
	        	}
	        	
	          break;
	          
	       case "FloorStore":
	        	// We first generate a number between 0 and 15
	        	enemyValue = randomEnemy.nextInt(randomEnemyMax)+1;
	        	System.out.println(enemyValue);
	        	
	        	if(enemyValue == 15)
	        	{
	        		System.out.println("OMG BRIAN CAME OUT! GET READY TO BATTLE?!");
	        		// THis is the rarity of the enemy. If the enemy is rare he gives more exp at end of battle? 
	        		enemyRareValue = randomEnemy.nextInt(randomEnemyRarity);
	        		if(enemyRareValue >= 90)
	        		{
	        			System.out.println("OMG RARE MONSTERRR BBG!");
	        		}
	        		else
	        		{
	        			System.out.println("LAME NORMAL MONSTER *SADFACE");
	        		}
	        		
	        	}
	        	
	          break;
	       case "RainForest":
	        	// We first generate a number between 0 and 15
	        	enemyValue = randomEnemy.nextInt(randomEnemyMax)+1;
	        	System.out.println(enemyValue);
	        	
	        	if(enemyValue == 15)
	        	{
	        		System.out.println("OMG BRIAN CAME OUT! GET READY TO BATTLE?!");
	        		// THis is the rarity of the enemy. If the enemy is rare he gives more exp at end of battle? 
	        		enemyRareValue = randomEnemy.nextInt(randomEnemyRarity)+1;
	        		if(enemyRareValue >= 90)
	        		{
	        			System.out.println("OMG RARE MONSTERRR BBG!");
	        		}
	        		else
	        		{
	        			System.out.println("LAME NORMAL MONSTER *SADFACE");
	        		}
	        		
	        	}
	        	
	          break;
	       
	       case "Pallet Town":
	    	   	System.out.println("YO, BRIAN CAME OUT. And no scary monsters. yo.");

	        	// We first generate a number between 0 and 15
	        	/*
	    	   	enemyValue = randomEnemy.nextInt(randomEnemyMax)+1;
	        	System.out.println(enemyValue);
	        	
	        	if(enemyValue == 15)
	        	{
	        		System.out.println("OMG BRIAN CAME OUT! GET READY TO BATTLE?!");
	        		// THis is the rarity of the enemy. If the enemy is rare he gives more exp at end of battle? 
	        		enemyRareValue = randomEnemy.nextInt(randomEnemyRarity)+1;
	        		if(enemyRareValue >= 90)
	        		{
	        			System.out.println("OMG RARE MONSTERRR BBG!");
	        		}
	        		else
	        		{
	        			System.out.println("LAME NORMAL MONSTER *SADFACE");
	        		}
	        		
	        	}*/ 
	    	   	//Remove the comments above if you want encounters in Pallet town
	        	
	          break;
	          
	       case "WeRToys":
	        	// We first generate a number between 0 and 15
	        	enemyValue = randomEnemy.nextInt(randomEnemyMax)+1;
	        	System.out.println(enemyValue);
	        	
	        	if(enemyValue == 15)
	        	{
	        		System.out.println("OMG BRIAN CAME OUT! GET READY TO BATTLE?!");
	        		// THis is the rarity of the enemy. If the enemy is rare he gives more exp at end of battle? 
	        		enemyRareValue = randomEnemy.nextInt(randomEnemyRarity)+1;
	        		if(enemyRareValue >= 90)
	        		{
	        			System.out.println("OMG RARE MONSTERRR BBG!");
	        		}
	        		else
	        		{
	        			System.out.println("LAME NORMAL MONSTER *SADFACE");
	        		}
	        		
	        	}
	        	
	          break;
	          


	          
		 }
	}
	
}
