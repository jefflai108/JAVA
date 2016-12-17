/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 10
*Class Provider 
********************************************************/

public class Provider implements Provides { 

   //Instance variables 
	/**
   *provider's name 
   */
   private String name; 
   /**
   *type of goods/services supplied by provider
   */
   private String service; 
   /**
   *the appearance fee charged by the provider
   */
   private double fee; 
   /**
   *total sales during previous event 
   */
   private double sale;
   
   //Constructor 
   /**
   *Creates a provider with given information 
   *
   *@param name     provider's name 
   *@param service  service supplied by provider
   *@param fee      appearance fee charged by provider 
   *@param sale     total sale during previous event
   */
   public Provider(String name, String service, double fee, double sale) { 
      this.name = name; 
      this.service = service; 
      this.fee = fee; 
      this.sale = sale; 
   }
   
   //Getters
   /**
	*Returns the name of the provider.
	*
	*@return the provider name
	*/
	public String getName() { 
      return this.name; 
   }
	/**
	*Returns what type of goods/services are supplied by provider.
	*
	*@return the type of goods/services supplied
	*/
   public String getWhat() { 
      return this.service; 
   }
	/**
	*Returns the appearance fee charged by the provider.
	*
	*@return the appearance fee amount (0.0 if no charge)
	*/
	public double getFee() { 
      String s = String.format("%1$.2f",this.fee);      
      return Double.parseDouble(s); 
   }
 	/**
	*Get the total sales by this provider during previous event.
	*
	*@return the total sales from previous event
	*/
	public double getTotalPreviousSales() { 
      String s = String.format("%1$.2f",this.sale);
      return Double.parseDouble(s);  
   }
	
   //Setters
   /**
	*Checks if two providers are equal by checking if their 
   *names are equal (ignoring case).
	*
	*@param o  the object being compared
	*@return true if the provider names match, false otherwise
	*/
	@Override
	public boolean equals(Object o) { 
      if (!(o instanceof Provider)) 
         return false;
      return ((Provider)o).getName().equalsIgnoreCase(getName());
   }
	/**
	*Creates a String representation of a provider.
   *Any double values appearing in the representation are formatted to two decimal places. 
   *
	*@return the String representation of a transactor
	*/
	@Override
	public String toString() {
      String S = ""; 
      return S = S + getName() + " [" + getWhat() + "], fee: $" + getFee() 
         + ", sales: $" + getTotalPreviousSales();  
   } 
   /**
   *Consider providers which grossed less money during the previous event as 
   *“less than” providers which grossed more.
   *
   *@param newObject   
   *@return true if more, false if less, thorws exception if object is not provider type  
   */
   public int compareTo(Object newObject) { 
      if (!(newObject instanceof Provider))
         throw new IllegalArgumentException("Not a provider!");
      int i; 
      if (((Provider)newObject).getTotalPreviousSales() == getTotalPreviousSales())
         i=0;    
      else if (((Provider)newObject).getTotalPreviousSales() > getTotalPreviousSales())
         i=1;
      else 
         i=-1;
      return i;    
   }
}
