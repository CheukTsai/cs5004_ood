package problem2;

/*** Time is an object that has a unique starting time,
 * end time, starting location and end location. */
public class Trip {
  public static final Integer SEXAGESIMAL = 60;
  private Time startingTime;
  private Time endTime;
  private String startingLocation;
  private String endLocation;

  /**
   * Constructor that creates a new Trip object with the specified hour, minute and second.
   *
   * @param startingTime - starting time of the new Trip object.
   * @param endTime - end time of the new Trip.
   * @param startingLocation - starting location of the new Trip.
   * @param endLocation - end location of the new Trip.
   */
  public Trip(Time startingTime, Time endTime, String startingLocation, String endLocation) {
    this.startingTime = startingTime;
    this.endTime = endTime;
    this.startingLocation = startingLocation;
    this.endLocation = endLocation;
  }

  /**
   * Returns the startingTime of the Trip.
   *
   * @return the startingTime of the Trip.
   */
  public Time getStartingTime() {
    return this.startingTime;
  }

  /**
   * Returns the endTime of the Trip.
   *
   * @return the endTime of the Trip.
   */
  public Time getEndTime() {
    return this.endTime;
  }

  /**
   * Returns the startingLocation of the Trip.
   *
   * @return the startingLocation of the Trip.
   */
  public String getStartingLocation() {
    return this.startingLocation;
  }

  /**
   * Returns the endLocation of the Trip.
   *
   * @return the endLocation of the Trip.
   */
  public String getEndLocation() {
    return this.endLocation;
  }

  /**
   * Returns the duration of the Trip.
   *
   * @return the duration of the Trip.
   */
  public Time getDuration() {
    Integer startingSecond = this.startingTime.getSecond();
    Integer startingMinute = this.startingTime.getMinute();
    Integer startingHour = this.startingTime.getHour();
    Integer endSecond = this.endTime.getSecond();
    Integer endMinute = this.endTime.getMinute();
    Integer endHour = this.endTime.getHour();

    if (endSecond < startingSecond) {
      endSecond += SEXAGESIMAL;
      endMinute -= 1;
    }

    if (endMinute < startingMinute) {
      endMinute += SEXAGESIMAL;
      endHour -= 1;
    }
    Integer second = endSecond - startingSecond;
    Integer minute = endMinute - startingMinute;
    Integer hour = endHour - startingHour;

    Time duration = new Time(hour, minute, second);
    return duration;
  }
}
