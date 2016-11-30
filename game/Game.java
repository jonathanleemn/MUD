package game;

import java.util.Arrays;
import java.util.Scanner;
import entities.Fighter;
import entities.Mage;
import entities.Monster;
import entities.Player;
import entities.QuestGiver;
import entities.Rogue;
import entities.ShopKeep;
import entities.Skeleton;
import entities.Slime;
import entities.Useless;
import entities.Zombie;
import items.Armor;
import items.Inventory;
import items.MiscItem;
import items.Potion;
import items.Weapon;
import utilities.Util;
import world.Location;

public class Game
{
	Fighter fighter = new Fighter("Grognak", new Location(10, 10));
	Mage mage = new Mage("Beatrice", new Location(10, 10));
	Rogue rogue = new Rogue("Minsc", new Location(10, 10));
	Player player = new Player("Player", new Location(10, 10));
	Monster monster = new Monster();
	QuestGiver questgiver = new QuestGiver();
	ShopKeep shopkeep = new ShopKeep();
	Skeleton skeleton = new Skeleton();
	Slime slime = new Slime();
	Useless uselessnpc = new Useless();
	Zombie zombie = new Zombie();

	Inventory backpack = new Inventory();
	Potion healthPotion = new Potion("Health Potion", "Restores 10 HP", 10);
	Weapon ironSword = new Weapon("Iron Sword", "An ordinary blade made of iron", 10);
	Armor leatherArmor = new Armor("Leather Armor", "An unassuming set of leather garbs", 5);
	MiscItem brassKey = new MiscItem("Brass Key", "A mysterious key made of brass");
	Scanner input = new Scanner(System.in);

	public void playGame()
	{
		selectAClass();
		System.out.println("Name: " +  player.getName()+ "\nDescription: " + player.getDescription() + 
				"\nHealth: " + player.getHealth() + "\nHit Rating: " + player.getHitRating() +
				"\nDodge Chance: " + player.getDodgeChance());
		System.out.println();
		backpack.addConsumableToInventory(healthPotion);
		backpack.addEquippableToInventory(ironSword);
		backpack.addEquippableToInventory(leatherArmor);
		chooseCommand();	
	}
	
	public void chooseCommand()
	{
		System.out.println(player.getLoc());
		System.out.println("Commands: Inventory - Consume - Equip - Unequip - Move");
		System.out.print("What do you want to do? ");
		String command = input.next();
		if (command.equalsIgnoreCase("Inventory"))
		{
			System.out.println(backpack.toString());
		} else if (command.equalsIgnoreCase("Consume"))
		{
			consumePotion();
			System.out.println("You drink a health potion.");
		} else if (command.equalsIgnoreCase("Equip"))
		{
			// equips first item in array (sword)
			backpack.equipItem(0);
			// equips next item in array (armor)
			backpack.equipItem(0);
			
			System.out.println(backpack.getEquipped());

		} 
		else if (command.equalsIgnoreCase("Unequip"))
		{
			// unequips armor
			backpack.unequipItem(Util.ARMOR_SLOT);
			// unequips weapon
			backpack.unequipItem(Util.WEAPON_SLOT);
			System.out.println("You unequip your weapon and armor.");
		}
		else if(command.equalsIgnoreCase("Move"))
		{
			
		}
		else
		{
			System.out.println("You can't do that.");
		}
	}

	public void consumePotion()
	{
		backpack.removeConsumable(0);
		int health = player.getHealth() + Util.HP_POTION;
		player.setHealth(health);
	}

	public void selectAClass()
	{
		String classSelect;
		do
		{
			System.out.print("Select a class (Fighter, Mage, Rogue): ");
			classSelect = input.next();
			if (classSelect.equalsIgnoreCase("fighter"))
			{
				player = fighter;
			} else if (classSelect.equalsIgnoreCase("mage"))
			{
				player = mage;
			} else if (classSelect.equalsIgnoreCase("rogue"))
			{
				player = rogue;
			}
		} while (!(classSelect.equalsIgnoreCase("fighter") || classSelect.equalsIgnoreCase("mage")
				|| classSelect.equalsIgnoreCase("rogue")));

	}
}
