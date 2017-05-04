import java.util.ArrayList;
import java.text.DecimalFormat;
/**
* Determines various functions of an array of hexagonal prisms.
* Project 5
* @author Sloan Kiechel
* @version 2/29/16
*/
public class HexagonalPrismList
{
   private String name;
   private ArrayList<HexagonalPrism> hpArray;
/**
* Constructor for class.
* @param nameIn the name for the array given.
* @param hpArrayIn  
*/   
   public HexagonalPrismList(String nameIn, ArrayList<HexagonalPrism> hpArrayIn)
   {
      name = nameIn;
      hpArray = hpArrayIn;
   }
/**
* Gets the name of the array.
* @return returns the name
*/   
   public String getName()
   {
      return name; 
   }
/**
* Gets the number of Hexagonal Prisms in the Array.
* @return returns the number of hexagonal prisms.
*/   
   public int numberOfHexagonalPrisms()
   {
      int size = hpArray.size();
      return size; 
   }
/**
* Calculates the total surface area of all the Hexagonal prisms in the array.
* @return returns the total surface area
*/   
   public double totalSurfaceArea()
   {
      double totalSurfaceArea = 0;
      if (hpArray.size() == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i <= hpArray.size() - 1)
         {
            temp = hpArray.get(i);
            totalSurfaceArea += temp.surfaceArea();
            i++; 
         }
      }
      return totalSurfaceArea;
   }
/**
* Calculates the total volume of all the Hexagonal Prisms in the array.
* @return returns the total volume
*/   
   public double totalVolume()
   {
      double totalVolume = 0;
      if (hpArray.size() == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i <= hpArray.size() - 1)
         {
            temp = hpArray.get(i);
            totalVolume += temp.volume();
            i++;
         }
      }
      return totalVolume; 
   }
/**
* Calculates the total base perimeter of all the hexagonal prisms in the array.
* @return returns the base perimeter
*/   
   public double totalBasePerimeter()
   {
      double totalBasePerimeter = 0;
      if (hpArray.size() == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i <= hpArray.size() - 1)
         {
            temp = hpArray.get(i);
            totalBasePerimeter += temp.basePerimeter();
            i++;
         }
      }
      return totalBasePerimeter;
   }
/**
* Calculates the total base area of all the hexagonal prisms in the array.
* @return returns the total base area
*/   
   public double totalBaseArea()
   {
      double totalBaseArea = 0;
      if (hpArray.size() == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i <= hpArray.size() - 1)
         {
            temp = hpArray.get(i);
            totalBaseArea += temp.baseArea();
            i++;
         }
      }
      return totalBaseArea;
   }
/**
* Calculates the average surface area of all the hexagonal prisms in the array.
* @return returns the average surface area
*/  
   public double averageSurfaceArea()
   {
      double averageSurfaceArea = 0;
      if (hpArray.size() == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i <= hpArray.size() - 1)
         {
            temp = hpArray.get(i);
            averageSurfaceArea += temp.surfaceArea();
            i++;
         }
         averageSurfaceArea = averageSurfaceArea / hpArray.size();
      }
      return averageSurfaceArea;
   }
/**
* Calculates the average volume of all the hexagonal prisms in the array.
* @return returns the average volume
*/  
   public double averageVolume()
   {
      double averageVolume = 0;
      if (hpArray.size() == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i <= hpArray.size() - 1)
         {
            temp = hpArray.get(i);
            averageVolume += temp.volume();
            i++;
         }
         averageVolume = averageVolume / hpArray.size();
      }
      return averageVolume;
   }
/**
* Prints out the name of the list as well as each hexagonal prism in the array.
* @return returns the output as described above
*/   
   public String toString()
   {
      String output = "";
      int i = 0;
      HexagonalPrism temp;
      while (i <= hpArray.size() - 1)
      {
         temp = hpArray.get(i);
         output += "\n" + temp + "\n"; 
         i++;
      }
      return getName() + "\n" + output;
   }
/**
* Prints out the summary of the the array.
* @return returns the summary
*/   
   public String summaryInfo()
   {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String result = "";
      result += "----- " + getName() + " Summary -----"; 
      result += "\nNumber of Hexagonal Prisms: " + numberOfHexagonalPrisms();
      result += "\nTotal Surface Area: " + df.format(totalSurfaceArea()); 
      result += "\nTotal Volume: "  + df.format(totalVolume());
      result += "\nTotal Base Perimeter: "  + df.format(totalBasePerimeter());
      result += "\nTotal Base Area: " + df.format(totalBaseArea());
      result += "\nAverage Surface Area: " + df.format(averageSurfaceArea());
      result += "\nAverage Volume: " + df.format(averageVolume());
      return result;
   }
}