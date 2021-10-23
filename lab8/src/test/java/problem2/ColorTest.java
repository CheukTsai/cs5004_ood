package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ColorTest {
  private Color color;

  @Test
  public void values() {
    assertEquals(color.RED.name(), "RED");
  }
}