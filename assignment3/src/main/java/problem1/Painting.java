package problem1;

/**
 * Represents an concrete class Painting, extending Interior.
 */
public class Painting extends Interior{

  private static final double HOUR_SPENT_SMALL_MEDIUM_HOUSE = 16;
  private static final double HOUR_SPENT_LARGE_HOUSE = 24;

  /**
   * Constructs a new Painting, with basicInformation and numberOfPets
   *
   * @param basicInformation - basic information of the customer, expressed as a BasicInformation
   * @param numberOfPets - number of pets owned by customer, expressed as an Integer
   */
  public Painting(BasicInformation basicInformation, Integer numberOfPets) {
    super(basicInformation, numberOfPets);
  }

  /**
   * {@inheritDoc}
   * Calculates the painting service price.
   * @return double
   */
  @Override
  public double calculatePrice() {
    this.finalPrice = calculatePaintingPrice();
    return super.calculatePrice();
  }

  /**
   * A helper to calculate the painting price in different situations.
   * @return double
   */
  private double calculatePaintingPrice() {
    double finalPrice = 0;

    switch (this.basicInformation.getPropertySize()) {
      case SMALL:
      case MEDIUM:
        finalPrice = BASE_RATE_INTERIOR * HOUR_SPENT_SMALL_MEDIUM_HOUSE;
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
