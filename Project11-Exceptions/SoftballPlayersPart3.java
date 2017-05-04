import java.io.IOException;
/**
* Main class for project 11. Reads file of softball players,
* creates team, and generates 5 reports on them.
* Project 11
* @author Sloan Kiechel
* @version 4/28/16
*/
public class SoftballPlayersPart3
{
/**
* Main method as described above.
* @param args command line arguments will contain the file name.
*/
   public static void main(String[] args)
   {
      if (args[0] == null)
      {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
      else
      {  
         SoftballTeam st = new SoftballTeam();
         String fileName = args[0];
         try
         {
            st.readPlayerFile(fileName);
         }
         catch (IOException e)
         {
            System.out.println(e);
            System.out.println("Program ending.");
         }
         System.out.print(st.generateReport());
         System.out.println(st.generateReportByNumber());
         System.out.println(st.generateReportByName());
         System.out.println(st.generateReportByRating());
         System.out.println(st.generateExcludedRecordsReport());
      }
   }
}