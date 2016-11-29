package game;

import entities.Fighter;
import items.Armor;
import items.Inventory;
import items.MiscItem;
import items.Potion;
import items.Weapon;
import world.Location;

public class Game
{
	Fighter grognak = new Fighter("Grognak", new Location(10,0));
	Inventory backpack = new Inventory();
	Potion healthPotion = new Potion("Health Potion", "Restores 10 HP", 10);
	Weapon ironSword = new Weapon("Iron Sword", "An ordinary blade made of iron", 10);
	Armor leatherArmor = new Armor("Leather Armor", "An unassuming set of leather garbs", 5);
	MiscItem brassKey = new MiscItem("Brass Key", "A myterious key made of brass");

	public void playGame()
	{
		System.out.println(grognak.toString());
		backpack.addConsumableToInventory(healthPotion);
		backpack.addEquippableToInventory(ironSword);
		backpack.addEquippableToInventory(leatherArmor);
		backpack.addMiscItemToInventory(brassKey);
		// equips first item in array (sword)
		backpack.equipItem(0);
		// equips next item in array (armor)
		backpack.equipItem(0);
		// unequips armor
		backpack.unequipItem(0);
		// unequips weapon
		backpack.unequipItem(1);
		consumePotion();
		System.out.println(backpack.toString());

	}

	public void consumePotion()
	{
		backpack.removeConsumable(0);
		int health = grognak.getHealth() + 5;
		grognak.setHealth(health);
	}

}
