import java.util.Scanner;
import java.io.IOException;
/**
* Creates a menu to interact with the Hexagonal Prism List.
* Project 8
* @author Sloan Kiechel
* @version 3/21/16
*/
public class HexagonalPrismList2MenuApp
{
/**
* Gets user input and prints to std output.
* @param args Command line arguments (not used)
* @throws IOException for input file
*/
   public static void main(String[] args)throws IOException
   {
      String hpListName = "No list name";
      HexagonalPrism[] myList = new HexagonalPrism[100];
      String fileName = "No file name";
      int elements = 0;
      HexagonalPrismList2 hpList = new HexagonalPrismList2(hpListName, myList, elements);
      String label = "", code = "";
      double height = 0, side = 0;
      Scanner input = new Scanner(System.in);
      System.out.println("Hexagonal Prism List System Menu\n"
                       + "R - Read in File and Create Hexagonal Prism List\n"
                       + "P - Print Hexagonal Prism List\n" 
                       + "S - Print Summary\n"   
                       + "A - Add Hexagonal Prism\n"
                       + "D - Delete Hexagonal Prism\n"
                       + "F - Find Hexagonal Prism\n"
                       + "E - Edit Hexagonal Prism\n"
                       + "Q - Quit");
      do
      {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = input.nextLine();
         if (code.length() == 0)
         {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch (codeChar)
         {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = input.nextLine();
            
               hpList = hpList.readFile(fileName);
            
               System.out.println("\tFile read in and "
                              + "Hexagonal Prism List created\n");
               break; 
               
            case 'P':
               System.out.println(hpList);
               break;
               
            case 'S':
               System.out.println(hpList.summaryInfo() + "\n");
               break;   
               
            case 'A':
               System.out.print("\tLabel: ");
               label = input.nextLine();
               System.out.print("\tSide: ");
               side = Double.parseDouble(input.nextLine());
               System.out.print("\tHeight: ");
               height = Double.parseDouble(input.nextLine());
               hpList.addHexagonalPrism(label, side, height);
               System.out.println("***Hexagonal Prism added***\n");
               break;
               
            case 'D':
               System.out.print("\tLabel: ");
               label = input.nextLine();
               if (hpList.deleteHexagonalPrism(label) != null)
               {
                  HexagonalPrism h = hpList.deleteHexagonalPrism(label);
                  System.out.println("\t\"" + label + "\" deleted\n");
               }
               else
               {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
            
            case 'F':
               System.out.print("\tLabel: ");
               label = input.nextLine();
               if (hpList.findHexagonalPrism(label) != null)
               {
                  System.out.println(hpList.findHexagonalPrism(label) + "\n");
               }
               else
               {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'E':
               System.out.print("\tLabel: ");
               label = input.nextLine();
               System.out.print("\tSide: ");
               side = Double.parseDouble(input.nextLine());
               System.out.print("\tHeight: ");
               height = Double.parseDouble(input.nextLine());
               if (hpList.editHexagonalPrism(label, side, height))
               {
                  System.out.println("\t\"" + label 
                                    + "\" successfully edited\n");
               }
               else
               {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'Q': 
               break;   
               
            default:
               break;    
         }
      } while (!code.equalsIgnoreCase("Q"));
   }
}