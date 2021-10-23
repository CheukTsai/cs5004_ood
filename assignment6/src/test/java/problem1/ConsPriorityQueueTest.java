package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsPriorityQueueTest {

  private Integer expectedPriority;
  private Integer expectedPriority2;
  private String expectedValue;
  private String expectedValue2;
  private PriorityQueue expectedRest;
  private PriorityQueue expectedRest2;
  private ConsPriorityQueue testConsPriorityQueue;
  private PriorityQueue testConsPriorityQueue2;

  @Before
  public void setUp() throws Exception {
    expectedPriority = 100;
    expectedValue = "first";
    expectedRest = PriorityQueue.createEmpty();
    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
  }

  @Test
  public void isEmpty() {
    assertFalse(testConsPriorityQueue.isEmpty());
  }

  @Test
  public void add() throws InvalidCallException{
    expectedPriority2 = 102;
    expectedValue2 = "second";
    testConsPriorityQueue2 = testConsPriorityQueue.add(expectedPriority2, expectedValue2);
    assertEquals(expectedValue2,testConsPriorityQueue2.peek());

    expectedPriority2 = 99;
    expectedValue2 = "second";
    testConsPriorityQueue2 = testConsPriorityQueue.add(expectedPriority2, expectedValue2);
    assertEquals(expectedValue,testConsPriorityQueue2.peek());
  }

  @Test
  public void peek() throws InvalidCallException{
    assertEquals(expectedValue,testConsPriorityQueue.peek());
  }

  @Test
  public void pop() {
    assertEquals(expectedRest, testConsPriorityQueue.pop());
  }

  @Test
  public void testEquals() {
    assertTrue(testConsPriorityQueue.equals(testConsPriorityQueue));
    assertFalse(testConsPriorityQueue.equals(null));
    assertFalse(testConsPriorityQueue.equals(expectedPriority));

    testConsPriorityQueue2 = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
    assertTrue(testConsPriorityQueue.equals(testConsPriorityQueue2));

    expectedPriority2 = null;
    expectedValue2 = "first";
    expectedRest2 = PriorityQueue.createEmpty();
    testConsPriorityQueue2 = new ConsPriorityQueue(expectedPriority2, expectedValue2, expectedRest2);
    assertFalse(testConsPriorityQueue2.equals(testConsPriorityQueue));
    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority2, expectedValue2, expectedRest2);
    assertTrue(testConsPriorityQueue2.equals(testConsPriorityQueue));

    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
    expectedPriority2 = 100;
    expectedValue2 = null;
    expectedRest2 = PriorityQueue.createEmpty();
    testConsPriorityQueue2 = new ConsPriorityQueue(expectedPriority2, expectedValue2, expectedRest2);
    assertFalse(testConsPriorityQueue2.equals(testConsPriorityQueue));
    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority2, expectedValue2, expectedRest2);
    assertTrue(testConsPriorityQueue2.equals(testConsPriorityQueue));

    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
    expectedPriority2 = 100;
    expectedValue2 = "first";
    expectedRest2 = null;
    testConsPriorityQueue2 = new ConsPriorityQueue(expectedPriority2, expectedValue2, expectedRest2);
    assertFalse(testConsPriorityQueue2.equals(testConsPriorityQueue));
    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority2, expectedValue2, expectedRest2);
    assertTrue(testConsPriorityQueue2.equals(testConsPriorityQueue));

    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);

    expectedPriority = 101;
    expectedValue = "first";
    expectedRest = PriorityQueue.createEmpty();
    testConsPriorityQueue2 = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
    assertFalse(testConsPriorityQueue.equals(testConsPriorityQueue2));

    expectedPriority = 100;
    expectedValue = "first1";
    expectedRest = PriorityQueue.createEmpty();
    testConsPriorityQueue2 = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
    assertFalse(testConsPriorityQueue.equals(testConsPriorityQueue2));

    expectedPriority = 100;
    expectedValue = "first";
    expectedRest = testConsPriorityQueue;
    testConsPriorityQueue2 = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
    assertFalse(testConsPriorityQueue.equals(testConsPriorityQueue2));
  }

  @Test
  public void testHashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((expectedPriority == null) ? 0 : expectedPriority.hashCode());
    result = (prime * result) + ((expectedValue == null) ? 0 : expectedValue.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsPriorityQueue.hashCode());

    expectedPriority = null;
    expectedValue = "first";
    expectedRest = PriorityQueue.createEmpty();
    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
    result = 1;
    result = (prime * result) + ((expectedPriority == null) ? 0 : expectedPriority.hashCode());
    result = (prime * result) + ((expectedValue == null) ? 0 : expectedValue.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsPriorityQueue.hashCode());

    expectedPriority = 100;
    expectedValue = null;
    expectedRest = PriorityQueue.createEmpty();
    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
    result = 1;
    result = (prime * result) + ((expectedPriority == null) ? 0 : expectedPriority.hashCode());
    result = (prime * result) + ((expectedValue == null) ? 0 : expectedValue.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsPriorityQueue.hashCode());

    expectedPriority = 100;
    expectedValue = "first";
    expectedRest = null;
    testConsPriorityQueue = new ConsPriorityQueue(expectedPriority, expectedValue, expectedRest);
    result = 1;
    result = (prime * result) + ((expectedPriority == null) ? 0 : expectedPriority.hashCode());
    result = (prime * result) + ((expectedValue == null) ? 0 : expectedValue.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsPriorityQueue.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "ConsPriorityQueue{" +
        ", head.priority=" + expectedPriority +
        ", head.value=" + expectedValue +
        ", rest=" + expectedRest +
        '}';
    assertEquals(expectedString, testConsPriorityQueue.toString());
  }
}