package problem2;

/**
 * Represents an object Recipient, including its firstName, lastName, and emailAddress
 *
 * @author Zhuocai Li
 */
public class Recipient {
  private final String firstName;
  private final String lastName;
  private final String emailAddress;

  /**
   * Constructs a new Recipient, with its firstName, lastName, and emailAddress
   *
   * @param firstName - first name of Recipient, expressed as a String
   * @param lastName - last name of Recipient, expressed as a String
   * @param emailAddress - email address of Recipient, expressed as a String
   */
  public Recipient(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * returns the first name of Recipient, expressed as a String
   *
   * @return String
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * returns the last name of Recipient, expressed as a String
   *
   * @return String
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * returns the email address of Recipient, expressed as a String
   *
   * @return String
   */
  public String getEmailAddress() {
    return emailAddress;
  }
}
