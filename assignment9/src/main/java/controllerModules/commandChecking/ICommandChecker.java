package controllerModules.commandChecking;

/**
 * An interface that represents ICommandChecker.
 */
public interface ICommandChecker {

  /**
   * Check all arguments
   * @throws Exception throw exception when condition is reached
   */
  void checkAll()
      throws Exception;

  /**
   * Check AddToDo argument
   * @throws Exception throw exception when condition is reached
   */
  void checkAddToDo() throws Exception;

  /**
   * Check CSVFile argument
   * @throws Exception throw exception when condition is reached
   */
  void checkCSVFile() throws Exception;

  /**
   * Check DueDate argument
   * @throws Exception throw exception when condition is reached
   */
  void checkDueDate() throws Exception;

  /**
   * Check priority argument
   * @throws Exception throw exception when condition is reached
   */
  void checkPriority() throws Exception;

  /**
   * Check CompleteTodo argument
   */
  void checkCompleteTodo();


  /**
   * Check Display argument
   */
  void checkDisplay();


  /**
   * Check ShowIncomplete argument
   * @throws Exception throw exception when condition is reached
   */
  void checkShowIncomplete() throws Exception;


  /**
   * Check ShowCategory
   * @throws Exception throw exception when condition is reached
   */
  void checkShowCategory() throws Exception;

  /**
   * Check SortByDate argument
   * @throws Exception throw exception when condition is reached
   */
  void checkSortByDate() throws Exception;

  /**
   * Check SortByPriority argument
   * @throws Exception throw exception when condition is reached
   */
  void checkSortByPriority() throws Exception;
}
