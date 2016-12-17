/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 2
*Task 1
********************************************************/

//MiddleThree.java
//Asks user to enter an odd-length of text, and prints to screen the length of the
//string and then the String of length 3 from that String’s middle, enclosed 
//in quotation marks.

import java.util.Scanner;

public class MiddleThree {
   
   public static void main(String[] args) {
   
      Scanner keyboard = new Scanner(System.in); //so we can collect input 
      
      //Prompt the user to enter a string, then store it in the variable userInput
      System.out.println("Please enter an odd-length String with at least three characters: "); 
      String userInput = keyboard.nextLine();
      
      //Calculate string length with .length() method 
      int length = userInput.length();
      
      //Find out the middle 3 characters
      int middle1 = (length - 1) / 2;
      int middle3 =  middle1 + 2;
      
      //Print out final statement with string concatenation
      System.out.println("The string has length " + length + ", and its middle three String is " + '\"' + userInput.substring(middle1, middle3) + '\"');           
      
      
    }//end main
}//end class  