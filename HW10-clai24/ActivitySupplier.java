/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 10
*Class ActivitySupplier 
********************************************************/

public class ActivitySupplier extends Provider { 

   //Constructor
   /**
   *Creates a activity suppplier with given information 
   *
   *@param name     activity supplier's name 
   *@param service  service supplied by activity supplier
   *@param fee      appearance fee charged by activity supplier 
   *@param sale     total sale during previous event
   */ 
   public ActivitySupplier(String name, String service, double fee, double sale) { 
      super(name, service, fee, sale);
   }
} 