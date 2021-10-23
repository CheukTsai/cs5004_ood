package simpleRecursiveList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsTest {

  private Cons testCons;
  private Cons testCons2;
  private List testCons3;
  private Integer expectedFirst;
  private List expectedRest;

  @Before
  public void setUp() throws Exception {
    expectedFirst = 1;
    expectedRest = new Empty();
    testCons = new Cons(expectedFirst, expectedRest);
  }

  @Test
  public void getFirst() {
    assertEquals(expectedFirst, testCons.getFirst());
  }

  @Test
  public void getRest() {
    assertEquals(expectedRest, testCons.getRest());
  }

  @Test
  public void size() {
    Integer one = 1;
    assertEquals(one, testCons.size());

  }

  @Test
  public void isEmpty() {
    assertFalse(testCons.isEmpty());
  }

  @Test
  public void add() {
    testCons2 = new Cons(2, testCons);
    testCons3 = testCons.add(2);
    assertEquals(testCons3, testCons2);
  }

  @Test
  public void last() {
    assertEquals(expectedFirst, testCons.last());
    testCons3 = testCons.add(2);
    assertEquals(expectedFirst, testCons3.last());
  }

  @Test
  public void contains() {
    assertTrue(testCons.contains(expectedFirst));
    assertFalse(testCons.contains(2));
    testCons3 = testCons.add(2);
    assertTrue(testCons3.contains(2));
  }

  @Test(expected = InvalidCallException.class)
  public void elementAt() {
    testCons.elementAt(-1);

  }

  @Test(expected = InvalidCallException.class)
  public void elementAt1() {
    testCons.elementAt(1);
  }

  @Test
  public void elementAt2() {
    assertEquals(expectedFirst,testCons.elementAt(0));
    testCons3 = testCons.add(2);
    assertEquals((Integer) 1, testCons3.elementAt(1));
  }

  @Test
  public void sum() {
    testCons3 = testCons.add(2);
    assertEquals((Integer) 3, testCons3.sum());
  }

  @Test
  public void remove() {
    assertEquals(testCons, testCons.remove(2));
    assertEquals(expectedRest, testCons.remove(1));
    testCons3 = testCons.add(2);
    testCons3 = testCons3.remove(expectedFirst);
    assertEquals(new Cons(2,expectedRest), testCons3);
  }

  @Test
  public void testEquals() {
    assertTrue(testCons.equals(testCons));
    assertFalse(testCons.equals(null));
    assertFalse(testCons.equals(expectedFirst));
    testCons2 = new Cons(expectedFirst, expectedRest);
    assertTrue(testCons.equals(testCons2));

    testCons2 = new Cons(null, expectedRest);
    testCons3 = new Cons(null, null);
    assertFalse(testCons3.equals(testCons2));

    testCons2 = new Cons(null, expectedRest);
    assertFalse(testCons.equals(testCons2));
    assertFalse(testCons2.equals(testCons));

    testCons2 = new Cons(expectedFirst, expectedRest);
    assertTrue(testCons.equals(testCons2));

    testCons2 = new Cons(expectedFirst, null);
    assertFalse(testCons.equals(testCons2));

    testCons2 = new Cons(expectedFirst, expectedRest);
    testCons3 = new Cons(expectedFirst, testCons);
    assertFalse(testCons3.equals(testCons2));

    testCons2 = new Cons(expectedFirst, null);
    testCons3 = new Cons(expectedFirst, testCons);
    assertFalse(testCons3.equals(testCons2));

    testCons2 = new Cons(expectedFirst, null);
    testCons3 = new Cons(expectedFirst, null);
    assertTrue(testCons3.equals(testCons2));

    testCons2 = new Cons(3, expectedRest);
    assertFalse(testCons.equals(testCons2));

    testCons2 = new Cons(3, testCons);
    assertFalse(testCons.equals(testCons2));
  }

  @Test
  public void testHashCode() {
    int HASHCODE = 31;
    int hash = expectedFirst.hashCode();
    hash = HASHCODE * hash + expectedRest.hashCode();
    assertEquals(hash, testCons.hashCode());

    testCons2 = new Cons(null,null);
    assertEquals(0,testCons2.hashCode());

    testCons2 = new Cons(null, expectedRest);
    hash = 0 + expectedRest.hashCode();
    assertEquals(hash,testCons2.hashCode());

    testCons2 = new Cons(expectedFirst, null);
    hash = expectedFirst.hashCode() * HASHCODE;
    assertEquals(hash, testCons2.hashCode());

  }

  @Test
  public void testToString() {
    String expectedString = "Cons{"
        + "first=" + expectedFirst
        + ", rest=" + expectedRest
        + '}';
    assertEquals(expectedString, testCons.toString());
  }
}