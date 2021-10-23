package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoubleRoomTest {

  private Integer expectedPrice;
  private DoubleRoom testDoubleRoom;

  @Before
  public void setUp() throws Exception {
    expectedPrice = 100;
    testDoubleRoom = new DoubleRoom(expectedPrice);
  }

  @Test
  public void testMaximumOccupancy() {
    Integer expectedMaximumOccupancy = 2;
    assertEquals(expectedMaximumOccupancy,testDoubleRoom.maximumOccupancy);
  }
}