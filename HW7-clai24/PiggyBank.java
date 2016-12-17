/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 7
*Task 1
********************************************************/

//PiggyBank.java
//OOP practice

public class PiggyBank { 

   //Instance Variables 
   /**
   *How much a dime is worth.
   */
   public static final int CENTS_PER_DIME = 10; 
   /**
   *How much a nickel is worth.
   */
   public static final int CENTS_PER_NICKEL = 5;
   /**
   *How much a penny is worth.
   */
   public static final int CENTS_PER_PENNY = 1; 
   /**
   *How much a quarter is worth.
   */
   public static final int CENTS_PER_QUARTER = 25;
   /**
   *Number of dimes in the piggy bank.
   */
   private int dimes; 
   /**
   *Number of nickels in the piggy bank.
   */
   private int nickels; 
   /**
   *Number of pennies in the piggy bank.
   */
   private int pennies; 
   /**
   *Number of quarters in the piggy bank.
   */
   private int quarters; 
   
   //Constructors: initialize instance variables 
   /**
   *Construct a new piggy bank with no coins in it.
   */
   public PiggyBank() {
      quarters = 0; 
      dimes = 0; 
      nickels = 0; 
      pennies = 0; 
   }
   
   /**
   *Construct a new piggy bank with the given numbers of coins in it. 
   *If any argument is negative, the number of that type of coin is set to zero.
   *
   *@param quarters  the number of quarters to start with
   *@param dimes  the number of dimes to start with
   *@param nickels  the number of nickels to start with
   *@param pennies  the number of pennies to start with
   */
   public PiggyBank(int quarters, int dimes, int nickels, int pennies) { 
      
      if (quarters > 0)                                                                      
         this.quarters = quarters; 
      else 
         this.quarters = 0; 
      
      if (dimes > 0) 
         this.dimes = dimes; 
      else 
         this.dimes = 0; 
         
      if (nickels > 0) 
         this.nickels = nickels; 
      else 
         this.nickels = 0; 
      
      if (pennies > 0) 
         this.pennies = pennies; 
      else 
         this.pennies = 0; 
         
   }
   
   //GETTERS: access instance variables, but don't change their values
   /**
   *Return the number of quarters currently in the bank.
   *
   *@return the number of quarters present
   */
   public int getQuarters() {
      return quarters; 
   }
   
   /**
   *Return the number of dimes currently in the bank.
   *
   *@return the number of dimes present
   */
   public int getDimes() {
      return dimes; 
   }
   
   /**
   *Return the number of nickels currently in the bank.
   *
   *@return the number of nickels present
   */
   public int getNickels() {
      return nickels;
   }
   
   /**
   *Return the number of pennies currently in the bank.
   *
   *@return the number of pennies present
   */
   public int getPennies() {
      return pennies; 
   }
   
   // SETTERS: modify instance variable values
   /**
   *Add the specified number of quarters to the bank.
   *
   *@param howMany the number to add, assumed to be non-negative
   */
   public void insertQuarters(int howMany) {
      this.quarters += howMany * CENTS_PER_QUARTER; 
   }
   
   /**
   *Add the specified number of dimes to the bank.
   *
   *@param howMany the number to add, assumed to be non-negative
   */
   public void insertDimes(int howMany) {
      this.dimes += howMany * CENTS_PER_DIME; 
   }
   
   /**
   *Add the specified number of nickels to the bank.
   *
   *@param howMany the number to add, assumed to be non-negative
   */
   public void insertNickels(int howMany) {
      this.nickels += howMany * CENTS_PER_NICKEL; 
   }
   
   /**
   *Add the specified number of pennies to the bank.
   *
   *@param howMany the number to add, assumed to be non-negative
   */
   public void insertPennies(int howMany) {
      this.pennies += howMany * CENTS_PER_PENNY; 
   }
   
   /**
   *Remove up to howMany quarters from the bank. 
   *If fewer than howMany are present, remove as many as possible. 
   *Does not impact the other coin denominations.
   *
   *@param howMany the desired number to remove
   *@return the number actually removed
   */
   public int removeQuarters(int howMany) {
      if (howMany >= this.quarters) {
         int left = this.quarters; 
         this.quarters = 0; 
         return left;  
      } else {
         int left = this.quarters - howMany;
         this.quarters -= howMany;
         return left;      
      }
   }
   
   /**
   *Remove up to howMany dimes from the bank. 
   *If fewer than howMany are present, remove as many as possible. 
   *Does not impact the other coin denominations.
   *
   *@param howMany the desired number to remove
   *@return the number actually removed
   */
   public int removeDimes(int howMany) {
      if (howMany >= this.dimes) {
         int left = this.dimes; 
         this.dimes = 0; 
         return left;  
      } else {
         int left = this.dimes - howMany;
         this.dimes -= howMany;
         return left; 
      }
   }
   
