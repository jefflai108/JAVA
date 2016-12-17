/*
MilitaryTime.java

600.107, Spring 2016
HW2 Task 3 SOLUTION
Author: Sara More

Given a starting time and duration elapsed, this progam outputs the new time.
All times are in 24-hour (military time) format.
*/
import java.util.Scanner;

public class MilitaryTime {

	public static void main(String[] args) {

		//Collect input as required
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter a time in 24-hour HH:MM format, e.g., 1:02 or 19:56.");
		String enteredStartTime = keyboard.next();

		System.out.println("Next, enter a duration to add to that time.  Use HH:MM format. ");
		System.out.println("For example, to add two hours and five minutes, type 2:05.");
		String enteredDurationTime = keyboard.next();

		//Separate input strings into integer components
		int startColon = enteredStartTime.indexOf(":");
		int startHour = Integer.parseInt(enteredStartTime.substring(0,startColon));
		int startMinutes = Integer.parseInt(enteredStartTime.substring(startColon+1));

		int durationColon = enteredDurationTime.indexOf(":");
		int durationHour = Integer.parseInt(enteredDurationTime.substring(0,durationColon));
		int durationMinutes = Integer.parseInt(enteredDurationTime.substring(durationColon+1));

		//Add the duration to the starting time, taking care not to allow minutes to exceed 59
		//or hours to exceed 23.
		final int MINS_PER_HOUR = 60;
		final int HOURS_PER_DAY = 24;
		int newTotalMinutes = startMinutes + durationMinutes;
		int newHour = (startHour + durationHour + (newTotalMinutes / MINS_PER_HOUR)) % HOURS_PER_DAY;
		int newMinutes = newTotalMinutes % MINS_PER_HOUR;

		//Output the result, using printf to ensure the proper number of digits in each value.
		System.out.print("Okay, the time " + durationHour + " hour(s) and " + durationMinutes + " minute(s) past " 
			+ enteredStartTime + " will be ");
		System.out.printf("%02d:%02d.\n\n", newHour, newMinutes);
	}
}
