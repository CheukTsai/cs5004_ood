package problem3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import problem2.Swimmer;

public class SwimmerIteratorTest {

  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> butterfly50mTimes2;
  private List<Double> backstroke50mTimes;
  private List<Double> breaststroke50mTimes;
  private List<Double> freestyle50mTimes;
  private List<Double> freestyle50mTimes2;
  private Swimmer swimmer;
  private Swimmer swimmer2;
  private List<Swimmer> swimmerList;
  private SwimmerIterator swimmerIterator;

  @Before
  public void setUp() throws Exception {
    name = "a";
    butterfly50mTimes = new ArrayList<>();
    butterfly50mTimes.add(1.0);
    butterfly50mTimes.add(2.0);
    butterfly50mTimes.add(2.0);
    butterfly50mTimes.add(2.0);
    butterfly50mTimes.add(2.0);

    butterfly50mTimes2 = new ArrayList<>();
    butterfly50mTimes2.add(1.0);
    butterfly50mTimes2.add(1111.0);

    backstroke50mTimes = new ArrayList<>();
    backstroke50mTimes.add(3.0);


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

    swimmer2 = new Swimmer(name, butterfly50mTimes2,
        backstroke50mTimes, breaststroke50mTimes, freestyle50mTimes2);

    swimmerList = new ArrayList<>();
    swimmerList.add(swimmer);
    swimmerList.add(swimmer2);

    swimmerIterator = new SwimmerIterator(swimmerList);
  }

  @Test
  public void hasNext() {
    assertTrue(swimmerIterator.hasNext());
    swimmerList = new ArrayList<>();
    swimmerList.add(swimmer2);
    swimmerIterator = new SwimmerIterator(swimmerList);
    assertFalse(swimmerIterator.hasNext());
  }

  @Test
  public void next() {
    assertEquals(swimmer ,swimmerIterator.next());
  }

}