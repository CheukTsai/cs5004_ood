package problem1.service;

import java.util.Objects;

/**
 * A class that represents command line parser.
 */
public class CommandLineParser {

  public static final String EMAIL = "--email";
  public static final String EMAIL_TEMPLATE_COMMAND = "--email-template";
  public static final String EMAIL_TEMPLATE = "email-template.txt";

  public static final String LETTER = "--letter";
  public static final String LETTER_TEMPLATE_COMMAND = "--letter-template";
  public static final String LETTER_TEMPLATE = "letter-template.txt";

  public static final String OUTPUT_DIR = "--output-dir";
  public static final String CSV_FILE = "--csv-file";
  public static final Integer CSV_SUFFIX_LENGTH = 4;

  private Boolean emailCommand = false;
  private String emailTemplateAddress = "";

  private Boolean letterCommand = false;
  private String letterTemplateAddress = "";

  private String csvFile = "";
  private String outputDirAddress = "";

  /**
   * A constructor that create a new object with processArgs and checkArguments
   *
   * @param args String[], args of new object
   * @throws CommandLineExceptions throw exception when condition is not matched
   */
  public CommandLineParser(String[] args) {
    this.processArgs(args);
    this.checkArguments();
  }

  /**
   * Process args of each template file
   *
   * @param args String[]
   * @throws CommandLineExceptions throw exception when condition is not matched
   */
  private void processArgs(String[] args) {
    int length = args.length;
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case EMAIL:
          this.emailCommand = true;
          break;
        case LETTER:
          this.letterCommand = true;
          break;
        case EMAIL_TEMPLATE_COMMAND:
          i++;
          checkArgsLength(i, length);
          this.emailTemplateAddress = args[i];
          break;
        case LETTER_TEMPLATE_COMMAND:
          i++;
          checkArgsLength(i, length);
          this.letterTemplateAddress = args[i];
          break;
        case OUTPUT_DIR:
          i++;
          checkArgsLength(i, length);
          this.outputDirAddress = args[i];
          checkNoArg(this.outputDirAddress);
          break;
        case CSV_FILE:
          i++;
          checkArgsLength(i, length);
          this.csvFile = args[i];
          checkNoArg(this.csvFile);
          break;
        default:
          break;
      }
    }
  }

  /**
   * Helper function to check the length of args.
   *
   * @param curr   int, curr length
   * @param length int
   * @throws CommandLineExceptions throw exception when condition is not matched
   */
  private void checkArgsLength(int curr, int length) {
    if (curr >= length) {
      throw new CommandLineExceptions.LackArgumentsException("Error: Lack of arguments. ");
    }
  }

  /**
   * A helper method that is used to check arguments.
   *
   * @param arg
   */
  private void checkNoArg(String arg) {
    switch (arg) {
      case EMAIL:
      case LETTER:
      case EMAIL_TEMPLATE_COMMAND:
      case LETTER_TEMPLATE_COMMAND:
      case OUTPUT_DIR:
      case CSV_FILE:
        throw new CommandLineExceptions.LackArgumentsException("Error: Lack of file path");
      default:
        break;
    }
  }

  /**
   * A helper method that is used to check arguments.
   */
  private void checkArguments() {
    if (!this.emailCommand && !this.letterCommand) {
      throw new CommandLineExceptions.LackArgumentsException("Error: No command is provided.");
    }

    if (this.emailCommand && !this.emailTemplateAddress.equals(EMAIL_TEMPLATE)) {
      throw new CommandLineExceptions.LackArgumentsException("Error: --email provided "
          + "but no --email-template was given.");
    }

    if (this.letterCommand && !this.letterTemplateAddress.equals(LETTER_TEMPLATE)) {
      throw new CommandLineExceptions.LackArgumentsException("Error: --letter provided "
          + "but no --letter-template was given.");
    }
  }

  /**
   * Return Boolean value if get email command, otherwise false
   *
   * @return Boolean value
   */
  public Boolean getEmailCommand() {
    return emailCommand;
  }

  /**
   * Return email template address
   *
   * @return String, email template address
   */
  public String getEmailTemplateAddress() {
    return emailTemplateAddress;
  }

  /**
   * Return Boolean value if get letter command, otherwise false
   *
   * @return Boolean value
   */
  public Boolean getLetterCommand() {
    return letterCommand;
  }

  /**
   * Return letter template address
   *
   * @return String, letter template address
   */
  public String getLetterTemplateAddress() {
    return letterTemplateAddress;
  }

  /**
   * Return csv file
   *
   * @return String, csv file
   */
  public String getCsvFile() {
    return csvFile;
  }

  /**
   * Return out put dir address
   *
   * @return String, out put dir address
   */
  public String getOutputDirAddress() {
    return outputDirAddress;
  }

  /**
   * {@inheritDoc} Indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return boolean value
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandLineParser that = (CommandLineParser) o;
    return Objects.equals(getEmailCommand(), that.getEmailCommand()) && Objects
        .equals(getEmailTemplateAddress(), that.getEmailTemplateAddress()) && Objects
        .equals(getLetterCommand(), that.getLetterCommand()) && Objects
        .equals(getLetterTemplateAddress(), that.getLetterTemplateAddress()) && Objects
        .equals(getCsvFile(), that.getCsvFile()) && Objects
        .equals(getOutputDirAddress(), that.getOutputDirAddress());
  }

  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int, hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getEmailCommand(), getEmailTemplateAddress(), getLetterCommand(),
        getLetterTemplateAddress(), getCsvFile(), getOutputDirAddress());
  }

  /**
   * {@inheritDoc} Returns an String representation of the object.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
        "emailCommand=" + emailCommand +
        ", emailTemplateAddress='" + emailTemplateAddress + '\'' +
        ", letterCommand=" + letterCommand +
        ", letterTemplateAddress='" + letterTemplateAddress + '\'' +
        ", csvFile='" + csvFile + '\'' +
        ", outputDirAddress='" + outputDirAddress + '\'' +
        '}';
  }

  /**
   * Changes the email template address (helper, used for testing)
   *
   * @param emailTemplateAddress the email template address
   */
  public void setEmailTemplateAddress(String emailTemplateAddress) {
    this.emailTemplateAddress = emailTemplateAddress;
  }

  /**
   * Changes the letter template address (helper, used for testing)
   *
   * @param letterTemplateAddress the letter template address
   */
  public void setLetterTemplateAddress(String letterTemplateAddress) {
    this.letterTemplateAddress = letterTemplateAddress;
  }
}