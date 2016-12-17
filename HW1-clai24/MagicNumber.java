/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 1
*Task 1
********************************************************/

//MagicNumber.java
//Calculate the magic number in baseball from the user input 
import java.util.Scanner;

public class MagicNumber {

   public static void main(String[] args) {

      //Set up the Scanner "hose" from keyboard to our program
      Scanner keyboard = new Scanner(System.in);

      //Prompt the user to enter a name or value, then collect them
      //and store in the variables
      System.out.println("Please enter the first place team's city and name: ");
      String winTeam = keyboard.nextLine();
      
      System.out.println("Please enter their number of wins so far: ");
      int wins = keyboard.nextInt();
      
      System.out.println("Please enter the number of LOSSES so far for the second place team: ");
      int loses = keyboard.nextInt();
      
      System.out.println("Please enter the total number of games per team: ");
      int games = keyboard.nextInt();
      
      //Calculate the magicNumber 
      int magic = games - wins - loses + 1;
     
     
      //Print the result statement 
      System.out.print("The " + winTeam + " have a magic number of " + magic);
  
  
   } //end main 
} //end class MagicNumber 