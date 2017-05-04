import java.text.DecimalFormat;
/**
* Determines various functions of a hexagonal prism.
* Project 4
* @author Sloan Kiechel
* @version 2/18/16
*/
public class HexagonalPrism
{
//Instance Variables
   private String label;
   private double side, height;

/**
* Constructor for Hexagonal Prism.
* @param labelIn the label for the Hexagonal Prism.
* @param sideIn the side for the Hexagonal Prism.
* @param heightIn the height of the Hexagonal Prism.
*/
   public HexagonalPrism(String labelIn, double sideIn, double heightIn)
   {
      label = labelIn.trim();
      side = sideIn;
      height = heightIn;
   }
/**
* Gets the label for the Hexagonal Prism.
* @return Returns the String variable label.
*/   
   public String getLabel()
   {
      return label;
   }
/**
* Sets the label for the Hexagonal Prism.
* @param labelIn the label for the Hexagonal Prism.
* @return Returns boolean to tell if set or not.
*/   
   public boolean setLabel(String labelIn)
   {
      boolean isSet = false;
      if (labelIn != null)
      {
         label = labelIn.trim();
         isSet = true;
      }
      return isSet;
   }
/**
* Gets the side for the Hexagonal prism.
* @return returns the double variable side.
*/   
   public double getSide()
   {
      return side;
   }
/**
* Sets the side for the Hexagonal Prism.
* @param sideIn the side for the Hexagonal Prism.
*/
   public void setSide(double sideIn)
   {
      side = sideIn;
   }
/**
* Gets the height for the Hexagonal Prism.
* @return returns the double variable height.
*/   
   public double getHeight()
   {
      return height;
   }
/**
* Sets the height for the Hexagonal prism.
* @param heightIn the height for the Hexagonal Prism.
*/
   public void setHeight(double heightIn)
   {
      height = heightIn;
   }
/**
* Calculates the base Perimeter of the hexagonal prism.
* @return returns the double variable basePerim
*/   
   public double basePerimeter()
   {
      double basePerim = 6 * side;
      return basePerim;
   }
/**
* Calculates the Base Area of the hexagonal Prism.
* @return returns the double variable baseArea
*/   
   public double baseArea()
   {
      double baseArea = 3 * Math.sqrt(3) * Math.pow(side, 2) / 2;
      return baseArea;
   }
/**
* Calculates the surface Area of the hexagonal Prism.
* @return returns the double variable surfaceArea
*/
   public double surfaceArea()
   {
      double surfaceArea = (6 * side * height) 
               + (3 * Math.sqrt(3) * Math.pow(side, 2));
      return surfaceArea;
   }
/**
* Calculates the volume of the hexagonal prism.
* @return returns the double variable volume.
*/
   public double volume()
   {
      double volume = 3 * Math.sqrt(3) / 2 * Math.pow(side, 2) * height;
      return volume;
   }
/**
* To String method.
* @return Returns a string containing information about Hexagonal Prism.
*/
   public String toString()
   {
      String output = "";
      DecimalFormat formatter = new DecimalFormat("#,##0.0##");
      output = "\"" + label + "\" is a hexagonal prism with side = " 
             + formatter.format(side) + " units and height = " 
             + formatter.format(height) + " units,\nwhich has base perimeter = "
             + formatter.format(basePerimeter()) + " units, base area = " 
             + formatter.format(baseArea()) + " square units, "
             + "\nsurface area = " + formatter.format(surfaceArea())
             + " square units, and volume = " + formatter.format(volume())
             + " cubic units.";
      return output;
   }
}
