package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class CourseTest {

  private String expectedName;
  private String expectedPrefix;
  private int expectedNumber;
  private Course testCourse;
  private Course testCourse2;

  @Before
  public void setUp() throws Exception {
    expectedName = "a";
    expectedPrefix = "b";
    expectedNumber = 1;
    testCourse = new Course(expectedName, expectedPrefix, expectedNumber);
  }

  @Test
  public void testToString() {
    String expectedString = expectedPrefix + expectedNumber + ": " + expectedName;
    assertEquals(expectedString, testCourse.toString());
  }

  @Test
  public void testEquals() {
    assertTrue(testCourse.equals(testCourse));
  }

  @Test
  public void testEquals1() {
    testCourse2 = new Course(expectedName, expectedPrefix, expectedNumber);
    assertTrue(testCourse.equals(testCourse2));
  }

  @Test
  public void testEquals2() {
    testCourse2 = new Course("c", "s", 2);
    assertFalse(testCourse.equals(testCourse2));
  }

  @Test
  public void testEquals3() {
    assertFalse(testCourse.equals(null));
  }

  @Test
  public void testEquals4() {
    assertFalse(testCourse.equals(new Course("b", expectedPrefix, expectedNumber)));
  }

  @Test
  public void testEquals5() {
    assertFalse(testCourse.equals(new Course(expectedName, "c", expectedNumber)));
  }

  @Test
  public void testEquals6() {
    assertFalse(testCourse.equals(new Course(expectedName, expectedPrefix, 1000000)));
  }

  @Test
  public void testEquals7() {
    assertFalse(testCourse.equals(expectedName));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(expectedName, expectedPrefix, expectedNumber);
    assertEquals(hash, testCourse.hashCode());
  }
}
