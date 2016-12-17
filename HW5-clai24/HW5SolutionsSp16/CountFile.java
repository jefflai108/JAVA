/*
CountFile.java

HW5 Task 1 SOLUTION
Author: Sara More

This program takes as input from the user the name of an input
file and output file.  It then opens the input file and counts
the number of occurrences of digits on consecutive lines of the
file, reporting counts to the output file, one per line.  Any
lines in the input file that contain the substring SKIP (case-
insensitively) are skipped over, and only the first nine 
"non-SKIP" lines in the input file are read. In the resulting 
output file, the value on line i is the number of occurrences
of digit i on the ith of the non-SKIP lines.
*/


import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CountFile {

    public static void main(String[] args) throws IOException{

        final int LIMIT = 9;  //largest values to search for in input file

        //Collect name of input file from keyboard
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter the name of the input file: ");
        String inputFileName = kb.next();
        System.out.print("Please enter the name of the output file: ");
        String outputFileName = kb.next();

        //Open the output file where we'll store our results
        PrintWriter outFile = new PrintWriter(new FileWriter(outputFileName));
        
        //Open the input file and read lines until file ends
        //or we've read LIMIT lines without the word SKIP
        Scanner inFile = new Scanner(new FileReader(inputFileName));
        int numLinesWithoutSkip = 0;

        while (inFile.hasNextLine() && numLinesWithoutSkip < LIMIT) {
            //Collect next line from input file
            String line = inFile.nextLine();

            //Process it if it doesn't contain SKIP or skip or SkIp, etc.
            if (!lineContainsSkip(line)) {
                numLinesWithoutSkip++;
                outFile.println(countLine(numLinesWithoutSkip, line));            
            }

        }
        
        //In case we didn't have LIMIT non-SKIP lines, add 0's for rest of output lines
        while (numLinesWithoutSkip < LIMIT) {
            outFile.println("0");
            numLinesWithoutSkip++;
        }

        //Close both input and output files
        inFile.close();
        outFile.close();
    }
    
    //Returns number of times the given number appears within the given line.
    public static int countLine(int number, String line) {

        String numAsString = "" + number;

        int length = line.length();  //avoid re-calling this method in loop header
        int count = 0;

        //Loop over all single-char substrings in line, looking for numAsString
        for (int i = 0; i < length; i++) {
            if (line.substring(i,i+1).equals(numAsString)) {
                count++;
            }
        }

        return count;
    }


    //Determines whether line contains SKIP or skip or SkIp, etc.
    public static boolean lineContainsSkip(String line) {
        return line.toLowerCase().contains("skip");
    }

}