package controllerModules.commandChecking;

import controllerModules.exceptions.InvalidCommandExceptions.InvalidArgumentsException;
import controllerModules.exceptions.InvalidCommandExceptions.LackArgumentsException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import controllerModules.commandOpreration.CommandOptions;

/**
 * A class that represents command checker implementing from ICommandChecker.
 */
public class CommandChecker implements ICommandChecker{

  private Map<String, String> commandInfoMap;
  private static final Integer PRI_NUM_ONE = 1;
  private static final Integer PRI_NUM_THREE = 3;


  /**
   * A constructor that create a new object of CommandChecker
   * @param commandInfoMap - Map, commandInfoMap
   */
  public CommandChecker(Map<String, String> commandInfoMap) {
    this.commandInfoMap = commandInfoMap;
  }

  /**
   * Check all arguments according different conditions
   */
  @Override
  public void checkAll()
      throws Exception {
    checkAddToDo();
    checkCSVFile();
    checkDueDate();
    checkPriority();
    checkCompleteTodo();
    checkDisplay();
    checkShowIncomplete();
    checkShowCategory();
    checkSortByDate();
    checkSortByPriority();
  }

  /**
   * Check addToDo argument
   * @throws LackArgumentsException throw exception when condition is reached
   */
  @Override
  public void checkAddToDo() throws Exception {
    if (!commandInfoMap.containsKey(CommandOptions.S_ADD_TODO)) {
      throw new LackArgumentsException("--add-todo must be provided");
    } else {
      if (!commandInfoMap.containsKey(CommandOptions.D_TODO_TEXT)) {
        throw new LackArgumentsException("--todo-text must be provided");
      }
    }
  }

  @Override
  public void checkCSVFile() throws Exception {
    if (!commandInfoMap.containsKey(CommandOptions.D_CSV_FILE)) {
      throw new LackArgumentsException("--csv-file must be provided");
    }
  }

  /**
   * Check DueDate argument
   */
  @Override
  public void checkDueDate() {
    if (commandInfoMap.containsKey(CommandOptions.D_DUE_DATE)) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
      simpleDateFormat.setLenient(false);
      try {
        simpleDateFormat.parse(commandInfoMap.get(CommandOptions.D_DUE_DATE));
      } catch (ParseException e) {
        System.out.println("Your due date is in an invalid format!");
      }
    }
  }

  /**
   * Check priority argument
   * @throws InvalidArgumentsException throw exception when condition is reached
   */
  @Override
  public void checkPriority() throws Exception {
    if (commandInfoMap.containsKey(CommandOptions.D_PRIORITY)) {
      try {
        int priorityNum = Integer.parseInt(commandInfoMap.get(CommandOptions.D_PRIORITY));
        if (priorityNum < PRI_NUM_ONE || priorityNum > PRI_NUM_THREE) throw new
            InvalidArgumentsException("Priority should be between 1 and 3!");
      } catch (NumberFormatException e) {
        throw new InvalidArgumentsException("Priority must be an Integer");
      }
    }
  }

  /**
   * Check CompleteToDo argument
   */
  @Override
  public void checkCompleteTodo() {
  }

  /**
   * Check Display argument
   */
  @Override
  public void checkDisplay() {
  }

  /**
   * Check ShowIncomplete argument
   * @throws LackArgumentsException throw exception when condition is reached
   */
  @Override
  public void checkShowIncomplete() throws Exception {
    if (commandInfoMap.containsKey(CommandOptions.S_SHOW_INCOMPLETE)){
      if (!commandInfoMap.containsKey(CommandOptions.S_DISPLAY)) {
        throw new LackArgumentsException("No display command is provided!");
      }
    }
  }

  /**
   * Check ShowCategory argument
   * @throws LackArgumentsException throw exception when condition is reached
   */
  @Override
  public void checkShowCategory() throws Exception {
    if (commandInfoMap.containsKey(CommandOptions.D_SHOW_CATEGORY)){
      if (!commandInfoMap.containsKey(CommandOptions.S_DISPLAY)) {
        throw new LackArgumentsException("No display command is provided!");
      }
    }
  }

  /**
   * Check ShortByDate argument
   * @throws LackArgumentsException throw exception when condition is reached
   * @throws InvalidArgumentsException throw exception when condition is reached
   */
  @Override
  public void checkSortByDate() throws Exception {
    if (commandInfoMap.containsKey(CommandOptions.S_SORT_BY_DATE)){
      if (!commandInfoMap.containsKey(CommandOptions.S_DISPLAY)) {
        throw new LackArgumentsException("No display command is provided!");
      }
      if (commandInfoMap.containsKey(CommandOptions.S_SORT_BY_PRIORITY)) {
        throw new InvalidArgumentsException(
            "Cannot sort by date and priority at the same time!");
      }
    }
  }

  /**
   * Check SortByPriority argument
   * @throws LackArgumentsException throw exception when condition is reached
   */
  @Override
  public void checkSortByPriority() throws Exception {
    if (commandInfoMap.containsKey(CommandOptions.S_SORT_BY_PRIORITY)){
      if (!commandInfoMap.containsKey(CommandOptions.S_DISPLAY)) {
        throw new LackArgumentsException("No display command is provided!");
      }
    }
  }
}
