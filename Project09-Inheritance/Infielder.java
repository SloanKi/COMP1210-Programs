/**
* Creates an infielder softball player.
* Project 9
* @author Sloan Kiechel
* @version 4/14/16
*/
public class Infielder extends SoftballPlayer
{
   private double infielderFieldingAvg;
/**
* Constructor.
* @param numberIn is the number of the player (super)
* @param nameIn is the name of the player (super)
* @param positionIn is the position of the player (super)
* @param sFactorIn is the specializiation factor of the player (super)
* @param battingAvgIn is the batting average of the player (super)
* @param infielderFieldingAvgIn is the fielding average
*/   
   public Infielder(String numberIn, String nameIn, String positionIn,
                        double sFactorIn, double battingAvgIn,
                        double infielderFieldingAvgIn)
   {
      super(numberIn, nameIn, positionIn, sFactorIn, battingAvgIn);
      infielderFieldingAvg = infielderFieldingAvgIn;                
   }
/**
* Gets the fielding average of the infielder.
* @return a double representing the fielding average.
*/    
   public double getInfielderFieldingAvg()
   {
      return infielderFieldingAvg;
   }
/**
* Sets the fielding average of the infielder.
* @param infielderFieldingAvgIn is the fielding average
*/    
   public void setInfielderFieldingAvg(double infielderFieldingAvgIn)
   {
      infielderFieldingAvg = infielderFieldingAvgIn;
   }
/**
* Finds the rating of the player by multiplying several factors.
* @return a double representing the rating.
*/     
   public double rating()
   {
      double rating = BASE_RATING * sFactor * battingAvg 
                     * infielderFieldingAvg;
      return rating;
   }
}