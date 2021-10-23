package problem1;

import java.util.Objects;

/**
 * Represents an abstract class AbstractRoom, including the room's maximum occupancy, price and
 * current number of guests.
 *
 * @author - Zhuocai Li
 */
public abstract class AbstractRoom implements Room {
  protected Integer maximumOccupancy;
  protected Integer price;
  protected Integer currentGuests;

  /**
   * Constructs a new AbstractRoom
   *
   * @param maximumOccupancy - maximum occupancy of the room, expressed as an Integer
   * @param price - price of the room, expressed as an Integer default current number of guests is
   *     set to 0.
   */
  public AbstractRoom(Integer maximumOccupancy, Integer price) {
    this.maximumOccupancy = maximumOccupancy;
    this.price = price;
    this.currentGuests = 0;
  }

  /**
   * returns maximum occupancy of the room, expressed as an Integer
   *
   * @return Integer
   */
  public Integer getMaximumOccupancy() {
    return maximumOccupancy;
  }

  /**
   * returns maximum occupancy of the room, expressed as an Integer
   *
   * @return Integer
   */
  public Integer getPrice() {
    return price;
  }

  /**
   * returns current number of guests, expressed as an Integer
   *
   * @return Integer
   */
  public Integer getCurrentGuests() {
    return currentGuests;
  }

  /**
   * {@inheritDoc} returns whether the room is currently available, expressed as a boolean
   *
   * @return Boolean
   */
  @Override
  public boolean isAvailable() {
    return this.currentGuests == 0;
  }

  /**
   * {@inheritDoc} Books the room
   *
   * @exception IllegalArgumentException when number of guests is over the room capacity
   * @exception IllegalArgumentException when the room is not available
   * @param bookingGuests - number of guests booking the room
   */
  @Override
  public void bookRoom(Integer bookingGuests) {
    if (bookingGuests > this.maximumOccupancy) {
      throw new IllegalArgumentException("Number of guests is over the room capacity.");
    } else if (!this.isAvailable()) {
      throw new IllegalArgumentException("The room is not available");
    } else {
      this.currentGuests = bookingGuests;
    }
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return Boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractRoom that = (AbstractRoom) o;
    return Objects.equals(maximumOccupancy, that.maximumOccupancy)
        && Objects.equals(price, that.price)
        && Objects.equals(currentGuests, that.currentGuests);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return Integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(maximumOccupancy, price, currentGuests);
  }

  /**
   * {@inheritDoc} returns the value given to it in string format
   *
   * @return String
   */
  @Override
  public String toString() {
    return "AbstractRoom{"
        + "maximumOccupancy="
        + maximumOccupancy
        + ", price="
        + price
        + ", currentGuests="
        + currentGuests
        + '}';
  }
}
