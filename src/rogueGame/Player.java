package rogueGame;

public class Player extends Creature {

	private int level;
	private int exp;

	public Player() {
		super();
	}

	public Player(int h, int s) {
		super(h, s);
		level = 0;
		exp = 0;
	}

	@Override
	public void takeDamage(int damage) {
		int hp = super.getHitPoints();
		hp -= damage;
		super.setHitPoints(hp);
	}

	
	
	@Override
	public void dealDamage() {
		// TODO Auto-generated method stub
		
	}

	
	
}
