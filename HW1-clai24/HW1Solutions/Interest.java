//Interest.java
//CS 107, Spring 2016
//SOLUTION to HW1, Task 2
//
//This program calculates the future value of an initial investment
//where interest is compounded annually, given an initial principal
//amount and an interest rate.  It outputs the future value after
//one, five, and twenty-five years.

import java.util.Scanner;

public class Interest {

    public static void main(String[] args) {

        //Initialize a Scanner object so we can collect input from the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        //Collect input from the user and store in two double variables
        System.out.print("Please enter the amount of initial principal: ");    
        double initial = keyboard.nextDouble();
        System.out.print("Please enter the interest rate (e.g. 9% is entered as .09): ");    
        double rate = keyboard.nextDouble();
        //Output a blank line to separate input collection from results
        System.out.println();
        
        
        //Calculate the future values of the initial investment after 1, 5, and 25 years, and output them
        double one = initial * Math.pow((1 + rate), 1);
        System.out.println("The value of that initial deposit after 1 year is $" + one + ".");

        double five = initial * Math.pow((1 + rate), 5);
        System.out.println("The value of that initial deposit after 5 years is $" + five + ".");

        double twentyfive = initial * Math.pow((1 + rate), 25);
        System.out.println("The value of that initial deposit after 25 years is $" + twentyfive + ".");


    }
}