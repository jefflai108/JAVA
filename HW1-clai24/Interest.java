/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 1
*Task 1
********************************************************/

//Interest.java
//Collects from the user the initial principle and interest rate and 
//calculate the future principle after 1, 5, and 10 years
import java.util.Scanner;

import java.lang.Math;

public class Interest {

   public static void main(String[] args) {
      
      //Set up the Scanner "hose" from keyboard to our program
      Scanner keyboard = new Scanner(System.in); 
      
      //Prompt the user to enter a name or value, then collect them
      //and store in the variables
      System.out.println("Please enter the amount of initial principal: ");
      int initial = keyboard.nextInt();
   
      System.out.println("Please enter the interest rate (e.g. 9% is entered as .09): ");
      double rate = keyboard.nextDouble();
      
      //using the provided formula to calculate the future principle 
      double year1 = initial * Math.pow((1 + rate),1); 
      double year5 = initial * Math.pow((1 + rate),5);
      double year10 = initial * Math.pow((1 + rate),10);  
     
      //print out the result 
      System.out.println("The value of that initial deposit after 1 year is " + year1);
      System.out.println("The value of that initial deposit after 5 year is " + year5);
      System.out.println("The value of that initial deposit after 10 year is " + year10);

   }//end main
}// class Interest