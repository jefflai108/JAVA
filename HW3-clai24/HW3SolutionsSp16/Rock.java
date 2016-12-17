/*
Electricity.java

600.107, Spring 2016
HW3 Task 2 SOLUTION
Author: Sara More

Play one round of Rock, Paper, Scissors with the user.

 */

import java.util.Scanner;
import java.util.Random;

public class Rock {

    public static void main(String[] args) {
        
        //Create named constants to stand for different integers
        final int ROCK = 1;
        final int PAPER = 2;
        final int SCISSORS = 3;
        
        //Select 1, 2, or 3 at random to stand for computer's choice
        Random gen = new Random();
        int computerChoice = gen.nextInt(3) + 1;

        //Prompt user to enter their choice
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors!\n");
        System.out.print("I've made my choice.  What's yours? Enter R, P, or S: ");

        //Account for entered Strings that contain more than one letter,
        //and those entered in lower or upper case
        String userChoiceLetter = kb.nextLine().substring(0,1).toUpperCase();
        System.out.println();

        int userChoiceInt = 0;
        String userChoiceFullString = "";

        switch(userChoiceLetter) {
            case "R": 
                userChoiceFullString = "Rock"; 
                userChoiceInt = ROCK;
                break;
            case "P": 
                userChoiceFullString = "Paper"; 
                userChoiceInt = PAPER;
                break;
            case "S": 
                userChoiceFullString = "Scissors"; 
                userChoiceInt = SCISSORS;
                break;
        }

        if (userChoiceInt == 0) {  //user letter didn't match any case above, so end
            System.out.println("Sorry, that is not a valid choice.");

        } else {
            //report computer choice, user choice, and result
            System.out.print("I chose ");
            switch(computerChoice) {
                case ROCK: System.out.print("Rock"); break;
                case PAPER: System.out.print("Paper"); break;
                case SCISSORS: System.out.print("Scissors"); break;
            }
            
            System.out.print(", and you chose " + userChoiceFullString + ". ");

            //Determine the winner by comparing the integers
            if (userChoiceInt % 3 == (computerChoice + 1) % 3) {
                System.out.println("You WIN!");
            } else if (userChoiceInt == computerChoice) {
                System.out.println("We TIED!");
            } else {
                System.out.println("You LOSE!");
            }
        }  //end else

    }
}