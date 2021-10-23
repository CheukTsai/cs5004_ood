package midtermExam.p2;

/**
 * Represents the interface of NationalParkDirectorySystem
 */
public interface NationalParkDirectorySystem {

  /**
   * Creates an empty NationalParkDirectorySystem
   *
   * @return an empty NationalParkDirectorySystem
   */
  static NationalParkDirectorySystem createEmptyNationalParkDirectorySystem(){
    return new EmptyNationalParkDirectorySystem();
  }

  /**
   * Checks whether or not the NationalParkDirectorySystem is empty, returns true if it is empty,
   * false otherwise
   *
   * @return Boolean
   */
  Boolean isEmpty();

  /**
   * Counts the number of NationalParks in the NationalParkDirectorySystem
   *
   * @return the number of NationalParks in the NationalParkDirectorySystem
   */
  Integer countNationalParks();

  /**
   * Adds a new National Park to the NationalParkDirectorySystem, if the new Nation Park unique ID
   * is the same as one of the Nation Park in the System, we assume it is an update of the Park's
   * information. (As ID can be seen as the authorized identifier)
   *
   * @param nationalPark a new National Park
   * @return a new NationalParkDirectorySystem with new Nation Park is added
   */
  NationalParkDirectorySystem addNationalPark(NationalPark nationalPark);

  /**
   * Removes a specified NationalPark from the NationalParkDirectorySystem
   *
   * @param nationalPark the NationPark to remove
   * @return a new NationalParkDirectorySystem without the NationPark
   * @throws NationalParkNotFoundException thrown when the park is not found in the
   * NationalParkDirectorySystem
   */
  NationalParkDirectorySystem removeNationalPark(NationalPark nationalPark)
      throws NationalParkNotFoundException;

  /**
   * Checks if a specified NationalPark is included in the NationalParkDirectorySystem, true if
   * it is, false otherwise
   *
   * @param nationalPark the NationalPark to check
   * @return Boolean
   */
  Boolean containsNationalPark(NationalPark nationalPark);

  /**
   * Finds and returns all NationalParks from the NationalParkDirectorySystem that
   * are located within the same state, provided as an input argument
   *
   * @param state the specified state to check
   * @return a new NationalParkDirectorySystem collecting all valid NationalPark
   */
  NationalParkDirectorySystem findAllNationalParksInASpecificState(String state);

  /**
   *  Finds and returns all NationalParks from the NationalParkDirectorySystem
   *  that are opened year round
   *
   * @return a new NationalParkDirectorySystem collecting all valid NationalPark
   */
  NationalParkDirectorySystem findAllNationalParksOpenYearRound();

  /**
   * Gets a NationalPark from the NationalParkDirectorySystem based upon the NationalPark’s unique
   * identifier, nationalParkID
   *
   * @param nationalParkID NationalPark’s unique * identifier
   * @return the unique NationPark
   * @throws InvalidNationalParkIDException thrown when the given unique ID doesn't exist
   */
  NationalPark findNationalParkWithNationalParkID(String nationalParkID)
      throws InvalidNationalParkIDException;

  /**
   * {@inheritDoc}
   * Helper, removes a specified NationalPark from the NationalParkDirectorySystem, but won't
   * throw exception when the NationalParkDirectorySystem is empty, used in recursion for
   * function 'equals', since Exception is unnecessary in 'equals' function
   *
   * @param nationalPark a specified NationalPark to remove
   * @return a new NationalParkDirectorySystem without the NationPark
   */
  NationalParkDirectorySystem removeNationalParkWithoutException(NationalPark nationalPark);
}
