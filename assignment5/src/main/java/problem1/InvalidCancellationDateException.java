package problem1;

/**
 * Represents an exception InvalidCancellationDateException, thrown when cancellation date is
 * earlier than subscription date
 */
public class InvalidCancellationDateException extends Exception{

  /**
   * Throws specific information when exception is thrown
   */
  public InvalidCancellationDateException() {
    super("Invalid cancellation date is input");
  }
}
