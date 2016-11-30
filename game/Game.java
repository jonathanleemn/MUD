package game;

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
import items.MiscItem;
import items.Potion;
import items.Weapon;
import utilities.Constants;
import world.Location;
import world.Map;

public class Game
{
	Fighter fighter = new Fighter("Grognak", new Location(0, 0));
	Mage mage = new Mage("Beatrice", new Location(0, 0));
	Rogue rogue = new Rogue("Minsc", new Location(0, 0));
	Player player = new Player("Player", new Location(0, 0));
	Monster monster = new Monster();
	QuestGiver questgiver = new QuestGiver();
	ShopKeep shopkeep = new ShopKeep();
	Skeleton skeleton = new Skeleton();
	Slime slime = new Slime();
	Useless uselessnpc = new Useless();
	Zombie zombie = new Zombie();
	Map map = new Map(player);

	Potion healthPotion = new Potion("Health Potion", "Restores 10 HP", 10);
	Weapon ironSword = new Weapon("Iron Sword", "An ordinary blade made of iron", 10);
	Armor leatherArmor = new Armor("Leather Armor", "An unassuming set of leather garbs", 5);
	MiscItem brassKey = new MiscItem("Brass Key", "A mysterious key made of brass");
	Scanner input = new Scanner(System.in);

	public void playGame()
	{
		selectAClass();
		System.out.println("Name: " + player.getName() + "\nDescription: " + player.getDescription() + "\nHealth: "
				+ player.getHealth() + "\nHit Rating: " + player.getHitRating() + "\nDodge Chance: "
				+ player.getDodgeChance());
		System.out.println();
		player.backpack.addConsumableToInventory(healthPotion);
		player.backpack.addEquippableToInventory(ironSword);
		player.backpack.addEquippableToInventory(leatherArmor);
		while (!player.backpack.miscItems.contains(brassKey))
			chooseCommand();
	}

	public void chooseCommand()
	{
		System.out.println(map.getLoc());
		System.out.println("Commands: Inventory - Consume - Equip - Unequip - Move - Map");
		System.out.print("What do you want to do? ");
		String command = input.next();
		if (command.equalsIgnoreCase("Inventory"))
		{
			System.out.println(player.backpack.toString());
		} else if (command.equalsIgnoreCase("Consume"))
		{
			consumePotion();
		} else if (command.equalsIgnoreCase("Equip"))
		{
			try
			{
				System.out.print("Enter the index of the item you wish to equip: ");
				int itemCommand = input.nextInt();
				player.backpack.equipItem(itemCommand);

				System.out.println(player.backpack.getEquipped());
			} catch (IndexOutOfBoundsException e)
			{
				System.out.println("No item in that index.");
			}

		} else if (command.equalsIgnoreCase("Unequip"))
		{
			try
			{
				System.out.print("Enter the index of the item you wish to unequip: ");
				int itemCommand = input.nextInt();
				player.backpack.unequipItem(itemCommand);
				System.out.println(player.backpack.getEquipped());
			} catch (IndexOutOfBoundsException e)
			{
				System.out.println("No item in that index.");
			}
		} else if (command.equalsIgnoreCase("Move"))
		{
			map.makeMove();
		} else if (command.equalsIgnoreCase("Map"))
		{
			displayMap();
		} else
		{
			System.out.println("You can't do that.");
		}
		System.out.println();
	}

	public void displayMap()
	{
		map.drawMap();
	}

	public void consumePotion()
	{
		try
		{
			player.backpack.removeConsumable(0);
			int health = player.getHealth() + Constants.HP_POTION;
			player.setHealth(health);
			System.out.println("You drink a health potion.");
		} catch (IndexOutOfBoundsException e)
		{
			System.out.println("No potions in backpack.");
		}
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
