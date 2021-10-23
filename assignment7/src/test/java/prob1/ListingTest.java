package prob1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class ListingTest {

  private Residential residential;
  private Sale sale;
  private Residential residential2;
  private Sale sale2;

  private Commercial commercial;
  private Rental rental;
  private Commercial commercial2;
  private Rental rental2;

  private Integer term;
  protected Double askingPrice;
  protected Boolean isNegotiable;

  private Integer term2;
  protected Double askingPrice2;
  protected Boolean isNegotiable2;

  private Integer numOfOffices;
  private Integer numOfOffices2;

  private Commercial testCommercial;
  private Commercial testCommercial2;
  private Residential testResidential;

  private Boolean isRetail;
  private String address;
  private Integer size;

  private Listing<Property, Contract> testListingPropertyContract;
  private Listing<Property, Contract> testListingPropertyContract2;
  private Listing<Residential, Contract> testListingResidentialContract;
  private Listing<Property, Sale> testListingPropertySale;


  @Before
  public void setUp() throws Exception {
    sale = new Sale(20.0, true);
    residential = new Residential("A", 10, 2, 1.5);

    sale2 = new Sale(21.0, true);
    residential2 = new Residential("B", 10, 2, 1.5);

    askingPrice = 10.0;
    askingPrice2 = 5.0;
    isNegotiable = true;
    term = 5;
    term2 = -1;

    rental = new Rental(askingPrice, isNegotiable, term);

    numOfOffices = 2;
    numOfOffices2 = -1;
    isRetail = true;
    address = "A";
    size = 10;
    commercial = new Commercial(address, size, numOfOffices, isRetail);

    testListingPropertyContract = new Listing<>(residential, sale);
    testListingPropertyContract2 = new Listing<>(commercial, rental);
    testListingResidentialContract = new Listing<>(residential, sale);


  }

  @Test
  public void getContract() {
    assertEquals(testListingPropertyContract.getContract(), sale);
  }

  @Test
  public void testEquals() {
    assertTrue(testListingPropertyContract.equals(testListingPropertyContract));
    assertFalse(testListingPropertyContract.equals(residential));
    assertNotEquals(testListingPropertyContract, null);
    testListingPropertyContract2 = new Listing<>(residential, sale);
    assertTrue(testListingPropertyContract.equals(testListingPropertyContract2));

    testListingPropertyContract2 = new Listing<>(residential2, sale);
    assertFalse(testListingPropertyContract.equals(testListingPropertyContract2));

    testListingPropertyContract2 = new Listing<>(residential, sale2);
    assertFalse(testListingPropertyContract.equals(testListingPropertyContract2));

  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(residential, sale);
    assertEquals(testListingPropertyContract.hashCode(), hash);
  }

  @Test
  public void testToString() {
    String expectedString = "Listing{" +
        "property=" + residential +
        ", contract=" + sale +
        '}';

    assertEquals(testListingPropertyContract.toString(), expectedString);

  }
}