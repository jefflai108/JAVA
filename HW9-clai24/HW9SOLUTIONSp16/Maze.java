import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Intro to Programming, 600.107, Spring 2016, HW9
 *
 * @author Sara More, based on initial code by Katie Calabro
 *
 */
public class Maze {

	/** The maze */
	private char[][] maze;

	/** Mario's position */
	private int[] mario;  //stored in an array of size 2

	/** The ending position */
	private int[] end;  //stored in an array of size 2

	/** The number of mushrooms currently in the maze */
	private int numMushroomsLeft; //can't end until this becomes 0

	/** The number of moves made */
	private int numMoves;

	/**
	 * Creates a new maze from a file.
	 *
	 * @param filename
	 *            the name of the file
	 * @throws IOException
	 */
	public Maze(String filename) throws IOException {
    
		//Collect number of rows, columns and mushrooms from top line
		Scanner fromFile = new Scanner(new FileReader(filename));
		int rows = fromFile.nextInt();
		int cols = fromFile.nextInt();
		numMushroomsLeft = fromFile.nextInt();

		//remove the remaining new line character in the top line
		fromFile.nextLine();

		//Create 2D array and populate it with maze details,
		//track location of Mario and of target position 'X'
		maze = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
        
			//Collect one line at a time from input file
			String line = fromFile.nextLine();
            
			for (int c = 0; c < cols; c++) {
				char ch = line.charAt(c);
				if (ch == 'M') {  //found Mario
					mario = new int[] { r, c };
				} else if (ch == 'X') {  //found exit
					end = new int[] { r, c };
				}
				maze[r][c] = ch;
			}
		}
        
 		//close the input file
		fromFile.close();
        
		numMoves = 0;

	}

	/**
	 * Prints the maze.
	 */
	public void printMaze() {
		//Output complete contents of 2D array
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[r].length; c++) {
				System.out.print(maze[r][c]);
			}
			System.out.println();
		}
	}

	/**
	 * Checks which move the user made and calls other method to perform that
	 * move.
	 *
	 * @param move
	 *            the move made (one of i,I,j,J,k,K,l,L)
	 * @return true if Mario moved, false otherwise
	 */
	public boolean moveMario(String move) {
		switch (move.toLowerCase()) {
		case "i": case "I":// up
			return moveUp();
		case "j": case "J": // left
			return moveLeft();
		case "k": case "K": // down
			return moveDown();
		case "l": case "L": // right
			return moveRight();
		default:
			System.out.println("Invalid command.");
			return false;
		}
	}

	/**
	 * Attempts to move Mario to the left by one step.
	 *
	 * @return true if he moves, false otherwise
	 */
	private boolean moveLeft() {
		int newR = mario[0];
		int newC = mario[1] - 1;

		//check if new location is [off the left edge of the maze],
		//or if it [is a wall] or [is the exit but Mario can't exit yet]
		if (newC < 0 || invalidTypeOfPlaceToMove(newR, newC)) {  
			return false;
		}
		if (maze[newR][newC] == 'S') { //found a mushroom
			numMushroomsLeft--;
		}
		maze[mario[0]][mario[1]] = '.';  //leave a trail where Mario was
		numMoves++;  //update move count
		mario[1] = newC; //update Mario's column position
		maze[mario[0]][mario[1]] = 'M';  //place Mario back in maze
		return true;
	}

	/**
	 * Attempts to move Mario to the right by one step.
	 *
	 * @return true if he moves, false otherwise
	 */
	private boolean moveRight() {
		int newR = mario[0];
		int newC = mario[1] + 1;
        
		//check if new location is [off the right edge of the maze],
		//or if it [is a wall] or [is the exit but Mario can't exit yet]
		if (newC >= maze[0].length || invalidTypeOfPlaceToMove(newR, newC)) {
			return false;
		}
		if (maze[newR][newC] == 'S') { //found a mushroom
			numMushroomsLeft--;
		}
		maze[mario[0]][mario[1]] = '.';
		numMoves++;
		mario[1] = newC;
		maze[mario[0]][mario[1]] = 'M';
		return true;
	}

	/**
	 * Attempts to move Mario up by one step.
	 *
	 * @return true if he moves, false otherwise
	 */
	private boolean moveUp() {
		int newR = mario[0] - 1;
		int newC = mario[1];

		//check if new location is [off the top edge of the maze],
		//or if it [is a wall] or [is the exit but Mario can't exit yet]
		if (newR < 0 || invalidTypeOfPlaceToMove(newR, newC)) {
			return false;
		}
		if (maze[newR][newC] == 'S') { //found a mushroom
			numMushroomsLeft--;
		}
		maze[mario[0]][mario[1]] = '.';
		numMoves++;
		mario[0] = newR;
		maze[mario[0]][mario[1]] = 'M';
		return true;
	}

	/**
	 * Attempts to move Mario down by one step.
	 *
	 * @return true if he moves, false otherwise
	 */
	private boolean moveDown() {
		int newR = mario[0] + 1;
		int newC = mario[1];
        
		//check if new location is [off the bottom edge of the maze],
		//or if it [is a wall] or [is the exit but Mario can't exit yet]
		if (newR >= maze.length || invalidTypeOfPlaceToMove(newR, newC)) {
			return false;
		}
		if (maze[newR][newC] == 'S') { //found a mushroom
 			numMushroomsLeft--;
		}
		maze[mario[0]][mario[1]] = '.';
		numMoves++;
		mario[0] = newR;
		maze[mario[0]][mario[1]] = 'M';
		return true;
	}
    
	/**
	 * Inspects maze and the given location to see if it is invalid (at this time).
	 * It is considered invalid if it is a wall, or if it is the exit but not
	 * all mushrooms have been collected yet.
	 *
	 * @param newR
	 *            the row number of the location to check
	 * @param newC
	 *            the column number of the location to check
	 * @return true if given location is invalid, false otherwise
	 */
	private boolean invalidTypeOfPlaceToMove(int newR, int newC) {
    
		boolean isWall = maze[newR][newC] == '+';
		boolean isExitSpot = maze[newR][newC] == 'X';
		boolean okToExit = numMushroomsLeft == 0;
        
		return isWall || (isExitSpot && !okToExit);
	}

	/**
	 * Getter for the number of moves Mario has made.
	 *
	 * @return The number of moves Mario has made
	 */
	public int getNumMoves() {
		return numMoves;
	}

	/**
	 * Checks if the maze is solved by checking if Mario reached the end of the
	 * maze and also collected all mushrooms.
	 * 
	 * @return true if Mario reached the end and collected all mushrooms, false otherwise.
	 */
	public boolean isSolved() {
		return numMushroomsLeft == 0 && mario[0] == end[0] && mario[1] == end[1];
	}

}
