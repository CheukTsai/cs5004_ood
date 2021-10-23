package prob1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class CommercialTest {

  private Integer numOfOffices;
  private Integer numOfOffices2;

  private Commercial testCommercial;
  private Commercial testCommercial2;
  private Residential testResidential;

  private Boolean isRetail;
  private String address;
  private Integer size;


  @Before
  public void setUp() throws Exception {
    numOfOffices = 2;
    numOfOffices2 = -1;
    isRetail = true;
    address = "A";
    size = 10;
    testCommercial = new Commercial(address, size, numOfOffices, isRetail);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkPropertyInfo() throws IllegalArgumentException {
    testCommercial2 = new Commercial("B", 10, numOfOffices2, isRetail);
  }

  @Test
  public void testEquals() {
    assertTrue(testCommercial.equals(testCommercial));
    assertFalse(testCommercial.equals(numOfOffices));
    assertNotEquals(testCommercial, null);

    testResidential = new Residential(address, size, 1, 1.5);
    assertFalse(testCommercial.equals(testResidential));
    assertFalse(testResidential.equals(testCommercial));

    testCommercial2 = new Commercial(address, size, numOfOffices, isRetail);
    assertTrue(testCommercial.equals(testCommercial2));

    testCommercial2 = new Commercial("b", size, numOfOffices, isRetail);
    assertFalse(testCommercial.equals(testCommercial2));

    testCommercial2 = new Commercial(address, 111, numOfOffices, isRetail);
    assertFalse(testCommercial.equals(testCommercial2));

    testCommercial2 = new Commercial(address, size, 111, isRetail);
    assertFalse(testCommercial.equals(testCommercial2));

    testCommercial2 = new Commercial(address, size, numOfOffices, false);
    assertFalse(testCommercial.equals(testCommercial2));

  }


  @Test
  public void testHashCode() {
    int hash1 = Objects.hash("A", 10);
    int hash = Objects.hash(hash1, numOfOffices, true);
    assertEquals(testCommercial.hashCode(), hash);
  }

  @Test
  public void testToString() {
    String expectedString = "Commercial{" +
        "numOfOffices=" + numOfOffices +
        ", isRetail=" + isRetail +
        ", address='" + address + '\'' +
        ", size=" + size +
        '}';

    assertEquals(testCommercial.toString(), expectedString);
  }
}