package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * A class that represents Todo object.
 */
public class Todo {

  private Integer id;
  private String text;
  private Boolean completed;
  private LocalDate due;
  private Integer priority = 3;
  private String category;

  /**
   * A Todo builder method.
   * @param builder Builder
   */
  public Todo(Builder builder) {
    id = builder.id;
    text = builder.text;
    completed = builder.completed;
    due = builder.due;
    priority = builder.priority;
    category = builder.category;
  }

  /**
   * A builder method that used to define some fields.
   */
  public static class Builder {

    private Integer id;
    private String text;
    private Boolean completed;
    private LocalDate due;
    private Integer priority;
    private String category;

    /**
     * Set id of Todo
     * @param id Integer, set id of Todo
     */
    public void setId(Integer id) {
      this.id = id;
    }

    /**
     * Set text of Todo
     * @param text String
     */
    public void setText(String text) {
      this.text = text;
    }

    /**
     * Set completed of Todo
     * @param completed Boolean value
     */
    public void setCompleted(Boolean completed) {
      this.completed = completed;
    }

    /**
     * Set due of Todo
     * @param due LocalDate
     */
    public void setDue(LocalDate due) {
      this.due = due;
    }

    /**
     * Set priority of Todo
     * @param priority Integer
     */
    public void setPriority(Integer priority) {
      this.priority = priority;
    }

    /**
     * Set category of Todo
     * @param category String
     */
    public void setCategory(String category) {
      this.category = category;
    }

    /**
     * Return new Todo object
     * @return new Todo object
     */
    public Todo build(){
      return new Todo(this);
    }
  }

  /**
   * Return id of Todo
   * @return Integer
   */
  public Integer getId() {
    return id;
  }

  /**
   * Return text of Todo
   * @return String
   */
  public String getText() {
    return text;
  }

  /**
   * Return completed of Todo
   * @return Boolean value
   */
  public Boolean getCompleted() {
    return completed;
  }

  /**
   * Return due of Todo
   * @return LocalDate
   */
  public LocalDate getDue() {
    return due;
  }

  /**
   * Return priority of Todo
   * @return Integer
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * Return category of Todo
   * @return String
   */
  public String getCategory() {
    return category;
  }

  /**
   * Set completed of Todo
   * @param completed Boolean value
   */
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  /**
   * {@inheritDoc}
   * Returns an String representation of the object
   *
   * @return int hash code
   */
  @Override
  public String toString() {
    return "Todo{" +
        "id=" + id +
        ", text='" + text + '\'' +
        ", completed=" + completed +
        ", due=" + due +
        ", priority=" + priority +
        ", category='" + category + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Todo todo = (Todo) o;
    return Objects.equals(getId(), todo.getId()) && Objects
        .equals(getText(), todo.getText()) && Objects
        .equals(getCompleted(), todo.getCompleted()) && Objects
        .equals(getDue(), todo.getDue()) && Objects
        .equals(getPriority(), todo.getPriority()) && Objects
        .equals(getCategory(), todo.getCategory());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getText(), getCompleted(), getDue(), getPriority(), getCategory());
  }
}