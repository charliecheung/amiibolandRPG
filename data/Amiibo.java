package data;

import java.util.Random;

public class Amiibo 
{
	public int index;
	public String amiiboName;
	public String amiiboClass;
	public String amiiboFranchise;
	public int amiiboLevel;
	public int currentExp;
	public int physicalAttack;
	public int statPhysical;
	public int specialAttack;
	public int statSpecial;
	public int currentHealth;
	public int maxHealth;
	public int physicalDefence;
	public int specialDefence;
	public int expNeeded;
	public String physicalName;
	public String specialName;
	public String identifierFirst;
	public String identifierSecond;
	public int obtained;
	public Random randomGenerator = new Random();
	public int toggleSelection = 0;
	public int battleType;

	public Amiibo(String[] amiiboData)
	{
		index = Integer.parseInt(amiiboData[0]);
		amiiboName = amiiboData[1];												//Get Amiibo Name
		amiiboClass = amiiboData[2];											//Get Fighter Class of Amiibo
		amiiboFranchise = amiiboData[3];										//Get Franchise Amiibo is from
		amiiboLevel = Integer.parseInt(amiiboData[4]);							//Get Amiibo Level
		currentExp = Integer.parseInt(amiiboData[5]);							//Get current exp
		physicalAttack = Integer.parseInt(amiiboData[6]);						//Get Physical Attack
		specialAttack = Integer.parseInt(amiiboData[7]);						//Get Special Attack
		currentHealth = Integer.parseInt(amiiboData[8]);						//Get current Health
		maxHealth = Integer.parseInt(amiiboData[9]);							//Get Max Health
		physicalDefence = Integer.parseInt(amiiboData[10]);						//Get Physical Defence
		specialDefence = Integer.parseInt(amiiboData[11]);						//Get Special Defence	
		physicalName = amiiboData[12];											//Physical Attack Name
		specialName = amiiboData[13];											//Special Attack Name
		identifierFirst = amiiboData[14];										//First identifier
		identifierSecond = amiiboData[15];										//Second identifier
		obtained = Integer.parseInt(amiiboData[16]);							//Stores of Amiibo has been obtained or not
		expNeeded = ((amiiboLevel * amiiboLevel) + (amiiboLevel * 3)) * 4;		//4(Level^2 + 3(Level))
	}
	
	public Amiibo()
	{
		
	}

	public void addExp(int exp)
	{
		currentExp = currentExp + exp;
		
		if (currentExp >= expNeeded)
		{
			currentExp = expNeeded - currentExp;
			amiiboLevel++;														//Increase level
			increaseStats();													//Increase stats
			setHealth(9999);													//Set health
			
			if (currentExp >= expNeeded)										//Check if leveled up multiple times
			{
				addExp(0);
			}
		}
	}
	
	public void setHealth(int healthAdjustment)
	{
		currentHealth = currentHealth + healthAdjustment;
		
		if (currentHealth >= maxHealth)
		{
			currentHealth = maxHealth;
		}
		else if (currentHealth <= 0)
		{
			currentHealth = 0;
		}
	}

	public void increaseStats()
	{
		maxHealth = maxHealth + randomNumber(3, 10);
		physicalAttack = physicalAttack + randomNumber(1, 5);
		specialAttack = specialAttack + randomNumber(1, 5);
		physicalDefence = physicalDefence + randomNumber(1, 5);
		expNeeded = ((amiiboLevel * amiiboLevel) + amiiboLevel + 3) * 4;		//4(Level^2 + 3(Level))
	}
	
	public void toggleSelection()
	{
		if (toggleSelection == 0)
		{
			toggleSelection = 1;
		}
		else
		{
			toggleSelection = 0;
		}
	}
	
	public String getString()
	{
		return (index + "," + amiiboName + "," + amiiboClass + "," + amiiboFranchise + "," + amiiboLevel + "," + currentExp + "," + physicalAttack + "," + specialAttack + "," + currentHealth + "," + maxHealth + "," + physicalDefence + "," + specialDefence + "," + physicalName + "," + specialName + "," + identifierFirst + "," + identifierSecond + "," + obtained);
	}
	
	public int randomNumber(int min, int max)
	{
		int value = randomGenerator.nextInt(max - min) + min;
		return value;
	}
	
}
