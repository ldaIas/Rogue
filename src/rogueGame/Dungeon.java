package rogueGame;

import java.util.*;

public class Dungeon {

	private int numRooms;
	private final int MAX_LEVEL_SIZE = 5;
	private final  int MIN_LEVEL_SIZE = 3;
	private final int LEVEL_GRID_SIZE = 3;
	private Room[][] dungeonLayer;
	private Room currRoom;
	private ArrayList<Pathway> paths;
	
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
		dungeonLayer[1][1].setStart();
		currRoom = dungeonLayer[1][1];
		int numRoomsMade = 1;
		
		while(numRoomsMade < numRooms) {
			
				int randX = generateInt(0, LEVEL_GRID_SIZE);
				int randY = generateInt(0, LEVEL_GRID_SIZE);
				
				if(dungeonLayer[randX][randY] == null) {
					dungeonLayer[randX][randY] = new Room();
					numRoomsMade += 1;
				}		
		}
		
		createPaths();
	}
	
	//Generates paths/links between rooms in a dungeon level. 1 room can only have 2 links to different rooms
	public void createPaths() {
		paths = new ArrayList<Pathway>();
		Room currRoom = dungeonLayer[1][1];
		int numPaths = 0;
		
		while (numPaths < numRooms) {
			
			int randX = generateInt(0, LEVEL_GRID_SIZE);
			int randY = generateInt(0, LEVEL_GRID_SIZE);
			
			if( (dungeonLayer[randX][randY] != null) && (dungeonLayer[randX][randY].getNumPaths() < 2) ) {
				currRoom.addPath();
				Pathway path = new Pathway(currRoom, dungeonLayer[randX][randY]);
				paths.add(path);
				
				currRoom = dungeonLayer[randX][randY];
				currRoom.addPath();
			}	
		}	
	}
}
