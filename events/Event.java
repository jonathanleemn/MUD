package events;

import entities.Zombie;

public class Event
{
	public void monsterRoom()
	{
		System.out.println("You encounter a zombie.");
	}
	
	public void emptyRoom()
	{
		System.out.println("There is nothing of interest here.");
	}
	
	public void npcRoom()
	{
		System.out.println("You encounter a sheepish looking man.");
	}
	
	public void itemRoom()
	{
		System.out.println("You find an item. ");
		
	}
	
}
