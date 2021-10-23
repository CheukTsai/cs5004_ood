package problem2;

import java.util.Objects;
import java.util.Set;

/**
 * Represents an abstract class Group, extending its parent class Creator
 */
public abstract class Group extends Creator {
  private String name;
  private Set<Person> members;

  /**
   * Constructs a Band, with name and a collection of members
   * @param name - String, name of the group
   * @param members - Set of Person, collection of members
   */
  public Group(String name, Set<Person> members) {
    this.name = name;
    this.members = members;
  }

  /**
   * {@inheritDoc}
   * Overrides getName(), returns the name of the group
   * @return String
   */
  @Override
  public String getName() {
    return this.name;
  }
  /**
   * {@inheritDoc}
   * Overrides getMembers(), returns the name of the group
   * @return Set of Person
   */
  @Override
  public Set<Person> getMembers() {
    return this.members;
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
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(name, group.name) && Objects
        .equals(members, group.members);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, members);
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Group{" +
        "name='" + name + '\'' +
        ", members=" + members +
        '}';
  }
}
