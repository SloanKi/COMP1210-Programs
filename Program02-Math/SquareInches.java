//Imports scanner for input.
import java.util.Scanner;
/**
* Calculates the integral number of units (acres, square yards,
* and square feet) in a specified number of square inches.
*
* @author Sloan Kiechel
*/
public class SquareInches
{
/**
* Prints to std output.
*
* @param args command line arguments (not used)
*/
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      int sqInches, sqYard, acre, sqFoot, remainder;
      
      //Prompt user for square inches
      System.out.print("Enter the area in square inches: ");
      sqInches = userInput.nextInt();
      
      //Checks to be sure sqInches does not exceed 1,000,000,000.
      if (sqInches > 1000000000)
      {
         System.out.println("Limit of 1,000,000,000 square inches exceeded!");
      }
      else
      {
         //Calculations
         acre = sqInches / 6272640;
         sqYard = (sqInches % 6272640) / 1296;
         sqFoot = ((sqInches % 6272640) % 1296) / 144;
         remainder = ((sqInches % 6272640) % 1296) % 144;
         //Prints out results
         System.out.println("Number of Units:");
         System.out.println("\tAcres: " + acre);
         System.out.println("\tSquare Yards: " + sqYard);
         System.out.println("\tSquare Feet: " + sqFoot);
         System.out.println("\tSquare Inches: " + remainder);
      
      }
   }
}