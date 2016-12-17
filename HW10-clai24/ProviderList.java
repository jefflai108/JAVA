/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 10
*Class ProviderList 
********************************************************/

import java.util.Scanner; 

public class ProviderList implements ProviderCatalog { 

   //Instance Variable 
	/**
   *The default initial size of the catalog 
   */
	public static final int START_SIZE = 5;
	/**
   *Declare the provider list(array) 
   */
   private Provider[] P; 
   /**
   *Number of actual providers in the provider array  
   */
   private int numActualProvider; 
   
   //Constuctor
   public ProviderList() { 
      P = new Provider[START_SIZE];
      this.numActualProvider=0; 
   } 
   
   //Getters 
   /**
   *Return the number of providers present in the list.
   *
   *@return the number of providers in the list
   */
   public int getNumProviders() { 
      return numActualProvider; 
   }
   
   //Setters
	/**
	*Adds a new Provider, as long as no other Provider in the catalog has the 
   *same name (ignoring case).
	*
	*@param p the new Provider to add
	*@return true if the Provider was added, false otherwise
	*/
	public boolean add(Provider p) { 
      int num = getNumProviders();
      for (int i=0; i<P.length; i++) { 
         if ((P[i] != null) && P[i].equals(p)== true)
            return false;
      } 
      if (num == P.length) { 
         Provider[] temp = new Provider[2*P.length];
         for (int i=0; i<num; i++) 
            temp[i] = P[i]; 
         P = temp;  
      }   
      P[num] = p;
      
     
      numActualProvider++; 
      return true; 
   } 
	/**
	*Removes all Providers from the list whose total sales in the previous
	*event is less than the amount of the parameter, and returns the number 
   *of Providers that were removed from the list.  This can never cause
   *the removal of a Performer, since Performers always have zero sales.
	*
	*@param minSales the minimum threshold for sales in the previous event
	*@return the number of Providers removed
	 */
	public int remove(double minSales) { 
      int count = 0; 
      int num = numActualProvider; 
      for (int i=0; i<num; i++) { 
         if (P[i].getTotalPreviousSales() < minSales){
            P[i] = P[num-1];
            numActualProvider--;
            count++;
         }
      }
      return count; 
   }
	/**
	*Sorts the Providers by sales during the previous event (descending order).
   *Sort method is adapted from class note selection sort 
	*/
	public void sort() { 
   Provider temp;
   int maxIndex;  // where biggest so far is 
            
   for (int start=0; start < numActualProvider-1; start++) {
      maxIndex = start;
      for (int i=start+1; i < numActualProvider; i++) { // look for better max
         if (P[i].getTotalPreviousSales() > P[maxIndex].getTotalPreviousSales())
            maxIndex = i;
      }
      // swap min with start
      temp = P[start];
      P[start] = P[maxIndex];
      P[maxIndex] = temp;
      }   
   }
	/**
	*Outputs to the screen all the Providers in the list.
	*/
	public void display() { 
      if (numActualProvider == 0) 
         System.out.println("There are currently no Provider in the list.\n");
      else { 
         for (int i=0; i<numActualProvider; i++) 
            System.out.println(P[i].toString());
      }
   }
	/**
	*Indicates that a given FoodVendor's license to serve is confirmed.  The method
	*first supplies a list of existing food vendors, with indices, then asks the user
   *for the index of the FoodVendor to confirm. If the user enters an index which
   *does not represent a FoodVendor, no status is changed.
	*
	*@param kb a Scanner which can collect keyboard input, needed because
	*the current method will collect user input
	*/
	public void confirmLicenseToServeFood(Scanner kb) { 
      //Collect user choice c, validate that c is a FoodVendor
      kb = new Scanner(System.in); 
      int count = 0; 
      for (int i=0; i<numActualProvider; i++) { 
         if (P[i] instanceof FoodVendor) { 
            System.out.println(i+")"+P[i].toString());   
            count++;
         }    
      } 
      if (count == 0) 
         System.out.println("There are currently no food vendors in the list.\n");
      else { 
         System.out.print("Enter index ->"); 
         int c = kb.nextInt(); 
         if (!(P[c] instanceof FoodVendor))
            System.out.print("invalid input!");   
         else 
            ((FoodVendor)P[c]).confirmLicense(); 
      }
   }
	/**
	*Displays the Providers in the list grouped by type (performers, activity suppliers, 
	*(non-food) goods vendors, food vendors).
	*/
	public void displayGroups() { 
      System.out.println("-- Groups --\nPerformers:");
      int count1 = 0; 
      int count2 = 0; 
      int count3 = 0; 
      int count4 = 0;
       
      //performers
      for (int i=0; i<numActualProvider; i++) {
         if (P[i] instanceof Performer){ 
            System.out.println(P[i].toString()); 
            count1++; 
            }
      }
      if (count1 == 0) 
         System.out.println("There are no performers currently in the list.\n");
      else 
         System.out.println();
      //Activity Suppliers  
      System.out.println("Activity Suppliers:"); 
      for (int i=0; i<numActualProvider; i++) {
         if (P[i] instanceof ActivitySupplier){
            System.out.println(P[i].toString()); 
            count2++; 
         }
      }
      if (count2 == 0) 
         System.out.println("There are no activity suppliers currently in the list.\n");
      else 
         System.out.println();
      //Good Vendors  
      System.out.println("Good Vendors:");  
      for (int i=0; i<numActualProvider; i++) {
         if (P[i] instanceof GoodsVendor && !(P[i] instanceof FoodVendor)){ 
            System.out.println(P[i].toString()); 
            count3++; 
            }
      }
      if (count3 == 0) 
         System.out.println("There are no good vendors currently in the list.\n");
      else 
         System.out.println();
      //Food Vendors  
      System.out.println("Food Vendors:");  
      for (int i=0; i<numActualProvider; i++) {
         if (P[i] instanceof FoodVendor){ 
            System.out.println(P[i].toString()); 
            count4++; 
            }
      }
      if (count4 == 0) 
         System.out.println("There are no food vendors currently in the list.\n"); 
      else 
         System.out.println();  
   }
	/**
	*Returns the Performer or ActivitySupplier with the greatest appearance fee.
   *If there is a tie, returns just one such provider. If there are no Performers 
   *or ActivitySuppliers in the list, returns null.
	*
	*@return the Performer or ActivitySupplier with the greatest appearance fee,
   *or null if no Performers or ActivitySuppliers in list
	*/
	public Provider getPerfOrActSuplLargestFee() { 
      double num = 0.0; 
      int index = -1;
      for (int i=0; i<numActualProvider; i++) { 
         if (P[i] instanceof ActivitySupplier || P[i] instanceof Performer) 
            if (P[i].getFee() > num) {
               num = P[i].getFee();
               index = i;
            }
      }
      if (index == -1) 
         return null; 
      return P[index];
   }
} 