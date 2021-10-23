package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class NonProfitTest {

  private LocalDateTime expectedDonationTime;
  private Float expectedAmount;
  private OneTimeDonation testOneTimeDonation;
  private OneTimeDonation testOneTimeDonation2;

  private LocalDateTime creationTime;
  private Float amount;
  private LocalDateTime processTime;
  private Pledge testPledge1;
  private Pledge testPledge2;

  private String expectedOrganization;
  private String expectedOrganization2;

  private NonProfit testNonProfit;
  private NonProfit testNonProfit2;
  private Set<Donation> expectedSet;


  @Before
  public void setUp() throws Exception {
    expectedDonationTime = LocalDateTime.of(1,1,1,1,1,1);
    expectedAmount = 1000f;
    testOneTimeDonation = new OneTimeDonation(expectedDonationTime, expectedAmount);

    expectedDonationTime = LocalDateTime.of(1,1,1,1,1,2);
    expectedAmount = 1001f;
    testOneTimeDonation2 = new OneTimeDonation(expectedDonationTime, expectedAmount);

    creationTime = LocalDateTime.of(1,1,1,1,1,1);
    processTime = LocalDateTime.of(1,2,2,2,2,2);
    amount = 1000f;
    testPledge1 = new Pledge(creationTime,amount);
    testPledge2 = new Pledge(creationTime, amount, processTime);

    expectedOrganization = "PandaProtectionOrg";
    testNonProfit = new NonProfit(expectedOrganization);


    expectedSet = new HashSet<>();
  }

  @Test
  public void testGetDonationCollection() {
    assertEquals(expectedSet, testNonProfit.getDonationCollection());
  }

  @Test
  public void donate() {
    testNonProfit.donate(testOneTimeDonation);
    expectedSet.add(testOneTimeDonation);
    assertEquals(expectedSet, testNonProfit.getDonationCollection());
  }

  @Test
  public void getTotalDonationsForYear() {
    testNonProfit.donate(testOneTimeDonation);
    testNonProfit.donate(testPledge1);
    testNonProfit.donate(testPledge2);

    assertEquals(2000f, testNonProfit.getTotalDonationsForYear(1),0);

  }

  @Test
  public void getDonationCollection() {
    testNonProfit.donate(testOneTimeDonation);
    expectedSet.add(testOneTimeDonation);
    assertEquals(expectedSet, testNonProfit.getDonationCollection());
  }

  @Test
  public void testEquals() {
    assertTrue(testNonProfit.equals(testNonProfit));
    assertFalse(testNonProfit.equals(expectedOrganization));
    assertFalse(testNonProfit.equals(null));
  }


  @Test
  public void testEquals2() {
    expectedOrganization2 = "abc";
    testNonProfit2 = new NonProfit(expectedOrganization2);
    assertFalse(testNonProfit.equals(testNonProfit2));

    testNonProfit2 = new NonProfit(expectedOrganization);
    testNonProfit2.donate(testOneTimeDonation2);
    testNonProfit.donate(testOneTimeDonation);
    assertFalse(testNonProfit.equals(testNonProfit2));

    testNonProfit2 = new NonProfit(expectedOrganization);
    testNonProfit2.donate(testOneTimeDonation);
    assertTrue(testNonProfit.equals(testNonProfit2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(expectedOrganization, expectedSet);
    assertEquals(hash, testNonProfit.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "NonProfit{" +
        "organization='" + expectedOrganization + '\'' +
        ", donationCollection=" + expectedSet +
        '}';

    assertEquals(expectedString, testNonProfit.toString());
  }


}