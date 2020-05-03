package rogueGame;

import java.util.ArrayList;

public class Player extends Creature {

	private int level;
	private int exp;
	private char playerChar;
	
	//Armors handling
	private ArrayList<Armor> armors;
	private Armor currArmor;
	
	//Weapons handling
	private ArrayList<Weapon> weapons;
	private Weapon currWeapon;
	
	public Player() {
		super();
	}

	public Player(int x, int y) {
		super(20, 3);
		level = 0;
		exp = 0;
		
		armors = new ArrayList<Armor>();
		currArmor = Armor.NONE;
		
		weapons = new ArrayList<Weapon>();
		currWeapon = Weapon.FISTS;
		
		playerChar = 'P';
		move(x, y);
	}

	//The player takes damage. If the player is wearing armor, the damage is reduced by the armor's damage reduction amount.
	@Override
	public void takeDamage(int damage) {
		int hp = super.getHitPoints();
		
		int netDamage = damage - currArmor.getDamageReduction();
		if(netDamage < 0) netDamage = 0;
		
		hp -= damage;
		super.setHitPoints(hp);
	}
	
	@Override
	public void move(int x, int y) {
		super.setPosX(x);
		super.setPosY(y);
	}
	
	
	@Override
	public void dealDamage() {
		// TODO Auto-generated method stub
		
	}
	
	public char getChar() {
		return playerChar;
	}

	
	
}
