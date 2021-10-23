package listOfList;

import simpleRecursiveList.List;

/**
 * Represents an empty List of List of Integers
 */
public class EmptyListOfList implements ListOfList{

  /**
   * {@inheritDoc}
   * Returns the size of the List of List
   *
   * @return the size of the List of List
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * {@inheritDoc}
   * Returns the number of total Integers in the List of List
   *
   * @return the number of total Integers in the List of List
   */
  @Override
  public Integer length() {
    return 0;
  }

  /**
   * {@inheritDoc}
   * Returns the total sum of Integers in the List of List
   *
   * @return the total sum of Integers in the List of List
   */
  @Override
  public Integer sum() {
    return 0;
  }

  /**
   * {@inheritDoc}
   * Checks whether the List of List is empty
   *
   * @return Boolean
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * {@inheritDoc}
   * Returns List of List after new List is added to the original list of List
   *
   * @param listToAdd new List to add to the list
   * @return new List of List with the List to add
   */
  @Override
  public ListOfList add(List listToAdd) {
    return new ConsListOfList(listToAdd, this);
  }

  /**
   * {@inheritDoc}
   * Removes the first Integer to find in the List of List
   *
   * @param value the Integer to find
   * @return the first Integer to find in the List of List
   */
  @Override
  public ListOfList removeInteger(Integer value) {
    return this;
  }

  /**
   * {@inheritDoc}
   * Removes all Integers equal to value in the List of List
   *
   * @param value the value for the Integers
   * @return all Integers equal to value in the List of List
   */
  @Override
  public ListOfList removeAllInteger(Integer value) {
    return this;
  }
}
