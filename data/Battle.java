package data;

import java.util.Random;

import amiibo.GUI.AmiiboLandGameMapGUI;

public class Battle 
{
	public Party foe;
	public Party player;
	Random randomGenerator = new Random();
	
	public Battle(Party foe, Party player)
	{
		this.foe = foe;
		this.player = player;
	}
	
	public int damageCalculator(String attackingClass, String defendingClass, int attack, int defence)
	{
		int damage = ((attack * typeEffective(attackingClass, defendingClass)) - defence);
		if (damage <= 0)
		{
			damage = 1;
		}
		return damage;
	}
	
	public void fight(Amiibo one, Amiibo two)
	{
		
	}
	
	public boolean flee(AmiiboLandGameMapGUI gameMap)
	{
		gameMap.dialogue.flee(gameMap, foe.firstSlot.battleType);
		if (foe.firstSlot.battleType == 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public int expCalculator(Amiibo amiibo)
	{
		int levelDif = amiibo.amiiboLevel - foe.firstSlot.amiiboLevel;
		if (levelDif <= 0)
		{
			levelDif = 1;
		}
		
		int exp = ((foe.firstSlot.physicalAttack + foe.firstSlot.physicalDefence + foe.firstSlot.specialAttack + foe.firstSlot.specialDefence + foe.firstSlot.maxHealth) ^ (levelDif));
		return exp;
	}
	
	public int typeEffective(String attacking, String defending)
	{
		if ((attacking == "Nintendo") && (defending == "Pokemon"))
		{
			return 2;
		}

		else if ((attacking == "Pokemon") && (defending == "Mythical"))
		{
			return 2;
		}
		
		else if ((attacking == "Mythical") && (defending == "Tech"))
		{
			return 2;
		}
		
		else if ((attacking == "Tech") && (defending == "Creature"))
		{
			return 2;
		}
		
		else if ((attacking == "Creature") && (defending == "Brawler"))
		{
			return 2;
		}
		
		else if ((attacking == "Brawler") && (defending == "Nintendo"))
		{
			return 2;
		}
		
		else
		{
			return 1;
		}
	}
}
