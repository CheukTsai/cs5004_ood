package prob1;

/**
 * Represents an Exception ListingNotFoundException, thrown when input listing is not found
 */
public class ListingNotFoundException extends Exception {

  /**
   * Constructs a ListingNotFoundException
   *
   * @param message message to throw
   */
  public ListingNotFoundException(String message) {
    super(message);
  }
}