package problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private String expectedFirstName;
  private String expectedFirstName2;
  private String expectedMiddleName;
  private String expectedMiddleName2;
  private String expectedLastName;
  private String expectedLastName2;
  private Name testName;
  private Name testName2;

  @Before
  public void setUp() throws Exception {
    expectedFirstName = "Zhuocai";
    expectedFirstName2 = "a";
    expectedMiddleName = "Tsai";
    expectedMiddleName2 = "b";
    expectedLastName = "Li";
    expectedLastName2 = "c";
    testName = new Name(expectedFirstName, expectedMiddleName, expectedLastName);
  }

  @Test
  public void getFirstName() {
    assertEquals(expectedFirstName, testName.getFirstName());
  }

  @Test
  public void getMiddleName() {
    assertEquals(expectedMiddleName, testName.getMiddleName());
  }

  @Test
  public void getLastName() {
    assertEquals(expectedLastName, testName.getLastName());
  }

  @Test
  public void equalsReflexivity(){
    assertTrue(testName.equals(testName));
  }

  @Test
  public void equalsReflexivity2(){
    testName2 = new Name(expectedFirstName2,expectedMiddleName2, expectedLastName2);
    assertFalse(testName.equals(testName2));
  }

  @Test
  public void equalsReflexivity3(){
    assertFalse(testName.equals(null));
  }

  @Test
  public void equalsDifferentDataTypes(){
    assertFalse(testName.equals(expectedFirstName));
  }

  @Test
  public void equalsSameFields(){
   testName2 = new Name(expectedFirstName, expectedMiddleName, expectedLastName);
   assertTrue(testName.equals(testName2));
  }

  @Test
  public void equalsNotSameFirstName(){
    testName2 = new Name(expectedFirstName2, expectedMiddleName, expectedLastName);
    assertFalse(testName.equals(testName2));
  }

  @Test
  public void equalsNotSameMiddleName(){
    testName2 = new Name(expectedFirstName, expectedMiddleName2, expectedLastName);
    assertFalse(testName.equals(testName2));
  }
  @Test
  public void equalsNotSameLastName(){
    testName2 = new Name(expectedFirstName, expectedMiddleName, expectedLastName2);
    assertFalse(testName.equals(testName2));

  }

  @Test
  public void hasCodeSame(){
    int hash = Objects.hash(testName.getFirstName(), testName.getMiddleName(),
        testName.getLastName());
    assertEquals(hash, testName.hashCode());
  }

  @Test
  public void hasSameToString(){
    String expectedString = "Name{" +
        "firstName='" + expectedFirstName + '\'' +
        ", middleName='" + expectedMiddleName + '\'' +
        ", lastName='" + expectedLastName + '\'' +
        '}';
    assertEquals(expectedString, testName.toString());
  }
}