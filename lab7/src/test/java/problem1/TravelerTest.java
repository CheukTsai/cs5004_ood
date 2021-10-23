package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TravelerTest {
  private String firstName;
  private String lastName;
  private List<Destination> traveledDestinations;
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
  private Traveler traveler;
  private Traveler traveler2;


  private String firstName2;
  private String lastName2;
  private List<Destination> traveledDestinations2;

  private Comparator<Traveler> comparator;

  @Before
  public void setUp() throws Exception {
    firstName = "a1";
    lastName = "b1";
    traveledDestinations = new ArrayList<>();

    destinationName = "a";
    country = "b";
    airportCode = "c";
    distanceFromSeattle = 10f;

    destinationName2 = "aa";
    country2 = "bb";
    airportCode2 = "cc";
    distanceFromSeattle2 = 100f;

    destination = new Destination(destinationName,country,airportCode,distanceFromSeattle);
    destination2 = new Destination(destinationName2,country2,airportCode2,distanceFromSeattle2);

    traveledDestinations.add(destination);
    traveledDestinations.add(destination2);

    traveler = new Traveler(firstName,lastName,traveledDestinations);

  }

  @Test
  public void getFirstName() {
    assertEquals(traveler.getFirstName(),firstName);
  }

  @Test
  public void getLastName() {
    assertEquals(traveler.getLastName(),lastName);
  }

  @Test
  public void traveledDestinations() {
    assertEquals(traveler.traveledDestinations(),traveledDestinations);
  }

  @Test
  public void testCompareTo() {
    assertEquals(0,traveler.compareTo(traveler2));
  }
}