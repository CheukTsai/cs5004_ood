package problem1;

/** Represents a room with a default maximum occupancy of 4 */
public class FamilyRoom extends AbstractRoom {

  private static final Integer Maximum_Occupancy = 4;

  /**
   * Constructs a new FamilyRoom, with specific price
   *
   * @param price - the price of booking a FamilyRoom, expressed as an Integer
   */
  public FamilyRoom(Integer price) {
    super(Maximum_Occupancy, price);
  }
}
