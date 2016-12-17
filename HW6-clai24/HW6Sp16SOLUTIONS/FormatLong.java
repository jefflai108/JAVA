/*
FormatLong.java

HW6 Task 2 SOLUTION
Author: Sara More

This program uses recursion to add the appropriate commas to
an integer value.
*/

import java.util.Scanner;

public class FormatLong {

    public static void main(String[] args) {

        //Uncomment this to see the largest value that can be read in as a long:
        //System.out.println(Long.MAX_VALUE);

        //Collect a long integer from the user
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        long n = in.nextLong();

        //Call formatLong and output the result
        System.out.println("The formatted number is " + formatLong(n) + ".");        

    }
    
    /**
     * Returns its long integer argument as a String with commas
     * inserted so that a comma is used after every third digit 
     * from right to left.  The returned String never begins with
     * a comma.  If the argument is negative, the returned String
     * begins with a - symbol.
     *
     * @param   n   the long integer to be formatted
     * @return      the number formatted with commas as appropriate    
     */
     public static String formatLong(long n) {
        
        // Base case is when no comma is needed at all
        if (n >= 0 && n < 1000) 
            return "" + n;  //return a String instead of a long
        
        // Recursive case 1: when negative number 
        if (n < 0)
            return "-" + formatLong(-n); //call recursively on n without the -
        
        // Recursive case 2: when at least four digits in n
        // Call formatLong on leftmost part of n without the final three
        // digits, then add a comma and the last three digits.
        String number = "" + n;        
        return formatLong(n/1000) + "," + number.substring(number.length()-3);
    }

}
