package problem1;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

public class ReservationSystemTest {

  @Test(expected = NoSuchElementException.class)
  public void start() {
    ReservationSystem.start();
  }
}