package inventory;

import java.util.ArrayList;

import utilities.Constants;

public class Inventory {
	private ArrayList<Equipable> equipableItems;
	private ArrayList<Consumable> consumableItems;
	private Equipable[] equippedItems;

	public Inventory(){
		equipableItems=new ArrayList<Equipable>();
		consumableItems=new ArrayList<Consumable>();
		equippedItems=new Equipable[Constants.PLAYER_EQUIP_SLOTS];
	}

	public void addEquipable(Equipable item){
		equipableItems.add(item);
	}

	public void addConsumable(Consumable item){
		consumableItems.add(item);
	}

	public Equipable removeEquipable(int index){
		return equipableItems.remove(index);
	}

	public Consumable removeConsumable(int index){
		return consumableItems.remove(index);
	}

	//equipItem
	public void equipItem(int item){
		Equipable toEquip=equipableItems.remove(item);
		if(toEquip instanceof Armor){
			equippedItems[0]=toEquip;
		}
		else if(toEquip instanceof Weapon)
			equippedItems[1]=toEquip;
		else
			equippedItems[2]=toEquip;
	}

	public void unequipItem(int index){
		if(equippedItems[index]!=null){
			equipableItems.add(equippedItems[index]);
			equippedItems[index]=null;
		}
	}

	//getters and setters
	public ArrayList<Equipable> getEquipableItems() {
		return equipableItems;
	}

	public void setEquipableItems(ArrayList<Equipable> equipableItems) {
		this.equipableItems = equipableItems;
	}

	@Override
	public String toString() {
		return "Inventory [equipableItems=" + equipableItems + "]";
	}



	public ArrayList<Consumable> getConsumableItems() {
		return consumableItems;
	}



	public void setConsumableItems(ArrayList<Consumable> consumableItems) {
		this.consumableItems = consumableItems;
	}

	public Equipable[] getEquippedItems() {
		return equippedItems;
	}

	public void setEquippedItems(Equipable[] equippedItems) {
		this.equippedItems = equippedItems;
	}

}
