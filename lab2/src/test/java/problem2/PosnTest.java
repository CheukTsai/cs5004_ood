package problem2;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import problem1.Athlete;

public class PosnTest {

  private Integer expectedX;
  private Integer expectedX2;
  private Integer expectedY;
  private Integer expectedY2;
  private Posn testPosn;
  private Posn testPosn2;

  @Before
  public void setUp() throws Exception {
    expectedX = 1;
    expectedX2 = 2;
    expectedY = 3;
    expectedY2 = 4;
    testPosn = new Posn(expectedX, expectedY);
  }

  @Test
  public void getX() {
    assertEquals(expectedX, testPosn.getX());
  }

  @Test
  public void getY() {
    assertEquals(expectedY, testPosn.getY());
  }

  @Test
  public void equalsReflexivity(){
    assertTrue(testPosn.equals(testPosn));
  }

  @Test
  public void equalsReflexivity2(){
    testPosn2 = new Posn(expectedX2, expectedY2);
    assertFalse(testPosn.equals(testPosn2));
  }

  @Test
  public void equalsReflexivity3(){
    assertFalse(testPosn.equals(null));
  }

  @Test
  public void equalsDifferentDataType(){
    assertFalse(testPosn.equals(expectedX));
  }

  @Test
  public void equalsSameFields(){
    testPosn2 = new Posn(expectedX, expectedY);
    assertTrue(testPosn.equals(testPosn2));
  }

  @Test
  public void equalsNotSameX(){
    testPosn2 = new Posn(expectedX2, expectedY);
    assertFalse(testPosn.equals(testPosn2));
  }

  @Test
  public void equalsNotSameY(){
    testPosn2 = new Posn(expectedX, expectedY2);
    assertFalse(testPosn.equals(testPosn2));
  }

  @Test
  public void hasCodeSame(){
    int expectedResult = expectedX.hashCode();
    expectedResult = expectedResult * 31 + expectedY.hashCode();
    assertEquals(expectedResult, testPosn.hashCode());
  }

  @Test
  public void hasCodeSame2(){
    testPosn2 = new Posn(null,null);
    int expectedResult = 0;
    assertEquals(expectedResult, testPosn2.hashCode());
  }

  @Test
  public void hasSameToString(){
    String expectedString = "Posn{" +
        "x=" + expectedX +
        ", y=" + expectedY +
        '}';
    assertEquals(expectedString, testPosn.toString());
  }
}