package problem2;


import java.util.Set;

/**
 * Represents a concrete class RecordingArtist, extending its parent class Person
 */
public class RecordingArtist extends Person{


  /**
   * Constructs a RecordingArtist, with firstName and lastName
   * @param firstName - String, first name of the artist
   * @param lastName - String, last name of the artist
   */
  public RecordingArtist(String firstName, String lastName) {
    super(firstName, lastName);
  }

  /**
   * {@inheritDoc}
   * Overrides getMembers(), returns null
   * @return null
   */
  @Override
  public Set<Person> getMembers() {
    return null;
  }

}
