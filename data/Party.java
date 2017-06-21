package data;

import java.io.FileNotFoundException;

public class Party 
{
	String[] blank = {"-1","Name","Class","Franchise","0","0","0","0","0","0","0","0","Primary","Special","00000000","00000000","0"};
	public Amiibo blankAmiibo = new Amiibo(blank);
	public Amiibo firstSlot = blankAmiibo;
	public Amiibo secondSlot = blankAmiibo;
	public Amiibo thirdSlot = blankAmiibo;

	public Party()
	{
	}
	
	public Party(Amiibo first)
	{
		firstSlot = first;
	}
	
	public Party(Amiibo first, Amiibo second)
	{
		firstSlot = first;
		secondSlot = second;
	}
	
	public Party(Amiibo first, Amiibo second, Amiibo third)
	{
		firstSlot = first;
		
		if (second != null)
		{
			secondSlot = second;
		}
		else
		{
			secondSlot = blankAmiibo;
		}
		
		if (third != null)
		{
			thirdSlot = third;
		}
		else
		{
			thirdSlot = blankAmiibo;;
		}
	}
	
	public void add(Amiibo amiibo) throws FileNotFoundException
	{
		if (firstSlot.equals(blankAmiibo))										//If Party is empty
		{
			firstSlot = amiibo;
		}
		else if (secondSlot.equals(blankAmiibo))									//If Party has 1 people
		{
			secondSlot = amiibo;
		}
		else if (thirdSlot.equals(blankAmiibo))	
		{
			thirdSlot = amiibo;
		}
		else
		{
		}
	}
	
	public boolean checkHealth()
	{
		if ((firstSlot.currentHealth <= 0) && (secondSlot.currentHealth <= 0) && (thirdSlot.currentHealth <= 0))
		{
			return false;											//dead
		}
		else
		{
			return true;											//true
		}
	}
	
	public Party switchMembers(Amiibo first, Amiibo second)
	{
		if (firstSlot == first)
		{
			if (secondSlot == second)
			{
				firstSlot = second;
				secondSlot = first;
			}
			
			else if (thirdSlot == second)
			{
				firstSlot = second;
				thirdSlot = first;
			}
		}
		
		else if (secondSlot == first)
		{
			if (firstSlot == second)
			{
				secondSlot = second;
				firstSlot = first;
			}
			
			else if (thirdSlot == second)
			{
				secondSlot = second;
				thirdSlot = first;
			}
		}
		
		else if (thirdSlot == first)
		{
			if (firstSlot == second)
			{
				thirdSlot = second;
				firstSlot = first;
			}
			
			else if (secondSlot == second)
			{
				thirdSlot = second;
				secondSlot = first;
			}
		}
		
		return this;
	}
	
	public void heal()
	{
		if (firstSlot.equals(blankAmiibo) == false)
		{
			firstSlot.currentHealth = firstSlot.maxHealth;
		}
		
		if (secondSlot.equals(blankAmiibo) == false)
		{
			secondSlot.currentHealth = secondSlot.maxHealth;
		}
		
		if (thirdSlot.equals(blankAmiibo) == false)
		{
			thirdSlot.currentHealth = thirdSlot.maxHealth;
		}
	}
	
	public boolean ifHurt()
	{
		boolean hurt = false;
		if ((firstSlot.equals(blankAmiibo) == false) && (firstSlot.currentHealth < firstSlot.maxHealth))
		{
			hurt = true;
		}
		
		if ((secondSlot.equals(blankAmiibo) == false) && (secondSlot.currentHealth < secondSlot.maxHealth))
		{
			hurt = true;
		}
		
		if ((thirdSlot.equals(blankAmiibo) == false) && (thirdSlot.currentHealth < thirdSlot.maxHealth))
		{
			hurt = true;
		}
		
		return hurt;
	}
}
