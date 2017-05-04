import org.junit.Assert;
import org.junit.Test;
/**
* Tests the methods of Hexagonal Prism.
*/
public class HexagonalPrismTest {

/**
* Tests setLabel and getLabel.
*/   
   @Test public void setLabel()
   {
      HexagonalPrism test = new HexagonalPrism("Test", 2.0, 5.4);
      Assert.assertEquals("Test", test.getLabel());
      test.setLabel("Meow");
      Assert.assertEquals("Meow", test.getLabel());
      test.toString();
   }
/**
* Tests setSide, setHeight, getSide, getHeight, and basePerimeter.
*/   
   @Test public void basePerimeter()
   {
      HexagonalPrism test = new HexagonalPrism("Test", 2.0, 5.4);
      test.setSide(3.0);
      test.setHeight(2.3);
      Assert.assertEquals(3.0, test.getSide(), .001);
      Assert.assertEquals(2.3, test.getHeight(), .001);
      Assert.assertEquals(18.0, test.basePerimeter(), .001);
   }
/**
* Tests baseArea.
*/   
   @Test public void baseArea()
   {
      HexagonalPrism test = new HexagonalPrism("Test", 2.0, 5.4);
      Assert.assertEquals(10.392, test.baseArea(), .001);
   }
/**
* Tests surfaceArea.
*/
   @Test public void surfaceArea()
   {
      HexagonalPrism test = new HexagonalPrism("Test", 2.0, 5.4);
      Assert.assertEquals(85.584, test.surfaceArea(), .001);
   }
/**
* Tests volume.
*/   
   @Test public void volume()
   {
      HexagonalPrism test = new HexagonalPrism("Test", 2.0, 5.4);
      Assert.assertEquals(56.118, test.volume(), .001);
   }
/**
* Tests resetCount and get count.
*/     
   @Test public void resetCount()
   {
      HexagonalPrism.resetCount();
      HexagonalPrism test = new HexagonalPrism("Test", 2.0, 5.4);
      HexagonalPrism test2 = new HexagonalPrism("Test 2", 4.0, 7.0);
      Assert.assertEquals(2, test2.getCount());
      HexagonalPrism.resetCount();
      Assert.assertEquals(0, HexagonalPrism.getCount());
   }
/**
* Tests equals, both true and false, tests hashcode.
*/   
   @Test public void equals()
   {
      HexagonalPrism test = new HexagonalPrism("Test", 2.0, 5.4);
      HexagonalPrism test2 = test;
      String strTest = " ";
      Assert.assertEquals(true, test.equals(test2));
      Assert.assertEquals(false, test.equals(strTest));
      Assert.assertEquals(0, test.hashCode());
   }
}