   /**
   *Remove up to howMany nickels from the bank. 
   *If fewer than howMany are present, remove as many as possible. 
   *Does not impact the other coin denominations.
   *
   *@param howMany the desired number to remove
   *@return the number actually removed
   */
   public int removeNickels(int howMany) {
      if (howMany >= this.nickels) {
         int left = this.nickels; 
         this.nickels = 0; 
         return left;  
      } else {
         int left = this.nickels - howMany;
         this.nickels -= howMany;
         return left;   
      }
   }
   
   /**
   *Remove up to howMany pennies from the bank. 
   *If fewer than howMany are present, remove as many as possible. 
   *Does not impact the other coin denominations.
   *
   *@param howMany the desired number to remove
   *@return the number actually removed
   */
   public int removePennies(int howMany) {
      if (howMany >= this.pennies) {
         int left = this.pennies; 
         this.pennies = 0; 
         return left;  
      } else {
         int left = this.pennies - howMany;
         this.pennies -= howMany;
         return left;
      }
   }
   
   /**
   *Obtain the amount of money currently present in the bank, in cents.
   *
   *@return how many cents are currently in the bank
   */
   public int getTotal() {
      int total = this.dimes * CENTS_PER_DIME + this.pennies * CENTS_PER_PENNY + 
         this.quarters * CENTS_PER_QUARTER + this.nickels * CENTS_PER_NICKEL; 
      return total; 
   }
   
   /**
   *Remove the given amount from the bank, using the largest coin denominations possible. 
   *If the bank does not contain the full amount requested, remove nothing.
   *
   *@param totalWanted the amount to withdraw, expressed in cents
   *@return true if the withdrawal succeeds, and false otherwise
   */
   public boolean withdrawAmount(int totalWanted) {
      int total = getTotal();
      
      if (totalWanted <= total) {
         
         this.quarters -= totalWanted / CENTS_PER_QUARTER;
         totalWanted %= CENTS_PER_QUARTER;
         this.dimes -= totalWanted / CENTS_PER_DIME;
         totalWanted %= CENTS_PER_DIME;
         this.nickels -= totalWanted / CENTS_PER_NICKEL;
         totalWanted %= CENTS_PER_NICKEL;
         this.pennies -= totalWanted;
         
         return true; 
      } else 
         return false; 
   }
   
   /**
   *Determine if the argument holds the same amount of each of the four coin denominations as thisPiggyBank.   
   *
   *@param other the item to which to compare this PiggyBank
   *@return true if other is a PiggyBank which holds the same number of each of the
   *denominations as this PiggyBank, and false otherwise   */
   public boolean equals(Object other) {
      if (other instanceof PiggyBank) {
         PiggyBank p = (PiggyBank) other; //type cast
         return this.quarters == p.quarters && this.dimes == p.dimes && 
            this.nickels == p.nickels && this.pennies == p.pennies; 
      } else 
         return false; 
   }
   
   /**
   *Determine whether the argument holds more or less money than this PiggyBank. Note that unlike
   *equals, this comparison is based on total amount of cents, not the particular denominations present.
   *
   *@param other the item to which to compare this PiggyBank
   *@return a negative int if this PiggyBank holds less money than the argument, a
   *positive int if this PiggyBank holds more money, and zero if both hold the
   *same amount
   *@throws IllegalArgumentException if argument is not an instanceof PiggyBank
   */
   public int compareTo(Object other) {
      if (!(other instanceof PiggyBank))
         throw new IllegalArgumentException(); 
         
      int diff = getTotal() - ((PiggyBank) other).getTotal();
      return diff; 
   }
   
   /**
   *Return a String representation of the contents of this PiggyBank. If the PiggyBank contains no coins at all, the returned String is "Bank is empty." Otherwise, the first line of the returned String says
   *"Bank contains:", and subsequent lines contain the number of each type of coin present, in descending order by denomination, along with an appropriate label (e.g., "dimes" or "pennies" when
   *more than one is in the bank, but "dime" or "penny" when exactly one of that type is present). If there are zero of any denomination, no line is included for that denomination.
   *
   *@return the String describing the contents
   */
   public String toString() {
      String s = ""; 
      
      if (getTotal() == 0)
         return "Bank is empty.";
      else { 
      s = s + "Bank contains:";
         if (getQuarters() > 1)
            s = s + "\n" + Integer.toString(getQuarters()) + " quarters";
         else if (getQuarters() == 1)
            s = s + "\n" + Integer.toString(getQuarters()) + " quarter";
         
         if (getDimes() > 1)
            s = s + "\n" + Integer.toString(getDimes()) + " dimes";
         else if (getDimes() == 1)
            s = s + "\n" + Integer.toString(getDimes()) + " dime";
            
         if (getNickels() > 1)
            s = s + "\n" + Integer.toString(getNickels()) + " nickels";
         else if (getNickels() == 1)
            s = s + "\n" + Integer.toString(getNickels()) + " nickel";
            
         if (getPennies() > 1)
            s = s + "\n" + Integer.toString(getPennies()) + " pennies";
         else if (getPennies() == 1)
            s = s + "\n" + Integer.toString(getPennies()) + " penny";    
      }
      
      return s; 
   }
   
}//end class
     