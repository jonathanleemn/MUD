package entities;

import world.Location;

public class Player extends Entity
{

	public Player(String name, Location loc)
	{
		setName(name);
		setLoc(loc);
		setStatus(Status.ALIVE);
	}


}
