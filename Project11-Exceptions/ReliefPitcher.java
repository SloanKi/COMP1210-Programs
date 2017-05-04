/**
* Creates a relief pitcher.
* Project 9
* @author Sloan Kiechel
* @version 4/14/16
*/
public class ReliefPitcher extends Pitcher
{
   private int saves;
/**
* Constructor.
* @param numberIn is the number of the player (super)
* @param nameIn is the name of the player (super)
* @param positionIn is the position of the player (super)
* @param sFactorIn is the specializiation factor of the player (super)
* @param battingAvgIn is the batting average of the player (super)
* @param winsIn is the number of wins.(super)
* @param lossesIn is the number of losses. (super)
* @param eraIn is the era of the player. (super)
* @param savesIn is the number of saves.
*/      
   public ReliefPitcher(String numberIn, String nameIn, String positionIn,
              double sFactorIn, double battingAvgIn, int winsIn,
              int lossesIn, double eraIn, int savesIn)
   {
      super(numberIn, nameIn, positionIn, sFactorIn, battingAvgIn,
            winsIn, lossesIn, eraIn);
      saves = savesIn;                 
   }
/**
* Gets the number of saves of the player.
* @return an int representing the number of saves.
*/   
   public int getSaves()
   {
      return saves;
   }
/**
* Sets the number of saves of the player.
* @param savesIn the number of saves.
*/   
   public void setSaves(int savesIn)
   {
      saves = savesIn;
   }
/**
* Calculates the rating of the player.
* @return a double representing the rating of the player
*/   
   public double rating()
   {
      double rating = BASE_RATING * sFactor * (1 / (1 + era))
                      * ((wins - losses + saves) / 30.0);
      return rating;
   }
/**
* Gets the stats of the player.
* @return a string representing player stats.
*/   
   public String stats()
   {
      String stats = wins + " wins, " + losses + " losses, " + saves + " saves,"
                  + " " + era + " ERA";
      return stats;
   }
}