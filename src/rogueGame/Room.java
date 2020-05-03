package rogueGame;

import java.util.*;

public class Room {

	private int width;
	private int height;
	
	private final int MAX_WIDTH = 20;
	private final int MAX_HEIGHT = 10;
	private final int MIN_SIZE = 7;
	private char[][] roomLines;
	private int numPaths;
	private Player player;
	private boolean updated;
	private final char FLOOR_CHAR = '.';
	
	public Room() {
		width = generateInt(MIN_SIZE, MAX_WIDTH);
		height = generateInt(MIN_SIZE, MAX_HEIGHT);
		
		roomLines = new char[height][width];
		generateRoom();
		numPaths = 0;
	}
	
	
	private int generateInt(int min, int max) {
		Random r = new Random();
		int randWidth = r.nextInt((max - min) + 1) + min;
		return randWidth;				
	}
	
	private void generateRoom() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				
				//If it is the edge of the room, mark with wall texture
				if( (i == 0) || (j == 0) ) roomLines[i][j] = '/';
				else if ( (i == height - 1) || (j == width - 2) ) roomLines[i][j] = '/';
				else roomLines[i][j] = FLOOR_CHAR;
				
				//End the line if we have reached the width
				if(j == width - 1) {
					roomLines[i][j] = '\n';
					continue;
				}				
								
			}
		}
	}
	
	//Set the room as the starting room. This is where the player will start, denoted "P"
	public void setStart() {
		int playerPosX = generateInt(2, width - 2);
		int playerPosY = generateInt(2, height - 2);
		
		player = new Player(playerPosX, playerPosY);				
	}
	
	public int getNumPaths() {
		return numPaths;
	}
	
	//Add a visible door to a path to the room. Doors are denoted "*" and only appear on the sides of the room
	public void addPath() {
		
		int wallX = generateInt(0, width);
		int wallY = generateInt(0, height);
		while( (wallX != 0) && (wallY != 0)) {
			wallX = generateInt(0, width);
			wallY = generateInt(0, height);
		}
		
		changeChar(wallY, wallX, '*');
		
		numPaths += 1;
	}
	
	public void movePlayer(int x, int y) {
		int playerX = player.getPosX();
		int playerY = player.getPosY();
		
		changeChar(playerY, playerX, FLOOR_CHAR);
		
		if( (x > 1) && (x < width - 1) ) playerX = x;
		if( (y > 1) && (y < height - 1) ) playerY = y;
		
		player.move(playerX, playerY);		
	}
	
	//Change a character in the room to the one passed in at the position passed in
	public void changeChar(int h, int w, char c) {
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				
				if( (i == h) && (j == w) ) roomLines[i][j] = c;
			}
		}	
	}
	
	public void update(boolean b) {
		updated = b;
	}
	
	public boolean wasUpdated() {
		return updated;
	}
	
	public void printRoom() {
		changeChar(player.getPosY(), player.getPosX(), player.getChar());
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print(roomLines[i][j]);
			}
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public static void main(String[] args) {
		Room r = new Room();
		r.setStart();
		r.printRoom();
	}
}
