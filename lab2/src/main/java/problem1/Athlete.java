package problem1;

import java.util.Objects;

public class Athlete {
  protected Name athletesName;
  protected Double height;
  protected Double weight;
  protected String league;

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league - athlete's league, expressed as String
   */
  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   * @param  athletesName - object Name, containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   */
  public Athlete(Name athletesName, Double height, Double weight) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /** Returns athlete's name as an object Name
   * @return object athletesName
   */
  public Name getAthletesName() {
    return athletesName;
  }

  /** Returns athlete's height as a Double
   * @return a Double
   */
  public Double getHeight() {
    return height;
  }

  /** Returns athlete's weight as a Double
   * @return a Double
   */
  public Double getWeight() {
    return weight;
  }

  /** Returns athlete's league as a String
   * @return a String
   */
  public String getLeague() {
    return league;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Athlete athlete = (Athlete) o;
    return Objects.equals(athletesName, athlete.athletesName) && Objects
        .equals(height, athlete.height) && Objects.equals(weight, athlete.weight)
        && Objects.equals(league, athlete.league);
  }

  @Override
  public int hashCode() {
    return Objects.hash(athletesName, height, weight, league);
  }

  @Override
  public String toString() {
    return "Athlete{" +
        "athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
  }
}
