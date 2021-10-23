package controllerModules.commandOpreration;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * A class that represents CommandInfoCollection.
 */
public class CommandInfoCollection {
  private Boolean addTodo = true;
  private String csvFile = "";
  private Boolean completed = false;
  private String todoText = "";
  private LocalDate due = null;
  private Integer priority = 3;
  private String category = "?";
  private Boolean display = false;
  private Boolean showIncomplete = false;
  private Boolean showCategory = false;
  private Boolean sortByDate = false;
  private Boolean sortByPriority = false;
  private String categoryToShow = "";

  private Map<String, String> commandStringInfoMap;
  private List<Integer> completeTodoList;

  /**
   * A constructor that creates a new object of CommandInfoCollection
   * @param commandStringInfoMap - Map, commandStringInfoMap
   */
  public CommandInfoCollection(Map<String, String> commandStringInfoMap) {
    this.commandStringInfoMap = commandStringInfoMap;
    collectAll();
  }

  /**
   * A helper function that collects all commands.
   */
  private void collectAll() {
    collectCsvFile();
    collectText();
    collectDue();
    collectPriority();
    collectCategory();
    collectDisplay();
    collectShowIncomplete();
    collectShowCategory();
    collectSortByDate();
    collectSortByPriority();
  }


  /**
   * A helper function that collects CSV file.
   */
  private void collectCsvFile() {
    if (this.commandStringInfoMap.containsKey(CommandOptions.D_CSV_FILE)) {
      csvFile = this.commandStringInfoMap.get(CommandOptions.D_CSV_FILE);
    }
  }

  /**
   * A helper function that collects Text.
   */
  private void collectText() {
    todoText = this.commandStringInfoMap.get(CommandOptions.D_TODO_TEXT);
  }

  /**
   * A helper function that collect Due command.
   */
  private void collectDue() {
    Integer firstOne = 1;
    Integer zeroZero = 0;
    Integer secondTwo = 2;
    if (this.commandStringInfoMap.containsKey(CommandOptions.D_DUE_DATE)) {
      String info = this.commandStringInfoMap.get(CommandOptions.D_DUE_DATE);
      String[] dateInfo = info.split("/");
      Integer month = Integer.parseInt(dateInfo[zeroZero]);
      Integer date = Integer.parseInt(dateInfo[firstOne]);
      Integer year = Integer.parseInt(dateInfo[secondTwo]);
      due = LocalDate.of(year, month, date);
    } else {
      due = null;
    }
  }

  /**
   * A helper function that collects Priority command.
   */
  private void collectPriority() {
    if (this.commandStringInfoMap.containsKey(CommandOptions.D_PRIORITY)) {
      priority =Integer.parseInt(this.commandStringInfoMap.get(CommandOptions.D_PRIORITY));
    }
  }

  /**
   * A helper function that collects Category command.
   */
  private void collectCategory(){
    if (this.commandStringInfoMap.containsKey(CommandOptions.D_CATEGORY)) {
      category = this.commandStringInfoMap.get(CommandOptions.D_CATEGORY);
    }
  }

  /**
   * A helper function that collects Display command.
   */
  private void collectDisplay(){
    if (this.commandStringInfoMap.containsKey(CommandOptions.S_DISPLAY)) {
      display = true;
    }
  }

  /**
   * A helper function that collects ShowIncomplete command.
   */
  private void collectShowIncomplete(){
    if (this.commandStringInfoMap.containsKey(CommandOptions.S_SHOW_INCOMPLETE)) {
      showIncomplete = true;
    }
  }

  private void collectShowCategory() {
    if (this.commandStringInfoMap.containsKey(CommandOptions.D_SHOW_CATEGORY)){
      showCategory = true;
      categoryToShow = this.commandStringInfoMap.get(CommandOptions.D_SHOW_CATEGORY);
    }

  }

  /**
   * A helper function that collects SortByDate command.
   */
  private void collectSortByDate(){
    if (this.commandStringInfoMap.containsKey(CommandOptions.S_SORT_BY_DATE)) {
      sortByDate = true;
    }
  }

  /**
   * A helper function that collects SortByPriority command.
   */
  private void collectSortByPriority(){
    if (this.commandStringInfoMap.containsKey(CommandOptions.S_SORT_BY_PRIORITY)) {
      sortByPriority = true;
    }
  }

  /**
   * Return csv file
   * @return String, csv file
   */
  public String getCsvFile() {
    return csvFile;
  }

  /**
   * Return completed
   * @return Boolean value
   */
  public Boolean getCompleted() {
    return completed;
  }

  /**
   * Return TodoText
   * @return String
   */
  public String getTodoText() {
    return todoText;
  }

  /**
   * Return due
   * @return LocalDate
   */
  public LocalDate getDue() {
    return due;
  }

  /**
   * Return priority
   * @return Integer
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * Return category
   * @return String
   */
  public String getCategory() {
    return category;
  }

  /**
   * Return display
   * @return Boolean value
   */
  public Boolean getDisplay() {
    return display;
  }

  /**
   * Return ShowIncomplete
   * @return Boolean value
   */
  public Boolean getShowIncomplete() {
    return showIncomplete;
  }

  /**
   * Return ShowCategory
   * @return Boolean value
   */
  public Boolean getShowCategory() {
    return showCategory;
  }

  /**
   * Return Sort By date
   * @return Boolean value
   */
  public Boolean getSortByDate() {
    return sortByDate;
  }

  /**
   * Return SortByPriority
   * @return Boolean value
   */
  public Boolean getSortByPriority() {
    return sortByPriority;
  }

  public String getCategoryToShow() {
    return categoryToShow;
  }

  /**
   * Set complete todo list
   * @param completeTodoList set complete todo list
   */
  public void setCompleteTodoList(List<Integer> completeTodoList) {
    this.completeTodoList = completeTodoList;
  }

  /**
   * Return complete todo list
   * @return completeTodoList
   */
  public List<Integer> getCompleteTodoList() {
    return completeTodoList;
  }
}
