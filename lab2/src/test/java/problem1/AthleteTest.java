package problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class AthleteTest {

  private Athlete testAthlete;
  private Athlete testAthleteNoLeague;
  private Athlete testAthlete2;
  private Name expectedName;
  private Name expectedName2;
  private Double expectedHeight;
  private Double expectedHeight2;
  private Double expectedWeight;
  private Double expectedWeight2;
  private String expectedLeague;
  private String expectedLeague2;


  @Before
  public void setUp() throws Exception {
    expectedName = new Name("Zhuocai", "Tsai", "Li");
    expectedName2 = new Name("a", "b", "c");
    expectedHeight = 56.0;
    expectedHeight2 = 66.0;
    expectedWeight = 170.0;
    expectedWeight2 = 180.0;
    expectedLeague = "N/A";
    expectedLeague2 = "aaa";
    testAthlete = new Athlete(expectedName,expectedHeight,expectedWeight,expectedLeague);
    testAthleteNoLeague = new Athlete(expectedName,expectedHeight,expectedWeight);

  }

  @Test
  public void getAthletesName() {
    assertEquals(expectedName, testAthlete.getAthletesName());
  }

  @Test
  public void getHeight() {
    assertEquals(expectedHeight, testAthlete.getHeight());
  }

  @Test
  public void getWeight() {
    assertEquals(expectedWeight, testAthlete.getWeight());
  }

  @Test
  public void getLeague() {
    assertEquals(expectedLeague, testAthlete.getLeague());
  }

  @Test
  public void equalsReflexivity(){
    assertTrue(testAthlete.equals(testAthlete));
  }

  @Test
  public void equalsReflexivity2(){
    testAthlete2 = new Athlete(expectedName2,expectedHeight2,expectedWeight2,expectedLeague2);
    assertFalse(testAthlete.equals(testAthlete2));
  }

  @Test
  public void equalsReflexivity3(){
    assertFalse(testAthlete.equals(null));
  }

  @Test
  public void equalsDifferentDataTypes(){
    assertFalse(testAthlete.equals(expectedName));
  }

  @Test
  public void equalsSameFields(){
    testAthlete2 = new Athlete(expectedName,expectedHeight,expectedWeight,expectedLeague);
    assertTrue(testAthlete.equals(testAthlete2));
  }

  @Test
  public void equalsNotSameHeight(){
    testAthlete2 = new Athlete(expectedName, expectedHeight2, expectedWeight, expectedLeague);
    assertFalse(testAthlete.equals(testAthlete2));
  }

  @Test
  public void equalsNotSameWeight(){
    testAthlete2 = new Athlete(expectedName, expectedHeight, expectedWeight2, expectedLeague);
    assertFalse(testAthlete.equals(testAthlete2));
  }

  @Test
  public void equalsNotSameLeague(){
    testAthlete2 = new Athlete(expectedName, expectedHeight, expectedWeight, expectedLeague2);
    assertFalse(testAthlete.equals(testAthlete2));
  }

  @Test
  public void hasCodeSame(){
    int hash = Objects.hash(testAthlete.getAthletesName(), testAthlete.getHeight(),
        testAthlete.getWeight(), testAthlete.getLeague());
    assertEquals(hash, testAthlete.hashCode());
  }

  @Test
  public void hasSameToString(){
    String expectedString = "Athlete{" +
        "athletesName=" + expectedName +
        ", height=" + expectedHeight +
        ", weight=" + expectedWeight +
        ", league='" + expectedLeague + '\'' +
        '}';
    assertEquals(expectedString, testAthlete.toString());
  }
}