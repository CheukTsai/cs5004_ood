package midtermExam.p2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import jdk.vm.ci.meta.Local;
import org.junit.Before;
import org.junit.Test;

public class EmptyNationalParkDirectorySystemTest {

  private String nationalParkID;
  private String nationalParkName;
  private String state;
  private Double area;
  private LocalDate dateParkFounded;
  private String[] visitorCenters;
  private Boolean openYearRound;
  private NationalPark expectedNationalPark;
  private NationalParkDirectorySystem testEmptyNationalParkDirectorySystem;
  private NationalParkDirectorySystem expectedEmptyNationalParkDirectorySystem;

  @Before
  public void setUp() throws Exception {
    testEmptyNationalParkDirectorySystem =
        NationalParkDirectorySystem.createEmptyNationalParkDirectorySystem();
  }

  @Test
  public void add(){
    nationalParkID = "zhuocaili";
    nationalParkName = "zhuocai's park";
    state = "MD";
    area = 20.1;
    dateParkFounded = LocalDate.of(1900,10,1);
    visitorCenters = null;
    openYearRound = true;
    expectedNationalPark = new NationalPark(nationalParkID, nationalParkName,
        state, area, dateParkFounded, visitorCenters, openYearRound);
    assertEquals(testEmptyNationalParkDirectorySystem.addNationalPark(expectedNationalPark),
        new ConsNationalParkDirectorySystem(expectedNationalPark,
            testEmptyNationalParkDirectorySystem));

  }

  @Test
  public void countNationalParks() {
    assertEquals((Integer) 0, testEmptyNationalParkDirectorySystem.countNationalParks());
  }

  @Test
  public void findAllNationalParksOpenYearRound() {
    expectedEmptyNationalParkDirectorySystem = new EmptyNationalParkDirectorySystem();
    assertEquals(expectedEmptyNationalParkDirectorySystem,
        testEmptyNationalParkDirectorySystem.findAllNationalParksOpenYearRound());
  }

  @Test
  public void findNationalParkWithNationalParkID() {
    expectedEmptyNationalParkDirectorySystem = new EmptyNationalParkDirectorySystem();
    assertEquals(expectedEmptyNationalParkDirectorySystem,
        testEmptyNationalParkDirectorySystem.findAllNationalParksOpenYearRound());
  }
}