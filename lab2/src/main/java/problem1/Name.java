package problem1;

import java.util.Objects;

public class Name {
  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Constructs a new Name, based upon all of the provided input parameters.
   * @param firstName - first name, expressed as String
   * @param middleName - middle name, expressed as String
   * @param lastName - last name, expressed as String
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * returns first name as a String
   * @return a String
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * returns middle name as a String
   * @return a String
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * returns last name as a String
   * @return a String
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(firstName, name.firstName) && Objects
        .equals(middleName, name.middleName) && Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, middleName, lastName);
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
