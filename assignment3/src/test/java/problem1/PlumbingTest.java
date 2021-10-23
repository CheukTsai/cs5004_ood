package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlumbingTest {

  private String expectedAddress;
  private PropertySize expectedPropertySize;
  private PropertySize expectedPropertySize2;
  private PropertySize expectedPropertySize3;
  private Boolean expectedMonthlySubscription;
  private Integer expectedNumberOfPreviousService;
  private BasicInformation expectedBasicInformation;
  private BasicInformation expectedBasicInformation2;
  private Boolean expectedIfComplex;
  private Boolean expectedIfComplex2;
  private Integer expectedNumberOfLicensedEmployees;
  private Integer expectedNumberOfLicensedEmployees2;
  private Plumbing testPlumbing;
  private Plumbing testPlumbing2;

  @Before
  public void setUp() throws Exception {
    expectedAddress = "abc road";
    expectedPropertySize = PropertySize.SMALL;
    expectedMonthlySubscription = false;
    expectedNumberOfPreviousService = 0;
    expectedNumberOfLicensedEmployees = 1;
    expectedBasicInformation = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    expectedIfComplex = false;
    testPlumbing = new Plumbing(expectedBasicInformation, expectedIfComplex,
        expectedNumberOfLicensedEmployees);
  }

  @Test
  public void calculatePrice() {
    assertEquals(220.0, testPlumbing.calculatePrice(),0);
  }

  @Test
  public void calculatePrice2() {
    expectedIfComplex2 = true;
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testPlumbing2 = new Plumbing(expectedBasicInformation2,expectedIfComplex2,
        expectedNumberOfLicensedEmployees);
    assertEquals(420.0, testPlumbing2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice3() {
    expectedIfComplex2 = true;
    expectedPropertySize2 = PropertySize.MEDIUM;
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize2,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testPlumbing2 = new Plumbing(expectedBasicInformation2,expectedIfComplex2,
        expectedNumberOfLicensedEmployees);
    assertEquals(420.0, testPlumbing2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice4() {
    expectedIfComplex2 = true;
    expectedPropertySize2 = PropertySize.LARGE;
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize2,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testPlumbing2 = new Plumbing(expectedBasicInformation2,expectedIfComplex2,
        expectedNumberOfLicensedEmployees);
    assertEquals(620.0, testPlumbing2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice5() {
    expectedIfComplex2 = true;
    expectedNumberOfLicensedEmployees2 = 3;
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testPlumbing2 = new Plumbing(expectedBasicInformation2,expectedIfComplex2,
        expectedNumberOfLicensedEmployees2);
    assertEquals(620.0, testPlumbing2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice6() {
    expectedIfComplex2 = true;
    expectedPropertySize2 = PropertySize.LARGE;
    expectedNumberOfLicensedEmployees2 = 3;
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize2,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testPlumbing2 = new Plumbing(expectedBasicInformation2,expectedIfComplex2,
        expectedNumberOfLicensedEmployees2);
    assertEquals(620.0, testPlumbing2.calculatePrice(),0);
  }

  @Test
  public void testHashCode() {
    assertEquals(testPlumbing.hashCode(), testPlumbing.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(testPlumbing.equals(testPlumbing));
  }

  @Test
  public void testToString() {
    assertEquals(testPlumbing.toString(),testPlumbing.toString());
  }
}