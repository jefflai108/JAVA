/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 3
*Task 1
********************************************************/

//Electricity.java
//Calculate the rate of charge for user 

import java.util.Scanner; 

public class Electricity {

   public static void main(String[] args) {
   
   //Declare variables 
   int lastMonth; 
   int thisMonth; 
   int difference;
   int lengthOfLastMonth; 
   int lengthOfThisMonth;
   double charge=0; 
   
   Scanner keyboard = new Scanner(System.in);//so we can collect data 
   
   //Prompt the user to input last month and this month's electricity reading 
   //and store them in their corresonding variables
   System.out.print("Please input last month’s meter reading [0-99999]: ");
   lastMonth = keyboard.nextInt();
   System.out.print("Please input this month’s meter reading [0-99999]: ");
   thisMonth = keyboard.nextInt(); 
      
   //Printout the middle statement 
   System.out.println("You entered readings of " + String.valueOf(lastMonth) + " and " + 
      String.valueOf(thisMonth) + '.'); 
   
   //Assign the number of the digits user has entered 
   lengthOfLastMonth = String.valueOf(lastMonth).length();
   lengthOfThisMonth = String.valueOf(thisMonth).length();

   //Assign the value of difference by subtracting lastMonth from thisMonth 
   difference = thisMonth - lastMonth;  

   //if-else statement to determine the rate of charge 
   if (lengthOfThisMonth > 5 || lengthOfLastMonth > 5) {
      System.out.println("You have entered an invalid input value, so no bill will be produced.");
   } else {
      if (lastMonth > thisMonth) {
          thisMonth = 100000 + thisMonth;
          difference = thisMonth - lastMonth; 
      } else {
      }
      
      if (difference < 1000 && difference >= 0) { 
         charge = difference * .07;   
      } else if (difference >= 1000 && difference <= 2500) { 
         charge = 70 + (difference - 1000) * .05;
      } else { 
         charge = 145 + (difference - 2500) * .03;   
      }
      
      System.out.printf("You used %d kilowatt-hour(s), and you owe $%.2f.", difference, charge);
    }  
    
    }//end main
}//end class

