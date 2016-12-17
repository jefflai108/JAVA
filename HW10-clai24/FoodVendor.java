/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 10
*Class FoodVendor 
********************************************************/

public class FoodVendor extends GoodsVendor { 

   //Instance variable 
   /**
   *indicates whether their possession of a license to serve food has been confirmed
   */
   private String license; 
   
   //Constructor 
   /**
   *Creates a food vendor with given information 
   *
   *@param name     food vendor's name 
   *@param service  service supplied by food vendor 
   *@param fee      appearance fee charged by food vendor
   *@param sale     total sale during previous event
   */
   public FoodVendor(String name, String service, double fee, double sale) { 
      super(name, service, fee, sale); 
      this.license = "false";
   } 
   
   //Getters 
 	/**
	*Get their license status 
	*
	*@return their license status 
	*/
   public String getLicense() { 
      return this.license; 
   } 
   
   //Setters
   /**
	*Set their license status to confirmed (true)
	*
	*@return their license status 
	*/
   public void confirmLicense() { 
      this.license = "true"; 
   } 
   /**
	*Creates a String representation of a provider.
   *The string representation does not contain sale figure 
   *
	*@return the String representation of a performer 
	*/
   public String toString() {
      String S = super.toString(); 
      return S + ", " + getLicense(); 
   }
} 