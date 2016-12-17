/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 4
*Task 1
********************************************************/

//Isogram.java
//

import java.util.Scanner;

public class Isogram {

   public static void main(String[] args) { 
   
   //Declare variables 
   String word; 
   int count, i, k, length; 
   
   Scanner keyboard = new Scanner(System.in); //so we can collect data 

   //Prompt the user to input a word and store it in a variable
   System.out.println("Please enter a word (no spaces or punctuation, please): ");
   word = keyboard.next();
   
   //Initialization
   k = 0; 
   i = 0;
   length = word.length();
   
   while (k == 0 && i < length) {
      for (int a = i+1; a < length; a++) { 
         if (word.toLowerCase().charAt(i) == word.toLowerCase().charAt(a)) {
            k = 1;
         }
      }
      i++;
   }//end while 
   
   if(k == 1){
      System.out.println("The word " + word + " is an isogram.");
   } else {
      System.out.println("The word " + word + " is NOT an isogram.");
     
   }
   }
}//end 

