package problem1;

import java.util.Objects;

/**
 * Represents an concrete class WindowCleaning, extending Exterior,
 * including the number of floors of customer's property and his/her other basic information.
 */
public class WindowCleaning extends Exterior{
  private Integer numberOfFloors;
  private static final Integer BASE_ONE = 1;
  private static final Integer FLOOR_LIMIT_ONE = 1;
  private static final Integer FLOOR_LIMIT_THREE = 3;
  private static final double EXTRA_FLOOR_FEE = 0.05;

  /**
   * Constructs a new WindowCleaning, with basicInformation and numberOfFloors
   *
   * @param basicInformation - basic information of the customer, expressed as a BasicInformation
   * @param numberOfFloors - number of floors of property, expressed as an Integer
   * @throws OutNumberedFloorException - thrown when there are too many floors
   */
  public WindowCleaning(BasicInformation basicInformation, Integer numberOfFloors)
      throws OutNumberedFloorException {
    super(basicInformation);
    if(numberOfFloors > FLOOR_LIMIT_THREE){
      throw new OutNumberedFloorException();
    }
    this.numberOfFloors = numberOfFloors;
  }

  /**
   * {@inheritDoc}
   * Calculates the price after adding fee for extra floors.
   * @return double
   */
  @Override
  public double calculatePrice() {
    return addExtraFloorFee(super.calculatePrice());
  }

  /**
   * A helper to add extra floor fee.
   *
   * @param basicPrice - price before adding fee, expressed as a double
   * @return double
   */
  private double addExtraFloorFee(double basicPrice){
    if (this.numberOfFloors > FLOOR_LIMIT_ONE){
      return basicPrice * (BASE_ONE + EXTRA_FLOOR_FEE);
    }
    return basicPrice;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return Boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WindowCleaning that = (WindowCleaning) o;
    return Objects.equals(numberOfFloors, that.numberOfFloors);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(numberOfFloors);
  }

  /**
   * {@inheritDoc} returns the value given to it in string format
   *
   * @return String
   */
  @Override
  public String toString() {
    return "WindowCleaning{" +
        "numberOfFloors=" + numberOfFloors +
        '}';
  }
}
