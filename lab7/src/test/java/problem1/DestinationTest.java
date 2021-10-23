package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DestinationTest {
  private String destinationName;
  private String country;
  private String airportCode;
  private Float distanceFromSeattle;
  private Destination destination;

  @Before
  public void setUp() throws Exception {
    destinationName = "a";
    country = "b";
    airportCode = "c";
    distanceFromSeattle = 10f;
    destination = new Destination(destinationName,country,airportCode,distanceFromSeattle);
  }

  @Test
  public void getDestinationName() {
    assertEquals(destinationName,destination.getDestinationName());
  }

  @Test
  public void getCountry() {
    assertEquals(country,destination.getCountry());
  }

  @Test
  public void getAirportCode() {
    assertEquals(airportCode,destination.getAirportCode());
  }

  @Test
  public void getDistanceFromSeattle() {
    assertEquals(distanceFromSeattle,destination.getDistanceFromSeattle());
  }
}