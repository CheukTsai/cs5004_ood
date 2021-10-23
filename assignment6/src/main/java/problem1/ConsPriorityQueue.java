package problem1;

/**
 * Represents a concrete non-empty PriorityQueue
 */
public class ConsPriorityQueue extends APriorityQueue{

  private static final Integer HASH_CODE = 31;
  private static final Integer ONE = 1;

  /**
   * Represents a static class Node
   */
  static class Node{
    private Integer priority;
    private String value;

    /**
     * Constructs a Node
     * @param priority - the priority of the word
     * @param value - the word
     */
    private Node(Integer priority, String value){
      this.priority = priority;
      this.value = value;
    }
  }

  private final Node head;
  private final PriorityQueue rest;

  /**
   * Constructs a new ConsPriority with {@code priority}, {@code value} and {@code rest}
   * @param priority the priority of the Node
   * @param value the value of the Node
   * @param rest the rest of the Priority
   */
  public ConsPriorityQueue(Integer priority, String value, PriorityQueue rest) {
    this.head = new Node(priority, value);
    this.rest = rest;
  }

  /**
   * {@inheritDoc}
   * Returns true if a PriorityQueue is empty, false otherwise
   *
   * @return false;
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

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

    if(this.head.priority < priority){
      return new ConsPriorityQueue(priority, value, this);
    }
    return new ConsPriorityQueue(this.head.priority, this.head.value,
        this.rest.add(priority, value));
  }


  /**
   * {@inheritDoc}
   * Returns the value of the head of the PriorityQueue
   *
   * @return the value of the head of the PriorityQueue
   */
  @Override
  public String peek() {
    return this.head.value;
  }

  /**
   * {@inheritDoc}
   * Returns a copy of the PQ without the element with the highest priority
   *
   * @return a copy of the PQ without the element with the highest priority
   */
  @Override
  public PriorityQueue pop() {
    return this.rest;
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
    if (this == o) return true;
    if (o == null) return false;
    if(!(o instanceof ConsPriorityQueue)) return false;

    ConsPriorityQueue that = (ConsPriorityQueue) o;

    if(this.head.priority == null){
      if(that.head.priority != null) return false;
    }
    else if(!this.head.priority.equals(that.head.priority)) return false;

    if(this.head.value == null){
      if(that.head.value != null) return false;
    }
    else if(!this.head.value.equals(that.head.value)) return false;

    if(this.rest == null){
      if(that.rest != null) return false;
    }
    else if(!this.rest.equals(that.rest)) return false;
    return true;
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    final int prime = HASH_CODE;
    int result = ONE;
    result = (prime * result) + ((this.head.priority == null) ? 0 : this.head.priority.hashCode());
    result = (prime * result) + ((this.head.value == null) ? 0 : this.head.value.hashCode());
    result = (prime * result) + ((this.rest == null) ? 0 : this.rest.hashCode());
    return result;
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ConsPriorityQueue{" +
        ", head.priority=" + head.priority +
        ", head.value=" + head.value +
        ", rest=" + rest +
        '}';
  }
}
