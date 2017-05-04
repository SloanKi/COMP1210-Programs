import org.junit.Assert;
import org.junit.Test;
   
/**
* Tests InvalidCategoryExceptionTest.
* Project 11
* @author Sloan Kiechel
* @version 4/28/16
*/

public class InvalidCategoryExceptionTest {
   /**
   * Tests the output if the excepton is thrown.
   */
   @Test public void invalidTest()
   {
      String output = "";
      try
      {
         InvalidCategoryException e = new InvalidCategoryException("H");
         throw e;
      }
      catch (InvalidCategoryException e)
      {
         output = e.toString();
      }
      String test = "InvalidCategoryException: For category: \"H\"";
      Assert.assertEquals(test, output);
   }
}
