package rogueGame;

import java.util.*;

public class Dungeon {

	private int numRooms;
	private final int MAX_LEVEL_SIZE = 5;
	private final  int MIN_LEVEL_SIZE = 3;
	private final int LEVEL_GRID_SIZE = 3;
	private Room[][] dungeonLayer;
	
	public Dungeon() {
		
		numRooms = generateInt(MAX_LEVEL_SIZE, MIN_LEVEL_SIZE);
		dungeonLayer = new Room[LEVEL_GRID_SIZE][LEVEL_GRID_SIZE];
		generateLayout();
	}
	
	//Create a random integer to be used for the number of rooms
	private int generateInt(int max, int min) {
		Random r = new Random();
		int randInt = r.nextInt(max - min + 1) + min;
		return randInt;
	}
	
	//Generate the layout of this level of the dungeon
	private void generateLayout() {
		
		for(int i = 0; i < LEVEL_GRID_SIZE; i++) {
			for(int j = 0; j < LEVEL_GRID_SIZE; j++) {
				dungeonLayer[i][j] = null;
			}
		}
		dungeonLayer[1][1] = new Room();
		int currRooms = 1;
		
		while(currRooms < numRooms) {
			
				int randX = generateInt(0, LEVEL_GRID_SIZE);
				int randY = generateInt(0, LEVEL_GRID_SIZE);
				
				if(dungeonLayer[randX][randY] == null) {
					dungeonLayer[randX][randY] = new Room();
					currRooms += 1;
				}		
		}
		
	}
}
