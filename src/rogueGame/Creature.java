package rogueGame;

//This is the parent class for all creatures (monsters and human players).
//It assigns the health and strength of each creature
public abstract class Creature {

	private int hitPoints;
	private int strength;
	private int posX;
	private int posY;

	public Creature() {
		hitPoints = 0;
		strength = 0;
	}
	
	public Creature(int h, int s) {
		hitPoints = h;
		strength = s;
	}
	
	public abstract void takeDamage(int damage);
	
	public abstract void dealDamage();
	
	public abstract void move(int x, int y);
	
	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
}
