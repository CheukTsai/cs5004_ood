package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingTest {

  private String expectedAddress;
  private PropertySize expectedPropertySize;
  private PropertySize expectedPropertySize2;
  private Boolean expectedMonthlySubscription;
  private Integer expectedNumberOfPreviousService;
  private BasicInformation expectedBasicInformation;
  private BasicInformation expectedBasicInformation2;
  private Integer expectedNumberOfPets;
  private Painting testPainting;
  private Painting testPainting2;

  @Before
  public void setUp() throws Exception {
    expectedAddress = "abc road";
    expectedPropertySize = PropertySize.SMALL;
    expectedMonthlySubscription = false;
    expectedNumberOfPreviousService = 0;
    expectedBasicInformation = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    expectedNumberOfPets = 0;
    testPainting = new Painting(expectedBasicInformation, expectedNumberOfPets);
  }

  @Test
  public void calculatePrice() {
    assertEquals(1280,testPainting.calculatePrice(),0);
  }

  @Test
  public void calculatePrice2() {
    expectedPropertySize2 = PropertySize.MEDIUM;
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize2,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testPainting2 = new Painting(expectedBasicInformation2, expectedNumberOfPets);
    assertEquals(1280,testPainting2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice3() {
    expectedPropertySize2 = PropertySize.LARGE;
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize2,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testPainting2 = new Painting(expectedBasicInformation2, expectedNumberOfPets);
    assertEquals(1920,testPainting2.calculatePrice(),0);
  }

  @Test
  public void testHashCode() {
    assertEquals(testPainting.hashCode(), testPainting.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(testPainting.equals(testPainting));
  }

  @Test
  public void testToString() {
    assertEquals(testPainting.toString(),testPainting.toString());
  }
}