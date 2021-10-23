package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {

    private Integer expectHour;
    private Integer expectMinute;
    private Integer expectSecond;
    private Integer expectHourInvalid1;
    private Integer expectMinuteInvalid1;
    private Integer expectSecondInvalid1;
    private Integer expectHourInvalid2;
    private Integer expectMinuteInvalid2;
    private Integer expectSecondInvalid2;
    private Time testTime1;
    private Time testTime2;
    private Time testTime3;

    @Before
    public void setUp() throws Exception {
      expectHour = 3;
      expectMinute = 2;
      expectSecond = 1;
      expectHourInvalid1 = -1;
      expectMinuteInvalid1 = -2;
      expectSecondInvalid1 = -3;
      expectHourInvalid2 = 24;
      expectMinuteInvalid2 = 60;
      expectSecondInvalid2 = 60;
      testTime1 = new Time(expectHour, expectMinute, expectSecond);
      testTime2 = new Time(expectHourInvalid1, expectMinuteInvalid1, expectSecondInvalid1);
      testTime3 = new Time(expectHourInvalid2, expectMinuteInvalid2, expectSecondInvalid2);
    }

    @Test
    public void getHour() {
      assertEquals(expectHour, testTime1.getHour());
      assertEquals(null, testTime2.getHour());
      assertEquals(null, testTime3.getHour());
    }

    @Test
    public void getMinute() {
      assertEquals(expectMinute, testTime1.getMinute());
      assertEquals(null, testTime2.getMinute());
      assertEquals(null, testTime3.getMinute());
    }

    @Test
    public void getSecond() {
      assertEquals(expectSecond, testTime1.getSecond());
      assertEquals(null, testTime2.getSecond());
      assertEquals(null, testTime3.getSecond());
    }
}