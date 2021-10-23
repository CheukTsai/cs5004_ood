package prob1;

import java.util.Objects;

/**
 * Represents a concrete class Residential, extending its parent class Property
 */
public class Residential extends Property {

  private Integer numBedrooms;
  private Double numBathrooms;

  /**
   * Constructs a Residential
   *
   * @param address      the address of the Residential, as a String
   * @param size         the size of the Residential, as an Integer
   * @param numBedrooms  the number of bedrooms of the Residential, as an Integer
   * @param numBathrooms the number of bathrooms of the Residential, as a Double
   */
  public Residential(String address, Integer size, Integer numBedrooms,
      Double numBathrooms) {
    super(address, size);
    this.numBedrooms = numBedrooms;
    this.numBathrooms = numBathrooms;
    this.checkPropertyInfo();
  }

  /**
   * Helper, checks if the propertyInfo is correct
   */
  private void checkPropertyInfo() {
    if (this.numBedrooms <= 0) {
      throw new IllegalArgumentException("Illegal number of bedrooms");
    }
    if (this.numBathrooms <= 0 || this.numBathrooms - this.numBathrooms.intValue() != 0.5) {
      throw new IllegalArgumentException("Illegal number of bathrooms");
    }
  }

  /**
   * Returns the number of bedrooms
   *
   * @return number of bedrooms
   */
  public Integer getNumBedrooms() {
    return numBedrooms;
  }

  /**
   * Returns the number of bathrooms
   *
   * @return number of bathrooms
   */
  public Double getNumBathrooms() {
    return numBathrooms;
  }

  /**
   * {@inheritDoc} Indicates whether some other object passed as an argument is "equal to" the
   * Residential
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    if (!(o instanceof Residential)) {
      return false;
    }
    Residential that = (Residential) o;
    return Objects.equals(numBedrooms, that.numBedrooms) && Objects
        .equals(numBathrooms, that.numBathrooms);
  }


  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numBedrooms, numBathrooms);
  }


  /**
   * {@inheritDoc} Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Residential{" +
        "address='" + address + '\'' +
        ", size=" + size +
        ", num_bedrooms=" + numBedrooms +
        ", num_bathrooms=" + numBathrooms +
        '}';
  }

}
