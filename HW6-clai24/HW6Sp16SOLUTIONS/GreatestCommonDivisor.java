
/*
GreatestCommonDivisor.java

HW6 Task 1 SOLUTION
Author: Sara More

This program uses a recursive implementation of the Euclidean
algorithm to output the greatest common divisor of an integer
entered by the user.
*/


import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void main(String[] args) {

        //Collect two integers from the user
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter two integers: ");
        int a = in.nextInt();
        int b = in.nextInt();

        //Output the result of calling the gcd method
        System.out.println("Their greatest common divisor is " + gcd(a,b) + ".");        

    }


    /**
     * Determines the greatest common divisor of arguments a and b using
     * a recursive implementation of the Euclidean algorithm.
     *
     * @param   a   the first number
     * @param   b   the second number
     * @return      the gcd of a and b
     */
    public static int gcd(int a, int b) {

        //If b is zero, then a and b are both divisible by a
        if (b == 0) {
            return a;        
        }

        //If b is not zero, then gcd(a,b) = gcd(b,r), so make
        //recursive call to find out gcd(b,r).  We know this
        //call gets us closer to base case since r is by
        //definition smaller than b.
        int r = a % b;
        return gcd(b,r);    
    }

}