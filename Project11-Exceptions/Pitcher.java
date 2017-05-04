 /**
* Creates a pitcher.
* Project 9
* @author Sloan Kiechel
* @version 4/14/16
*/
public class Pitcher extends SoftballPlayer
{
   protected int wins;
   protected int losses;
   protected double era;
/**
* Constructor.
* @param numberIn is the number of the player (super)
* @param nameIn is the name of the player (super)
* @param positionIn is the position of the player (super)
* @param sFactorIn is the specializiation factor of the player (super)
* @param battingAvgIn is the batting average of the player (super)
* @param winsIn is the number of wins.
* @param lossesIn is the number of losses.
* @param eraIn is the era of the player.
*/    
   public Pitcher(String numberIn, String nameIn, String positionIn,
              double sFactorIn, double battingAvgIn, int winsIn,
              int lossesIn, double eraIn)
   {
      super(numberIn, nameIn, positionIn, sFactorIn, battingAvgIn);
      wins = winsIn;
      losses = lossesIn;
      era = eraIn;
   }  
/**
* Gets the number of wins of the player.
* @return and int representing the number of wins
*/   
   public int getWins()
   {
      return wins;
   }        
/**
* Sets the number of wins of the player.
* @param winsIn the number of wins.
*/   
   public void setWins(int winsIn)
   {
      wins = winsIn;
   }
/**
* Gets the number of losses of the player.
* @return an int representing the number of losses.
*/   
   public int getLosses()
   {
      return losses;
   }
/**
* Sets the number of losses of the player.
* @param lossesIn the number of losses.
*/   
   public void setLosses(int lossesIn)
   {
      losses = lossesIn;
   }
/**
* Gets the ERA of the player.
* @return a double reperesenting the ERA of the player.
*/   
   public double getEra()
   {
      return era;
   }
/**
* Sets the ERA of the player.
* @param eraIn the era of the player.
*/   
   public void setEra(double eraIn)
   {
      era = eraIn;
   }
/**
* Calculates the rating of the player.
* @return a double representing the player rating.
*/   
   public double rating()
   {
      double rating = BASE_RATING * sFactor * (1 / (1 + era))
                      * ((wins - losses) / 25.0);
      return rating;
   }
/**
* Gets the stats of the player.
* @return a String representing the stats of the player.
*/   
   public String stats()
   {
      String stats = wins + " wins, " + losses + " losses, " + era + " ERA";
      return stats;
   }
}