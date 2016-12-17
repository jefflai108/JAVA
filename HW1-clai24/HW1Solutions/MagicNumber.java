//MagicNumber.java
//CS 107, Spring 2016
//SOLUTION to HW1, Task 1
//
//This program calculates the "magic number" for a baseball team that
//is leading its division, given as input the number of games the team
//has WON so far, the number of games the second-place team has LOST so
//far, and the total number of games scheduled in a season.

import java.util.Scanner;

public class MagicNumber {

    public static void main(String[] args) {

        //Initialize a Scanner object so we can collect input from the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        //Collect user input: 1st place team city and team name as a String, 
        //then 1st place wins, 2nd place losses, and total games as ints.
        System.out.print("Please enter the first place team's city and name: ");
        String firstPlaceTeam = keyboard.nextLine();  //need nextLine() here, not next()
        
        System.out.print("Please enter their number of WINS so far: ");
        int wins = keyboard.nextInt();
        
        System.out.print("Please enter the number of LOSSES so far for the second place team: ");
        int losses = keyboard.nextInt();
        
        System.out.print("Please enter the total number of games per team: ");
        int totalGames = keyboard.nextInt();

        //Calculate the magic number for the first place team
        int magicNumber = totalGames - wins - losses + 1;
        
        //Output the result
        System.out.println();
        System.out.println("The " + firstPlaceTeam + " have a magic number of " + magicNumber + ".");
    }       
}
