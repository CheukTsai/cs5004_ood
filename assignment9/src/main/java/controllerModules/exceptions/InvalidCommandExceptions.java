package controllerModules.exceptions;

/**
 * A class that represents command line exceptions inherit from Exception.
 */
public class InvalidCommandExceptions extends Exception {

  private static String[] flags;
  private static String[][] explanations;
  private static String usageHelp;
  private static String examples = "\nExamples:\n"
      + "--complete-todo 2 --csv-file todos.csv"
      + "--show-category category --csv-file todos.csv"
      + "--display --show-incomplete --csv-file todos.csv"
      + "--display --sort-by-date --csv-file todos.csv"
      + "--display --sort-by-priority --csv-file todos.csv"
      + "--show-incomplete --csv-file todos.csv"
      + "--show-incomplete --display --csv-file todos.csv"
      + "--add-todo --todo-text Finish HW9"
      + "--add-todo --category JAVA Assignment9"
      + "--add-todo --todo-text Finish HW9 --completed"
      + "--add-todo --todo-text Finish HW9 --priority 1"
      + "--add-todo --todo-text Finish HW9 --priority 1 --due 08/09/2021";


  /**
   * Return Command line exceptions
   *
   * @param message, String message
   */
  public InvalidCommandExceptions(String message) {
    super(message + "\nPlease recheck your command line with the manual below." +
        "\n\n" + usageHelp + examples);
  }

  /**
   * A static class that represents InvalidArgumentsException inherit from Exception.
   */
  public static class InvalidArgumentsException extends Exception {

    public InvalidArgumentsException(String message) {
      super(message + "\nPlease recheck your command line with the manual below." +
          "\n\n" + usageHelp + examples);
    }
  }


  /**
   * A static class that represents LackArgumentsException inherit from Exception.
   */
  public static class LackArgumentsException extends Exception {

    /**
     * Return LackArgumentsException
     *
     * @param msg, String exception message
     */
    public LackArgumentsException(String msg) {
      super(msg + "\nPlease recheck your command line with the manual below." +
          "\n\n" + usageHelp + examples);
    }
  }


  static {
    flags = new String[]{
        "REQUIRED ARGUMENTS",
        "--csv-file <path/to/file>",
        "--add-todo",
        "--todo-text <description of todo>",
        "--completed",
        "--due <due date>",
        "--priority <1, 2, or 3>",
        "--category <a category name>",
        "--complete-todo <id>",
        "--display",
        "--show-incomplete",
        "--show-category <category>",
        "--sort-by-date",
        "--sort-by-priority"
    };

    explanations = new String[][]{
        {"EXPLANATION"},
        {"The CSV file containing the todos. This option is required"},
        {"Add a new todo. If this option is provided, then --todo-text must also be provided"},
        {"A description of the todo"},
        {"(Optional) Sets the completed status of a new todo to true"},
        {"(Optional) Sets the due date of a new todo. You may choose how the date should "
            + "be formatted"},
        {"(Optional) Sets the priority of a new todo. The value can be 1, 2, or 3"},
        {"(Optional) Sets the category of a new todo. The value can be any String. Categories "
            + "do not need to be pre-defined"},
        {"Mark the Todo with the provided ID as complete"},
        {"Display todos. If none of the following optional arguments are provided, "
            + "displays all todos"},
        {"(Optional) If --display is provided, only incomplete todos should be displayed"},
        {"(Optional) If --display is provided, only todos with the given category "
            + "should be displayed."},
        {"(Optional) If --display is provided, sort the list of todos by date order (ascending). "
            + "Cannot be combined with --sort-by-priority."},
        {"(Optional) If --display is provided, sort the list of todos by priority (ascending). "
            + "Cannot be combined with --sort-by-date"}
    };
  }

  static {
    usageHelp = "Usage:";
    try {
      usageHelp += UsageDisplayHelper.createTable(
          new int[]{flags.length, explanations[0].length},
          flags,
          explanations);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
