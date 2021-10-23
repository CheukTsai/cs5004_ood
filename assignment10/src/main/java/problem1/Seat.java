package problem1;

/**
 * Represents a Seat class
 */
public class Seat {

  private String name;
  private String reservedFor;

  /**
   * Constructs a Seat class
   *
   * @param builder builder for Seat
   */
  public Seat(Builder builder) {
    this.name = builder.name;
    this.reservedFor = builder.reservedFor;
  }

  /**
   * Builder for seat
   */
  public static class Builder {

    private String name;
    private String reservedFor = "No one";

    /**
     * Constructs a builder
     *
     * @param name the name of the Seat
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Changes who the seat is reserved for
     *
     * @param reservedFor the name of the user
     */
    public void setReservedFor(String reservedFor) {
      this.reservedFor = reservedFor;
    }

    /**
     * Constructs a Seat with Builder
     *
     * @return a Seat
     */
    public Seat build() {
      return new Seat(this);
    }
  }

  /**
   * Returns who the seat is reserved for
   *
   * @return who the seat is reserved for
   */
  public String getReservedFor() {
    return reservedFor;
  }

  /**
   * Returns the name of the seat
   *
   * @return the name of the seat
   */
  public String getName() {
    return name;
  }
}
