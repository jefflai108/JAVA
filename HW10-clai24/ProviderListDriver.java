/*******************************************************
*Cheng-I Lai
*clai24
*600.107 Introductory Programming in Java, Spring 2016
*Homework 10
*Class ProviderListDriver  
********************************************************/

import java.util.Scanner; 

public class ProviderListDriver { 
   /**
   *This is the driver class that will contain an instance of ProviderList. 
   *The user will be able to perform different actions to the ProviderList 
   *instance by adding, removing, sorting, modifying, and printing Providers via a 
   *menu that will take input from the user. 
   */
   public static void main(String args[]) {

      //Declare variables
      String name, schedule,service;
      String winner = "";  
      double sale, fee;
      int choice;
      
      Scanner kb = new Scanner(System.in); 
      ProviderList P = new ProviderList(); 
      
      do {  

      System.out.println("0) Quit");
      System.out.println("1) Add new performer");
      System.out.println("2) Add new activity supplier");
      System.out.println("3) Add new goods vendor");
      System.out.println("4) Add new food vendor");
      System.out.println("5) Print all the providers");
      System.out.println("6) Display providers in groups");
      System.out.println("7) Sort all providers sorted by total sales at previous event (descending)");
      System.out.println("8) Remove all non-Performers below a total sales threshold");
      System.out.println("9) Record that a food vendor’s license to serve has been confirmed");
      System.out.println("10) Get performer or activity supplier with largest appearance fee");         
      System.out.print("Choice --> ");
      choice = kb.nextInt();
      kb.nextLine();
      
         switch(choice) { 
            case 0: 
               break;
            case 1: 
               System.out.print("Enter name for performer ->  ");
               name = kb.nextLine();      
               System.out.print("Enter what type -> ");
               service = kb.nextLine();
               System.out.print("Enter schedule of performances -> ");
               schedule = kb.nextLine();
               System.out.print("Enter appearance fee -> ");
               fee = kb.nextDouble(); 
               Performer p = new Performer(name, service, fee, 0.00, schedule);
               if (P.add(p) == false) 
                  System.out.printf("Performer %s not successfully added.%n%n", name);
               else 
                  System.out.printf("Performer %s successfully added.%n%n", name);
               break;
            case 2:
               System.out.print("Enter name for activity supplier -> ");
               name = kb.nextLine();
               System.out.print("Enter what type -> ");
               service = kb.nextLine();
               System.out.print("Enter appearance fee -> ");
               fee = kb.nextDouble(); 
               System.out.print("Enter total sales at previous event -> ");
               sale = kb.nextDouble();
               ActivitySupplier a = new ActivitySupplier(name, service, fee, sale);
               if (P.add(a) == false) 
                  System.out.printf("Activity supplier %s not successfully added.%n%n", name);
               else 
                  System.out.printf("Activity supplier %s successfully added.%n%n", name);
               break;
            case 3:
               System.out.print("Enter name for goods vendor -> ");
               name = kb.nextLine();
               System.out.print("Enter what type -> ");
               service = kb.nextLine();
               System.out.print("Enter total sales at previous event -> ");
               sale = kb.nextDouble();
               GoodsVendor g = new GoodsVendor(name, service, 0.00, sale);
               if (P.add(g) == false) 
                  System.out.printf("Goods vendor %s not successfully added.%n%n", name);
               else 
                  System.out.printf("Goods vendor %s successfully added.%n%n", name);
               break;
            case 4:
               System.out.print("Enter name for food vendor -> ");
               name = kb.nextLine();
               System.out.print("Enter what type -> ");
               service = kb.nextLine();
               System.out.print("Enter total sales at previous event -> ");
               sale = kb.nextDouble();
               FoodVendor f = new FoodVendor(name, service, 0.00, sale);
               if (P.add(f) == false) 
                  System.out.printf("Food vendor %s not successfully added.%n%n", name);
               else 
                  System.out.printf("Food vendor %s successfully added.%n%n", name);
               break;
            case 5:
               P.display();
               System.out.println(); 
               break;
            case 6:
               P.displayGroups(); 
               break; 
            case 7:
               P.sort();
               System.out.println("Providers sorted.\n");
               break;
            case 8:
               System.out.println("Enter sales threshold -> ");
               double threshold = kb.nextDouble(); 
               int num = P.remove(threshold); 
               System.out.printf("Removed %d Providers.%n%n", num);
               break; 
            case 9:
               P.confirmLicenseToServeFood(kb);
               System.out.println(); 
               break;
            case 10:
               if (P.getPerfOrActSuplLargestFee() == null) 
                  System.out.println("There are no performers or activity suppliers currently in the list.\n");
               else 
                  winner = (P.getPerfOrActSuplLargestFee()).toString(); 
                  System.out.println(winner);
               break;
            default: 
               System.out.println("You enter an invalid input. Try again!\n");
               break;
         }//ends switch 
      } while (choice != 0); //ends while
        
   }//ends main 
}