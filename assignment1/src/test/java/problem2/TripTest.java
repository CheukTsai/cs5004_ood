package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripTest {
    private Time expectStartingTime;
    private Time expectStartingTime2;
    private Time expectEndTime;
    private String expectStartingLocation;
    private String expectEndLocation;
    private Trip testTrip;
    private Trip testTrip2;

    @Before
    public void setUp() throws Exception {
      this.expectStartingTime = new Time(2,0,0);
      this.expectStartingTime2 = new Time(2,30,30);
      this.expectEndTime = new Time(3,15,15);
      this.expectStartingLocation = "Seattle";
      this.expectEndLocation = "Boston";
      this.testTrip = new Trip(expectStartingTime, expectEndTime, expectStartingLocation, expectEndLocation);
      this.testTrip2 = new Trip(expectStartingTime2, expectEndTime, expectStartingLocation, expectEndLocation);
    }

    @Test
    public void getStartingTime() {
      assertEquals(expectStartingTime, testTrip.getStartingTime());
      assertEquals(expectStartingTime2, testTrip2.getStartingTime());
    }

    @Test
    public void getEndTime() {
      assertEquals(expectEndTime, testTrip.getEndTime());
      assertEquals(expectEndTime, testTrip2.getEndTime());
    }

    @Test
    public void getStartingLocation() {
      assertEquals(expectStartingLocation, testTrip.getStartingLocation());
      assertEquals(expectStartingLocation, testTrip2.getStartingLocation());
    }

    @Test
    public void getEndLocation() {
      assertEquals(expectEndLocation, testTrip.getEndLocation());
      assertEquals(expectEndLocation, testTrip2.getEndLocation());
    }

    @Test
    public void getDuration() {
      Time expectDuration = new Time(1, 15,15);
      assertEquals(expectDuration.getHour(), testTrip.getDuration().getHour());
      assertEquals(expectDuration.getMinute(), testTrip.getDuration().getMinute());
      assertEquals(expectDuration.getSecond(), testTrip.getDuration().getSecond());
      Time expectDuration2 = new Time(0,44,45);
      assertEquals(expectDuration2.getHour(), testTrip2.getDuration().getHour());
      assertEquals(expectDuration2.getMinute(), testTrip2.getDuration().getMinute());
      assertEquals(expectDuration2.getSecond(), testTrip2.getDuration().getSecond());
    }
}