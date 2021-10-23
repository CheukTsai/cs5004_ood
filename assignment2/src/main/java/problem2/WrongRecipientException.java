package problem2;

/** Exception class, thrown when the Recipient does not match. */
public class WrongRecipientException extends Exception {
  public WrongRecipientException() {
    super("This mail does not belong to you.");
  }
}
