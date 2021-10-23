package controllerModules.commandOpreration;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * A class that represents CommandOptions.
 */
public class CommandOptions {

  Integer commandSymbolIndex = 0;
  char singleCommandSymbol = 'S';
  Integer singleCommandLength = 1;
  char doubleCommandsSymbol = 'D';
  Integer doubleCommandLength = 2;

  public static final String D_CSV_FILE = "--csv-file";
  public static final String S_ADD_TODO = "--add-todo";
  public static final String D_TODO_TEXT = "--todo-text";
  public static final String S_COMPLETED = "--completed";
  public static final String D_DUE_DATE = "--due";
  public static final String D_PRIORITY = "--priority";
  public static final String D_CATEGORY = "--category";
  public static final String D_COMPLETE_TODO = "--complete-todo";
  public static final String S_DISPLAY = "--display";
  public static final String S_SHOW_INCOMPLETE = "--show-incomplete";
  public static final String D_SHOW_CATEGORY = "--show-category";
  public static final String S_SORT_BY_DATE = "--sort-by-date";
  public static final String S_SORT_BY_PRIORITY = "--sort-by-priority";

  private Map <String, Integer> outputOptionsMap;


  /**
   * Instantiate outputOptionsMap
   */
  public CommandOptions() {
    outputOptionsMap = new HashMap<>();
  }

  /**
   * Return outputOptionsMap
   * @return outputOptionsMap
   * @throws IllegalAccessException throw exception when condition is reached
   */
  public Map<String, Integer> initialize()
      throws IllegalAccessException {
    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field : fields) {
      if (Modifier.isStatic(field.getModifiers())) {
        putCommandLengthInMap(field.getName(), field.get(this).toString());
      }
    }
    return this.outputOptionsMap;
  }


  /**
   * A helper function that helps to put command length to a map.
   * @param commandName String
   * @param command String
   */
  private void putCommandLengthInMap(String commandName, String command) {
    if (commandName.charAt(commandSymbolIndex) == singleCommandSymbol) {
      this.outputOptionsMap.put(command, singleCommandLength);
    }
    if (commandName.charAt(commandSymbolIndex) == doubleCommandsSymbol) {
      this.outputOptionsMap.put(command, doubleCommandLength);
    }
  }

}
