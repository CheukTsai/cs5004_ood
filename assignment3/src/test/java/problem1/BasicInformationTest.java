package problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class BasicInformationTest {

  private String expectedAddress;
  private PropertySize expectedPropertySize;
  private Boolean expectedMonthlySubscription;
  private Integer expectedNumberOfPreviousService;
  private BasicInformation testBasicInformation;
  private BasicInformation testBasicInformation2;

  @Before
  public void setUp() throws Exception {
    expectedAddress = "abc road";
    expectedPropertySize = PropertySize.LARGE;
    expectedMonthlySubscription = false;
    expectedNumberOfPreviousService = 9;
    testBasicInformation = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
  }

  @Test
  public void getPropertySize() {
    assertEquals(expectedPropertySize,testBasicInformation.getPropertySize());
  }

  @Test
  public void getMonthlySubscription() {
    assertEquals(expectedMonthlySubscription, testBasicInformation.getMonthlySubscription());
  }

  @Test
  public void getNumberOfPreviousService() {
    assertEquals(expectedNumberOfPreviousService,
        testBasicInformation.getNumberOfPreviousService());
  }

  @Test
  public void setNumberOfPreviousService() {
    Integer expectedNumberOfPreviousService2 = 2;
    testBasicInformation.setNumberOfPreviousService(
        expectedNumberOfPreviousService2);
    assertEquals(expectedNumberOfPreviousService2,
        testBasicInformation.getNumberOfPreviousService());
  }

  @Test
  public void equalsReflexivity() {
    assertTrue(testBasicInformation.equals(testBasicInformation));
  }

  @Test
  public void equalsReflexivity2() {
    testBasicInformation2 = new BasicInformation("a",PropertySize.SMALL,
        true,0);
    assertFalse(testBasicInformation.equals(testBasicInformation2));
  }

  @Test
  public void equalsReflexivity3() {
    assertNotEquals(testBasicInformation,null);
  }

  @Test
  public void equalsDifferentDataTypes(){
    assertFalse(testBasicInformation.equals(expectedAddress));
  }

  @Test
  public void equalsSameFields() {
    testBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription, expectedNumberOfPreviousService);
    assertTrue(testBasicInformation.equals(testBasicInformation2));
  }

  @Test
  public void differentArgument(){
    testBasicInformation2 = new BasicInformation("a",expectedPropertySize,
        expectedMonthlySubscription, expectedNumberOfPreviousService);
    assertFalse(testBasicInformation.equals(testBasicInformation2));
  }

  @Test
  public void differentArgument2(){
    testBasicInformation2 = new BasicInformation(expectedAddress,PropertySize.SMALL,
        expectedMonthlySubscription, expectedNumberOfPreviousService);
    assertFalse(testBasicInformation.equals(testBasicInformation2));
  }

  @Test
  public void differentArgument3(){
    testBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize,
        true, expectedNumberOfPreviousService);
    assertFalse(testBasicInformation.equals(testBasicInformation2));
  }

  @Test
  public void differentArgument4(){
    testBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription, 0);
    assertFalse(testBasicInformation.equals(testBasicInformation2));
  }
  @Test
  public void testHashCode() {
    int hash = Objects.hash(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    assertEquals(hash, testBasicInformation.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString =  "BasicInformation{" +
        "address='" + expectedAddress + '\'' +
        ", propertySize=" + expectedPropertySize +
        ", monthlySubscription=" + expectedMonthlySubscription +
        ", numberOfPreviousService=" + expectedNumberOfPreviousService +
        '}';
    assertEquals(expectedString, testBasicInformation.toString());
  }
}