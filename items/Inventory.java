package items;

import java.util.ArrayList;

public class Inventory
{
	private ArrayList<Equippable> equippableItems;
	private Equippable[] itemsEquipped;
	private ArrayList<Consumable> consumableItems;
	
	public Inventory()
	{
		equippableItems = new ArrayList<Equippable>();
		itemsEquipped = new Equippable[2];
		consumableItems = new ArrayList<Consumable>();
	}
	
	public void addEquippableToInventory(Equippable item)
	{
		equippableItems.add(item);
	}
	
	public Equippable removeEquippableFromInventory(int index)
	{
		return equippableItems.remove(index);
	}
	
	public void addConsumableToInventory(Consumable item)
	{
		consumableItems.add(item);
	}
	
	public void equipItem(int item)
	{
		Equippable equippableItem = equippableItems.remove(item);
		if(equippableItem instanceof Armor)
		{
			itemsEquipped[0] = equippableItem;
		}
		else if(equippableItem instanceof Weapon)
		{
			itemsEquipped[1] = equippableItem;
		}
	}
	
	public Consumable removeConsumable(int index)
	{
		return consumableItems.remove(index);
	}
	
	public ArrayList<Consumable> getConsumableItems()
	{
		return consumableItems;
	}

	public void setConsumableItems(ArrayList<Consumable> consumableItems)
	{
		this.consumableItems = consumableItems;
	}

	public void unequipItem(int index)
	{
		if(itemsEquipped[index] != null)
		{
			equippableItems.add(itemsEquipped[index]);
			itemsEquipped[index] = null;
		}
	}

	public ArrayList<Equippable> getEquippableItems()
	{
		return equippableItems;
	}

	public void setEquippableItems(ArrayList<Equippable> equippableItems)
	{
		this.equippableItems = equippableItems;
	}

	public Equippable[] getItemsEquipped()
	{
		return itemsEquipped;
	}

	public void setItemsEquipped(Equippable[] itemsEquipped)
	{
		this.itemsEquipped = itemsEquipped;
	}
}
