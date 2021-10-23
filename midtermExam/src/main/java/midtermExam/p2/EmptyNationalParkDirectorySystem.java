package midtermExam.p2;

/**
 * Represents an empty NationalParkDirectorySystem
 */
public class EmptyNationalParkDirectorySystem extends ANationalParkDirectorySystem {

  private static final int LARGE_PRIME = 40013;

  /**
   * {@inheritDoc}
   * Checks whether or not the NationalParkDirectorySystem is empty, returns true if it is empty,
   * false otherwise
   *
   * @return Boolean
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * {@inheritDoc}
   * Counts the number of NationalParks in the NationalParkDirectorySystem
   *
   * @return the number of NationalParks in the NationalParkDirectorySystem
   */
  @Override
  public Integer countNationalParks() {
    return 0;
  }

  /**
   * {@inheritDoc}
   * Removes a specified NationalPark from the NationalParkDirectorySystem
   *
   * @param nationalPark the NationPark to remove
   * @return a new NationalParkDirectorySystem without the NationPark
   * @throws NationalParkNotFoundException thrown when the park is not found in the
   * NationalParkDirectorySystem
   */
  @Override
  public NationalParkDirectorySystem removeNationalPark(NationalPark nationalPark)
      throws NationalParkNotFoundException {
    throw new NationalParkNotFoundException();
  }

  /**
   * {@inheritDoc}
   * Checks if a specified NationalPark is included in the NationalParkDirectorySystem, true if
   * it is, false otherwise
   *
   * @param nationalPark the NationalPark to check
   * @return Boolean
   */
  @Override
  public Boolean containsNationalPark(NationalPark nationalPark) {
    return false;
  }

  /**
   * {@inheritDoc}
   * Finds and returns all NationalParks from the NationalParkDirectorySystem that
   * are located within the same state, provided as an input argument
   *
   * @param state the specified state to check
   * @return a new NationalParkDirectorySystem collecting all valid NationalPark
   */
  @Override
  public NationalParkDirectorySystem findAllNationalParksInASpecificState(String state) {
    return this;
  }

  /**
   * {@inheritDoc}
   * Finds and returns all NationalParks from the NationalParkDirectorySystem
   * that are opened year round
   *
   * @return a new NationalParkDirectorySystem collecting all valid NationalPark
   */
  @Override
  public NationalParkDirectorySystem findAllNationalParksOpenYearRound() {
    return this;
  }

  /**
   * {@inheritDoc}
   * Gets a NationalPark from the NationalParkDirectorySystem based upon the NationalPark’s unique
   * identifier, nationalParkID
   *
   * @param nationalParkID NationalPark’s unique * identifier
   * @return the unique NationPark
   * @throws InvalidNationalParkIDException thrown when the given unique ID doesn't exist
   */
  @Override
  public NationalPark findNationalParkWithNationalParkID(String nationalParkID)
      throws InvalidNationalParkIDException {
    throw new InvalidNationalParkIDException();
  }

  /**
   * {@inheritDoc}
   * Helper, removes a specified NationalPark from the NationalParkDirectorySystem, but won't
   * throw exception when the NationalParkDirectorySystem is empty, used in recursion for
   * function 'equals', since Exception is unnecessary in 'equals' function
   *
   * @param nationalPark a specified NationalPark to remove
   * @return a new NationalParkDirectorySystem without the NationPark
   */
  @Override
  public NationalParkDirectorySystem removeNationalParkWithoutException(NationalPark nationalPark) {
    return this;
  }

  /**
   * {@inheritDoc}
   * Indicates whether some other object passed as an argument is "equal to" the
   * EmptyNationalParkDirectorySystem
   *
   * @param obj - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof EmptyNationalParkDirectorySystem)) {
      return false;
    }

    return true;
  }

  /**
   * {@inheritDoc}
   * Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return LARGE_PRIME;
  }

  /**
   * {@inheritDoc}
   * Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "{ }";
  }
}
