package controllerModules.lineOperation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LineSeparatorTest {
  private LineSeparator lineSeparator;
  private String line;

  @Before
  public void setUp() {
    line = "\"a\",\"b\"";
    lineSeparator = new LineSeparator();
  }

  @Test
  public void separate() {
    String[] expectedWords = new String[]{ "a", "b" };
    assertArrayEquals(expectedWords, lineSeparator.separate(line));

  }
}