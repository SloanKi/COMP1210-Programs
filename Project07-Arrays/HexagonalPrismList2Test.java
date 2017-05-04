import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
/**
* Tests the methods of HexagonalPrismList2.
*/
public class HexagonalPrismList2Test {
/**
* Tests readFile, getName, getList, and numberOfHexagonalPrisms.
* @throws IOException for reading the file.
*/
   @Test public void readFile()throws IOException
   {
      String hpListName = "No list name";
      HexagonalPrism[] myList = new HexagonalPrism[100];
      String fileName = "No file name";
      int elements = 0;
      HexagonalPrismList2 hpList = new HexagonalPrismList2(hpListName, myList,
                                    +elements);
      Assert.assertEquals(myList, hpList.getList());
      Assert.assertEquals("No list name", hpList.getName());
      Assert.assertEquals(0, hpList.numberOfHexagonalPrisms());
      hpList = hpList.readFile("hexagonal_prism_1.dat");
      Assert.assertEquals("Hexagonal Prism List 1", hpList.getName());
      Assert.assertEquals(4, hpList.numberOfHexagonalPrisms());
   }
   
}
