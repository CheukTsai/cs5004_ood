package simpleRecursiveList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyTest {

  private static final Integer ZERO = 0;
  private List testEmpty;
  private Integer expectedFirst;
  private List testEmpty2;

  @Before
  public void setUp() throws Exception {
    testEmpty = new Empty();
    expectedFirst = 1;
  }

  @Test
  public void size() {

    assertEquals(ZERO, testEmpty.size());
  }

  @Test
  public void isEmpty() {
    assertTrue(testEmpty.isEmpty());
  }

  @Test
  public void add() {

    List expectedCons = new Cons(expectedFirst, testEmpty);
    List test = testEmpty.add(expectedFirst);
    assertEquals(expectedCons, test);
  }

  @Test(expected = InvalidCallException.class)
  public void last() throws InvalidCallException{
      testEmpty.last();
  }

  @Test
  public void contains() {
    assertFalse(testEmpty.contains(expectedFirst));
  }

  @Test(expected = InvalidCallException.class)
  public void elementAt() {
    testEmpty.elementAt(1);
  }

  @Test
  public void sum() {
    assertEquals(ZERO, testEmpty.sum());
  }

  @Test(expected = InvalidCallException.class)
  public void remove() {
    testEmpty.remove(1);
  }

  @Test
  public void testEquals() {
    testEmpty2 = new Empty();
    assertTrue(testEmpty.equals(testEmpty));
    assertTrue(testEmpty.equals(testEmpty2));
    assertFalse(testEmpty.equals(null));
    assertFalse(testEmpty.equals(expectedFirst));
  }

  @Test
  public void testHashCode() {
    assertEquals(42, testEmpty.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "Empty{}";
    assertEquals(expectedString, testEmpty.toString());
  }
}