package problem2;

/**
 * Represents an object Locker, with specific width, height and depth, and available to receive a
 * mail
 */
public class Locker extends AbstractCuboid {
  private Mail mail;

  /**
   * Constructs a new Locker, with width, height and depth mail in it initiates as null
   *
   * @param width - the width of the Locker, expressed as an Integer
   * @param height - the height of the Locker, expressed as an Integer
   * @param depth - the depth of the Locker, expressed as an Integer
   */
  public Locker(Integer width, Integer height, Integer depth) {
    super(width, height, depth);
    this.mail = null;
  }

  /**
   * Adds Mail into the Locker
   *
   * @param mail - Object Mail
   * @throws OversizeException - thrown when either width, height or depth of the Mail is larger
   *     than that of the Locker
   * @throws OccupiedException - thrown when the Locker is not empty
   */
  public void addMail(Mail mail) throws OversizeException, OccupiedException {
    if (this.width < mail.width || this.height < mail.height || this.depth < mail.depth) {
      throw new OversizeException();
    } else if (this.mail != null) {
      throw new OccupiedException();
    }
    this.mail = mail;
  }

  /**
   * Picks up Mail in the Locker
   *
   * @param recipient - a Recipient who tries to pick up Mail in the Locker
   * @return Mail
   * @throws EmptyException - thrown when no Mail is in the Locker
   * @throws WrongRecipientException - thrown when the Recipient does not match that of the Mail
   */
  public Mail pickupMail(Recipient recipient) throws EmptyException, WrongRecipientException {
    if (this.mail == null) {
      throw new EmptyException();
    } else if (recipient != this.mail.getRecipient()) {
      throw new WrongRecipientException();
    }
    Mail temp = this.mail;
    this.mail = null;
    return temp;
  }

  /**
   * Return the current Mail in the Locker, expressed as Mail
   *
   * @return Mail
   */
  public Mail getMail() {
    return mail;
  }
}
