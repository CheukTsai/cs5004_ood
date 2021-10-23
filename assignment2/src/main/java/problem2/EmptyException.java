package problem2;

/** Exception class, thrown when a Locker is empty. */
public class EmptyException extends Exception {
  public EmptyException() {
    super("There is no mail in this locker");
  }
}
