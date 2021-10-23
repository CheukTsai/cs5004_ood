package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import jdk.vm.ci.code.CodeUtil;
import org.junit.Before;
import org.junit.Test;

public class SwimmerTest {

  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breaststroke50mTimes;
  private List<Double> freestyle50mTimes;
  private List<Double> freestyle50mTimes2;
  private Swimmer swimmer;
  private Swimmer swimmer2;

  @Before
  public void setUp() throws Exception {
    name = "a";
    butterfly50mTimes = new ArrayList<>();
    butterfly50mTimes.add(1.0);
    butterfly50mTimes.add(2.0);

    backstroke50mTimes = new ArrayList<>();
    butterfly50mTimes.add(3.0);
    butterfly50mTimes.add(4.0);

    breaststroke50mTimes = new ArrayList<>();
    breaststroke50mTimes.add(5.0);
    breaststroke50mTimes.add(6.0);

    freestyle50mTimes = new ArrayList<>();
    freestyle50mTimes.add(7.0);
    freestyle50mTimes.add(9.0);

    freestyle50mTimes2 = new ArrayList<>();
    freestyle50mTimes2.add(8.0);
    freestyle50mTimes2.add(10.0);

    swimmer = new Swimmer(name, butterfly50mTimes,
        backstroke50mTimes, breaststroke50mTimes, freestyle50mTimes);

    swimmer2 = new Swimmer(name, butterfly50mTimes,
        backstroke50mTimes, breaststroke50mTimes, freestyle50mTimes2);
  }


  @Test
  public void getButterfly50mTimes() {
    assertEquals(butterfly50mTimes, swimmer.getButterfly50mTimes());
  }

  @Test
  public void getFreestyle50mTimes() {
    assertEquals(freestyle50mTimes, swimmer.getFreestyle50mTimes());
  }

  @Test
  public void compareTo() {
    assertEquals(-1, swimmer.compareTo(swimmer2));
  }

  @Test
  public void getFastestSwimTime() {
    assertEquals(9.0, swimmer.getFastestSwimTime(freestyle50mTimes),
        0);
  }

  @Test
  public void testCompare() {
    assertEquals(0, swimmer.fastestButterflyTime.compare(swimmer,swimmer2));

    Comparator<Swimmer> swimmerComparator = new SwimmerComparator<Swimmer>();
    assertEquals(0, swimmerComparator.compare(swimmer, swimmer2));
  }
}