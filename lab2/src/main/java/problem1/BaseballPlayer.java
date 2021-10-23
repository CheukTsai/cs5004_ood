package problem1;


import java.util.Objects;

public class BaseballPlayer extends Athlete{

  private String team;
  private Double averageBatting;
  private Integer seasonHomeRuns;

  /**
   * Constructs a new baseballPlayer, based upon all of the provided input parameters.
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league - athlete's league, expressed as String
   * @param team - baseball player's team , expressed as a String
   * @param averageBatting -  baseball player's average batting, expressed as a Double
   * @param seasonHomeRuns - baseball player's season home runs, expressed as an Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Constructs a new baseballPlayer, based upon all of the provided input parameters.
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param team - baseball player's team , expressed as a String
   * @param averageBatting -  baseball player's average batting, expressed as a Double
   * @param seasonHomeRuns - baseball player's season home runs, expressed as an Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight,
      String team, Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  public String getTeam() {
    return team;
  }

  /**
   * returns runner's average batting, expressed as a Double
   * @return a Double
   */
  public Double getAverageBatting() {
    return averageBatting;
  }

  /**
   * returns runner's season home runs, expressed as an Integer
   * @return an Integer
   */
  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(team, that.team) && Objects
        .equals(averageBatting, that.averageBatting) && Objects
        .equals(seasonHomeRuns, that.seasonHomeRuns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, averageBatting, seasonHomeRuns);
  }

  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", averageBatting=" + averageBatting +
        ", seasonHomeRuns=" + seasonHomeRuns +
        '}';
  }
}
