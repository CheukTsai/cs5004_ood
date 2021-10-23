package problem2;

/**
 * Represents an abstract BagOfWords
 */
abstract class ABagOfWords implements BagOfWords {

  /**
   * {@inheritDoc}
   * Returns a new BagOfWords that contains all elements in the original BagOfWords plus {@code s}
   * @param s the word
   *
   * @return a new BagOfWords that contains all elements in the original BagOfWords plus {@code s}
   */
  @Override
  public BagOfWords add(String s) {
    return new ConsBagOfWords(s, this);
  }

  /**
   * {@inheritDoc}
   * Removes a word from the BagOfWords
   * @param s the word
   * @return a BagOfWords without the word
   */
  @Override
  public BagOfWords remove(String s) {
    return removeElement(s);
  }

  /**
   * Removes a word from the BagOfWords
   * @param s the word
   * @return a BagOfWords without the word
   */
  protected abstract ABagOfWords removeElement(String s);
}
