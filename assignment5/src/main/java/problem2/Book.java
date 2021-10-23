package problem2;

/**
 * Represents a concrete class Book, extending its parent class Item
 */
public class Book extends Item {

  /**
   * Constructs a Book, with title, creator, and releasing year
   * @param title - String, title of the Book
   * @param author - Creator, creator of the Book
   * @param year - Integer, releasing year of the Book
   */
  public Book(String title, Author author, Integer year) {
    super(title, author, year);
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
    return super.equals(o);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return super.toString();
  }
}


