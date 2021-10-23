package prob1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class SaleTest {

  private Double askingPrice;
  private Boolean isNegotiable;
  private Double askingPrice2;
  private Boolean isNegotiable2;
  private Sale testSale;
  private Sale testSale2;


  @Before
  public void setUp() throws Exception {
    askingPrice = 10.0;
    isNegotiable = true;
    isNegotiable2 = false;
    askingPrice2 = 5.0;

    testSale = new Sale(askingPrice, true);
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(askingPrice, isNegotiable);
    assertEquals(hash, testSale.hashCode());
  }


  @Test
  public void testEquals() {
    assertTrue(testSale.equals(testSale));
    assertNotEquals(testSale, testSale2);
    assertFalse(testSale.equals(askingPrice));
    assertNotNull(testSale);
    testSale2 = new Sale(askingPrice, true);
    assertEquals(testSale, testSale2);

    testSale2 = new Sale(askingPrice, false);
    assertNotEquals(testSale, testSale2);
    testSale2 = new Sale(askingPrice2, false);
    assertNotEquals(testSale, testSale2);

  }

  @Test
  public void testToString() {
    String expectedString = "Sale{" +
        "asking_price=" + askingPrice +
        ", negotiable=" + isNegotiable +
        '}';

    assertEquals(testSale.toString(), expectedString);
  }

  @Test
  public void testGetCommissionFactor() {
    assertEquals((Integer) 1, testSale.getCommissionFactor());
  }
}