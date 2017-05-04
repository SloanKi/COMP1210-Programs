/**
* Creates a way to handle invalid category exceptions.
* Project 11
* @author Sloan Kiechel
* @version 4/28/16
*/
public class InvalidCategoryException extends Exception
{
/**
* Handles an invalid category.
* @param category the invalid category
*/
   public InvalidCategoryException(String category)
   {
      super("For category: " + "\"" + category + "\"");
   }
}