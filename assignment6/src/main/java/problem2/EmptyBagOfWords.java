package problem2;

/**
 * Represents a concrete empty BagOfWords
 */
class EmptyBagOfWords extends ABagOfWords{

  private static final Integer HASH_CODE = 41;

  /**
   * {@inheritDoc}
   * Checks if the BagOfWords is empty. Returns true if the BagOfWords
   * contains no items, false otherwise.
   *
   * @return true if the BagOfWords contains no items, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * {@inheritDoc}
   * Returns the number of elements in the BagOfWords, duplicates should be
   * counted as separate elements
   *
   * @return the number of elements in the BagOfWords
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * {@inheritDoc}
   * Returns a new BagOfWords that contains all elements in the original BagOfWords plus {@code s}
   *
   * @return a new BagOfWords that contains all elements in the original BagOfWords plus {@code s}
   */
  @Override
  public Boolean contains(String s) {
    return false;
  }

  /**
   * {@inheritDoc}
   * Removes a word from the BagOfWords
   * @param s the word
   * @return a BagOfWords without the word
   */
  @Override
  protected ABagOfWords removeElement(String s) {
    return this;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * BagOfWords
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if(!(o instanceof EmptyBagOfWords)) return false;

    return true;
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode(){
    return HASH_CODE;
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "{ }";
  }
}
