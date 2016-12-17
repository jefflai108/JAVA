/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 5
*Task 1
********************************************************/

//Countfile.java
//The program analyze the data in the input file to count and report to specific output file 
//the number of 1's on the first line of input file, the number of 2's on the second line of 
//input file, and so on, up to the number of 9's on the 9th line of the input file. Any line 
//that contains SKIP (case insensitive) should not be included in the count. If there are more 
//lines in the file then the one treated as line 9, the remaining lines can be ignored. The output 
//file will always contain exactly 9 integers, with one on each line. 

import java.io.IOException;
import java.io.FileReader; 
import java.util.Scanner; 
import java.io.FileWriter; 
import java.io.PrintWriter; 

public class CountFile {

   //add "throws IOException" for inputing files
   public static void main(String[] args) throws IOException {

   //Declare variables 
   String inputFile, outputFile; 
   int count;
   String line;
   
   //ask the user file name for both input and output file  
   Scanner kb = new Scanner(System.in); //so we can collect data 
   System.out.println("What's the name for input file?");
   inputFile = kb.next(); 
   System.out.println("What's the name for output file?");
   outputFile = kb.next();

   //Set up file input output mechanism 
   Scanner inFile = new Scanner(new FileReader(inputFile));
   PrintWriter outFile = new PrintWriter(new FileWriter(outputFile));
 
   count = 0; 
   
   while(inFile.hasNextLine()){ 
      
      //if-else to ignore line number > 9
      if (count < 9) {
         line = inFile.nextLine(); 
         
         //determine if "SKIP"is in the line or not before calling out helper method 
         if (line.toUpperCase().indexOf("SKIP") > -1){
            count--;
         } else {
            //call out helper method 
            outFile.println(countLine(count+1, line)); 
         }     
           
      } //end if-else 
       count++; 
   } //end while 
  
    
   for (int i = count; i<9; i++) {
      outFile.println(0);
   }
      
   inFile.close(); //close file Scanner when finish using it 
   outFile.close(); //save the changes to file 
   
   } //end main

//helper method 
//Returns number of times the given number appears within the given line.
   public static int countLine(int number, String line) {
      //Declare variable 
      int count;              

         //for loop to count the number of times the nubmer appeared in the line 
         count = 0; 
         for (int i=0, len=line.length(); i<len; i++) {
            if (line.charAt(i) -'0'== number) {
               count++;
            } //end if-else  
         } //end for loop
         return count; 
  
      
   } //end countLine 

} //end class