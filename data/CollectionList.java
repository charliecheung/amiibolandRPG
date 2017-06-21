package data;
import amiibo.GUI.*;

public class CollectionList 
{
	public AmiiboCollection head = null;
	public AmiiboCollection amiibo;
	public AmiiboCollection current;
	
	public CollectionList(SavedData save)
	{
		for (int i = 0; i < 49; i++)
		{
			if (save.dataAmiibo[i].obtained == 1)
			{
				amiibo = new AmiiboCollection(save.dataAmiibo[i]);
				if (head == null)
				{
					head = amiibo;
				}
				
				else
				{
					current = getHead();
					while (current.next != null)
					{
						current = current.next;
					}
					amiibo.prev = current;
					current.next = amiibo;
				}
			}
		}
	}
	
	public CollectionList(Party party)
	{
		if (party.firstSlot.equals(party.blankAmiibo) == false)
		{
			head = new AmiiboCollection(party.firstSlot);
			if (party.secondSlot.equals(party.blankAmiibo) == false)
			{
				head.next = new AmiiboCollection(party.secondSlot);
				head.next.prev = head;
				if (party.thirdSlot.equals(party.blankAmiibo) == false)
				{
					head.next.next = new AmiiboCollection(party.thirdSlot);
					head.next.next.prev = head.next;
				}
			}
		}
		
	}
	
	public AmiiboCollection getImage(String index)
	{
		current = getHead();
		for (int i = 0; i < 49; i++)
		{
			if (index.equals(current.index))
			{
				i = 49;
			}
			else
			{
				current = current.next;
			}
		}
		return current;
	}
	
	public int getLength()
	{
		int i = 0;
		current = getHead();
		while ((current != null) &&(current.next != null))
		{
			i++;
			current = current.next;
		}
		i++;
		return i;
	}
	
	public AmiiboCollection getHead()
	{
		return head;
	}
	
	public void setCurrent()
	{
		current = getHead();
	}
}
