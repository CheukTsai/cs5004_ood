package controllerModules.lineOperation;

/**
 * Separate the line from csv file
 */
public class LineSeparator {

  /**
   * Separate the line from csv file
   * @param line String
   * @return String[], separated words
   */
  public String[] separate(String line){
    String tempLine;
    tempLine = line.substring(1,line.length()-1);
    String[] words = tempLine.split("\",\"");
    return words;
  }

}