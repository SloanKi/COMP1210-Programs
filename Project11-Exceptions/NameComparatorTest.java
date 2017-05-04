import org.junit.Assert;
import org.junit.Test;
   /**
* Tests NameComparator.
* Project 10
* @author Sloan Kiechel
* @version 4/21/16
*/ 

public class NameComparatorTest {
   /**
   * Tests all 4 ways names can be compared.
   */
   @Test public void nameCompTest()
   {
      Outfielder p1 = new Outfielder("32", "Jackie Lee", "RF", 1.0,
                           .892, 1.32);
      Outfielder p2 = new Outfielder("32", "Han Lee", "RF", 1.0,
                           .892, 1.32);                     
      Outfielder p3 = new Outfielder("32", "Jackie Smith", "RF", 1.0,
                           .892, 1.32);
      Outfielder p4 = new Outfielder("32", "Jackie Lee", "RF", 1.0,
                           .892, 1.32);
      Outfielder p5 = new Outfielder("32", "Michael Lee", "RF", 1.0,
                           .892, 1.32);
      NameComparator ncomp = new NameComparator();
      Assert.assertEquals(1, ncomp.compare(p1, p2), 0);
      Assert.assertEquals(-1, ncomp.compare(p1, p3), 0);
      Assert.assertEquals(0, ncomp.compare(p1, p4), 0);
      Assert.assertEquals(-1, ncomp.compare(p1, p5), 0);                 
   }
}
