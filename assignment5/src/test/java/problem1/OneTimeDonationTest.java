package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class OneTimeDonationTest {

  private LocalDateTime expectedDonationTime;
  private Float expectedAmount;
  private OneTimeDonation testOneTimeDonation;
  private OneTimeDonation testOneTimeDonation2;

  @Before
  public void setUp() throws Exception {
    expectedDonationTime = LocalDateTime.of(1,1,1,1,1,1);
    expectedAmount = 1000f;
    testOneTimeDonation = new OneTimeDonation(expectedDonationTime, expectedAmount);
  }

  @Test
  public void countYearlyAmount() {
    assertEquals(0f,testOneTimeDonation.countYearlyAmount(2021),0);
    assertEquals(1000f,testOneTimeDonation.countYearlyAmount(1),0);
  }

  @Test
  public void testEquals() {
    assertTrue(testOneTimeDonation.equals(testOneTimeDonation));
    assertFalse(testOneTimeDonation.equals(null));
    assertFalse(testOneTimeDonation.equals(expectedDonationTime));
  }

  @Test
  public void testEquals2() {
    testOneTimeDonation2 = new OneTimeDonation(expectedDonationTime, expectedAmount);
    assertTrue(testOneTimeDonation.equals(testOneTimeDonation2));

    expectedAmount = 1000f;
    expectedDonationTime = LocalDateTime.of(1,1,1,1,1,2);
    testOneTimeDonation2 = new OneTimeDonation(expectedDonationTime, expectedAmount);
    assertFalse(testOneTimeDonation.equals(testOneTimeDonation2));

    expectedAmount = 1001f;
    expectedDonationTime = LocalDateTime.of(1,1,1,1,1,1);
    testOneTimeDonation2 = new OneTimeDonation(expectedDonationTime, expectedAmount);
    assertFalse(testOneTimeDonation.equals(testOneTimeDonation2));

    expectedAmount = 1001f;
    expectedDonationTime = LocalDateTime.of(1,1,1,1,1,2);
    testOneTimeDonation2 = new OneTimeDonation(expectedDonationTime, expectedAmount);
    assertFalse(testOneTimeDonation.equals(testOneTimeDonation2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(expectedDonationTime, expectedAmount);
    assertEquals(hash, testOneTimeDonation.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "OneTimeDonation{" +
        "donationTime=" + expectedDonationTime +
        ", amount=" + expectedAmount +
        '}';
    assertEquals(expectedString, testOneTimeDonation.toString());
  }
}