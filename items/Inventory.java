package items;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory
{
	@Override
	public String toString()
	{
		return "Inventory [equippableItems=" + equippableItems + ", itemsEquipped=" + Arrays.toString(itemsEquipped)
				+ ", consumableItems=" + consumableItems + ", miscItems=" + miscItems + "]";
	}

	private ArrayList<Equippable> equippableItems;
	private Equippable[] itemsEquipped;
	private ArrayList<Consumable> consumableItems;
	private ArrayList<MiscItem> miscItems;
	
	public Inventory()
	{
		equippableItems = new ArrayList<Equippable>();
		consumableItems = new ArrayList<Consumable>();
		miscItems = new ArrayList<MiscItem>();
		itemsEquipped = new Equippable[2];
	}
	public void addMiscItemToInventory(MiscItem item)
	{
		miscItems.add(item);
	}
	
	public MiscItem removeMiscItemFromInventory(int index)
	{
		return miscItems.remove(index);		
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
		Equippable toEquip = equippableItems.remove(item);
		if(toEquip instanceof Armor)
		{
			itemsEquipped[0] = toEquip;
		}
		else if(toEquip instanceof Weapon)
		{
			itemsEquipped[1] = toEquip;
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
	
	public int getAttackBonus(){
		int total = 0;
		
		for (int i = 0; i < itemsEquipped.length; i++){
			try{total += itemsEquipped[i].getAttBonus();
			} catch (NullPointerException e){
				total += 0;
			}
		}
		
		return total;
	}
	
	public int getDefenseBonus(){
		int total = 0;
		
		for (int i = 0; i < itemsEquipped.length; i++){
			try{total += itemsEquipped[i].getDefBonus();
			} catch (NullPointerException e){
				total += 0;
			}
		}
		return total;
	}
	
}
