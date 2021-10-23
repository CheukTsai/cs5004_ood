package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordingArtistTest {

  private String expectedFirstName;
  private String expectedLastName;
  private RecordingArtist testRecordingArtist;

  @Before
  public void setUp() throws Exception {
    expectedFirstName = "Zhuocai";
    expectedLastName = "Li";
    testRecordingArtist = new RecordingArtist(expectedFirstName, expectedLastName);

  }

  @Test
  public void testGetName() {
    String expectedName = expectedFirstName + " " + expectedLastName;
    assertEquals(expectedName, testRecordingArtist.getName());
  }

  @Test
  public void testGetMembers() {
    assertNull(testRecordingArtist.getMembers());
  }
}