import java.io.IOException;
import java.util.Scanner;

/**
 * Intro to Programming, 600.107, Spring 2016, HW9
 *
 * @author Sara More, based on initial code by Katie Calabro
 *
 */
public class MazeDriver {

	/** instance of the Maze class. */
	private static Maze maze;

	/**
	 * Driver for the Maze class
	 *
	 * @param args
	 *            arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

        //Collect name of input file storing maze data, and 
        //then create the maze from that file
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the filename with the maze -> ");
		String filename = kb.next();
		maze = new Maze(filename);
		System.out.println();

        //Repeat until maze is solved
		do {
            //Output maze and menu of choices, then collect choice
			maze.printMaze();
			printMenu();
			String choice = kb.next();

            //Attempt to make the specified move
			if (!maze.moveMario(choice)) {
				System.out.println("Invalid move");
			}
			System.out.println();
            
		} while (!maze.isSolved());

        //Now that maze is solved, print it out one last time, 
        //and report number of moves
		maze.printMaze();
		System.out.println("You Won in " + maze.getNumMoves() + " moves!!");
		kb.close();
	}

	/**
	 * Prints the menu.
	 */
	private static void printMenu() {
		System.out.println("Enter i to move up");
		System.out.println("Enter j to move left");
		System.out.println("Enter k to move down");
		System.out.println("Enter l to move right");
		System.out.print("Choice -> ");
	}

}
