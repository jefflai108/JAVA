/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 2
*Task 3
********************************************************/

//MilitaryTime.java
//Asks the user for a starting time in 24-hour HH:MM format 
//(i.e. “military time format”, where, for example, 1:15pm is represented as 13:15),
//and then a duration in HH:MM format, and which reports the new time (also in 24-hour format) 
//after that duration has elapsed. 

import java.util.Scanner; 

public class MilitaryTime {

   public static void main(String[] args) {
      
      //Declare variables 
      String initialHour1;
      String initialMinute1;
      
      int initialHour2;
      int initialMinute2;
      
      String durationHour1; 
      String durationMinute1; 
      
      int durationHour2; 
      int durationMinute2;
      
      int finalHour;
      int finalMinute; 
   
      Scanner keyboard = new Scanner(System.in); //so we can collect input 
   
      //Prompt the user to enter starting time, then store it in the variable initialTime
      System.out.println("Please enter a time in 24-hour HH:MM format, e.g., 1:02 or 19:56.");
      String initialTime = keyboard.nextLine(); 
      
      //Split the time with colon as delimiter
      String[] splitInitialTime = initialTime.split(":");
      
      //Assign starting time hour and minute to corresponding variables 
      initialHour1 = splitInitialTime[0];
      initialMinute1 = splitInitialTime[1];
      
      //Convert the String varaibles to integer type
      initialHour2 = Integer.parseInt(initialHour1);
      initialMinute2 = Integer.parseInt(initialMinute1);
            
      //Prompt the user to enter a duration time, then store it in the variable durationTime
      System.out.println("Next, enter a duration to add to that time. Use HH:MM format.\nFor example, to add two hours and five minutes, type 2:05.");
      String durationTime = keyboard.nextLine();
      
      //Split the time with colon as delimiter 
      String[] splitDurationTime = durationTime.split(":");
      
      //Assign duration time hour and minute to corresponding variables 
      durationHour1 = splitDurationTime[0];
      durationMinute1 = splitDurationTime[1];

      //Convert the String varaibles to integer type
      durationHour2 = Integer.parseInt(durationHour1);
      durationMinute2 = Integer.parseInt(durationMinute1);

      //Calculate final time = starting time + duration time 
      //For the minute part, use if-else statement to tackle the exceed 60 minutes part 
      //For the hour part, use if-else statement to tackle the exceed 24 hours part 
      //Note that hour conditional(if-else) is nested in minute conditional(if-else)
      finalHour = initialHour2 + durationHour2;
      finalMinute = initialMinute2 + durationMinute2;
            
      if ( finalMinute % 60 < 60 ) {
         finalMinute = finalMinute % 60; 
         finalHour = finalHour % 24;         
      } else {
         finalMinute = finalMinute % 60; 
         finalHour = (finalHour + 1) % 24;            
      }
      
      //Printout the final statement using printf method 
      System.out.printf("Okay, the time %d hours and %d minute(s) past %s will be %02d : %02d.", durationHour2, durationMinute2, initialTime, finalHour, finalMinute);

   }//end main
}//end class
