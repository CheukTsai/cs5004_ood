package problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint.Single;
import org.junit.Before;
import org.junit.Test;
import problem2.Mail;

public class SingleRoomTest {
  private Integer expectedMaximumOccupancy;
  private Integer expectedPrice;
  private Integer expectedCurrentGuests = 0;
  private SingleRoom testSingleRoom;
  private SingleRoom testSingleRoom2;

  @Before
  public void setUp() throws Exception {
    expectedMaximumOccupancy = 1;
    expectedPrice = 100;
    expectedCurrentGuests = 0;
    testSingleRoom = new SingleRoom(expectedPrice);
  }

  @Test
  public void testMaximumOccupancy() {
    assertEquals(expectedMaximumOccupancy,testSingleRoom.maximumOccupancy);
  }

  @Test
  public void testGetMaximumOccupancy(){
    assertEquals(expectedMaximumOccupancy, testSingleRoom.getMaximumOccupancy());
  }

  @Test
  public void getPrice() {
    assertEquals(expectedPrice, testSingleRoom.getPrice());
  }

  @Test
  public void getCurrentGuests() {
    assertEquals(expectedCurrentGuests, testSingleRoom.getCurrentGuests());
  }

  @Test
  public void testIsAvailable() {
    assertTrue(testSingleRoom.isAvailable());
    testSingleRoom.bookRoom(1);
    assertFalse(testSingleRoom.isAvailable());
  }

  @Test
  public void bookRoomSuccess() {
    Integer bookingGuest = 1;
    testSingleRoom.bookRoom(bookingGuest);
  }

  @Test(expected = IllegalArgumentException.class)
  public void roomUnavailable() {
    Integer bookingGuest = 1;
    testSingleRoom.bookRoom(bookingGuest);
    Integer bookingGuest2 = 1;
    testSingleRoom.bookRoom(bookingGuest2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooManyBookingGuests() {
    Integer bookingGuest = 2;
    testSingleRoom.bookRoom(bookingGuest);
  }


  @Test
  public void equalsReflexivity(){
    assertTrue(testSingleRoom.equals(testSingleRoom));
  }

  @Test
  public void equalsReflexivity2(){
    testSingleRoom2 = new SingleRoom(200);
    assertFalse(testSingleRoom.equals(testSingleRoom2));
  }

  @Test
  public void equalsReflexivity3(){
    assertFalse(testSingleRoom.equals(null));
  }

  @Test
  public void equalsDifferentDataTypes(){
    assertFalse(testSingleRoom.equals(expectedPrice));
  }

  @Test
  public void equalsSameFields(){
    testSingleRoom2 = new SingleRoom(expectedPrice);
    assertTrue(testSingleRoom.equals(testSingleRoom2));
  }

  @Test
  public void equalsNotSameMaximumOccupancy(){
    testSingleRoom2 = new SingleRoom(expectedPrice);
    testSingleRoom.maximumOccupancy = 2;
    assertFalse(testSingleRoom.equals(testSingleRoom2));
  }

  @Test
  public void equalsNotSameCurrentGuests(){
    testSingleRoom2 = new SingleRoom(expectedPrice);
    testSingleRoom2.currentGuests = 1;
    assertFalse(testSingleRoom.equals(testSingleRoom2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(testSingleRoom.getMaximumOccupancy(),
        testSingleRoom.getPrice(), testSingleRoom.getCurrentGuests());
    assertEquals(hash,testSingleRoom.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "AbstractRoom{" +
        "maximumOccupancy=" + expectedMaximumOccupancy +
        ", price=" + expectedPrice +
        ", currentGuests=" + expectedCurrentGuests +
        '}';
    assertEquals(expectedString, testSingleRoom.toString());
  }
}