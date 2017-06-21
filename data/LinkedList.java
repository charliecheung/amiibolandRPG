package data;

import amiibo.GUI.Dialogue;

public class LinkedList 
{
	Dialogue head = null;
	
	public LinkedList(Dialogue text)
	{
		head = text;
	}
	
	public void insert(Dialogue next)
	{
		if (head == null)
		{
			head = next;
		}
		
		else
		{
			Dialogue temp = head;
			while (temp.next != null)
			{
				temp = temp.next;
			}
			
			temp.next = next;
			temp.next.prev = temp;
		}
	}
	
	public Dialogue getHead()
	{
		return head;
	}
	
	public int getLength()
	{
		int i = 1;
		Dialogue temp = getHead();
		
		while (temp.next != null)
		{
			i++;
			temp = temp.next;
		}
		return i;
	}
}
