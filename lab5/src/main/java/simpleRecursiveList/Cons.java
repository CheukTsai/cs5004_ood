package simpleRecursiveList;

/**
 * Represents a non-empty list of integers
 *
 */
public class Cons implements List {
    private final Integer first;
    private final List rest;
    private static final Integer HASH_CODE = 31;

    /**
     * Given an integer and a list create a new list with the
     * same elements as {@code rest} and with {@code first} prepended.
     *
     * @param first new element to add to the beginning of the list
     * @param rest the list we are going to use to add our new element
     */
    public Cons(Integer first, List rest) {
        this.first = first;
        this.rest = rest;
    }

    /**
     * Getter for property 'first'.
     *
     * @return Value for property 'first'.
     */
    public Integer getFirst() {
        return first;
    }

    /**
     * Getter for property 'rest'.
     *
     * @return Value for property 'rest'.
     */
    public List getRest() {
        return rest;
    }

    /**
     * {@inheritDoc}
     * Returns the size of the List
     *
     * @return the size of the List
     */
    @Override
    public Integer size() {
        return 1 + this.getRest().size(); }

    /**
     * {@inheritDoc}
     * Checks whether the List is empty
     *
     * @return Boolean
     */
    @Override
    public Boolean isEmpty() {
        return false;
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
     * {@inheritDoc}
     * Returns the last Integer in the List
     *
     * @return the last Integer in the List
     */
    @Override
    public Integer last() {
        if (this.rest.isEmpty()) {
            return this.first;
        } else {
            return this.rest.last();
        }
    }

    /**
     * {@inheritDoc}
     * Returns true if element is in the list and false otherwise
     *
     * @param number number to be checked
     * @return Boolean
     */
    @Override
    public Boolean contains(Integer number) {
        if(this.first.equals(number))
            return true;
        else return this.rest.contains(number);
    }

    /**
     * {@inheritDoc}
     * Returns the element found at index in the list. If an index provided is outside
     * the bounds of the list, the method throws exception.
     *
     * @param index the index of the element
     * @return the element found at given index
     */
    @Override
    public Integer elementAt(Integer index) throws InvalidCallException{
        if(index < 0 || index >= this.size())
            throw new InvalidCallException("Index out of bounds!");
        else if(index == 0)
            return this.first;
        else return this.rest.elementAt(index - 1);
    }

    /**
     * {@inheritDoc}
     * Returns the sum of all elements in the List
     *
     * @return the sum of all elements in the List
     */
    @Override
    public Integer sum() {
        return this.first + this.rest.sum();
    }

    /**
     * {@inheritDoc}
     * Returns a new List with a given element is removed from the original List
     *
     * @param value the element to be removed
     * @return a new List with a given element is removed from the original List
     */
    @Override
    public List remove(Integer value) {
        if(!this.contains(value)) return this;
        else if(!this.first.equals(value))
            return new Cons(this.first, this.rest.remove(value));
        else return this.rest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cons cons = (Cons) o;

        if (getFirst() != null ? !getFirst().equals(cons.getFirst()) : cons.getFirst() != null)
            return false;
        return getRest() != null ? getRest().equals(cons.getRest()) : cons.getRest() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirst() != null ? getFirst().hashCode() : 0;
        result = HASH_CODE * result + (getRest() != null ? getRest().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cons{"
            + "first=" + first
            + ", rest=" + rest
            + '}';
    }


}
