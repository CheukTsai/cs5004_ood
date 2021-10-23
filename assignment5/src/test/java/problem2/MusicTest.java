package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MusicTest {

  private String expectedTitle;
  private Creator expectedCreator;
  private Integer expectedYear;
  private Music testMusic;

  @Before
  public void setUp() throws Exception {
    expectedTitle = "goodBook";
    expectedCreator = new RecordingArtist("good", "author");
    expectedYear = 2021;
    testMusic = new Music(expectedTitle, expectedCreator, expectedYear);
  }

  @Test
  public void testGetTitle() {
    assertEquals(expectedTitle, testMusic.getTitle());
  }
}