package items;
import data.Amiibo;
import data.SavedData;

public class Inventory
{	
	Mushroom mushroom;
	MegaMushroom megaMushroom;
	HeartContainer heartContainer;
	SpecialFlag specialFlag;
	OneUpMushroom oneUpMushroom;
	Item head;
	
	
	public Inventory(SavedData data)
	{
		mushroom = new Mushroom(data);
		megaMushroom = new MegaMushroom(data);
		heartContainer = new HeartContainer(data);
		specialFlag = new SpecialFlag(data);
		oneUpMushroom = new OneUpMushroom(data);
		head = mushroom;
		
		//Initialize linked list
		mushroom.prev = oneUpMushroom;
		
		mushroom.next = megaMushroom;
		megaMushroom.prev = mushroom;
		
		megaMushroom.next = heartContainer;
		heartContainer.prev = megaMushroom;
		
		heartContainer.next = specialFlag;
		specialFlag.prev = heartContainer;
		
		specialFlag.next = oneUpMushroom;
		oneUpMushroom.prev = specialFlag;
		
		oneUpMushroom.next = mushroom;
	}
	
	public void add(String item)
	{
		if (item.equals("Mushroom"))
		{
			mushroom.add();
		}
		else if (item.equals("Mega Mushroom"))
		{
			megaMushroom.add();
		}
		else if (item.equals("Heart Container"))
		{
			heartContainer.add();
		}
		else if (item.equals("Special Flag"))
		{
			specialFlag.add();
		}
		else if (item.equals("1-Up Mushroom"))
		{
			oneUpMushroom.add();
		}
	}
	
	public Item getHead()
	{
		return head;
	}
}
