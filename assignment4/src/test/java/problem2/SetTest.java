package problem2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class SetTest {

  private Integer expectedItem;
  private Set testSet;
  private Set testSet2;

  @Before
  public void setUp() throws Exception {
    expectedItem = 1;
    testSet = new Set();
    testSet2 = new Set();

  }

  @Test
  public void emptySet() {
    testSet2 = testSet.emptySet();
    System.out.println(testSet2.toString());
    Integer i = 0;
    assertEquals(i,testSet2.size());
    assertTrue(testSet2.isEmpty());
  }

  @Test
  public void isEmpty() {
    assertTrue(testSet.isEmpty());
    testSet = testSet.add(2);
    assertFalse(testSet.isEmpty());
  }

  @Test
  public void add() {
    testSet = testSet.add(2);
    testSet = testSet.add(2);
    testSet = testSet.add(3);
    assertFalse(testSet.isEmpty());
    assertTrue(testSet.contains(2));
    assertTrue(testSet.contains(3));
  }

  @Test
  public void remove() {
    testSet = testSet.add(2);
    testSet = testSet.add(3);
    testSet = testSet.remove(4);
    testSet = testSet.remove(2);
    testSet = testSet.remove(3);
    assertTrue(testSet.isEmpty());
  }

  @Test
  public void size() {
    Integer i = 0;
    assertEquals(i,testSet.size());
    i++;
    testSet = testSet.add(3);
    assertEquals(i,testSet.size());
  }

  @Test
  public void contains() {
    assertFalse(testSet.contains(1));
    testSet = testSet.add(1);
    assertTrue(testSet.contains(1));
  }

  @Test
  public void testEquals1() {
    assertTrue(testSet.equals(testSet));

    assertFalse(testSet.equals(null));

    testSet = testSet.add(1);
    testSet2 = testSet2.add(1);
    assertTrue(testSet.equals(testSet2));

    testSet2 = testSet2.add(2);
    assertFalse(testSet.equals(testSet2));

  }

  @Test
  public void testEquals2() {

    testSet = testSet.add(1);
    assertFalse(testSet.equals(1));

    testSet2 = testSet2.add(2);
    assertFalse(testSet.equals(testSet2));

    testSet2 = testSet2.add(3);
    assertFalse(testSet.equals(testSet2));
  }

  @Test
  public void testHashCode() {
    testSet = testSet.add(1);
    Integer[] a = new Integer[1];
    a[0] = 1;
    int result = Objects.hash(1);
    result = 31 * result + Arrays.hashCode(a);
    assertEquals(result, testSet.hashCode());
  }

  @Test
  public void testToString() {
    testSet = testSet.add(1);
    Integer[] a = new Integer[1];
    a[0] = 1;
    String expectedString = "Set{" +
        "items=" + Arrays.toString(a) +
        ", totalLength=" + 1 +
        '}';
  }
}