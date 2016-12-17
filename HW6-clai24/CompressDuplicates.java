/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 6
*Task 3
********************************************************/

//CompressDuplicates.java
//The program compress the string user input

import java.util.Scanner; 

public class CompressDuplicates {
   
   public static void main(String[] args) {
       
      Scanner kb = new Scanner(System.in); 
   
      System.out.println("Please enter a line of input: ");
      String s = kb.nextLine(); 
   
      System.out.printf("The compressed line is %s.", compressDuplicates(s));
   
   }//end main
   
   /**     
   * Replaces duplicate consecutive symbols in a line of text with     
   * the symbol and the number of times it appears in that location.     
   *     
   * @param s the string from which duplicates are compressed     
   * @return  the compressed string     
   */    
   public static String compressDuplicates(String s){

      return compressDuplicates(s, "", 0);//call out second helper method
   
   }//end first helper method 
   
   /** 
   * Replaces duplicate consecutive symbols in a line of text with 
   * the symbol and the number of times it appears in that location. 
   * If the parameter last equals the empty string, this method 
   * returns the empty string. 
   * 
   * @param  s     the string from which duplicates are compressed
   * @param  last  a string containing the last single symbol seen
   * @param  times the number of times last has been encountered so far 
   * @return       the compressed string 
   */    
   public static String compressDuplicates(String s, String last, int times) {
     
      if (s.equals("")) 
         return last + "";
      else {
         if (times == 0) { 
            last = last + s.charAt(times);
            times++;
            return compressDuplicates(s,last,times);
         } 
         else {
            if ((times < s.length()) && (s.charAt(times) == s.charAt(times-1))) {
               times++;
               return compressDuplicates(s,last,times); 
            } 
            else {
               if (s.length() != 1) {
                  s = s.substring(times);
                  last = last + Integer.toString(times);
                  times = 0; 
                  return compressDuplicates(s,last,times); 
               } 
               else {
                  s="";
                  last = last + Integer.toString(times);
                  times = 0; 
                  
                  return compressDuplicates(s,last,times);
               }
            }
         }     
      }
   
   }//end second helper method 
}//end class









































