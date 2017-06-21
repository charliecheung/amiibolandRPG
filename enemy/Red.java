package enemy;

public class Red extends Enemy
{
	public Red() 
	{
		super();
		// TODO Auto-generated constructor stub
		setRed();
	}
	
	public void setRed()
	{
		amiiboName = "Red";
		amiiboClass = "Pokemon";
		amiiboLevel = 100;
		physicalAttack = 10;
		statPhysical = 10;
		specialAttack = 10;
		statSpecial = 10;
		currentHealth = 10;
		maxHealth = 10;
		physicalDefence = 10;
		specialDefence = 10;
		physicalName = "Silence";
		specialName = "More Silence";
		battleType = 0;
	}
}
