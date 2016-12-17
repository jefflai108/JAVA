/*
Divisors.java

HW4 Task 3 SOLUTION
Author: Sara More

This program calculates the value (or one of the values if tied) in a specified range
of positive integers which has the highest number of divisors.

*/

import java.util.Scanner;

public class Divisors
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        
        //Collect the endpoints of the range of values to check
        System.out.println("Given a specific range of positive integers to search, this program will\n" +
        "determine a value in the range which has the highest number of divisors.\n" + 
        "You get to select the range.\n");
        int a;
        int b;

        //Use a do-while loop to validate the input - must both be positive
        do {
            System.out.print("Please specify the range by entering two positive integers: ");
            a = kb.nextInt();
            b = kb.nextInt();
        } while (a <= 0 || b <= 0);


        //Since user may enter values in either order, check to see which is smaller
        //and set limits accordingly
        int lowerLimit;
        int upperLimit;        
        if (a <= b) {
            lowerLimit = a;
            upperLimit = b;   
        } else {
            lowerLimit = b;
            upperLimit = a;
        }
        
        //Echo the input
        System.out.println("Okay, checking values between " + lowerLimit + 
            " and " + upperLimit + "...");
        
        
        //Determine number of divisors of first value in list
        int winnerSoFar;
        int maxDivisors;
        if (lowerLimit == 1)  //Unlike other pos. ints, 1 has only 1 divisor
        {
            winnerSoFar = 1;
            maxDivisors = 1;
        } 
        else
        {
            winnerSoFar = lowerLimit;
            maxDivisors = 2;  //it must be div. by 1 and lowerLimit itself; we won't check below
        
            //Since we already dealt with lowerLimit itself, we only need to check up to half that
            for (int j = 2; j <= lowerLimit / 2; j++) {
                if (lowerLimit % j == 0)
                    maxDivisors++;
            }
        }
        
        
        //See if any other number in the range can beat the number who is the winnerSoFar 
        for (int i = lowerLimit + 1; i <= upperLimit; i++)
        {

            //Calculate number of divisors of this value of i and report it
            int numDivisors = 2;  //i will always be divisible by 1 and i itself; we won't check it

            //As above, we already dealt with i itself, so we only need to check up to half that
            for (int j = 2; j <= i/2; j++)
            {
                if (i % j == 0)
                    numDivisors++;
            }


            //Check if i beats the winnerSoFar; if so, now need to remember i and its number
            if (numDivisors > maxDivisors)
            {
                winnerSoFar = i;
                maxDivisors = numDivisors;
            }
        }
        
        //Output result after all values in range have been checked
        System.out.println("The winning number is " + winnerSoFar + " with " + maxDivisors + " divisors.");
    }
}