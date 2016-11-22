package entities;

import java.util.Random;

public class Skeleton extends Monster{

	public Skeleton(){
		setName("Skeleton");
		setHealth(4);
		setHitRating(5);
		setDodgeChance(4);
		setDescription(getRandomDescription());
	}
	
	public String getRandomDescription(){
		Random rand = new Random();
		String description = null;
		
		switch (rand.nextInt(4)+1){
		case 1:
			description = "A normal skeleton, nothing to worry about"; break;
		case 2:
			description =  "A brittle looking skeleton"; break;
		case 3:
			description =  "A skeleton is using his arm as a sword"; break;
		case 4:
			description =  "A skeleton with dark bones. how unusual"; break;
		}
		return description;
	}
}
