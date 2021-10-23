package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyPriorityQueueTest {

  private PriorityQueue testEmptyPriorityQueue;
  private PriorityQueue testEmptyPriorityQueue2;

  @Before
  public void setUp() throws Exception {
    testEmptyPriorityQueue = new EmptyPriorityQueue();
  }

  @Test
  public void isEmpty() {
    assertTrue(testEmptyPriorityQueue.isEmpty());
  }

  @Test(expected = InvalidCallException.class)
  public void peek() throws InvalidCallException{
    testEmptyPriorityQueue.peek();
  }

  @Test(expected = InvalidCallException.class)
  public void pop() throws InvalidCallException{
    testEmptyPriorityQueue.pop();
  }

  @Test
  public void testEquals() {
    assertTrue(testEmptyPriorityQueue.equals(testEmptyPriorityQueue));
    assertFalse(testEmptyPriorityQueue.equals(null));
    assertFalse(testEmptyPriorityQueue.equals(0));
    testEmptyPriorityQueue2 = PriorityQueue.createEmpty();
    assertTrue(testEmptyPriorityQueue.equals(testEmptyPriorityQueue2));
  }

  @Test
  public void testHashCode() {
    assertEquals(41, testEmptyPriorityQueue.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "{ }";
    assertEquals(expectedString, testEmptyPriorityQueue.toString());
  }


}