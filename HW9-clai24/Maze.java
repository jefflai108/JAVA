/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 9
*Task 1
********************************************************/

//Maze.java
//An Instantiable Java class named Maza for the Maze game. 

import java.io.IOException; 
import java.io.FileReader; 
import java.util.Scanner; 

public class Maze { 

   //Instance Variable
   /**
   *number of rows in the game 
   */ 
   private int rows; 
   /**
   *number of columns in the game 
   */ 
   private int columns; 
   /**
   *number of mushrooms in the game 
   */ 
   private int mushroom;
   /**
   *Represent the input file 
   */ 
   private Scanner in; 
   /**
   *User Choice of going up, down, right, or left
   */ 
   private String userChoice; 
   /**
   *Number of moves from initial position to destination
   */ 
   public static int count = 0; 
   /**
   *The maze itself, stored in an array 
   */ 
   private String[][] marray; 
   /**
   *Position of Mario in the maze 
   */ 
   private int[] mario_pos;
   /**
   *Position of destination in the maze 
   */ 
   private int[] x_pos; 
   
   //Constructor
   /**
   *Creates a new maze with the given data
   *
   *@param rows      the number of rows of the maze 
   *@param columns   the number of columns of the maze 
   *@param mushroom  the number of mushrooms of the maze 
   *@param in        the input file 
   */
   public Maze(int rows, int columns, int mushroom, Scanner in) { 
      this.rows = rows; 
      this.columns = columns; 
      this.mushroom = mushroom; 
      this.in = in; 
      marray = new String[rows][columns];
      mario_pos = new int[2];
      x_pos = new int[2]; 
     
      String dummy = in.nextLine(); 
      for (int r=0; r<marray.length; r++) { 
         String s = in.nextLine(); 
         for (int c=0; c<marray[0].length; c++) { 
            marray[r][c] = Character.toString(s.charAt(c));
            if (s.charAt(c) == 'M') { 
               mario_pos[0] = r; 
               mario_pos[1] = c;
            } else if (s.charAt(c) == 'X') { 
               x_pos[0] = r; 
               x_pos[1] = c; 
            }             
         }
      }  
   } 
   
   //Getters
   /**
   *Updating the user’s view of the maze.
   *
   *@return    a string of the maze 
   */
   public String toString() { 
      String S =""; 
      for (int r=0; r<marray.length; r++) { 
         for (int c=0; c<marray[0].length; c++) {
            S = S + marray[r][c];
         }
         S = S + "\n";
      }
      return S; 
   } 
   
   //Setters 
   /**
   *Return the number of packages present in the list.
   *take i, j, k, l and move Mario to corresponding position and place a . and eat the mashroom 
   *
   *@param userChoice   User enter either i,j,k,l
   *@return true/false if Mario moves successfully 
   */   
   public boolean marioMove(String userChoice) { 

      switch (userChoice) { 
         
         case "i": 
            if (!validMove(userChoice))
               break; 
            //update mushroom 
            if (marray[mario_pos[0]-1][mario_pos[1]].equals("S")) 
               mushroom--; 
            //place an "."
            marray[mario_pos[0]][mario_pos[1]] = "."; 
            //update mario position 
            mario_pos[0]--;
            //update counter 
            count++; 
            //Put an M 
            marray[mario_pos[0]][mario_pos[1]] = "M"; 
            return true; 

         case "k":
            if (!validMove(userChoice))
               break; 
            //update mushroom 
            if (marray[mario_pos[0]+1][mario_pos[1]].equals("S")) 
               mushroom--; 
            //place an "."
            marray[mario_pos[0]][mario_pos[1]] = "."; 
            //update mario position 
            mario_pos[0]++;
            //update counter 
            count++; 
            //Put an M 
            marray[mario_pos[0]][mario_pos[1]] = "M"; 
            return true; 
            
         case "l": 
            if (!validMove(userChoice))
               break; 
            //update mushroom 
            if (marray[mario_pos[0]][mario_pos[1]+1].equals("S")) 
               mushroom--; 
            //place an "."
            marray[mario_pos[0]][mario_pos[1]] = "."; 
            //update mario position 
            mario_pos[1]++;
            //update counter 
            count++; 
            //Put an M 
            marray[mario_pos[0]][mario_pos[1]] = "M"; 
            return true;          
         
         case "j":
            if (!validMove(userChoice))
               break; 
            //update mushroom 
            if (marray[mario_pos[0]][mario_pos[1]-1].equals("S")) 
               mushroom--; 
            //place an "."
            marray[mario_pos[0]][mario_pos[1]] = "."; 
            //update mario position 
            mario_pos[1]--;
            //update counter 
            count++; 
            //Put an M 
            marray[mario_pos[0]][mario_pos[1]] = "M"; 
            return true;          
         
      } 
      
      return false; 
   } 
   
   /**
   *Return if the move user intended is valid or not 
   *
   *@param userChoice   User enter either i,j,k,l
   *@return true/false if the move is valid or not 
   */
   public boolean validMove(String userChoice) { 
      //if the move is valid return ture 
      //else return false 
      switch (userChoice) { 
         
         case "i": 
            if ((mario_pos[0]-1) < 0) 
               return false; 
            if ((marray[mario_pos[0]-1][mario_pos[1]]).equals("+")) 
               return false;
            if ((marray[mario_pos[0]-1][mario_pos[1]]).equals("X") && mushroom != 0) 
               return false;
            break; 
         
         case "k":
            if ((mario_pos[0]+1) >= rows) 
               return false; 
            if ((marray[mario_pos[0]+1][(mario_pos[1])]).equals("+")) 
               return false;
            if ((marray[mario_pos[0]+1][(mario_pos[1])]).equals("X") && mushroom != 0) 
               return false;
            break;
         
         case "l": 
            if ((mario_pos[1]+1) >= columns) 
               return false; 
            if ((marray[mario_pos[0]][mario_pos[1]+1]).equals("+")) 
               return false; 
            if ((marray[mario_pos[0]][mario_pos[1]+1]).equals("X") && mushroom != 0) 
               return false; 
            break; 
         
         case "j":
            if ((mario_pos[1]-1) < 0) 
               return false; 
            if ((marray[mario_pos[0]][mario_pos[1]-1]).equals("+")) 
               return false; 
            if ((marray[mario_pos[0]][mario_pos[1]-1]).equals("X") && mushroom != 0) 
               return false;  
            break;
      } 
      
      return true; 
   }  
   
   /**
   *Determine if Mario reaches destination
   *
   *@return true/false if Mario reaches destination
   */     
   public boolean destination() { 
      
      return mario_pos[0] == x_pos[0] && mario_pos[1] == x_pos[1] && mushroom == 0; 
   } 
}