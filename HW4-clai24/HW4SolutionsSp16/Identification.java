/*
Identification.java

HW4 Task 2 SOLUTION
Author: Sara More

This program simulates a user entering a PIN number at an ATM,
allows him or her up to three tries to match a target PIN
before locking the user out.

*/

import java.util.Scanner;

public class Identification
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        final String TARGET_PIN = "1234";
        
        String attempt;
        int numAttempts = 0;
        
        //Allow PIN entry attempts as long as last attempt was incorrect and
        //we haven't already tried three times
        do
        {
            System.out.print("Please enter your PIN number: ");
            attempt = kb.next();
            numAttempts++;
            
        } while (!attempt.equals(TARGET_PIN) && numAttempts < 3);
        
        //Determine why loop ended
        if (attempt.equals(TARGET_PIN))
            System.out.println("You are successfully logged in.");
        else //too many incorrect attempts
            System.out.println("You made 3 unsuccessful login attempts. " +
                "Your account is locked. \n Please contact the bank.\n");

    }
}