package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsBagOfWordsTest {

  private String expectedHead;
  private String expectedHead2;
  private BagOfWords expectedRest;
  private BagOfWords expectedRest2;
  private BagOfWords testConsBagOfWords;
  private BagOfWords testConsBagOfWords2;

  @Before
  public void setUp() throws Exception {
    expectedHead = "a";
    expectedRest = BagOfWords.emptyBagOfWords();
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);

  }

  @Test
  public void add(){
    assertEquals(expectedRest.add("a"), testConsBagOfWords);
  }

  @Test
  public void isEmpty() {
    assertFalse(testConsBagOfWords.isEmpty());
  }

  @Test
  public void size() {
    assertEquals((Integer)1, testConsBagOfWords.size());
  }

  @Test
  public void contains() {
    assertTrue(testConsBagOfWords.contains(expectedHead));
    assertFalse(testConsBagOfWords.contains("b"));
  }

  @Test
  public void removeElement() {
    testConsBagOfWords = testConsBagOfWords.add("a");
    testConsBagOfWords = testConsBagOfWords.add("b");
    testConsBagOfWords = testConsBagOfWords.add("c");
    testConsBagOfWords = testConsBagOfWords.remove("a");
    testConsBagOfWords = testConsBagOfWords.remove("b");
    testConsBagOfWords = testConsBagOfWords.remove("c");
    assertEquals(expectedRest, testConsBagOfWords.remove(expectedHead));

  }

  @Test
  public void testEquals() {
    assertTrue(testConsBagOfWords.equals(testConsBagOfWords));
    assertFalse(testConsBagOfWords.equals(null));
    assertFalse(testConsBagOfWords.equals(expectedHead));

    testConsBagOfWords2 = new ConsBagOfWords(expectedHead, expectedRest);
    assertTrue(testConsBagOfWords.equals(testConsBagOfWords2));

//    expectedHead2 = null;
//    expectedRest2 = BagOfWords.emptyBagOfWords();
//    testConsBagOfWords2 = new ConsBagOfWords(expectedHead2, expectedRest2);
//    assertFalse(testConsBagOfWords2.equals(testConsBagOfWords));
//    testConsBagOfWords = new ConsBagOfWords(expectedHead2, expectedRest2);
//    assertTrue(testConsBagOfWords2.equals(testConsBagOfWords));
//
//    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
//    expectedHead2 = "a";
//    expectedRest2 = null;
//    testConsBagOfWords2 = new ConsBagOfWords(expectedHead2, expectedRest2);
//    assertFalse(testConsBagOfWords2.equals(testConsBagOfWords));
//    testConsBagOfWords = new ConsBagOfWords(expectedHead2, expectedRest2);
//    assertTrue(testConsBagOfWords2.equals(testConsBagOfWords));
//
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    expectedHead2 = "b";
    expectedRest2 = BagOfWords.emptyBagOfWords();
    testConsBagOfWords2 = new ConsBagOfWords(expectedHead2, expectedRest2);
    assertFalse(testConsBagOfWords2.equals(testConsBagOfWords));

    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    expectedHead2 = "a";
    expectedRest2 = testConsBagOfWords;
    testConsBagOfWords2 = new ConsBagOfWords(expectedHead2, expectedRest2);
    assertFalse(testConsBagOfWords2.equals(testConsBagOfWords));
  }

  @Test
  public void testHashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());

    result = 1;
    expectedHead = null;
    expectedRest = BagOfWords.emptyBagOfWords();
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());

    result = 1;
    expectedHead = "a";
    expectedRest = null;
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());

    result = 1;
    expectedHead = "b";
    expectedRest = BagOfWords.emptyBagOfWords();
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());

    result = 1;
    expectedHead = "a";
    expectedRest = testConsBagOfWords;
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "ConsBagOfWords{" +
        "head='" + expectedHead + '\'' +
        ", rest=" + expectedRest +
        '}';
    assertEquals(expectedString, testConsBagOfWords.toString());
  }


}