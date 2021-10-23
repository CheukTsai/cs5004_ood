package prob1;

import java.util.Objects;

/**
 * Represents a concrete class Commercial, extending its parent class Property
 */
public class Commercial extends Property {

  private Integer numOfOffices;
  private Boolean isRetail;

  /**
   * Constructs a Commercial
   *
   * @param address      the address of the Commercial, as a String
   * @param size         the size of the Commercial, as an Integer
   * @param numOfOffices the number of offices of the Commercial, as an Integer
   * @param isRetail     whether the Commercial is retail, as a Boolean
   */
  public Commercial(String address, Integer size, Integer numOfOffices, Boolean isRetail) {
    super(address, size);
    this.numOfOffices = numOfOffices;
    this.isRetail = isRetail;
    this.checkPropertyInfo();
  }

  /**
   * Helper, checks if the propertyInfo is correct
   */
  private void checkPropertyInfo() {
    if (this.numOfOffices <= 0) {
      throw new IllegalArgumentException("Illegal number of offices");
    }
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * Commercial
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    if (!(o instanceof Commercial)) {
      return false;
    }
    Commercial that = (Commercial) o;
    return Objects.equals(numOfOffices, that.numOfOffices) && Objects
        .equals(isRetail, that.isRetail);
  }

  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfOffices, isRetail);
  }

  /**
   * {@inheritDoc} Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Commercial{" +
        "numOfOffices=" + numOfOffices +
        ", isRetail=" + isRetail +
        ", address='" + address + '\'' +
        ", size=" + size +
        '}';
  }
}
