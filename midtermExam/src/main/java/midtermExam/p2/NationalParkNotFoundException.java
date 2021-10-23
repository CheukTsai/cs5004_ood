package midtermExam.p2;

/**
 * Represents NationalParkNotFoundException, thrown when the park is not found in the
 * NationalParkDirectorySystem
 */
public class NationalParkNotFoundException extends Exception {

  /**
   * Throws message when NationalParkNotFoundException occurs
   */
  public NationalParkNotFoundException() {
    super("National Park not found");
  }
}
