/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 9
*Task 1
********************************************************/

//MazeDriver.java
//Maze game to entertain the user himself. 

import java.io.IOException; 
import java.io.FileReader; 
import java.util.Scanner; 

public class MazeDriver { 
   /**
   *The main method utilizes the Maze class and allow users to manipulate Mario in the maze user provided 
   */
   public static void main(String[] args) throws IOException { 

      Scanner kb = new Scanner(System.in); 
      System.out.print("Enter the filename with the maze --> ");
      String inputFile = kb.nextLine(); 
      
      Scanner in = new Scanner(new FileReader(inputFile));
      int x = in.nextInt(); 
      int y = in.nextInt(); 
      int z = in.nextInt(); 
         
      Maze m = new Maze(x, y, z, in);
       
      String line = null; 
      do { 
         System.out.println(m.toString()); 
         System.out.println("Enter i to move up"); 
         System.out.println("Enter j to move left"); 
         System.out.println("Enter k to move down"); 
         System.out.println("Enter l to move right"); 
         System.out.print("Choice --> "); 
         String userChoice = kb.nextLine(); 
         if (!m.marioMove(userChoice))
            System.out.println("Invalid move"); 
         System.out.print("\n");
      } while (!m.destination()); 
      
      System.out.printf("You won in %d move", m.count); 
      in.close(); 
        
   }
}