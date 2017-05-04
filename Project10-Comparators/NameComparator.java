import java.util.Comparator;
/**
* Creates a way to compare by name.
* Project 10
* @author Sloan Kiechel
* @version 4/21/16
*/
public class NameComparator implements Comparator<SoftballPlayer>
{
/**
* Compares two softball players by ratings.
* @return an int, 1 if greater, -1, if less, 0 if equal.
* @param p1 player1
* @param p2 player2
*/
   public int compare(SoftballPlayer p1, SoftballPlayer p2)
   {
      String name1 = p1.getName();
      String name2 = p2.getName();
      name1.trim();
      name2.trim();
      String lastName = "";
      String firstName = "";
      String lastName2 = "";
      String firstName2 = "";
      for (int i = 0; i < name1.length(); i++)
      {
         if (name1.charAt(i) == ' ')
         {
            lastName = name1.substring(i);
            firstName = name1.substring(0, i);
            break;
         }
      }
      for (int i = 0; i < name2.length(); i++)
      {
         if (name2.charAt(i) == ' ')
         {
            lastName2 = name2.substring(i);
            firstName2 = name2.substring(0, i);
            break;
         }
      }
      lastName.toLowerCase();
      firstName.toLowerCase();
      lastName2.toLowerCase();
      firstName2.toLowerCase();
      if (lastName.compareTo(lastName2) > 0)
      {
         return 1;
      }
      else if (lastName.compareTo(lastName2) < 0)
      {
         return -1;
      }
      else
      {
         if (firstName.compareTo(firstName2) > 0)
         {
            return 1;
         }
         if (firstName.compareTo(firstName2) < 0)
         {
            return -1;
         }
         else 
         {
            return 0;
         }
      }
      
   }
}