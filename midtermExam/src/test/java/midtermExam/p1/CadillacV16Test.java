package midtermExam.p1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CadillacV16Test {

  private String expectedUniqueID;
  private Integer expectedAge;
  private Integer expectedMileage;
  private Condition expectedCondition;
  private Double expectedLatestAskingPrice;
  private CadillacV16 testCadillacV16;

  @Before
  public void setUp() throws Exception {
    expectedUniqueID = "goodCar123";
    expectedAge = 100;
    expectedMileage = 10000000;
    expectedCondition = Condition.DRIVER;
    expectedLatestAskingPrice = 20000.0;
    testCadillacV16 = new CadillacV16(expectedUniqueID, expectedAge,
        expectedMileage, expectedCondition, expectedLatestAskingPrice);
  }

  @Test
  public void testEstimatePrice() {
    Double EXPECTED_EXTRA_BONUS = 0.0;
    Double expectedPrice = expectedLatestAskingPrice * 3.2 + EXPECTED_EXTRA_BONUS;
    assertEquals(expectedPrice, testCadillacV16.estimatePrice());
  }
}