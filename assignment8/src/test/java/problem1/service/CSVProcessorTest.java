package problem1.service;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import problem1.basicInformation.Person;

public class CSVProcessorTest {

  private ArrayList<Person> personInformationList;
  private CSVProcessor csvProcessor;
  private CSVProcessor csvProcessor2;

  @Before
  public void setUp() throws Exception {
    csvProcessor = new CSVProcessor();
  }

  @Test
  public void collectCSVData() {
    personInformationList = csvProcessor.collectCSVData("nonprofit-supporters.csv");
  }

  @Test
  public void collectCSVData2() {
    personInformationList = csvProcessor.collectCSVData("profit-supporters.csv");
  }

  @Test
  public void testEquals() {
    csvProcessor2 = new CSVProcessor();

    assertTrue(csvProcessor.equals(csvProcessor));
    assertNotEquals(csvProcessor,null);
    assertFalse(csvProcessor.equals("profit-supporters.csv"));
    assertTrue(csvProcessor.equals(csvProcessor2));
  }

  @Test
  public void testHashCode() {
    personInformationList = csvProcessor.collectCSVData("nonprofit-supporters.csv");
    int hash = Objects.hash(personInformationList);
    assertEquals(csvProcessor.hashCode(),hash);
  }

  @Test
  public void testToString() {
    personInformationList = csvProcessor.collectCSVData("nonprofit-supporters.csv");
    String expectedString = "CSVProcessor{" +
        "personInformationList=" + personInformationList +
        '}';

    assertEquals(csvProcessor.toString(),expectedString);
  }
}