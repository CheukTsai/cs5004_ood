package problem1;

/**
 * Represents an concrete class WindowCleaning, extending Exterior,
 * including the customer's basic information.
 */
public class Gardening extends Exterior{

  private static final double WASTE_REMOVAL_FEE = 20;

  /**
   * Constructs a new Gardening, with basicInformation.
   * @param basicInformation - basic information of the customer, expressed as a BasicInformation
   */
  public Gardening(BasicInformation basicInformation) {
    super(basicInformation);
  }

  /**
   * {@inheritDoc}
   * Adds waste removal fee to the price.
   * @return double
   */
  @Override
  public double calculatePrice() {
    this.finalPrice +=  WASTE_REMOVAL_FEE;
    return super.calculatePrice();
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
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param obj - an object to compare
   * @return Boolean
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * {@inheritDoc} returns the value given to it in string format
   *
   * @return String
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
