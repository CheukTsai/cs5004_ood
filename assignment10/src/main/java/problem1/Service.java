package problem1;

/**
 * The interface of service, with 3 usable functions
 */
public interface Service {

  /**
   * Shows the available seats of a Theater
   *
   * @param theater Theater
   */
  void show(Theater theater);

  /**
   * Exits the system
   */
  void done();

  /**
   * Reserves seats
   *
   * @param theater                     Theater
   * @param number                      number of audience to reserve seats
   * @param name                        name of the user
   * @param needWheelchairAccessibility if the customer needs wheelchair accessibility
   */
  void reserve(Theater theater, Integer number, String name, Boolean needWheelchairAccessibility);
}
