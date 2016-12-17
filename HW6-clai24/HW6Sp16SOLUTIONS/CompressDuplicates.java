/*
CompressDuplicates.java

HW6 Task 3 SOLUTION
Author: Sara More

This program collects a line of text from the user,
then uses recursion to "compress" the string so that
when a run of consecutive duplicate characters appears,
the duplicate values are replaced by the count of
duplicates instead.

For example, an input string such as 
aaabbaadddde

becomes
a3b2a2d4e1

*/

import java.util.Scanner;

public class CompressDuplicates {

    public static void main(String[] args) {
    
        //Collect a line of input from the user (may include spaces)
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a line of input: ");
        String s = in.nextLine();

        //Call method and report result
        System.out.println("The compressed line is " + compressDuplicates(s) + ".");        

    }
    
    /**
     * Replaces duplicate consecutive symbols in a line of text with 
     * the symbol and the number of times it appears in that location.
     *
     * @param   s   the string from which duplicates are compressed
     * @return      the compressed string
     */
    public static String compressDuplicates(String s) {
        //no reason to make another call if original string was empty
        if (s.length() == 0) {
            return "";
        }
        //make call to overloaded 3-argument method compressDuplicates,
        //and send back exactly what it answers
        return compressDuplicates(s, "", 0);
    
    }

    /**
     * Replaces duplicate consecutive symbols in a line of text with 
     * the symbol and the number of times it appears in that location.
     * If the parameter last equals the empty string, this method
     * returns the empty string.
     *
     * @param   s       the string from which duplicates are compressed
     * @param   last    a string containing the last single symbol seen
     * @param   times   the number of times last has been encountered so far
     * @return          the compressed string
     */
    public static String compressDuplicates(String s, String last, int times) {

        //Determine length of string
        int len = s.length();

        //Base case is when string has length 0, but need to split into two
        //subcases to see if there was a letter prior to this whose count
        //needs to be added into the string
        if (len == 0 && last.equals("")
            return "";  //this should've been caught by 1-arg method anyway

        if (len == 0)  //we now know for sure that last is not empty
            return last + times;
        

        //Recursive case: when there is at least one character in the string
        String now = s.substring(0,1);

        //Determine if current symbol ("now") matches the last symbol seen.
        if (now.equals(last))
            //If so, make recursive call with rest of string and times increased
            //by one, but do not add any information to the result returned
            return compressDuplicates(s.substring(1), last, times+1);

        //If "now" is different, then concatenate count and previous symbol
        //before making recursive call on rest of string with times == 1, 
        //UNLESS this is first symbol checked (in which case don't concatenate anything)
        if (last.equals("") && times == 0)
            return compressDuplicates(s.substring(1), now, 1);

        return last + times + compressDuplicates(s.substring(1), now, 1);
    
    }


}