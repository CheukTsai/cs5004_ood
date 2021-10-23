package controllerModules.csvOperation;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import model.Todo;
import controllerModules.lineOperation.LineSeparator;

import java.io.*;
import java.util.ArrayList;
import model.Todo.Builder;

/**
 * A class that represents CSVReader.
 */
public class CSVReader {

  /**
   * Collect csv data information according those conditions.
   * @param dir String
   * @return a list of csv todo file
   * @throws IllegalAccessException throw exception when condition is reached
   */
  public List<Todo> collectCSVData(String dir) throws IllegalAccessException {
    List<Todo> csvInfoTotal = new ArrayList<>();
    try {
      File template = new File(dir);
      BufferedReader inputFile = new BufferedReader(new FileReader(template));
      int row = 0;
      String line;
      List<List<String>> info = new ArrayList<>();
      while ((line = inputFile.readLine()) != null) {
        LineSeparator lineSeparator = new LineSeparator();
        String[] words = lineSeparator.separate(line);
        if(row == 0) {
          info = generateColumns(words);

        } else {
          addInfo(info, words);
          Todo newTodo = createTodo(info);
          csvInfoTotal.add(newTodo);
        }
        row++;
      }
      inputFile.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return csvInfoTotal;
  }

  /**
   * Return a valid columns.
   * @param words String[]
   * @return a list of list String
   */
  public List<List<String>> generateColumns(String[] words){
    List<List<String>> items = new ArrayList<>();
    for(String word : words) {
      List<String> item = new ArrayList<>();
      item.add(word);
      item.add("");
      items.add(item);
    }
    return items;
  }

  /**
   * Return a list of list Sting storing valid
   * @param items List
   * @param words String[]
   */
  public void addInfo(List<List<String>> items, String[] words){
    int column = 0;
    for(String word : words) {
      if(column == items.size()) return;
      List<String> item = items.get(column);
      item.remove(1);
      item.add(word);
      items.remove(column);
      items.add(column, item);
      column++;
    }
  }

  /**
   * Return createTodo
   * @param items List
   * @return List
   * @throws IllegalAccessException throw exception when condition is reached.
   */
  public Todo createTodo(List<List<String>> items) throws IllegalAccessException {
    Builder builder = new Builder();
    for (List<String> item : items) {
      String columnName = item.get(0);
      String info  = item.get(1);
      convertInfo(columnName, info, builder);
    }
    Todo todo = builder.build();
    return todo;
  }

  /**
   * A helper function that is used to convert valid info.
   * @param columnName String
   * @param info String
   * @param builder Builder
   */
  private void convertInfo(String columnName, String info, Builder builder){
    Integer secondTwo = 2;
    Integer thirdThree = 3;

    if(columnName.contains(ColumnNamesUtils.ID))builder.setId(Integer.parseInt(info));
    if(columnName.contains(ColumnNamesUtils.TEXT)) builder.setText(info);
    if(columnName.contains(ColumnNamesUtils.COMPLETED)) {
      if (info.equals("true")) builder.setCompleted(true);
      else builder.setCompleted(false);
    }
    if(columnName.contains(ColumnNamesUtils.DUE)) {
      if(info.equals("?")) builder.setDue(null);
      else {
        String[] dateInfo = info.split("/");
        Integer month = Integer.parseInt(dateInfo[0]);
        Integer date = Integer.parseInt(dateInfo[1]);
        Integer year = Integer.parseInt(dateInfo[secondTwo]);
        builder.setDue(LocalDate.of(year, month, date));
      }
    }
    if(columnName.contains(ColumnNamesUtils.PRIORITY)) {
      if(info.equals("?")) builder.setPriority(thirdThree);
      else builder.setPriority(Integer.parseInt(info));
    }
    if(columnName.contains(ColumnNamesUtils.CATEGORY)) {
      if(info.equals("?")) builder.setCategory("?");
      else builder.setCategory(info);
    }
  }
}
