/*
Isogram.java

HW4 Task 1 SOLUTION
Author: Sara More

This program determines whether a single word entered
by the user is an isogram (a word containing no repeated letters)
or not, and outputs the result.

*/


import java.util.Scanner;

public class Isogram {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        
        System.out.print("Please enter a word (no spaces or punctuation, please): ");
        String origWord = kb.next();
        String word = origWord.toLowerCase();
        
        boolean isIsogram = true;
        
        int len = word.length();
        
        int i = 0;
        while(isIsogram && i < len) {
            for (int j = i+1; j < len; j++) {
                if (word.charAt(j) == word.charAt(i))
                    isIsogram = false;
            }
        
            i++;
        }
        System.out.print("The word " + origWord + " is ");
        if (!isIsogram) {
            System.out.print("NOT ");
        }
        System.out.println("an isogram.");


    }
}