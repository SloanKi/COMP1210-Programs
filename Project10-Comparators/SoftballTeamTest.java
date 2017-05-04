import org.junit.Assert;
import org.junit.Test;

/**
* Tests SoftballTeam
* Project 10
* @author Sloan Kiechel
* @version 4/21/16
*/

public class SoftballTeamTest {

   @Test public void SoftballTest()
   {
      SoftballTeam st = new SoftballTeam();
      st.setTeamName("Meow");
      Assert.assertEquals("Meow", st.getTeamName());
   }
}
