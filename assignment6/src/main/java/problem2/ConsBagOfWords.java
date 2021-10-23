package problem2;

/**
 * Represents a concrete non-empty BagOfWords
 */
class ConsBagOfWords extends ABagOfWords{

  private String head;
  private BagOfWords rest;

  private static final Integer HASH_CODE = 31;
  private static final Integer ONE = 1;

  /**
   * Constructs a ConsBagOfWords, with {@code wordsCollection} set to null
   */
  public ConsBagOfWords(String head, BagOfWords rest) {
    this.head = head;
    this.rest = rest;
  }

  /**
   * Checks if the BagOfWords is empty. Returns true if the BagOfWords
   * contains no items, false otherwise.
   *
   * @return true if the BagOfWords contains no items, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return false;
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
    return 1 + this.rest.size();
  }


  /**
   * {@inheritDoc}
   * Checks if {@code s} is in the BagOfWords
   *
   * @param s a String to be checked
   * @return Returns true if the BagOfWords contains {@code s} and false otherwise.
   */
  @Override
  public Boolean contains(String s) {
    if(this.head.equals(s)) return true;
    return this.rest.contains(s);
  }

  /**
   * {@inheritDoc}
   * Removes a word from the BagOfWords
   * @param s the word
   * @return a BagOfWords without the word
   */
  @Override
  protected ABagOfWords removeElement(String s) {
    if(this.head.equals(s)) return (ABagOfWords) this.rest;
    return new ConsBagOfWords(this.head, ((ABagOfWords) this.rest).removeElement(s));
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
    if(!(o instanceof ConsBagOfWords)) return false;

    final ConsBagOfWords that = (ConsBagOfWords) o;
    if(!this.size().equals(that.size())) return false;
    if(!that.contains(this.head)) return false;

    return this.rest.equals(that.removeElement(this.head));
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
    result = (prime * result) + ((this.head == null) ? 0 : this.head.hashCode());
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
    return "ConsBagOfWords{" +
        "head='" + head + '\'' +
        ", rest=" + rest +
        '}';
  }
}
