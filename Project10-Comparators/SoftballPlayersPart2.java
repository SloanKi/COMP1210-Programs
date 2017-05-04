import java.io.IOException;
/**
* Main method for softball team and players.
* Project 10
* @author Sloan Kiechel
* @version 4/21/16
*/
public class SoftballPlayersPart2
{
/**
* Reads a filename and generates reports.
* @param args command line arguments for filename.
* @throws IOException in case there is no file.
*/
   public static void main(String[] args) throws IOException
   {
      if (args[0] == null)
      {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
      else
      {
         String fileName = args[0];
         SoftballTeam sbt = new SoftballTeam();
         sbt.readPlayerFile("softball_player_data.csv");
         System.out.println(sbt.generateReport());
         System.out.println(sbt.generateReportByNumber());
         System.out.println(sbt.generateReportByName());
         System.out.println(sbt.generateReportByRating());
         System.out.println(sbt.generateExcludedRecordsReport());
      }
      
   }
}