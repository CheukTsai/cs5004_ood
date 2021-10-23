package prob1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class AgentTest {

  private String name;
  private ArrayList<Listing<? extends Property, ? extends Contract>> currentListings;
  private Double commissionRate;
  private Double totalEarnings;

  private Residential residential;
  private Sale sale;
  private Listing<Residential, ? extends Contract> testListing;

  private String name2;
  private Double commissionRate2;
  private Double commissionRate3;
  private Double commissionRate4;
  private Double totalEarnings2;

  private Residential residential2;
  private Sale sale2;

  private Listing<Residential, ? extends Contract> testListingResidentialOnly;


  private Agent<Listing<Residential, ? extends Contract>> testAgentResidentialOnly;
  private Agent<Listing<? extends Property, ? extends Contract>> testAgentAllAccepted2;


  @Before
  public void setUp() throws Exception {
    currentListings = new ArrayList<>();
    name = "A";
    name2 = "B";
    commissionRate = 0.5;
    commissionRate2 = 2.5;
    commissionRate3 = -1.5;
    commissionRate4 = 0.3;

    totalEarnings = 10.5;
    totalEarnings2 = 15.5;
    sale = new Sale(20.0, true);
    residential = new Residential("A", 10, 2, 1.5);

    sale2 = new Sale(21.0, true);
    residential2 = new Residential("B", 10, 2, 1.5);

    sale2 = new Sale(21.0, false);
    residential2 = new Residential("B", 10, 3, 1.5);

    testListing = new Listing<>(residential, sale);
    testListingResidentialOnly =
        new Listing<>(residential2, sale2);

    testAgentResidentialOnly = new Agent<>(name, commissionRate, totalEarnings);

  }

  @Test
  public void addListing() {
    testAgentResidentialOnly.addListing(testListing);
    testAgentResidentialOnly.addListing(testListingResidentialOnly);
    assertTrue(testAgentResidentialOnly.getCurrentListings().contains(testListing));
    assertTrue(testAgentResidentialOnly.getCurrentListings().contains(testListingResidentialOnly));
  }


  @Test(expected = IllegalArgumentException.class)
  public void checkCommissionRate() throws IllegalArgumentException {
    testAgentAllAccepted2 = new Agent<>(name, commissionRate2, totalEarnings);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkCommissionRate2() throws IllegalArgumentException {
    testAgentResidentialOnly = new Agent<>(name, commissionRate3, totalEarnings);
  }


  @Test(expected = ListingNotFoundException.class)
  public void completeListing() throws ListingNotFoundException {
    testAgentResidentialOnly.addListing(testListing);
    testAgentResidentialOnly.completeListing(testListingResidentialOnly);

  }

  @Test
  public void completeListing2() throws ListingNotFoundException {
    testAgentResidentialOnly.addListing(testListing);
    testAgentResidentialOnly.completeListing(testListing);
    assertFalse(currentListings.contains(testListing));
  }


  @Test(expected = ListingNotFoundException.class)
  public void dropListing() throws ListingNotFoundException {
    testAgentResidentialOnly.addListing(testListing);
    testAgentResidentialOnly.dropListing(testListingResidentialOnly);
    testAgentResidentialOnly.dropListing(testListing);
  }

  @Test
  public void dropListing2() {
    testAgentResidentialOnly.addListing(testListing);
    try {
      testAgentResidentialOnly.dropListing(testListing);
    } catch (ListingNotFoundException e) {
      e.printStackTrace();
    }
  }


  @Test
  public void getTotalPortfolioValue() {
    Double output = commissionRate * testListing.getContract().askingPrice
        * testListing.getContract().getCommissionFactor();
    ;
    testAgentResidentialOnly.addListing(testListing);
    assertEquals(testAgentResidentialOnly.getTotalPortfolioValue(), output);
  }


  @Test
  public void testEquals() throws ListingNotFoundException {
    testAgentResidentialOnly.addListing(testListing);
    testAgentResidentialOnly.addListing(testListingResidentialOnly);
    testAgentResidentialOnly.completeListing(testListing);

    assertTrue(testAgentResidentialOnly.equals(testAgentResidentialOnly));
    assertFalse(testAgentResidentialOnly.equals(name));
    assertNotEquals(testAgentResidentialOnly, null);
    testAgentAllAccepted2 = new Agent(name, commissionRate, totalEarnings);
    testAgentAllAccepted2.addListing(testListing);
    assertFalse(testAgentResidentialOnly.equals(testAgentAllAccepted2));

    testAgentAllAccepted2.addListing(testListingResidentialOnly);
    testAgentAllAccepted2.completeListing(testListing);

    assertTrue(testAgentResidentialOnly.equals(testAgentAllAccepted2));

    testAgentResidentialOnly = new Agent(name, commissionRate, totalEarnings);
    testAgentAllAccepted2 = new Agent(name, commissionRate4, totalEarnings);
    assertFalse(testAgentResidentialOnly.equals(testAgentAllAccepted2));
    testAgentAllAccepted2 = new Agent(name, commissionRate, totalEarnings2);
    assertFalse(testAgentResidentialOnly.equals(testAgentAllAccepted2));
    testAgentAllAccepted2 = new Agent(name2, commissionRate, totalEarnings);
    assertFalse(testAgentResidentialOnly.equals(testAgentAllAccepted2));

  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(name, currentListings, commissionRate, totalEarnings);
    assertEquals(testAgentResidentialOnly.hashCode(), hash);
  }

  @Test
  public void testToString() {

    String expectedString = "Agent{" +
        "name='" + name + '\'' +
        ", currentListings=" + currentListings +
        ", commissionRate=" + commissionRate +
        ", totalEarnings=" + totalEarnings +
        '}';

    assertEquals(testAgentResidentialOnly.toString(), expectedString);
  }
}