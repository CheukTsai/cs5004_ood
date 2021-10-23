package problem2;

import java.util.Set;

/**
 * Represents a concrete class Author, extending its parent class Person
 */
public class Author extends Person{


  /**
   * Constructs an Author, with firstName and lastName
   * @param firstName - String, first name of the author
   * @param lastName - String, last name of the author
   */
  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }


  /**
   * {@inheritDoc}
   * Overrides getMembers(), returns null
   * @return null
   */
  @Override
  public Set<Person> getMembers() {
    return null;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return boolean
   */

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
