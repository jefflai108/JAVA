/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 4
*Task 3
********************************************************/

//Divisors.java
//The class is able to find and print out the largest number of positive divisors an integer, which is between  
//the two positive integers user input, has.

import java.util.Scanner; 

public class Divisors {

   public static void main(String[] args) { 
 
   //Declare variables 
   int first, second;
   int small, big;
   int count; 
   int max;
   int number; 
   
   Scanner keyboard = new Scanner(System.in); //so we can collect data 
   
   System.out.println("Given a specific range of positive integers to search, this program will " + 
      "determine a value in the range which has the highest number of divisors. You get to select the range.");
   
   //Prompt the user to enter two positive numbers and store them in variables   
   System.out.print("Please specify the range by entering two positive integers: ");
   first = keyboard.nextInt();
   second = keyboard.nextInt();
   
   //Check if the two integers entered are positive; if not, use while loop to 
   //prompt the user to enter again until both integers inputed are positive
   while (!(first > 0) || !(second > 0)) {
      System.out.print("Please specify the range by entering two positive integers: ");
      first = keyboard.nextInt();
      second = keyboard.nextInt();
   }
   
   big = 0;
   small = 0; 
   //To identify which is the larger number and which is the smaller one 
   if (first >= second) {
      big = first;
      small = second;
   } else {
      small = first; 
      big = second;
   }
   
   //Initialization
   count = 0;
   max = 0;
   number = 0;
   
   //for loop with if-else statement
   for (int i = small; i < (big+1); i++) {
      
      //to reset the counter each time 
      count = 0;
      
      //count the divisors of current i 
      for (int a = 1; a <= i; a++) {
         if (i % a == 0) {
            count++;
         }//end if-else
      }//end nested for loop
      
      //See if new number beats current max; update max if necessary
      if (count > max) {
         number = i;
         max = count; 
      }//end if-else    
   }//end big for loop
   
   //Printout final statement 
   System.out.printf("Okay, checking values between %d and %d...", small, big); 
   System.out.printf("The winning number is %d with %d divisors.", number, max);
  
   }//end main
}//end class