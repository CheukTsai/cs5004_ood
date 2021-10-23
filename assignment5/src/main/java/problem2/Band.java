package problem2;

import java.util.Set;

/**
 * Represents a concrete class Band, extending its parent class Group
 */
public class Band extends Group{

  /**
   * Constructs a Band, with name and a collection of members
   * @param name - String, name of the band
   * @param members - Set of Person, collection of members
   */
  public Band(String name, Set<Person> members) {
    super(name, members);
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
