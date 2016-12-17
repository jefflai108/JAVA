/** 600.107.01, Spring 2016, HW7:  A class that represents a child's piggy bank. */

public class PiggyBank {

    /** How much a penny is worth. */
    public static final int CENTS_PER_PENNY = 1;     
    /** How much a nickel is worth. */
    public static final int CENTS_PER_NICKEL = 5;
    /** How much a dime is worth. */
    public static final int CENTS_PER_DIME = 10; 
    /** How much a quarter is worth. */
    public static final int CENTS_PER_QUARTER = 25; 
    
    /** Number of quarters in the piggy bank. */
    private int quarters;
    /** Number of dimes in the piggy bank. */
    private int dimes;
    /** Number of nickels in the piggy bank. */
    private int nickels;
    /** Number of pennies in the piggy bank. */
    private int pennies;
    
    /**
        Construct a new piggy bank with no coins in it.
     */
    public PiggyBank() {
        quarters = 0;    
        dimes = 0;
        nickels = 0;
        pennies = 0;
    }
    
    /**
        Construct a new piggy bank with the given numbers of coins in it.
        If any argument is negative, the number of that type of coin is set to zero.
        @param quarters   the number of quarters to start with
        @param dimes      the number of dimes to start with
        @param nickels    the number of nickels to start with
        @param pennies    the number of pennies to start with
     */
    public PiggyBank(int quarters, int dimes, int nickels, int pennies) {
        if (quarters >= 0)
            this.quarters = quarters;
        else
            quarters = 0;
        if (dimes >= 0)
            this.dimes = dimes;
        else
            this.dimes = 0;
        if (nickels >= 0)
            this.nickels = nickels;
        else
            this.nickels = 0;
        if (pennies >= 0)
            this.pennies = pennies;
        else
            this.pennies = 0;
    }


    /**
        Return the number of quarters currently in the bank.
        @return     the number of quarters present
     */
    public int getQuarters() {
        return quarters;
    }
    
    /**
        Return the number of dimes currently in the bank.
        @return     the number of dimes present
     */
    public int getDimes() {
        return dimes;
    }
    
    /**
        Return the number of nickels currently in the bank.
        @return     the number of nickels present
     */
    public int getNickels() {
        return nickels;
    }
    
    /**
        Return the number of pennies currently in the bank.
        @return     the number of pennies present
     */
    public int getPennies() {
        return pennies;
    }

    /**
        Add the specified number of quarters to the bank.
        @param howMany  the number to add, assumed to be non-negative
     */
    public void insertQuarters(int howMany){
        quarters += howMany;
    }
    
    /**
        Add the specified number of dimes to the bank.
        @param howMany  the number to add, assumed to be non-negative
     */
    public void insertDimes(int howMany){
        dimes += howMany;
    }
    
    /**
        Add the specified number of nickels to the bank.
        @param howMany  the number to add, assumed to be non-negative
     */
    public void insertNickels(int howMany){
        nickels += howMany;
    }

    /**
        Add the specified number of pennies to the bank.
        @param howMany  the number to add, assumed to be non-negative
     */
    public void insertPennies(int howMany){
        pennies += howMany;
    }
    
    /**
        Remove up to howMany quarters from the bank.  If fewer than
        howMany are present, remove as many as possible.  Does not
        impact the other coin denominations.
        @param  howMany the desired number to remove
        @return     the number actually removed
     */
    public int removeQuarters(int howMany){
        if (quarters >= howMany) {
            quarters -= howMany;
            return howMany;
        }
        int amountFound = quarters;
        quarters = 0;
        return amountFound;
    }

    /**
        Remove up to howMany dimes from the bank.  If fewer than
        howMany are present, remove as many as possible.  Does not
        impact the other coin denominations.
        @param  howMany the desired number to remove
        @return     the number actually removed
     */
    public int removeDimes(int howMany){
        if (dimes >= howMany) {
            dimes -= howMany;
            return howMany;
        }
        int amountFound = dimes;
        dimes = 0;
        return amountFound;
    }

    /**
        Remove up to howMany nickels from the bank.  If fewer than
        howMany are present, remove as many as possible.  Does not
        impact the other coin denominations.
        @param  howMany the desired number to remove
        @return     the number actually removed
     */
    public int removeNickels(int howMany){
        if (nickels >= howMany) {
            nickels -= howMany;
            return howMany;
        }
        int amountFound = nickels;
        nickels = 0;
        return amountFound;
    }

    /**
        Remove up to howMany pennies from the bank.  If fewer than
        howMany are present, remove as many as possible.  Does not
        impact the other coin denominations.
        @param  howMany the desired number to remove
        @return     the number actually removed
     */
    public int removePennies(int howMany){
        if (pennies >= howMany) {
            pennies -= howMany;
            return howMany;
        }
        int amountFound = pennies;
        pennies = 0;
        return amountFound;
    }

