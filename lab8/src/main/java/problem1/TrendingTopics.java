package problem1;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * A class that represents an object of TrendingTopics.
 */
public class TrendingTopics {
  private Map<String,Integer> occuranceMap;

  /**
   * A constructor that creates a new object of TrendingTopics.
   * @param occuranceMap - Map, occuranceMap
   */
  public TrendingTopics(Map<String, Integer> occuranceMap) {
    this.occuranceMap = occuranceMap;
  }

  /**
   * A constructor that creates a new object of TrendingTopics.
   */
  public TrendingTopics(){
    this.occuranceMap = new HashMap<>();
  }

  /**
   * Return occurrence map.
   * @return Map, occurrence map.
   */
  public Map<String, Integer> getOccurnceMap() {
    return occuranceMap;
  }

  /**
   * Return the number of occurrences of every String in the input list as a Map.
   * @param topics Map List
   * @return the number of occurrences of every String in the input list as a Map.
   */
  public Map<String, Integer> countTopics(List<String> topics){
    this.occuranceMap = topics.stream().collect(Collectors.toMap(x -> x.toString(),
        x -> 1, (x,y) -> x+y));
    return this.occuranceMap;
  }

  /**
   * Return the number of occurrences of every String in the input list as a Map.
   * @param topics - List
   * @return  the number of occurrences of every String in the input list as a Map.
   */
  public Map<String, Long> countTopics2(List<String> topics){
    return topics.stream().collect(Collectors.groupingBy(Function.identity(),
        Collectors.counting()));
  }

  /**
   * Return the number of occurrences of every String in the input list as a Map.
   * @param topics - List
   * @return the number of occurrences of every String in the input list as a Map.
   */
  public Map<String, Long> countTopics3(List<String> topics){
    return topics.stream().collect(Collectors.groupingBy(word->word, Collectors.counting()));
  }

  /**
   * Return the number of occurrences of every String in the input list as a Map.
   * @param topics - List
   * @return the number of occurrences of every String in the input list as a Map
   */
  public Map<String, Integer> countTopics4(List<String> topics){
    this.occuranceMap = topics.stream().collect(Collectors.toMap(x->x, x->1, Integer::sum));
    return this.occuranceMap;
  }

  /**
   * Return the number of occurrences of every String in the input list as a Map.
   * @param topics - List
   * @return the number of occurrences of every String in the input list as a Map
   */
  public Map<String, Integer> countTopics5(List<String> topics){
    this.occuranceMap = topics.stream().collect(Collectors.toMap(Function.identity(),
        x-> TrendingTopics.getNumElements(topics,x),(x,y) -> Math.max(x, y)));
    return this.occuranceMap;
  }

  /**
   * Return the counter of the String x in the list
   * @param topics List
   * @param x String
   * @return the counter of the String x in the list
   */
  protected static Integer getNumElements(List<String> topics, String x){
    Integer counter = 0;
    for(String element : topics){
      if(element.equals(x))
        counter++;
    }
    return counter;
  }


  /**
   *  Indicates whether some other object passed as an argument is "equal to" the
   *  current instance
   * @param o object, an object to compare
   * @return  boolean value
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrendingTopics that = (TrendingTopics) o;
    return Objects.equals(getOccurnceMap(), that.getOccurnceMap());
  }

  /**
   * {@inheritDoc}
   * Returns an integer representation of the object memory address
   * @return int, hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getOccurnceMap());
  }

  /**
   *{@inheritDoc}
   * Returns an String representation of the object
   * @return an String representation of the object
   */
  @Override
  public String toString() {
    return "TrendingTopics{" +
        "occuranceMap=" + occuranceMap +
        '}';
  }
}
