/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 3
*Task 2
********************************************************/

//Rock.java
//Play Rock, Paper, Scissors against the computer in a single round 

import java.util.Scanner;
import java.util.Random;

public class Rock {

   public static void main(String[] args) {

      //Declare variables 
      int randomInt; 
      String userInput; 
      String computerInput = " ";
      
      Scanner keyboard = new Scanner(System.in); 
      Random random = new Random();
      
      //Computer's random decision using if-else statement 
      randomInt = random.nextInt(3);
      if (randomInt == 0) {
         computerInput = "Rock";
      } else if (randomInt == 1) { 
         computerInput = "Paper";
      } else {
         computerInput = "Scissors"; 
      }     
      
      //Printout first two messages on top 
      System.out.println("Welcome to Rock, Paper, Scissors!");
      System.out.print("I’ve made my choice.  What’s yours?  Enter R, P, or S: ");
      userInput = keyboard.nextLine();
      
      //Convert R,P,S,r,p,s to corrsonding meaning 
      if (userInput.equalsIgnoreCase("R")) {
         userInput = "Rock";
      } else if (userInput.equalsIgnoreCase("P")) {
         userInput = "Paper"; 
      } else if (userInput.equalsIgnoreCase("S")) { 
         userInput = "Scissors";
      }
      
      //if-else statement to determine the result of the game 
      //First if-else to determine if it is valid 
      if (!userInput.equals("Rock") && !userInput.equals("Paper") && 
         !userInput.equals("Scissors")) {
         System.out.println("Sorry, that is not a valid choice.");
      } else {
         //second if-else to determine the game is tie or not 
         if (userInput.equals(computerInput)) {
            System.out.printf("I chose %s, and you chose %s.  We TIED!", userInput, computerInput);
         } else {
            //third and final if-else to determine who wins 
            if (userInput.equals("Rock") && computerInput.equals("Paper")) {
               System.out.printf("I chose %s, and you chose %s.  You LOSE!", userInput, computerInput);
            } else if (userInput.equals("Rock") && computerInput.equals("Scissors")) {
               System.out.printf("I chose %s, and you chose %s.  We WIN!", userInput, computerInput);
            } else if (userInput.equals("Paper") && computerInput.equals("Rock")) {
               System.out.printf("I chose %s, and you chose %s.  We WIN!", userInput, computerInput);
            } else if (userInput.equals("Paper") && computerInput.equals("Scissors")) {
               System.out.printf("I chose %s, and you chose %s.  We LOSE!", userInput, computerInput);
            } else if (userInput.equals("Scissors") && computerInput.equals("Rock")) {
               System.out.printf("I chose %s, and you chose %s.  We LOSE!", userInput, computerInput);
            } else {
               System.out.printf("I chose %s, and you chose %s.  We WIN!", userInput, computerInput);   
            }//end the third if-else statement 
         }//end the second if-else statement 
      }//end the gigantic first if-else statement 
      
   }//end main
}//end class