package problem1;

/**
 * This class will implement the actual service as a public method that takes a theater as its
 * argument, as well as an Integer array to see which rows are wheelchair accessible.
 */
public class ReservationSystem {

  private static final String THEATER_NAME = "Tsai's Theater";
  private static final Integer NUMBER_OF_ROWS = 5;
  private static final Integer NUMBER_OF_SEATS_IN_ROW = 7;
  private static final Integer[] ROWS_WITH_WHEELCHAIR_ACCESSIBILITY = {1, 3, 5};

  /**
   * The controller, calls other Service function.
   */
  public static void start() {
    Theater theater = new Theater(THEATER_NAME,
        NUMBER_OF_ROWS, NUMBER_OF_SEATS_IN_ROW, ROWS_WITH_WHEELCHAIR_ACCESSIBILITY);
    ReservationService reservationService = new ReservationService();
    reservationService.create(theater);
  }
}
