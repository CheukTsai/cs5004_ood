package problem2;

/** Exception class, thrown when a Mail is larger than a Locker. */
public class OversizeException extends Exception {
  public OversizeException() {
    super("The mail cannot fit in the locker.");
  }
}
