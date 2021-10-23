package recursiveSet;

/**
 * Represents a non-empty set of integers.
 */
public class ConsSet implements Set{

  private final Integer value;
  private final Set rest;


  /**
   * Given an integer and a set to create a new set with the
   * same elements as {@code value} and with {@code rest} prepended.
   *
   * @param value new element to add to the beginning of the set
   * @param rest the set we are going to use to add our new element
   */
  public ConsSet(Integer value, Set rest) {
    this.value = value;
    this.rest = rest;
  }


  /**
   * {@inheritDoc}
   * Checks whether the Set is empty
   *
   * @return Boolean
   */
  @Override
  public Boolean isEmpty() {
    return false;
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
    if (this.value.equals(value)) return true;
    return this.rest.contains(value);
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
    if(this.value.equals(value)) return this.rest;
    return new ConsSet(this.value,this.rest.remove(value));
  }

  /**
   * {@inheritDoc}
   * Checks whether the Set is empty
   *
   * @return Boolean
   */
  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }
}
