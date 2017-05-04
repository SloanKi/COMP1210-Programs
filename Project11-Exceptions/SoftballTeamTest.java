import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

/**
* Tests SoftballTeam.
* Project 11
* @author Sloan Kiechel
* @version 4/28/16
*/

public class SoftballTeamTest {
/**
* Tests the getters and setters.
*/
   @Test public void getterAndSetterTest()
   {
      SoftballTeam st = new SoftballTeam();
      st.setTeamName("Meow");
      Assert.assertEquals("Meow", st.getTeamName());
      SoftballPlayer[] roster = new SoftballPlayer[24];
      st.setRoster(roster);
      Assert.assertEquals(roster, st.getRoster());
      st.setPlayerCount(10);
      Assert.assertEquals(10, st.getPlayerCount(), 0);
      String[] excludedTest = new String[30];
      st.setExcludedRecords(excludedTest);
      Assert.assertEquals(excludedTest, st.getExcludedRecords());
      st.setExcludedCount(2);
      Assert.assertEquals(2, st.getExcludedCount(), 0);
      SoftballTeam.resetTeamCount();
      Assert.assertEquals(0, SoftballTeam.getTeamCount(), 0);
   }
/**
* Tests readPlayerFile.
* @throws IOException in case file isnt there.
*/   
   @Test public void readPlayerFileTest() throws IOException
   {
      SoftballTeam st = new SoftballTeam();
      st.readPlayerFile("softball_player_data2.csv");
      SoftballPlayer[] roster = st.getRoster();
      String[] excludedRecords = st.getExcludedRecords();
      //Checks the first player of the roster to be sure he matches.
      Outfielder sp = new Outfielder("21", "Jodi Doe", "RF", 1.0,
                                     .305, .98);
      Assert.assertEquals(0, sp.compareTo(roster[0]), 0);
      RatingComparator rcomp = new RatingComparator();
      Assert.assertEquals(0, rcomp.compare(roster[0], sp), 0);
      NameComparator ncomp = new NameComparator();
      Assert.assertEquals(0, ncomp.compare(roster[0], sp), 0);
      //Checks player count
      Assert.assertEquals(24, st.getPlayerCount(), 0);
      //Checks excluded count
      Assert.assertEquals(3, st.getExcludedCount(), 0);
      //Checks invalid and max players
      String invalid = "InvalidCategoryException: For category: ";
      invalid += "\"H\" in: H,24,Nola Austin,LHP,";
      invalid += "2.0,0.225,4,12,1.2";
      Assert.assertEquals(invalid, excludedRecords[0]);
      String max = "Maximum player count of 24 exceeded for: R,35,";
      max += "Bruce Wayne,LHP,2.0,0.175,15,1,2.3,4";
      Assert.assertEquals(max, excludedRecords[1]);
   }
/**
* Tests generateReport.
* @throws IOException incase file isnt there.
*/   
   @Test public void generateReportTest()throws IOException
   {
      SoftballTeam st = new SoftballTeam();
      st.readPlayerFile("softball_player_data3a.csv");
      String output = "---------------------------------------\n";
      output += "Team Report for Auburn Stars";
      output += "\n---------------------------------------\n\n";
      output += "32 Pat Jones (RF) .375\nSpecialization Factor: ";
      output += "1.0 (class Outfielder) Rating: 3.562\n\n23 Jackie ";
      output += "Smith (3B) .275\nSpecialization Factor: 1.25 (class";
      output += " Infielder) Rating: 2.922\n\n43 Jo Williams (RHP) 22 ";
      output += "wins, 4 losses, 2.85 ERA\nSpecialization Factor: 2.0";
      output += " (class Pitcher) Rating: 3.740\n\n34 Sammi James (LHP)";
      output += " 5 wins, 4 losses, 17 saves, 3.85 ERA\nSpecialization";
      output += " Factor: 2.0 (class ReliefPitcher) Rating: 2.474\n\n";
      Assert.assertEquals(output, st.generateReport());
   }
/**
* Tests generateReportByNumbers.
* @throws IOException incase file isnt there.
*/     
   @Test public void generateReportByNumber() throws IOException
   {
      SoftballTeam st = new SoftballTeam();
      st.readPlayerFile("softball_player_data3a.csv");
      String output = "---------------------------------------\n";
      output += "Team Report for Auburn Stars (by Number)";
      output += "\n---------------------------------------\n";
      output += "23 Jackie Smith 3B";
      output += " .275\n32 Pat Jones RF .375\n";
      output += "34 Sammi James LHP 5 wins, 4 losses,";
      output += " 17 saves, 3.85 ERA\n43 Jo Williams RHP 22";
      output += " wins, 4 losses, 2.85 ERA\n";
      Assert.assertEquals(output, st.generateReportByNumber());
   }
/**
* Tests generateReportByRating.
* @throws IOException incase file isnt there.
*/     
   @Test public void generateReportByRating() throws IOException
   {
      SoftballTeam st = new SoftballTeam();
      st.readPlayerFile("softball_player_data3a.csv");
      String output = "---------------------------------------\n";
      output += "Team Report for Auburn Stars (by Rating)";
      output += "\n---------------------------------------\n";
      output += "3.74 43 Jo ";
      output += "Williams RHP 22 wins, 4 losses, 2.85 ERA\n";
      output += "3.56 32 Pat Jones RF .375\n2.92 23 Jackie ";
      output += "Smith 3B .275\n2.47 34 Sammi James LHP 5 wins,";
      output += " 4 losses, 17 saves, 3.85 ERA\n";
      Assert.assertEquals(output, st.generateReportByRating());
   }
/**
* Tests generateReportByName.
* @throws IOException incase file isnt there.
*/    
   @Test public void generateReportByName() throws IOException
   {
      SoftballTeam st = new SoftballTeam();
      st.readPlayerFile("softball_player_data3a.csv");
      String output = "---------------------------------------\n";
      output += "Team Report for Auburn Stars (by Name)";
      output += "\n---------------------------------------\n";
      output += "34 Sammi James LHP 5 wins, 4 losses, 17 saves,";
      output += " 3.85 ERA\n32 Pat Jones RF .375\n23 Jackie ";
      output += "Smith 3B .275\n43 Jo Williams RHP 22 wins, ";
      output += "4 losses, 2.85 ERA\n";
      Assert.assertEquals(output, st.generateReportByName());
   }
/**
* Tests generateExcludedRecordsReport.
* @throws IOException incase file isnt there.
*/       
   @Test public void generateExcludedRecordsReport() throws IOException
   {
      SoftballTeam st = new SoftballTeam();
      st.readPlayerFile("softball_player_data3a.csv");
      String output = "---------------------------------------\n";
      output += "Excluded Records Report";
      output += "\n---------------------------------------\n";
      output += "InvalidCategoryException: For category: ";
      output += "\"L\" in: L,23,Gayle Adams,2B,1.25,.225,.875";
      output += "\njava.lang.NumberFormatException: For input string:";
      output += " \".480a\" in: O, 9,Pat Williams,RF,1.0,.480a,.950";
      Assert.assertEquals(output, st.generateExcludedRecordsReport());
   }
}