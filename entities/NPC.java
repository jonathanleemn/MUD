package entities;

import java.util.Random;

public abstract class NPC extends Entity {

	public NPC(){
		setHealth(3);
		setHitRating(4);
		setDodgeChance(3);
		setName(getRandomName() + getRandomTitle());
	}
	
	public String getRandomName(){
		Random rand = new Random();
		String name = null;
		
		switch (rand.nextInt(4)+1){
		case 1:
			name = "M'iaq"; break;
		case 2: 
			name =  "Lira"; break;
		case 3: 
			name = "Kragus"; break;
		case 4:
			name = "Phenil"; break;
		}
		return name;
	}
	
	public String getRandomTitle(){
		Random rand = new Random();
		String title = null;
		
		switch (rand.nextInt(6)+1){
		case 1:
			title = " the weary"; break;
		case 2: 
			title =  " the welthy"; break;
		case 3:
			title = " the lost"; break;
		case 4:
			title = " the chicken chaser"; break;
		case 5:
			title = " the proud"; break;
		case 6:
			title = " the liar"; break;
		}
		return title;
	}
}
