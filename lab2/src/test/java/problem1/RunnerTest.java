package problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {

  private Name name;
  private Name name2;
  private Double height;
  private Double height2;
  private Double weight;
  private Double weight2;
  private String league;
  private String league2;
  private String team;
  private String team2;
  private Double best5KTime;
  private Double best5KTime2;
  private String favoriteRunningEvent;
  private String favoriteRunningEvent2;
  private Runner testRunner;
  private Runner testRunnerNoLeague;
  private Runner testRunner2;

  @Before
  public void setUp() throws Exception {
    name = new Name("Zhuocai", "Tsai", "Li");
    name2 = new Name("a", "b", "c");
    height = 170.0;
    height2 = 180.0;
    weight = 58.0;
    weight2 = 158.0;
    league = "NoName";
    league2 = "BigName";
    team = "Rockets";
    team2 = "Rocks";
    best5KTime= 20.0;
    best5KTime2= 120.0;
    favoriteRunningEvent = "Jogging";
    favoriteRunningEvent2 = "Marathon";
    testRunner = new Runner(name, height, weight, league, team, best5KTime, favoriteRunningEvent);
    testRunnerNoLeague = new Runner(name, height, weight, team, best5KTime, favoriteRunningEvent);
  }

  @Test
  public void getTeam() {
    assertEquals(team, testRunner.getTeam());
  }

  @Test
  public void getBest5KTime() {
    assertEquals(best5KTime, testRunner.getBest5KTime());
  }

  @Test
  public void getFavoriteRunningEvent() {
    assertEquals(favoriteRunningEvent, testRunner.getFavoriteRunningEvent());
  }


  @Test
  public void equalsReflexivity(){
    assertTrue(testRunner.equals(testRunner));
  }

  @Test
  public void equalsReflexivity2(){
    testRunner = new Runner(name2, height2, weight2, league2, team2, best5KTime2, favoriteRunningEvent2);
    assertFalse(testRunner.equals(testRunner2));
  }

  @Test
  public void equalsReflexivity3(){
    assertFalse(testRunner.equals(null));
  }

  @Test
  public void equalsDifferentDataTypes(){
    assertFalse(testRunner.equals(name));
  }

  @Test
  public void equalsSameFields(){
    testRunner2 = new Runner(name, height, weight, league, team, best5KTime, favoriteRunningEvent);
    assertTrue(testRunner.equals(testRunner2));
  }

  @Test
  public void equalsNotSameName(){
    testRunner2 = new Runner(name2, height, weight, league, team, best5KTime, favoriteRunningEvent);
    assertFalse(testRunner.equals(testRunner2));
  }

  @Test
  public void equalsNotSameHeight(){
    testRunner2 = new Runner(name, height2, weight, league, team, best5KTime, favoriteRunningEvent);
    assertFalse(testRunner.equals(testRunner2));
  }

  @Test
  public void equalsNotSameWeight(){
    testRunner2 = new Runner(name, height, weight2, league, team, best5KTime, favoriteRunningEvent);
    assertFalse(testRunner.equals(testRunner2));
  }

  @Test
  public void equalsNotSameLeague(){
    testRunner2 = new Runner(name, height, weight, league2, team, best5KTime, favoriteRunningEvent);
    assertFalse(testRunner.equals(testRunner2));
  }

  @Test
  public void equalsNotSameTeam(){
    testRunner2 = new Runner(name, height, weight, league, team2, best5KTime, favoriteRunningEvent);
    assertFalse(testRunner.equals(testRunner2));
  }

  @Test
  public void equalsNotSameBest5KTime(){
    testRunner2 = new Runner(name, height, weight, league, team, best5KTime2, favoriteRunningEvent);
    assertFalse(testRunner.equals(testRunner2));
  }

  @Test
  public void equalsNotSameFavoriteRunningEvent(){
    testRunner2 = new Runner(name, height, weight, league, team, best5KTime, favoriteRunningEvent2);
    assertFalse(testRunner.equals(testRunner2));
  }

  @Test
  public void hasCodeSame(){
    int hash1 = Objects.hash(testRunner.getAthletesName(), testRunner.getHeight(),
        testRunner.getWeight(),testRunner.getLeague());
    int hash = Objects.hash(hash1, testRunner.getTeam(),
        testRunner.getBest5KTime(), testRunner.getFavoriteRunningEvent());
    assertEquals(hash, testRunner.hashCode());
  }

  @Test
  public void hasSameToString(){
    String expectedString = "Runner{" +
        "team='" + team + '\'' +
        ", best5KTime=" + best5KTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
        '}';
    assertEquals(expectedString, testRunner.toString());
  }
}