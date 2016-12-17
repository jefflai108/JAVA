/*
MiddleThree.java

600.107, Spring 2016
HW2 Task 1 SOLUTION
Author: Sara More

Given an odd-length String, this program outputs the String
of length three from its middle.  It is assumed that the input
always has odd length of at least three.
*/

import java.util.Scanner;

public class MiddleThree {
	
	public static void main(String[] args) {

		//Collect input
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter an odd-length String with at least three characters:");
		String str = keyboard.nextLine();

		//Determine the midpoint of the string (integer division is helpful here!)
		int half = str.length() / 2;
        
		//Output the substring centered at that midpoint.
		System.out.println("The middle three String is \"" + str.substring(half-1, half+2) + "\".");

	}
}