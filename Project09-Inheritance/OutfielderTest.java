import org.junit.Assert;
import org.junit.Test;
/**
* Tests outfielder and softball player methods.
* Project 9
* @author Sloan Kiechel
* @version 4/14/16
*/  

public class OutfielderTest
{
/**
* Tests getters and setters. 
*/
   @Test public void getterAndSetterTesting()
   {
      Outfielder player1 = new Outfielder("32", "Pat Jones", "RF",
                                           1.0, .375, .9499); 
      //Test name                                     
      player1.setName("Meow");
      Assert.assertEquals("Meow", player1.getName());
      //Test number
      player1.setNumber("52");
      Assert.assertEquals("52", player1.getNumber());
      //Test position
      player1.setPosition("LF");
      Assert.assertEquals("LF", player1.getPosition());
      //Test Specialization Factor
      player1.setSpecializationFactor(2.0);
      Assert.assertEquals(2.0, player1.getSpecializationFactor(), .0);
      //Test batting average
      player1.setBattingAvg(.945);
      Assert.assertEquals(.945, player1.getBattingAvg(), .000);
      //Test fielding average
      player1.setOutfielderFieldingAvg(.3234);
      Assert.assertEquals(.3234, player1.getOutfielderFieldingAvg(), .0000);
      //Checks Stats
      Assert.assertEquals("0.945", player1.stats());
      //Tests count
      SoftballPlayer.resetCount();
      Assert.assertEquals(0, SoftballPlayer.getCount());
   }
/**
* Tests Rating method.
*/   
   @Test public void ratingTest()
   {
      Outfielder player1 = new Outfielder("32", "Pat Jones", "RF",
                                           1.0, .375, .9499); 
      Assert.assertEquals(3.562125, player1.rating(), .000);
   }
/**
* Tests toString method.
*/   
   @Test public void toStringTest()
   {
      Outfielder player1 = new Outfielder("32", "Pat Jones", "RF",
                                           1.0, .375, .9499); 
      String output = "32 Pat Jones (RF) 0.375\nSpecialization Factor: 1.0";
      output += " (class Outfielder) Rating: 3.562";
      Assert.assertEquals(output, player1.toString());
   }
}
