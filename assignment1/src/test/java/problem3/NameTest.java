package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {

    private String expectFirstName;
    private String expectLastName;
    private Name testName;

    @Before
    public void setUp() throws Exception {
      expectFirstName = "Zhuocai";
      expectLastName = "Li";
      testName = new Name(expectFirstName, expectLastName);
    }

    @Test
    public void getFirstName() {
      assertEquals(expectFirstName, testName.getFirstName());
    }

    @Test
    public void getLastName() {
      assertEquals(expectLastName, testName.getLastName());
    }
}