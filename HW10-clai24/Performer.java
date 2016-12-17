/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 10
*Class Performer 
********************************************************/

public class Performer extends Provider { 

   //Instance variable 
   /**
   *performer's schedule
   */
   private String schedule; 
   
   //Constructor 
   /**
   *Creates a perfomer with given information 
   *
   *@param name     performer's name 
   *@param service  service supplied by performer 
   *@param fee      appearance fee charged by performer
   *@param sale     total sale during previous event
   *@param schedule performer's schedule
   */
   public Performer(String name, String service, double fee, double sale, String schedule) { 
      super(name, service, fee, sale); 
      this.schedule = schedule; 
   } 
   
   //Getters 
 	/**
	*Get the schedule of the performer
	*
	*@return the schedule of the performer  
   */
   public String getSchedule() { 
      return this.schedule; 
   } 
   
   //Setters
   /**
	*Creates a String representation of a provider.
   *The string representation does not contain sale figure 
   *
	*@return the String representation of a performer 
	*/
   public String toString() {
      String S = ""; 
      return S = S + getName() + " [" + getWhat() + "], fee: $" + getFee() 
         + ", " + getSchedule();
   }
} 