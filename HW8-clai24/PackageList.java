/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 8
*Task 2
********************************************************/

//PackageList.java
//An Instantiable Java class named PackageList build on the Package class from Task 1, 
//and will be used to track a group of packages that, for example, may be traveling together on a delivery truck.

public class PackageList {

   //instance variable 
   /**
   *The new Package array with a starting upper limit on capacity of 5 Package objects.
   */
   private static final int START_SIZE = 5; 
   /**
   *The total allowable weight weight for the packages. 
   */
   private final double TOTAL_ALLOWABLE_WEIGHT; 
   /**
   *Number of actual packages in the package list 
   */
   private static int NUM_ACTUAL_OBJECT; 
   /**
   *Declare the package list(array)
   */
   private Package[] p;   
   //Constructor 
   /**
   *Create a new empty PackageList with capacity START_SIZE, which is 5.
   *
   *@param allowable_weight the weight limit in pounds for this collection of packages
   */
   public PackageList(double allowable_weight) {
      p = new Package[START_SIZE]; 
      this.TOTAL_ALLOWABLE_WEIGHT = allowable_weight; 
      this.NUM_ACTUAL_OBJECT = 0; 
   } 
   
   //Getters
   /**
   *Return the number of packages present in the list.
   *
   *@return the number of packages in the list
   */
   public int getNumPackages() { 
      return NUM_ACTUAL_OBJECT; 
   }
   /**
   *Return the total weight, in pounds, of all packages present in the list.
   *
   *@return the total package weight in pounds
   */
   public double getTotalWeight() { 
      double sum = 0; 
      for (int i=0; i<getNumPackages(); i++) { 
         sum += p[i].getWeight(); 
      }
      return sum; 
   } 
   /**
   *Get the a string description about a specific package in the list.
   *
   *@param ID  the tracking number for the package
   *@return the information about the package, if it exists, or otherwise "***packagenot found***".
   */
   public String getPackageInfo(String ID) { 
      int num = findPackage(ID); 
      if (num == -1) 
         return "***package not found***";
      else 
         return p[num].toString(); 
   } 
   /**
   *Find the package ID and returns the index at whihch the package is located in the package list
   *if it doesn not find it, returns -1.
   *
   *@param ID  the package tracking ID 
   *@return the index of the package in the package list, if not return -1 
   */
   private int findPackage(String ID) { 
      int i=0; 
      while (i < getNumPackages()) { 
         if (p[i].getTrackingID().equalsIgnoreCase(ID)) 
            return i; 
         else 
            i++; 
      } 
      return -1; 
   }
   
   //Setters
   /**
   *Add a new package to the list, if the new item does not have the same tracking ID as an existing
   *package (ignoring case), and if the new item won't put the list over its allowable weight. If more space
   *is needed in the list to make this addition, this method doubles the list's current capacity.
   *
   *@param trackingID  the unique ID number used to track the package to be added
   *@param length  the length of the package to be addded, in inches
   *@param width  the width of the package to be addded, in inches
   *@param height  the height of the package to be addded, in inches
   *@param weight  the weight of the package to be addded, in pounds
   *@return true if the item was added successfully, or, false if the new item could not
   *be added to the list
   */
   public boolean addEntry(String trackingID,double length,double width,double height,double weight) {
      
      int num = getNumPackages(); 
      
      if (getTotalWeight() + weight > TOTAL_ALLOWABLE_WEIGHT) 
         return false; 
      
      int i = 0; 
      while (i < num) { 
         if (p[i].getTrackingID().equalsIgnoreCase(trackingID)) 
            return false;
         else 
            i ++;
      } 
  
      if (num == p.length) { //double the size of the array if the array if full
         Package[] temp = new Package[2*p.length]; //create a temporary array 
         for (int j=0; j < num; j++) 
            temp[j] = p[j]; 
         p = temp; 
      }      
      
      p[num] = new Package(trackingID, length, width, height, weight);
      this.NUM_ACTUAL_OBJECT++;
      return true;  
   }
   /**
   *Given a trackingID, remove the entry in the list (if any) that matches. The trackingIDs do not need to
   *match with respect to case. The resulting list need not store its remaining entries in the same order as
   *prior to the removal of this package.
   *
   *@param trackingID  the unique ID number that identifies a package   
   *@return true if a package was removed, false otherwise
   */
   public boolean removeEntry(String trackingID) { 
      int num1 = findPackage(trackingID); 
      int num2 = getNumPackages(); 
      
      if (num1 == -1) 
         return false; 
      
      p[num1] = p[num2-1]; 
      this.NUM_ACTUAL_OBJECT--; 
      return true; 
   } 
   /**
   *Return a String containing all the packages in the package list, on separate lines, with details for each
   *package presented exactly as indicated by the Package's toString() method. No particular ordering of
   *the packages is guaranteed. If the package list currently contains no items, the returned String is
   *"***no entries present***".
   * 
   *@return a string description of the packages currently present in the list
   */
   public String toString() { 
      String s = ""; 
      if (getNumPackages() == 0) 
         return "***no entries present***";
      for (int i=0; i<getNumPackages(); i++) { 
         s = s + p[i].toString(); 
      } 
      return s; 
   } 
   /**
   *Return a String containing all the oversize packages in the package list, one per line, with details as   
   *given by the Package's toString() method. No particular ordering of the packages is guaranteed. If the
   *package list currently contains no oversize items, the returned String is "***no oversize entries
   *present***".
   * 
   *@return the list of packages that are classified as oversize
   */
   public String getOversizePackageList() { 
      String s = "";
      for (int i=0; i<getNumPackages(); i++) { 
         if (p[i].isOversize())
            s = s + p[i].toString(); 
      } 
      
      if (s.equals(""))
         return "***no oversize entries present***";
      else
         return s;
   } 
}//end class