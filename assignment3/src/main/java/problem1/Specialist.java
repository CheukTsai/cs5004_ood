package problem1;

/**
 * Represents an abstract class Specialist, extending Service,
 * including the number of needed licensed employees,
 * whether the service is complex, and customer's other basic information.
 */
public abstract class Specialist extends Service {
  private static final double BASIC_RATE_SPECIALIST = 200;
  private static final Integer MIN_EMPLOYEES_FOR_LARGE_HOUSE = 3;
  private static final Integer MIN_EMPLOYEES_FOR_SMALL_OR_MEDIUM_HOUSE = 2;
  private static final Integer MIN_EMPLOYEES_FOR_SPECIALIST = 1;
  protected Integer numberOfLicensedEmployees;
  protected Boolean ifComplex;

  /**
   * Constructs a new specialist, with basicInformation, ifComplex and
   * numberOfLicensedEmployees, numberOfLicensedEmployees will change based on
   * ifComplex and specific limits
   *
   * @param basicInformation - basic information of the customer, expressed as a BasicInformation
   * @param ifComplex - whether service is complex, expressed as a boolean
   * @param numberOfLicensedEmployees - number of licensed employees needed, expressed as an Integer
   */
  public Specialist(BasicInformation basicInformation,
      Boolean ifComplex, Integer numberOfLicensedEmployees) {
    super(basicInformation);
    this.numberOfLicensedEmployees = Math.max(numberOfLicensedEmployees,
        MIN_EMPLOYEES_FOR_SPECIALIST);
    this.ifComplex = ifComplex;
    this.complexVerification();
  }


  /**
   * {@inheritDoc}
   * Calculates the specialist price based on the number of licensed employees
   * @return double
   */
  @Override
  public double calculatePrice() {
    this.finalPrice += BASIC_RATE_SPECIALIST * this.numberOfLicensedEmployees;
    return super.calculatePrice();
  }

  /**
   * A helper to modify the number of licensed employees based on ifComplex and
   * the size of the property.
   *
   */
  private void complexVerification() {
    if (this.ifComplex) {
      switch (this.basicInformation.getPropertySize()){
        case SMALL:
        case MEDIUM:
          this.numberOfLicensedEmployees = Math.max(
              this.numberOfLicensedEmployees, MIN_EMPLOYEES_FOR_SMALL_OR_MEDIUM_HOUSE);
          break;
        default:
          this.numberOfLicensedEmployees = Math.max(
              this.numberOfLicensedEmployees, MIN_EMPLOYEES_FOR_LARGE_HOUSE);
          break;
      }
    }
  }
}
