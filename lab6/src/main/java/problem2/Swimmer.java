package problem2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*Class Swimmer contains information about a swimmer, and the list of their swimming times, when
swimming 50m. Four swimming styles are considered: butterfly, backstroke, breaststroke, and freestyle.
 */
public class Swimmer implements Comparable<Swimmer> {

  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breaststroke50mTimes;
  private List<Double> freestyle50mTimes;

  public Swimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes,
                              List<Double> breaststroke50mTimes, List<Double> freestyle50mTimes) {
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes;
    this.backstroke50mTimes = backstroke50mTimes;
    this.breaststroke50mTimes = breaststroke50mTimes;
    this.freestyle50mTimes = freestyle50mTimes;
  }

  public List<Double> getButterfly50mTimes() {
    return butterfly50mTimes;
  }

  public List<Double> getFreestyle50mTimes() {
    return freestyle50mTimes;
  }

  @Override
  public int compareTo(Swimmer otherSwimmer) {
    return Double.compare(this.computeAverageSwimTime(this.freestyle50mTimes),
        otherSwimmer.computeAverageSwimTime(otherSwimmer.freestyle50mTimes));
  }

  private Double computeAverageSwimTime(List<Double> swimTimes){
    Double averageTime = 0d;

    for(Double swimTime: swimTimes){
      averageTime+= swimTime;
    }
    return averageTime/swimTimes.size();
  }

  protected Double getFastestSwimTime(List<Double> swimTimes){
    Collections.sort(swimTimes);
    return swimTimes.get(swimTimes.size() - 1);
  }

  Comparator<Swimmer> fastestButterflyTime = new Comparator<Swimmer>(){
      @Override
      public int compare(Swimmer s1, Swimmer s2){
        return Double.compare(s1.getFastestSwimTime(s1.butterfly50mTimes),
            s2.getFastestSwimTime(s2.butterfly50mTimes));
      }
  };
}
