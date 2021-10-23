package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TravelerIteratorTest {
  private String firstName;
  private String firstName2;
  private String lastName;
  private Traveler traveler;
  private Traveler traveler2;

  private Traveler traveler3;
  private List<Traveler> travelerList;
  private TravelerIterator travelerIterator;
  private TravelerIterator travelerIterator2;

  private List<Destination> traveledDestinations;
  private List<Destination> traveledDestinations2;
  private String destinationName;
  private String country;
  private String airportCode;
  private Float distanceFromSeattle;
  private String destinationName2;
  private String country2;
  private String airportCode2;
  private Float distanceFromSeattle2;
  private Destination destination;
  private Destination destination2;

  @Before
  public void setUp() throws Exception {
    firstName = "a1";
    firstName2 = "a2";
    lastName = "b1";
    traveledDestinations = new ArrayList<>();
    traveledDestinations2 = new ArrayList<>();

    destinationName = "US";
    country = "US";
    airportCode = "c";
    distanceFromSeattle = 10f;

    destinationName2 = "CN";
    country2 = "CN";
    airportCode2 = "cc";
    distanceFromSeattle2 = 100f;

    destination = new Destination(destinationName,country,airportCode,distanceFromSeattle);
    destination2 = new Destination(destinationName2,country2,airportCode2,distanceFromSeattle2);

    traveledDestinations.add(destination);

    traveledDestinations2.add(destination);
    traveledDestinations2.add(destination2);


    traveler = new Traveler(firstName,lastName,traveledDestinations);
    traveler2 = new Traveler(firstName,lastName,traveledDestinations2);

    traveler3 = new Traveler(firstName,lastName,traveledDestinations2);
    traveler3 = new Traveler(firstName,"abc",traveledDestinations2);

    travelerList = new ArrayList<>();
    travelerList.add(traveler);


    travelerIterator = new TravelerIterator(travelerList);

    travelerList.add(traveler2);
    travelerIterator2 = new TravelerIterator(travelerList);

  }

  @Test
  public void hasNext() {
    assertTrue(travelerIterator2.hasNext());
  }

  @Test
  public void next() {
    assertEquals(traveler ,travelerIterator2.next());
  }

  @Test(expected = RuntimeException.class)
  public void testRemove() throws RuntimeException{
    travelerIterator.remove();
  }
}