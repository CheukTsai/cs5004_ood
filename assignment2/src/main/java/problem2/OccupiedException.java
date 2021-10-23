package problem2;

/** Exception class, thrown when a Locker is occupied. */
public class OccupiedException extends Exception {
  public OccupiedException() {
    super("This locker is already occupied.");
  }
}
