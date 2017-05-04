import org.junit.Assert;
import org.junit.Test;
 /**
* Tests the Pitcher class.
* Project 9
* @author Sloan Kiechel
* @version 4/14/16
*/ 
public class ReliefPitcherTest {
/**
* Tests rating() and getters and setters.
*/
   @Test public void ratingTest()
   {
      ReliefPitcher player1 = new ReliefPitcher("34", "Sammi James", "LHP", 2.0,
                                              .125, 5, 4, 3.85, 0);
   //Tests saves                                      
      player1.setSaves(17);
      Assert.assertEquals(17, player1.getSaves());
   //Tests rating
      Assert.assertEquals(2.4742268041237114, player1.rating(), .000);
   }
/**
* Tests stats().
*/   
   @Test public void statsTest()
   {
      ReliefPitcher player1 = new ReliefPitcher("34", "Sammi James", "LHP", 2.0,
                                                .125, 5, 4, 3.85, 17);
      String stats = "5 wins, 4 losses, 17 saves, 3.85 ERA";
      Assert.assertEquals(stats, player1.stats());
   }
/**
* Tests toString().
*/   
   @Test public void toStringTest()
   {
      ReliefPitcher player1 = new ReliefPitcher("34", "Sammi James", "LHP", 2.0,
                                                .125, 5, 4, 3.85, 17);
      String output = "34 Sammi James (LHP) 5 wins, 4 losses, 17 saves, 3.85";
      output += " ERA\nSpecialization Factor: 2.0 (class ReliefPitcher) ";
      output += "Rating: 2.474";
      Assert.assertEquals(output, player1.toString()); 
   }

}
