import java.util.Scanner; //import scanner
import java.text.DecimalFormat;

/**
* Solves a certain expression for any user input.
* Project 3
* Sloan Kiechel
* 2/2/16
*
*/
public class RadicalFormula
{
/**
* Prints to std output.
*
* @param args Command line arguments (not used)
*/
   public static void main(String[] args)
   {
      double x, leftHand, rightHand, resultDoub;
      Scanner userInput = new Scanner(System.in);
      String resultString = "";
      int length, position;
      DecimalFormat formatter = new DecimalFormat("###,##0.0##");
   
   //Retrieves x from user
      System.out.print("Enter a value for x: ");
      x = Double.parseDouble(userInput.nextLine());
   
   //left hand
      leftHand = 3 * Math.pow(x, 8) - 2 * Math.pow(x, 3);
      leftHand = Math.pow(leftHand, 2);
   //right hand
      rightHand = 3 * Math.pow(x, 5) - 2 * Math.pow(x, 3);
      rightHand = Math.abs(rightHand);
   //result
      resultDoub = Math.sqrt((leftHand + rightHand));
      resultString = Double.toString(resultDoub);
      length = resultString.length();
      position = resultString.indexOf('.');
      System.out.println("Result: " + resultString);
      System.out.println("# digits to left of decimal point: " + position);
      System.out.println("# digits to right of decimal point: "
                          + (length - (position + 1)));
      System.out.println("Formatted Result: " + formatter.format(resultDoub));
   }
}