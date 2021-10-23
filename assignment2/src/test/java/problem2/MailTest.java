package problem2;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MailTest {
  Integer expectedWidth = 1;
  Integer expectedWidth2 = 2;
  Integer expectedHeight = 2;
  Integer expectedHeight2 = 3;
  Integer expectedDepth = 3;
  Integer expectedDepth2 = 4;
  Recipient expectedRecipient = new Recipient("a", "b", "c");
  Recipient expectedRecipient2 = new Recipient("c", "b", "a");
  Mail testMail;
  Mail testMail2;

  @Before
  public void setUp() throws Exception {
    testMail = new Mail(expectedWidth, expectedHeight, expectedDepth, expectedRecipient);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWidth(){
    testMail2 = new Mail(-1,1,1,expectedRecipient);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHeight(){
    testMail2 = new Mail(1,-1,1,expectedRecipient);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDepth(){
    testMail2 = new Mail(1,1,-1,expectedRecipient);
  }

  @Test
  public void testGetWidth() {
    assertEquals(expectedWidth, testMail.getWidth());
  }

  @Test
  public void testGetHeight() {
    assertEquals(expectedHeight, testMail.getHeight());
  }

  @Test
  public void testGetDepth() {
    assertEquals(expectedDepth, testMail.getDepth());
  }

  @Test
  public void getRecipient() { assertEquals(expectedRecipient, testMail.getRecipient());}

  @Test
  public void equalsReflexivity(){
    assertTrue(testMail.equals(testMail));
  }

  @Test
  public void equalsReflexivity2(){
    testMail2 = new Mail(1,1,1,expectedRecipient2);
    assertFalse(testMail.equals(testMail2));
  }

  @Test
  public void equalsReflexivity3(){
    assertFalse(testMail.equals(null));
  }

  @Test
  public void equalsDifferentDataTypes(){
    assertFalse(testMail.equals(expectedWidth));
  }

  @Test
  public void equalsSameFields(){
    testMail2 = new Mail(expectedWidth,expectedHeight,expectedDepth,expectedRecipient);
    assertTrue(testMail.equals(testMail2));
  }

  @Test
  public void equalsNotSameWidth(){
    testMail2 = new Mail(expectedWidth2, expectedHeight, expectedDepth, expectedRecipient);
    assertFalse(testMail.equals(testMail2));
  }

  @Test
  public void equalsNotSameHeight(){
    testMail2 = new Mail(expectedWidth, expectedHeight2, expectedDepth, expectedRecipient);
    assertFalse(testMail.equals(testMail2));
  }

  @Test
  public void equalsNotSameDepth(){
    testMail2 = new Mail(expectedWidth, expectedHeight, expectedDepth2, expectedRecipient);
    assertFalse(testMail.equals(testMail2));
  }

  @Test
  public void equalsNotSameRecipient(){
    testMail2 = new Mail(expectedWidth2, expectedHeight, expectedDepth, expectedRecipient2);
    assertFalse(testMail.equals(testMail2));
  }

  @Test
  public void hasCodeSame(){
    int hash = Objects.hash(testMail.getWidth(),testMail.getHeight(),testMail.getDepth());
    assertEquals(hash, testMail.hashCode());
  }

  @Test
  public void hasSameToString(){
    String expectedString = "AbstractCuboid{" +
        "width=" + expectedWidth +
        ", height=" + expectedHeight +
        ", depth=" + expectedDepth +
        '}';
    assertEquals(expectedString, testMail.toString());
  }

}

