package simpleRecursiveList;

/**
 * Represents a List of Integers
 */
public interface List {

    /**
     * Returns the total number of elements in the list.
     *
     * @return number of elements in this list
     */
    Integer size();


    /**
     * Returns true if empty and false otherwise
     *
     */
    Boolean isEmpty();

    /**
     * Given a new element {@code element} prepend it to this list
     *
     * @param element new element to add to the list
     * @return updated list with {@code element} prepends
     */
    List add(Integer element);


    /**
     * Return the last element of this list.
     *
     * @return the last element of this list.
     */
    Integer last();

    /**
     * returns true if element is in the list and false otherwise
     * @param number number to find
     * @return Boolean
     */
    Boolean contains(Integer number);

    /**
     * Returns the element found at index in the list. If an index provided is outside
     * the bounds of the list, the method throws exception.
     * @param index index of element to find
     * @return Integer;
     */
    Integer elementAt(Integer index);

    Integer sum();

    List remove(Integer value);
}
