package problem2;

/**
 * Represents a concrete class Music, extending its parent class Item
 */
public class Music extends Item{

  /**
   * Constructs a Music, with title, creator, and releasing year
   * @param title - String, title of the Music
   * @param creator - Creator, creator of the Music
   * @param year - Integer, releasing year of the Music
   */
  public Music(String title, Creator creator, Integer year) {
    super(title, creator, year);
  }
}
