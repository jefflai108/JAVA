/*
Initials.java

600.108, Spring 2016
HW2 Task 2 SOLUTION
Author: Sara More

Given a full three-part name as input in a single String,
this program will output the three initials of the name in
upper case.
*/

import java.util.Scanner; 

public class Initials {

	public static void main(String[] args) {

		//Prepare a Scanner object to receive input from keyboard
		Scanner keyboard = new Scanner(System.in);


		//Collect the required input information
		//Note that we use .nextDouble() to collect input here, since 
		//we are told that the input values are not necessarily integers
		System.out.print("Please enter your full name (all three parts): ");
		String fullName = keyboard.nextLine();


		//Calculate and output the results
		String initial1 = fullName.substring(0,1);
		int posnSpace1 = fullName.indexOf(" ");
		String initial2 = fullName.substring(posnSpace1+1, posnSpace1+2);
		String lastPart = fullName.substring(posnSpace1 + 2);
		int posnSpace2 = lastPart.indexOf(" ");
		String initial3 = lastPart.substring(posnSpace2+1, posnSpace2+2);

		String initials = initial1 + initial2 + initial3;
		initials = initials.toUpperCase();
		System.out.println("Your initials are " + initials + ".");

		
	} 	
}