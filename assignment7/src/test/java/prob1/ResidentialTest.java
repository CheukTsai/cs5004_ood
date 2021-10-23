package prob1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class ResidentialTest {

  private String address;
  private Integer size;

  private String address2;
  private Integer size2;

  private Integer numBedrooms;
  private Double numBathrooms;

  private Integer numBedrooms2;
  private Double numBathrooms2;
  private Double numBathrooms3;

  private Residential testResidential;
  private Residential testResidential2;
  private Residential testResidential5;
  private Residential testResidential6;


  @Before
  public void setUp() throws Exception {
    address = "A";
    size = 1;
    numBedrooms = 2;
    numBathrooms = 1.5;
    numBedrooms2 = 0;
    numBathrooms2 = 0.0;
    numBathrooms3 = 2.7;

    testResidential = new Residential(address, size, numBedrooms, numBathrooms);
  }

  @Test
  public void checkPropertyInfo() {
    assertEquals(testResidential.getNumBathrooms(), numBathrooms);
    assertEquals(testResidential.getNumBedrooms(), numBedrooms);
    assertNotEquals(testResidential.getNumBedrooms(), numBedrooms2);
  }


  @Test(expected = IllegalArgumentException.class)
  public void checkPropertyInfo2() throws IllegalArgumentException {
    testResidential2 = new Residential(address, size, numBedrooms2, numBathrooms2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkPropertyInfo3() throws IllegalArgumentException {
    Residential testResidential3 = new Residential(address, size, numBedrooms, numBathrooms3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkPropertyInfo4() throws IllegalArgumentException {
    Residential testResidential4 = new Residential(address, size, numBedrooms, numBathrooms2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkPropertyInfo5() throws IllegalArgumentException {
    testResidential5 = new Residential(address, size, numBedrooms, numBathrooms3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkPropertyInfo6() throws IllegalArgumentException {
    numBathrooms3 = -2.7;
    testResidential5 = new Residential(address, size, numBedrooms, numBathrooms3);
  }


  @Test
  public void testEquals() {
    assertEquals(testResidential, testResidential);
    assertNotEquals(testResidential, testResidential2);
    assertFalse(testResidential.equals(numBathrooms));
    assertNotEquals(testResidential, null);

    testResidential2 = new Residential(address, size, numBedrooms, numBathrooms);
    assertEquals(testResidential, testResidential2);

    testResidential2 = new Residential("B", size, numBedrooms, numBathrooms);
    assertNotEquals(testResidential, testResidential2);
    testResidential2 = new Residential(address, 2, numBedrooms, numBathrooms);
    assertNotEquals(testResidential, testResidential2);
    testResidential2 = new Residential(address, size, 3, numBathrooms);
    assertNotEquals(testResidential, testResidential2);
    testResidential2 = new Residential(address, size, numBedrooms, 2.5);
    assertNotEquals(testResidential, testResidential2);
  }

  @Test
  public void testHashCode() {
    int hash1 = Objects.hash(address, size);
    int hash = Objects.hash(hash1, numBedrooms, numBathrooms);
    assertEquals(testResidential.hashCode(), hash);
  }

  @Test
  public void testToString() {
    String expectedString = "Residential{" +
        "address='" + address + '\'' +
        ", size=" + size +
        ", num_bedrooms=" + numBedrooms +
        ", num_bathrooms=" + numBathrooms +
        '}';

    assertEquals(testResidential.toString(), expectedString);

  }
}