package entities;

public class Fighter extends Player {

	public Fighter(String name) {
		super(name);
		setHealth(8);
		setHitRating(7);
		setDodgeChance(5);
		setDescription("A strong warrior who lets his strength do the talking");
	}



}
