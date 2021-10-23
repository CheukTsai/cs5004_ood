package recursiveSet;

/**
 * Represents an empty set of integers.
 */
public class EmptySet implements Set{

  /**
   * {@inheritDoc}
   * Checks whether the Set is empty
   *
   * @return Boolean
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * {@inheritDoc}
   * Returns Set after new element is added to the original Set
   *
   * @param value new element to add to the Set
   * @return new Set with the element
   */
  @Override
  public Set add(Integer value) {
    return new ConsSet(value, this);
  }

  /**
   * {@inheritDoc}
   * Returns true if element is in the Set and false otherwise
   *
   * @param value number to be checked
   * @return Boolean
   */
  @Override
  public Boolean contains(Integer value) {
    return false;
  }

  /**
   * {@inheritDoc}
   * Returns a new Set with a given element is removed from the original Set
   *
   * @param value the element to be removed
   * @return a new Set with a given element is removed from the original Set
   */
  @Override
  public Set remove(Integer value) {
    return this;
  }

  /**
   * {@inheritDoc}
   * Checks whether the Set is empty
   *
   * @return Boolean
   */
  @Override
  public Integer size() {
    return 0;
  }
}
