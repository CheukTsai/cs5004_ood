package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class PledgeTest {

  private LocalDateTime creationTime;
  private Float amount;
  private LocalDateTime processTime;
  private Pledge testPledge1;
  private Pledge testPledge2;
  private Pledge testPledge3;

  @Before
  public void setUp() throws Exception {
    creationTime = LocalDateTime.of(1,1,1,1,1,1);
    processTime = LocalDateTime.of(2,2,2,2,2,2);
    amount = 1000f;
    testPledge1 = new Pledge(creationTime,amount);
    testPledge2 = new Pledge(creationTime, amount, processTime);
  }

  @Test
  public void countYearlyAmount() {
    assertEquals(0f, testPledge1.countYearlyAmount(2021),0);
    assertEquals(0f, testPledge2.countYearlyAmount(2021),0);
    assertEquals(1000f, testPledge2.countYearlyAmount(2),0);
  }

  @Test(expected = InvalidProcessingTimeException.class)
  public void testInvalidProcessingTime() throws InvalidProcessingTimeException{
    creationTime = LocalDateTime.of(2,2,2,2,2,2);
    processTime = LocalDateTime.of(1,1,1,1,1,1);
    amount = 1000f;
    testPledge3 = new Pledge(creationTime, amount, processTime);
  }

  @Test
  public void testEquals() {
    assertTrue(testPledge1.equals(testPledge1));
    assertFalse(testPledge1.equals(null));
    assertFalse(testPledge1.equals(creationTime));
    assertFalse(testPledge1.equals(testPledge2));
  }


  @Test
  public void testEquals2() throws InvalidProcessingTimeException{
    creationTime = LocalDateTime.of(1,1,1,1,1,2);
    amount = 1000f;
    testPledge3 = new Pledge(creationTime,amount);
    assertFalse(testPledge1.equals(testPledge3));

    creationTime = LocalDateTime.of(1,1,1,1,1,1);
    amount = 1001f;
    testPledge3 = new Pledge(creationTime,amount);
    assertFalse(testPledge1.equals(testPledge3));

    creationTime = LocalDateTime.of(1,1,1,1,1,2);
    amount = 1001f;
    testPledge3 = new Pledge(creationTime,amount);
    assertFalse(testPledge1.equals(testPledge3));

    creationTime = LocalDateTime.of(1,1,1,1,1,1);
    processTime = LocalDateTime.of(2,2,2,2,2,2);
    amount = 1000f;
    testPledge3 = new Pledge(creationTime, amount, processTime);
    assertTrue(testPledge2.equals(testPledge3));

    creationTime = LocalDateTime.of(1,1,1,1,1,1);
    processTime = LocalDateTime.of(2,2,2,2,2,3);
    amount = 1000f;
    testPledge3 = new Pledge(creationTime, amount, processTime);
    assertFalse(testPledge2.equals(testPledge3));

  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(creationTime, amount, null);
    assertEquals(hash, testPledge1.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "Pledge{" +
        "creationTime=" + creationTime +
        ", amount=" + amount +
        ", processTime=" + processTime +
        '}';
    assertEquals(expectedString, testPledge2.toString());
  }
}