package problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Theater class
 */
public class Theater {

  private String name;
  public List<Row> rows;
  private Integer numberOfRows;
  private Integer numberOfSeatsInRow;

  /**
   * Constructs a Theater
   *
   * @param name                     name of theater
   * @param numberOfRows             number of rows in theater
   * @param numberOfSeatsInRow       number of seats in a row
   * @param wheelchairAccessibleRows which rows are wheelchair accessible
   */
  public Theater(String name, Integer numberOfRows, Integer numberOfSeatsInRow,
      Integer[] wheelchairAccessibleRows) {
    if (wheelchairAccessibleRows.length < 1) {
      throw new IllegalArgumentException(
          "Can't create a Theater without at least one accessible row.");
    }
    this.name = name;
    this.numberOfRows = numberOfRows;
    this.numberOfSeatsInRow = numberOfSeatsInRow;
    this.rows = new ArrayList<>();
    for (int i = 1; i <= numberOfRows; i++) {
      boolean ifWheelchairAccessible = false;
      for (Integer wheelchairAccessibleRow : wheelchairAccessibleRows) {
        if (wheelchairAccessibleRow.equals(i)) {
          ifWheelchairAccessible = true;
          break;
        }
      }
      Row row = new Row(i, ifWheelchairAccessible);
      row.initialize(numberOfSeatsInRow);
      rows.add(row);
    }
  }

  /**
   * Returns the name of the theater
   *
   * @return the name of the theater
   */
  public String getName() {
    return name;
  }

  /**
   * Find valid rows for a customer to reserve
   *
   * @param numberToReserve             number of seats to reserve
   * @param needWheelchairAccessibility if the customer needs wheelchair accessibility
   * @return the row for them to reserve, if no valid row, -1 will be returned;
   */
  public Integer findValidRow(Integer numberToReserve, Boolean needWheelchairAccessibility) {
    if (numberToReserve > numberOfSeatsInRow) {
      return -1;
    }
    int bestRow = -1;
    int potentialRow = -1;
    int midRow = rows.size() / 2;
    for (int i = 0; i < rows.size(); i++) {
      Row row = rows.get(i);
      if (needWheelchairAccessibility && !row.getIfWheelchairAccessible()) {
        continue;
      }
      int emptySeats = 0;
      for (Seat seat : row) {
        if (seat.getReservedFor().equals("No one")) {
          emptySeats++;
        }
      }
      if (emptySeats >= numberToReserve) {
        bestRow = Math.abs(midRow - bestRow) < Math.abs(midRow - i) ? bestRow : i;
        if (!needWheelchairAccessibility && !row.getIfWheelchairAccessible()) {
          potentialRow = Math.abs(midRow - potentialRow) < Math.abs(midRow - i) ? potentialRow : i;
        }
      }
    }
    if (potentialRow != -1) {
      bestRow = potentialRow;
    }
    return bestRow;
  }

  /**
   * Overrides toString to ensure Theater can be shown correctly
   *
   * @return expected shown graph
   */
  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    for (Row row : rows) {
      output.append(row.toString());
      output.append("\n");
    }
    return output.toString();
  }
}
