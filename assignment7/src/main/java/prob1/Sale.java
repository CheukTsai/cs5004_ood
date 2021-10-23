package prob1;

/**
 * Represents an concrete class Sale, extending its parent class Contract
 */
public class Sale extends Contract {

  private static final Integer SALE_COMMISSION_FACTOR = 1;

  /**
   * Constructs a Sale
   *
   * @param askingPrice  the asking price of the Sale Contract
   * @param isNegotiable whether the Sale Contract is negotiable
   */
  public Sale(Double askingPrice, Boolean isNegotiable) {
    super(askingPrice, isNegotiable);
  }

  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return super.hashCode();
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
    return super.equals(o);
  }

  /**
   * {@inheritDoc} Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Sale{" +
        "asking_price=" + askingPrice +
        ", negotiable=" + isNegotiable +
        '}';
  }

  /**
   * {@inheritDoc} Helper, returns commission factor for calculating commission
   *
   * @return commission factor
   */
  @Override
  protected Integer getCommissionFactor() {
    return SALE_COMMISSION_FACTOR;
  }
}
