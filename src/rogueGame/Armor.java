package rogueGame;

//Different types of armors available to the player.
public enum Armor {
	
	//All types
	NONE(0), LEATHER(1), IRON(2), BRONZE(3), SILVER(5), GOLD(7), STEEL(10), KEVLAR(99);
	
	private int damageReduction;

	Armor(int armor) {
		damageReduction = armor;
	}
	
	public int getDamageReduction() {
		return damageReduction;
	}
	
	
}
