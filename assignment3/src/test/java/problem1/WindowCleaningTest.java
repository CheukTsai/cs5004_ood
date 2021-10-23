package problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class WindowCleaningTest {

  private String expectedAddress;
  private PropertySize expectedPropertySize;
  private Boolean expectedMonthlySubscription;
  private Integer expectedNumberOfPreviousService;
  private BasicInformation expectedBasicInformation;
  private BasicInformation expectedBasicInformation2;
  private Integer expectedNumberOfFloors;
  private Integer expectedNumberOfFloors2;
  private Integer expectedNumberOfFloors3;
  private WindowCleaning testWindowCleaning;
  private WindowCleaning testWindowCleaning2;


  @Before
  public void setUp() throws Exception {
    expectedAddress = "abc road";
    expectedPropertySize = PropertySize.SMALL;
    expectedMonthlySubscription = false;
    expectedNumberOfPreviousService = 0;
    expectedBasicInformation = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    expectedNumberOfFloors = 1;
    testWindowCleaning = new WindowCleaning(expectedBasicInformation, expectedNumberOfFloors);
  }

  @Test
  public void calculatePrice() {
    assertEquals(80.0,
        testWindowCleaning.calculatePrice(),0);
  }

  @Test(expected = OutNumberedFloorException.class)
  public void testOverFloor() throws OutNumberedFloorException{
    expectedNumberOfFloors2 = 5;
    testWindowCleaning2 = new WindowCleaning(expectedBasicInformation, expectedNumberOfFloors2);
  }

  @Test
  public void calculatePrice2() throws OutNumberedFloorException{
    expectedNumberOfFloors3 = 2;
    testWindowCleaning2 = new WindowCleaning(expectedBasicInformation, expectedNumberOfFloors3);
    assertEquals(84.0,testWindowCleaning2.calculatePrice(),0);
  }

  @Test
  public void equalsReflexivity(){
    assertTrue(testWindowCleaning.equals(testWindowCleaning));
  }

  @Test
  public void equalsReflexivity2() throws OutNumberedFloorException{
    expectedBasicInformation2 = new BasicInformation("a", PropertySize.MEDIUM,
        true,9);
    expectedNumberOfFloors2 = 1;
    testWindowCleaning2 = new WindowCleaning(expectedBasicInformation2, expectedNumberOfFloors2);
    assertTrue(testWindowCleaning.equals(testWindowCleaning2));
  }

  @Test
  public void equalsReflexivity3() throws OutNumberedFloorException{
    assertNotEquals(testWindowCleaning,null);
  }

  @Test
  public void equalsDifferentDataTypes() {
    assertFalse(testWindowCleaning.equals(expectedBasicInformation));
  }

  @Test
  public void equalsSameFields() throws OutNumberedFloorException{
    testWindowCleaning2 = new WindowCleaning(expectedBasicInformation, expectedNumberOfFloors);
    assertEquals(testWindowCleaning, testWindowCleaning2);
  }

  @Test
  public void hashcode(){
    int hash = Objects.hash(expectedNumberOfFloors);
    assertEquals(testWindowCleaning.hashCode(),hash);
  }

  @Test
  public void testToString(){
    String expectedString = "WindowCleaning{" +
        "numberOfFloors=" + expectedNumberOfFloors +
        '}';
    assertEquals(expectedString, testWindowCleaning.toString());
  }

}