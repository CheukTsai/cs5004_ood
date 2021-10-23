package problem1;

/**
 * Represents an abstract class of PriorityQueue
 */
public abstract class APriorityQueue implements PriorityQueue{

  /**
   * {@inheritDoc}
   * Returns a new PriorityQueue, after adding a new Node with priority and value into the original
   * PriorityQueue
   *
   * @param priority the priority of the Node
   * @param value the value of the Node
   * @return a new PriorityQueue after new Node is added
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    return new ConsPriorityQueue(priority, value, this);
  }
}
