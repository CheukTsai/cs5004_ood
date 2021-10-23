package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyBagOfWordsTest {

  private BagOfWords testEmptyBagOfWords;
  private BagOfWords testEmptyBagOfWords2;
  private String expectedString;
  @Before
  public void setUp() throws Exception {
    expectedString = "a";
    testEmptyBagOfWords = BagOfWords.emptyBagOfWords();
  }

  @Test
  public void isEmpty() {
    assertTrue(testEmptyBagOfWords.isEmpty());
  }

  @Test
  public void size() {
    assertEquals((Integer) 0, testEmptyBagOfWords.size());
  }

  @Test
  public void contains() {

    assertFalse(testEmptyBagOfWords.contains(expectedString));
  }

  @Test
  public void removeElement() {
    assertEquals(testEmptyBagOfWords, testEmptyBagOfWords.remove(expectedString));
  }

  @Test
  public void testEquals() {
    assertTrue(testEmptyBagOfWords.equals(testEmptyBagOfWords));
    assertFalse(testEmptyBagOfWords.equals(null));
    assertFalse(testEmptyBagOfWords.equals(0));
    testEmptyBagOfWords2 = BagOfWords.emptyBagOfWords();
    assertTrue(testEmptyBagOfWords.equals(testEmptyBagOfWords2));
  }

  @Test
  public void testHashCode() {
    assertEquals(41, testEmptyBagOfWords.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "{ }";
    assertEquals(expectedString, testEmptyBagOfWords.toString());
  }

}