import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.text.DecimalFormat;
/**
* Determines various functions of an array of hexagonal prisms.
* Project 6
* @author Sloan Kiechel
* @version 3/07/16
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
* Gets the hexagonal prism array list.
* @return returns the array list.
*/   
   public ArrayList<HexagonalPrism> getList() 
   {
      
      return hpArray;
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
* Reads a file and creats an HP array from it.
* @param fileNameIn takes in file name
* @return hpList the hexagonal prism list made from the file.
* @throws IOException an exception if file is not there from scanning input.
*/   
   public HexagonalPrismList readFile(String fileNameIn)throws IOException
   {
      ArrayList<HexagonalPrism> myList = new ArrayList<HexagonalPrism>();
      String listName = "";
      String hexPrismName = "";
      double side = 0;
      double height = 0;
      String fileName = fileNameIn;
      Scanner scanFile = new Scanner(new File(fileName));
      listName = scanFile.nextLine();
      
      while (scanFile.hasNext())
      {
         hexPrismName = scanFile.nextLine();
         side = Double.parseDouble(scanFile.nextLine());
         height = Double.parseDouble(scanFile.nextLine());
         HexagonalPrism h = new HexagonalPrism(hexPrismName, side, height);
         myList.add(h);
      }
      
      HexagonalPrismList hplist = new HexagonalPrismList(listName, myList);
   
      return hplist;
   }
/**
* Adds a hexagonal prism to the hexagonal prism list object.
* @param label the label of the hexagonal prism
* @param side the side of the hexagonal prism
* @param height the height of the hexagonal prism
*/
   public void addHexagonalPrism(String label, double side, double height)
   {
      HexagonalPrism h = new HexagonalPrism(label, side, height);
      hpArray.add(h);
   }   
/**
* Removes a hexagonal Prism from the list.
* @param label to find the hexagonal Prism
* @return null if not found, h (the hexagonal prism) if found.
*/   
   public HexagonalPrism deleteHexagonalPrism(String label)
   {
      int i = 0;
      HexagonalPrism h = new HexagonalPrism("", 0, 0);
      while (i < hpArray.size())
      {
         h = hpArray.get(i);
         if (h.getLabel().compareToIgnoreCase(label) != 0)
         {
            i++;
         } 
         else 
         {
            break;  
         }
      }
      if (h.getLabel().compareToIgnoreCase(label) != 0)
      {
         return null;
      }
      hpArray.remove(i);
      return h;  
   } 
/**
* Finds and returns a hexagonal prism from the list.
* @param label the label of the hexagonal prism.
* @return null if not found, the prism if found.
*/
   public HexagonalPrism findHexagonalPrism(String label)
   {
      int i = 0;
      HexagonalPrism h = new HexagonalPrism("", 0, 0);
      while (i < hpArray.size())
      {
         h = hpArray.get(i);
         if (h.getLabel().compareToIgnoreCase(label) != 0)
         {
            i++;
         } 
         else 
         {
            break;  
         }
      }
      if (h.getLabel().compareToIgnoreCase(label) != 0)
      {
         return null;
      }
      return h;
   }  
/**
* Finds and edits a hexagonal prism.
* @param label of the hexagonal prism
* @param side of the edited hexagonal prism
* @param height of the edited hexagonal prism
* @return true if done, false if not.
*/
   public boolean editHexagonalPrism(String label, double side, double height)
   {
      int i = 0;
      HexagonalPrism h = new HexagonalPrism("", 0, 0);
      while (i < hpArray.size())
      {
         h = hpArray.get(i);
         if (h.getLabel().compareToIgnoreCase(label) != 0)
         {
            i++;
         } 
         else 
         {
            break;  
         }
      }
      if (h.getLabel().compareToIgnoreCase(label) != 0)
      {
         return false;
      }
      h.setSide(side);
      h.setHeight(height);
      return true;
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