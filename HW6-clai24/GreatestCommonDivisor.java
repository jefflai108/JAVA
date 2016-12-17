/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 6
*Task 1
********************************************************/

//GreatestCommonDivisor.java
//The program finds the greatest common divisor of two user input integers 

import java.util.Scanner; 

public class GreatestCommonDivisor { 

   public static void main(String[] args) { 
   
      Scanner kb = new Scanner(System.in); 
      
      System.out.println("Please enter two integers: ");
      int a = kb.nextInt();
      int b = kb.nextInt(); 
      
      int c;
      
      if (a == 0)
         c = b;
      else if (b ==0)
         c = a;
      else    
         c = gcd(a,b); //call out helper method 
      
      System.out.printf("Their greatest common divisor is %d.", c);
   
   }//end main 

   /**     
   * Determines the greatest common divisor of arguments a and b using    
   * a recursive implementation of the Euclidean algorithm.     
   *     
   * @param a the first number     
   * @param b the second number 
   * @return the gcd of a and b    
   */    
   public static int gcd(int a, int b) {
      
      int c = a % b; 
   
      if (c == 0) 
         return b; 
      else if (c == a) {
         c = b % a; 
         return gcd(b%a,a);
      } else { 
         return gcd(a%b,b);
      }
 
   }//end helper method 
}//end class 