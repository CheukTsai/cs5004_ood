package problem1.service;

import org.junit.Before;
import org.junit.Test;
import problem1.basicInformation.Person;

public class EmailGeneratorTest {

  private EmailGenerator emailGenerator;
  private Person person;
  private String outputDir;
  private String templatePath;
  @Before
  public void setUp() throws Exception {
    person = new Person("a","a","a","a","a",
        "a","a","a","a","a","a","a");
    outputDir = "testPackage";
    templatePath = "email-template.txt";
    emailGenerator = new EmailGenerator();
  }

  @Test
  public void create() {
    emailGenerator.create(person, outputDir, templatePath);
  }

  @Test
  public void create2() {
    person = new Person("a","a","a","a","a",
        "a","a","a","a","a","a","a");
    outputDir = "testPackage2";
    templatePath = "email-template.txt";
    emailGenerator.create(person, outputDir, templatePath);
  }

}