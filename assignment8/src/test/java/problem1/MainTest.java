package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import problem1.basicInformation.Person;
import problem1.service.CSVProcessor;
import problem1.service.CommandLineParser;
import problem1.service.DirCreator;
import problem1.service.FileGenerator;

public class MainTest {

  private static final String EMAIL = "--email";
  private static final String EMAIL_TEMPLATE_COMMAND = "--email-template";
  private static final String EMAIL_TEMPLATE = "email-template.txt";
  private static final String LETTER = "--letter";
  private static final String LETTER_TEMPLATE_COMMAND = "--letter-template";
  private static final String LETTER_TEMPLATE = "letter-template.txt";
  private static final String OUTPUT_DIR = "--output-dir";
  private static final String CSV_FILE = "--csv-file";

  @Test
  public void main() {
    String[] args = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "testPackage", CSV_FILE, "nonprofit-supporters.csv"
    };
    Main main = new Main();
    main.main(args);
  }
}