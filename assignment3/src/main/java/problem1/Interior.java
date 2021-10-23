package problem1;

/**
 * Represents an abstract class Interior, extending Service,
 * including the number of pets the customer owns and his/her other basic information.
 */
public abstract class Interior extends Service {
  protected static final double BASE_RATE_INTERIOR = 80;
  private static final double BASE_ONE = 1;
  private static final Integer ONE = 1;
  private static final Integer THREE = 3;
  private static final double EXTRA_RATE_FOR_ONE_OR_TWO_PETS = 0.05;
  private static final double EXTRA_RATE_FOR_THREE_OR_MORE_PETS = 0.07;
  protected Integer numberOfPets;

  /**
   * Constructs a new abstract class Interior, with basicInformation and numberOfPets
   *
   * @param basicInformation - basic information of customer, expressed as a BasicInformation
   * @param numberOfPets - number of pets owned by customer, expressed as an Integer
   */
  public Interior(BasicInformation basicInformation, Integer numberOfPets) {
    super(basicInformation);
    this.numberOfPets = numberOfPets;
  }

  /**
   * {@inheritDoc}
   * Returns the price after calculating the extra interior fee.
   *
   * @return double
   */
  @Override
  public double calculatePrice() {
    return addExtraPetFee(super.calculatePrice());
  }

  /**
   * A helper to add the extra pet fee for interior service.
   * @param basicFee - interior fee before calculating the extra pet fee, expressed as a double
   * @return double
   */
  private double addExtraPetFee(double basicFee){
    if(this.numberOfPets >= ONE && this.numberOfPets < THREE){
      return basicFee * (BASE_ONE+EXTRA_RATE_FOR_ONE_OR_TWO_PETS);
    }
    if(this.numberOfPets >= THREE){
      return basicFee * (BASE_ONE+EXTRA_RATE_FOR_THREE_OR_MORE_PETS);
    }
    return basicFee;
  }
}
