/*
Electricity.java

600.107, Spring 2016
HW3 Task 1 SOLUTION
Author: Sara More

Given two electricity customer meter readings from consecutive months, this program 
determines the amount owed by that customer for the intervening month, based on a 
specified rate chart.
*/

import java.util.Scanner;

public class Electricity
{
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
        //Collect meter readings from the user, and echo it back
		System.out.print ("Please input last month's meter reading [0-99999]:");
		int lastMonth = keyboard.nextInt();
		System.out.print ("Please input this month's meter reading [0-99999]:");
		int thisMonth = keyboard.nextInt();
		System.out.println ("You entered readings of " + lastMonth + " and " + thisMonth + ".");
		
        //Validate the input
		if (lastMonth < 0 || lastMonth > 99999 || thisMonth < 0 || thisMonth > 99999)
		{
			System.out.println ("You have entered an invalid input value, so no bill will be produced.");
		}
		else
		{	
			//We have valid data, so we proceed with calculations
            
            //Determine kilowatt-hours used, adjusting for any meter rollover
            int kWhUsed = thisMonth - lastMonth;			
			if (lastMonth > thisMonth) //there was a rollover
			{
				kWhUsed = kWhUsed + 100000;
			}
			System.out.print("You used " + kWhUsed + " kilowatt-hour(s), and ");
			
            
            //Calculate the amount owed, given the rate charts specified in the problem
			double amountOwed;
            if (kWhUsed < 1000)
			{
				amountOwed = kWhUsed * 0.07;
			}
			else if (kWhUsed <= 2500)
			{
				amountOwed = (kWhUsed - 1000) * 0.05 + 70;
			}
			else  //we know kWhUsed must be > 2500 if we got this far
			{
				amountOwed = (kWhUsed -2500) * 0.03 + 145;
			}
            
            //Report the amount of money owed, formatted to contain at least
            //1 digit before the decimal point, and exactly 2 decimal places.
			System.out.printf ("you owe $%1.2f.\n", amountOwed);
		}
	}
}
