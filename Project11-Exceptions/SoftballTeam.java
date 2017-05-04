import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.text.DecimalFormat;
/**
* Creates a softball team.
* Project 11
* @author Sloan Kiechel
* @version 4/28/16
*/
public class SoftballTeam
{
   private String teamName;
   private SoftballPlayer[] roster = new SoftballPlayer[24]; 
   private int playerCount; 
   private String[] excludedRecords = new String[30];
   private int excludedCount;
   private static int teamCount = 0;
   /**
   * Maximum number of players.
   */
   public static final int MAX_PLAYERS = 24;
   /**
   * Maximum excluded.
   */
   public static final int MAX_EXCLUDED = 30;
/**
* Constructor.
*/
   public SoftballTeam()
   {
      teamName = "";
      playerCount = 0;
      excludedCount = 0;
      teamCount++;
   }
/**
* Gets the team name.
* @return a string representing the team name
*/   
   public String getTeamName()
   {
      return teamName;
   }
/**
* Sets the team name.
* @param teamNameIn name of the team
*/   
   public void setTeamName(String teamNameIn)
   {
      teamName = teamNameIn;
   }
/**
* Gets the roster.
* @return an array of the roster
*/   
   public SoftballPlayer[] getRoster()
   {
      return roster;
   }
/**
* Sets the roster.
* @param rosterIn the roster.
*/   
   public void setRoster(SoftballPlayer[] rosterIn)
   {
      roster = rosterIn;
   }
/**
* gets PlayerCount.
* @return an int representing the player count.
*/   
   public int getPlayerCount()
   {
      return playerCount;
   }
/**
* Sets the player count.
* @param playerCountIn the player count.
*/   
   public void setPlayerCount(int playerCountIn)
   {
      playerCount = playerCountIn;
   }
/**
* Gets the excluded records array.
* @return a string array with the excluded records.
*/   
   public String[] getExcludedRecords()
   {
      return excludedRecords;
   }
/**
* Sets excluded records array.
* @param excludedRecordsIn the array.
*/   
   public void setExcludedRecords(String[] excludedRecordsIn)
   {
      excludedRecords = excludedRecordsIn;
   }
/**
* Gets the number of excluded records.
* @return the number of excluded records.
*/   
   public int getExcludedCount()
   {
      return excludedCount;
   }
/**
* Sets the excluded count.
* @param excludedCountIn the excluded count.
*/   
   public void setExcludedCount(int excludedCountIn)
   {
      excludedCount = excludedCountIn;
   }
/**
* Gets the team count.
* @return the team count
*/   
   public static int getTeamCount()
   {
      return teamCount;
   }
/**
* Resets the team count.
*/   
   public static void resetTeamCount()
   {
      teamCount = 0;
   }
/**
* Reads a player file and creates a team.
* @param fileName the name of the file.
* @throws IOException in case no file.
*/   
   public void readPlayerFile(String fileName) throws IOException
   {
      Scanner scanFile = new Scanner(new File(fileName));
      Scanner scanLines;
      teamName = scanFile.nextLine();
      while (scanFile.hasNextLine())
      {
         String line = scanFile.nextLine();
         scanLines = new Scanner(line);
         scanLines.useDelimiter(",");
         try
         {
            String type = scanLines.next();
            char ctype = type.charAt(0);
            String number = scanLines.next().trim();
            String name = scanLines.next();
            String position = scanLines.next();
            double sFactor = Double.parseDouble(scanLines.next());
            double battingAvg = Double.parseDouble(scanLines.next());
            switch (ctype)
            {
               case 'O':
                  double outfielderFieldingAvg = Double.parseDouble(
                                             scanLines.next());
                  Outfielder player = new Outfielder(number, name, position,
                                    sFactor, battingAvg, outfielderFieldingAvg);
                  if (playerCount < MAX_PLAYERS)
                  {
                     roster[playerCount] = player;
                     playerCount++;
                  }
                  else if (excludedCount < MAX_EXCLUDED)
                  {
                     excludedRecords[excludedCount] = "Maximum player count of" 
                                     + "  24 exceeded for: " + line;
                     excludedCount++;
                  }
                  break;
               
               case 'I': 
               
                  double infielderFieldingAvg = Double.parseDouble(
                                          scanLines.next());
                  Infielder player2 = new Infielder(number, name, position,
                                   sFactor, battingAvg, infielderFieldingAvg);
                  if (playerCount < MAX_PLAYERS)
                  {
                     roster[playerCount] = player2;
                     playerCount++;
                  }
                  else if (excludedCount < MAX_EXCLUDED)
                  {
                     excludedRecords[excludedCount] = "Maximum player count of"
                                     + " 24 exceeded for: " + line;
                     excludedCount++;
                  }
                  break;
               
               case 'P':
                  int wins = Integer.parseInt(scanLines.next());
                  int losses = Integer.parseInt(scanLines.next());
                  double era = Double.parseDouble(scanLines.next());
                  Pitcher player3 = new Pitcher(number, name, position, sFactor,
                                      battingAvg, wins, losses, era);
                  if (playerCount < MAX_PLAYERS)
                  {
                     roster[playerCount] = player3;
                     playerCount++;
                  }
                  else if (excludedCount < MAX_EXCLUDED)
                  {
                     excludedRecords[excludedCount] = "Maximum player count of"
                                      + " 24 exceeded for: " + line;
                     excludedCount++;
                  }
                  break; 
                                     
               case 'R':
                  int wins2 = Integer.parseInt(scanLines.next());
                  int losses2 = Integer.parseInt(scanLines.next());
                  double era2 = Double.parseDouble(scanLines.next());
                  int saves = Integer.parseInt(scanLines.next());
                  ReliefPitcher player4 = new ReliefPitcher(number, name,
                     position, sFactor, battingAvg, wins2, losses2, era2,
                     saves);
                  if (playerCount < MAX_PLAYERS)
                  {
                     roster[playerCount] = player4;
                     playerCount++;
                  }
                  else if (excludedCount < MAX_EXCLUDED)
                  {
                     excludedRecords[excludedCount] = "Maximum player count of"
                                         + " 24 exceeded for: " + line; 
                     excludedCount++;
                  }
                  break;
               default: 
                  InvalidCategoryException e = new 
                                 InvalidCategoryException(type);
                  throw e;    
            }
         }  
         catch (InvalidCategoryException e)
         {
            if (excludedCount < MAX_EXCLUDED)
            {
               excludedRecords[excludedCount] = e + " in: " + line;
               excludedCount++;
            }
         }
         catch (NumberFormatException e)
         {
            if (excludedCount < MAX_EXCLUDED)
            {
               excludedRecords[excludedCount] = e + " in: " + line;
               excludedCount++;
            }
         }
      }
   }
/**
* Generates a report in the order the players are inputed.
* @return the players.
*/   
   public String generateReport()
   {
      String output = "---------------------------------------\n";
      output += "Team Report for ";
      output += teamName + "\n---------------------------------------\n\n";
      for (int i = 0; i < playerCount; i++)
      {
         output += roster[i] + "\n\n";
      }
      return output;
   }
/**
* Generates a report of the players.
* @return a string in the order by numbers.
*/   
   public String generateReportByNumber()
   {
      String output = "---------------------------------------\n";
      output += "Team Report for " + teamName + " (by Number)";
      output += "\n---------------------------------------\n";
      SoftballPlayer [] myTeam = Arrays.copyOf(roster, playerCount);
      Arrays.sort(myTeam);
      for (int i = 0; i < playerCount; i++)
      {
         output += myTeam[i].getNumber();
         output += " " + myTeam[i].getName();
         output += " " + myTeam[i].getPosition();
         output += " " + myTeam[i].stats() + "\n";
      }
      return output;
   }
/**
* Generates a report of the players.
* @return a string in the order by name.
*/   
   public String generateReportByName()
   {
      String output = "---------------------------------------\n";
      output += "Team Report for " + teamName + " (by Name)";
      output += "\n---------------------------------------\n";
      NameComparator ncomp = new NameComparator();
      SoftballPlayer [] myTeam = Arrays.copyOf(roster, playerCount);
      Arrays.sort(myTeam, ncomp);
      for (int i = 0; i < playerCount; i++)
      {
         output += myTeam[i].getNumber();
         output += " " + myTeam[i].getName();
         output += " " + myTeam[i].getPosition();
         output += " " + myTeam[i].stats() + "\n";
      }
      return output;
   }
/**
* Generates a report of the players.
* @return a string in the order by rating.
*/   
   public String generateReportByRating()
   {
      DecimalFormat formatter = new DecimalFormat("#,##0.00");
      String output = "---------------------------------------\n";
      output += "Team Report for " + teamName + " (by Rating)";
      output += "\n---------------------------------------\n";
      RatingComparator rcomp = new RatingComparator();
      SoftballPlayer [] myTeam = Arrays.copyOf(roster, playerCount);
      Arrays.sort(myTeam, rcomp);
      for (int i = 0; i < playerCount; i++)
      {
         output += formatter.format(myTeam[i].rating());
         output += " " + myTeam[i].getNumber();
         output += " " + myTeam[i].getName();
         output += " " + myTeam[i].getPosition();
         output += " " + myTeam[i].stats() + "\n";
      }
      return output;
   }
/**
* Generates a report of excluded players.
* @return a string of excluded players
*/     
   public String generateExcludedRecordsReport()
   {
      String output = "---------------------------------------\n";
      output += "Excluded Records Report\n";
      output += "---------------------------------------";
      for (int i = 0; i < excludedCount; i++)
      {
         output += "\n" + excludedRecords[i];
      }
      return output;
   }
   
}