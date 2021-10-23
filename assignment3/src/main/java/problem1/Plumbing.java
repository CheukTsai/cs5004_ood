package problem1;

/**
 * Represents an concrete class Plumbing, extending Specialist.
 */
public class Plumbing extends Specialist{

  private static final double PERMITTING_FEE = 20;

  /**
   *
   * @param basicInformation - basic information of the customer, expressed as a BasicInformation
   * @param ifComplex - whether service is complex, expressed as a boolean
   * @param numberOfLicensedEmployees number of licensed employees needed, expressed as an Integer
   */
  public Plumbing(BasicInformation basicInformation, Boolean ifComplex,
      Integer numberOfLicensedEmployees) {
    super(basicInformation, ifComplex, numberOfLicensedEmployees);
  }

  /**
   * {@inheritDoc}
   * Calculate the price after adding permitting fee.
   * @return double
   */
  @Override
  public double calculatePrice() {
    return super.calculatePrice() + PERMITTING_FEE;
  }

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
