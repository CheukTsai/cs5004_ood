package prob1;

import java.util.Objects;

/**
 * Represents an abstract class Property
 */
public abstract class Property {

  protected String address;
  protected Integer size; // Size in square feet, a non-negative integer.

  /**
   * Constructs a Property
   *
   * @param address the address of the Property, as a String
   * @param size    the size of the Property, as an Integer
   */
  public Property(String address, Integer size) {
    this.address = address;
    this.size = size;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * Property
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (!(o instanceof Property)) {
      return false;
    }
    Property property = (Property) o;
    return Objects.equals(address, property.address) && Objects
        .equals(size, property.size);
  }

  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(address, size);
  }
}
