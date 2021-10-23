package problem2;

import java.util.Objects;

/**
 * Represents an abstract class Item, with title, creator, and releasing year
 */
public abstract class Item{
  protected String title;
  protected Creator creator;
  protected Integer year;

  /**
   * Constructs an Item, with title, creator, and releasing year
   * @param title - String, title of the Item
   * @param creator - Creator, creator of the Item
   * @param year - Integer, releasing year of the Item
   */
  public Item(String title, Creator creator, Integer year) {
    this.title = title;
    this.creator = creator;
    this.year = year;
  }

  /**
   * Returns the title of the Item
   * @return String
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the creator of the Item
   * @return Creator
   */
  public Creator getCreator() {
    return creator;
  }

  /**
   * Returns releasing year of the Item
   * @return Integer
   */
  public Integer getYear() {
    return year;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(title, item.title) && Objects
        .equals(creator, item.creator) && Objects.equals(year, item.year);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(title, creator, year);
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Item{" +
        "title='" + title + '\'' +
        ", creator=" + creator +
        ", year=" + year +
        '}';
  }
}
