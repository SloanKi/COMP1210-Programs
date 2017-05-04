import org.junit.Assert;
import org.junit.Test;
/**
* Tests the Pitcher class.
* Project 10
* @author Sloan Kiechel
* @version 4/21/16
*/ 
public class PitcherTest 
{
/**
* Tests rating() and getters and setters.
*/
   @Test public void ratingTest()
   {
      Pitcher player1 = new Pitcher("43", "Joe Williams", "RHP", 2.0, 0.0,
                                    0, 0, 0);
      //tests wins
      player1.setWins(22);
      Assert.assertEquals(22, player1.getWins(), 0);
      //tests losses
      player1.setLosses(4);
      Assert.assertEquals(4, player1.getLosses(), 0);
      //tests ERA
      player1.setEra(2.85);
      Assert.assertEquals(2.85, player1.getEra(), .00);
      //tests rating
      Assert.assertEquals(3.74025974025974, player1.rating(), .000);
   }
/**
* Tests stats().
*/
   @Test public void statsTest()
   {
      Pitcher player1 = new Pitcher("43", "Joe Williams", "RHP", 2.0, 0.0,
                                    22, 4, 2.85);
      String stats = "22 wins, 4 losses, 2.85 ERA";
      Assert.assertEquals(stats, player1.stats());
   }
/**
* Tests toString().
*/   
   @Test public void toStringTest()
   {
      Pitcher player1 = new Pitcher("43", "Joe Williams", "RHP", 2.0, 0.0,
                                    22, 4, 2.85);
      String output = "43 Joe Williams (RHP) 22 wins, 4 losses, ";
      output += "2.85 ERA\nSpecialization Factor: 2.0 (class Pitcher)";
      output += " Rating: 3.740";
      Assert.assertEquals(output, player1.toString());
   }
}
