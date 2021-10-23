package simpleRecursiveList;

/**
 * Represents an empty list of integers
 */

public class Empty implements List {

    private static final Integer HASH_CODE = 42;
    /**
     * {@inheritDoc}
     * Returns the size of the List
     *
     * @return the size of the List
     */
    @Override
    public Integer size() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * Checks whether the List is empty
     *
     * @return Boolean
     */
    @Override
    public Boolean isEmpty() {
        return true;
    }

    /**
     * {@inheritDoc}
     * Returns List after new element is added to the original list
     *
     * @param element new element to add to the list
     * @return new List with the element
     */
    @Override
    public List add(Integer element) {

        return new Cons(element, this);
    }

    /**
     * Returns the last Integer in the List
     *
     * @return the last Integer in the List
     * @throws InvalidCallException thrown when checking on an empty List
     */
    @Override
    public Integer last() throws InvalidCallException {
        throw new InvalidCallException("Called last() on empty!");
    }

    /**
     * {@inheritDoc}
     * Returns true if element is in the list and false otherwise
     *
     * @param number number to be checked
     * @return Boolean
     */
    @Override
    public Boolean contains(Integer number){return false;}

    /**
     * Returns the element found at index in the list. If an index provided is outside
     * the bounds of the list, the method throws exception.
     *
     * @param index - the index of element to find
     * @throws InvalidCallException - thrown when an index provided is outside
     * the bounds of the list
     * @return the element found at index in the list
     */
    @Override
    public Integer elementAt(Integer index) throws InvalidCallException{
        throw new InvalidCallException("Called elementAt() on empty list.");
    }

    /**
     * {@inheritDoc}
     * Returns the sum of all elements in the List
     *
     * @return the sum of all elements in the List
     */
    @Override
    public Integer sum() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * Returns a new List with a given element is removed from the original List
     *
     * @param value the element to be removed
     * @return a new List with a given element is removed from the original List
     */
    @Override
    public List remove(Integer value) throws InvalidCallException{
        throw new InvalidCallException("Called elementAt() on empty list.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return HASH_CODE;
    }

    @Override
    public String toString() {
        return "Empty{}";
    }


}
