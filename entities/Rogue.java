package entities;

public class Rogue extends Player {

	public Rogue(String name) {
		super(name);
		setHealth(5);
		setHitRating(7);
		setDodgeChance(8);
		setDescription("A rogue who wanders the shadows as though they are sunlit streets");
	}

}
