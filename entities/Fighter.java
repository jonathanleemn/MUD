package entities;

import world.Location;

public class Fighter extends Player
{
	
	public Fighter(String name, Location loc)
	{
		super(name, loc);
		setHealth(8);
		setHitRating(7);
		setDodgeChance(5);
		setDescription("A strong warrior who lets his strength do the talking");
	}

}
