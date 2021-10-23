package problem1.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import problem1.basicInformation.Person;

public class FileGeneratorTest {

  private ArrayList<Person> personInformationList;
  private CSVProcessor csvProcessor;

  private static final String EMAIL = "--email";
  private static final String EMAIL_TEMPLATE_COMMAND = "--email-template";
  private static final String EMAIL_TEMPLATE = "email-template.txt";
  private static final String LETTER = "--letter";
  private static final String LETTER_TEMPLATE_COMMAND = "--letter-template";
  private static final String LETTER_TEMPLATE = "letter-template.txt";
  private static final String OUTPUT_DIR = "--output-dir";
  private static final String CSV_FILE = "--csv-file";
  private CommandLineParser parser;

  private FileGenerator fileGenerator;


  @Before
  public void setUp() throws Exception {
    csvProcessor = new CSVProcessor();
    personInformationList = csvProcessor.collectCSVData("nonprofit-supporters.csv");

    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "testPackage", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
    fileGenerator = new FileGenerator();
  }

  @Test
  public void generateEmail() {
    fileGenerator.generateEmail(parser, personInformationList);
  }

  @Test
  public void generateEmail2() {
    String[] testArgs = new String[]{
        LETTER, LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "testPackage", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
    fileGenerator.generateEmail(parser, personInformationList);
  }

  @Test
  public void generateLetter() {
    fileGenerator.generateLetter(parser, personInformationList);
  }

  @Test
  public void generateLetter2() {
    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE,
        OUTPUT_DIR, "testPackage", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
    fileGenerator.generateLetter(parser, personInformationList);
  }
}