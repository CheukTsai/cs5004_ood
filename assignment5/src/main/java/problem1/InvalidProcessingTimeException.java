package problem1;

/**
 * Represents an exception InvalidProcessingTimeException, thrown when processing date is
 * earlier than creation date
 */
public class InvalidProcessingTimeException extends Exception{

  public InvalidProcessingTimeException() {
    super("Processing time should be after your donation time");
  }
}
