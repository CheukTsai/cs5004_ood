package problem3;

import java.util.Objects;

/**
 * A class that has two different fields, item and nextNode.
 */
public class Node {
  private String item;
  private Node nextNode;

  /**
   * Constructor that creates a new object of Node
   * @param item - String, item of the new object
   * @param nextNode - Node, nextNode of the new object
   */
  public Node(String item, Node nextNode) {
    this.item = item;
    this.nextNode = nextNode;
  }

  /**
   * Return item of the new object
   * @return String, item of the new object
   */
  public String getItem() {
    return item;
  }

  /**
   * Return next node of the new object
   * @return Node, next node of the object
   */
  public Node getNextNode() {
    return nextNode;
  }

  /**
   * A method provided by java.lang.Object that indicates whether some other object
   * passed as an argument is "equal to" the current instance.
   * @param o - Object, taking this object as a parameter
   * @return a boolean value after compare with those fields of AService object
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(getItem(), node.getItem()) && Objects
        .equals(getNextNode(), node.getNextNode());
  }

  /**
   * Return a hashcode value of the Object
   * @return int, a hashcode value of the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getItem(), getNextNode());
  }

  /**
   *
   * @return
   */
  @Override
  public String toString() {
    return "Node{" +
        "item='" + item + '\'' +
        ", nextNode=" + nextNode +
        '}';
  }
}
