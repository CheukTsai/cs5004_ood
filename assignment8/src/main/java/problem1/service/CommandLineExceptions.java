package problem1.service;

/**
 * A class that represents command line exceptions inherit from Exception.
 */
public class CommandLineExceptions extends RuntimeException {

  private static String[] flags;
  private static String[][] explanations;
  private static String usageHelp;
  private static String examples = "\nExamples:\n"
      + "--email --email-template email-template.txt "
      + "--output-dir emails --csv-file customer.csv\n"
      + "--letter --letter-template letter-template.txt "
      + "--output-dir letters --csv-file customer.csv\n";

  /**
   * Return Command line exceptions
   *
   * @param msg, String message
   */
  public CommandLineExceptions(String msg) {
    super(msg + "\nPlease recheck your command line with the manual below." +
        "\n\n" + usageHelp + examples);
  }

  /**
   * A static class that represents LackArgumentsException inherit from CommandLineExceptions.
   */
  public static class LackArgumentsException extends CommandLineExceptions {

    /**
     * Return LackArgumentsException
     *
     * @param msg, String exception message
     */
    public LackArgumentsException(String msg) {
      super(msg);
    }
  }

  static {
    flags = new String[]{
        "REQUIRED ARGUMENTS",
        "--email",
        "--email-template <path/to/file>",
        "--letter",
        "--letter-template <path/to/file>",
        "--output-dir<path/to/folder>",
        "--csv-file <path/to/folder>"
    };
    explanations = new String[][]{
        {"EXPLANATION"},
        {"Generate email messages"},
        {"Need a filename for the email template"},
        {"Generate letters"},
        {"Need a filename for the letter template"},
        {"The folder to store all generated files. This option is required."},
        {"The CSV file to process. This option is required."},
    };
  }

  static {
    usageHelp = "Usage:";
    usageHelp += UsageDisplayHelper.createTable(
        new int[]{flags.length, explanations[0].length},
        flags,
        explanations);
  }

}
