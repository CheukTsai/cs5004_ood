package problem1;

import java.util.ArrayList;
import problem1.basicInformation.Person;
import problem1.service.CSVProcessor;
import problem1.service.CommandLineParser;
import problem1.service.DirCreator;
import problem1.service.FileGenerator;

/**
 * Call other methods and execute.
 */
public class Main {

  public static void main(String[] args) {
    FileGenerator fileGenerator = new FileGenerator();
    CommandLineParser parser = new CommandLineParser(args);
    CSVProcessor csvProcessor = new CSVProcessor();
    DirCreator dirCreator = new DirCreator();

    dirCreator.createNewOutputDir(parser.getOutputDirAddress());
    ArrayList<Person> personInformationList =
        csvProcessor.collectCSVData(parser.getCsvFile());

    fileGenerator.generateEmail(parser, personInformationList);
    fileGenerator.generateLetter(parser, personInformationList);
  }
}
