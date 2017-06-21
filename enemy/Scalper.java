package enemy;

public class Scalper extends Enemy
{
	public Scalper() 
	{
		super();
		// TODO Auto-generated constructor stub
		setScalper();
	}
	
	public void setScalper()
	{
		amiiboName = "Brian";
		amiiboClass = "Gay";
		amiiboLevel = 100;
		physicalAttack = 1;
		statPhysical = 1;
		specialAttack = 1;
		statSpecial = 1;
		currentHealth = 1;
		maxHealth = 1;
		physicalDefence = 0;
		specialDefence = 0;
		physicalName = "Bitch slap";
		specialName = "Annoy";
		battleType = 0;
	}
	
	public void setClass()
	{
		int randomNum = randomNumber(1, 9);
		if (randomNum == 1)
		{
			amiiboClass = "Brawler";
		}
		else if (randomNum == 2)
		{
			amiiboClass = "Magic";
		}
		else if (randomNum == 3)
		{
			amiiboClass = "Princess";
		}
		else if (randomNum == 4)
		{
			amiiboClass = "Creature";
		}
		else if (randomNum == 5)
		{
			amiiboClass = "Magic";
		}
		else if (randomNum == 6)
		{
			amiiboClass = "Tech";
		}
		else if (randomNum == 7)
		{
			amiiboClass = "Mythical";
		}
		else if (randomNum == 8)
		{
			amiiboClass = "Nintendo";
		}
		else if (randomNum == 9)
		{
			amiiboClass = "Swordsman";
		}
	}
}
