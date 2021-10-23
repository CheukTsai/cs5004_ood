package midtermExam.p2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class ConsNationalParkDirectorySystemTest {

  private String nationalParkID;
  private String nationalParkName;
  private String state;
  private Double area;
  private LocalDate dateParkFounded;
  private String[] visitorCenters;
  private Boolean openYearRound;
  private NationalPark expectedNationalPark;
  private NationalPark expectedNationalPark2;
  private NationalParkDirectorySystem testConsNationalParkDirectorySystem;
  private NationalParkDirectorySystem testConsNationalParkDirectorySystem2;

  @Before
  public void setUp() throws Exception {
    nationalParkID = "zhuocaili";
    nationalParkName = "zhuocai's park";
    state = "MD";
    area = 20.1;
    dateParkFounded = LocalDate.of(1900,10,1);
    visitorCenters = null;
    openYearRound = true;
    expectedNationalPark = new NationalPark(nationalParkID, nationalParkName,
        state, area, dateParkFounded, visitorCenters, openYearRound);
    testConsNationalParkDirectorySystem = new ConsNationalParkDirectorySystem(
        expectedNationalPark, new EmptyNationalParkDirectorySystem());


  }

  @Test
  public void countNationalParks() {
    assertEquals((Integer) 1, testConsNationalParkDirectorySystem.countNationalParks());
  }

  @Test
  public void addNationalPark() {
    assertEquals(testConsNationalParkDirectorySystem,
        testConsNationalParkDirectorySystem.addNationalPark(expectedNationalPark));

    area = 22.2;
    expectedNationalPark = new NationalPark(nationalParkID, nationalParkName,
        state, area, dateParkFounded, visitorCenters, openYearRound);
    testConsNationalParkDirectorySystem =
        testConsNationalParkDirectorySystem.addNationalPark(expectedNationalPark);
    testConsNationalParkDirectorySystem2 = new ConsNationalParkDirectorySystem(
        expectedNationalPark, new EmptyNationalParkDirectorySystem());
    assertEquals(testConsNationalParkDirectorySystem2, testConsNationalParkDirectorySystem);

    nationalParkID = "zhuocaili2";
    nationalParkName = "li's park";
    expectedNationalPark2 = new NationalPark(nationalParkID, nationalParkName,
        state, area, dateParkFounded, visitorCenters, openYearRound);
    testConsNationalParkDirectorySystem =
        testConsNationalParkDirectorySystem.addNationalPark(expectedNationalPark2);
    assertTrue(testConsNationalParkDirectorySystem.containsNationalPark(expectedNationalPark2));
  }

  @Test
  public void findAllNationalParksOpenYearRound() {
    nationalParkID = "anotherPark";
    openYearRound = false;
    expectedNationalPark2 = new NationalPark(nationalParkID, nationalParkName,
        state, area, dateParkFounded, visitorCenters, openYearRound);
    testConsNationalParkDirectorySystem =
        testConsNationalParkDirectorySystem.addNationalPark(expectedNationalPark2);
    testConsNationalParkDirectorySystem2 = new ConsNationalParkDirectorySystem(
        expectedNationalPark, new EmptyNationalParkDirectorySystem());
    testConsNationalParkDirectorySystem =
        testConsNationalParkDirectorySystem.findAllNationalParksOpenYearRound();
    assertEquals(testConsNationalParkDirectorySystem2, testConsNationalParkDirectorySystem);
  }

  @Test
  public void findNationalParkWithNationalParkID() throws InvalidNationalParkIDException{
    nationalParkID = "zhuocaili2";
    nationalParkName = "li's park";
    expectedNationalPark2 = new NationalPark(nationalParkID, nationalParkName,
        state, area, dateParkFounded, visitorCenters, openYearRound);
    testConsNationalParkDirectorySystem =
        testConsNationalParkDirectorySystem.addNationalPark(expectedNationalPark2);
    assertEquals(expectedNationalPark2,
        testConsNationalParkDirectorySystem.findNationalParkWithNationalParkID("zhuocaili2"));
  }

  @Test (expected = InvalidNationalParkIDException.class)
  public void findNationalParkWithNationalParkID2() throws InvalidNationalParkIDException{
    nationalParkID = "zhuocaili2";
    expectedNationalPark2 = testConsNationalParkDirectorySystem.
            findNationalParkWithNationalParkID(nationalParkID);
  }
}