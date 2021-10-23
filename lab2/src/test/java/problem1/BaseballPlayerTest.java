package problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {

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
  private Double averageBatting;
  private Double averageBatting2;
  private Integer seasonHomeRuns;
  private Integer seasonHomeRuns2;
  private BaseballPlayer testPlayer;
  private BaseballPlayer testPlayerNoLeague;
  private BaseballPlayer testPlayer2;

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
    averageBatting = 5111.1;
    averageBatting2 = 1111.1;
    seasonHomeRuns = 1888;
    seasonHomeRuns2 = 1899;
    testPlayer = new BaseballPlayer(name, height, weight, league,
        team, averageBatting, seasonHomeRuns);
    testPlayerNoLeague = new BaseballPlayer(name,
        height, weight, team, averageBatting, seasonHomeRuns);
  }


  @Test
  public void getTeam() {
    assertEquals(team, testPlayer.getTeam());
  }

  @Test
  public void getAverageBatting() {
    assertEquals(averageBatting, testPlayer.getAverageBatting());
  }

  @Test
  public void getSeasonHomeRuns() {
    assertEquals(seasonHomeRuns, testPlayer.getSeasonHomeRuns());
  }

  @Test
  public void equalsReflexivity(){
    assertTrue(testPlayer.equals(testPlayer));
  }

  @Test
  public void equalsReflexivity2(){
    testPlayer2 = new BaseballPlayer(name2, height2, weight2, league2, team2,
        averageBatting2, seasonHomeRuns2);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  public void equalsReflexivity3(){
    assertFalse(testPlayer.equals(null));
  }

  @Test
  public void equalsDifferentDataTypes(){
    assertFalse(testPlayer.equals(name));
  }

  @Test
  public void equalsSameFields(){
    testPlayer2 = new BaseballPlayer(name, height, weight, league,
        team, averageBatting, seasonHomeRuns);
    assertTrue(testPlayer.equals(testPlayer2));
  }

  @Test
  public void equalsNotSameName(){
    testPlayer2 = new BaseballPlayer(name2, height, weight, league,
        team, averageBatting, seasonHomeRuns);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  public void equalsNotSameHeight(){
    testPlayer2 = new BaseballPlayer(name, height2, weight, league,
        team, averageBatting, seasonHomeRuns);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  public void equalsNotSameWeight(){
    testPlayer2 = new BaseballPlayer(name, height, weight2, league,
        team, averageBatting, seasonHomeRuns);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  public void equalsNotSameLeague(){
    testPlayer2 = new BaseballPlayer(name, height, weight, league2,
        team, averageBatting, seasonHomeRuns);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  public void equalsNotSameTeam(){
    testPlayer2 = new BaseballPlayer(name, height, weight, league,
        team2, averageBatting, seasonHomeRuns);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  public void equalsNotSameAverageBatting(){
    testPlayer2 = new BaseballPlayer(name, height, weight, league,
        team, averageBatting2, seasonHomeRuns);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  public void equalsNotSameSeasonHomeRuns(){
    testPlayer2 = new BaseballPlayer(name, height, weight, league,
        team, averageBatting, seasonHomeRuns2);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  public void hasCodeSame(){
    int hash1 = Objects.hash(testPlayer.getAthletesName(), testPlayer.getHeight(),
        testPlayer.getWeight(),testPlayer.getLeague());
    int hash = Objects.hash(hash1, testPlayer.getTeam(),
        testPlayer.getAverageBatting(), testPlayer.getSeasonHomeRuns());
    assertEquals(hash, testPlayer.hashCode());
  }

  @Test
  public void hasSameToString(){
    String expectedString = "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", averageBatting=" + averageBatting +
        ", seasonHomeRuns=" + seasonHomeRuns +
        '}';
    assertEquals(expectedString, testPlayer.toString());
  }
}