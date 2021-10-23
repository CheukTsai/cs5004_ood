package problem2;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class BookTest {

  private String expectedTitle;
  private Author expectedAuthor;
  private Integer expectedYear;
  private Book testBook;
  private Book testBook2;

  @Before
  public void setUp() throws Exception {
    expectedTitle = "goodBook";
    expectedAuthor = new Author("good", "author");
    expectedYear = 2021;
    testBook = new Book(expectedTitle, expectedAuthor, expectedYear);
  }

  @Test
  public void testGetTitle() {
    assertEquals(expectedTitle, testBook.getTitle());
  }

  @Test
  public void testGetCreator() {
    assertEquals(expectedAuthor, testBook.getCreator());
  }

  @Test
  public void testGetYear() {
    assertEquals(expectedYear, testBook.getYear());
  }

  @Test
  public void testEquals() {
    assertTrue(testBook.equals(testBook));
    assertFalse(testBook.equals(null));
    assertFalse(testBook.equals(expectedTitle));
  }

  @Test
  public void testEquals2() {
    testBook2 = new Book(expectedTitle, expectedAuthor, expectedYear);
    assertTrue(testBook.equals(testBook2));

    expectedTitle = "goodBook2";
    expectedAuthor = new Author("good", "author");
    expectedYear = 2021;
    testBook2 = new Book(expectedTitle, expectedAuthor, expectedYear);
    assertFalse(testBook.equals(testBook2));

    expectedTitle = "goodBook";
    expectedAuthor = new Author("good2", "author");
    expectedYear = 2021;
    testBook2 = new Book(expectedTitle, expectedAuthor, expectedYear);
    assertFalse(testBook.equals(testBook2));

    expectedTitle = "goodBook";
    expectedAuthor = new Author("good", "author");
    expectedYear = 20212;
    testBook2 = new Book(expectedTitle, expectedAuthor, expectedYear);
    assertFalse(testBook.equals(testBook2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(expectedTitle, expectedAuthor, expectedYear);
    assertEquals(hash, testBook.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "Item{" +
        "title='" + expectedTitle + '\'' +
        ", creator=" + expectedAuthor +
        ", year=" + expectedYear +
        '}';
    assertEquals(expectedString, testBook.toString());
  }
}