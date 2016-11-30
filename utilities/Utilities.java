package utilities;

import java.util.Random;
import entities.Entity;

public class Utilities {

	// attack with ability modifier
		public int Attack(Entity attacker, Entity defender) {
			Random rand = new Random();
			int chance = 0;

			chance = rand.nextInt(attacker.getHitRating() - defender.getDodgeChance());
			
			// try is left over from testing combat, but leaving for the very rare possible error
			try{if (chance > 0)
				return (attacker.getAttack() - defender.getDefense());
			else
				return 0;
			}
			catch (IllegalArgumentException error){
				return 0;
			}
		}

}
