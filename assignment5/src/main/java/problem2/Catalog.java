package problem2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a concrete class Catalog, with functionalities to store and search items
 */
public class Catalog {

  private Set<Item> collection;

  /**
   * Constructs a new Catalog, with an empty set of Item is created
   */
  public Catalog() {
    collection = new HashSet<>();
  }

  /**
   * Returns Set of Item whose title contains the keyword
   * @param keyword - String, searching keyword
   * @return Set of Item
   */
  public Set<Item> search(String keyword){
    Set<Item> output = new HashSet<>();
    for(Item item : collection){
      if(item.getTitle().toLowerCase().contains(keyword.toLowerCase())) output.add(item);
    }
    return output;
  }

  /**
   * Returns Set of Item, only Book, whose author matches the input
   * @param author - Author, the author of book
   * @return Set of Item
   */
  public Set<Item> search(Author author){
    Set<Item> output = new HashSet<>();
    for(Item item : collection) {
      if (item.getCreator().equals(author)) output.add(item);
    }
    return output;
  }

  /**
   * Returns Set of Item, only Music, whose creator includes the input
   * @param recordingArtist - RecordingArtist, the artist of music
   * @return Set of Item
   */
  public Set<Item> search(RecordingArtist recordingArtist){
    Set<Item> output = new HashSet<>();
    for(Item item : collection){
      if(item.getCreator().equals(recordingArtist)) output.add(item);
      else if(item.getCreator().getMembers() != null &&
          item.getCreator().getMembers().contains(recordingArtist)) output.add(item);
    }
    return output;
  }

  /**
   * Adds Item to the collection
   * @param item - Item, including Music and Book
   */
  public void addItem(Item item){
    this.collection.add(item);
  }

  /**
   * Returns the collection of Item
   * @return Set of Item
   */
  public Set<Item> getCollection() {
    return collection;
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
    Catalog catalog = (Catalog) o;
    return Objects.equals(collection, catalog.collection);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(collection);
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "collection=" + collection +
        '}';
  }
}
