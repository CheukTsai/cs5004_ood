package midtermExam.p2;

/**
 * Represents an abstract class ANationalParkDirectorySystem
 */
public abstract class ANationalParkDirectorySystem implements NationalParkDirectorySystem {

  /**
   * {@inheritDoc}
   * Adds a new National Park to the NationalParkDirectorySystem, if the new Nation Park unique ID
   * is the same as one of the Nation Park in the System, we assume it is an update of the Park's
   * information. (As ID can be seen as the authorized identifier)
   *
   * @param nationalPark a new National Park
   * @return a new NationalParkDirectorySystem with new Nation Park is added
   */
  @Override
  public NationalParkDirectorySystem addNationalPark(NationalPark nationalPark) {
    return new ConsNationalParkDirectorySystem(nationalPark, this);
  }
}
