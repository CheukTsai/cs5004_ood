package problem1;

/**
 * Represents InvalidCallException, thrown when the call is invalid
 */
public class InvalidCallException extends Exception{

  public InvalidCallException(String message) {
    super(message);
  }
}
