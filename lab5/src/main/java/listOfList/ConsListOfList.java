package listOfList;

import simpleRecursiveList.List;

/**
 * Represents a non-empty List of List of Integers
 */
public class ConsListOfList implements ListOfList{

  private final List value;
  private final ListOfList rest;

  /**
   * Given a list and a list of list to create a new list of list with the
   * same elements as {@code value} and with {@code rest} prepended.
   *
   * @param value new list to add to the beginning of the list of list
   * @param rest the list of list we are going to use to add our new list
   */
  public ConsListOfList(List value, ListOfList rest) {
    this.value = value;
    this.rest = rest;
  }

  /**
   * {@inheritDoc}
   * Returns the size of the List of List
   *
   * @return the size of the List of List
   */
  @Override
  public Integer size() {
    return 1 + rest.size();
  }

  /**
   * {@inheritDoc}
   * Returns the number of total Integers in the List of List
   *
   * @return the number of total Integers in the List of List
   */
  @Override
  public Integer length() {
    return this.value.size() + this.rest.length();
  }

  /**
   * {@inheritDoc}
   * Returns the total sum of Integers in the List of List
   *
   * @return the total sum of Integers in the List of List
   */
  @Override
  public Integer sum() {
    return this.value.sum() + this.rest.sum();
  }

  /**
   * {@inheritDoc}
   * Checks whether the List of List is empty
   *
   * @return Boolean
   */
  @Override
  public Boolean isEmpty() {
    return false;
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
    if(this.value.contains(value))
      return new ConsListOfList(this.value.remove(value), this.rest);
    else
      return new ConsListOfList(this.value, this.rest.removeInteger(value));
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
    if(this.value.contains(value))
      return new ConsListOfList(this.value.remove(value), this.rest.removeAllInteger(value));
    else
      return new ConsListOfList(this.value, this.rest.removeAllInteger(value));
  }
}
