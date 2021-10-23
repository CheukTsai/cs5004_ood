package problem3;

/**
 * A concrete class that inherits from interface of ImmutableListOfStrings.
 */
public class ListOfString implements ImmutableListOfStrings {

  private Node head;
  private Integer numNodes;

  /**
   * A constructor that instantiate the head and numNodes.
   */
  public ListOfString() {
    this.head = null;
    this.numNodes = 0;
  }

  /**
   * Return a boolean value
   * @return boolean, a boolean value
   */
  @Override
  public Boolean isEmpty() {
    return (this.head == null && this.numNodes == 0);
  }

  /**
   * Return the number of nodes
   * @return Integer, number of nodes
   */
  @Override
  public Integer size() {
    return this.numNodes;
  }

  /**
   * Return a boolean value if condition is matched.
   * @param item String, taking this parameter
   * @return boolean, a boolean value
   */
  @Override
  public Boolean contains(String item) {
      Node currNode = this.head;
      while (currNode != null) {
        if (currNode.getItem().equals(item)) {
          return true;
        }
        currNode = currNode.getNextNode();
      }
    return false;
  }

  /**
   * Return a boolean value if condition is matched.
   * @param items Strings, taking this parameter
   * @return boolean, a boolean value
   */
  @Override
  public Boolean containsAll(ImmutableListOfStrings items) {
    if(this.head != null){
      ListOfString currItems = (ListOfString) items;
      while(currItems.head != null){
        if(!this.contains(currItems.head.getItem())) return false;
        currItems.head = currItems.head.getNextNode();
      }
      return true;
    }
    return items.size() == 0;
  }

  /**
   * Return a link list that is a ImmutableListOfStrings date type
   * @param strLen Integer, taking this parameter
   * @return ImmutableListOfStrings, a link list that is a ImmutableListOfStrings date type
   */
  @Override
  public ImmutableListOfStrings filterLargerThan(Integer strLen) {
    ImmutableListOfStrings resultingList = new ListOfString();
      Node currNode = this.head;
      while (currNode != null) {
        if (currNode.getItem().length() >= strLen){
          resultingList = resultingList.add(currNode.getItem());
        }
        if(currNode.getNextNode() != null) currNode = currNode.getNextNode();
        else break;
      }
    return resultingList;
  }

  /**
   * Return a boolean value
   * @return boolean, a boolean value if the condition is matched
   */
  @Override
  public Boolean hasDuplicates() {
      Node currNode1 = this.head;
      while (currNode1 != null) {
        Node currNode2 = currNode1.getNextNode();
        while (currNode2 != null) {
          if (currNode1.getItem().equals(currNode2.getItem()))
            return true;
          currNode2 = currNode2.getNextNode();
        }
        currNode1 = currNode1.getNextNode();
      }
    return false;
  }

  /**
   * Return a storeLinkList that has removed the duplicated items
   * @return ImmutableListOfStrings, a storeLinkList that has removed the duplicated items
   */
  @Override
  public ImmutableListOfStrings removeDuplicates() {
    ImmutableListOfStrings newLinkedList = new ListOfString();
    Node currNode = this.head;
    while (currNode.getNextNode() != null) {
      String currString = currNode.getNextNode().getItem();
      if(!newLinkedList.contains(currString)){
        newLinkedList = newLinkedList.add(currString);
      }
      currNode = currNode.getNextNode();
    }
    return newLinkedList;
  }

  /**
   * Return a new node that has added new nodes
   * @param item String, taking this parameter
   * @return ImmutableListOfStrings, a new node that has added new nodes
   */
  @Override
  public ImmutableListOfStrings add(String item) {
    ListOfString newList = new ListOfString();
    Node curNode = new Node(item, this.head);
    newList.head = curNode;
    newList.numNodes = this.numNodes + 1;
    return newList;
  }

}
