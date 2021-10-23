package problem1;

/**
 * Represents an concrete class Cleaning, extending Interior.
 */
public class Cleaning extends Interior{

  private static final double HOUR_SPENT_SMALL_HOUSE = 1;
  private static final double HOUR_SPENT_MEDIUM_HOUSE = 2;
  private static final double HOUR_SPENT_LARGE_HOUSE = 4;

  /**
   * Constructs a new Cleaning, with basicInformation and numberOfPets
   *
   * @param basicInformation - basic information of the customer, expressed as a BasicInformation
   * @param numberOfPets - number of pets owned by customer, expressed as an Integer
   */
  public Cleaning(BasicInformation basicInformation, Integer numberOfPets) {
    super(basicInformation, numberOfPets);
  }

  /**
   * {@inheritDoc}
   * Returns the price after calculating the cleaning part.
   * @return double
   */
  @Override
  public double calculatePrice() {
    this.finalPrice = calculateCleaningPrice();
    return super.calculatePrice();
  }

  /**
   * A helper to calculate the cleaning price in different situations.
   * @return double
   */
  private double calculateCleaningPrice(){
    double finalPrice = 0;
    switch (this.basicInformation.getPropertySize()){
      case SMALL:
        finalPrice =  BASE_RATE_INTERIOR * HOUR_SPENT_SMALL_HOUSE;
        break;
      case MEDIUM:
        finalPrice = BASE_RATE_INTERIOR * HOUR_SPENT_MEDIUM_HOUSE;
        break;
      default:
        finalPrice = BASE_RATE_INTERIOR * HOUR_SPENT_LARGE_HOUSE;
        break;
    }
    return finalPrice;
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
