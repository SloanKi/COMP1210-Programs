import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
* Application for the HexagonalPrismList class.
* Project 5
* @author Sloan Kiechel
* @version 2/29/16
*/
public class HexagonalPrismListApp
{
/**
* Prints to std output.
* @param args Command line arguments (not used)
* @throws IOException from scanning input file.
*/
   public static void main(String[] args)throws IOException
   {
      ArrayList<HexagonalPrism> myList = new ArrayList<HexagonalPrism>();
      String listName = "";
      String hexPrismName = "";
      double side = 0;
      double height = 0;
      
      Scanner input = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = input.nextLine();
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
      
      HexagonalPrismList hpList = new HexagonalPrismList(listName, myList);
      System.out.println("\n" + hpList);
      System.out.println(hpList.summaryInfo());
   }
}