
import java.util.NoSuchElementException;
import org.junit.Test;

public class ControllerUtilsTest {


  @Test(expected = NoSuchElementException.class)
  public void create() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv"};
    ControllerUtils.create(args);
  }

  @Test
  public void controllerBody() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody0() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--dis"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody1() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file",
        "todos.csv", "--priority", "1"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody121() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--display"};
    ControllerUtils.controllerBody(args);
  }


  @Test(expected = Exception.class)
  public void controllerBody2() throws Exception {
    String[] args = {"--todo-text", "go to school", "--csv-file", "todos.csv"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody3() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody4() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "2", "--category", "nothing", "--display", "--sort-by-priority"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody5() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "--due",
        "askdhajk"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody6() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority", "15"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody621() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority", "0"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody7() throws Exception {
    String[] args = {"--add-todo", "--csv-file", "--priority", "1"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody8() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "a", "--category", "nothing", "--display", "--sort-by-priority"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBodyX() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "a", "--category", "nothing", "--display", "--sort-by-priority", "--due", "111-1-1"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBodyY() throws Exception {
    String[] args = {"--add-todo", "--csv-file", "todos.csv", "--priority",
        "a", "--category", "nothing", "--display", "--sort-by-priority"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody9() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/8/2008", "--display", "--sort-by-priority"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody921() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/8/2008", "--display", "--sort-by-date"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody10() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/8/2008", "--display", "--sort-by-priority",
        "--show-incomplete",
        "--show-category", "school"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody11() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/8/2008", "--display",
        "--show-category", "school"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody12() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/8/2008", "--display",
        "--show-category", "school", "--complete-todo", "1"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody1201() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/8/2008", "--display",
        "--show-category", "school", "--complete-todo", "a"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody13() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/111/2008", "--display",
        "--show-category", "school", "--complete-todo", "1"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody14() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/1/2008", "--display",
        "--show-category", "school", "--complete-todo", "1", "--sort-by-date",
        "--sort-by-priority"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody15() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/1/2008", "--display",
        "--show-category", "school", "--complete-todo", "1", "--sort-by-date"};
    ControllerUtils.controllerBody(args);
  }

  @Test
  public void controllerBody16() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/1/2008", "--display",
        "--show-category", "school", "--complete-todo", "1", "--sort-by-priority"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody17() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/1/2008",
        "--show-category", "school", "--complete-todo", "1", "--sort-by-priority"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody18() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/1/2008",
        "--show-incomplete", "school", "--complete-todo", "1", "--sort-by-priority"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody19() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/1/2008", "school", "--complete-todo", "1",
        "--sort-by-priority"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody20() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/1/2008", "school", "--complete-todo", "1",
        "--sort-by-date"};
    ControllerUtils.controllerBody(args);
  }

  @Test(expected = Exception.class)
  public void controllerBody21() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "go to school", "--csv-file", "todos.csv",
        "--priority",
        "1", "--category", "nothing", "--due", "8/1/2008", "school", "--complete-todo", "1",
        "--sort-by-priority", "--sort-by-date"};
    ControllerUtils.controllerBody(args);
  }
}