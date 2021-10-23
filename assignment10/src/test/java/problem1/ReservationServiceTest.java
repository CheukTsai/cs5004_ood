package problem1;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ReservationServiceTest {
  private String name;
  private Integer numberOfRows;
  private Integer numberOfSeatsInRow;
  private Theater theater;
  private  ReservationService reservationService;
  private static final Integer[] ROWS_WITH_WHEELCHAIR_ACCESSIBILITY = {1, 3, 5};

  @Before
  public void setUp() throws Exception {
    name =  "Tsai's Theater";
    numberOfRows = 5;
    numberOfSeatsInRow = 7;
    reservationService = new ReservationService();
    theater = new Theater(name, numberOfRows,
        numberOfSeatsInRow, ROWS_WITH_WHEELCHAIR_ACCESSIBILITY);
  }

  @Test
  public void show() {
    reservationService.show(theater);
  }



  @Test
  public void reserve() {
    reservationService.reserve(theater, 1, "a", false);
    reservationService.reserve(theater, 8, "a", false);
    reservationService.reserve(theater, 7, "a", true);
  }

//  @Test
//  public void done() {
//    reservationService.done();
//  }

}