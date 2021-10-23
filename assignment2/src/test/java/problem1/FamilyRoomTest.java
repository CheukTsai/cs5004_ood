package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FamilyRoomTest {

  private Integer expectedPrice;
  private FamilyRoom testFamilyRoom;

  @Before
  public void setUp() throws Exception {
    expectedPrice = 100;
    testFamilyRoom = new FamilyRoom(expectedPrice);
  }

  @Test
  public void testMaximumOccupancy() {
    Integer expectedMaximumOccupancy = 4;
    assertEquals(expectedMaximumOccupancy,testFamilyRoom.maximumOccupancy);
  }
}