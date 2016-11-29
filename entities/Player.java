package entities;

public class Player extends Entity
{

	public Player(String name)
	{
		setName(name);
		setStatus(Status.ALIVE);
	}


}
