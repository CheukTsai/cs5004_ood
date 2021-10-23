package problem1;

/** Represents a room with a default maximum occupancy of 1 */
public class SingleRoom extends AbstractRoom {

  /**
   * Constructs a new SingleRoom, with specific price
   *
   * @param price - the price of booking a SingleRoom, expressed as an Integer
   */
  private static final Integer Maximum_Occupancy = 1;

  public SingleRoom(Integer price) {
    super(Maximum_Occupancy, price);
  }
}
