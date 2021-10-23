package controllerModules.todoListOperation;

import controllerModules.commandOpreration.CommandInfoCollection;
import java.util.List;
import model.Todo;
import model.Todo.Builder;

/**
 * A class that represent TodoListProcessor
 */
public class TodoListProcessor {
  private List<Todo> todoList;
  private CommandInfoCollection commandInfoCollection;

  /**
   * A constructor that create a new object of TodoListProcessor
   * @param todoList - List, todoList
   * @param commandInfoCollection - CommandInfoCollection commandInfoCollection
   */
  public TodoListProcessor(List<Todo> todoList,
      CommandInfoCollection commandInfoCollection) {
    this.todoList = todoList;
    this.commandInfoCollection = commandInfoCollection;
  }

  /**
   * Modify todo list
   * @return modified todo list
   */
  public List<Todo> modifyTodoList(){
    todoList.add(createNewTodo());
    for (Todo todo : todoList) {
      completeTodo(todo);
    }
    return todoList;
  }

  /**
   * A helper function that is used to create new todo
   * @return a new Todo object
   */
  private Todo createNewTodo(){
    Builder builder = new Builder();
    builder.setId(todoList.size()+1);
    builder.setText(commandInfoCollection.getTodoText());
    builder.setDue(commandInfoCollection.getDue());
    builder.setCompleted(commandInfoCollection.getCompleted());
    builder.setPriority(commandInfoCollection.getPriority());
    builder.setCategory(commandInfoCollection.getCategory());
    return builder.build();

  }

  /**
   * A helper function that set completed is true when condition is reached
   * @param todo
   */
  private void completeTodo(Todo todo){
    for (Integer id : commandInfoCollection.getCompleteTodoList()) {
      if(id.equals(todo.getId())){
        todo.setCompleted(true);
      }
    }
  }
}

