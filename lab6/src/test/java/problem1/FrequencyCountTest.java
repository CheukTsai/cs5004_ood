package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class FrequencyCountTest {

  private List<Integer> listInts;
  private Map<Integer, Float> expectedFrequencies;

  @Before
  public void setUp() throws Exception {
    listInts = new ArrayList<>();
    listInts.add(1);
    listInts.add(1);
    listInts.add(1);
    listInts.add(2);
    listInts.add(2);
    expectedFrequencies = new HashMap<>();
  }

  @Test
  public void findFrequencies() {
    expectedFrequencies.put(1, 0.6f);
    expectedFrequencies.put(2, 0.4f);
    FrequencyCount fc = new FrequencyCount();
    assertEquals(expectedFrequencies, fc.findFrequencies(listInts));
  }
}