package recursiveSet;

/**
 * Represents a set of integers.
 */
public interface Set {

  /**
   * Returns an empty Set
   *
   * @return an empty Set
   */

  static Set emptySet(){
    return new EmptySet();
  }

  /**
   * Checks whether the Set is empty
   *
   * @return Boolean
   */
  Boolean isEmpty();

  /**
   * Returns Set after new element is added to the original Set
   *
   * @param value new element to add to the Set
   * @return new Set with the element
   */
  Set add(Integer value);

  /**
   * Returns true if element is in the Set and false otherwise
   *
   * @param value number to be checked
   * @return Boolean
   */
  Boolean contains(Integer value);

  /**
   * Returns a new Set with a given element is removed from the original Set
   *
   * @param value the element to be removed
   * @return a new Set with a given element is removed from the original Set
   */
  Set remove(Integer value);

  /**
   * Checks whether the Set is empty
   *
   * @return Boolean
   */
  Integer size();

}
