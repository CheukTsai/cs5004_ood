package problem2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class BandTest {

  private String expectedName;
  private String expectedName2;
  private Set<Person> expectedMembers;
  private Set<Person> expectedMembers2;
  private RecordingArtist expectedMember1;
  private RecordingArtist expectedMember2;
  private RecordingArtist expectedMember3;
  private Band testBand;
  private Band testBand2;

  @Before
  public void setUp() throws Exception {
    expectedName = "Beatles";
    expectedMember1 = new RecordingArtist("a", "b");
    expectedMember2 = new RecordingArtist("c", "d");
    expectedMember3 = new RecordingArtist("c", "d");

    expectedMembers = new HashSet<Person>();
    expectedMembers.add(expectedMember1);
    expectedMembers.add(expectedMember2);

    testBand = new Band(expectedName, expectedMembers);
  }

  @Test
  public void testGetName() {
    assertEquals(expectedName, testBand.getName());
  }

  @Test
  public void testGetMembers() {
    assertEquals(expectedMembers, testBand.getMembers());
  }

  @Test
  public void testEquals() {
    assertTrue(testBand.equals(testBand));
    assertFalse(testBand.equals(null));
    assertFalse(testBand.equals(expectedName));
  }


  @Test
  public void testEquals2() {
    testBand2 = new Band(expectedName, expectedMembers);
    assertTrue(testBand.equals(testBand2));

    expectedName2 = "abc";
    testBand2 = new Band(expectedName2, expectedMembers);
    assertFalse(testBand.equals(testBand2));


    expectedMembers2 = new HashSet<Person>();
    expectedMembers.add(expectedMember1);
    expectedMembers.add(expectedMember3);
    testBand2 = new Band(expectedName, expectedMembers2);
    assertFalse(testBand.equals(testBand2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(expectedName,expectedMembers);
    assertEquals(hash, testBand.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "Group{" +
        "name='" + expectedName + '\'' +
        ", members=" + expectedMembers +
        '}';
    assertEquals(expectedString, testBand.toString());
  }
}