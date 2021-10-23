package midtermExam.p2;

/**
 * Represents InvalidNationalParkIDException, thrown when the given unique ID doesn't exist
 */
public class InvalidNationalParkIDException extends Exception{

  /**
   * Throws message when InvalidNationalParkIDException occurs
   */
  public InvalidNationalParkIDException() {
    super("Invalid National Park ID");
  }
}
