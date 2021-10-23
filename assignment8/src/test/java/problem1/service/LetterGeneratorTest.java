package problem1.service;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import problem1.basicInformation.Person;

public class LetterGeneratorTest {

  private LetterGenerator letterGenerator;
  private Person person;
  private String outputDir;
  private String templatePath;
  @Before
  public void setUp() throws Exception {
    person = new Person("a","a","a","a","a",
        "a","a","a","a","a","a","a");
    outputDir = "testPackage";
    templatePath = "letter-template.txt";
    letterGenerator = new LetterGenerator();
  }

  @Test
  public void create() {
    letterGenerator.create(person, outputDir, templatePath);
  }

  @Test
  public void create2() {
    person = new Person("a","a","a","a","a",
        "a","a","a","a","a","a","a");
    outputDir = "testPackage2";
    templatePath = "letter-template.txt";
    letterGenerator.create(person, outputDir, templatePath);
  }
}