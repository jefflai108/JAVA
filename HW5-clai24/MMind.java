/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 5
*Task 2
********************************************************/

//MMind.java
//At the start, the player is given instructions, and then may begin to guess the target number. 
//After each incorrect guess, the player is given a clue based on the digits that match between the 
//target and the most recent guess (see details below). After a correct guess, the total number of 
//guesses is reported, and the program ends.

import java.util.Scanner; 
import java.util.Random; 

public class MMind {

   public static void main(String[] args) {

   //Declare variable 
   String input; 
   String answer; 
   
   Scanner kb = new Scanner(System.in); //so we can collect data 
   
   //first helper method to determine the computer-generated answer
   answer = genTargetWithNoZeroes();

   //Ask user question 
   System.out.println("I’m thinking of a 4 digit number.  Each digit is between 1 and 9." +
      " Try to guess my number, and I’ll say R for each digit you get right, and W for each" +
      " correct digit you get in the wrong place.  If you don’t use any of the correct digits" + 
      " in your guess, I’ll say none.");
      
   System.out.println("Your guess: "); 
   input = "" + kb.nextInt(); 
   
   //counter 
   //while loop 
   int count = 1;
   while (!answer.equals(input)) {
      System.out.println(getClue(answer,input));
      System.out.println("Your guess: "); 
      input = "" + kb.nextInt();
      count++;
   } 
   
   if (answer.equals(input)) {
   System.out.println("You got it right in " + count + " guesses!");
   }
   
   } //end main

   //Returns a randomly-selected String containing exactly four
   //digits from the range 1-9 inclusive.     
   public static String genTargetWithNoZeroes(){
      
      String random1, random2, random3, random4, result;
      
      //create random object 
      Random random = new Random(); 
      
      random1 = "" + (random.nextInt(9) + 1);
      random2 = "" + (random.nextInt(9) + 1);
      random3 = "" + (random.nextInt(9) + 1);
      random4 = "" + (random.nextInt(9) + 1);   
      result = "" + random1 + random2 + random3 + random4;
      
      return result;  
       
   } //end genTargetWithNoZeroes

   //Given a particular target String, returns the appropriate clue to
   //output after the given guess.  All R’s must come before all W’s.
   //If neither R’s nor W’s are warranted, returns the String ‘none’’.
   public static String getClue(String target, String guess) {
      
      String result = ""; 
      int i,j,k;
      
      for (i=0; i<4; i++) {
         if (target.charAt(i) == guess.charAt(i)) { 
            result = result + "R"; 
            target = target.substring(0,i)+'x'+ target.substring(i+1);
         }
         }
         

      for (j=0; j<4; j++) {
         for (k=0; k<4; k++) {
         if ((j != k) && (target.charAt(j) == guess.charAt(k))) { 
            result = result + "W";
            target = target.substring(0,j)+'x'+ target.substring(j+1);
         }
         } 
         }
         
      if (result == ""){
         result = "None";
         }
      
      return result;
   } //end getClue


} //end class

