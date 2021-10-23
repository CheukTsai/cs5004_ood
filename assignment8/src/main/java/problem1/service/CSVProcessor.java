package problem1.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import problem1.basicInformation.Person;

/**
 * A class that get csv file info to a new ArrayList.
 */
public class CSVProcessor {

  private ArrayList<Person> personInformationList = new ArrayList<>();

  private static final Integer ZERO = 0;
  private static final Integer ONE = 1;
  private static final Integer TWO = 2;
  private static final Integer THREE = 3;
  private static final Integer FOUR = 4;
  private static final Integer FIVE = 5;
  private static final Integer SIX = 6;
  private static final Integer SEVEN = 7;
  private static final Integer EIGHT = 8;
  private static final Integer NINE = 9;
  private static final Integer TEN = 10;
  private static final Integer ELEVEN = 11;

  /**
   * BufferRead csv file info to store and temporary file and return this ArrayList.
   *
   * @param csvFilePath, String cvs file path
   * @return ArrayList personInformationList
   */
  public ArrayList<Person> collectCSVData(String csvFilePath) {
    LineSeparator lineSeparator = new LineSeparator();
    try (BufferedReader in = new BufferedReader(new FileReader(csvFilePath))) {
      String line;
      while ((line = in.readLine()) != null) {

        String[] s = lineSeparator.getInfoSeparated(line);
        Person person = new Person(s[ZERO], s[ONE], s[TWO], s[THREE],
            s[FOUR], s[FIVE], s[SIX], s[SEVEN], s[EIGHT], s[NINE], s[TEN], s[ELEVEN]);
        this.personInformationList.add(person);

      }
    } catch (FileNotFoundException fileNotFoundException) {
      System.out.println("*** OOPS! A file was not found : " +
          fileNotFoundException.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    }
    return this.personInformationList;
  }

  /**
   * {@inheritDoc} Indicates whether some other object passed as an argument is "equal to" the
   * current instance.
   *
   * @param o - an object to compare
   * @return boolean value
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CSVProcessor that = (CSVProcessor) o;
    return Objects.equals(personInformationList, that.personInformationList);
  }

  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int, hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(personInformationList);
  }

  /**
   * {@inheritDoc} Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "CSVProcessor{" +
        "personInformationList=" + personInformationList +
        '}';
  }
}
