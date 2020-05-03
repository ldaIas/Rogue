package rogueGame;

//All the types of weapons that the player may acquire
public enum Weapon {

	//All types adding to the players strength by the value passed in
	FISTS(0), DAGGER(1), SHORTSWORD(3), BROADSWORD(4), KATANA(6), CUTLASS(8), BLOODTHIRSTER(12, 2), STICK(999);
	
	private int weapDamage;
	private int lifesteal;
	
	Weapon(int damage){
		weapDamage = damage;
	}
	
	Weapon(int damage, int ls){
		weapDamage = damage;
		lifesteal = ls;
	}
	
}