    /**
        Obtain the amount of money currently present in the bank, in cents.
        @return     how many cents are currently in the bank
     */
    public int getTotal() {
        return pennies * CENTS_PER_PENNY + nickels * CENTS_PER_NICKEL + 
            dimes * CENTS_PER_DIME + quarters * CENTS_PER_QUARTER;
    }
    
    /**
        Remove the given amount from the bank, using the largest coin denominations
        possible.  If the bank does not contain the full amount requested, remove
        nothing.
        @param  totalWanted the amount to withdraw, expressed in cents
        @return     true if the withdrawal succeeds, and false otherwise
     */
    public boolean withdrawAmount(int totalWanted){        

        /*  
            *-*-*-*-*-*-*-*-*
            NOTE: This implementation does not handle the cases where the
            "greedy" approach fails; for example this method will incorrectly
            return false when the totalWanted is 55 cents and the bank contains
            80 cents in the form of 2 quarters and 3 dimes.
            *-*-*-*-*-*-*-*-*
        */


        /* If there is not enough money in the bank, exit */
        if (totalWanted > getTotal())
            return false;
        
        /* Even if totalWanted is not greater than total in
            bank, the denominations we need may not be present.
            So we'll work with a "temporary copy" of all coins
            to figure out if we can complete the withdrawal. */
        int quartersTemp = quarters;
        int dimesTemp = dimes;
        int nickelsTemp = nickels;

        while (totalWanted >= CENTS_PER_QUARTER && quartersTemp > 0) {
            quartersTemp--;
            totalWanted -= CENTS_PER_QUARTER;
        }
        
        while (totalWanted >= CENTS_PER_DIME && dimesTemp > 0) {
            dimesTemp--;
            totalWanted -= CENTS_PER_DIME;
        }

        while (totalWanted >= CENTS_PER_NICKEL && nickelsTemp > 0) {
            nickelsTemp--;
            totalWanted -= CENTS_PER_NICKEL;
        }        

        if (totalWanted <= pennies) {  /* Then we can complete the transaction */
            quarters = quartersTemp;
            dimes = dimesTemp;
            nickels = nickelsTemp;
            pennies -= totalWanted;
            return true;

        } else {
            return false;
        }
    }
    
    /**
        Determine if the argument holds the same amount of each of the four
        coin denominations as this PiggyBank.
        @param  other   the item to which to compare this PiggyBank
        @return     true if other is a PiggyBank which holds the same number
            of each of the denominations as this PiggyBank, and false otherwise
     */
    public boolean equals(Object other) {
        if (!(other instanceof PiggyBank)) {
            return false;
        }
        PiggyBank otherBank = (PiggyBank) other;
        return (quarters == otherBank.quarters &&
                   dimes == otherBank.dimes    &&
                 nickels == otherBank.nickels  &&
                 pennies == otherBank.pennies);             
    }
    
    /**
        Determine whether the argument holds more or less money than this PiggyBank.
        Note that unlike equals, this comparison is based on total amount of cents, 
        not the particular denominations present.
        @param other    the item to which to compare this PiggyBank
        @return     a negative int if this PiggyBank holds less money than the argument,
            a positive int if this PiggyBank holds more money, and zero if both hold 
            the same amount
        @throws IllegalArgumentException if argument is not an instanceof PiggyBank
     */
    public int compareTo(Object other) {
        if (!(other instanceof PiggyBank)) {
            throw new IllegalArgumentException();
        }
        return getTotal() - ((PiggyBank) other).getTotal();
    }


    /**
        Return a String representation of the contents of this PiggyBank.
        If the PiggyBank contains no coins at all, the returned String is
        "Bank is empty."  Otherwise, the first line of the returned String
        says "Bank contains:", and subsequent lines contain the number of
        each type of coin present, in descending order by denomination,
        along with an appropriate label (e.g., "dimes" or "pennies" when
        more than one is in the bank, but "dime" or "penny" when exactly 
        one of that type is present).  If there are zero of any denomination,
        no line is included for that denomination.
        @return     the String describing the contents
     */
    public String toString() {
        if (getTotal() == 0) {
            return "Bank is empty.";
        }
        String result = "Bank contains: \n";
        if (quarters > 0) {
            result = result + quarters + " quarter";
            if (quarters != 1) {
                result = result + "s";
            }
            result = result + "\n";
        }
       if (dimes > 0) {
           result = result + dimes + " dime";
           if (dimes != 1) {
               result = result + "s";
           }
           result = result + "\n";
       }
       if (nickels > 0) {
           result = result + nickels + " nickel";
           if (nickels != 1) {
               result = result + "s";
           }
           result = result + "\n";
       }
       if (pennies > 0) {
           result = result + pennies + " ";
           if (pennies != 1) {
               result = result + "pennies";
           } else {
               result = result + "penny";
           }
           result = result + "\n";
       }
       return result;
    }

}