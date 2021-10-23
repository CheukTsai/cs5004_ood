package problem1;

import problem1.Seat.Builder;

public class ReservationService implements Service {

  /**
   * Creates a service, with theater input, user get response when certain input met
   *
   * @param theater Theater
   */
  public void create(Theater theater) {
    String lookup = "";
    System.out.println("Welcome to " + theater.getName());
    while (true) {
      lookup = View.getInput("What would you like to do? ");
      if (lookup.equals("done")) {
        done();
      }
      if (lookup.equals("show")) {
        show(theater);
        continue;
      }
      String[] input = lookup.split(" ");
      if (input[0].equals("reserve")) {
        if (input.length == 2) {
          String name = View.getInput("What's your name?");
          String needWheelchairAccessibility =
              View.getInput("Do you need wheelchair accessible seats?");
          Boolean necessity = false;
          if (needWheelchairAccessibility.equals("yes")) {
            necessity = true;
          }
          reserve(theater, Integer.parseInt(input[1]), name, necessity);
        }
        continue;
      }
      System.out.println("You Type in Something wrong, please try again.");
    }
  }

  /**
   * Shows the available seats of a Theater
   *
   * @param theater Theater
   */
  @Override
  public void show(Theater theater) {
    System.out.println(theater);
  }

  /**
   * Exits the system
   */
  @Override
  public void done() {
    System.out.println("Have a nice day");
    System.exit(0);
  }

  /**
   * Reserves seats
   *
   * @param theater                     Theater
   * @param number                      number of audience to reserve seats
   * @param name                        name of the user
   * @param needWheelchairAccessibility if the customer needs wheelchair accessibility
   */
  @Override
  public void reserve(Theater theater, Integer number, String name,
      Boolean needWheelchairAccessibility) {
    Integer targetRowNum = theater.findValidRow(number, needWheelchairAccessibility);
    if (targetRowNum.equals(-1)) {
      System.out.println("Sorry, we don’t have that many seats together for you.");
      return;
    }
    Row row = theater.rows.get(targetRowNum);
    Integer seatToReserveNum = number;
    for (int i = 0; i < row.size(); i++) {
      if (row.get(i).getReservedFor().equals("No one")) {
        seatToReserveNum--;
        Builder builder = new Builder(row.get(i).getName());
        builder.setReservedFor(name);
        Seat reservedSeat = builder.build();
        row.set(i, reservedSeat);
        if (seatToReserveNum.equals(0)) {
          break;
        }
      }
    }
    theater.rows.set(targetRowNum, row);
    System.out.println("I’ve reserved " + number + " seats for you at " + theater.getName() +
        " in row " + (targetRowNum + 1) + ", " + name + ".");
  }
}

