import org.junit.Assert;
import org.junit.Test;
/**
* Tests the infielder class.
* Project 10
* @author Sloan Kiechel
* @version 4/21/16
*/   
public class InfielderTest 
{
/**
* Tests rating().
*/
   @Test public void ratingTest()
   {
      Infielder player1 = new Infielder("23", "Jackie Smith", "3B",
                                        1.25, .275, 0);
      player1.setInfielderFieldingAvg(.85);
      Assert.assertEquals(.85, player1.getInfielderFieldingAvg(), .00);
      Assert.assertEquals(2.9218750000000004, player1.rating(), 0.000);
   }
/**
* Tests toString().
*/   
   @Test public void toStringTest()
   {
      Infielder player1 = new Infielder("23", "Jackie Smith", "3B",
                                           1.25, .275, .85); 
      String output = "23 Jackie Smith (3B) 0.275\nSpecialization Factor: 1.25";
      output += " (class Infielder) Rating: 2.922";
      Assert.assertEquals(output, player1.toString());
   }
}
