package problem1;

/**
 * Represents an abstract class Exterior, extending Service,
 * including the customer's basic information.
 */
public abstract class Exterior extends Service {
  protected static final double BASE_RATE_EXTERIOR = 80;
  private static final double HOUR_SPENT_SMALL_HOUSE = 1;
  private static final double HOUR_SPENT_MEDIUM_HOUSE = 2;
  private static final double HOUR_SPENT_LARGE_HOUSE = 4;

  /**
   * Constructs a new abstract class Exterior, with basicInformation.
   *
   * @param basicInformation - basic information of the customer, expressed as a BasicInformation
   */
  public Exterior(BasicInformation basicInformation) {
    super(basicInformation);
  }

  /**
   * {@inheritDoc}
   * Calculate the price after considering the exterior service part.
   * @return double
   */
  @Override
  public double calculatePrice() {
    this.finalPrice += calculateExterior();
    return super.calculatePrice();
  }

  /**
   * Calculates the exterior price in different situations.
   * @return double
   */
  private double calculateExterior(){
    double finalPrice = 0;
    switch(this.basicInformation.getPropertySize()){
      case LARGE:
        finalPrice = BASE_RATE_EXTERIOR * HOUR_SPENT_LARGE_HOUSE;
        break;
      case MEDIUM:
        finalPrice = BASE_RATE_EXTERIOR * HOUR_SPENT_MEDIUM_HOUSE;
        break;
      default:
        finalPrice = BASE_RATE_EXTERIOR * HOUR_SPENT_SMALL_HOUSE;
        break;
    }
    return finalPrice;
  }
}
