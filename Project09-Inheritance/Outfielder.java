/**
* Creates an outfielder softball player.
* Project 9
* @author Sloan Kiechel
* @version 4/14/16
*/
public class Outfielder extends SoftballPlayer
{
   private double outfielderFieldingAvg;
/**
* Constructor.
* @param numberIn is the number of the player (super)
* @param nameIn is the name of the player (super)
* @param positionIn is the position of the player (super)
* @param sFactorIn is the specializiation factor of the player (super)
* @param battingAvgIn is the batting average of the player (super)
* @param outfielderFieldingAvgIn is the fielding average
*/    
   public Outfielder(String numberIn, String nameIn, String positionIn,
                        double sFactorIn, double battingAvgIn,
                        double outfielderFieldingAvgIn)
   {
      super(numberIn, nameIn, positionIn, sFactorIn, battingAvgIn);
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
/**
* Gets the fielding average of the outfielder.
* @return a double representing the fielding average.
*/   
   public double getOutfielderFieldingAvg()
   {
      return outfielderFieldingAvg;
   }
/**
* Sets the fielding average of the outfielder.
* @param outfielderFieldingAvgIn is the fielding average
*/   
   public void setOutfielderFieldingAvg(double outfielderFieldingAvgIn)
   {
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
/**
* Finds the rating of the player by multiplying several factors.
* @return a double representing the rating.
*/   
   public double rating()
   {
      double rating = BASE_RATING * sFactor * battingAvg 
                     * outfielderFieldingAvg;
      return rating;
   }
}