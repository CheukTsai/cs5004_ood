package controllerModules.csvOperation;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Todo;

/**
 * A class that represents CSV writer.
 */
public class CSVWriter {

  /**
   * Create a Todo list.
   * @param todoList List
   * @param directory String
   * @throws IOException throw exception when condition is reached
   */
  public void create(List<Todo> todoList, String directory) throws IOException {
    try {
      FileWriter outputFile = new FileWriter(directory);
      outputFile.write(columnNameWriter() + System.lineSeparator());
      outputFile.flush();
      for (Todo todo : todoList) {
        String line = todoWriter(todo);
        line = line + System.lineSeparator();
        outputFile.write(line);
        outputFile.flush();
      }
      outputFile.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Return a valid Todo column
   * @param todo Todo
   * @return a valid Todo column
   */
  public String todoWriter(Todo todo){
    String parsedDueText = "";
    if ( todo.getDue() == null) parsedDueText = "?";
    else{
      DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/d/uuuu");
      parsedDueText = todo.getDue().format(formatters);
      LocalDate parsedDate = LocalDate.parse(parsedDueText, formatters);
      parsedDueText = parsedDate.format(formatters);
    }
    return "\"" + todo.getId() + "\","
        + "\"" + todo.getText() + "\","
        + "\"" + todo.getCompleted() + "\","
        + "\"" + parsedDueText + "\","
        + "\"" + todo.getPriority() + "\","
        + "\"" + todo.getCategory() + "\"";
  }

  /**
   * Return the column name of csv file.
   * @return String
   */
  public String columnNameWriter() {
    return "\"" + ColumnNamesUtils.ID + "\","
        + "\"" + ColumnNamesUtils.TEXT + "\","
        + "\"" + ColumnNamesUtils.COMPLETED + "\","
        + "\"" + ColumnNamesUtils.DUE + "\","
        + "\"" + ColumnNamesUtils.PRIORITY + "\","
        + "\"" + ColumnNamesUtils.CATEGORY + "\"";

  }
}

