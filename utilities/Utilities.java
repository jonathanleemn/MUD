package utilities;

import java.util.Random;
import entities.Entity;

public class Utilities {

	// attack with ability modifier
		public int Attack(Entity attacker, Entity defender) {
			Random rand = new Random();
			int chance = 0;

			chance = rand.nextInt(attacker.getHitRating() - defender.getDodgeChance());
			
			try{if (rand.nextInt(chance) > 0)
				return (attacker.getAttack() - defender.getDefense());
			else
				return 0;
			}catch (NullPointerException error){
				// catches errors and just returns 0 damage
				return 0;
			}
		}

}
