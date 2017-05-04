import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
/**
* This program decodes a code given to determine superbowl box lunches.
* Project 3
* Sloan Kiechel
* 2/5/16
*/
public class SuperBowlBoxLunch
{
/**
* Prints to std output.
*
* @param args Command line argument (not used).
*/
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      Random generator = new Random();
      int luckyNumber = generator.nextInt(9998) + 1;
      DecimalFormat priceFormat = new DecimalFormat("$#0.00");
      DecimalFormat luckyFormat = new DecimalFormat("0000");
      String orderCode = "";
      String theme = "";
      String name = "";
      int adultMeals, childMeals;
      double adultPrice, childPrice, total;
      //Gets user input
      System.out.print("Enter order code: ");
      orderCode = userInput.nextLine();
      System.out.println("");
      //Trims off whitespace
      orderCode = orderCode.trim();
      //Checks length
      if (orderCode.length() < 13)
      {
         System.out.println("*** Invalid Order Code ***");
         System.out.println("Order code must have at least 13 characters.");
      }
      else
      {
         //Gets theme
         if (orderCode.charAt(0) == '0')
         {
            theme = "Broncos";
         }
         else if (orderCode.charAt(0) == '1')
         {
            theme = "Panthers";
         }
         else
         {
            theme = "Broncos and Panthers";
         }
         //decodes rest of input
         adultMeals = Integer.parseInt(orderCode.substring(1, 3));
         adultPrice = Double.parseDouble(orderCode.substring(3, 5) + '.' 
                     + orderCode.substring(5, 7));
         childMeals = Integer.parseInt(orderCode.substring(7, 9));
         childPrice = Double.parseDouble(orderCode.substring(9, 11) + '.'
                     + orderCode.substring(11, 13));
         total = (adultMeals * adultPrice) + (childMeals * childPrice);
         name = orderCode.substring(13, (orderCode.length()));
         //Output
         System.out.println("Name: " + name);
         System.out.println("Adult meals: " + adultMeals + " at "
                            + priceFormat.format(adultPrice));
         System.out.println("Child meals: " + childMeals + " at "
                            + priceFormat.format(childPrice));
         System.out.println("Total: " + priceFormat.format(total));
         System.out.println("Theme: " + theme);
         System.out.println("Lucky Number: " + luckyFormat.format(luckyNumber));
      }
   
   }
}