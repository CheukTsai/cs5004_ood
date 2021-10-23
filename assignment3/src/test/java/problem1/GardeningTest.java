package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GardeningTest {

  private String expectedAddress;
  private PropertySize expectedPropertySize;
  private PropertySize expectedPropertySize2;
  private PropertySize expectedPropertySize3;
  private Boolean expectedMonthlySubscription;
  private Boolean expectedMonthlySubscription2;
  private Integer expectedNumberOfPreviousService;
  private Integer expectedNumberOfPreviousService2;
  private BasicInformation expectedBasicInformation;
  private BasicInformation expectedBasicInformation2;
  private Gardening testGardening;
  private Gardening testGardening2;


  @Before
  public void setUp() throws Exception {
    expectedAddress = "abc road";
    expectedPropertySize = PropertySize.LARGE;
    expectedPropertySize2 = PropertySize.MEDIUM;
    expectedPropertySize3 = PropertySize.SMALL;
    expectedMonthlySubscription = false;
    expectedMonthlySubscription2 = true;
    expectedNumberOfPreviousService = 9;
    expectedNumberOfPreviousService2 = 0;
    expectedBasicInformation = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testGardening = new Gardening(expectedBasicInformation);
  }

  @Test
  public void calculatePrice() {
    assertEquals(170.0, testGardening.calculatePrice(),0);
  }

  @Test
  public void calculatePrice2() {
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize2,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testGardening2 = new Gardening(expectedBasicInformation2);
    assertEquals(90.0, testGardening2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice3() {
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize3,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testGardening2 = new Gardening(expectedBasicInformation2);
    assertEquals(50.0, testGardening2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice4() {
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription2,expectedNumberOfPreviousService);
    testGardening2 = new Gardening(expectedBasicInformation2);
    assertEquals(170.0, testGardening2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice5() {
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService2);
    testGardening2 = new Gardening(expectedBasicInformation2);
    assertEquals(340.0, testGardening2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice6() {
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription2,expectedNumberOfPreviousService2);
    testGardening2 = new Gardening(expectedBasicInformation2);
    assertEquals(306.0, testGardening2.calculatePrice(),0);
  }

  @Test
  public void testHashCode() {
    assertEquals(testGardening.hashCode(),testGardening.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(testGardening.equals(testGardening));
  }

  @Test
  public void testToString() {
    assertEquals(testGardening.toString(), testGardening.toString());
  }
}