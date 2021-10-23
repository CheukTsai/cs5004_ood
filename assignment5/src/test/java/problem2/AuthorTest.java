package problem2;


import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

  private String expectedFirstName;
  private String expectedLastName;
  private Author testAuthor;
  private Author testAuthor2;

  @Before
  public void setUp() throws Exception {
    expectedFirstName = "Zhuocai";
    expectedLastName = "Li";
    testAuthor = new Author(expectedFirstName, expectedLastName);
  }

  @Test
  public void testGetName() {
    String expectedName = expectedFirstName + " " + expectedLastName;
    assertEquals(expectedName, testAuthor.getName());
  }

  @Test
  public void testEquals() {
    assertTrue(testAuthor.equals(testAuthor));
    assertFalse(testAuthor.equals(null));
    assertFalse(testAuthor.equals(expectedFirstName));
  }

  @Test
  public void testEquals2() {
    testAuthor2 = new Author(expectedFirstName, expectedLastName);
    assertTrue(testAuthor.equals(testAuthor2));

    expectedFirstName = "NotZhuocai";
    expectedLastName = "Li";
    testAuthor2 = new Author(expectedFirstName, expectedLastName);
    assertFalse(testAuthor.equals(testAuthor2));

    expectedFirstName = "Zhuocai";
    expectedLastName = "NotLi";
    testAuthor2 = new Author(expectedFirstName, expectedLastName);
    assertFalse(testAuthor.equals(testAuthor2));

  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(expectedFirstName, expectedLastName);
    assertEquals(hash, testAuthor.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "Person{" +
        "firstName='" + expectedFirstName + '\'' +
        ", lastName='" + expectedLastName + '\'' +
        '}';
    assertEquals(expectedString, testAuthor.toString());
  }
}