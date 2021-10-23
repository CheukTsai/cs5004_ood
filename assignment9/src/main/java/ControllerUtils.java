import controllerModules.csvOperation.FileCreatorUtils;
import controllerModules.displayOperation.DisplayOperator;
import controllerModules.commandOpreration.CommandInfoCollection;
import controllerModules.commandOpreration.CommandLineParser;
import controllerModules.csvOperation.CSVReader;
import controllerModules.csvOperation.CSVWriter;
import controllerModules.todoListOperation.TodoListProcessor;
import java.util.List;
import java.util.logging.Logger;
import model.Todo;

/**
 * A class that represents Controller.
 */
public class ControllerUtils {

  /**
   * A hub that can control all the command input.
   * @param args String[]
   * @throws Exception throw exception when condition is reached
   */
  static void create(String[] args) throws Exception {
    String lookup = "";
    while (true) {
      lookup = ViewUtils.getInput("Command >");
      if(lookup.equals("quit")) {
        System.out.println("GoodBye!");
        System.exit(0);
      }
      String[] input = lookup.split(" ");
      controllerBody(input);
    }
  }

  /**
   * A method that can control the process of todo updating and create.
   * @param args String[]
   * @throws Exception throw exception when condition is reached
   */
  static void controllerBody(String[] args) throws Exception {
    CommandLineParser commandLineParser = new CommandLineParser(args);
    CommandInfoCollection commandInfoCollection = commandLineParser.getCommandInfoCollection();
    FileCreatorUtils.create(commandInfoCollection.getCsvFile());
    CSVReader csvReader = new CSVReader();
    List<Todo> todoList = csvReader.collectCSVData(commandInfoCollection.getCsvFile());
    CSVWriter csvWriter = new CSVWriter();
    TodoListProcessor todoListProcessor = new TodoListProcessor(todoList, commandInfoCollection);
    todoList = todoListProcessor.modifyTodoList();
    csvWriter.create(todoList, commandInfoCollection.getCsvFile());
    DisplayOperator displayOperator = new DisplayOperator(commandInfoCollection, todoList);
    displayOperator.print();
  }

}
