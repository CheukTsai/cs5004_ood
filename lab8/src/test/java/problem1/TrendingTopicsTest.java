package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class TrendingTopicsTest {
  private Map<String,Integer> occuranceMap;
  private Map<String,Integer> occuranceMap2;
  private List<String> topics;
  private List<String> topics2;
  private TrendingTopics trendingTopics;
  private TrendingTopics trendingTopics2;
  private TrendingTopics trendingTopics3;


  @Before
  public void setUp() throws Exception {
    occuranceMap = new HashMap<>();
    topics = new ArrayList<>();
    topics.add("a");
    topics.add("a");
    topics.add("a");
    topics.add("a");
    topics.add("b");
    topics.add("b");
    topics.add("c");
    topics.add("d");
    trendingTopics = new TrendingTopics();
    trendingTopics2 = new TrendingTopics();
    trendingTopics3 = new TrendingTopics(occuranceMap);

  }

  @Test
  public void getOccuranceMap() {
    assertEquals(trendingTopics.getOccurnceMap(),occuranceMap);
  }

  @Test
  public void countTopics() {
    Long expected = trendingTopics.countTopics2(topics).get("b");
    assertEquals(Long.compare(expected,2),0);
    Long expected2 = trendingTopics.countTopics3(topics).get("b");
    assertEquals(Long.compare(expected2,2),0);
    Integer expected3 = trendingTopics.countTopics4(topics).get("b");
    assertEquals(Integer.compare(expected3,2),0);
    Integer expected4 = trendingTopics.countTopics5(topics).get("b");
    assertEquals(Integer.compare(expected4,2),0);
  }

  @Test
  public void testEquals() {
    assertTrue(trendingTopics.equals(trendingTopics));
    assertFalse(trendingTopics.equals(occuranceMap));
    assertNotEquals(trendingTopics,null);
    assertTrue(trendingTopics.equals(trendingTopics2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(occuranceMap);
    assertEquals(trendingTopics.hashCode(),hash);
  }

  @Test
  public void testToString() {
    String expectString = "TrendingTopics{" +
        "occuranceMap=" + occuranceMap +
        '}';
    assertEquals(expectString,trendingTopics.toString());
  }
}