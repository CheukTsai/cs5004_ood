package controllerModules.displayOperation;

import controllerModules.commandOpreration.CommandInfoCollection;
import controllerModules.csvOperation.CSVWriter;
import java.util.Comparator;
import java.util.List;
import model.Todo;

/**
 * A class that represents DisplayOperator.
 */
public class DisplayOperator {
  private CommandInfoCollection commandInfoCollection;
  private List<Todo> todoList;

  /**
   * A constructor that creates a new object of DisplayOperator
   * @param commandInfoCollection - CommandInfoCollection, commandInfoCollection
   * @param todoList - List, todoList
   */
  public DisplayOperator(
      CommandInfoCollection commandInfoCollection, List<Todo> todoList) {
    this.commandInfoCollection = commandInfoCollection;
    this.todoList = todoList;
  }

  /**
   * Print csv file info.
   */
  public void print(){
    CSVWriter csvWriter = new CSVWriter();
    if(commandInfoCollection.getDisplay()) {
      System.out.println(csvWriter.columnNameWriter());
      if(commandInfoCollection.getShowIncomplete()) {
        for(Todo todo : todoList){
          if(!todo.getCompleted()) {
            System.out.println(csvWriter.todoWriter(todo));
          }
        }
      }
      else if(commandInfoCollection.getShowCategory()) {
        for(Todo todo : todoList){
          if(todo.getCategory().equals(commandInfoCollection.getCategoryToShow())) {
            System.out.println(csvWriter.todoWriter(todo));
          }
        }
      }
      else if(!sortByDate() && !sortByPriority()) {
        for(Todo todo : todoList){
          System.out.println(csvWriter.todoWriter(todo));
        }
      }
    }




  }

  /**
   * Sort by date of the todo file.
   * @return Boolean value
   */
  private Boolean sortByDate() {
    CSVWriter csvWriter = new CSVWriter();
    if (commandInfoCollection.getSortByDate()) {
      List<Todo> newTodoList = createListSortByDate(todoList);
      for(Todo todo : newTodoList){
        System.out.println(csvWriter.todoWriter(todo));
      }
    }
    return commandInfoCollection.getSortByDate();
  }

  /**
   * Sort by priority of the todo file
   * @return Boolean value
   */
  private Boolean sortByPriority() {
    CSVWriter csvWriter = new CSVWriter();
    if(commandInfoCollection.getSortByPriority()) {
      List<Todo> newTodoList = createListSortByPriority(todoList);
      for(Todo todo : newTodoList){
        System.out.println(csvWriter.todoWriter(todo));
      }
    }
    return commandInfoCollection.getSortByPriority();
  }

  /**
   * A helper function that creates a list sorting by date.
   * @param todoList List<Todo>
   * @return a valid list of todo
   */
  private List<Todo> createListSortByDate(List<Todo> todoList) {
    List<Todo> outputList = todoList;
    outputList.sort(new Comparator<Todo>() {
      @Override
      public int compare(Todo o1, Todo o2) {
        if(o1.getDue() == null && o2.getDue() == null) return 0;
        else if (o1.getDue() == null && o2.getDue() != null) return 1;
        else if (o1.getDue() != null && o2.getDue() == null) return -1;
        else if(o1.getDue().isAfter(o2.getDue())){
          return 1;
        } else if (o1.getDue().isEqual(o2.getDue())){
          return 0;}
        else return -1;
      }
    });
    return outputList;
  }

  /**
   * A helper function that creates a list sorting by priority.
   * @param todoList List<Todo>, todo list
   * @return a valid list of todo
   */
  private List<Todo> createListSortByPriority(List<Todo> todoList) {
    List<Todo> outputList = todoList;
    outputList.sort(new Comparator<Todo>() {
      @Override
      public int compare(Todo o1, Todo o2) {
        if (o1.getPriority() > o2.getPriority()) {
          return 1;
        } else if (o1.getPriority() < o2.getPriority()) {
          return -1;
        } else return 0;
      }
    });
    return outputList;
  }
}
