package problem1;

/** The Room interface represents a "room" that can be booked when available */
public interface Room {
  boolean isAvailable();

  void bookRoom(Integer bookingGuests);
}
