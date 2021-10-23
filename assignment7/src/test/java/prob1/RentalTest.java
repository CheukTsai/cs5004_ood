package prob1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class RentalTest {

  private Integer term;
  protected Double askingPrice;
  protected Boolean isNegotiable;

  private Integer term2;
  protected Double askingPrice2;
  protected Boolean isNegotiable2;

  private Rental testRental;
  private Rental testRental2;
  private Sale testSale;

  @Before
  public void setUp() throws Exception {
    askingPrice = 10.0;
    askingPrice2 = 5.0;
    isNegotiable = true;
    term = 5;
    term2 = -1;

    testRental = new Rental(askingPrice, isNegotiable, term);

  }

  @Test
  public void getTerm() {
    assertEquals(testRental.getTerm(), term);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getTerm2() throws IllegalArgumentException {
    testRental2 = new Rental(askingPrice, isNegotiable, term2);
    assertEquals(testRental2.getTerm(), term2);
  }

  @Test
  public void testEquals() {
    assertTrue(testRental.equals(testRental));
    assertFalse(testRental.equals(askingPrice));
    assertNotEquals(testRental, null);
    testRental2 = new Rental(askingPrice, isNegotiable, term);
    assertTrue(testRental.equals(testRental2));

    testSale = new Sale(askingPrice, true);
    assertFalse(testRental.equals(testSale));

  }

  @Test
  public void testHashCode() {
    int hash1 = Objects.hash(askingPrice, isNegotiable);
    int hash = Objects.hash(hash1, term);
    assertEquals(hash, testRental.hashCode());
  }

  @Test
  public void testToString() {

    String expectedString = "Contract{" +
        "asking_price=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        "}" +
        "Rental{" + "term=" + term +
        '}';

    assertEquals(expectedString, testRental.toString());
  }

  @Test
  public void testGetCommissionFactor() {
    assertEquals(testRental.getCommissionFactor(), term);
  }

}