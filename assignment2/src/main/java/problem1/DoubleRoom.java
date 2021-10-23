package problem1;

/** Represents a room with a default maximum occupancy of 2 */
public class DoubleRoom extends AbstractRoom {
  private static final Integer Maximum_Occupancy = 2;

  /**
   * Constructs a new DoubleRoom, with specific price
   *
   * @param price - the price of booking a DoubleRoom, expressed as an Integer
   */
  public DoubleRoom(Integer price) {
    super(Maximum_Occupancy, price);
  }
}
