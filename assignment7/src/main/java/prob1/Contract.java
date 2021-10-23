
package prob1;

import java.util.Objects;

/**
 * Represents an abstract class Contract
 */
public abstract class Contract {

  protected Double askingPrice;
  protected Boolean isNegotiable;

  /**
   * Constructs a Contract
   *
   * @param askingPrice  the asking price of the Contract
   * @param isNegotiable whether the Contract is negotiable
   */
  public Contract(Double askingPrice, Boolean isNegotiable) {
    this.askingPrice = askingPrice;
    this.isNegotiable = isNegotiable;
  }

  /**
   * {@inheritDoc} Indicates whether some other object passed as an argument is "equal to" the
   * Contract
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
    if (!(o instanceof Contract)) {
      return false;
    }

    Contract contract = (Contract) o;
    return Objects.equals(askingPrice, contract.askingPrice) && Objects
        .equals(isNegotiable, contract.isNegotiable);
  }

  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(askingPrice, isNegotiable);
  }

  /**
   * {@inheritDoc} Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Contract{" +
        "asking_price=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        '}';
  }

  /**
   * Returns commission factor for calculating commission
   *
   * @return commission factor
   */
  protected abstract Integer getCommissionFactor();
}
