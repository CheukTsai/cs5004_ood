package problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class CourseCatalogTest {

  private String expectedName;
  private String expectedPrefix;
  private int expectedNumber;
  private Course expectedCourse;
  private Course expectedCourse2;
  private Course expectedCourse3;
  private CourseCatalog testCourseCatalog;
  private CourseCatalog testCourseCatalog2;

  @Before
  public void setUp() throws Exception {
    expectedName = "a";
    expectedPrefix = "b";
    expectedNumber = 1;
    expectedCourse = new Course(expectedName,expectedPrefix,expectedNumber);
    expectedCourse2 = new Course("c","d",10000);
    testCourseCatalog = new CourseCatalog();
    testCourseCatalog2 = new CourseCatalog();
  }

  @Test
  public void append() throws InvalidIndexException{
    testCourseCatalog.append(expectedCourse);
    assertTrue(testCourseCatalog.contains(expectedCourse));
    assertEquals(1,testCourseCatalog.count());
    testCourseCatalog.append(expectedCourse2);
    assertTrue(testCourseCatalog.contains(expectedCourse2));
    assertEquals(2,testCourseCatalog.count());
  }

  @Test
  public void remove() throws CourseNotFoundException{
    testCourseCatalog.append(expectedCourse);
    testCourseCatalog.remove(expectedCourse);
    assertFalse(testCourseCatalog.contains(expectedCourse));
    assertEquals(0,testCourseCatalog.count());
  }

  @Test(expected = CourseNotFoundException.class)
  public void remove2() throws CourseNotFoundException{
    testCourseCatalog.append(expectedCourse);
    expectedCourse3 = new Course("d", expectedPrefix,expectedNumber);
    testCourseCatalog.remove(expectedCourse3);
  }

  @Test
  public void remove3() throws CourseNotFoundException{
    testCourseCatalog.append(expectedCourse);
    expectedCourse3 = new Course("d", expectedPrefix,expectedNumber);
    testCourseCatalog.append(expectedCourse3);
    testCourseCatalog.remove(expectedCourse3);
    assertFalse(testCourseCatalog.contains(expectedCourse3));
    assertEquals(1,testCourseCatalog.count());
  }

  @Test
  public void contains() {
    assertFalse(testCourseCatalog.contains(expectedCourse));
    testCourseCatalog.append(expectedCourse);
    assertTrue(testCourseCatalog.contains(expectedCourse));
  }

  @Test
  public void indexOf() {
    testCourseCatalog.append(expectedCourse);
    expectedCourse3 = new Course("d", expectedPrefix,expectedNumber);
    assertEquals(0,testCourseCatalog.indexOf(expectedCourse));
    assertEquals(-1,testCourseCatalog.indexOf(expectedCourse3));

  }

  @Test
  public void count() {
    testCourseCatalog.append(expectedCourse);
    assertEquals(1, testCourseCatalog.count());
  }

  @Test
  public void get() throws InvalidIndexException{
    testCourseCatalog.append(expectedCourse);
    assertEquals(expectedCourse,testCourseCatalog.get(0));
  }

  @Test(expected = InvalidIndexException.class)
  public void get2() throws InvalidIndexException{
    testCourseCatalog.append(expectedCourse);
    assertEquals(expectedCourse,testCourseCatalog.get(-1));
  }

  @Test(expected = InvalidIndexException.class)
  public void get3() throws InvalidIndexException{
    testCourseCatalog.append(expectedCourse);
    assertEquals(expectedCourse,testCourseCatalog.get(1));
  }

  @Test
  public void isEmpty() {
    assertTrue(testCourseCatalog.isEmpty());
    testCourseCatalog.append(expectedCourse);
    assertFalse(testCourseCatalog.isEmpty());
  }

  @Test
  public void testEquals() {
    assertTrue(testCourseCatalog.equals(testCourseCatalog));
  }


  @Test
  public void testEquals2() {
    testCourseCatalog.append(expectedCourse);
    testCourseCatalog2.append(expectedCourse);
    assertTrue(testCourseCatalog.equals(testCourseCatalog2));
  }

  @Test
  public void testEquals3() {
    testCourseCatalog2.append(expectedCourse);
    assertFalse(testCourseCatalog.equals(testCourseCatalog2));
  }

  @Test
  public void testEquals4() {
    assertFalse(testCourseCatalog.equals(null));
  }


  @Test
  public void testEquals5() {
    testCourseCatalog.append(expectedCourse);
    testCourseCatalog2.append(expectedCourse2);
    assertFalse(testCourseCatalog.equals(testCourseCatalog2));
  }

  @Test
  public void testEquals6() {
    assertFalse(testCourseCatalog.equals(expectedCourse));
  }

  @Test
  public void testHashCode() {
    testCourseCatalog.append(expectedCourse);
    Course[] a =  new Course[1];
    a[0] = expectedCourse;
    int result = Objects.hash(1);
    result = 31 * result + Arrays.hashCode(a);
    assertEquals(result, testCourseCatalog.hashCode());

  }

  @Test
  public void testToString() {
    testCourseCatalog.append(expectedCourse);
    Course[] a =  new Course[1];
    a[0] = expectedCourse;
    String expectedString = "CourseCatalog{"
        + "courses="
        + Arrays.toString(a)
        + ", totalNum="
        + 1
        + '}';
    assertEquals(expectedString, testCourseCatalog.toString());
  }
}