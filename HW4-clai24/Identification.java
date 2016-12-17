/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 4
*Task 2
********************************************************/

//Identification.java
//The class simulates the interaction a bank customer might have attempting to
//log into an automated teller machine (ATM).

import java.util.Scanner;

public class Identification {

   public static void main(String[] args) {
   
   //Declare variavbles
   String input;
   int count;
   
   //named constant representing desired PIN value   
   final String TARGET_PIN = "1234";
   
   Scanner keyboard = new Scanner(System.in); //so we can collect data 
   
   //Prompt the user to input PIN number and collect it in a variable 
   System.out.println("Please enter your PIN number: ");
   input = keyboard.next();
   
   //Counter with while loop to count the number of times user input the PIN 
   count = 0;
   while (count < 3 && !(input.equals(TARGET_PIN))) {
      
      //if-else statement to ensure a limit of 3 times input
      if (count == 2) {
         System.out.println("You made 3 unsuccessful login attempts. Your account is locked. Please contact the bank.");
      } else {
         System.out.println("Please enter your PIN number: ");
         input = keyboard.next();
      }//end if-else
 
   count++;
   }//end while 
   
   //if-else statement to prevent logic error 
   if (input.equals(TARGET_PIN)) {
      System.out.println("You are successfully logged in.");
   }//end if-else
   
   }//end main
}//end class


