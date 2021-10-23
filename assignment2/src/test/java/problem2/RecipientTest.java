package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipientTest {

  private String expectedFirstName;
  private String expectedLastName;
  private String expectedEmailAddress;
  private Recipient testRecipient;

  @Before
  public void setUp() throws Exception {
    expectedFirstName = "Zhuocai";
    expectedLastName = "Li";
    expectedEmailAddress = "lzc@neu.edu";
    testRecipient = new Recipient(expectedFirstName, expectedLastName, expectedEmailAddress);
  }

  @Test
  public void getFirstName() {
    assertEquals(expectedFirstName, testRecipient.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals(expectedLastName, testRecipient.getLastName());
  }

  @Test
  public void getEmailAddress() {
    assertEquals(expectedEmailAddress, testRecipient.getEmailAddress());
  }
}