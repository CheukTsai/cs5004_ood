package problem3;

/*** Time is a simple object that has a unique
 * first name, and last name. */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructor that creates a new Name object with the specified first name and last name.
   *
   * @param firstName - first name of the new Name object.
   * @param lastName - last name of the new Name.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the firstName of the Name.
   *
   * @return the firstName of the Name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the lastName of the Name.
   *
   * @return the lastName of the Name.
   */
  public String getLastName() {
    return lastName;
  }
}
