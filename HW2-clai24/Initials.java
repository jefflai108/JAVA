/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 2
*Task 2
********************************************************/

//Initials.java
//Ask users for their full name and collects it as a string, and then output the 
//users' three initials.

import java.util.Scanner; 

public class Initials {

   public static void main(String[] args) {
   
      Scanner keyboard = new Scanner(System.in); //so we can collect input 
     
      //Prompt the user to enter a string, then store it in the variable username 
      System.out.println("Please enter your full name (all three parts): ");
      String username = keyboard.nextLine(); 
      
      //Split the username with whitespace as delimiter 
      String[] splitUserName= username.split(" ");
      
      //Capitalize each first, middle, last name 
      String firstString = splitUserName[0].toUpperCase();
      String middleString = splitUserName[1].toUpperCase();
      String lastString = splitUserName[2].toUpperCase();
      
      //Extract the first initials 
      char firstChar = firstString.charAt(0);
      char middleChar = middleString.charAt(0);
      char lastChar = lastString.charAt(0);
      
      //Printout the final statement with string concatenation    
      System.out.println("Your initials are " + firstChar + middleChar + lastChar + ".");


   }//end main
}//end class