package entities;

public class Mage extends Player {

	public Mage(String name) {
		super(name);
		setHealth(4);
		setHitRating(9);
		setDodgeChance(7);
		setDescription("A master of harnessing the elements");
	}
	
	public void displaySpells(){
		System.out.println("Fireball");
		System.out.println("Cone of Cold");
		System.out.println("Rock Spire");
		System.out.println("Wind Blade");
	}

}
