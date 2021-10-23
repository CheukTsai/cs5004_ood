package problem1.service;

import java.util.ArrayList;
import problem1.basicInformation.Person;

/**
 * A class that represents the file generator
 */
public class FileGenerator {

  /**
   * A method that is used to generate emails.
   *
   * @param parser CommandLineParser
   * @param list   ArrayList
   */
  public void generateEmail(CommandLineParser parser, ArrayList<Person> list) {
    if (parser.getEmailCommand()) {
      IMaterialGenerator generator = new EmailGenerator();
      for (Person person : list) {
        generator.create(person, parser.getOutputDirAddress(),
            parser.getEmailTemplateAddress());
      }
    }
  }

  /**
   * A method that is used to generate letters.
   *
   * @param parser CommandLineParser
   * @param list   ArrayList
   */
  public void generateLetter(CommandLineParser parser, ArrayList<Person> list) {
    if (parser.getLetterCommand()) {
      IMaterialGenerator generator = new LetterGenerator();
      for (Person person : list) {
        generator.create(person, parser.getOutputDirAddress(),
            parser.getLetterTemplateAddress());
      }
    }
  }

}
