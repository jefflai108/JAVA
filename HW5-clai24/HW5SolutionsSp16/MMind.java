/*
MMind.java

HW5 Task 2 SOLUTION
Author: Sara More

This program allows the user to play a version
of the game MasterMind with the computer.  A
four-digit integer containing no zeroes is selected
at random by the program, and the user attempts
to guess it, receiving hints along the way.

*/

import java.util.Scanner;
import java.util.Random;

public class MMind {
    public static void main(String[] args) {
    
        Scanner kb = new Scanner(System.in);
        
        //Generate a random String of length 4 made up of digits 1-9
        String target = genTargetWithNoZeroes();
        
        //[The statement below is for testing purposes only]
        //System.out.println("TARGET = " + target);

        outputDirections();


        //Collect first guess
        System.out.print("Your guess: ");
        String guess = kb.next();        

        int count = 1;
        
        //Repeat as long as guess is incorrect
        while(!guess.equals(target)) {

            //Give clue based on previous guess
            String clue = getClue(target, guess);
            System.out.println(clue);
            
            //Collect next guess and update counter
            System.out.print("Your guess: ");
            guess = kb.next();
            count++;
        }        

        //Output ending message
        System.out.println("You got it right in " + count + " guesses.");
    
    }

/*
    Given a particular target String, returns the appropriate clue to
    output after the given guess.  All R’s must come before all W’s.
    If neither R’s nor W’s are warranted, returns the String "none".   
*/
    public static String getClue(String target, String guess){
    
        String clue = "";  //will be returned as result of method

        //These are to keep track of which digits didn't get an R match
        String unmatchedTarget = ""; 
        String unmatchedGuess = "";
        
        //Determine if there are any R matches
        for (int i = 0; i < 4; i++) {

            //If a perfect match, don't add target char into unmatchedTarget
            //or guess char into unmatchedGuess
            if (target.charAt(i) == guess.charAt(i)) {
                clue = clue + "R ";                
            } else {
                unmatchedTarget = unmatchedTarget + target.charAt(i);
                unmatchedGuess = unmatchedGuess + guess.charAt(i);
            }
        }
        
        //Loop through all unmatchedGuess substrings to determine 
        //if there are any W matches
        for (int i = 0; i < unmatchedGuess.length(); i++) {

            //Find first occurrence of unmatched digit from guess
            //in unmatchedTarget digits
            int where = 
                unmatchedTarget.indexOf(unmatchedGuess.substring(i,i+1));

            //indexOf returns -1 if substring wasn't found there
            if (where != -1){

                //Then we found a correct digit in wrong place
                clue = clue + "W ";
                
                //Make unmatchedTarget one char smaller, so we don't double-match this
                unmatchedTarget = unmatchedTarget.substring(0,where) + 
                    unmatchedTarget.substring(where + 1);
            }
        }
        
        //Check if there was at least one R or W; if not, return "none"
        if (clue.length() > 0) {
            return clue;    
        }
        return "none";
    }


/*
    Returns a randomly-selected String containing exactly four
    digits from the range 1-9 inclusive.  
    Hint:  you may wish torepeatedly use the nextInt method 
    from the Random class, and build up a String result to return.
*/
    public static String genTargetWithNoZeroes() {
        //generator to allow us to generate random digits
        Random gen = new Random();
        
        //"adding" digits to a String will result in a String
        String target = "";
        
        //repeatedly generate a non-zero digit
        for (int i = 0; i < 4; i++) {
            target = target + (gen.nextInt(9) + 1);
        }
        return target;
    }
    

/*
    Helper method to output directions on the screen.
    This exists only to de-clutter main method.
*/
    public static void outputDirections() {
        System.out.println("I’m thinking of a 4 digit number.  " +
            "Each digit is between 1 and 9.");
        System.out.println("Try to guess my number, and " +
            "I’ll say R for each digit you get right, ");
        System.out.println("and W for each correct digit " +
            "you get in the wrong place.  If you don’t ");
        System.out.println("use any of the correct digits " +
            "in your guess, I’ll say none.");
        System.out.println();
    }
}