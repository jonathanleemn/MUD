package entities;

import java.util.Random;

public class Zombie extends Monster {

	public Zombie() {
		setHealth(3);
		setHitRating(4);
		setDodgeChance(3);
		setDescription(getRandomDescription());
	}
	
	public String getRandomDescription(){
		Random rand = new Random();
		String description = null;
		
		switch (rand.nextInt(4)+1){
		case 1:
			description = "A heavily decayed zombie. You can barely tell it was once human"; break;
		case 2:
			description =  "A decrepit zombie, it looks weak"; break;
		case 3:
			description =  "A feral looking zombie, try not to get bitten"; break;
		case 4:
			description =  "A zombie wearing what looks like a red jacket?"; break;
		}
		return description;
	}
}
