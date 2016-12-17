/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 10
*Class GoodsVendor 
********************************************************/

public class GoodsVendor extends Provider { 

   //Constructor
   /**
   *Creates a goods vendor with given information 
   *
   *@param name     goods vendor's name 
   *@param service  service supplied by goods vendor
   *@param fee      appearance fee charged by goods vendor 
   *@param sale     total sale during previous event
   */ 
   public GoodsVendor(String name, String service, double fee, double sale) { 
      super(name, service, fee, sale);
   }
   
   //Setters 
   public String toString() { 
      String S = ""; 
      return S = S + getName() + " [" + getWhat() + "], sales: $" + getTotalPreviousSales();  
   } 

} 