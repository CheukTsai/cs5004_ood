package problem1;

/**
 * Represents an concrete class Electrical, extending Specialist.
 */
public class Electrical extends Specialist{

  private static final double PERMITTING_FEE = 50;

  private static final Integer LICENSED_EMPLOYEE_LIMIT = 4;

  /**
   * Constructs a new Electrical, with basicInformation, ifComplex and numberOfLicensedEmployees
   *
   * @param basicInformation - basic information of the customer, expressed as a BasicInformation
   * @param ifComplex - whether service is complex, expressed as a boolean
   * @param numberOfLicensedEmployees - number of licensed employees needed, expressed as an Integer
   * @throws OutNumberedLicensedEmployeeException - thrown if too many employees are needed
   */
  public Electrical(BasicInformation basicInformation, Boolean ifComplex,
      Integer numberOfLicensedEmployees)
      throws OutNumberedLicensedEmployeeException{
    super(basicInformation, ifComplex, numberOfLicensedEmployees);
    if(numberOfLicensedEmployees > LICENSED_EMPLOYEE_LIMIT){
      throw new OutNumberedLicensedEmployeeException();
    }
  }

  /**
   * {@inheritDoc}
   * Calculates the price after adding permitting fee.
   * @return double
   */
  @Override
  public double calculatePrice() {
    return super.calculatePrice() + PERMITTING_FEE;
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
