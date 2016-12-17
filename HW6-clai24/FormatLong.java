/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 6
*Task 2
********************************************************/

//FormatLong.java
//The program adds a comma after every third digit from right to left from the number user input 

import java.util.Scanner; 

public class FormatLong { 

   public static void main(String[] args) {
   
      Scanner kb = new Scanner(System.in); 
   
      System.out.println("Please enter an integer: ");
      long n = kb.nextLong(); 
   
      System.out.printf("The formatted number is %s.", formatLong(n));

      }//end main 
   
   /**     
   * Returns its long integer argument as a String with commas     
   * inserted so that a comma is used after every third digit     
   * from right to left.  The returned String never begins with     
   * a comma.  If the argument is negative, the returned String     
   * begins with a - symbol.     
   *    
   * @param n the long integer to be formatted     
   * @return  the number formatted with commas as appropriate     
   */    
   public static String formatLong(long n) { 
   
   String free = "" + n; 
   int length = free.length();
   
      if (n >= 0){ 
         if (length <= 3) 
            return free;
         else 
            return formatLong(n/1000)+","+free.substring(length-3);
      } else {
         if (length <= 4) 
            return free;
         else 
            return formatLong(n/1000)+","+free.substring(length-3);
      }

   }//end helper method 
}//end class