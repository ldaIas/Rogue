package rogueGame;

import java.awt.event.*;
import java.io.IOException;

public class RogueGame{

	Room currRoom;
	Player player;
	
	public RogueGame() {
		
		Dungeon dungeon = new Dungeon();
		currRoom = dungeon.getCurrRoom();
		currRoom.printRoom();
		player = currRoom.getPlayer();
		
		while(true) {
			try {
				processMove();			
			}
			catch (Exception e) {
				System.out.print("Error reading input");
			}
		}
		
	}
	
	public void processMove() throws IOException {
		char input = (char) System.in.read();
		switch(input) {
		case 'w':
			currRoom.movePlayer(player.getPosX(), player.getPosY() + 1);
			System.out.println("Move: " + input);
			currRoom.update(true);
			break;
			
		case 'a':
			currRoom.movePlayer(player.getPosX() - 1, player.getPosY());
			System.out.println("Move: " + input);
			currRoom.update(true);
			break;
			
		case 's':
			currRoom.movePlayer(player.getPosX(), player.getPosY() - 1);
			System.out.println("Move: " + input);
			currRoom.update(true);
			break;
			
		case 'd':
			currRoom.movePlayer(player.getPosX() + 1, player.getPosY());
			System.out.println("Move: " + input);
			currRoom.update(true);
			break;
			
		default:
			break;		
		}
		
		if(currRoom.wasUpdated()) {
			currRoom.printRoom();
			currRoom.update(false);
		}
		
	}

	public static void main(String[] args) {
		
		RogueGame g = new RogueGame();
		
	}



}
