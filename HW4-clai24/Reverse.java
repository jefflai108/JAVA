import java.util.Scanner;

public class Reverse {

   public static void main(String[] args) {
      
      Scanner kb = new Scanner(System.in);
            
      String str = kb.nextLine();
      
      System.out.println(reverse(str));
   
   } 
   
   public static String reverse(String s) {
  
   int len = s.length();  
   //base case is when s contains fewer than 2 characters   
   if (len < 2) {
      return s;
   }
   //recursive case (writing else here is optional) 
   char firstChar = s.charAt(0); 
   String otherpartReversed = reverse(s.substring(1)); 
   return otherpartReversed + firstChar;
   
   }
}