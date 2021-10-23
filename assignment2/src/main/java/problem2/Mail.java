package problem2;

/** Represents a Mail, with width, height and depth, and a fixed Recipient */
public class Mail extends AbstractCuboid {
  private final Recipient recipient;

  /**
   * Constructs a Mail, with width, height, depth and recipient
   *
   * @param width - the width of Mail, expressed as an Integer
   * @param height - the height of Mail, expressed as an Integer
   * @param depth - the depth of Mail, expressed as an Integer
   * @param recipient - the recipient of Mail, expressed as a Recipient
   */
  public Mail(Integer width, Integer height, Integer depth, Recipient recipient) {
    super(width, height, depth);
    this.recipient = recipient;
  }

  /**
   * returns the recipient of the Mail
   *
   * @return Recipient
   */
  public Recipient getRecipient() {
    return recipient;
  }
}
