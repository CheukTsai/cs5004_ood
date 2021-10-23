package problem1.service;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest {

  private static final String EMAIL = "--email";
  private static final String EMAIL_TEMPLATE_COMMAND = "--email-template";
  private static final String EMAIL_TEMPLATE = "email-template.txt";

  private static final String LETTER = "--letter";
  private static final String LETTER_TEMPLATE_COMMAND = "--letter-template";
  private static final String LETTER_TEMPLATE = "letter-template.txt";

  private static final String OUTPUT_DIR = "--output-dir";
  private static final String CSV_FILE = "--csv-file";

  private CommandLineParser parser;
  private CommandLineParser parser2;

  @Before
  public void setUp() throws Exception {
    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
  }

  @Test
  public void testAllCorrect() {
    String[] testArgs = new String[]{
        LETTER, LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
  }

  @Test
  public void testAllCorrect2() {
    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
  }


  @Test(expected = CommandLineExceptions.LackArgumentsException.class)
  public void test() {
    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
  }

  @Test(expected = CommandLineExceptions.LackArgumentsException.class)
  public void test2() {
    String[] testArgs = new String[]{
        EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
  }

  @Test(expected = CommandLineExceptions.LackArgumentsException.class)
  public void test3() {
    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
  }

  @Test(expected = CommandLineExceptions.LackArgumentsException.class)
  public void test4() {
    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
  }

  @Test(expected = CommandLineExceptions.LackArgumentsException.class)
  public void test5() {
    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE
    };
    parser = new CommandLineParser(testArgs);
  }

  @Test(expected = CommandLineExceptions.LackArgumentsException.class)
  public void test6() {
    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, CSV_FILE, "nonprofit-supporters.csv"
    };
    parser = new CommandLineParser(testArgs);
  }

  @Test
  public void getEmailCommand() {
    assertTrue(parser.getEmailCommand());
  }

  @Test
  public void getEmailTemplateAddress() {
    assertEquals(EMAIL_TEMPLATE, parser.getEmailTemplateAddress());
  }

  @Test
  public void getLetterCommand() {
    assertTrue(parser.getLetterCommand());
  }

  @Test
  public void getLetterTemplateAddress() {
    assertEquals(LETTER_TEMPLATE, parser.getLetterTemplateAddress());
  }

  @Test
  public void getCsvFile() {
    assertEquals("nonprofit-supporters.csv", parser.getCsvFile());
  }

  @Test
  public void getOutputDirAddress() {
    assertEquals("letters", parser.getOutputDirAddress());
  }

  @Test
  public void testEquals() {
    String[] testArgs = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser2 = new CommandLineParser(testArgs);

    assertTrue(parser.equals(parser));
    assertNotEquals(parser,null);
    assertFalse(parser.equals(CommandLineParser.EMAIL));
    assertTrue(parser.equals(parser2));

    String[] testArgs2 = new String[]{
        "emails", EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser2 = new CommandLineParser(testArgs2);
    assertFalse(parser.equals(parser2));

    String[] testArgs3 = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, "letters",
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser2 = new CommandLineParser(testArgs3);
    assertFalse(parser.equals(parser2));

    String[] testArgs4 = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "Letters", CSV_FILE, "nonprofit-supporters.csv"
    };
    parser2 = new CommandLineParser(testArgs4);
    assertFalse(parser.equals(parser2));

    String[] testArgs5 = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", "--csv-files", "nonprofit-supporters.csv"
    };
    parser2 = new CommandLineParser(testArgs5);
    assertFalse(parser.equals(parser2));

    parser2.setEmailTemplateAddress(LETTER_TEMPLATE);
    assertFalse(parser.equals(parser2));

    String[] testArgs6 = new String[]{
        EMAIL, EMAIL_TEMPLATE_COMMAND, EMAIL_TEMPLATE, LETTER,
        LETTER_TEMPLATE_COMMAND, LETTER_TEMPLATE,
        OUTPUT_DIR, "letters", "--csv-files", "nonprofit-supporters.csv"
    };
    parser2 = new CommandLineParser(testArgs6);
    parser2.setLetterTemplateAddress(EMAIL_TEMPLATE);
    assertFalse(parser.equals(parser2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(parser.getEmailCommand(),parser.getEmailTemplateAddress(),
        parser.getLetterCommand(),parser.getLetterTemplateAddress(),
        parser.getCsvFile(),parser.getOutputDirAddress());
    assertEquals(parser.hashCode(),hash);
  }

  @Test
  public void testToString() {
    String expectedString = "CommandLineParser{" +
        "emailCommand=" + parser.getEmailCommand() +
        ", emailTemplateAddress='" + parser.getEmailTemplateAddress() + '\'' +
        ", letterCommand=" + parser.getLetterCommand() +
        ", letterTemplateAddress='" + parser.getLetterTemplateAddress() + '\'' +
        ", csvFile='" + parser.getCsvFile() + '\'' +
        ", outputDirAddress='" + parser.getOutputDirAddress() + '\'' +
        '}';

    assertEquals(parser.toString(),expectedString);
  }
}