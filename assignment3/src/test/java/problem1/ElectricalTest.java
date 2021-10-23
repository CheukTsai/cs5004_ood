package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElectricalTest {
  private String expectedAddress;
  private PropertySize expectedPropertySize;
  private Boolean expectedMonthlySubscription;
  private Integer expectedNumberOfPreviousService;
  private BasicInformation expectedBasicInformation;
  private Boolean expectedIfComplex;
  private Integer expectedNumberOfLicensedEmployees;
  private Integer expectedNumberOfLicensedEmployees2;
  private Electrical testElectrical;
  private Electrical testElectrical2;

  @Before
  public void setUp() throws Exception {
    expectedAddress = "abc road";
    expectedPropertySize = PropertySize.SMALL;
    expectedMonthlySubscription = false;
    expectedNumberOfPreviousService = 0;
    expectedBasicInformation = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    expectedIfComplex = true;
    expectedNumberOfLicensedEmployees = 3;
    testElectrical = new Electrical(expectedBasicInformation,expectedIfComplex,
        expectedNumberOfLicensedEmployees);
  }

  @Test
  public void calculatePrice() {
    assertEquals(650.0,testElectrical.calculatePrice(),0);
  }

  @Test(expected = OutNumberedLicensedEmployeeException.class)
  public void testOverEmployee() throws OutNumberedLicensedEmployeeException{
    expectedNumberOfLicensedEmployees2 = 5;
    testElectrical2 = new Electrical(expectedBasicInformation, expectedIfComplex,
        expectedNumberOfLicensedEmployees2);
  }

  @Test
  public void testHashCode() {
    assertEquals(testElectrical.toString(),testElectrical.toString());
  }

  @Test
  public void testEquals() {
    assertTrue(testElectrical.equals(testElectrical));
  }

  @Test
  public void testToString() {
    assertEquals(testElectrical.toString(), testElectrical.toString());
  }
}