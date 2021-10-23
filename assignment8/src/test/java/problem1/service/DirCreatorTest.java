package problem1.service;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.Before;
import org.junit.Test;

public class DirCreatorTest {
  private DirCreator dirCreator;

  @Before
  public void setUp() throws Exception {
    dirCreator = new DirCreator();
  }

  @Test
  public void createNewOutputDir() {
    dirCreator.createNewOutputDir("gradle");
    dirCreator.createNewOutputDir("newDir");
    File dir = new File("newDir");
    dir.delete();

  }
}