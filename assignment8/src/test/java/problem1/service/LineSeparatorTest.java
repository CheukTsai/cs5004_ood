package problem1.service;

import static org.junit.Assert.*;

import javax.sound.sampled.Line;
import org.junit.Before;
import org.junit.Test;

public class LineSeparatorTest {

  private LineSeparator lineSeparator;
  private String line;

  @Before
  public void setUp() throws Exception {
    line = "\"a\",\"b\"";
    lineSeparator = new LineSeparator();
  }

  @Test
  public void getInfoSeparated() {
    String[] expectedWords = new String[]{
      "a", "b"
    };
    assertArrayEquals(expectedWords, lineSeparator.getInfoSeparated(line));
  }
}