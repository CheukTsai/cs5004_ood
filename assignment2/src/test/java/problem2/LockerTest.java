package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LockerTest {
  private Recipient expectedRecipient;
  private Recipient wrongRecipient;
  private Mail expectedMail;
  private Mail occupyingMail;
  private Mail oversizeMail;
  private Locker testLocker;
  private Locker testLocker2;
  @Before
  public void setUp() throws Exception {
    expectedRecipient = new Recipient("Zhuocai", "Li",
        "correct@email.com");
    expectedMail = new Mail(2,2,2,expectedRecipient);
    testLocker = new Locker(3,3,3);
  }

  @Test
  public void testAddMailSuccess() throws  OversizeException, OccupiedException{
    testLocker.addMail(expectedMail);
  }

  @Test(expected = OversizeException.class)
  public void testAddOverWidthMail() throws OversizeException, OccupiedException{
    oversizeMail = new Mail(4,2,2,expectedRecipient);
    testLocker.addMail(oversizeMail);
  }

  @Test(expected = OversizeException.class)
  public void testAddOverHeightMail() throws OversizeException, OccupiedException{
    oversizeMail = new Mail(2,4,2,expectedRecipient);
    testLocker.addMail(oversizeMail);
  }

  @Test(expected = OversizeException.class)
  public void testAddOverDepthMail() throws OversizeException, OccupiedException{
    oversizeMail = new Mail(2,2,4,expectedRecipient);
    testLocker.addMail(oversizeMail);
  }

  @Test(expected = OccupiedException.class)
  public void testOccupiedLocker() throws OversizeException, OccupiedException{
    occupyingMail = new Mail(2,2,2,expectedRecipient);
    testLocker2 = new Locker(3,3,3);
    testLocker2.addMail(occupyingMail);
    testLocker2.addMail(expectedMail);
  }

  @Test
  public void testPickupMailSuccess() throws OversizeException, OccupiedException,
      EmptyException, WrongRecipientException{
    testLocker.addMail(expectedMail);
    assertEquals(expectedMail,testLocker.pickupMail(expectedRecipient));
    assertNull(testLocker.getMail());
  }

  @Test(expected = EmptyException.class)
  public void testNoMailToPick() throws EmptyException, WrongRecipientException{
    testLocker.pickupMail(expectedRecipient);
  }

  @Test(expected = WrongRecipientException.class)
  public void testWrongRecipient() throws OversizeException, OccupiedException,
      EmptyException, WrongRecipientException{
    wrongRecipient = new Recipient("Wrong","Guy","NoEmail");
    testLocker.addMail(expectedMail);
    testLocker.pickupMail(wrongRecipient);
  }

  @Test
  public void getMail() {
    assertNull(testLocker.getMail());
  }
}