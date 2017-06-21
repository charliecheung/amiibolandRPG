package amiibo.GUI;
import data.*;

public class Dialogue 
{
	public String text;
	public String name;
	public Dialogue next = null;
	public Dialogue prev = null;
	public PlaySound sound = null;
	public boolean soundPlayed = false;
	
	public Dialogue(String textFile, String name, PlaySound sound)
	{
		this.text = textFile;
		this.name = name;
		this.sound = sound;
	}
	
	public void saving(AmiiboLandGameMapGUI gameMap)
	{
		Dialogue dialogue = new Dialogue("Saving Game...", "", null);
		LinkedList linkedList = new LinkedList(dialogue);
		dialogue = new Dialogue("Done!", null, null);
		linkedList.insert(dialogue);
		dialogue = new Dialogue("done", null, null);
		linkedList.insert(dialogue);
		
		gameMap.inDialogue = true;
		gameMap.current = linkedList.getHead();
	}
	
	public void attack(AmiiboLandGameMapGUI gameMap, int attackType, Amiibo amiibo)
	{
		if (attackType == 0)
		{
			Dialogue dialogue = new Dialogue(amiibo.amiiboName + " used " + amiibo.physicalName + "!", "", null);
			LinkedList linkedList = new LinkedList(dialogue);
			//It was super effective or nah
			dialogue = new Dialogue("done", null, null);
			linkedList.insert(dialogue);
			
			gameMap.inDialogue = true;
			gameMap.current = linkedList.getHead();
		}
		else
		{
			Dialogue dialogue = new Dialogue(amiibo.amiiboName + " used " + amiibo.specialName + "!", "", null);
			LinkedList linkedList = new LinkedList(dialogue);
			//It was super effective or nah
			dialogue = new Dialogue("done", null, null);
			linkedList.insert(dialogue);
			
			gameMap.inDialogue = true;
			gameMap.current = linkedList.getHead();
		}
	}
	
	public void incorrectUsage(AmiiboLandGameMapGUI gameMap)
	{
		Dialogue dialogue = new Dialogue("This isn't the time to use that!", "Prof. Oak", null);
		LinkedList linkedList = new LinkedList(dialogue);
		dialogue = new Dialogue("done", null, null);
		linkedList.insert(dialogue);
		
		gameMap.inDialogue = true;
		gameMap.current = linkedList.getHead();
	}
	
	public void insufficientQuantity(AmiiboLandGameMapGUI gameMap)
	{
		Dialogue dialogue = new Dialogue("You do not have enough!", "Prof. Oak", null);
		LinkedList linkedList = new LinkedList(dialogue);
		dialogue = new Dialogue("done", null, null);
		linkedList.insert(dialogue);
		
		gameMap.inDialogue = true;
		gameMap.current = linkedList.getHead();
		System.out.println("2");
	}
	
	public void flee(AmiiboLandGameMapGUI gameMap, int battleType)
	{
		if (battleType == 0)
		{
			Dialogue dialogue = new Dialogue("You ran away!", "", null);
			LinkedList linkedList = new LinkedList(dialogue);
			dialogue = new Dialogue("done", null, null);
			linkedList.insert(dialogue);
			
			gameMap.inDialogue = true;
			gameMap.current = linkedList.getHead();
		}
		else
		{
			Dialogue dialogue = new Dialogue("You can't flee.. You pussy", "Prof. Oak", null);
			LinkedList linkedList = new LinkedList(dialogue);
			dialogue = new Dialogue("done", null, null);
			linkedList.insert(dialogue);
			
			gameMap.inDialogue = true;
			gameMap.current = linkedList.getHead();
		}
	}
}
