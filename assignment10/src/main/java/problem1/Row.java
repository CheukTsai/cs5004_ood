package problem1;

import java.util.ArrayList;
import problem1.Seat.Builder;

/**
 * Represents a Row
 */
public class Row extends ArrayList<Seat> {

  private Integer rowNumber;
  private Boolean ifWheelchairAccessible;

  /**
   * Constructs a Row
   *
   * @param rowNumber              row number
   * @param ifWheelchairAccessible if the row is wheelchair accessible
   */
  public Row(Integer rowNumber, Boolean ifWheelchairAccessible) {
    this.rowNumber = rowNumber;
    this.ifWheelchairAccessible = ifWheelchairAccessible;
  }

  /**
   * Creates an empty row
   *
   * @param numberOfSeats number of seats in the row
   */
  public void initialize(Integer numberOfSeats) {
    for (int i = 65; i < numberOfSeats + 65; i++) {
      Builder builder = new Builder(Character.toString((char) i));
      this.add(builder.build());
    }
  }

  /**
   * Returns if it is wheelchair accessible
   *
   * @return if it is wheelchair accessible
   */
  public Boolean getIfWheelchairAccessible() {
    return ifWheelchairAccessible;
  }

  /**
   * Overrides toString, making sure it will show the row graph in a correct format
   *
   * @return the expected row graph
   */
  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append(rowNumber);
    for (Seat seat : this) {
      output.append(" ");
      if (seat.getReservedFor().equals("No one")) {
        if (this.ifWheelchairAccessible) {
          output.append("=");
        } else {
          output.append("_");
        }
      } else {
        output.append("X");
      }
    }
    return output.toString();
  }

}
