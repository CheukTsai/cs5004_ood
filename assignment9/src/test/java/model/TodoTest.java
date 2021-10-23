package model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Objects;
import model.Todo.Builder;
import org.junit.Before;
import org.junit.Test;

public class TodoTest {
  private Integer id;
  private String text;
  private Boolean completed;
  private LocalDate due;
  private LocalDate due2;
  private Integer priority = 3;
  private String category;
  private Integer priority2 = 1;
  private String category2;
  private Todo todo;
  private Todo todo2;
  private Builder builder;

  @Before
  public void setUp() throws Exception {
    id = 1;
    text = "a";
    completed = true;
    due = LocalDate.of(2021,8,10);
    due2 = LocalDate.of(2022,8,10);
    category = "x";
    category2 = "yzz";
    builder = new Builder();
    builder.setId(id);
    builder.setText(text);
    builder.setCompleted(completed);
    builder.setDue(due);
    builder.setPriority(priority);
    builder.setCategory(category);
    todo = builder.build();
    todo2 = builder.build();
  }


  @Test
  public void getId() {
    assertEquals(todo.getId(),id);

  }

  @Test
  public void getText() {
    assertEquals(todo.getText(),text);
  }

  @Test
  public void getCompleted() {
    assertEquals(todo.getCompleted(),completed);
  }

  @Test
  public void getDue() {
    assertEquals(todo.getDue(),due);
  }

  @Test
  public void getPriority() {
    assertEquals(todo.getPriority(),priority);
  }

  @Test
  public void getCategory() {
    assertEquals(todo.getCategory(),category);
  }

  @Test
  public void setCompleted() {
    todo.setCompleted(true);
    assertTrue(todo.getCompleted());
  }

  @Test
  public void testToString() {
    String expected = "Todo{" +
        "id=" + id +
        ", text='" + text + '\'' +
        ", completed=" + completed +
        ", due=" + due +
        ", priority=" + priority +
        ", category='" + category + '\'' +
        '}';
    assertEquals(expected, todo.toString());
  }

  @Test
  public void testEquals() {
    assertTrue(todo.equals(todo));
    assertNotEquals(todo,null);
    assertFalse(todo.equals(text));
    assertTrue(todo.equals(todo2));

    builder.setId(2);
    builder.setText(text);
    builder.setCompleted(completed);
    builder.setDue(due);
    builder.setPriority(priority);
    builder.setCategory(category);
    todo2 = builder.build();

    assertFalse(todo.equals(todo2));

    builder.setId(id);
    builder.setText("abc");
    builder.setCompleted(completed);
    builder.setDue(due);
    builder.setPriority(priority);
    builder.setCategory(category);
    todo2 = builder.build();

    assertFalse(todo.equals(todo2));

    builder.setId(id);
    builder.setText(text);
    builder.setCompleted(false);
    builder.setDue(due);
    builder.setPriority(priority);
    builder.setCategory(category);
    todo2 = builder.build();

    assertFalse(todo.equals(todo2));

    builder.setId(id);
    builder.setText(text);
    builder.setCompleted(completed);
    builder.setDue(due2);
    builder.setPriority(priority);
    builder.setCategory(category);
    todo2 = builder.build();

    assertFalse(todo.equals(todo2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(id,text,completed,due,priority,category);
    assertEquals(todo.hashCode(),hash);
  }
}