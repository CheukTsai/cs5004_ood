package problem1.service;

/**
 * Separate the line from csv file
 */
public class LineSeparator {

  /**
   * Separate the line from csv file
   *
   * @param line, String
   * @return String[], separated words
   */
  public String[] getInfoSeparated(String line) {
    String tempLine;
    tempLine = line.substring(1, line.length() - 1);
    String[] words = tempLine.split("\",\"");
    return words;
  }

}
