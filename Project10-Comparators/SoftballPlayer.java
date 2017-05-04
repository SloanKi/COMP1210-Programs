import java.text.DecimalFormat;
/**
* Creates an abstract class SoftballPlayer to make other softball player
* creation easy.
* Project 10
* @author Sloan Kiechel
* @version 4/21/16
*/
public abstract class SoftballPlayer implements Comparable<SoftballPlayer>
{
   protected String number, name, position;
   protected double sFactor, battingAvg;
   protected static int count = 0;
   protected static final int BASE_RATING = 10;
/**
* Constructor.
* @param numberIn is the number of the player
* @param nameIn is the name of the player
* @param positionIn is the position of the player
* @param sFactorIn is the specializiation factor of the player
* @param battingAvgIn is the batting average of the player
*/   
   public SoftballPlayer(String numberIn, String nameIn, String positionIn,
                        double sFactorIn, double battingAvgIn)
   {
      count++;
      number = numberIn;
      name = nameIn;
      position = positionIn;
      sFactor = sFactorIn;
      battingAvg = battingAvgIn;
   }
/**
* Gets the number of the player.
* @return a string representing the number.
*/   
   public String getNumber()
   {
      return number;
   }
/**
* Sets the number of the player.
* @param numberIn is the number of the player.
*/   
   public void setNumber(String numberIn)
   {
      number = numberIn;
   }
/**
* Gets the name of the player.
* @return a string representing the name.
*/   
   public String getName()
   {
      return name;
   }
/**
* Sets the name of the player.
* @param nameIn is the name of the player
*/   
   public void setName(String nameIn)
   {
      name = nameIn;
   }
/**
* Gets the position of the player.
* @return a string representing the position of the player
*/   
   public String getPosition()
   {
      return position;
   }
/**
* Sets the position of the player.
* @param positionIn is the position of the player.
*/   
   public void setPosition(String positionIn)
   {
      position = positionIn;
   }
/**
* Gets the batting average of the player.
* @return a double representing the batting average.
*/   
   public double getBattingAvg()
   {
      return battingAvg;
   }
/**
* Sets the batting average.
* @param battingAvgIn is the batting average of the player.
*/   
   public void setBattingAvg(Double battingAvgIn)
   {
      battingAvg = battingAvgIn;
   }
/**
* Gets the specialization factor of the player.
* @return a double representing the specialization factor.
*/   
   public double getSpecializationFactor()
   {
      return sFactor;
   }
/**
* Sets the specilization factor of the player.
* @param sFactorIn is the specialization factor of the player.
*/   
   public void setSpecializationFactor(double sFactorIn)
   {
      sFactor = sFactorIn;
   }
/**
* Gets the number of instances of players made.
* @return the number of players.
*/   
   public static int getCount()
   {
      return count;
   }
/**
* Resets the number of player instances.
*/   
   public static void resetCount()
   {
      count = 0;
   }
/**
* Creates a string with the batting average of the player.
* @return a string representing the batting average.
*/   
   public String stats()
   {
      DecimalFormat formatter = new DecimalFormat("#,##0.000");
      return "" + formatter.format(battingAvg);
   }
/**
* The toString method.
* @return the player information.
*/   
   public String toString()
   {
      DecimalFormat formatter = new DecimalFormat("#,##0.000");
      String output = this.getNumber() + " " + this.getName() + " ("
                    + this.getPosition() + ") " + this.stats();
      output += "\nSpecialization Factor: " + this.getSpecializationFactor()
             + " (" + this.getClass() + ") Rating: " 
             + formatter.format(this.rating());
             
      return output;
   }
/**
* Compares two softball players based on their numbers.
* @param s is the second SoftballPlayer.
* @return an int, 1 if larger, -1 if smaller, 0 if equal.
*/  
   public int compareTo(SoftballPlayer s)
   {
      int obj1 = Integer.parseInt(this.getNumber());
      int obj2 = Integer.parseInt(s.getNumber());
      if (obj1 > obj2)
      {
         return 1;
      }
      else if (obj1 < obj2)
      {
         return -1;
      }
      else         
      {
         return 0;
      }
   }
/**
* Rating method to be overrode by subclasses.
* @return the rating of the player.
*/ 
   public abstract double rating();
   
   
}