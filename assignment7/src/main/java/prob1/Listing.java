package prob1;

import java.util.Objects;

/**
 * Represents a concrete class Property
 *
 * @param <T> objects extend Property
 * @param <E> objects extend Contract
 */
public class Listing<T extends Property, E extends Contract> {

  private T property; // T for Property
  private E contract; // E for Contract

  /**
   * Constructs a Listing
   *
   * @param property property of the listing
   * @param contract contract of the listing
   */
  public Listing(T property, E contract) {
    this.property = property; // can be commercial or residential
    this.contract = contract; // property can be sale or rental
  }

  /**
   * Returns the Contract of the Listing
   *
   * @return the Contract of the Listing
   */
  public E getContract() {
    return contract;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * Listing
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Listing<?, ?> listing = (Listing<?, ?>) o;
    return Objects.equals(property, listing.property) && Objects
        .equals(contract, listing.contract);
  }


  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(property, contract);
  }

  /**
   * {@inheritDoc} Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Listing{" +
        "property=" + property +
        ", contract=" + contract +
        '}';
  }
}
