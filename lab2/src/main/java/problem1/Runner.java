package problem1;

import java.util.Objects;

public class Runner extends Athlete{

  private String team;
  private Double best5KTime;
  private String favoriteRunningEvent;


  /**
   * Constructs a new Runner, based upon all of the provided input parameters.
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league - athlete's league, expressed as String
   * @param team - runner's team , expressed as a String
   * @param best5KTime - runner's best 5K time, expressed as a Double
   * @param favoriteRunningEvent  - runner's favorite running event, expressed as a String
   */
  public Runner(Name athletesName, Double height, Double weight, String league, String team,
      Double best5KTime , String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.best5KTime = best5KTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Constructs a new Runner, based upon all of the provided input parameters.
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param team - runner's team , expressed as a String
   * @param best5KTime - runner's best 5K time, expressed as a Double
   * @param favoriteRunningEvent  - runner's favorite running event, expressed as a String
   */
  public Runner(Name athletesName, Double height, Double weight, String team,
      Double best5KTime , String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.team = team;
    this.best5KTime = best5KTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }
  /**
   * returns baseball player's team as a String
   * @return a String
   */
  public String getTeam() {
    return team;
  }

  /**
   * returns baseball player's best 5K time as a Double
   * @return a Double
   */
  public Double getBest5KTime() {
    return best5KTime;
  }

  /**
   * returns baseball player's favorite running event, expressed as a String
   * @return a String
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }
  /**
   * returns runner's team , expressed as a String
   * @return a String
   */

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
    Runner runner = (Runner) o;
    return Objects.equals(team, runner.team) && Objects
        .equals(best5KTime, runner.best5KTime) && Objects
        .equals(favoriteRunningEvent, runner.favoriteRunningEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, best5KTime, favoriteRunningEvent);
  }

  @Override
  public String toString() {
    return "Runner{" +
        "team='" + team + '\'' +
        ", best5KTime=" + best5KTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
        '}';
  }
}
