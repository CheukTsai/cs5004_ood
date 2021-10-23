package problem1;

/**
 * Represents a concrete empty PriorityQueue
 */
public class EmptyPriorityQueue extends APriorityQueue{

  private static final int HASH_CODE = 41;

  /**
   * {@inheritDoc}
   * Returns true if a PriorityQueue is empty, false otherwise
   *
   * @return true;
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * {@inheritDoc}
   * Returns the value of the head of the PriorityQueue
   *
   * @return the value of the head of the PriorityQueue
   * @exception InvalidCallException thrown when the call is invalid
   */
  @Override
  public String peek() throws InvalidCallException{
    throw new InvalidCallException("Call peek() on an empty PriorityQueue");
  }


  /**
   * {@inheritDoc}
   * Returns a copy of the PQ without the element with the highest priority
   *
   * @return a copy of the PQ without the element with the highest priority
   * @exception InvalidCallException thrown when the call is invalid
   */
  @Override
  public PriorityQueue pop() throws InvalidCallException {
    throw new InvalidCallException("Call pop() on an empty PriorityQueue");
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * PriorityQueue
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null)
      return false;
    if (!(o instanceof EmptyPriorityQueue))
      return false;

    return true;
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode(){
    return HASH_CODE;
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "{ }";
  }
}
