package items;

public class Weapon extends Item implements Equippable
{
	@Override
	public String toString()
	{
		return "Weapon [weaponBonus=" + weaponBonus + "]";
	}

	private int weaponBonus;
	
	public Weapon(String name, String description, int bonus)
	{
		super(name, description);
		setAttBonus(bonus);
	}

	private void setAttBonus(int bonus)
	{
		weaponBonus = bonus;
	}

	@Override
	public int getAttBonus()
	{
		return weaponBonus;
	}

	@Override
	public int getDefBonus()
	{
		return 0;
	}
	
}
