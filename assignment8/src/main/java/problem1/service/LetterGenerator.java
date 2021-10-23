package problem1.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import problem1.basicInformation.Person;

/**
 * A class that represents letter generator and implements from the interface of
 * IMaterialGenerator.
 */
public class LetterGenerator implements IMaterialGenerator {

  /**
   * A method that can create template with person, outputDirectory and templatePath.
   *
   * @param person          - Person, person
   * @param outputDirectory - String, pathDriver
   * @param templatePath    - String, templatePath
   */
  public void create(Person person, String outputDirectory, String templatePath) {

    try {
      File template = new File(templatePath);
      BufferedReader inputFile = new BufferedReader(new FileReader(template));
      FileWriter outputFile = new FileWriter(outputDirectory + File.separator +
          person.getFirstName() + "_" + person.getLastName() + "_letter" + ".txt");
      String line;
      while ((line = inputFile.readLine()) != null) {
        line = letterProcessing(person, line);
        line = line + System.lineSeparator();
        outputFile.write(line);
        outputFile.flush();
      }
      outputFile.close();
      inputFile.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * A helper method to process the Person object.
   *
   * @param person       Person
   * @param wordToChange String
   * @return valid words after processing
   */
  private String letterProcessing(Person person, String wordToChange) {
    String temporaryWord;
    temporaryWord = wordToChange.replace("[[first_name]]", person.getFirstName());
    temporaryWord = wordToChange.replace("[[last_name]]", person.getLastName());
    temporaryWord = wordToChange.replace("[[address]]", person.getAddress());
    temporaryWord = wordToChange.replace("[[city]]", person.getCity());
    temporaryWord = wordToChange.replace("[[state]]", person.getState());
    temporaryWord = wordToChange.replace("[[zip]]", person.getZip());
    return temporaryWord;
  }

}
