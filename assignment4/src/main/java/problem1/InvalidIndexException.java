package problem1;

/**
 * Represents an Exception, thrown when the index doesn't exist
 */
public class InvalidIndexException extends Exception{

  public InvalidIndexException() {
    super("Invalid index is input");
  }
}
