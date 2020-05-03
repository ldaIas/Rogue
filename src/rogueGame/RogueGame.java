package rogueGame;

public class RogueGame {

	public RogueGame() {
		
		Dungeon dungeon = new Dungeon();
		Room currRoom = dungeon.getCurrRoom();
		currRoom.printRoom();
		
	}
	
	
	
	public static void main(String[] args) {
		
		RogueGame g = new RogueGame();
		
	}
}
