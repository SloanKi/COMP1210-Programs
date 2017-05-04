import java.util.Comparator;
/**
* Creates a way to compare by rating.
* Project 10
* @author Sloan Kiechel
* @version 4/21/16
*/
public class RatingComparator implements Comparator<SoftballPlayer>
{
/**
* Compares two softball players by ratings.
* @return an int, 1 if greater, -1, if less, 0 if equal.
* @param p1 player1
* @param p2 player2
*/
   public int compare(SoftballPlayer p1, SoftballPlayer p2)
   {
      if (p1.rating() > p2.rating())
      {
         return 1;
      }
      else if (p1.rating() < p2.rating())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }
}