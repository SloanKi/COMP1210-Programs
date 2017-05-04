import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
/**
* Determines various functions of an array of hexagonal prisms.
* Project 8
* @author Sloan Kiechel
* @version 3/21/16
*/
public class HexagonalPrismList2
{
   private String name;
   private HexagonalPrism[] hpArray = new HexagonalPrism[100];
   private int elements;
/**
* Constructor for class.
* @param nameIn the name for the array given.
* @param hpArrayIn  array in
* @param elementsIn the elements for the array
*/   
   public HexagonalPrismList2(String nameIn, HexagonalPrism[] hpArrayIn, 
                              int elementsIn)
   {
      name = nameIn;
      hpArray = hpArrayIn;
      elements = elementsIn;
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
* Gets the hexagonal prism array.
* @return returns the array.
*/   
   public HexagonalPrism[] getList() 
   {
      
      return hpArray;
   }
   
/**
* Gets the number of Hexagonal Prisms in the Array.
* @return returns the number of hexagonal prisms.
*/   
   public int numberOfHexagonalPrisms()
   {
      return elements; 
   }
/**
* Reads a file and creats an HP array from it.
* @param fileNameIn takes in file name
* @return hpList the hexagonal prism list made from the file.
* @throws IOException an exception if file is not there from scanning input.
*/   
   public HexagonalPrismList2 readFile(String fileNameIn)throws IOException
   {
      HexagonalPrism[] myList = new HexagonalPrism[100];
      String listName = "";
      String hexPrismName = "";
      double side = 0;
      double height = 0;
      int tempElements = 0;
      String fileName = fileNameIn;
      Scanner scanFile = new Scanner(new File(fileName));
      listName = scanFile.nextLine();
      
      while (scanFile.hasNext())
      {
         hexPrismName = scanFile.nextLine();
         side = Double.parseDouble(scanFile.nextLine());
         height = Double.parseDouble(scanFile.nextLine());
         HexagonalPrism h = new HexagonalPrism(hexPrismName, side, height);
         myList[tempElements] = h;
         tempElements++;
      }
      elements = tempElements;
      HexagonalPrismList2 hplist = new HexagonalPrismList2(listName, myList,
                                  elements);
   
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
      hpArray[elements + 1] = h;
      elements++;
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
      while (i < elements)
      {
         h = hpArray[i];
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
      hpArray[i] = null;
      if (i < elements)
      {
         while (i < elements)
         {
            hpArray[i] = hpArray[i + 1];
            i++;
         }
      }
      elements--;
      
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
      while (i < elements)
      {
         h = hpArray[i];
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
      while (i < elements)
      {
         h = hpArray[i];
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
      if (elements == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i < elements)
         {
            temp = hpArray[i];
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
      if (elements == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i < elements)
         {
            temp = hpArray[i];
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
      if (elements == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i < elements)
         {
            temp = hpArray[i];
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
      if (elements == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i < elements)
         {
            temp = hpArray[i];
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
      if (elements == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i < elements)
         {
            temp = hpArray[i];
            averageSurfaceArea += temp.surfaceArea();
            i++;
         }
         averageSurfaceArea = averageSurfaceArea / elements;
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
      if (elements == 0)
      {
         return 0;
      }
      else
      {
         int i = 0;
         HexagonalPrism temp;
         while (i < elements)
         {
            temp = hpArray[i];
            averageVolume += temp.volume();
            i++;
         }
         averageVolume = averageVolume / elements;
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
      while (i < elements)
      {
         temp = hpArray[i];
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
/**
* Finds the hexagonal prism with the smallest side.
* @return the hexagonal prism with smallest side.
*/   
   public HexagonalPrism findHexagonalPrismWithSmallestSide()
   {
      if (elements == 0)
      {
         return null;
      }
      double smallest = hpArray[0].getSide();
      int indexNumber = 0;
      int i = 1;
      while (i < elements)
      {
         if (hpArray[i].getSide() < smallest)
         {
            smallest = hpArray[i].getSide();
            indexNumber = i;
         }
         i++;
      }
      return hpArray[indexNumber];
   }
/**
* Finds the hexagonal prism with the largest side.
* @return the hexagonal prism with largest side.
*/     
   public HexagonalPrism findHexagonalPrismWithLargestSide()
   {
      if (elements == 0)
      {
         return null;
      }
      double largest = hpArray[0].getSide();
      int indexNumber = 0;
      int i = 1;
      while (i < elements)
      {
         if (hpArray[i].getSide() > largest)
         {
            largest = hpArray[i].getSide();
            indexNumber = 1;
         }
         i++;
      }
      return hpArray[indexNumber];
   }
/**
* Finds the hexagonal prism with the smallest height.
* @return the hexagonal prism with smallest height.
*/    
   public HexagonalPrism findHexagonalPrismWithSmallestHeight()
   {
      if (elements == 0)
      {
         return null;
      }
      double smallest = hpArray[0].getHeight();
      int indexNumber = 0;
      int i = 1;
      while (i < elements)
      {
         if (hpArray[i].getHeight() < smallest)
         {
            smallest = hpArray[i].getHeight();
            indexNumber = i;
         }
         i++;
      }
      return hpArray[indexNumber];
   }
/**
* Finds the hexagonal prism with the largest height.
* @return the hexagonal prism with the largest height
*/   
   public HexagonalPrism findHexagonalPrismWithLargestHeight()
   {
      if (elements == 0)
      {
         return null;
      }
      double largest = hpArray[0].getHeight();
      int indexNumber = 0;
      int i = 1;
      while (i < elements)
      {
         if (hpArray[i].getHeight() > largest)
         {
            largest = hpArray[i].getHeight();
            indexNumber = i;
         }
         i++;
      }
      return hpArray[indexNumber];
   }
}