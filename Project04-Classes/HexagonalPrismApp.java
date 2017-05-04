import java.util.Scanner;
/**
* Application to create a Hexagonal Prism from user input.
* Project 4
* @version 2/18/16
* @author Sloan Kiechel
*/
public class HexagonalPrismApp
{
/**
* Prints to Std Output.
* @param args Command Line Arguments (not Used). 
*/
   public static void main(String[] args)
   {
   //Declaring variables
      double side, height;
      String label;
      Scanner myScanner = new Scanner(System.in);
      
      System.out.print("Enter label, side, and height for a hexagonal prism.");
      System.out.print("\n\tlabel: ");
      label = myScanner.nextLine();
      System.out.print("\tside: ");
      side = Double.parseDouble(myScanner.nextLine());
      System.out.print("\theight: ");
      height = Double.parseDouble(myScanner.nextLine());
      
      HexagonalPrism myPrism = new HexagonalPrism(label, side, height); 
      System.out.print(myPrism);
   }
}