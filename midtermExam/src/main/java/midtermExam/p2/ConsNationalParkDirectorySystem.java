package midtermExam.p2;

/**
 * Represents a non-empty NationalParkDirectorySystem
 */
public class ConsNationalParkDirectorySystem extends ANationalParkDirectorySystem {

  private static final Integer ZERO = 0;
  private static final Integer ONE = 1;
  private static final Integer PRIME = 31;

  private final NationalPark head;
  private final NationalParkDirectorySystem rest;

  /**
   * Constructs a ConsNationalParkDirectorySystem, with {@code head} and {@code rest}
   * @param head head of the ConsNationalParkDirectorySystem
   * @param rest rest of the ConsNationalParkDirectorySystem
   */
  public ConsNationalParkDirectorySystem(NationalPark head, NationalParkDirectorySystem rest) {
    this.head = head;
    this.rest = rest;
  }

  /**
   * {@inheritDoc}
   * Checks whether or not the NationalParkDirectorySystem is empty, returns true if it is empty,
   * false otherwise
   *
   * @return Boolean
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * {@inheritDoc}
   * Counts the number of NationalParks in the NationalParkDirectorySystem
   *
   * @return the number of NationalParks in the NationalParkDirectorySystem
   */
  @Override
  public Integer countNationalParks() {
    return ONE + this.rest.countNationalParks();
  }

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
    if (this.head.equals(nationalPark)) return this;
    if (this.head.getNationalParkID().equals(nationalPark.getNationalParkID())){
      return new ConsNationalParkDirectorySystem(nationalPark, this.rest);
    }
    return new ConsNationalParkDirectorySystem(this.head,
        this.rest.addNationalPark(nationalPark));
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
      throws NationalParkNotFoundException{
    if (this.head.equals(nationalPark)) return this.rest;
    return new ConsNationalParkDirectorySystem(this.head,
        this.rest.removeNationalPark(nationalPark));
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
    if(this.head.equals(nationalPark)) return true;
    return this.rest.containsNationalPark(nationalPark);
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
    if(this.head.getState().equals(state)){
      return new ConsNationalParkDirectorySystem(this.head,
          this.rest.findAllNationalParksInASpecificState(state));
    }
    return this.rest.findAllNationalParksInASpecificState(state);
  }

  /**
   * {@inheritDoc}
   *  Finds and returns all NationalParks from the NationalParkDirectorySystem
   *  that are opened year round
   *
   * @return a new NationalParkDirectorySystem collecting all valid NationalPark
   */
  @Override
  public NationalParkDirectorySystem findAllNationalParksOpenYearRound() {
    if(this.head.getOpenYearRound()) {
      return new ConsNationalParkDirectorySystem(this.head,
          this.rest.findAllNationalParksOpenYearRound());
    }
    return this.rest.findAllNationalParksOpenYearRound();
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
    if (this.head.getNationalParkID().equals(nationalParkID)) return this.head;
    return this.rest.findNationalParkWithNationalParkID(nationalParkID);
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
    if(!this.head.equals(nationalPark)) {
      return new ConsNationalParkDirectorySystem(this.head,
          this.rest.removeNationalParkWithoutException(nationalPark));}
    return this.rest;
  }

  /**
   * {@inheritDoc}
   * Indicates whether some other object passed as an argument is "equal to" the
   * ConsNationalParkDirectorySystem
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (!(o instanceof ConsNationalParkDirectorySystem)) {
      return false;
    }
    ConsNationalParkDirectorySystem that = (ConsNationalParkDirectorySystem) o;
    if (this.head == null) {
      if (that.head != null) return false;
    }
    if (!this.countNationalParks().equals(that.countNationalParks())) return false;
    if (!that.containsNationalPark(this.head)) return false;

    return this.rest.equals(that.removeNationalParkWithoutException(this.head));
  }

  /**
   * {@inheritDoc}
   * Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    int result = ONE;
    int prime = PRIME;

    result = (prime * result) + ((this.head == null) ? ZERO : this.head.hashCode());
    result = (prime * result) + ((this.rest == null) ? ZERO : this.rest.hashCode());

    return result;
  }

  /**
   * {@inheritDoc}
   * Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ConsNationalParkDirectorySystem{" +
        "head=" + head +
        ", rest=" + rest +
        '}';
  }
}
