package rogueGame;

import java.util.*;

public class Room {

	private int width;
	private int height;
	
	private final int MAX_WIDTH = 20;
	private final int MAX_HEIGHT = 10;
	private final int MIN_SIZE = 7;
	private char[][] roomLines;
	
	public Room() {
		width = generateInt(MIN_SIZE, MAX_WIDTH);
		height = generateInt(MIN_SIZE, MAX_HEIGHT);
		
		roomLines = new char[height][width];
		generateRoom();
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
				else roomLines[i][j] = '.';
				
				//End the line if we have reached the width
				if(j == width - 1) {
					roomLines[i][j] = '\n';
					continue;
				}				
								
			}
		}
	}
	
	public void setStart() {
		int playerPosX = generateInt(1, MAX_WIDTH - 1);
		int playerPosY = generateInt(1, MAX_HEIGHT - 1);
		
		roomLines[playerPosX][playerPosY] = 'P';
		
		
	}
	
	
	public void printRoom() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print(roomLines[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {
		Room r = new Room();
		r.printRoom();
	}
}
