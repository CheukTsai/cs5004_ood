package problem2;

/*** Time is an object that has a unique
 * hour, minute and second. */
public class Time {
  public static final Integer BASE_24 = 24;
  public static final Integer SEXAGESIMAL = 60;
  private Integer hour;
  private Integer minute;
  private Integer second;

  /**
   * Constructor that creates a new Time object with the specified hour, minute and second.
   *
   * @param hour - hour of the new Time object.
   * @param minute - minute of the new Time.
   * @param second - second of the new Time.
   */
  public Time(Integer hour, Integer minute, Integer second) {
    if (hour < 0 || hour >= BASE_24) {
      System.out.println("Input hour is invalid.");
    } else {
      this.hour = hour;
    }

    if (minute < 0 || minute >= SEXAGESIMAL) {
      System.out.println("Input minute is invalid.");
    } else {
      this.minute = minute;
    }

    if (second < 0 || second >= SEXAGESIMAL) {
      System.out.println("Input second is invalid.");
    } else {
      this.second = second;
    }
  }

  /**
   * Returns the hour of the Time.
   *
   * @return the hour of the Time.
   */
  public Integer getHour() {
    return this.hour;
  }

  /**
   * Returns the minute of the Time.
   *
   * @return the minute of the Time.
   */
  public Integer getMinute() {
    return this.minute;
  }

  /**
   * Returns the second of the Time.
   *
   * @return the second of the Time.
   */
  public Integer getSecond() {
    return this.second;
  }
}
