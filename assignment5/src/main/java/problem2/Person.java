package problem2;

import java.util.Objects;
import java.util.Set;

/**
 * Represents an abstract class Person, extending its parent class Creator
 */
public abstract class Person extends Creator {
  private String firstName;
  private String lastName;

  /**
   * Constructs a Person, with firstName and lastName
   * @param firstName - String, first name of the person
   * @param lastName - String, last name of the person
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * {@inheritDoc}
   * Overrides getName(), returns a new string with firstName and lastName;
   * @return String
   */
  @Override
  public String getName() {
    return firstName + " " + lastName;
  }

  /**
   * {@inheritDoc}
   * Overrides getMembers()
   */
  @Override
  public abstract Set<Person> getMembers();

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(firstName, person.firstName) && Objects
        .equals(lastName, person.lastName);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Person{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
