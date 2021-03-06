package entities;

import java.util.Random;

import items.Inventory;
import world.Location;

public abstract class Entity
{
	private String name, description; // age, location may also be possible
	private int health, hitRating, dodgeChance;
	private Status status;
	private Location loc;
	public Inventory backpack = new Inventory();
	
	@Override
	public String toString()
	{
		return "Entity [name=" + name + ", description=" + description + ", health=" + health + ", hitRating="
				+ hitRating + ", dodgeChance=" + dodgeChance + ", status=" + status + ", loc=" + loc + "]";
	}

	public Entity()
	{
		this.name = getName();
		this.description = getDescription();
		this.health = getHealth();
		this.hitRating = getHitRating();
		this.dodgeChance = getDodgeChance();
		this.status = getStatus();
		this.loc = getLoc();
	}
	
	public Entity(String name, String description, int health, int hitRating, int dodgeChance, Status status, Location loc)
	{
		this.name = name;
		this.description = description;
		this.health = health;
		this.hitRating = hitRating;
		this.dodgeChance = dodgeChance;
		this.status = status;
		this.loc = loc;
	}
	
	public Location getLoc()
	{
		return loc;
	}
	
	public void setLoc(Location loc)
	{
		this.loc = loc;
	}

	public enum Status
	{
		ALIVE, DEAD
	}

	public void setStatus(Status in)
	{
		status = in;
	}

	public Status getStatus()
	{
		return status;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getDodgeChance()
	{
		return dodgeChance;
	}

	public void setDodgeChance(int dodgeChance)
	{
		this.dodgeChance = dodgeChance;
	}

	public int getHitRating()
	{
		return hitRating;
	}

	public void setHitRating(int hitRating)
	{
		this.hitRating = hitRating;
	}
	
	public int getAttack(){
		return backpack.getAttackBonus();
	}
	
	public int getDefense(){
		return backpack.getDefenseBonus();
	}

} // End
