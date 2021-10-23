package problem1;

/**
 * Represents the interface of PriorityQueue
 */
public interface PriorityQueue {

  /**
   * Creates an empty PriorityQueue
   * @return an empty PriorityQueue
   */
  static PriorityQueue createEmpty(){
    return new EmptyPriorityQueue();
  };

  /**
   * Returns true if a PriorityQueue is empty, false otherwise
   *
   * @return Boolean
   */
  Boolean isEmpty();

  /**
   * Returns a new PriorityQueue, after adding a new Node with priority and value into the original
   * PriorityQueue
   *
   * @param priority the priority of the Node
   * @param value the value of the Node
   * @return a new PriorityQueue after new Node is added
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * Returns the value of the head of the PriorityQueue
   *
   * @return the value of the head of the PriorityQueue
   * @exception InvalidCallException thrown when the call is invalid
   */
  String peek() throws InvalidCallException;

  /**
   * Returns a copy of the PQ without the element with the highest priority
   *
   * @return a copy of the PQ without the element with the highest priority
   * @exception InvalidCallException thrown when the call is invalid
   */
  PriorityQueue pop() throws InvalidCallException;

}
