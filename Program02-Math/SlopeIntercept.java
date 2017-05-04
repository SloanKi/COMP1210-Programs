import java.util.Scanner; 
/**
* Finds the slop and x and y intercept of a line.
*
* @author Sloan Kiechel
*/
public class SlopeIntercept
{
/**
* Prints to std output.
*
* @param args Command line arguments (not userd).
*/
   public static void main(String[] args)
   {
      double x1, y1, x2, y2, xIntercept, yIntercept, slope;
      Scanner userInput = new Scanner(System.in);
      
      //Prompts for x1 and y1.
      System.out.println("Enter the X and Y coordinates of starting point:");
      System.out.print("\tx1 = ");
      x1 = userInput.nextDouble();
      System.out.print("\ty1 = ");
      y1 = userInput.nextDouble();
      //Prompts for x2 and y2
      System.out.println("Enter the X and Y coordinates of ending point:");
      System.out.print("\tx2 = ");
      x2 = userInput.nextDouble();
      System.out.print("\ty2 = ");
      y2 = userInput.nextDouble();
      
      //Checks to see if slope is defined.
      if (x1 == x2)
      {
         System.out.println("Slope: \"undefined\"");
      }
      else
      {
         slope = (y2 - y1) / (x2 - x1);
         yIntercept = y1 - slope * x1;
         System.out.println("Slope: " + slope);
         System.out.println("Y intercept: " + yIntercept);
         if (y1 == y2)
         {
            System.out.println("X intercept: \"undefined\"");
         }
         else
         {
            xIntercept = -1 * (yIntercept / slope);
            System.out.println("X intercept: " + xIntercept);
         }
      }
   
   }
}