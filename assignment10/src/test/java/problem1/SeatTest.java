package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Seat.Builder;

public class SeatTest {

  private String name;
  private String reservedFor;
  private Builder builder;
  private Seat seat;

  @Before
  public void setUp() throws Exception {
    name = "A";
    reservedFor = "Tsai";
    builder = new Builder(name);
    builder.setReservedFor(reservedFor);
    seat = builder.build();
  }

  @Test
  public void getReservedFor() {
    assertEquals(reservedFor, seat.getReservedFor());
  }

  @Test
  public void getName() {
    assertEquals(name, seat.getName());
  }
}